package encoder

import java.util

import org.apache.spark.SparkConf
import org.apache.spark.serializer.KryoSerializer
import org.apache.spark.sql.SparkSession
import referential.store.v2.{ Store, WeekPattern }

import scala.collection.JavaConverters._

object Encoders {

  implicit def storeEncoder: org.apache.spark.sql.Encoder[Store] = org.apache.spark.sql.Encoders.kryo[Store]
}
object EncoderApp extends App {

  val sparkConf: SparkConf = new SparkConf()
    .setMaster("local[2]")
    .setAppName("Test Encoder")
    .set("spark.serializer", classOf[KryoSerializer].getName)
    .set("spark.hadoop.validateOutputSpecs", "true")

  implicit val sparkSession: SparkSession = SparkSession.builder().config(sparkConf).getOrCreate()
  implicit val sc = sparkSession.sparkContext

  import Encoders._
  import sparkSession.implicits._

  val weekPattern = WeekPattern.newBuilder().setBegDate("begDate").build()
  val weekPatterns = new util.ArrayList[WeekPattern]()
  weekPatterns.add(weekPattern)
  val store = Store.newBuilder()
    .setAclGesKey("AclGesKey")
    .setOpeningWeekPattern(weekPatterns)
    .build()
  val df = Seq(store).toDF()
  df.show()
  val ds = df.as[Store]

  ds.foreach { store ⇒
    println(store.getAclGesKey)
    store.getOpeningWeekPattern.asScala.foreach(println)
  }
  ds.collect().foreach { store ⇒ println("######"); println(store.getOpeningWeekPattern) }
  sc.stop()

  sc.stop()

}
