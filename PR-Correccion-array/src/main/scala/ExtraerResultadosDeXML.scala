

object ExtraerResultadosDeXML extends App{

	import scala.collection._
	import java.util.Scanner
	import scala.sys.process._

	
	def execute = {
		Seq( "grep", "-r", "testsuite name" ) lines
	}


	case class ResultLine( student: String, test: String, totalTests: Int, failures : Int )

	class Student( name: String ){
		val results = mutable.Map[String,(Int,Int)]()
		override def toString = name + "\t" + { for( (k,v) <- results ) yield k + "\t" + v._1 + "\t" + v._2 + "\t" }.mkString
	}

	val regex = """(.*)TEST-.*name=(.*)tests="(\d+)".*failures="(\d+)".*""".r

	def lineToResult( line: String ) = line match{
		case regex(student,test,totalTests,failures) => ResultLine(student,test,totalTests.toInt,failures.toInt)
		case _ => ResultLine("","",0,0)
	}

	val lines = execute.toList

	println( "**************************" )
	println( lines.mkString("\n") )

	val results = lines.map( lineToResult )
	println( "**************************" )
	println( results.mkString("\n") )

	val resultsByStudent = mutable.Map[String,Student]()
	
	for( result <- results ){
		val student = resultsByStudent.getOrElseUpdate( result.student, new Student(result.student) )
		student.results(result.test) = (result.totalTests, result.failures)
	}

	println( resultsByStudent.values.mkString("\n") )

}
