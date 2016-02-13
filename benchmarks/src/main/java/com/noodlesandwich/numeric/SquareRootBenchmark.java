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
public class SquareRootBenchmark {
    private double smallNumber;
    private double largeNumber;

    @Setup
    public void initializeNumbers() {
        this.smallNumber = 4;
        this.largeNumber = 1000000000;
    }

    @Benchmark
    public double smallNumber() {
        return SquareRoot.apply(smallNumber);
    }

    @Benchmark
    public double largeNumber() {
        return InverseSquareRoot.apply(largeNumber);
    }
}
