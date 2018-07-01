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

  case object Coffee extends Item with Hot{
    def price = 1.0
    def name="Coffee"
  }

  case object CheeseSandwich extends Item with Food{
    def price = 2.0
    def name="Cheese Sandwich"
  }

  case object SteakSandwich extends Item with Food with Hot{
    def price = 4.5
    def name="Steak Sandwich"
  }

  trait Food

  trait Hot


  trait ServiceCharge10 extends Menu{
    override def charge = if(items.exists(_.isInstanceOf[Food])) math.max(super.charge, price * 0.1) else super.charge
  }

  trait ServiceCharge20 extends Menu{
    override def charge = if(items.exists(i => i.isInstanceOf[Food] && i.isInstanceOf[Hot])) math.max(super.charge, math.min(2.0,price * 0.2)) else super.charge
  }

  class Menu(val items : List[Item]){

    def price = items.map(_.price).sum

    def total = price + round(charge)

    def charge = 0.0

    override def equals(that:Any) = that match {
      case m : Menu => items.equals(m.items)
      case _ => false
    }

    override def hashCode() = items.hashCode

    override def toString = items.mkString

  }

  def apply(xs : List[String]):Menu =  new Menu(xs.map((s:String) => Item(s)).flatten) with ServiceCharge10 with ServiceCharge20

  def apply(xs : String*):Menu =  apply(xs.toList)

  def round(d:Double):Double = math.BigDecimal(d).setScale(2, math.BigDecimal.RoundingMode.HALF_DOWN).doubleValue
}
