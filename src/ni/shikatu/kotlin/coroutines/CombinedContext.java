package ni.shikatu.kotlin.coroutines;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.Ref;
import ni.shikatu.kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001(B\u0019\bF\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\t\u001a\u0004\u0018\u0001H\n\"\b\b\u0000\u0010\n*\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\fH\u0096\u0082\u0004¢\u0006\u0002\u0010\rJ7\u0010\u000e\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0010\u001a\u0002H\u000f2\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u000f0\u0012H\u0096\u0080\u0004¢\u0006\u0002\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u00012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0096\u0080\u0004J\n\u0010\u0015\u001a\u00020\u0016H\u0082\u0080\u0004J\u0012\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0006H\u0082\u0080\u0004J\u0012\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0000H\u0082\u0080\u0004J\u0014\u0010\u001b\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0082\u0004J\n\u0010\u001e\u001a\u00020\u0016H\u0096\u0080\u0004J\n\u0010\u001f\u001a\u00020 H\u0096\u0080\u0004J\n\u0010!\u001a\u00020\u001dH\u0082\u0080\u0004J\u001b\u0010\"\u001a\u00020#2\n\u0010$\u001a\u00060%j\u0002`&H\u0082\u0080\u0004¢\u0006\u0002\u0010'R\u000f\u0010\u0004\u001a\u00020\u0001X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0005\u001a\u00020\u0006X\u0082\u0084\b¢\u0006\u0002\n\u0000Ê\u0001\f\b*\u0012\b\b+\u0012\u0004\b\b(,¨\u0006)"}, d2 = {"Lni/shikatu/kotlin/coroutines/CombinedContext;", "Lni/shikatu/kotlin/coroutines/CoroutineContext;", "Ljava/io/Serializable;", "Lni/shikatu/kotlin/io/Serializable;", "left", "element", "Lni/shikatu/kotlin/coroutines/CoroutineContext$Element;", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext$Element;)V", "get", "E", "key", "Lni/shikatu/kotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "fold", "R", "initial", "operation", "Lni/shikatu/kotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "minusKey", "size", _UrlKt.FRAGMENT_ENCODE_SET, "contains", _UrlKt.FRAGMENT_ENCODE_SET, "containsAll", "context", "equals", "other", _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", "toString", _UrlKt.FRAGMENT_ENCODE_SET, "writeReplace", "readObject", _UrlKt.FRAGMENT_ENCODE_SET, "input", "Ljava/io/ObjectInputStream;", "Lni/shikatu/kotlin/internal/ReadObjectParameterType;", "(Ljava/io/ObjectInputStream;)V", "Serialized", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.3"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class CombinedContext implements CoroutineContext, Serializable {
    private final CoroutineContext.Element element;
    private final CoroutineContext left;

    public CombinedContext(CoroutineContext left, CoroutineContext.Element element) {
        Intrinsics.checkNotNullParameter(left, "left");
        Intrinsics.checkNotNullParameter(element, "element");
        this.left = left;
        this.element = element;
    }

    @Override
    public /* bridge */ CoroutineContext plus(CoroutineContext context) {
        return CoroutineContext.DefaultImpls.plus(this, context);
    }

    @Override
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        CombinedContext combinedContext = this;
        while (true) {
            E e = (E) combinedContext.element.get(key);
            if (e != null) {
                return e;
            }
            CoroutineContext coroutineContext = combinedContext.left;
            if (coroutineContext instanceof CombinedContext) {
                combinedContext = (CombinedContext) coroutineContext;
            } else {
                return (E) coroutineContext.get(key);
            }
        }
    }

    @Override
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(function2, "operation");
        return function2.invoke((Object) this.left.fold(r, function2), this.element);
    }

    @Override
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (this.element.get(key) != null) {
            return this.left;
        }
        CoroutineContext newLeft = this.left.minusKey(key);
        if (newLeft == this.left) {
            return this;
        }
        return newLeft == EmptyCoroutineContext.INSTANCE ? this.element : new CombinedContext(newLeft, this.element);
    }

    private final int size() {
        CombinedContext cur = this;
        int size = 2;
        while (true) {
            CoroutineContext coroutineContext = cur.left;
            CombinedContext combinedContext = coroutineContext instanceof CombinedContext ? (CombinedContext) coroutineContext : null;
            if (combinedContext == null) {
                return size;
            }
            cur = combinedContext;
            size++;
        }
    }

    private final boolean contains(CoroutineContext.Element element) {
        return Intrinsics.areEqual(get(element.getKey()), element);
    }

    private final boolean containsAll(CombinedContext context) {
        CombinedContext cur = context;
        while (contains(cur.element)) {
            CoroutineContext next = cur.left;
            if (next instanceof CombinedContext) {
                cur = (CombinedContext) next;
            } else {
                Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return contains((CoroutineContext.Element) next);
            }
        }
        return false;
    }

    public boolean equals(Object other) {
        return this == other || ((other instanceof CombinedContext) && ((CombinedContext) other).size() == size() && ((CombinedContext) other).containsAll(this));
    }

    public int hashCode() {
        return this.left.hashCode() + this.element.hashCode();
    }

    public String toString() {
        return AbstractJsonLexerKt.BEGIN_LIST + ((String) fold(_UrlKt.FRAGMENT_ENCODE_SET, new Function2() {
            @Override
            public final Object invoke(Object obj, Object obj2) {
                return CombinedContext.toString$lambda$0((String) obj, (CoroutineContext.Element) obj2);
            }
        })) + AbstractJsonLexerKt.END_LIST;
    }

    public static final String toString$lambda$0(String acc, CoroutineContext.Element element) {
        Intrinsics.checkNotNullParameter(acc, "acc");
        Intrinsics.checkNotNullParameter(element, "element");
        return acc.length() == 0 ? element.toString() : acc + ", " + element;
    }

    private final Object writeReplace() {
        int n = size();
        final CoroutineContext[] elements = new CoroutineContext[n];
        final Ref.IntRef index = new Ref.IntRef();
        fold(Unit.INSTANCE, new Function2() {
            @Override
            public final Object invoke(Object obj, Object obj2) {
                return CombinedContext.writeReplace$lambda$0(elements, index, (Unit) obj, (CoroutineContext.Element) obj2);
            }
        });
        if (!(index.element == n)) {
            throw new IllegalStateException("Check failed.");
        }
        return new Serialized(elements);
    }

    public static final Unit writeReplace$lambda$0(CoroutineContext[] $elements, Ref.IntRef $index, Unit unit, CoroutineContext.Element element) {
        Intrinsics.checkNotNullParameter(unit, "<unused var>");
        Intrinsics.checkNotNullParameter(element, "element");
        int i = $index.element;
        $index.element = i + 1;
        $elements[i] = element;
        return Unit.INSTANCE;
    }

    private final void readObject(ObjectInputStream input) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \r2\u00060\u0001j\u0002`\u0002:\u0001\rB\u0017\bF\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\u000b\u001a\u00020\fH\u0082\u0080\u0004R\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u0084\b¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lni/shikatu/kotlin/coroutines/CombinedContext$Serialized;", "Ljava/io/Serializable;", "Lni/shikatu/kotlin/io/Serializable;", "elements", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/coroutines/CoroutineContext;", "<init>", "([Lkotlin/coroutines/CoroutineContext;)V", "getElements", "()[Lkotlin/coroutines/CoroutineContext;", "[Lni/shikatu/kotlin/coroutines/CoroutineContext;", "readResolve", _UrlKt.FRAGMENT_ENCODE_SET, "Companion", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private static final class Serialized implements Serializable {
        public static final Companion Companion = new Companion(null);
        private static final long serialVersionUID = 0;
        private final CoroutineContext[] elements;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u000f\u0010\u0004\u001a\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lni/shikatu/kotlin/coroutines/CombinedContext$Serialized$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "serialVersionUID", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public Serialized(CoroutineContext[] elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            this.elements = elements;
        }

        public final CoroutineContext[] getElements() {
            return this.elements;
        }

        private final Object readResolve() {
            CoroutineContext[] coroutineContextArr = this.elements;
            Object initial$iv = EmptyCoroutineContext.INSTANCE;
            Object accumulator$iv = initial$iv;
            for (CoroutineContext coroutineContext : coroutineContextArr) {
                CoroutineContext p0 = (CoroutineContext) accumulator$iv;
                accumulator$iv = p0.plus(coroutineContext);
            }
            return accumulator$iv;
        }
    }
}
