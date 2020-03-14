package com.psv.java8.stream.utils;

import com.psv.java8.stream.utils.functions.Function3;
import com.psv.java8.stream.utils.functions.Function4;
import com.psv.java8.stream.utils.functions.Function5;
import com.psv.java8.stream.utils.tuples.Tuple2;
import com.psv.java8.stream.utils.tuples.Tuple3;
import com.psv.java8.stream.utils.tuples.Tuple4;
import com.psv.java8.stream.utils.tuples.Tuple5;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Contains util methods to zip streams and collections
 */
public class StreamZipUtils {
    private StreamZipUtils() {}

    /**
     * Create new <code>Stream</code> object based on zip of two source streams.
     * Each stream is iterated sequentially and for pair of elements
     * from both streams is applied <code>mapper</code> function
     * that generates new element of result stream
     *
     * @param stream1 - first stream
     * @param stream2 - second stream
     * @param mapper - function that transform pair of items from both streams to new item of result stream
     * @param isParallel - use parallel processing of streams
     * @param <T1> - type of items of the first stream
     * @param <T2>- type of items of the second stream
     * @param <R> - type of items of the result stream
     * @return <code>Stream</code> object
     *
     * @note If source streams have different count of items
     * then result stream would be contain minimum item count of both streams
     */
    public static <T1, T2, R> Stream<R> zipWith(Stream<? extends T1> stream1,
                                                 Stream<? extends T2> stream2,
                                                 BiFunction<? super T1, ? super  T2, R> mapper,
                                                 boolean isParallel)
    {
        final Iterator<? extends T1> iterator1 = stream1.iterator();
        final Iterator<? extends T2> iterator2 = stream2.iterator();

        final Iterable<R> iterable = () -> new Iterator<R>() {
            @Override
            public boolean hasNext() {
                return iterator1.hasNext() && iterator2.hasNext();
            }

            @Override
            public R next() {
                return mapper.apply(iterator1.next(), iterator2.next());
            }
        };

        return StreamSupport.stream(iterable.spliterator(), isParallel);
    }
    /**
     * Create new <code>Stream</code> object based on zip of two source streams.
     * Each stream is iterated sequentially and for pair of elements
     * from both streams is applied <code>mapper</code> function
     * that generates new element of result stream
     *
     * @param stream1 - first stream
     * @param stream2 - second stream
     * @param mapper - function that transform pair of items from both streams to new item of result stream
     * @param <T1> - type of items of the first stream
     * @param <T2>- type of items of the second stream
     * @param <R> - type of items of the result stream
     * @return <code>Stream</code> object
     *
     * @note If source streams have different count of items
     * then result stream would be contain minimum item count of both streams
     */
    public static <T1, T2, R> Stream<R> zipWith(Stream<? extends T1> stream1,
                                                Stream<? extends T2> stream2,
                                                BiFunction<? super T1, ? super T2, R> mapper)
    {
        return zipWith(stream1, stream2, mapper, false);
    }
    /**
     * Create new <code>Stream</code> object based on zip of two source collections.
     * Each stream is iterated sequentially and for pair of elements
     * from both collections is applied <code>mapper</code> function
     * that generates new element of result stream
     *
     * @param collection1 - first collection
     * @param collection2 - second collection
     * @param mapper - function that transform pair of items from both collections to new item of result stream
     * @param isParallel - use parallel processing of collections
     * @param <T1> - type of items of the first collection
     * @param <T2>- type of items of the second collection
     * @param <R> - type of items of the result stream
     * @return <code>Stream</code> object
     *
     * @note If source collections have different size
     * then result stream would be contain minimum size of both collections
     */
    public static <T1, T2, R> Stream<R> zipWith(Collection<? extends T1> collection1,
                                                Collection<? extends T2> collection2,
                                                BiFunction<? super T1, ? super  T2, R> mapper,
                                                boolean isParallel)
    {
        return zipWith(collection1.stream(), collection2.stream(), mapper, isParallel);
    }
    /**
     * Create new <code>Stream</code> object based on zip of two source collections.
     * Each stream is iterated sequentially and for pair of elements
     * from both collections is applied <code>mapper</code> function
     * that generates new element of result stream
     *
     * @param collection1 - first collection
     * @param collection2 - second collection
     * @param mapper - function that transform pair of items from both collections to new item of result stream
     * @param <T1> - type of items of the first collection
     * @param <T2>- type of items of the second collection
     * @param <R> - type of items of the result stream
     * @return <code>Stream</code> object
     *
     * @note If source collections have different size
     * then result stream would be contain minimum size of both collections
     */
    public static <T1, T2, R> Stream<R> zipWith(Collection<? extends T1> collection1,
                                                Collection<? extends T2> collection2,
                                                BiFunction<? super T1, ? super  T2, R> mapper)
    {
        return zipWith(collection1.stream(), collection2.stream(), mapper);
    }
    /**
     * Create new <code>Stream</code> of <code>Tuple2</code> based on zip of two source streams.
     *
     * @param stream1 - first stream
     * @param stream2 - second stream
     * @param isParallel - use parallel processing of streams
     * @param <T1> - type of items of the first stream
     * @param <T2>- type of items of the second stream
     * @return <code>Stream&ltT1, T2&gt</T1></code> object
     *
     * @note If source streams have different count of items
     * then result stream would be contain minimum item count of both streams
     */
    public static <T1, T2> Stream<Tuple2<T1, T2>> zip(Stream<? extends T1> stream1,
                                                      Stream<? extends T2> stream2,
                                                      boolean isParallel)
    {
        return zipWith(stream1, stream2, Tuple2::new, isParallel);
    }
    /**
     * Create new <code>Stream</code> of <code>Tuple2</code> based on zip of two source streams.
     *
     * @param stream1 - first stream
     * @param stream2 - second stream
     * @param <T1> - type of items of the first stream
     * @param <T2>- type of items of the second stream
     * @return <code>Stream&ltT1, T2&gt</code> object
     *
     * @note If source streams have different count of items
     * then result stream would be contain minimum item count of both streams
     */
    public static <T1, T2> Stream<Tuple2<T1, T2>> zip(Stream<? extends T1> stream1,
                                                      Stream<? extends T2> stream2)
    {
        return zipWith(stream1, stream2, Tuple2::new, false);
    }
    /**
     * Create new <code>Stream</code> of <code>Tuple2</code> based on zip of two source collections.
     *
     * @param collection1 - first collection
     * @param collection2 - second collection
     * @param isParallel - use parallel processing of collections
     * @param <T1> - type of items of the first collection
     * @param <T2>- type of items of the second collection
     * @return <code>Stream&ltT1, T2&gt</code> object
     *
     * @note If source collections have different size
     * then result stream would be contain minimum size of both collections
     */
    public static <T1, T2> Stream<Tuple2<T1, T2>> zip(Collection<? extends T1> collection1,
                                                      Collection<? extends T2> collection2,
                                                      boolean isParallel)
    {
        return zipWith(collection1.stream(), collection2.stream(), Tuple2::new, isParallel);
    }

