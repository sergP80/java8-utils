package com.psv.java8.stream.utils.tuples;

import java.io.Serializable;
import java.util.Objects;

public class Tuple2<T1, T2> implements Serializable {
    private T1 t1;
    private T2 t2;

    public Tuple2() {
    }

    public Tuple2(T1 t1, T2 t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    public static <U, V> Tuple2<U, V> of(U u, V v)
    {
        return new Tuple2<>(u, v);
    }

    public T1 t1() {
        return t1;
    }

    public void t1(T1 t1) {
        this.t1 = t1;
    }

    public T2 t2() {
        return t2;
    }

    public void t2(T2 t2) {
        this.t2 = t2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple2<?, ?> tuple2 = (Tuple2<?, ?>) o;
        return Objects.equals(t1, tuple2.t1) &&
                Objects.equals(t2, tuple2.t2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(t1, t2);
    }

    @Override
    public String toString() {
        return "Tuple2{" +
                "t1=" + t1 +
                ", t2=" + t2 +
                '}';
    }
}
