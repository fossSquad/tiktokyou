package ni.shikatu.kotlin.random;

import java.io.Serializable;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.internal.PlatformImplementationsKt;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\b'\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u000bH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u000fH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u0005H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0005H\u0016¨\u0006\u0019"}, d2 = {"Lni/shikatu/kotlin/random/Random;", "", "<init>", "()V", "nextBits", "", "bitCount", "nextInt", "until", "from", "nextLong", "", "nextBoolean", "", "nextDouble", "", "nextFloat", "", "nextBytes", "", "array", "fromIndex", "toIndex", "size", "Default", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class Random {
    public static final Default Default = new Default(null);
    private static final Random defaultRandom = PlatformImplementationsKt.IMPLEMENTATIONS.defaultPlatformRandom();

    public abstract int nextBits(int i);

    public int nextInt() {
        return nextBits(32);
    }

    public int nextInt(int until) {
        return nextInt(0, until);
    }

    public int nextInt(int from, int until) {
        int bits;
        int v;
        int bitCount;
        int rnd;
        boolean z;
        RandomKt.checkRangeBounds(from, until);
        int n = until - from;
        if (n <= 0 && n != Integer.MIN_VALUE) {
            do {
                rnd = nextInt();
                z = false;
                if (from <= rnd && rnd < until) {
                    z = true;
                }
            } while (!z);
            return rnd;
        }
        if (((-n) & n) == n) {
            int bitCount2 = RandomKt.fastLog2(n);
            bitCount = nextBits(bitCount2);
        } else {
            do {
                bits = nextInt() >>> 1;
                v = bits % n;
            } while ((bits - v) + (n - 1) < 0);
            bitCount = v;
        }
        return from + bitCount;
    }

    public long nextLong() {
        return (((long) nextInt()) << 32) + ((long) nextInt());
    }

    public long nextLong(long until) {
        return nextLong(0L, until);
    }

    public long nextLong(long from, long until) {
        long rnd;
        boolean z;
        long bits;
        long v;
        RandomKt.checkRangeBounds(from, until);
        long n = until - from;
        if (n <= 0) {
            do {
                rnd = nextLong();
                z = false;
                if (from <= rnd && rnd < until) {
                    z = true;
                }
            } while (!z);
            return rnd;
        }
        if (((-n) & n) == n) {
            int nLow = (int) n;
            int nHigh = (int) (n >>> 32);
            if (nLow != 0) {
                int bitCount = RandomKt.fastLog2(nLow);
                v = 4294967295L & ((long) nextBits(bitCount));
            } else if (nHigh == 1) {
                v = 4294967295L & ((long) nextInt());
            } else {
                int bitCount2 = RandomKt.fastLog2(nHigh);
                v = (4294967295L & ((long) nextInt())) + (((long) nextBits(bitCount2)) << 32);
            }
        } else {
            do {
                bits = nextLong() >>> 1;
                v = bits % n;
            } while ((bits - v) + (n - 1) < 0);
        }
        return from + v;
    }

    public boolean nextBoolean() {
        return nextBits(1) != 0;
    }

    public double nextDouble() {
        return PlatformRandomKt.doubleFromParts(nextBits(26), nextBits(27));
    }

    public double nextDouble(double until) {
        return nextDouble(0.0d, until);
    }

    public double nextDouble(double from, double until) {
        double r;
        RandomKt.checkRangeBounds(from, until);
        double size = until - from;
        if (Double.isInfinite(size)) {
            if ((Double.isInfinite(from) || Double.isNaN(from)) ? false : true) {
                if ((Double.isInfinite(until) || Double.isNaN(until)) ? false : true) {
                    double d = 2;
                    double r1 = nextDouble() * ((until / d) - (from / d));
                    r = from + r1 + r1;
                } else {
                    r = from + (nextDouble() * size);
                }
            } else {
                r = from + (nextDouble() * size);
            }
        } else {
            r = from + (nextDouble() * size);
        }
        return r >= until ? Math.nextAfter(until, Double.NEGATIVE_INFINITY) : r;
    }

    public float nextFloat() {
        return nextBits(24) / 1.6777216E7f;
    }

    public static  byte[] nextBytes$default(Random random, byte[] bArr, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: nextBytes");
        }
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return random.nextBytes(bArr, i, i2);
    }

    public byte[] nextBytes(byte[] array, int fromIndex, int toIndex) {
        boolean z;
        Intrinsics.checkNotNullParameter(array, "array");
        if (!(fromIndex >= 0 && fromIndex <= array.length)) {
            z = false;
        } else if (toIndex >= 0 && toIndex <= array.length) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            throw new IllegalArgumentException(("fromIndex (" + fromIndex + ") or toIndex (" + toIndex + ") are out of range: 0.." + array.length + '.').toString());
        }
        if (!(fromIndex <= toIndex)) {
            throw new IllegalArgumentException(("fromIndex (" + fromIndex + ") must be not greater than toIndex (" + toIndex + ").").toString());
        }
        int steps = (toIndex - fromIndex) / 4;
        int position = fromIndex;
        for (int i = 0; i < steps; i++) {
            int v = nextInt();
            array[position] = (byte) v;
            array[position + 1] = (byte) (v >>> 8);
            array[position + 2] = (byte) (v >>> 16);
            array[position + 3] = (byte) (v >>> 24);
            position += 4;
        }
        int remainder = toIndex - position;
        int vr = nextBits(remainder * 8);
        for (int i2 = 0; i2 < remainder; i2++) {
            array[position + i2] = (byte) (vr >>> (i2 * 8));
        }
        return array;
    }

    public byte[] nextBytes(byte[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return nextBytes(array, 0, array.length);
    }

    public byte[] nextBytes(int size) {
        return nextBytes(new byte[size]);
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001\u001dB\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0010H\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u0014H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\nH\u0016J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0016R\u000e\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lni/shikatu/kotlin/random/Random$Default;", "Lni/shikatu/kotlin/random/Random;", "Ljava/io/Serializable;", "Lni/shikatu/kotlin/io/Serializable;", "<init>", "()V", "defaultRandom", "writeReplace", "", "nextBits", "", "bitCount", "nextInt", "until", "from", "nextLong", "", "nextBoolean", "", "nextDouble", "", "nextFloat", "", "nextBytes", "", "array", "size", "fromIndex", "toIndex", "Serialized", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Default extends Random implements Serializable {
        public  Default(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Default() {
        }

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\bÂ\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lni/shikatu/kotlin/random/Random$Default$Serialized;", "Ljava/io/Serializable;", "Lni/shikatu/kotlin/io/Serializable;", "<init>", "()V", "serialVersionUID", "", "readResolve", "", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
        private static final class Serialized implements Serializable {
            public static final Serialized INSTANCE = new Serialized();
            private static final long serialVersionUID = 0;

            private Serialized() {
            }

            private final Object readResolve() {
                return Random.Default;
            }
        }

        private final Object writeReplace() {
            return Serialized.INSTANCE;
        }

        @Override
        public int nextBits(int bitCount) {
            return Random.defaultRandom.nextBits(bitCount);
        }

        @Override
        public int nextInt() {
            return Random.defaultRandom.nextInt();
        }

        @Override
        public int nextInt(int until) {
            return Random.defaultRandom.nextInt(until);
        }

        @Override
        public int nextInt(int from, int until) {
            return Random.defaultRandom.nextInt(from, until);
        }

        @Override
        public long nextLong() {
            return Random.defaultRandom.nextLong();
        }

        @Override
        public long nextLong(long until) {
            return Random.defaultRandom.nextLong(until);
        }

        @Override
        public long nextLong(long from, long until) {
            return Random.defaultRandom.nextLong(from, until);
        }

        @Override
        public boolean nextBoolean() {
            return Random.defaultRandom.nextBoolean();
        }

        @Override
        public double nextDouble() {
            return Random.defaultRandom.nextDouble();
        }

        @Override
        public double nextDouble(double until) {
            return Random.defaultRandom.nextDouble(until);
        }

        @Override
        public double nextDouble(double from, double until) {
            return Random.defaultRandom.nextDouble(from, until);
        }

        @Override
        public float nextFloat() {
            return Random.defaultRandom.nextFloat();
        }

        @Override
        public byte[] nextBytes(byte[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            return Random.defaultRandom.nextBytes(array);
        }

        @Override
        public byte[] nextBytes(int size) {
            return Random.defaultRandom.nextBytes(size);
        }

        @Override
        public byte[] nextBytes(byte[] array, int fromIndex, int toIndex) {
            Intrinsics.checkNotNullParameter(array, "array");
            return Random.defaultRandom.nextBytes(array, fromIndex, toIndex);
        }
    }
}
