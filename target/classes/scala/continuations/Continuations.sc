package continuations

object Continuations {

	def plus [A] (x: Int, y : Int, k: Int => A): A =
		k(x + y)                          //> plus: [A](x: Int, y: Int, k: Int => A)A
		
	def times[A] (x: Int, y: Int, k: Int => A): A =
		k(x*y)                            //> times: [A](x: Int, y: Int, k: Int => A)A
		
	def less [A] (x: Int, y: Int, kt: => A, kf: => A): A =
		if(x < y) kt else kf              //> less: [A](x: Int, y: Int, kt: => A, kf: => A)A

	def factorial [A] (n : Int, k : Int => A) : A =
		less(n , 2 , k(1),
			plus(n , -1 , (m: Int) =>
				factorial(m, (f: Int) =>
					times(n,f,k))))
                                                  //> factorial: [A](n: Int, k: Int => A)A
		println(3 + 4)                    //> 7
    plus(3,4, println)                            //> 7
    
    less(3 , 2, println(3) , println(2))          //> 2
    
		factorial(5 , println)            //> 120
		factorial(3, factorial(_, println))
                                                  //> 720
    val n = factorial(3 , r => r)                 //> n  : Int = 6
}