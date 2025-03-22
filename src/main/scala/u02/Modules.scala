package u02

import u03.Sequences.Sequence
import u03.Sequences.Sequence.{Cons, Nil, filter, flatMap, foldLeft, map}

object Modules extends App:

  // An ADT: type + module
  enum Person:
    case Student(name: String, year: Int)
    case Teacher(name: String, course: String)

  object Person:
    def name(p: Person): String = p match
      case Student(n, _) => n
      case Teacher(n, _) => n

  println(Person.name(Person.Student("mario", 2015)))

  import Person.*

  println(name(Student("mario", 2015)))

  // a method outside the Person module
  def isStudent(p: Person): Boolean = p match
    case Student(_, _) => true
    case _ => false

  def getCourses(s: Sequence[Person]): Sequence[String] =
    flatMap(s)(p => p match
      case Teacher(_,c) => Cons(c, Nil())
      case _ => Nil()
      )

  def countCourses(s: Sequence[Person]): Int =
    foldLeft(getCourses(s))(0)((c, p2) => c + 1)


  println(isStudent(Student("mario", 2015)))
end Modules
