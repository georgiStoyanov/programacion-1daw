

object ExtraerResultadosDeXML extends App{

	import scala.collection._
	import java.util.Scanner
	import scala.sys.process._

	
	def execute = {
		Seq( "grep", "-r", "testsuite name" ) lines
	}


	case class ResultLine( student: String, test: String, totalTests: Int, failures : Int ){
		val valid = totalTests > 0
	}

	class Student( name: String ){
		val results = mutable.Map[String,(Int,Int)]()
		override def toString = name + "\t" + { for( (k,v) <- results ) yield k + "\t" + v._1 + "\t" + v._2 + "\t" }.mkString
		def valid = results.size > 1
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

	type ResultsByStudent = mutable.Map[String,Student]

	val resultsByStudent : ResultsByStudent = mutable.Map[String,Student]()
	
	for( result <- results if result.valid ){
		val student = resultsByStudent.getOrElseUpdate( result.student, new Student(result.student) )
		student.results(result.test) = (result.totalTests, result.failures)
	}

	println( resultsByStudent.values.mkString("\n") )

	def formatCSV( results : ResultsByStudent ) = {
		val studentNames = results.keys.toArray.sorted
		val firstStudent = results.values.head
		val exercises = firstStudent.results.keys.toArray.sorted

		val headerKeys = {
			for( e <- exercises ; gb <- Seq(" total", " bad") ) yield e + gb
		}

		println( "\t" + headerKeys.mkString("\t" ) )

		for( s <- studentNames ; student = results(s) if student.valid ){
			print( s + "\t" )
			for( e <- exercises ){
				val test = student.results(e)
				print( test._1 + "\t" + test._2 + "\t" ) 								
			}
			println("")
		}
	}

	println( "\n" * 5 )		
	formatCSV( resultsByStudent )
}
