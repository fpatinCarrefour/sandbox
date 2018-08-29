
import com.typesafe.config.{ Config, ConfigFactory }
import org.apache.spark.SparkConf
import org.scalactic._
import Accumulation._
import scala.util.{ Failure, Success, Try }

val ok = ConfigFactory.parseString(
  """
    |phenix {
    |  hadoop.hdfs.rootPath.base: "/phenix"
    |  hadoop.hdfs.rootPath.rawData : "/Raw_Data"
    |  hadoop.hdfs.rootPath.computedData: "/Cmp_Data"
    |
    |  view {
    |    format: "orc"
    |
    |    options {
    |      "compression": "zlib",
    |      "orc.bloom.filter.columns": ""
    |    }
    |
    |    path: ${phenix.hadoop.hdfs.rootPath.base}"/views/sales/sales_day"
    |
    |    partitionColumns: ["chainTypeOpKey", "dateKey"]
    |    rePartitioningColumn: "chainTypeOpKey:1"
    |
    |    hiveTable: "sales.sales_day_orc"
    |
    |    purge {
    |      depth: 30
    |      retention: 3
    |    }
    |  }
    |
    |  jobConfiguration {
    |    src: [
    |      {
    |        input: ${phenix.hadoop.hdfs.rootPath.rawData}"Sqoop_Extraction/Sales/DAY/CAR/"
    |        chaintype: "HYP"
    |      },
    |      {
    |        input: ${phenix.hadoop.hdfs.rootPath.rawData}"Sqoop_Extraction/Sales/DAY/CHA/"
    |        chaintype: "SUP"
    |      },
    |      {
    |        input: ${phenix.hadoop.hdfs.rootPath.rawData}"Sqoop_Extraction/Sales/DAY/PMC/"
    |        chaintype: "PMC"
    |      }
    |    ]
    |    inputsDirectory {
    |      referentialBaseDir: ${phenix.hadoop.hdfs.rootPath.computedData}"Referential/"
    |    }
    |
    |    referential {
    |      inputStore: ${phenix.jobConfiguration.inputsDirectory.referentialBaseDir}"referential.store.validationGtZero.Store/"
    |    }
    |
    |    nbPartitions: 10
    |    computedTag: "user.computed"
    |    uselessValue: 1
    |  }
    |

    |
    |}
  """.stripMargin).resolve()

val ko = ConfigFactory.parseString(
  """
    |phenix {
    |  hadoop.hdfs.rootPath.base: "/phenix"
    |  hadoop.hdfs.rootPath.rawData : "/Raw_Data"
    |  hadoop.hdfs.rootPath.computedData: "/Cmp_Data"
    |
    |  view {
    |    format: "orc"
    |
    |    options {
    |      "compression": "zlib",
    |      "orc.bloom.filter.columns": ""
    |    }
    |
    |    path: ${phenix.hadoop.hdfs.rootPath.base}"/views/sales/sales_day"
    |
    |    partitionColumns: ["chainTypeOpKey", "dateKey"]
    |    rePartitioningColumn: "chainTypeOpKey:1"
    |
    |    hiveTable: "sales.sales_day_orc"
    |
    |    purge {
    |      depth: 30
    |      retention: 3
    |    }
    |  }
    |
    |  jobConfiguration {
    |    src: [
    |      {
    |        input: ${phenix.hadoop.hdfs.rootPath.rawData}"Sqoop_Extraction/Sales/DAY/CAR/"
    |        chaintype: "HYP"
    |      },
    |      {
    |        input: ${phenix.hadoop.hdfs.rootPath.rawData}"Sqoop_Extraction/Sales/DAY/CHA/"
    |        chaintype: "SUP"
    |      },
    |      {
    |        input: ${phenix.hadoop.hdfs.rootPath.rawData}"Sqoop_Extraction/Sales/DAY/PMC/"
    |        chaintype: "PMC"
    |      }
    |    ]
    |    inputsDirectory {
    |      referentialBaseDir: ${phenix.hadoop.hdfs.rootPath.computedData}"Referential/"
    |    }
    |
    |    referential {
    |      inputStore: ${phenix.jobConfiguration.inputsDirectory.referentialBaseDir}"referential.store.validationGtZero.Store/"
    |    }
    |
    |    nbPartitions: 0
    |    computedTag: ""
    |    uselessValue: 1
    |  }
    |

    |
    |}
  """.stripMargin).resolve()

