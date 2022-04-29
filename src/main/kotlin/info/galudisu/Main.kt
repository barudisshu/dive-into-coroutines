package info.galudisu

import kotlinx.coroutines.*
import java.util.concurrent.TimeUnit

@OptIn(DelicateCoroutinesApi::class)
fun main() {
  val job1 = GlobalScope.launch(start = CoroutineStart.LAZY) {
    delay(200)
    println("Pong")
    delay(200)
  }
  GlobalScope.launch {
    delay(200)
    println("Ping")
    job1.join()
    println("Ping")
    delay(200)
  }
  TimeUnit.SECONDS.sleep(1)
}
