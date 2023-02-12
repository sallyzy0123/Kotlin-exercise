import java.util.InputMismatchException

// Exercise 2

/*
Write implementations of the functions into a Kotlin file. You may find
it useful to try out the functions in a Kotlin worksheet.
*/

fun main() {


    //pickNumber function
    println(pickNumber())
    println(pickNumber(0,1))
    println(pickNumber(1,6))

    //pickNDistinct function
    println(pickNDistinct(1,40,7))
    println(pickNDistinct(1,6,3))
    println(pickNDistinct(1,6,6))

    //numDistinct function
    println(numDistinct(listOf(1,1,1,2,3,4,5,6,6,6)))
    println(numDistinct(pickNDistinct(1,40,7)))

    //numCommon function
    println(numCommon(listOf(1,2,3,4), listOf(2,4))) // 2
    println(numCommon(listOf(1, 1, 1, 2, 3), listOf(1, 2))) // 2
    println(numCommon(listOf(4, 3, 2), listOf(1, 4, 1, 1, 2, 3))) // 3

    //readNDistinct function
    println(readNDistinct())

    //playLotto function
    playLotto()

    //findLotto function
    findLotto(pickNDistinct(1,40,7))

}


/*
Write function pickNumber() that has two Int parameters: low and high
and returns a random number between low and high (inclusive). You may
assume low <= high. Default value for low and high should be 1 and 40.
Hint: consider making a range and picking a random number from it.
Example runs:
println(pickNumber()) // a number in 1..40
println(pickNumber(0,1)) // a number in 0..1
println(pickNumber(1,6)) // a number in 1..6
*/
fun pickNumber(low: Int = 0, high: Int = 40): String {
    //declare the list contains the number from low to high
    val values = (low..high).toList()

    // get the random number from the list
    val random = values.random()

    // return the string
    return "The random number between $low and $high is $random"
}
/*
Write function pickNDistinct(low: Int, high: Int, n: Int) that
returns n distinct random numbers between low and high (inclusive).
You may assume low <= high and n <= number of distinct values.
Return the values as List of Int values sorted from smallest to greatest.
Example runs:
println(pickNDistinct(1,40,7)) // for example [3, 6, 11, 17, 19, 21, 34]
println(pickNDistinct(1,6,3)) // for example [1, 3, 6]
println(pickNDistinct(1,6,6)) // [1, 2, 3, 4, 5, 6]
*/
fun pickNDistinct (low: Int, high: Int, n: Int) :  List<Int> {
    //declare the list contains the number from low to high, the mutable list to store the random number
    val values = (low..high).toList()
    val randomList: MutableList<Int> = mutableListOf<Int>()
    var count: Int = 0

    // loop to get the random number
    while (count < n) {
        var random = values.random()
        randomList.add(random)
        count++
    }

    // sort the number from the smallest to greatest
    randomList.sort()

    //return the string
    return randomList
}

/*
Write function numDistinct(list: List<Int>) that returns the
number of distinct elements in list.
Hint: consider conversion to set.
Example runs:
println(numDistinct(listOf(1,1,1,2,3,4,5,6,6,6))) // 6
println(numDistinct(pickNDistinct(1,40,7))) // 7
*/

fun numDistinct(listOf: List<Int>): Int {
    //declare the list
    val myList = listOf
    // convert the given list to a set collection, filter out the duplicates.
    val distinct = myList.toSet().toList()
    //count the different number in list
    var countNum = distinct.count()

    return countNum
}
/*
Write function numCommon(list1: List<Int>, list2: List<Int>) that returns
the number of elements in both list1 and list2. Multiple occurences should
be counted only once.
Example runs:
println(numCommon(listOf(1,2,3,4), listOf(2,4))) // 2
println(numCommon(listOf(1, 1, 1, 2, 3), listOf(1, 2))) // 2
println(numCommon(listOf(4, 3, 2), listOf(1, 4, 1, 1, 2, 3))) // 3
*/
fun numCommon(list1: List<Int>, list2: List<Int>): Int {
    // declare the list
    val firstList: List<Int> = list1
    val secondList: List<Int> = list2
    var count = 0

    //convert the given list to a set collection, filter out the duplicates
    val firstSet = firstList.toSet().toList()
    val secondSet = secondList.toSet().toList()

    //for loop to count the multiply occurences
    for (i in firstSet.indices) {
        for (y in secondSet.indices) {
            if (firstSet[i] == secondSet[y]) {
                count++
            }
        }
    }

    return count
}
/*
Write function readNDistinct(low: Int, high: Int, n: Int): List<Int> that reads from console a line
that contains n distinct integer numbers ranging from low and high (inclusive), separated by commas.
You may assume low <= high and n <= number of distinct values.
Hints: use readLine(), .split(), check .toIntOrNull(), .filterNotNull() and .all { ... }
*/

