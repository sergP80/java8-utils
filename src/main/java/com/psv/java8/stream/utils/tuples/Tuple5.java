package com.psv.java8.stream.utils.tuples;

import java.io.Serializable;
import java.util.Objects;

public class Tuple5<T1, T2, T3, T4, T5> implements Serializable {
    private T1 t1;
    private T2 t2;
    private T3 t3;
    private T4 t4;
    private T5 t5;

    public Tuple5() {
    }

    public Tuple5(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
        this.t4 = t4;
        this.t5 = t5;
    }

    public static <U1, U2, U3, U4, U5> Tuple5<U1, U2, U3, U4, U5> of(U1 u1, U2 u2, U3 u3, U4 u4, U5 u5)
    {
        return new Tuple5<>(u1, u2, u3, u4, u5);
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

    public T5 t5() {
        return t5;
    }

    public void t5(T5 t5) {
        this.t5 = t5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple5<?, ?, ?, ?, ?> tuple5 = (Tuple5<?, ?, ?, ?, ?>) o;
        return Objects.equals(t1, tuple5.t1) &&
                Objects.equals(t2, tuple5.t2) &&
                Objects.equals(t3, tuple5.t3) &&
                Objects.equals(t4, tuple5.t4) &&
                Objects.equals(t5, tuple5.t5);
    }

    @Override
    public int hashCode() {
        return Objects.hash(t1, t2, t3, t4, t5);
    }

    @Override
    public String toString() {
        return "Tuple5{" +
                "t1=" + t1 +
                ", t2=" + t2 +
                ", t3=" + t3 +
                ", t4=" + t4 +
                ", t5=" + t5 +
                '}';
    }
}
