/*
Create a CoffeeMaker class. The class has properties coffeeCapacity and waterCapacity which can be given values when constructing an instance of CoffeeMaker. These properties never change during the existence of a CoffeeMaker instance. If no values are given, default values 50 and 150 should be used.

CoffeeMaker has also three properties whose values may change during the lifetime of the CoffeeMaker instance: coffeeAmount, waterAmount, and isOn. It should be possible to read and assign the value of isOn outside the class, but coffeeAmount and waterAmount can only be read from outside.

CoffeeMaker should have three methods: makeDoubleEspresso which uses 16 units of coffee and 30 units of water, makeRegular which uses 10 units of coffee and 120 units of water, and fillAll that tops up the coffee and water amounts to their maximums. If the amount of coffee and water is not enough for an espresso or regular coffee, the make-methods should not change the state of the coffee machine at all. Consider using a private method to avoid duplicating code and remember to take into account whether the maker is on or not. Also, override toString method and make it output the CoffeeMaker state like in the example below.

Try to use a Kotlinish way of implementing the coffee maker. Should you get stuck with that, it is ok to write in more Java style.
*/
package CoffeeMaker

fun main() {
    val cm = CoffeeMaker()
    println(cm)
    cm.makeRegular()
    println(cm)
    cm.isOn = true
    println(cm)
    cm.makeRegular()
    println(cm)
    cm.fillAll()
    println(cm)
    cm.makeRegular()
    println(cm)
    cm.makeDoubleEspresso()
    println(cm)
    cm.makeDoubleEspresso()
    println(cm)
}