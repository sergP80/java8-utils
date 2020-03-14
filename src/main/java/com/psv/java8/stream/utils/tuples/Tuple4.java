package com.psv.java8.stream.utils.tuples;

import java.io.Serializable;
import java.util.Objects;

public class Tuple4<T1, T2, T3, T4> implements Serializable {
    private T1 t1;
    private T2 t2;
    private T3 t3;
    private T4 t4;

    public Tuple4() {
    }

    public Tuple4(T1 t1, T2 t2, T3 t3, T4 t4) {
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
        this.t4 = t4;
    }

    public static <U1, U2, U3, U4> Tuple4<U1, U2, U3, U4> of(U1 u1, U2 u2, U3 u3, U4 u4)
    {
        return new Tuple4<>(u1, u2, u3, u4);
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

    public T3 t3() {
        return t3;
    }

    public void t3(T3 t3) {
        this.t3 = t3;
    }

    public T4 t4() {
        return t4;
    }

    public void t4(T4 t4) {
        this.t4 = t4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple4<?, ?, ?, ?> tuple4 = (Tuple4<?, ?, ?, ?>) o;
        return Objects.equals(t1, tuple4.t1) &&
                Objects.equals(t2, tuple4.t2) &&
                Objects.equals(t3, tuple4.t3) &&
                Objects.equals(t4, tuple4.t4);
    }

    @Override
    public int hashCode() {
        return Objects.hash(t1, t2, t3, t4);
    }

    @Override
    public String toString() {
        return "Tuple4{" +
                "t1=" + t1 +
                ", t2=" + t2 +
                ", t3=" + t3 +
                ", t4=" + t4 +
                '}';
    }
}
