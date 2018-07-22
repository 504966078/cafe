package com.github.cafe

import org.junit._
import Assert._

@Test
class MenuTest {


    @Test
    def noItems() = assertEquals(0.0, Menu().price, 0)

    @Test
    def noItemsNoSpecitication() = assertEquals(Menu(), Menu("no such name"))

    @Test
    def priceOnCola() = assertEquals(0.5, Menu("Cola").price, 0)


    @Test
    def priceOnThreeItems() = assertEquals(3.5, Menu("Cola","Coffee","Cheese Sandwich").price, 0)

    @Test
    def priceOnThreeLabels() = assertEquals(3.5, Menu("Cola", "Coffee", "Cheese Sandwich").price, 0)


//step2


    @Test
    def priceOnCoffee() = assertEquals(1.0, Menu("Coffee").price, 0)


    @Test
    def priceOnDrinks() = assertEquals(1.5, Menu("Coffee","Cola").total, 0)


    @Test
    def serviceChargeOnFood_Add10() = assertEquals(2.0 + 0.2, Menu("Cheese Sandwich").total,0)

    @Test
    def priceMenuIncludesFood_Add10() = assertEquals((2.0 + 0.5) + 0.25, Menu("Cheese Sandwich","Cola").total, 0)

    @Test
    def serviceChargeOnHotFood_Add20and10() = assertEquals(4.5 + (0.9 + 0.45), Menu("Steak Sandwich").total,0)

    @Test
    def serviceChargeOnThreeHotFood_Add10andMax() = assertEquals(13.5 + (1.35 + 2.0), Menu(List.fill(3)("Steak Sandwich")).total,0)


    @Test
    def priceRoundingDown(){
      assertEquals(1.0, Menu.round(1.004),0.0)
      assertEquals(1.0, Menu.round(1.005),0.0)
      assertEquals(1.01, Menu.round(1.006),0.0)
    }

}


