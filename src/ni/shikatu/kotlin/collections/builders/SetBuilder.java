package ni.shikatu.kotlin.collections.builders;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.AbstractMutableSet;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.markers.KMutableSet;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0004\b\u0000\u0018\u0000 %*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00060\u0004j\u0002`\u0005:\u0001%B\u001b\b\u0000\u0012\u0010\u0010\u0006\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u0007¢\u0006\u0004\b\b\u0010\tB\t\b\u0016¢\u0006\u0004\b\b\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\b\u0010\rJ\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0016\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0015\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\u0015\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0096\u0002J\u0016\u0010 \u001a\u00020\u00162\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\"H\u0016J\u0016\u0010#\u001a\u00020\u00162\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\"H\u0016J\u0016\u0010$\u001a\u00020\u00162\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\"H\u0016R\u0018\u0010\u0006\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006&"}, d2 = {"Lni/shikatu/kotlin/collections/builders/SetBuilder;", "E", "", "Lni/shikatu/kotlin/collections/AbstractMutableSet;", "Ljava/io/Serializable;", "Lni/shikatu/kotlin/io/Serializable;", "backing", "Lni/shikatu/kotlin/collections/builders/MapBuilder;", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "()V", "initialCapacity", "", "(I)V", "build", "", "writeReplace", "", "size", "getSize", "()I", "isEmpty", "", "contains", "element", "(Ljava/lang/Object;)Z", "clear", "", "add", "remove", "iterator", "", "addAll", "elements", "", "removeAll", "retainAll", "Companion", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SetBuilder<E> extends AbstractMutableSet<E> implements Set<E>, Serializable, KMutableSet {
    private static final Companion Companion = new Companion(null);
    private static final SetBuilder Empty = new SetBuilder(MapBuilder.Companion.getEmpty$kotlin_stdlib());
    private final MapBuilder<E, ?> backing;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lni/shikatu/kotlin/collections/builders/SetBuilder$Companion;", "", "<init>", "()V", "Empty", "Lni/shikatu/kotlin/collections/builders/SetBuilder;", "", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public SetBuilder(MapBuilder<E, ?> mapBuilder) {
        Intrinsics.checkNotNullParameter(mapBuilder, "backing");
        this.backing = mapBuilder;
    }

    public SetBuilder() {
        this(new MapBuilder());
    }

    public SetBuilder(int initialCapacity) {
        this(new MapBuilder(initialCapacity));
    }

    public final Set<E> build() {
        this.backing.build();
        return size() > 0 ? this : Empty;
    }

    private final Object writeReplace() throws NotSerializableException {
        if (this.backing.isReadOnly$kotlin_stdlib()) {
            return new SerializedCollection(this, 1);
        }
        throw new NotSerializableException("The set cannot be serialized while it is being built.");
    }

    @Override
    public int getSize() {
        return this.backing.size();
    }

    @Override
    public boolean isEmpty() {
        return this.backing.isEmpty();
    }

    @Override
    public boolean contains(Object element) {
        return this.backing.containsKey(element);
    }

    @Override
    public void clear() {
        this.backing.clear();
    }

    @Override
    public boolean add(E e) {
        return this.backing.addKey$kotlin_stdlib(e) >= 0;
    }

    @Override
    public boolean remove(Object element) {
        return this.backing.removeKey$kotlin_stdlib(element);
    }

    @Override
    public Iterator<E> iterator() {
        return this.backing.keysIterator$kotlin_stdlib();
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        this.backing.checkIsMutable$kotlin_stdlib();
        return super.addAll(collection);
    }

    @Override
    public boolean removeAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        this.backing.checkIsMutable$kotlin_stdlib();
        return super.removeAll(collection);
    }

    @Override
    public boolean retainAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        this.backing.checkIsMutable$kotlin_stdlib();
        return super.retainAll(collection);
    }
}
