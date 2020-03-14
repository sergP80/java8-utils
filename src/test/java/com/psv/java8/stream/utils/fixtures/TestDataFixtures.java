package com.psv.java8.stream.utils.fixtures;

import com.psv.java8.stream.utils.tuples.Tuple3;
import com.psv.java8.stream.utils.tuples.Tuple4;
import com.psv.java8.stream.utils.tuples.Tuple2;
import com.psv.java8.stream.utils.tuples.Tuple5;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.Arrays;
import java.util.stream.Stream;

public class TestDataFixtures {
    public static class ZipSource1 implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of(
                            Arrays.asList(1, 3, 5, -1),
                            Arrays.asList("1", "A", "4", "D"),
                            Arrays.asList(
                                    Tuple2.of(1, "1"),
                                    Tuple2.of(3, "A"),
                                    Tuple2.of(5, "4"),
                                    Tuple2.of(-1, "D")
                            )
                    ),
                    Arguments.of(
                            Arrays.asList(-6, 4, 3, 12),
                            Arrays.asList("A", "B", "C"),
                            Arrays.asList(
                                    Tuple2.of(-6, "A"),
                                    Tuple2.of(4, "B"),
                                    Tuple2.of(3, "C")
                            )
                    )
            );
        }
    }

    public static class ZipSource2 implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of(
                            Arrays.asList(1, 3, 5, -1),
                            Arrays.asList("1", "A", "4", "D"),
                            Arrays.asList(
                                    new TestDataClass(1, 1/10.0, "1"),
                                    new TestDataClass(3, 3/10.0, "A"),
                                    new TestDataClass(5, 5/10.0, "4"),
                                    new TestDataClass(-1, -1/10.0, "D")
                            )
                    ),
                    Arguments.of(
                            Arrays.asList(-6, 4, 3, 12),
                            Arrays.asList("A", "B", "C"),
                            Arrays.asList(
                                    new TestDataClass(-6, -6/10.0, "A"),
                                    new TestDataClass(4, 4/10.0, "B"),
                                    new TestDataClass(3, 3/10.0, "C")
                            )
                    )
            );
        }
    }

    public static class ZipSource3 implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of(
                            Arrays.asList(1, 3, 5, -1),
                            Arrays.asList(2.1, 4.1, 5.8, -1.1, 2.05, 8.11),
                            Arrays.asList("1", "A", "4", "D", "C"),
                            Arrays.asList(
                                    Tuple3.of(1, 2.1, "1"),
                                    Tuple3.of(3, 4.1, "A"),
                                    Tuple3.of(5, 5.8, "4"),
                                    Tuple3.of(-1, -1.1, "D")
                            )
                    ),
                    Arguments.of(
                            Arrays.asList(2, -1, 6, 7, 8),
                            Arrays.asList(-11.5, 22.04),
                            Arrays.asList("A", "B", "C", "D"),
                            Arrays.asList(
                                    Tuple3.of(2, -11.5, "A"),
                                    Tuple3.of(-1, 22.04, "B")
                            )
                    )
            );
        }
    }

    public static class ZipSource4 implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of(
                            Arrays.asList(1, 3, 5, -1),
                            Arrays.asList(2.1, 4.1, 5.8, -1.1, 2.05, 8.11),
                            Arrays.asList("1", "A", "4", "D", "C"),
                            Arrays.asList(
                                    new TestDataClass(1, 2.1, "1"),
                                    new TestDataClass(3, 4.1, "A"),
                                    new TestDataClass(5, 5.8, "4"),
                                    new TestDataClass(-1, -1.1, "D")

                            )
                    ),
                    Arguments.of(
                            Arrays.asList(2, -1, 6, 7, 8),
                            Arrays.asList(-11.5, 22.04),
                            Arrays.asList("A", "B", "C", "D"),
                            Arrays.asList(
                                    new TestDataClass(2, -11.5, "A"),
                                    new TestDataClass(-1, 22.04, "B")
                            )
                    )
            );
        }
    }

    public static class ZipSource5 implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of(
                            Arrays.asList(1, 3, 5, -1),
                            Arrays.asList(2.1, 4.1, 5.8, -1.1, 2.05, 8.11),
                            Arrays.asList('c', 'e', 'f', 'g', 'k', 'm'),
                            Arrays.asList("1", "A", "4", "D", "C"),
                            Arrays.asList(
                                    Tuple4.of(1, 2.1,  'c', "1"),
                                    Tuple4.of(3, 4.1,  'e', "A"),
                                    Tuple4.of(5, 5.8,  'f', "4"),
                                    Tuple4.of(-1, -1.1,'g', "D")
                            )
                    ),
                    Arguments.of(
                            Arrays.asList(2, -1, 6, 7, 8),
                            Arrays.asList(-11.5, 22.04),
                            Arrays.asList('x', '#'),
                            Arrays.asList("A", "B", "C", "D"),
                            Arrays.asList(
                                    Tuple4.of(2, -11.5, 'x', "A"),
                                    Tuple4.of(-1, 22.04, '#', "B")
                            )
                    )
            );
        }
    }

    public static class ZipSource6 implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of(
                            Arrays.asList(1, 3, 5, -1),
                            Arrays.asList(2.1, 4.1, 5.8, -1.1, 2.05, 8.11),
                            Arrays.asList('c', 'e', 'f', 'g', 'k', 'm'),
                            Arrays.asList("1", "A", "4", "D", "C"),
                            Arrays.asList(
                                    new TestDataClass(1, 2.1,  'c', "1"),
                                    new TestDataClass(3, 4.1,  'e', "A"),
                                    new TestDataClass(5, 5.8,  'f', "4"),
                                    new TestDataClass(-1, -1.1,'g', "D")
                            )
                    ),
                    Arguments.of(
                            Arrays.asList(2, -1, 6, 7, 8),
                            Arrays.asList(-11.5, 22.04),
                            Arrays.asList('x', '#'),
                            Arrays.asList("A", "B", "C", "D"),
                            Arrays.asList(
                                    new TestDataClass(2, -11.5, 'x', "A"),
                                    new TestDataClass(-1, 22.04, '#', "B")
                            )
                    )
            );
        }
    }

    public static class ZipSource7 implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of(
                            Arrays.asList(1, 3, 5, -1),
                            Arrays.asList(2.1, 4.1, 5.8, -1.1, 2.05, 8.11),
                            Arrays.asList('c', 'e', 'f', 'g', 'k', 'm'),
                            Arrays.asList("1", "A", "4", "D", "C"),
                            Arrays.asList(true, false, false, true),
                            Arrays.asList(
                                    Tuple5.of(1, 2.1,  'c', "1", true),
                                    Tuple5.of(3, 4.1,  'e', "A", false),
                                    Tuple5.of(5, 5.8,  'f', "4", false),
                                    Tuple5.of(-1, -1.1,'g', "D", true)
                            )
                    ),
                    Arguments.of(
                            Arrays.asList(2, -1, 6, 7, 8),
                            Arrays.asList(-11.5, 22.04, -1.9),
                            Arrays.asList('x', '#', 'd', 'g'),
                            Arrays.asList("A", "B", "C", "D"),
                            Arrays.asList(false, true, true, false),
                            Arrays.asList(
                                    Tuple5.of(2, -11.5, 'x', "A", false),
                                    Tuple5.of(-1, 22.04, '#', "B", true),
                                    Tuple5.of(6, -1.9, 'd', "C", true)
                            )
                    )
            );
        }
    }
}
