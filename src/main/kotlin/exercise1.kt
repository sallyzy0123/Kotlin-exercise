import java.util.*

/*

Write a program that reads numbers (integers or floating point numbers) from the console 
until the user enters “quit”. Once the user has entered “quit” the program should print out 
the smallest number, largest number, the count of numbers and the average of the numbers.

Use readLine() to read a line of input (completed with Enter) as a String. A nice way to implement
reading loop is to use do - while. Do not store the numbers in a collection, it is enough to maintain
average, count, min and max. If you want to, you can maintain sum also, but it is not necessary.
Assign appropriate initial values to these variables. (What is sum before the user has any input? 
Perhaps null - so, use optionals).

Write your implementation into Kotlin main function ( fun main() { ... } ). Attach some sample executions
into comments box in your solution (in a way similar to what is shown below).

Hints:
- In Kotlin, you can use toDoubleOrNull() to convert a String to a Double. If the user enters "",
toDoubleOrNull returns null.
- Use the ? and ?: operators to handle the null case.
- If you have read 3 numbers and their average is 6, then the sum of numbers is 6 * 3 = 18
- Develop the program in steps
- You may find it useful to use Kotlin worksheet feature to try out parts of the program

Some sample runs:

Statistics computer starting...
Yes? quit
Thank you. You gave 0 numbers.
Their min is none
Their max is none
Their average is none

Statistics computer starting...
Yes? kukkuu
Yes? trallalaa
Yes? quit
Thank you. You gave 0 numbers.
Their min is none
Their max is none
Their average is none

Statistics computer starting...
Yes? 1
average is now 1.0
Yes? 2.0
average is now 1.5
Yes? 3
average is now 2.0
Yes? 4.000
average is now 2.5
Yes? quit
Thank you. You gave 4 numbers.
Their min is 1.0
Their max is 4.0
Their average is 2.5

*/

// Implement your solution in the main function. Fill in your name and student number below.

// Exercise 1

private val Any.toDoubleOrNull: Unit
    get() = Unit

fun main() {
    var sum: Double? = null
    var count = 0
    var average: Double? = null
    var min: Double? = null
    var max: Double? = null

    do {
        //user input and read input
        println("Please input a number ('quit' to stop)")
        val stringInput = readLine()
        var doubleInput = stringInput?.toDoubleOrNull()

        //Consider the case that doubleInput is not null
        if (doubleInput != null) {
            sum = sum?.plus(doubleInput) ?: doubleInput //if double input is not null, assign the doubleInput plus sum to sum. Otherwise,assign the doubleInput to sum

            //if the max is null, assign the first input to max. Otherwise, compare the input
            if(max == null) {
                max = doubleInput
            } else {
                if(max < doubleInput) {
                    max = doubleInput
                }
            }

            //if the min is null, assign the first input to min. Otherwise, compare the input
            if(min == null) {
                min = doubleInput
            } else {
                if(min > doubleInput) {
                    min = doubleInput
                }
            }

            //count and average the input
            count++
            average = sum.toDouble() / count
            println("sum = $sum")
            println("average = $average")
        }
    } while (stringInput != "quit") //the loop continues while input is not "quit"

    //output the result
    println("Thank you. You gave $count numbers")
    println("Their min is $min")
    println("Their max is $max")
    println("Their average is $average")
}
