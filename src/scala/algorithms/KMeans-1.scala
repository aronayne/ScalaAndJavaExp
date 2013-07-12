package scala.algorithms

/**
 * MOdified from http://garysieling.com/blog/implementing-k-means-in-scala
 * 
 */
class Point(dx: Double, dy: Double) {
  val x: Double = dx
  val y: Double = dy
 
  override def toString(): String = {
    "(" + x + ", " + y + ")"
  }
 
  def dist(p: Point): Double = {
    return x * p.x + y * p.y
  }
}
 
object kmeans extends App {
  val k: Int = 2
 
  // Correct answers to centers are (10, 20) and (25, 5)
  val points: List[Point] = List(
    new Point(0, 1),
    new Point(0, 1)).sortBy(
      p => (p.x + " " + p.y).hashCode())
 
  def clusterMean(points: List[Point]): Point = {
    val cumulative = points.reduceLeft((a: Point, b: Point) => new Point(a.x + b.x, a.y + b.y))
 
    return new Point(cumulative.x / points.length, cumulative.y / points.length)
  }
 
  def render(points: Map[Int, List[Point]]) {
    for (clusterNumber <- points.keys.toSeq.sorted) {
      System.out.println("  Cluster " + clusterNumber)
 
      val meanPoint = clusterMean(points(clusterNumber))
      System.out.println("  Mean: " + meanPoint)
 
      for (j <- 0 to points(clusterNumber).length - 1) {
        System.out.println("    " + points(clusterNumber)(j) + ")")
      }
 
      System.out.println("")
    }
  }
 
  val clusters =
    points.zipWithIndex.groupBy(
      x => x._2 % k) transform (
        (i: Int, p: List[(Point, Int)]) => for (x <- p) yield x._1)
 
  System.out.println("Initial State: ")
  render(clusters)
 
  def iterate(clusters: Map[Int, List[Point]]): Map[Int, List[Point]] = {
    val unzippedClusters =
      (clusters: Iterator[(Point, Int)]) => clusters.map(cluster => cluster._1)
 
    // find cluster means
    val means =
      (clusters: Map[Int, List[Point]]) =>
        for (clusterIndex <- clusters.keys)
          yield clusterMean(clusters(clusterIndex))
 
    // find the closest index
    def closest(p: Point, means: Iterable[Point]): Int = {
      val distances = for (center <- means) yield p.dist(center)
      return distances.zipWithIndex.min._2
    }
 
    // assignment step
    val newClusters =
      points.groupBy(
        (p: Point) => closest(p, means(clusters)))
 
    render(newClusters)
 
    return newClusters
  }
 
  var clusterToTest = clusters
  for (i <- 0 to 5) {
    System.out.println("Iteration: " + i)
    clusterToTest = iterate(clusterToTest)
  }
}