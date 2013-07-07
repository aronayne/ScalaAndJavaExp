package variance

/**
Based on http://oldfashionedsoftware.com/2008/08/26/variance-basics-in-java-and-scala/
**/

object ScalaVariance {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(181); 

  println("Welcome to the Scala worksheet")
  
  class InVar[T]     { override def toString = "InVar" }
	class CoVar[+T]     { override def toString = "CoVar" }
	class ContraVar[-T] { override def toString = "ContraVar" };$skip(276); 
	
	/************ Regular Assignment ************/
	
	val test1: InVar[String] = new InVar[String];System.out.println("""test1  : variance.ScalaVariance.InVar[String] = """ + $show(test1 ));$skip(46); 
	val test2: CoVar[String] = new CoVar[String];System.out.println("""test2  : variance.ScalaVariance.CoVar[String] = """ + $show(test2 ));$skip(54); 
	val test3: ContraVar[String] = new ContraVar[String];System.out.println("""test3  : variance.ScalaVariance.ContraVar[String] = """ + $show(test3 ))}
	
}
