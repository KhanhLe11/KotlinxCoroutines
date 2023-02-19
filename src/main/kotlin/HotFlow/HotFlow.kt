package HotFlow

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import simple

fun hotFlow(): SharedFlow<Int> {
    return simple().shareIn(replay = 1, scope = GlobalScope, started = SharingStarted.WhileSubscribed())
}
fun main() = runBlocking{
    val hotFlow = hotFlow()
    launch {
        hotFlow.collect{
            println("1st Collector: $it")
        }
    }
    delay(2500)
    launch {
        hotFlow.collect{
            println("2st Collector: $it")
        }
    }
    println("Finish")
}
