package variance

/**
* Based on 
*
* http://oldfashionedsoftware.com/2008/08/26/variance-basics-in-java-and-scala/
 **/

object ScalaVariance {

  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  class InVar[T]     { override def toString = "InVar" }
	class CoVar[+T]     { override def toString = "CoVar" }
	class ContraVar[-T] { override def toString = "ContraVar" }
	
	/************ Regular Assignment ************/
	
	val test1: InVar[String] = new InVar[String]
                                                  //> test1  : variance.ScalaVariance.InVar[String] = InVar
	val test2: CoVar[String] = new CoVar[String]
                                                  //> test2  : variance.ScalaVariance.CoVar[String] = CoVar
	val test3: ContraVar[String] = new ContraVar[String]
                                                  //> test3  : variance.ScalaVariance.ContraVar[String] = ContraVar
  val test1: InVar[String] = new InVar[AnyRef]
	
}