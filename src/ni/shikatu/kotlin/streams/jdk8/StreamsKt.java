package ni.shikatu.kotlin.streams.jdk8;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.sequences.Sequence;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u001a.\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u001a\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001*\u00020\bH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u001a\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\t0\u0001*\u00020\nH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u001a\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001*\u00020\fH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u001a.\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u001a.\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u001a\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f*\u00020\bH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u001a\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000f*\u00020\nH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u001a\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f*\u00020\fH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¨\u0006\u0010"}, d2 = {"asSequence", "Lni/shikatu/kotlin/sequences/Sequence;", "T", "Ljava/util/stream/Stream;", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.2", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/util/stream/IntStream;", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/util/stream/LongStream;", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/util/stream/DoubleStream;", "asStream", "toList", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib-jdk8"}, k = 2, mv = {2, 4, 0}, pn = "ni.shikatu.kotlin.streams", xi = 48)
public final class StreamsKt {
    public static final <T> Sequence<T> asSequence(final Stream<T> stream) {
        Intrinsics.checkNotNullParameter(stream, "<this>");
        return new Sequence<T>() {
            @Override
            public Iterator<T> iterator() {
                Iterator<T> it = stream.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                return it;
            }
        };
    }

    public static final Sequence<Integer> asSequence(final IntStream $this$asSequence) {
        Intrinsics.checkNotNullParameter($this$asSequence, "<this>");
        return new Sequence<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                Iterator<Integer> it = $this$asSequence.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                return it;
            }
        };
    }

    public static final Sequence<Long> asSequence(final LongStream $this$asSequence) {
        Intrinsics.checkNotNullParameter($this$asSequence, "<this>");
        return new Sequence<Long>() {
            @Override
            public Iterator<Long> iterator() {
                Iterator<Long> it = $this$asSequence.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                return it;
            }
        };
    }

    public static final Sequence<Double> asSequence(final DoubleStream $this$asSequence) {
        Intrinsics.checkNotNullParameter($this$asSequence, "<this>");
        return new Sequence<Double>() {
            @Override
            public Iterator<Double> iterator() {
                Iterator<Double> it = $this$asSequence.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                return it;
            }
        };
    }

    public static final <T> Stream<T> asStream(final Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Stream<T> stream = StreamSupport.stream(new Supplier() {
            @Override
            public final Object get() {
                return StreamsKt.asStream$lambda$0(sequence);
            }
        }, 16, false);
        Intrinsics.checkNotNullExpressionValue(stream, "stream(...)");
        return stream;
    }

    public static final Spliterator asStream$lambda$0(Sequence $this_asStream) {
        return Spliterators.spliteratorUnknownSize($this_asStream.iterator(), 16);
    }

    public static final <T> List<T> toList(Stream<T> stream) {
        Intrinsics.checkNotNullParameter(stream, "<this>");
        Object objCollect = stream.collect(Collectors.toList());
        Intrinsics.checkNotNullExpressionValue(objCollect, "collect(...)");
        return (List) objCollect;
    }

    public static final List<Integer> toList(IntStream $this$toList) {
        Intrinsics.checkNotNullParameter($this$toList, "<this>");
        int[] array = $this$toList.toArray();
        Intrinsics.checkNotNullExpressionValue(array, "toArray(...)");
        return ArraysKt.asList(array);
    }

    public static final List<Long> toList(LongStream $this$toList) {
        Intrinsics.checkNotNullParameter($this$toList, "<this>");
        long[] array = $this$toList.toArray();
        Intrinsics.checkNotNullExpressionValue(array, "toArray(...)");
        return ArraysKt.asList(array);
    }

    public static final List<Double> toList(DoubleStream $this$toList) {
        Intrinsics.checkNotNullParameter($this$toList, "<this>");
        double[] array = $this$toList.toArray();
        Intrinsics.checkNotNullExpressionValue(array, "toArray(...)");
        return ArraysKt.asList(array);
    }
}
