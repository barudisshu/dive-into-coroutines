# Kotlin Coroutines


如果你的项目多处出现了如下的情形。

```java
ExecutorServcie executorService = Executors.newXXXX()

executorService.submit(() -> {<tasks>})

// after all / graceful shutdown
executorService.shutdown()
```

那么可以考虑使用coroutines。其它任何一情形都不推荐使用coroutines。因为：

coroutine仅仅是响应式设计的另外一种形式：编写代码起来像是同步，实际运行时异步。

类似于RxJava，属于一种基于work-stealing的stackless。但是，`suspend`关键字会在编译期触发对源码字节码的修改(idea可以通过tools -> kotlin -> show bytecode查看编译后的Java代码)。这么做有好处，也有不好。一是，每次修改都需要重新编译，在不熟悉kotlin的情况下，经常出现牛头不对马嘴的情形；二是，编译后的Java代码，实际上更加啰嗦了... 想省磁盘的话不推荐。不过也有好处，可以不太关心 typesafe 问题。众所周知，80%的漏洞都是 typesafe 引起的。

如果你的项目迭代更新频繁、相对交付要求不高、相对要求性能不高的情况下。可以考虑coroutine方法。但如果考虑稳定、typesafe、stackless，不妨尝试替换方案 Fiber(cats effect/ZIO)；如果考虑更高的性能和并发的定制化设计，譬如原子类粒度控制，信号量、吞吐量、鲁棒性等，不妨尝试原始的RxJava/Reactor/Webflux。





## Conception

- chap01: Getting Started
