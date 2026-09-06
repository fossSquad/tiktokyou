package ni.shikatu.okio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import ni.shikatu.kotlin.KotlinVersion;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.collections.MapsKt;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.reflect.KClass;
import ni.shikatu.kotlin.reflect.KClasses;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001Bq\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\u0018\b\u0002\u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u001c\u001a\u0004\u0018\u0001H\u001d\"\b\b\u0000\u0010\u001d*\u00020\u00012\u000e\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u001d0\u000e¢\u0006\u0002\u0010\u001fJu\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0018\b\u0002\u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020#H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015R\u0015\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0018\u0010\u0015R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0019\u0010\u0015R!\u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006$"}, d2 = {"Lni/shikatu/okio/FileMetadata;", _UrlKt.FRAGMENT_ENCODE_SET, "isRegularFile", _UrlKt.FRAGMENT_ENCODE_SET, "isDirectory", "symlinkTarget", "Lni/shikatu/okio/Path;", "size", _UrlKt.FRAGMENT_ENCODE_SET, "createdAtMillis", "lastModifiedAtMillis", "lastAccessedAtMillis", "extras", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/reflect/KClass;", "<init>", "(ZZLokio/Path;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Map;)V", "()Z", "getSymlinkTarget", "()Lokio/Path;", "getSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCreatedAtMillis", "getLastModifiedAtMillis", "getLastAccessedAtMillis", "getExtras", "()Ljava/util/Map;", "extra", "T", "type", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "copy", "(ZZLokio/Path;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Map;)Lokio/FileMetadata;", "toString", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileMetadata {
    private final Long createdAtMillis;
    private final Map<KClass<?>, Object> extras;
    private final boolean isDirectory;
    private final boolean isRegularFile;
    private final Long lastAccessedAtMillis;
    private final Long lastModifiedAtMillis;
    private final Long size;
    private final Path symlinkTarget;

    public FileMetadata() {
        this(false, false, null, null, null, null, null, null, KotlinVersion.MAX_COMPONENT_VALUE, null);
    }

    public FileMetadata(boolean isRegularFile, boolean isDirectory, Path symlinkTarget, Long size, Long createdAtMillis, Long lastModifiedAtMillis, Long lastAccessedAtMillis, Map<KClass<?>, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "extras");
        this.isRegularFile = isRegularFile;
        this.isDirectory = isDirectory;
        this.symlinkTarget = symlinkTarget;
        this.size = size;
        this.createdAtMillis = createdAtMillis;
        this.lastModifiedAtMillis = lastModifiedAtMillis;
        this.lastAccessedAtMillis = lastAccessedAtMillis;
        this.extras = MapsKt.toMap(map);
    }

    public  FileMetadata(boolean z, boolean z2, Path path, Long l, Long l2, Long l3, Long l4, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? null : path, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : l2, (i & 32) != 0 ? null : l3, (i & 64) != 0 ? null : l4, (i & 128) != 0 ? MapsKt.emptyMap() : map);
    }

    public final boolean isRegularFile() {
        return this.isRegularFile;
    }

    public final boolean isDirectory() {
        return this.isDirectory;
    }

    public final Path getSymlinkTarget() {
        return this.symlinkTarget;
    }

    public final Long getSize() {
        return this.size;
    }

    public final Long getCreatedAtMillis() {
        return this.createdAtMillis;
    }

    public final Long getLastModifiedAtMillis() {
        return this.lastModifiedAtMillis;
    }

    public final Long getLastAccessedAtMillis() {
        return this.lastAccessedAtMillis;
    }

    public final Map<KClass<?>, Object> getExtras() {
        return this.extras;
    }

    public final <T> T extra(KClass<? extends T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "type");
        Object obj = this.extras.get(kClass);
        if (obj == null) {
            return null;
        }
        return (T) KClasses.cast(kClass, obj);
    }

    public static  FileMetadata copy$default(FileMetadata fileMetadata, boolean z, boolean z2, Path path, Long l, Long l2, Long l3, Long l4, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            z = fileMetadata.isRegularFile;
        }
        if ((i & 2) != 0) {
            z2 = fileMetadata.isDirectory;
        }
        if ((i & 4) != 0) {
            path = fileMetadata.symlinkTarget;
        }
        if ((i & 8) != 0) {
            l = fileMetadata.size;
        }
        if ((i & 16) != 0) {
            l2 = fileMetadata.createdAtMillis;
        }
        if ((i & 32) != 0) {
            l3 = fileMetadata.lastModifiedAtMillis;
        }
        if ((i & 64) != 0) {
            l4 = fileMetadata.lastAccessedAtMillis;
        }
        Map map2 = (i & 128) != 0 ? fileMetadata.extras : map;
        Long l5 = l4;
        Long l6 = l2;
        return fileMetadata.copy(z, z2, path, l, l6, l3, l5, map2);
    }

    public final FileMetadata copy(boolean isRegularFile, boolean isDirectory, Path symlinkTarget, Long size, Long createdAtMillis, Long lastModifiedAtMillis, Long lastAccessedAtMillis, Map<KClass<?>, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "extras");
        return new FileMetadata(isRegularFile, isDirectory, symlinkTarget, size, createdAtMillis, lastModifiedAtMillis, lastAccessedAtMillis, map);
    }

    public String toString() {
        List fields = new ArrayList();
        if (this.isRegularFile) {
            fields.add("isRegularFile");
        }
        if (this.isDirectory) {
            fields.add("isDirectory");
        }
        if (this.size != null) {
            fields.add("byteCount=" + this.size.longValue());
        }
        if (this.createdAtMillis != null) {
            fields.add("createdAt=" + this.createdAtMillis.longValue());
        }
        if (this.lastModifiedAtMillis != null) {
            fields.add("lastModifiedAt=" + this.lastModifiedAtMillis.longValue());
        }
        if (this.lastAccessedAtMillis != null) {
            fields.add("lastAccessedAt=" + this.lastAccessedAtMillis.longValue());
        }
        if (!this.extras.isEmpty()) {
            fields.add("extras=" + this.extras);
        }
        return CollectionsKt.joinToString$default(fields, ", ", "FileMetadata(", ")", 0, null, null, 56, null);
    }
}
