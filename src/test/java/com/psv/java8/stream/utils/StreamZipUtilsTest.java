package com.psv.java8.stream.utils;

import com.psv.java8.stream.utils.fixtures.TestDataClass;
import com.psv.java8.stream.utils.fixtures.TestDataFixtures;
import com.psv.java8.stream.utils.functions.Function3;
import com.psv.java8.stream.utils.functions.Function4;
import com.psv.java8.stream.utils.tuples.Tuple2;
import com.psv.java8.stream.utils.tuples.Tuple3;
import com.psv.java8.stream.utils.tuples.Tuple4;
import com.psv.java8.stream.utils.tuples.Tuple5;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class StreamZipUtilsTest {

    @ParameterizedTest
    @ArgumentsSource(TestDataFixtures.ZipSource1.class)
    public void successMapToTuple2UsingZipStream(List<Integer> sourceList1,
                                                 List<String> sourceList2,
                                                 List<Tuple2<Integer, String>> expectedZippedList)
    {
        List<Tuple2<Integer, String>> actualZippedList = StreamZipUtils.zip(
                sourceList1.stream(),
                sourceList2.stream()
        )
        .collect(Collectors.toList());
        Assertions.assertEquals(expectedZippedList, actualZippedList);
    }

    @ParameterizedTest
    @ArgumentsSource(TestDataFixtures.ZipSource1.class)
    public void successMapToTuple2UsingZipStreamParallel(List<Integer> sourceList1,
                                                         List<String> sourceList2,
                                                         List<Tuple2<Integer, String>> expectedZippedList)
    {
        List<Tuple2<Integer, String>> actualZippedList = StreamZipUtils.zip(
                sourceList1.stream(),
                sourceList2.stream(),
                true
        )
        .collect(Collectors.toList());
        Assertions.assertEquals(expectedZippedList, actualZippedList);
    }

    @ParameterizedTest
    @ArgumentsSource(TestDataFixtures.ZipSource1.class)
    public void successMapToTuple2UsingZip(List<Integer> sourceList1,
                                           List<String> sourceList2,
                                           List<Tuple2<Integer, String>> expectedZippedList)
    {
        List<Tuple2<Integer, String>> actualZippedList = StreamZipUtils.zip(sourceList1, sourceList2)
                .collect(Collectors.toList());
        Assertions.assertEquals(expectedZippedList, actualZippedList);
    }

    @ParameterizedTest
    @ArgumentsSource(TestDataFixtures.ZipSource1.class)
    public void successMapToTuple2UsingZipWithParallels(List<Integer> sourceList1,
                                                        List<String> sourceList2,
                                                        List<Tuple2<Integer, String>> expectedZippedList)
    {
        List<Tuple2<Integer, String>> actualZippedList = StreamZipUtils.zip(sourceList1, sourceList2, true)
                .collect(Collectors.toList());
        Assertions.assertEquals(expectedZippedList, actualZippedList);
    }

    @ParameterizedTest
    @ArgumentsSource(TestDataFixtures.ZipSource2.class)
    public void successMapToCustomClassUsingZip(List<Integer> sourceList1,
                                                List<String> sourceList2,
                                                List<TestDataClass> expectedZippedList)
    {
        BiFunction<Integer, String, TestDataClass> mapper = (i, s) -> new TestDataClass(i, i/10.0, s);
        List<TestDataClass> actualZippedList = StreamZipUtils.zipWith(sourceList1, sourceList2, mapper)
                .collect(Collectors.toList());
        Assertions.assertEquals(expectedZippedList, actualZippedList);
    }

    @ParameterizedTest
    @ArgumentsSource(TestDataFixtures.ZipSource2.class)
    public void successMapToCustomClassUsingZipWithParallel(List<Integer> sourceList1,
                                                            List<String> sourceList2,
                                                            List<TestDataClass> expectedZippedList)
    {
        BiFunction<Integer, String, TestDataClass> mapper = (i, s) -> new TestDataClass(i, i/10.0, s);
        List<TestDataClass> actualZippedList = StreamZipUtils.zipWith(sourceList1, sourceList2, mapper, true)
                .collect(Collectors.toList());
        Assertions.assertEquals(expectedZippedList, actualZippedList);
    }

    @ParameterizedTest
    @ArgumentsSource(TestDataFixtures.ZipSource3.class)
    public void successMapToTuple3UsingZip(
            List<Integer> sourceList1,
            List<Double> sourceList2,
            List<String> sourceList3,
            List<Tuple3<Integer, Double, String>> expectedZippedList)
    {
        List<Tuple3<Integer, Double, String>> actualZippedList =
                StreamZipUtils
                .zip(sourceList1, sourceList2, sourceList3)
                .collect(Collectors.toList());
        Assertions.assertEquals(expectedZippedList, actualZippedList);
    }

    @ParameterizedTest
    @ArgumentsSource(TestDataFixtures.ZipSource3.class)
    public void successMapToTuple3UsingZipWithParallel(
            List<Integer> sourceList1,
            List<Double> sourceList2,
            List<String> sourceList3,
            List<Tuple3<Integer, Double, String>> expectedZippedList)
    {
        List<Tuple3<Integer, Double, String>> actualZippedList =
                StreamZipUtils
                        .zip(sourceList1, sourceList2, sourceList3, true)
                        .collect(Collectors.toList());
        Assertions.assertEquals(expectedZippedList, actualZippedList);
    }

    @ParameterizedTest
    @ArgumentsSource(TestDataFixtures.ZipSource3.class)
    public void successMapToTuple3UsingZipStream(
            List<Integer> sourceList1,
            List<Double> sourceList2,
            List<String> sourceList3,
            List<Tuple3<Integer, Double, String>> expectedZippedList)
    {
        List<Tuple3<Integer, Double, String>> actualZippedList =
                StreamZipUtils
                        .zip(
                                sourceList1.stream(),
                                sourceList2.stream(),
                                sourceList3.stream())
                        .collect(Collectors.toList());
        Assertions.assertEquals(expectedZippedList, actualZippedList);
    }

    @ParameterizedTest
    @ArgumentsSource(TestDataFixtures.ZipSource3.class)
    public void successMapToTuple3UsingZipStreamWithParallel(
            List<Integer> sourceList1,
            List<Double> sourceList2,
            List<String> sourceList3,
            List<Tuple3<Integer, Double, String>> expectedZippedList)
    {
        List<Tuple3<Integer, Double, String>> actualZippedList =
                StreamZipUtils
                        .zip(
                                sourceList1.stream(),
                                sourceList2.stream(),
                                sourceList3.stream(),
                                true)
                        .collect(Collectors.toList());
        Assertions.assertEquals(expectedZippedList, actualZippedList);
    }

    @ParameterizedTest
    @ArgumentsSource(TestDataFixtures.ZipSource4.class)
    public void successMapToCustomClass3UsingZip(
            List<Integer> sourceList1,
            List<Double> sourceList2,
            List<String> sourceList3,
            List<TestDataClass> expectedZippedList)
    {
        Function3<Integer, Double, String, TestDataClass> mapper = TestDataClass::new;

        List<TestDataClass> actualZippedList =
                StreamZipUtils
                        .zipWith(sourceList1, sourceList2, sourceList3, mapper)
                        .collect(Collectors.toList());
        Assertions.assertEquals(expectedZippedList, actualZippedList);
    }

    @ParameterizedTest
    @ArgumentsSource(TestDataFixtures.ZipSource4.class)
    public void successMapToCustomClass3UsingZipWithParallel(
            List<Integer> sourceList1,
            List<Double> sourceList2,
            List<String> sourceList3,
            List<TestDataClass> expectedZippedList)
    {
        Function3<Integer, Double, String, TestDataClass> mapper = TestDataClass::new;

        List<TestDataClass> actualZippedList =
                StreamZipUtils
                        .zipWith(sourceList1, sourceList2, sourceList3, mapper, true)
                        .collect(Collectors.toList());
        Assertions.assertEquals(expectedZippedList, actualZippedList);
    }

    @ParameterizedTest
    @ArgumentsSource(TestDataFixtures.ZipSource5.class)
    public void successMapToTuple4UsingZipStream(
            List<Integer> sourceList1,
            List<Double> sourceList2,
            List<Character> sourceList3,
            List<String> sourceList4,
            List<Tuple4<Integer, Double, Character, String>> expectedZippedList)
    {
        List<Tuple4<Integer, Double, Character, String>> actualZippedList =
                StreamZipUtils
                        .zip(
                                sourceList1.stream(),
                                sourceList2.stream(),
                                sourceList3.stream(),
                                sourceList4.stream()
                        )
                        .collect(Collectors.toList());
        Assertions.assertEquals(expectedZippedList, actualZippedList);
    }

    @ParameterizedTest
    @ArgumentsSource(TestDataFixtures.ZipSource5.class)
    public void successMapToTuple4UsingZipStreamWithParallel(
            List<Integer> sourceList1,
            List<Double> sourceList2,
            List<Character> sourceList3,
            List<String> sourceList4,
            List<Tuple4<Integer, Double, Character, String>> expectedZippedList)
    {
        List<Tuple4<Integer, Double, Character, String>> actualZippedList =
                StreamZipUtils
                        .zip(
                                sourceList1.stream(),
                                sourceList2.stream(),
                                sourceList3.stream(),
                                sourceList4.stream(),
                                true)
                        .collect(Collectors.toList());
        Assertions.assertEquals(expectedZippedList, actualZippedList);
    }

    @ParameterizedTest
    @ArgumentsSource(TestDataFixtures.ZipSource6.class)
    public void successMapToCustomClass4UsingZipStream(
            List<Integer> sourceList1,
            List<Double> sourceList2,
            List<Character> sourceList3,
            List<String> sourceList4,
            List<TestDataClass> expectedZippedList)
    {
        Function4<Integer, Double, Character, String, TestDataClass> mapper = TestDataClass::new;
        List<TestDataClass> actualZippedList =
                StreamZipUtils
                        .zipWith(
                                sourceList1.stream(),
                                sourceList2.stream(),
                                sourceList3.stream(),
                                sourceList4.stream(),
                                mapper
                        )
                        .collect(Collectors.toList());
        Assertions.assertEquals(expectedZippedList, actualZippedList);
    }

    @ParameterizedTest
    @ArgumentsSource(TestDataFixtures.ZipSource6.class)
    public void successMapToCustomClass4UsingZipStreamParallel(
            List<Integer> sourceList1,
            List<Double> sourceList2,
            List<Character> sourceList3,
            List<String> sourceList4,
            List<TestDataClass> expectedZippedList)
    {
        Function4<Integer, Double, Character, String, TestDataClass> mapper = TestDataClass::new;
        List<TestDataClass> actualZippedList =
                StreamZipUtils
                        .zipWith(
                                sourceList1.stream(),
                                sourceList2.stream(),
                                sourceList3.stream(),
                                sourceList4.stream(),
                                mapper
                        )
                        .collect(Collectors.toList());
        Assertions.assertEquals(expectedZippedList, actualZippedList);
    }

    @ParameterizedTest
    @ArgumentsSource(TestDataFixtures.ZipSource7.class)
    public void successMapToTuple5UsingZipStream(
            List<Integer> sourceList1,
            List<Double> sourceList2,
            List<Character> sourceList3,
            List<String> sourceList4,
            List<Boolean> sourceList5,
            List<Tuple5<Integer, Double, Character, String, Boolean>> expectedZippedList)
    {
        List<Tuple5<Integer, Double, Character, String, Boolean>> actualZippedList =
                StreamZipUtils
                        .zip(
                                sourceList1.stream(),
                                sourceList2.stream(),
                                sourceList3.stream(),
                                sourceList4.stream(),
                                sourceList5.stream()
                        )
                        .collect(Collectors.toList());
        Assertions.assertEquals(expectedZippedList, actualZippedList);
    }

    @ParameterizedTest
    @ArgumentsSource(TestDataFixtures.ZipSource7.class)
    public void successMapToTuple5UsingZipStreamParallel(
            List<Integer> sourceList1,
            List<Double> sourceList2,
            List<Character> sourceList3,
            List<String> sourceList4,
            List<Boolean> sourceList5,
            List<Tuple5<Integer, Double, Character, String, Boolean>> expectedZippedList)
    {
        List<Tuple5<Integer, Double, Character, String, Boolean>> actualZippedList =
                StreamZipUtils
                        .zip(
                                sourceList1.stream(),
                                sourceList2.stream(),
                                sourceList3.stream(),
                                sourceList4.stream(),
                                sourceList5.stream(),
                                true
                        )
                        .collect(Collectors.toList());
        Assertions.assertEquals(expectedZippedList, actualZippedList);
    }

}
