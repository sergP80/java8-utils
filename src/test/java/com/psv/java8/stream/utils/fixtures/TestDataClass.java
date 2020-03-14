package com.psv.java8.stream.utils.fixtures;

import java.util.Objects;

public class TestDataClass {
    private Integer amount;
    private Double  offset;
    private Character sign = '0';
    private String  name;

    public TestDataClass() {
    }

    public TestDataClass(Integer amount, Double offset, String name) {
        this.amount = amount;
        this.offset = offset;
        this.name = name;
    }

    public TestDataClass(Integer amount, Double offset, Character sign, String name) {
        this.amount = amount;
        this.offset = offset;
        this.sign = sign;
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public Double getOffset() {
        return offset;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestDataClass that = (TestDataClass) o;
        return Objects.equals(amount, that.amount) &&
                Objects.equals(offset, that.offset) &&
                Objects.equals(sign, that.sign) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, offset, sign, name);
    }

    @Override
    public String toString() {
        return "TestDataClass{" +
                "amount=" + amount +
                ", offset=" + offset +
                ", sign=" + sign +
                ", name='" + name + '\'' +
                '}';
    }
}
