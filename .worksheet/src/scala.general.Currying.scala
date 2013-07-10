package scala.general

/**
http://www.codecommit.com/blog/scala/function-currying-in-scala

**/
object Currying {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(147); 

	  def add(x:Int, y:Int) = x + y;System.out.println("""add: (x: Int, y: Int)Int""");$skip(12); val res$0 = 
  	add(3,4);System.out.println("""res0: Int = """ + $show(res$0));$skip(12); val res$1 = 
		add(1, 2);System.out.println("""res1: Int = """ + $show(res$1));$skip(30); 
		
		def f = (y:Int) => y + 3;System.out.println("""f: => Int => Int""");$skip(53); 
		
		def addWithCurrying(x:Int) = ((y:Int) => x + y);System.out.println("""addWithCurrying: (x: Int)Int => Int""");$skip(21); val res$2 = 
		addWithCurrying(1);System.out.println("""res2: Int => Int = """ + $show(res$2));$skip(24); val res$3 = 
		addWithCurrying(7)(3);System.out.println("""res3: Int = """ + $show(res$3));$skip(7); val res$4 = 
		f(4);System.out.println("""res4: Int = """ + $show(res$4))}
}
