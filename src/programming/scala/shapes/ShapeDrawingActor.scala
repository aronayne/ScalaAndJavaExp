package programming.scala.shapes

import scala.actors._
import scala.actors.Actor._
import programming.scala.shapes.theseShapes._

  object ShapeDrawingActor extends Actor {
    def act() {
      loop {
        receive {
          case s: Shape => s.draw()
          case "exit"   => println("exiting..."); exit
          case x: Any   => println("Error: Unknown message! " + x)
        }
      }
    }
  }