import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking() {
    var resultOne = "Android"
    var resultTwo = "Kotlin"
    println("Launch Before")
    launch { resultOne = function1() }
    launch { resultTwo = function2() }
    println("Launch After")
    var resultText = resultOne + resultTwo
    println("Launch $resultText")

}

suspend fun function2(): String {
    delay(1000L)
    val message = "function1"
    println("Launch $message")
    return message
}

suspend fun function1(): String {
    delay(100L)
    val message = "function2"
    println("launch $message")
    return message
}