    public static <T1, T2> Stream<Tuple2<T1, T2>> zip(Collection<? extends T1> collection1,
                                                      Collection<? extends T2> collection2)
    {
        return zipWith(collection1.stream(), collection2.stream(), Tuple2::new, false);
    }

    /**
     * Unzip stream of tuple to tuple of stream
     * @param stream - stream of tuple
     * @param <T1> - type of first item
     * @param <T2> - type of the second item
     * @return tuple of two streams
     */
    public static <T1, T2> Tuple2<Stream<T1>, Stream<T2>> unzip(Stream<Tuple2<? extends T1, ? extends T2>> stream)
    {
        Objects.requireNonNull(stream);
        return Tuple2.of(stream.map(Tuple2::t1), stream.map(Tuple2::t2));
    }

    /**
     * Parts of stream on tuple of stream.
     * First item of tuple - stream with items that accepts of predicate
     * Second item of tuple - stream with items that does not accept of predicate
     * @param stream - source stream
     * @param predicate - predicate
     * @param <T> - type of source stream
     * @return tuple of streams
     */
    public static <T> Tuple2<Stream<? extends T>, Stream<? extends T>> partition(Stream<? extends T> stream, Predicate<? super T> predicate)
    {
        Objects.requireNonNull(stream);
        Objects.requireNonNull(predicate);
        return Tuple2.of(stream.filter(predicate), stream.filter(t -> !predicate.test(t)));
    }

