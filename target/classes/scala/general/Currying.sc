package scala.general

/**
http://www.codecommit.com/blog/scala/function-currying-in-scala

**/
object Currying {

	  def add(x:Int, y:Int) = x + y           //> add: (x: Int, y: Int)Int
  	add(3,4)                                  //> res0: Int = 7
		add(1, 2)                         //> res1: Int = 3
		
		def f = (y:Int) => y + 3          //> f: => Int => Int
		
		def addWithCurrying(x:Int) = ((y:Int) => x + y)
                                                  //> addWithCurrying: (x: Int)Int => Int
		addWithCurrying(1)                //> res2: Int => Int = <function1>
		addWithCurrying(7)(3)             //> res3: Int = 10
		f(4)                              //> res4: Int = 7
}