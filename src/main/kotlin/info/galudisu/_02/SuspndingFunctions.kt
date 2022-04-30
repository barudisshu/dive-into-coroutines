package info.galudisu._02

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


data class User(val id: Int, val name: String)

suspend fun getUserSuspend(userId: Int): User {
  delay(1_000)
  return User(userId, "Filip")
}

@OptIn(DelicateCoroutinesApi::class)
fun main() {
  GlobalScope.launch {
    val user = getUserSuspend(101)

    println(user)
  }
  Thread.sleep(1500)
}
