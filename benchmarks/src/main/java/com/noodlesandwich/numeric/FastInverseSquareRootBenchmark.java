package com.noodlesandwich.numeric;

import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@State(Scope.Thread)
@Fork(1)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class FastInverseSquareRootBenchmark {
    private float smallNumber;
    private float largeNumber;

    @Setup
    public void initializeNumbers() {
        this.smallNumber = 0.25F;
        this.largeNumber = 1000000000;
    }

    @Benchmark
    public float smallNumber() {
        return FastInverseSquareRoot.apply(smallNumber);
    }

    @Benchmark
    public float largeNumber() {
        return FastInverseSquareRoot.apply(largeNumber);
    }
}
