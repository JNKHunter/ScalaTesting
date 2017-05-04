def sum(f: Int => Int): (Int, Int) => Int = {
  def sumF(a: Int, b: Int): Int =
    if (a > b) 0
    else f(a) + sumF(a + 1, b)
  sumF
}

def sum2(f: Int => Int)(a: Int, b: Int): Int =
  if (a > b) 0 else f(a) + sum(f)(a + 1, b)

def sumInts = sum(x => x)
def sumCubes = sum(x => x * x * x)

sumInts(1,3)

def cube(x:Int) = x * x * x
sum(cube)(1,10)

sum2(cube)(1,10)