fun readNDistinct():List<Int> {
    // loop stops when the size of intInput is 7
    do {
        // hints for user and read input
        println("Give 7 distinct numbers from 0 to 40 separated by commas:")
        val userInput = readLine()

        // split the string to list<string> by commas
        val splitInput = userInput?.split(",")

        // if splitInput is not null, remove the duplication, otherwise get the emptyList
        val SetInput = if (splitInput != null) { splitInput.toSet().toList()} else {
            emptyList<String>()}

        // filter the null value in the list and convert to list<int>
        val IntInput = SetInput.filterNot{ it.isBlank()}.map { it.toInt() }

        // if the size is 7, return the intInput
        if (IntInput.size == 7) {
                return IntInput
        }
    } while(IntInput.size !==7)
    return emptyList()
}

/*
Write function playLotto() that
- generates (secret) lotto numbers (7 distinct Ints in range from 1 to 40 (inclusive)).
- reads from the console user guess using readNDistinct() function
- prints the number of correctly guessed numbers (use numCommon() for this)
- lets user either continue with another round or end
- call your playLotto implementation from main function

Example runs (here computer guess (next exercise) is implemented also):
Give numbers separated by commas: 1,,2,3,4,5,6,7
Give numbers separated by commas: 1,2,3,4,5,6,7,8
Give numbers separated by commas: ,1,2,3,4,5,6,7
Give numbers separated by commas: 1,1,2,3,4,5,6
Give numbers separated by commas: 1,2,3,4,5,6,7
lotto numbers: [6, 7, 10, 11, 13, 25, 35], you got 2 correct
computer guess in 30 steps is [6, 7, 10, 11, 13, 25, 35]
More? (Y/N): Y
Give numbers separated by commas: 1,2,3,4,5,6,77
Give numbers separated by commas: 5,2,9,32,17,11,10
lotto numbers: [3, 6, 10, 12, 20, 36, 40], you got 1 correct
computer guess in 43 steps is [3, 6, 10, 12, 20, 36, 40]
More? (Y/N): N
*/
fun playLotto() {

    do {
        //generates the secret lotto number
        val secretLotto = pickNDistinct(1,40,7)

        //prints the number of correctly guessed numbers (use numCommon() for this)
        println("lotto numbers: $secretLotto, you got ${numCommon(readNDistinct(), secretLotto)} correct")

//        val (guessCount, secretLotto) = findLotto(secretLotto)
        val count = findLotto(secretLotto).first
        println("Computer guess in $count steps is $secretLotto")
        println("More?(Y/N)")
        val userInput = readLine()
    } while (userInput == "Y")
}

fun findLotto(lotto: List<Int>): Pair<Int, List<Int>> {
    /*
    Write here code that generates lotto guesses and
    uses only function lottoResult (see below) to check the guesses.
    Do not use the content of variable lotto in any other way
    either directly or indirectly.
    Return the number of steps taken to find the correct lotto
    numbers as well as the list of correct numbers as a Pair.
    */
    // declare the count and check
    var guessCount = 0
    var guessCheck: Int?

    // loop stops when check equals 7
    do {
        //assignment pickNDistinct to computerGuess
        val computerGuess = pickNDistinct(1,40,7)
        guessCount++
        //check if values are the same
        guessCheck = lottoResult(computerGuess.toMutableList(), lotto)
    } while (guessCheck != 7)

    return Pair(guessCount, lotto) // comment this out when implementing the function
}


fun lottoResult(guess: List<Int>, lotto: List<Int>) =
    if (numDistinct(guess) == 7 && numDistinct(lotto) == 7 && (guess + lotto).all { it in (1..40) }) {
        numCommon(guess, lotto)
    } else {
        null
    }


