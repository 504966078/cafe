package com.capgemini

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
    def serviceChargeOnFood() = assertEquals(2.2, Menu("Cheese Sandwich").total,0)

    @Test
    def priceMenuIncludesFood() = assertEquals(2.75, Menu("Cheese Sandwich","Cola").total, 0)

    @Test
    def serviceChargeOnHotFood() = assertEquals(5.4, Menu("Steak Sandwich").total,0)

    @Test
    def serviceChargeOn1KHotFood() = assertEquals(Menu.SteakSandwich.price*1000 + 2, Menu(List.fill(1000)("Steak Sandwich")).total,0)

}


