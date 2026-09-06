package ni.shikatu.okhttp3.internal;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Field;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.collections.IntIterator;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.InlineMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.LongCompanionObject;
import ni.shikatu.kotlin.jvm.internal.StringCompanionObject;
import ni.shikatu.kotlin.ranges.RangesKt;
import ni.shikatu.kotlin.text.Charsets;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.kotlin.time.Duration;
import ni.shikatu.kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import ni.shikatu.okhttp3.Call;
import ni.shikatu.okhttp3.Dispatcher;
import ni.shikatu.okhttp3.EventListener;
import ni.shikatu.okhttp3.Headers;
import ni.shikatu.okhttp3.HttpUrl;
import ni.shikatu.okhttp3.OkHttpClient;
import ni.shikatu.okhttp3.Response;
import ni.shikatu.okhttp3.internal.http2.Header;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.Buffer;
import ni.shikatu.okio.BufferedSource;
import ni.shikatu.okio.ByteString;
import ni.shikatu.okio.Source;

@Metadata(d1 = {"\u0000´\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u0016\u0010\b\u001a\u00020\u0005*\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0007H\u0000\u001a)\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r\"\u00020\u000eH\u0000¢\u0006\u0002\u0010\u000f\u001a\u0014\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0011H\u0000\u001a \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0000\u001a\u001f\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u001aH\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0012\u0010\u001d\u001a\u00020\u001e*\b\u0012\u0004\u0012\u00020 0\u001fH\u0000\u001a\u0012\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f*\u00020\u001eH\u0000\u001a\u0014\u0010\"\u001a\u00020\u0007*\u00020\t2\u0006\u0010#\u001a\u00020\tH\u0000\u001a\f\u0010$\u001a\u00020%*\u00020&H\u0000\u001a\u001c\u0010'\u001a\u00020\u0007*\u00020(2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u0019H\u0000\u001a\f\u0010'\u001a\u00020**\u00020\u0012H\u0000\u001a\u001c\u0010+\u001a\u00020\u0007*\u00020(2\u0006\u0010,\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u0019H\u0000\u001a\u0014\u0010-\u001a\u00020\u0007*\u00020.2\u0006\u0010/\u001a\u00020\u0012H\u0000\u001a\"\u00100\u001a\u00020*2\u0006\u0010\u0004\u001a\u00020\u00052\f\u00101\u001a\b\u0012\u0004\u0012\u00020*02H\u0080\bø\u0001\u0000\u001a\f\u00103\u001a\u00020\u0017*\u000204H\u0000\u001a\u001f\u00105\u001a\b\u0012\u0004\u0012\u0002H60\u001f\"\u0004\b\u0000\u00106*\b\u0012\u0004\u0012\u0002H60\u001fH\u0080\b\u001a\u001f\u00105\u001a\b\u0012\u0004\u0012\u0002H607\"\u0004\b\u0000\u00106*\b\u0012\u0004\u0012\u0002H607H\u0080\b\u001a1\u00105\u001a\u000e\u0012\u0004\u0012\u0002H9\u0012\u0004\u0012\u0002H:08\"\u0004\b\u0000\u00109\"\u0004\b\u0001\u0010:*\u000e\u0012\u0004\u0012\u0002H9\u0012\u0004\u0012\u0002H:08H\u0080\b\u001a\u001e\u0010;\u001a\b\u0012\u0004\u0012\u0002H60\u001f\"\u0004\b\u0000\u00106*\b\u0012\u0004\u0012\u0002H60\u001fH\u0000\u001a-\u0010<\u001a\b\u0012\u0004\u0012\u0002H60\u001f\"\u0004\b\u0000\u001062\u0012\u0010=\u001a\n\u0012\u0006\b\u0001\u0012\u0002H60\r\"\u0002H6H\u0001¢\u0006\u0002\u0010>\u001a'\u0010;\u001a\b\u0012\u0004\u0012\u0002H60\u001f\"\u0004\b\u0000\u00106*\f\u0012\u0006\b\u0001\u0012\u0002H6\u0018\u00010\rH\u0000¢\u0006\u0002\u0010>\u001a\f\u0010?\u001a\u00020**\u00020.H\u0000\u001a\f\u0010?\u001a\u00020**\u00020@H\u0000\u001a\f\u0010A\u001a\u00020\u0005*\u00020\u0017H\u0000\u001a\f\u0010A\u001a\u00020\u0005*\u00020\u0015H\u0000\u001a3\u0010B\u001a\u0004\u0018\u0001H6\"\u0004\b\u0000\u001062\u0006\u0010C\u001a\u00020\u000e2\f\u0010D\u001a\b\u0012\u0004\u0012\u0002H60E2\u0006\u0010F\u001a\u00020\u0005H\u0000¢\u0006\u0002\u0010G\u001a\f\u0010I\u001a\u00020**\u00020JH\u0000\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010H\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010K\u001a\u00020\u00058\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006L"}, d2 = {"UTC", "Ljava/util/TimeZone;", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "name", _UrlKt.FRAGMENT_ENCODE_SET, "daemon", _UrlKt.FRAGMENT_ENCODE_SET, "toHostHeader", "Lni/shikatu/okhttp3/HttpUrl;", "includeDefaultPort", "format", "args", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "readBomAsCharset", "Ljava/nio/charset/Charset;", "Lni/shikatu/okio/BufferedSource;", "default", "checkDuration", _UrlKt.FRAGMENT_ENCODE_SET, "duration", _UrlKt.FRAGMENT_ENCODE_SET, "unit", "Ljava/util/concurrent/TimeUnit;", "Lni/shikatu/kotlin/time/Duration;", "checkDuration-HG0u8IE", "(Ljava/lang/String;J)I", "toHeaders", "Lni/shikatu/okhttp3/Headers;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/internal/http2/Header;", "toHeaderList", "canReuseConnectionFor", "other", "asFactory", "Lni/shikatu/okhttp3/EventListener$Factory;", "Lni/shikatu/okhttp3/EventListener;", "skipAll", "Lni/shikatu/okio/Source;", "timeUnit", _UrlKt.FRAGMENT_ENCODE_SET, "discard", "timeout", "isHealthy", "Ljava/net/Socket;", "source", "threadName", "block", "Lni/shikatu/kotlin/Function0;", "headersContentLength", "Lni/shikatu/okhttp3/Response;", "unmodifiable", "T", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "K", "V", "toImmutableList", "immutableListOf", "elements", "([Ljava/lang/Object;)Ljava/util/List;", "closeQuietly", "Ljava/net/ServerSocket;", "toHexString", "readFieldOrNull", "instance", "fieldType", "Ljava/lang/Class;", "fieldName", "(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "assertionsEnabled", "assertLockNotHeld", "Lni/shikatu/okhttp3/Dispatcher;", "okHttpName", "okhttp"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class _UtilJvmKt {
    public static final TimeZone UTC;
    public static final boolean assertionsEnabled;
    public static final String okHttpName;

    static {
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        Intrinsics.checkNotNull(timeZone);
        UTC = timeZone;
        assertionsEnabled = false;
        String name = OkHttpClient.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        okHttpName = StringsKt.removeSuffix(StringsKt.removePrefix(name, (CharSequence) "ni.shikatu.okhttp3."), (CharSequence) "Client");
    }

    public static final ThreadFactory threadFactory(final String name, final boolean daemon) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new ThreadFactory() {
            @Override
            public final Thread newThread(Runnable runnable) {
                return _UtilJvmKt.threadFactory$lambda$0(name, daemon, runnable);
            }
        };
    }

    public static final Thread threadFactory$lambda$0(String $name, boolean $daemon, Runnable runnable) {
        Thread $this$threadFactory_u24lambda_u240_u240 = new Thread(runnable, $name);
        $this$threadFactory_u24lambda_u240_u240.setDaemon($daemon);
        return $this$threadFactory_u24lambda_u240_u240;
    }

    public static  String toHostHeader$default(HttpUrl httpUrl, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return toHostHeader(httpUrl, z);
    }

    public static final String toHostHeader(HttpUrl $this$toHostHeader, boolean includeDefaultPort) {
        String host;
        Intrinsics.checkNotNullParameter($this$toHostHeader, "<this>");
        if (StringsKt.contains$default((CharSequence) $this$toHostHeader.host(), (CharSequence) ":", false, 2, (Object) null)) {
            host = AbstractJsonLexerKt.BEGIN_LIST + $this$toHostHeader.host() + AbstractJsonLexerKt.END_LIST;
        } else {
            host = $this$toHostHeader.host();
        }
        if (includeDefaultPort || $this$toHostHeader.port() != HttpUrl.Companion.defaultPort($this$toHostHeader.scheme())) {
            return host + AbstractJsonLexerKt.COLON + $this$toHostHeader.port();
        }
        return host;
    }

    public static final String format(String format, Object... args) {
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(args, "args");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Locale locale = Locale.US;
        Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
        String str = String.format(locale, format, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public static final Charset readBomAsCharset(BufferedSource $this$readBomAsCharset, Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter($this$readBomAsCharset, "<this>");
        Intrinsics.checkNotNullParameter(charset, "default");
        switch ($this$readBomAsCharset.select(_UtilCommonKt.getUNICODE_BOMS())) {
            case -1:
                return charset;
            case 0:
                return Charsets.UTF_8;
            case 1:
                return Charsets.UTF_16BE;
            case 2:
                return Charsets.INSTANCE.UTF32_LE();
            case 3:
                return Charsets.UTF_16LE;
            case 4:
                return Charsets.INSTANCE.UTF32_BE();
            default:
                throw new AssertionError();
        }
    }

    public static final int checkDuration(String name, long duration, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(unit, "unit");
        boolean z = true;
        if (!(duration >= 0)) {
            throw new IllegalStateException((name + " < 0").toString());
        }
        long millis = unit.toMillis(duration);
        if (!(millis <= 2147483647L)) {
            throw new IllegalArgumentException((name + " too large").toString());
        }
        if (millis == 0 && duration > 0) {
            z = false;
        }
        if (!z) {
            throw new IllegalArgumentException((name + " too small").toString());
        }
        return (int) millis;
    }

    public static final int m1736checkDurationHG0u8IE(String name, long j) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (Duration.m1411isNegativeimpl(j)) {
            throw new IllegalStateException((name + " < 0").toString());
        }
        long millis = Duration.m1396getInWholeMillisecondsimpl(j);
        boolean z = true;
        if (!(millis <= 2147483647L)) {
            throw new IllegalArgumentException((name + " too large").toString());
        }
        if (millis == 0 && Duration.m1412isPositiveimpl(j)) {
            z = false;
        }
        if (!z) {
            throw new IllegalArgumentException((name + " too small").toString());
        }
        return (int) millis;
    }

    public static final Headers toHeaders(List<Header> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Headers.Builder builder = new Headers.Builder();
        for (Header header : list) {
            ByteString name = header.component1();
            ByteString value = header.component2();
            builder.addLenient$okhttp(name.utf8(), value.utf8());
        }
        return builder.build();
    }

    public static final List<Header> toHeaderList(Headers $this$toHeaderList) {
        Intrinsics.checkNotNullParameter($this$toHeaderList, "<this>");
        Iterable $this$map$iv = RangesKt.until(0, $this$toHeaderList.size());
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        Iterator<Integer> it = $this$map$iv.iterator();
        while (it.hasNext()) {
            int item$iv$iv = ((IntIterator) it).nextInt();
            destination$iv$iv.add(new Header($this$toHeaderList.name(item$iv$iv), $this$toHeaderList.value(item$iv$iv)));
        }
        return (List) destination$iv$iv;
    }

    public static final boolean canReuseConnectionFor(HttpUrl $this$canReuseConnectionFor, HttpUrl other) {
        Intrinsics.checkNotNullParameter($this$canReuseConnectionFor, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return Intrinsics.areEqual($this$canReuseConnectionFor.host(), other.host()) && $this$canReuseConnectionFor.port() == other.port() && Intrinsics.areEqual($this$canReuseConnectionFor.scheme(), other.scheme());
    }

    public static final EventListener.Factory asFactory(final EventListener $this$asFactory) {
        Intrinsics.checkNotNullParameter($this$asFactory, "<this>");
        return new EventListener.Factory() {
            @Override
            public final EventListener create(Call call) {
                return _UtilJvmKt.asFactory$lambda$0($this$asFactory, call);
            }
        };
    }

    public static final EventListener asFactory$lambda$0(EventListener $this_asFactory, Call it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return $this_asFactory;
    }

    public static final boolean skipAll(Source $this$skipAll, int duration, TimeUnit timeUnit) throws IOException {
        long originalDurationNs;
        Intrinsics.checkNotNullParameter($this$skipAll, "<this>");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        long nowNs = System.nanoTime();
        if ($this$skipAll.timeout().hasDeadline()) {
            originalDurationNs = $this$skipAll.timeout().deadlineNanoTime() - nowNs;
        } else {
            originalDurationNs = Long.MAX_VALUE;
        }
        $this$skipAll.timeout().deadlineNanoTime(Math.min(originalDurationNs, timeUnit.toNanos(duration)) + nowNs);
        try {
            Buffer skipBuffer = new Buffer();
            while ($this$skipAll.read(skipBuffer, 8192L) != -1) {
                skipBuffer.clear();
            }
            if (originalDurationNs == LongCompanionObject.MAX_VALUE) {
                $this$skipAll.timeout().clearDeadline();
            } else {
                $this$skipAll.timeout().deadlineNanoTime(nowNs + originalDurationNs);
            }
            return true;
        } catch (InterruptedIOException e) {
            if (originalDurationNs == LongCompanionObject.MAX_VALUE) {
                $this$skipAll.timeout().clearDeadline();
            } else {
                $this$skipAll.timeout().deadlineNanoTime(nowNs + originalDurationNs);
            }
            return false;
        } catch (Throwable th) {
            if (originalDurationNs == LongCompanionObject.MAX_VALUE) {
                $this$skipAll.timeout().clearDeadline();
            } else {
                $this$skipAll.timeout().deadlineNanoTime(nowNs + originalDurationNs);
            }
            throw th;
        }
    }

    public static final void skipAll(BufferedSource $this$skipAll) throws IOException {
        Intrinsics.checkNotNullParameter($this$skipAll, "<this>");
        while (!$this$skipAll.exhausted()) {
            $this$skipAll.skip($this$skipAll.getBuffer().size());
        }
    }

    public static final boolean discard(Source $this$discard, int timeout, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter($this$discard, "<this>");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        try {
            return skipAll($this$discard, timeout, timeUnit);
        } catch (IOException e) {
            return false;
        }
    }

    public static final boolean isHealthy(Socket $this$isHealthy, BufferedSource source) {
        Intrinsics.checkNotNullParameter($this$isHealthy, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        try {
            int readTimeout = $this$isHealthy.getSoTimeout();
            try {
                $this$isHealthy.setSoTimeout(1);
                return !source.exhausted();
            } finally {
                $this$isHealthy.setSoTimeout(readTimeout);
            }
        } catch (SocketTimeoutException e) {
            return true;
        } catch (IOException e2) {
            return false;
        }
    }

    public static final void threadName(String name, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(function0, "block");
        Thread currentThread = Thread.currentThread();
        String oldName = currentThread.getName();
        currentThread.setName(name);
        try {
            function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            currentThread.setName(oldName);
            InlineMarker.finallyEnd(1);
        }
    }

    public static final long headersContentLength(Response $this$headersContentLength) {
        Intrinsics.checkNotNullParameter($this$headersContentLength, "<this>");
        String str = $this$headersContentLength.headers().get("Content-Length");
        if (str != null) {
            return _UtilCommonKt.toLongOrDefault(str, -1L);
        }
        return -1L;
    }

    public static final <T> List<T> unmodifiable(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<T> listUnmodifiableList = Collections.unmodifiableList(list);
        Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "unmodifiableList(...)");
        return listUnmodifiableList;
    }

    public static final <T> Set<T> unmodifiable(Set<? extends T> set) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        Set<T> setUnmodifiableSet = Collections.unmodifiableSet(set);
        Intrinsics.checkNotNullExpressionValue(setUnmodifiableSet, "unmodifiableSet(...)");
        return setUnmodifiableSet;
    }

    public static final <K, V> Map<K, V> unmodifiable(Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Map<K, V> mapUnmodifiableMap = Collections.unmodifiableMap(map);
        Intrinsics.checkNotNullExpressionValue(mapUnmodifiableMap, "unmodifiableMap(...)");
        return mapUnmodifiableMap;
    }

    public static final <T> List<T> toImmutableList(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        if (list.size() != 1) {
            Object[] array = list.toArray();
            Intrinsics.checkNotNullExpressionValue(array, "toArray(...)");
            List $this$unmodifiable$iv = ArraysKt.asList(array);
            List<T> listUnmodifiableList = Collections.unmodifiableList($this$unmodifiable$iv);
            Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "unmodifiableList(...)");
            Intrinsics.checkNotNull(listUnmodifiableList, "null cannot be cast to non-null type kotlin.collections.List<T of okhttp3.internal._UtilJvmKt.toImmutableList>");
            return listUnmodifiableList;
        }
        List<T> listSingletonList = Collections.singletonList(list.get(0));
        Intrinsics.checkNotNullExpressionValue(listSingletonList, "singletonList(...)");
        return listSingletonList;
    }

    @SafeVarargs
    public static final <T> List<T> immutableListOf(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "elements");
        return toImmutableList(tArr);
    }

    public static final <T> List<T> toImmutableList(T[] tArr) {
        boolean z;
        if (tArr == null) {
            z = true;
        } else {
            if (tArr.length == 0) {
                z = true;
            } else {
                z = false;
            }
        }
        if (z) {
            return CollectionsKt.emptyList();
        }
        if (tArr.length == 1) {
            List<T> listSingletonList = Collections.singletonList(tArr[0]);
            Intrinsics.checkNotNullExpressionValue(listSingletonList, "singletonList(...)");
            return listSingletonList;
        }
        List $this$unmodifiable$iv = ArraysKt.asList((Object[]) tArr.clone());
        List<T> listUnmodifiableList = Collections.unmodifiableList($this$unmodifiable$iv);
        Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "unmodifiableList(...)");
        return listUnmodifiableList;
    }

    public static final void closeQuietly(Socket $this$closeQuietly) {
        Intrinsics.checkNotNullParameter($this$closeQuietly, "<this>");
        try {
            $this$closeQuietly.close();
        } catch (AssertionError e) {
            throw e;
        } catch (RuntimeException rethrown) {
            if (Intrinsics.areEqual(rethrown.getMessage(), "bio == null")) {
            } else {
                throw rethrown;
            }
        } catch (Exception e2) {
        }
    }

    public static final void closeQuietly(ServerSocket $this$closeQuietly) {
        Intrinsics.checkNotNullParameter($this$closeQuietly, "<this>");
        try {
            $this$closeQuietly.close();
        } catch (RuntimeException rethrown) {
            throw rethrown;
        } catch (Exception e) {
        }
    }

    public static final String toHexString(long $this$toHexString) {
        String hexString = Long.toHexString($this$toHexString);
        Intrinsics.checkNotNullExpressionValue(hexString, "toHexString(...)");
        return hexString;
    }

    public static final String toHexString(int $this$toHexString) {
        String hexString = Integer.toHexString($this$toHexString);
        Intrinsics.checkNotNullExpressionValue(hexString, "toHexString(...)");
        return hexString;
    }

    public static final <T> T readFieldOrNull(Object obj, Class<T> cls, String str) {
        Object fieldOrNull;
        Intrinsics.checkNotNullParameter(obj, "instance");
        Intrinsics.checkNotNullParameter(cls, "fieldType");
        Intrinsics.checkNotNullParameter(str, "fieldName");
        Class<?> cls2 = obj.getClass();
        while (true) {
            T tCast = null;
            if (!Intrinsics.areEqual(cls2, Object.class)) {
                try {
                    Field declaredField = cls2.getDeclaredField(str);
                    declaredField.setAccessible(true);
                    Object obj2 = declaredField.get(obj);
                    if (cls.isInstance(obj2)) {
                        tCast = cls.cast(obj2);
                    }
                    return tCast;
                } catch (NoSuchFieldException e) {
                    Class<? super Object> superclass = cls2.getSuperclass();
                    Intrinsics.checkNotNullExpressionValue(superclass, "getSuperclass(...)");
                    cls2 = superclass;
                }
            } else {
                if (Intrinsics.areEqual(str, "delegate") || (fieldOrNull = readFieldOrNull(obj, Object.class, "delegate")) == null) {
                    return null;
                }
                return (T) readFieldOrNull(fieldOrNull, cls, str);
            }
        }
    }

    public static final void assertLockNotHeld(Dispatcher $this$assertLockNotHeld) {
        Intrinsics.checkNotNullParameter($this$assertLockNotHeld, "<this>");
        if (assertionsEnabled && Thread.holdsLock($this$assertLockNotHeld)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + $this$assertLockNotHeld);
        }
    }
}
