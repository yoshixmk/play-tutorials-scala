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

// == Type Lambdas ==
// 書換 type T = [X] =>> (X, X)
type T[X] = (X, X)

// == Match Types ==
// 型パラメータを使って、一致させる。別の型に変換する処理まとまりそう
type Elem[X] = X match {
  case String => Char
  case Array[t] => t
  case Iterable[t] => t
}

