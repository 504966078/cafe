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

}


