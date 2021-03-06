object exercise {
  def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0
      else f(a) + sumF(a + 1, b)
    sumF
  }

  def sum2(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sum2(f)(a + 1, b)

  def sumInts = sum(x => x)
  def sumCubes = sum(x => x * x * x)

  sumInts(1,3)

  def cube(x:Int):Int = x * x * x
  sum(cube)(1,10)


  def product(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 1 else f(a) * product(f)(a + 1, b)

  product(x => x)(1,4)

  def fact(n: Int) = product(x => x)(1,n)
  fact(5)

  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zeroVal: Int)(a: Int, b: Int): Int =
    if (a > b) zeroVal
    else combine(f(a), mapReduce(f, combine, zeroVal)(a+1, b))

  def productMR(f: Int => Int)(a: Int, b: Int):Int = mapReduce(f, (x,y) => x * y, 1)(a,b)
  productMR(x => x * x)(3,4)

  
}


