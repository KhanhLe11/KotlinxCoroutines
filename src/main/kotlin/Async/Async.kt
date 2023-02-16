package Async

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    println("Async Before")
    val resultOne = async { function1() }
    val resultTwo = async { function2() }
    println("Async After")
    val resultText = resultOne.await() + resultTwo.await()
    println("Async $resultText")
}

suspend fun function1(): String {
    delay(1000L)
    val message = "function1"
    println("Async $message")
    return message
}

suspend fun function2(): String {
    delay(100L)
    val message = "function2"
    println("Async $message")
    return message
}
