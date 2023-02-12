package CoffeeMaker

class CoffeeMaker() {
    val CoffeeCapacity: Int = 50
    val WaterCapacity: Int = 150
    var CoffeeAmount:Int =0
        private set
    var WaterAmount:Int =0
        private set
    var isOn: Boolean = false


    fun makeDoubleEspresso(){
        if (isOn == true && CoffeeAmount >= 16 && WaterAmount >= 30) {
            CoffeeAmount = CoffeeAmount-16
            WaterAmount = WaterAmount-30
            println("made coffee with 16 - 30")
        }
    }

    fun makeRegular(){
        if (isOn == true && CoffeeAmount >= 10 && WaterAmount >= 120) {
            CoffeeAmount = CoffeeAmount-10
            WaterAmount = WaterAmount-120
            println("made coffee with 10 - 120")
        }
    }

    fun fillAll(){
        CoffeeAmount = CoffeeCapacity
        WaterAmount = WaterCapacity
    }

    override fun toString(): String {
        if (isOn == true) {
            return "coffeemaker is on with $CoffeeAmount coffee and $WaterAmount water"
        } else {
            return "coffeemaker is off with $CoffeeAmount coffee and $WaterAmount water"
        }

    }

}