import com.carrefour.phenix.core.configuration.Configuration

case class Source(input: String, chaintype: String)

case class Referential(inputStore: String)

case class JobConfiguration(src: Seq[Source],
                            referential: Referential,
                            nbPartitions: Int,
                            computedTag: String)

class StandardAssortmentConfiguration(config: Config) extends Configuration(config) {

  import StandardAssortmentConfiguration._

  private val phenixConfiguration = config.getConfig("phenix")

  import net.ceedubs.ficus.Ficus._
  import net.ceedubs.ficus.readers.ArbitraryTypeReader._

  val jobConfig: JobConfiguration = phenixConfiguration.as[JobConfiguration]("jobConfiguration")

  val sparkConf: SparkConf = new SparkConf()
    .setAppName("Warehouse Deliveries recovery from Mandala")
    .set("spark.hadoop.validateOutputSpecs", "true")
    .setAll(phenixConfiguration.as[Option[Config]]("sparkConf")
      .map(f ⇒ new Configuration(f).asMap()).getOrElse(Map.empty))

  def validate(): Unit = {
    if (!srcNonEmpty0(jobConfig)) {
      throw new Exception("srcNonEmpty failed")
    } else if (!nbPartitionGtZero0(jobConfig)) {
      throw new Exception("nbPartitionGtZero0 failed")
    } else if (!computedTagNotEmpty0(jobConfig)) {
      throw new Exception("computedTagNotEmpty failed")
    }
  }
}

object StandardAssortmentConfiguration {
  def apply(config: Config) = new StandardAssortmentConfiguration(config)

  def load0(config: Config): StandardAssortmentConfiguration = {
    val c = new StandardAssortmentConfiguration(config)
    Try(c.validate()) match {
      case Success(_) ⇒ c
      case Failure(e) ⇒ throw e
    }
  }

  def srcNonEmpty0(jc: JobConfiguration): Boolean = jc.src.nonEmpty

  def nbPartitionGtZero0(jc: JobConfiguration): Boolean = jc.nbPartitions > 0

  def computedTagNotEmpty0(jc: JobConfiguration): Boolean = jc.computedTag.trim.nonEmpty

  def srcNonEmpty1(jc: JobConfiguration): JobConfiguration Or One[ErrorMessage] = {
    if (jc.src.nonEmpty) Good(jc).orBad[One[ErrorMessage]] else Good[JobConfiguration].orBad(One("src must not be empty"))
  }

  def nbPartitionGtZero1(jc: JobConfiguration): JobConfiguration Or One[ErrorMessage] = {
    if (jc.nbPartitions > 0) Good(jc).orBad[One[ErrorMessage]] else Good[JobConfiguration].orBad(One("nb partition should be > 0"))
  }

  def computedTagNotEmpty1(jc: JobConfiguration): JobConfiguration Or One[ErrorMessage] = {
    if (jc.computedTag.trim.nonEmpty) Good(jc).orBad[One[ErrorMessage]] else Good[JobConfiguration].orBad(One("computed Tag must not be empty"))
  }

  def load1(config: Config): Or[StandardAssortmentConfiguration, Every[ErrorMessage]] = {
    val standardAssortmentConfiguration = new StandardAssortmentConfiguration(config)
    val jc = standardAssortmentConfiguration.jobConfig
    withGood(
      srcNonEmpty1(jc),
      nbPartitionGtZero1(jc),
      computedTagNotEmpty1(jc)
    ) { case (_, _, _) ⇒ standardAssortmentConfiguration }
  }

}

val standardAssortmentConfigurationOk = new StandardAssortmentConfiguration(ok)
standardAssortmentConfigurationOk.validate()
val jobConfig = standardAssortmentConfigurationOk.jobConfig
val sparkConfig = standardAssortmentConfigurationOk.sparkConf

val standardAssortmentConfigurationKo = StandardAssortmentConfiguration(ko)
Try(standardAssortmentConfigurationKo.validate())

println(Try(StandardAssortmentConfiguration.load0(ok)))
println(Try(StandardAssortmentConfiguration.load0(ko)))
println("############")

println(StandardAssortmentConfiguration.load1(ok))
println(StandardAssortmentConfiguration.load1(ko))

