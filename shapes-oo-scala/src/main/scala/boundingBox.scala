package edu.luc.cs.laufer.cs371.shapes

// TODO: implement this behavior
//Section 5.3, 6.3
import Shape.*
import scala.math

object boundingBox:
  def apply(s: Shape): Location = s match
    //Location was not specified
    case Rectangle(width, height) => Location(0, 0, Rectangle(width, height))
    case Ellipse(x, y) => Location(-x, -y, Rectangle(x * 2, y * 2))

    //Location is specified
    case Location(x, y, shape) => 
        val Location(u, v, Rectangle(width, height)) = boundingBox(shape): @unchecked
        Location(x + u, y + v, Rectangle(width, height))

    case Group(shapes*) => 
        val list = shapes.map(shape => boundingBox(shape))

        val x_min = list.map{case Location(x, _, _) => x}.min
        val x_max = list.map{case Location(x, _, Rectangle(width, _)) => x + width}.max

        val y_min = list.map{case Location(_, y, _) => y}.min
        val y_max = list.map{case Location(_, y, Rectangle(_, height)) => y + height}.max
	
        Location(x_min, y_min, Rectangle(x_max - x_min, y_max - y_min))
end boundingBox
