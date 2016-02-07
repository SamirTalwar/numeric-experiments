# Experiments with numerical operations

I was having fun with the Newton-Raphson method, and decided to share. You can find implementations of the *square root* and *inverse square root* functions by diving into `implementation/src/main`.

I also created a Scala version of the [fast inverse square root][] function made famous by John Carmack. My throughput benchmarks of that function vs. the more naive version (using [JMH][]) are as follows:

    Benchmark                                    Mode  Cnt       Score      Error   Units
    FastInverseSquareRootBenchmark.largeNumber  thrpt   20  364327.510 ± 6054.767  ops/ms
    FastInverseSquareRootBenchmark.smallNumber  thrpt   20  365125.964 ± 7416.265  ops/ms
    InverseSquareRootBenchmark.largeNumber      thrpt   20     284.051 ±    6.977  ops/ms
    InverseSquareRootBenchmark.smallNumber      thrpt   20     181.565 ±    3.117  ops/ms

You can see here that the fast inverse square root function is over a thousand times faster (but, it should be noted, less precise) than the naive version.

[fast inverse square root]: https://en.wikipedia.org/wiki/Fast_inverse_square_root
[JMH]: http://openjdk.java.net/projects/code-tools/jmh/
