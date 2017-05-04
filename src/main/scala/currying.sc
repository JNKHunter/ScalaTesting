def sum(f: Int => Int): (Int, Int) => Int = {
  def sumF(a: Int, b: Int): Int =
    if (a > b) 0
    else f(a) + sumF(a + 1, b)
  sumF
}

def sumInts = sum(x => x)
def sumCubes = sum(x => x * x * x)

sumInts(1,3)