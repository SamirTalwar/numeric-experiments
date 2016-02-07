package com.noodlesandwich.numeric;

import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;

public class SquareRootBenchmark {
    @Benchmark
    @Fork(1)
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void smallNumber() {
        SquareRoot.apply(4);
    }

    @Benchmark
    @Fork(1)
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void largeNumber() {
        InverseSquareRoot.apply(1000000000);
    }
}
