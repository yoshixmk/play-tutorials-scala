object Main {

  def main(args: Array[String]): Unit = {
    println("Hello world!")
    println(msg)
  }

  def msg = "I was compiled by dotty :)"

}

// == Intersection Types ==
trait Resettable {
  def reset(): this.type
}
trait Growable[T] {
  def add(x: T): this.type
}
// 2つの型を持っていれば、エラーにならない
def f(x: Resettable & Growable[String]) = {
  x.reset()
  x.add("first")
}

trait A {
  def children: List[A]
}
trait B {
  def children: List[B]
}
class C extends A with B {
  def children: List[A & B] = ???
}

val x: A & B = new C
val xChildren: List[A & B] = x.children
// これはできない
// val yChildren: List[C] = y.children

// == Union Types ==
case class UserName(name: String)
case class Password(hash: String)

def help(id: UserName | Password) = {
  val user = id match {
    case UserName(name) => name // lookupName(name)
    case Password(hash) => hash // lookupPassword(hash)
  }
}
