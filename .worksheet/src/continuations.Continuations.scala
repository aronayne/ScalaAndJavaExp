package continuations

object Continuations {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(109); 

	def plus [A] (x: Int, y : Int, k: Int => A): A =
		k(x + y);System.out.println("""plus: [A](x: Int, y: Int, k: Int => A)A""");$skip(62); 
		
	def times[A] (x: Int, y: Int, k: Int => A): A =
		k(x*y);System.out.println("""times: [A](x: Int, y: Int, k: Int => A)A""");$skip(83); 
		
	def less [A] (x: Int, y: Int, kt: => A, kf: => A): A =
		if(x < y) kt else kf;System.out.println("""less: [A](x: Int, y: Int, kt: => A, kf: => A)A""");$skip(151); 

	def factorial [A] (n : Int, k : Int => A) : A =
		less(n , 2 , k(1),
			plus(n , -1 , (m: Int) =>
				factorial(m, (f: Int) =>
					times(n,f,k))));System.out.println("""factorial: [A](n: Int, k: Int => A)A""");$skip(17); 
		println(3 + 4);$skip(23); 
    plus(3,4, println);$skip(47); 
    
    less(3 , 2, println(3) , println(2));$skip(31); 
    
		factorial(5 , println);$skip(38); 
		factorial(3, factorial(_, println));$skip(34); 
    val n = factorial(3 , r => r);System.out.println("""n  : Int = """ + $show(n ))}
}