    /**
     * Create new <code>Stream</code> object based on zip of 3 source streams.
     * Each stream is iterated sequentially and for tuple of elements
     * from all streams is applied <code>mapper</code> function
     * that generates new element of result stream
     *
     * @param stream1 - first stream
     * @param stream2 - second stream
     * @param stream3 - third stream
     * @param mapper  - function that transform pair of items from all streams to new item of result stream
     * @param isParallel - use parallel processing of streams
     * @param <T1> - type of items of the first stream
     * @param <T2> - type of items of the second stream
     * @param <T3> - type of items of the third stream
     * @param <R>  - type of items of the result stream
     * @return <code>Stream</code> object
     *
     * @note If source streams have different count of items
     * then result stream would be contain minimum item count of all streams
     */
    public static <T1, T2, T3, R> Stream<R> zipWith(Stream<? extends T1> stream1,
                                                    Stream<? extends T2> stream2,
                                                    Stream<? extends T3> stream3,
                                                    Function3<? super T1, ? super  T2, ? super  T3, R> mapper,
                                                    boolean isParallel)
    {
        final Iterator<? extends T1> iterator1 = stream1.iterator();
        final Iterator<? extends T2> iterator2 = stream2.iterator();
        final Iterator<? extends T3> iterator3 = stream3.iterator();

        final Iterable<R> iterable = () -> new Iterator<R>() {
            @Override
            public boolean hasNext() {
                return iterator1.hasNext() && iterator2.hasNext() && iterator3.hasNext();
            }

            @Override
            public R next() {
                return mapper.apply(iterator1.next(), iterator2.next(), iterator3.next());
            }
        };

        return StreamSupport.stream(iterable.spliterator(), isParallel);
    }
    /**
     * Create new <code>Stream</code> object based on zip of 3 source streams.
     * Each stream is iterated sequentially and for tuple of elements
     * from all streams is applied <code>mapper</code> function
     * that generates new element of result stream
     *
     * @param stream1 - first stream
     * @param stream2 - second stream
     * @param stream3 - third stream
     * @param mapper  - function that transform pair of items from all streams to new item of result stream
     * @param <T1> - type of items of the first stream
     * @param <T2> - type of items of the second stream
     * @param <T3> - type of items of the third stream
     * @param <R>  - type of items of the result stream
     * @return <code>Stream</code> object
     *
     * @note If source streams have different count of items
     * then result stream would be contain minimum item count of all streams
     */
    public static <T1, T2, T3, R> Stream<R> zipWith(Stream<? extends T1> stream1,
                                                    Stream<? extends T2> stream2,
                                                    Stream<? extends T3> stream3,
                                                    Function3<? super T1, ? super  T2, ? super  T3, R> mapper)
    {
        return zipWith(stream1, stream2, stream3, mapper, false);
    }
    /**
     * Create new <code>Stream</code> object based on zip of 3 source collections.
     *
     * @param collection1 - first collection
     * @param collection2 - second collection
     * @param collection3 - third collection
     * @param mapper  - function that transform pair of items from all collections to new item of result stream
     * @param isParallel - use parallel processing of collections
     * @param <T1> - type of items of the first collection
     * @param <T2> - type of items of the second collection
     * @param <T3> - type of items of the third collection
     * @param <R>  - type of items of the result collection
     * @return <code>Stream</code> object
     *
     * @note If source collections have different count of items
     * then result stream would be contain minimum item count of all streams
     */
    public static <T1, T2, T3, R> Stream<R> zipWith(Collection<? extends T1> collection1,
                                                    Collection<? extends T2> collection2,
                                                    Collection<? extends T3> collection3,
                                                    Function3<? super T1, ? super  T2, ? super  T3, R> mapper,
                                                    boolean isParallel)
    {
        return zipWith(collection1.stream(), collection2.stream(), collection3.stream(), mapper, isParallel);
    }
    /**
     * Create new <code>Stream</code> object based on zip of 3 source collections.
     *
     * @param collection1 - first collection
     * @param collection2 - second collection
     * @param collection3 - third collection
     * @param mapper  - function that transform pair of items from all collections to new item of result stream
     * @param <T1> - type of items of the first collection
     * @param <T2> - type of items of the second collection
     * @param <T3> - type of items of the third collection
     * @param <R>  - type of items of the result stream
     * @return <code>Stream</code> object
     *
     * @note If source collections have different count of items
     * then result stream would be contain minimum item count of all streams
     */
    public static <T1, T2, T3, R> Stream<R> zipWith(Collection<? extends T1> collection1,
                                                    Collection<? extends T2> collection2,
                                                    Collection<? extends T3> collection3,
                                                    Function3<? super T1, ? super  T2, ? super  T3, R> mapper)
    {
        return zipWith(collection1.stream(), collection2.stream(), collection3.stream(), mapper, false);
    }
    /**
     * Create new <code>Stream</code> of <code>Tuple3</code> objects based on zip of 3 source streams.
     * Each stream is iterated sequentially and for tuple of elements
     * from all streams would be create <code>Tuple3</code> object
     *
     * @param stream1 - first stream
     * @param stream2 - second stream
     * @param stream3 - third stream
     * @param isParallel - use parallel processing of streams
     * @param <T1> - type of items of the first stream
     * @param <T2> - type of items of the second stream
     * @param <T3> - type of items of the third stream
     * @return <code>Stream&ltT1, T2, T3&gt</code> object
     *
     * @note If source streams have different count of items
     * then result stream would be contain minimum item count of all streams
     */
    public static <T1, T2, T3> Stream<Tuple3<T1, T2, T3>> zip(
            Stream<? extends T1> stream1,
            Stream<? extends T2> stream2,
            Stream<? extends T3> stream3,
            boolean isParallel)
    {
        return zipWith(stream1, stream2, stream3, Tuple3::new, isParallel);
    }
    /**
     * Create new <code>Stream</code> of <code>Tuple3</code> objects based on zip of 3 source streams.
     * Each stream is iterated sequentially and for tuple of elements
     * from all streams would be create <code>Tuple3</code> object
     *
     * @param stream1 - first stream
     * @param stream2 - second stream
     * @param stream3 - third stream
     * @param <T1> - type of items of the first stream
     * @param <T2> - type of items of the second stream
     * @param <T3> - type of items of the third stream
     * @return <code>Stream&ltT1, T2, T3&gt</code> object
     *
     * @note If source streams have different count of items
     * then result stream would be contain minimum item count of all streams
     */
    public static <T1, T2, T3> Stream<Tuple3<T1, T2, T3>> zip(
            Stream<? extends T1> stream1,
            Stream<? extends T2> stream2,
            Stream<? extends T3> stream3)
    {
        return zipWith(stream1, stream2, stream3, Tuple3::new, false);
    }
    /**
     * Create new <code>Stream</code> of <code>Tuple3</code> objects based on zip of 3 source collections.
     * Each collection is iterated sequentially and for tuple of elements
     * from all collections would be create <code>Tuple3</code> object
     *
     * @param collection1 - first collection
     * @param collection2 - second collection
     * @param collection3 - third collection
     * @param isParallel - use parallel processing of collections
     * @param <T1> - type of items of the first stream
     * @param <T2> - type of items of the second stream
     * @param <T3> - type of items of the third stream
     * @return <code>Stream&ltT1, T2, T3&gt</code> object
     *
     * @note If source streams have different count of items
     * then result stream would be contain minimum item count of all streams
     */
    public static <T1, T2, T3> Stream<Tuple3<T1, T2, T3>> zip(
            Collection<? extends T1> collection1,
            Collection<? extends T2> collection2,
            Collection<? extends T3> collection3,
            boolean isParallel)
    {
        return zipWith(
                collection1.stream(),
                collection2.stream(),
                collection3.stream(),
                Tuple3::new,
                isParallel
        );
    }
    /**
     * Create new <code>Stream</code> of <code>Tuple3</code> objects based on zip of 3 source collections.
     * Each collection is iterated sequentially and for tuple of elements
     * from all collections would be create <code>Tuple3</code> object
     *
     * @param collection1 - first collection
     * @param collection2 - second collection
     * @param collection3 - third collection
     * @param <T1> - type of items of the first stream
     * @param <T2> - type of items of the second stream
     * @param <T3> - type of items of the third stream
     * @return <code>Stream&ltT1, T2, T3&gt</code> object
     *
     * @note If source streams have different count of items
     * then result stream would be contain minimum item count of all streams
     */
    public static <T1, T2, T3> Stream<Tuple3<T1, T2, T3>> zip(
            Collection<? extends T1> collection1,
            Collection<? extends T2> collection2,
            Collection<? extends T3> collection3)
    {
        return zipWith(
                collection1.stream(),
                collection2.stream(),
                collection3.stream(),
                Tuple3::new,
                false
        );
    }
    /**
     * Create new <code>Stream</code> object based on zip of 4 source streams.
     * Each stream is iterated sequentially and for tuple of elements
     * from all streams is applied <code>mapper</code> function
     * that generates new element of result stream
     *
     * @param stream1 - first stream
     * @param stream2 - second stream
     * @param stream3 - third stream
     * @param stream4 - forth stream
     * @param mapper  - function that transform pair of items from all streams to new item of result stream
     * @param isParallel - use parallel processing of streams
     * @param <T1> - type of items of the first stream
     * @param <T2> - type of items of the second stream
     * @param <T3> - type of items of the third stream
     * @param <T4> - type of items of the forth stream
     * @param <R>  - type of items of the result stream
     * @return <code>Stream</code> object
     *
     * @note If source streams have different count of items
     * then result stream would be contain minimum item count of all streams
     */
    public static <T1, T2, T3, T4, R> Stream<R> zipWith(Stream<? extends T1> stream1,
                                                    Stream<? extends T2> stream2,
                                                    Stream<? extends T3> stream3,
                                                    Stream<? extends T4> stream4,
                                                    Function4<? super T1, ? super  T2, ? super  T3,? super  T4, R> mapper,
                                                    boolean isParallel)
    {
        final Iterator<? extends T1> iterator1 = stream1.iterator();
        final Iterator<? extends T2> iterator2 = stream2.iterator();
        final Iterator<? extends T3> iterator3 = stream3.iterator();
        final Iterator<? extends T4> iterator4 = stream4.iterator();

        final Iterable<R> iterable = () -> new Iterator<R>() {
            @Override
            public boolean hasNext() {
                return iterator1.hasNext()
                       && iterator2.hasNext()
                       && iterator3.hasNext()
                       && iterator4.hasNext();
            }

            @Override
            public R next() {
                return mapper.apply(
                        iterator1.next(),
                        iterator2.next(),
                        iterator3.next(),
                        iterator4.next()
                );
            }
        };

        return StreamSupport.stream(iterable.spliterator(), isParallel);
    }
    /**
     * Create new <code>Stream</code> object based on zip of 4 source streams.
     * Each stream is iterated sequentially and for tuple of elements
     * from all streams is applied <code>mapper</code> function
     * that generates new element of result stream
     *
     * @param stream1 - first stream
     * @param stream2 - second stream
     * @param stream3 - third stream
     * @param stream4 - forth stream
     * @param mapper  - function that transform pair of items from all streams to new item of result stream
     * @param <T1> - type of items of the first stream
     * @param <T2> - type of items of the second stream
     * @param <T3> - type of items of the third stream
     * @param <T4> - type of items of the forth stream
     * @param <R>  - type of items of the result stream
     * @return <code>Stream</code> object
     *
     * @note If source streams have different count of items
     * then result stream would be contain minimum item count of all streams
     */
    public static <T1, T2, T3, T4, R> Stream<R> zipWith(Stream<? extends T1> stream1,
                                                        Stream<? extends T2> stream2,
                                                        Stream<? extends T3> stream3,
                                                        Stream<? extends T4> stream4,
                                                        Function4<? super T1, ? super  T2, ? super  T3,? super  T4, R> mapper)
    {
        return zipWith(stream1, stream2, stream3, stream4, mapper, false);
    }
    /**
     * Create new <code>Stream</code> of <code>Tuple4</code> objects based on zip of 4 source streams.
     * Each stream is iterated sequentially and for tuple of elements
     * from all streams would be created <code>Tuple4</code> object of the result stream
     *
     * @param stream1 - first stream
     * @param stream2 - second stream
     * @param stream3 - third stream
     * @param stream4 - forth stream
     * @param isParallel - use parallel processing of streams
     * @param <T1> - type of items of the first stream
     * @param <T2> - type of items of the second stream
     * @param <T3> - type of items of the third stream
     * @param <T4> - type of items of the forth stream
     * @return <code>Stream&ltT1, T2, T3, T4&gt</code> object
     *
     * @note If source streams have different count of items
     * then result stream would be contain minimum item count of all streams
     */
    public static <T1, T2, T3, T4> Stream<Tuple4<T1, T2, T3, T4>> zip(
            Stream<? extends T1> stream1,
            Stream<? extends T2> stream2,
            Stream<? extends T3> stream3,
            Stream<? extends T4> stream4,
            boolean isParallel)
    {
        return zipWith(stream1, stream2, stream3, stream4, Tuple4::new, isParallel);
    }
    /**
     * Create new <code>Stream</code> of <code>Tuple4</code> objects based on zip of 4 source streams.
     * Each stream is iterated sequentially and for tuple of elements
     * from all streams would be created <code>Tuple4</code> object of the result stream
     *
     * @param stream1 - first stream
     * @param stream2 - second stream
     * @param stream3 - third stream
     * @param stream4 - forth stream
     * @param <T1> - type of items of the first stream
     * @param <T2> - type of items of the second stream
     * @param <T3> - type of items of the third stream
     * @param <T4> - type of items of the forth stream
     * @return <code>Stream&ltT1, T2, T3, T4&gt</code> object
     *
     * @note If source streams have different count of items
     * then result stream would be contain minimum item count of all streams
     */
    public static <T1, T2, T3, T4> Stream<Tuple4<T1, T2, T3, T4>> zip(
            Stream<? extends T1> stream1,
            Stream<? extends T2> stream2,
            Stream<? extends T3> stream3,
            Stream<? extends T4> stream4)
    {
        return zipWith(stream1, stream2, stream3, stream4, Tuple4::new, false);
    }
    /**
     * Create new <code>Stream</code> object based on zip of 5 source streams.
     * Each stream is iterated sequentially and for tuple of elements
     * from all streams is applied <code>mapper</code> function
     * that generates new element of result stream
     *
     * @param stream1 - first stream
     * @param stream2 - second stream
     * @param stream3 - third stream
     * @param stream4 - forth stream
     * @param mapper  - function that transform pair of items from all streams to new item of result stream
     * @param isParallel - use parallel processing of streams
     * @param <T1> - type of items of the first stream
     * @param <T2> - type of items of the second stream
     * @param <T3> - type of items of the third stream
     * @param <T4> - type of items of the forth stream
     * @param <T5> - type of items of the fifth stream
     * @param <R>  - type of items of the result stream
     * @return <code>Stream</code> object
     *
     * @note If source streams have different count of items
     * then result stream would be contain minimum item count of all streams
     */
    public static <T1, T2, T3, T4, T5, R> Stream<R> zipWith(Stream<? extends T1> stream1,
                                                        Stream<? extends T2> stream2,
                                                        Stream<? extends T3> stream3,
                                                        Stream<? extends T4> stream4,
                                                        Stream<? extends T5> stream5,
                                                        Function5<? super T1, ? super  T2, ? super  T3, ? super  T4, ? super  T5, R> mapper,
                                                        boolean isParallel)
    {
        final Iterator<? extends T1> iterator1 = stream1.iterator();
        final Iterator<? extends T2> iterator2 = stream2.iterator();
        final Iterator<? extends T3> iterator3 = stream3.iterator();
        final Iterator<? extends T4> iterator4 = stream4.iterator();
        final Iterator<? extends T5> iterator5 = stream5.iterator();

        final Iterable<R> iterable = () -> new Iterator<R>() {
            @Override
            public boolean hasNext() {
                return iterator1.hasNext()
                        && iterator2.hasNext()
                        && iterator3.hasNext()
                        && iterator4.hasNext()
                        && iterator5.hasNext();
            }

            @Override
            public R next() {
                return mapper.apply(
                        iterator1.next(),
                        iterator2.next(),
                        iterator3.next(),
                        iterator4.next(),
                        iterator5.next()
                );
            }
        };

        return StreamSupport.stream(iterable.spliterator(), isParallel);
    }
    /**
     * Create new <code>Stream</code> object based on zip of 5 source streams.
     * Each stream is iterated sequentially and for tuple of elements
     * from all streams is applied <code>mapper</code> function
     * that generates new element of result stream
     *
     * @param stream1 - first stream
     * @param stream2 - second stream
     * @param stream3 - third stream
     * @param stream4 - forth stream
     * @param mapper  - function that transform pair of items from all streams to new item of result stream
     * @param <T1> - type of items of the first stream
     * @param <T2> - type of items of the second stream
     * @param <T3> - type of items of the third stream
     * @param <T4> - type of items of the forth stream
     * @param <T5> - type of items of the fifth stream
     * @param <R>  - type of items of the result stream
     * @return <code>Stream</code> object
     *
     * @note If source streams have different count of items
     * then result stream would be contain minimum item count of all streams
     */
    public static <T1, T2, T3, T4, T5, R> Stream<R> zipWith(Stream<? extends T1> stream1,
                                                            Stream<? extends T2> stream2,
                                                            Stream<? extends T3> stream3,
                                                            Stream<? extends T4> stream4,
                                                            Stream<? extends T5> stream5,
                                                            Function5<? super T1, ? super  T2, ? super  T3, ? super  T4, ? super  T5, R> mapper)
    {
        return zipWith(stream1, stream2, stream3, stream4, stream5, mapper, false);
    }
    /**
     * Create new <code>Stream</code> object based on zip of 5 source streams.
     * Each stream is iterated sequentially and for tuple of elements
     * from all streams would be created <code>Tuple5</code> object of result stream
     *
     * @param stream1 - first stream
     * @param stream2 - second stream
     * @param stream3 - third stream
     * @param stream4 - forth stream
     * @param isParallel - use parallel processing of streams
     * @param <T1> - type of items of the first stream
     * @param <T2> - type of items of the second stream
     * @param <T3> - type of items of the third stream
     * @param <T4> - type of items of the forth stream
     * @param <T5> - type of items of the fifth stream
     * @return <code>Stream&ltT1,T2,T3,T4,T5&gt</code> object
     *
     * @note If source streams have different count of items
     * then result stream would be contain minimum item count of all streams
     */
    public static <T1, T2, T3, T4, T5> Stream<Tuple5<T1, T2, T3, T4, T5>> zip(
                                                           Stream<? extends T1> stream1,
                                                           Stream<? extends T2> stream2,
                                                           Stream<? extends T3> stream3,
                                                           Stream<? extends T4> stream4,
                                                           Stream<? extends T5> stream5,
                                                           boolean isParallel)
    {
        return zipWith(stream1, stream2, stream3, stream4, stream5, Tuple5::new, isParallel);
    }
    /**
     * Create new <code>Stream</code> object based on zip of 5 source streams.
     * Each stream is iterated sequentially and for tuple of elements
     * from all streams would be created <code>Tuple5</code> object of result stream
     *
     * @param stream1 - first stream
     * @param stream2 - second stream
     * @param stream3 - third stream
     * @param stream4 - forth stream
     * @param <T1> - type of items of the first stream
     * @param <T2> - type of items of the second stream
     * @param <T3> - type of items of the third stream
     * @param <T4> - type of items of the forth stream
     * @param <T5> - type of items of the fifth stream
     * @return <code>Stream&ltT1,T2,T3,T4,T5&gt</code> object
     *
     * @note If source streams have different count of items
     * then result stream would be contain minimum item count of all streams
     */
    public static <T1, T2, T3, T4, T5> Stream<Tuple5<T1, T2, T3, T4, T5>> zip(
            Stream<? extends T1> stream1,
            Stream<? extends T2> stream2,
            Stream<? extends T3> stream3,
            Stream<? extends T4> stream4,
            Stream<? extends T5> stream5)
    {
        return zipWith(stream1, stream2, stream3, stream4, stream5, Tuple5::new, false);
    }
}
