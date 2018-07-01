package com.capgemini

/**
 * @author ${user.name}
 */
object Menu {

  abstract class Item{
    
    def price : Double
    
    def name : String
    
    override def toString() = name

  }

  object Item{
    
    def apply(s:String):Option[Item] = apply(s,List(Cola, Coffee, CheeseSandwich, SteakSandwich))
    
    def apply(s:String, all : List[Item]):Option[Item] = all.find(_.name == s)

  }

  case object Cola extends Item{
    def price = 0.5
    def name="Cola"
  }

  case object Coffee extends Item{
    def price = 1.0
    def name="Coffee"
  }

  case object CheeseSandwich extends Item{
    def price = 2.0
    def name="Cheese Sandwich"
  }

  case object SteakSandwich extends Item{
    def price = 4.5
    def name="Steak Sandwich"
  }

  class Menu(val items : List[Item]){

    def price = items.map(_.price).sum

    override def equals(that:Any) = that match {
      case m : Menu => items.equals(m.items)
      case _ => false
    }

    override def hashCode() = items.hashCode

    override def toString = items.mkString

  }

  def apply(xs : List[String]):Menu =  new Menu(xs.map((s:String) => Item(s)).flatten)

  def apply(xs : String*):Menu =  apply(xs.toList)

}
