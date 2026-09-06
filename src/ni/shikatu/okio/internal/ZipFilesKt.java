package ni.shikatu.okio.internal;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import ni.shikatu.kotlin.ExceptionsKt;
import ni.shikatu.kotlin.KotlinVersion;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.TuplesKt;
import ni.shikatu.kotlin.UShort;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.collections.MapsKt;
import ni.shikatu.kotlin.comparisons.ComparisonsKt;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.Ref;
import ni.shikatu.kotlin.text.CharsKt;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.okhttp3.internal.http2.Settings;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okhttp3.internal.ws.WebSocketProtocol;
import ni.shikatu.okio.BufferedSource;
import ni.shikatu.okio.FileHandle;
import ni.shikatu.okio.FileSystem;
import ni.shikatu.okio.Okio;
import ni.shikatu.okio.Path;
import ni.shikatu.okio.ZipFileSystem;

@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a.\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016H\u0000\u001a\"\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00170\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00170\u001cH\u0002\u001a\f\u0010\u001d\u001a\u00020\u0017*\u00020\u001eH\u0000\u001a\f\u0010\u001f\u001a\u00020 *\u00020\u001eH\u0002\u001a\u0014\u0010!\u001a\u00020 *\u00020\u001e2\u0006\u0010\"\u001a\u00020 H\u0002\u001a.\u0010#\u001a\u00020$*\u00020\u001e2\u0006\u0010%\u001a\u00020\u00012\u0018\u0010&\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020$0'H\u0002\u001a\f\u0010(\u001a\u00020$*\u00020\u001eH\u0000\u001a\u0014\u0010)\u001a\u00020\u0017*\u00020\u001e2\u0006\u0010*\u001a\u00020\u0017H\u0000\u001a\u0018\u0010+\u001a\u0004\u0018\u00010\u0017*\u00020\u001e2\b\u0010*\u001a\u0004\u0018\u00010\u0017H\u0002\u001a\u0010\u0010,\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u000bH\u0000\u001a\u001f\u0010.\u001a\u0004\u0018\u00010\u000b2\u0006\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u0001H\u0000¢\u0006\u0002\u00101\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u00102\u001a\u000203*\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b4\u00105¨\u00066"}, d2 = {"LOCAL_FILE_HEADER_SIGNATURE", _UrlKt.FRAGMENT_ENCODE_SET, "CENTRAL_FILE_HEADER_SIGNATURE", "END_OF_CENTRAL_DIRECTORY_SIGNATURE", "ZIP64_LOCATOR_SIGNATURE", "ZIP64_EOCD_RECORD_SIGNATURE", "COMPRESSION_METHOD_DEFLATED", "COMPRESSION_METHOD_STORED", "BIT_FLAG_ENCRYPTED", "BIT_FLAG_UNSUPPORTED_MASK", "MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE", _UrlKt.FRAGMENT_ENCODE_SET, "HEADER_ID_ZIP64_EXTENDED_INFO", "HEADER_ID_NTFS_EXTRA", "HEADER_ID_EXTENDED_TIMESTAMP", "openZip", "Lni/shikatu/okio/ZipFileSystem;", "zipPath", "Lni/shikatu/okio/Path;", "fileSystem", "Lni/shikatu/okio/FileSystem;", "predicate", "Lni/shikatu/kotlin/Function1;", "Lni/shikatu/okio/internal/ZipEntry;", _UrlKt.FRAGMENT_ENCODE_SET, "buildIndex", _UrlKt.FRAGMENT_ENCODE_SET, "entries", _UrlKt.FRAGMENT_ENCODE_SET, "readCentralDirectoryZipEntry", "Lni/shikatu/okio/BufferedSource;", "readEocdRecord", "Lni/shikatu/okio/internal/EocdRecord;", "readZip64EocdRecord", "regularRecord", "readExtra", _UrlKt.FRAGMENT_ENCODE_SET, "extraSize", "block", "Lni/shikatu/kotlin/Function2;", "skipLocalHeader", "readLocalHeader", "centralDirectoryZipEntry", "readOrSkipLocalHeader", "filetimeToEpochMillis", "filetime", "dosDateTimeToEpochMillis", "date", "time", "(II)Ljava/lang/Long;", "hex", _UrlKt.FRAGMENT_ENCODE_SET, "getHex", "(I)Ljava/lang/String;", "ni.shikatu.okio"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ZipFilesKt {
    private static final int BIT_FLAG_ENCRYPTED = 1;
    private static final int BIT_FLAG_UNSUPPORTED_MASK = 1;
    private static final int CENTRAL_FILE_HEADER_SIGNATURE = 33639248;
    public static final int COMPRESSION_METHOD_DEFLATED = 8;
    public static final int COMPRESSION_METHOD_STORED = 0;
    private static final int END_OF_CENTRAL_DIRECTORY_SIGNATURE = 101010256;
    private static final int HEADER_ID_EXTENDED_TIMESTAMP = 21589;
    private static final int HEADER_ID_NTFS_EXTRA = 10;
    private static final int HEADER_ID_ZIP64_EXTENDED_INFO = 1;
    private static final int LOCAL_FILE_HEADER_SIGNATURE = 67324752;
    private static final long MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE = 4294967295L;
    private static final int ZIP64_EOCD_RECORD_SIGNATURE = 101075792;
    private static final int ZIP64_LOCATOR_SIGNATURE = 117853008;

    public static  ZipFileSystem openZip$default(Path path, FileSystem fileSystem, Function1 function1, int i, Object obj) throws IOException {
        if ((i & 4) != 0) {
            function1 = new Function1() {
                @Override
                public final Object invoke(Object obj2) {
                    return Boolean.valueOf(ZipFilesKt.openZip$lambda$0((ZipEntry) obj2));
                }
            };
        }
        return openZip(path, fileSystem, function1);
    }

    public static final boolean openZip$lambda$0(ZipEntry it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return true;
    }

    public static final ZipFileSystem openZip(Path zipPath, FileSystem fileSystem, Function1<? super ZipEntry, Boolean> function1) throws IOException {
        Closeable $this$use$iv;
        BufferedSource source;
        Object result$iv;
        Object result$iv2;
        Object result$iv3;
        Function1<? super ZipEntry, Boolean> function2 = function1;
        Intrinsics.checkNotNullParameter(zipPath, "zipPath");
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(function2, "predicate");
        Closeable $this$use$iv2 = fileSystem.openReadOnly(zipPath);
        int $i$f$use = 0;
        try {
            FileHandle fileHandle = (FileHandle) $this$use$iv2;
            long scanOffset = fileHandle.size() - ((long) 22);
            long j = 0;
            try {
                if (scanOffset < 0) {
                    throw new IOException("not a zip: size=" + fileHandle.size());
                }
                long stopOffset = Math.max(scanOffset - 65536, 0L);
                while (true) {
                    BufferedSource source2 = Okio.buffer(fileHandle.source(scanOffset));
                    try {
                        if (source2.readIntLe() == END_OF_CENTRAL_DIRECTORY_SIGNATURE) {
                            long eocdOffset = scanOffset;
                            try {
                                EocdRecord eocdRecord = readEocdRecord(source2);
                                try {
                                    long j2 = j;
                                    $this$use$iv = $this$use$iv2;
                                    source = source2;
                                    try {
                                        String comment = source.readUtf8(eocdRecord.getCommentByteCount());
                                        try {
                                            source.close();
                                            long zip64LocatorOffset = eocdOffset - ((long) 20);
                                            if (zip64LocatorOffset > j2) {
                                                Closeable $this$use$iv3 = Okio.buffer(fileHandle.source(zip64LocatorOffset));
                                                Throwable thrown$iv = null;
                                                try {
                                                    BufferedSource zip64LocatorSource = (BufferedSource) $this$use$iv3;
                                                    if (zip64LocatorSource.readIntLe() == ZIP64_LOCATOR_SIGNATURE) {
                                                        try {
                                                            int diskWithCentralDir = zip64LocatorSource.readIntLe();
                                                            long zip64EocdRecordOffset = zip64LocatorSource.readLongLe();
                                                            int numDisks = zip64LocatorSource.readIntLe();
                                                            if (numDisks != 1 || diskWithCentralDir != 0) {
                                                                throw new IOException("unsupported zip: spanned");
                                                            }
                                                            Closeable $this$use$iv4 = Okio.buffer(fileHandle.source(zip64EocdRecordOffset));
                                                            Throwable thrown$iv2 = null;
                                                            try {
                                                                BufferedSource zip64EocdSource = (BufferedSource) $this$use$iv4;
                                                                int zip64EocdSignature = zip64EocdSource.readIntLe();
                                                                try {
                                                                    if (zip64EocdSignature != ZIP64_EOCD_RECORD_SIGNATURE) {
                                                                        throw new IOException("bad zip: expected " + getHex(ZIP64_EOCD_RECORD_SIGNATURE) + " but was " + getHex(zip64EocdSignature));
                                                                    }
                                                                    EocdRecord zip64EocdRecord = readZip64EocdRecord(zip64EocdSource, eocdRecord);
                                                                    try {
                                                                        result$iv3 = Unit.INSTANCE;
                                                                        if ($this$use$iv4 != null) {
                                                                            try {
                                                                                $this$use$iv4.close();
                                                                                Unit unit = Unit.INSTANCE;
                                                                            } catch (Throwable t$iv) {
                                                                                thrown$iv2 = t$iv;
                                                                            }
                                                                        }
                                                                        eocdRecord = zip64EocdRecord;
                                                                    } catch (Throwable th) {
                                                                        t$iv = th;
                                                                        eocdRecord = zip64EocdRecord;
                                                                        Throwable thrown$iv3 = t$iv;
                                                                        if ($this$use$iv4 != null) {
                                                                            try {
                                                                                $this$use$iv4.close();
                                                                                Unit unit2 = Unit.INSTANCE;
                                                                            } catch (Throwable t$iv2) {
                                                                                ExceptionsKt.addSuppressed(thrown$iv3, t$iv2);
                                                                            }
                                                                        }
                                                                        thrown$iv2 = thrown$iv3;
                                                                        result$iv3 = null;
                                                                    }
                                                                    if (thrown$iv2 != null) {
                                                                        throw thrown$iv2;
                                                                    }
                                                                    Object obj = result$iv3;
                                                                } catch (Throwable th2) {
                                                                    t$iv = th2;
                                                                }
                                                            } catch (Throwable th3) {
                                                                t$iv = th3;
                                                            }
                                                        } catch (Throwable th4) {
                                                            t$iv = th4;
                                                            Throwable thrown$iv4 = t$iv;
                                                            if ($this$use$iv3 != null) {
                                                                try {
                                                                    $this$use$iv3.close();
                                                                    Unit unit3 = Unit.INSTANCE;
                                                                } catch (Throwable t$iv3) {
                                                                    ExceptionsKt.addSuppressed(thrown$iv4, t$iv3);
                                                                }
                                                            }
                                                            thrown$iv = thrown$iv4;
                                                            result$iv2 = null;
                                                        }
                                                    }
                                                    result$iv2 = Unit.INSTANCE;
                                                    if ($this$use$iv3 != null) {
                                                        try {
                                                            $this$use$iv3.close();
                                                            Unit unit4 = Unit.INSTANCE;
                                                        } catch (Throwable t$iv4) {
                                                            thrown$iv = t$iv4;
                                                        }
                                                    }
                                                } catch (Throwable th5) {
                                                    t$iv = th5;
                                                }
                                                if (thrown$iv != null) {
                                                    throw thrown$iv;
                                                }
                                                Object obj2 = result$iv2;
                                            }
                                            List entries = new ArrayList();
                                            Closeable $this$use$iv5 = Okio.buffer(fileHandle.source(eocdRecord.getCentralDirectoryOffset()));
                                            Throwable thrown$iv5 = null;
                                            try {
                                                BufferedSource source3 = (BufferedSource) $this$use$iv5;
                                                long i = 0;
                                                long entryCount = eocdRecord.getEntryCount();
                                                while (i < entryCount) {
                                                    ZipEntry entry = readCentralDirectoryZipEntry(source3);
                                                    if (entry.getOffset() >= eocdRecord.getCentralDirectoryOffset()) {
                                                        throw new IOException("bad zip: local file header offset >= central directory offset");
                                                    }
                                                    BufferedSource source4 = source3;
                                                    if (function2.invoke(entry).booleanValue()) {
                                                        entries.add(entry);
                                                    }
                                                    i++;
                                                    function2 = function1;
                                                    source3 = source4;
                                                }
                                                result$iv = Unit.INSTANCE;
                                                if ($this$use$iv5 != null) {
                                                    try {
                                                        $this$use$iv5.close();
                                                        Unit unit5 = Unit.INSTANCE;
                                                    } catch (Throwable t$iv5) {
                                                        thrown$iv5 = t$iv5;
                                                    }
                                                }
                                            } catch (Throwable t$iv6) {
                                                if ($this$use$iv5 != null) {
                                                    try {
                                                        $this$use$iv5.close();
                                                        Unit unit6 = Unit.INSTANCE;
                                                    } catch (Throwable t$iv7) {
                                                        ExceptionsKt.addSuppressed(t$iv6, t$iv7);
                                                    }
                                                }
                                                thrown$iv5 = t$iv6;
                                                result$iv = null;
                                            }
                                            if (thrown$iv5 != null) {
                                                throw thrown$iv5;
                                            }
                                            Object obj3 = result$iv;
                                            ZipFileSystem zipFileSystem = new ZipFileSystem(zipPath, fileSystem, buildIndex(entries), comment);
                                            if ($this$use$iv != null) {
                                                try {
                                                    $this$use$iv.close();
                                                    Unit unit7 = Unit.INSTANCE;
                                                } catch (Throwable th6) {
                                                }
                                            }
                                            return zipFileSystem;
                                        } catch (Throwable th7) {
                                            t$iv = th7;
                                        }
                                    } catch (Throwable th8) {
                                        th = th8;
                                        source.close();
                                        throw th;
                                    }
                                } catch (Throwable th9) {
                                    th = th9;
                                    source = source2;
                                }
                            } catch (Throwable th10) {
                                th = th10;
                                source = source2;
                            }
                        } else {
                            Closeable $this$use$iv6 = $this$use$iv2;
                            long j3 = j;
                            int $i$f$use2 = $i$f$use;
                            source2.close();
                            scanOffset--;
                            if (scanOffset < stopOffset) {
                                throw new IOException("not a zip: end of central directory signature not found");
                            }
                            function2 = function1;
                            $i$f$use = $i$f$use2;
                            j = j3;
                            $this$use$iv2 = $this$use$iv6;
                        }
                    } catch (Throwable th11) {
                        th = th11;
                        source = source2;
                    }
                }
            } catch (Throwable th12) {
                t$iv = th12;
            }
        } catch (Throwable th13) {
            t$iv = th13;
            $this$use$iv = $this$use$iv2;
        }
        Throwable thrown$iv6 = t$iv;
        if ($this$use$iv != null) {
            try {
                $this$use$iv.close();
                Unit unit8 = Unit.INSTANCE;
                throw thrown$iv6;
            } catch (Throwable t$iv8) {
                ExceptionsKt.addSuppressed(thrown$iv6, t$iv8);
                throw thrown$iv6;
            }
        }
        throw thrown$iv6;
    }

    private static final Map<Path, ZipEntry> buildIndex(List<ZipEntry> list) {
        Path root = Path.Companion.get$default(Path.Companion, "/", false, 1, (Object) null);
        Map<Path, ZipEntry> mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to(root, new ZipEntry(root, true, null, 0L, 0L, 0L, 0, 0L, 0, 0, null, null, null, null, null, null, 65532, null)));
        List<ZipEntry> $this$sortedBy$iv = list;
        for (ZipEntry entry : CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() {

            @Override
            public final int compare(T t, T t2) {
                ZipEntry it = (ZipEntry) t;
                ZipEntry it2 = (ZipEntry) t2;
                return ComparisonsKt.compareValues(it.getCanonicalPath(), it2.getCanonicalPath());
            }
        })) {
            ZipEntry replaced = mapMutableMapOf.put(entry.getCanonicalPath(), entry);
            if (replaced == null) {
                ZipEntry child = entry;
                while (true) {
                    Path parentPath = child.getCanonicalPath().parent();
                    if (parentPath == null) {
                        break;
                    }
                    ZipEntry parentEntry = mapMutableMapOf.get(parentPath);
                    if (parentEntry != null) {
                        parentEntry.getChildren().add(child.getCanonicalPath());
                        break;
                    }
                    ZipEntry parentEntry2 = new ZipEntry(parentPath, true, null, 0L, 0L, 0L, 0, 0L, 0, 0, null, null, null, null, null, null, 65532, null);
                    mapMutableMapOf.put(parentPath, parentEntry2);
                    parentEntry2.getChildren().add(child.getCanonicalPath());
                    child = parentEntry2;
                }
            }
        }
        return mapMutableMapOf;
    }

    public static final ZipEntry readCentralDirectoryZipEntry(final BufferedSource $this$readCentralDirectoryZipEntry) throws IOException {
        Intrinsics.checkNotNullParameter($this$readCentralDirectoryZipEntry, "<this>");
        int signature = $this$readCentralDirectoryZipEntry.readIntLe();
        if (signature != CENTRAL_FILE_HEADER_SIGNATURE) {
            throw new IOException("bad zip: expected " + getHex(CENTRAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(signature));
        }
        $this$readCentralDirectoryZipEntry.skip(4L);
        int bitFlag = $this$readCentralDirectoryZipEntry.readShortLe() & UShort.MAX_VALUE;
        if ((bitFlag & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + getHex(bitFlag));
        }
        int compressionMethod = $this$readCentralDirectoryZipEntry.readShortLe() & UShort.MAX_VALUE;
        int dosLastModifiedTime = $this$readCentralDirectoryZipEntry.readShortLe() & UShort.MAX_VALUE;
        int dosLastModifiedDate = $this$readCentralDirectoryZipEntry.readShortLe() & UShort.MAX_VALUE;
        long crc = ((long) $this$readCentralDirectoryZipEntry.readIntLe()) & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
        final Ref.LongRef compressedSize = new Ref.LongRef();
        compressedSize.element = ((long) $this$readCentralDirectoryZipEntry.readIntLe()) & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
        final Ref.LongRef size = new Ref.LongRef();
        size.element = ((long) $this$readCentralDirectoryZipEntry.readIntLe()) & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
        int nameSize = $this$readCentralDirectoryZipEntry.readShortLe() & UShort.MAX_VALUE;
        int extraSize = $this$readCentralDirectoryZipEntry.readShortLe() & UShort.MAX_VALUE;
        int commentByteCount = $this$readCentralDirectoryZipEntry.readShortLe() & UShort.MAX_VALUE;
        $this$readCentralDirectoryZipEntry.skip(8L);
        final Ref.LongRef offset = new Ref.LongRef();
        offset.element = ((long) $this$readCentralDirectoryZipEntry.readIntLe()) & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
        String name = $this$readCentralDirectoryZipEntry.readUtf8(nameSize);
        if (StringsKt.contains$default((CharSequence) name, (char) 0, false, 2, (Object) null)) {
            throw new IOException("bad zip: filename contains 0x00");
        }
        long result = size.element == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE ? 0 + ((long) 8) : 0L;
        if (compressedSize.element == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE) {
            result += (long) 8;
        }
        if (offset.element == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE) {
            result += (long) 8;
        }
        final Ref.ObjectRef ntfsLastModifiedAtFiletime = new Ref.ObjectRef();
        final Ref.ObjectRef ntfsLastAccessedAtFiletime = new Ref.ObjectRef();
        final Ref.ObjectRef ntfsCreatedAtFiletime = new Ref.ObjectRef();
        final Ref.BooleanRef hasZip64Extra = new Ref.BooleanRef();
        final long requiredZip64ExtraSize = result;
        readExtra($this$readCentralDirectoryZipEntry, extraSize, new Function2() {
            @Override
            public final Object invoke(Object obj, Object obj2) {
                return ZipFilesKt.readCentralDirectoryZipEntry$lambda$1(hasZip64Extra, requiredZip64ExtraSize, size, $this$readCentralDirectoryZipEntry, compressedSize, offset, ntfsLastModifiedAtFiletime, ntfsLastAccessedAtFiletime, ntfsCreatedAtFiletime, ((Integer) obj).intValue(), ((Long) obj2).longValue());
            }
        });
        if (requiredZip64ExtraSize > 0 && !hasZip64Extra.element) {
            throw new IOException("bad zip: zip64 extra required but absent");
        }
        String comment = $this$readCentralDirectoryZipEntry.readUtf8(commentByteCount);
        Path canonicalPath = Path.Companion.get$default(Path.Companion, "/", false, 1, (Object) null).resolve(name);
        boolean isDirectory = StringsKt.endsWith$default(name, "/", false, 2, (Object) null);
        return new ZipEntry(canonicalPath, isDirectory, comment, crc, compressedSize.element, size.element, compressionMethod, offset.element, dosLastModifiedDate, dosLastModifiedTime, (Long) ntfsLastModifiedAtFiletime.element, (Long) ntfsLastAccessedAtFiletime.element, (Long) ntfsCreatedAtFiletime.element, null, null, null, 57344, null);
    }

    public static final Unit readCentralDirectoryZipEntry$lambda$1(Ref.BooleanRef $hasZip64Extra, long $requiredZip64ExtraSize, Ref.LongRef $size, final BufferedSource $this_readCentralDirectoryZipEntry, Ref.LongRef $compressedSize, Ref.LongRef $offset, final Ref.ObjectRef $ntfsLastModifiedAtFiletime, final Ref.ObjectRef $ntfsLastAccessedAtFiletime, final Ref.ObjectRef $ntfsCreatedAtFiletime, int headerId, long dataSize) throws IOException {
        switch (headerId) {
            case 1:
                if ($hasZip64Extra.element) {
                    throw new IOException("bad zip: zip64 extra repeated");
                }
                $hasZip64Extra.element = true;
                if (dataSize >= $requiredZip64ExtraSize) {
                    $size.element = $size.element == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE ? $this_readCentralDirectoryZipEntry.readLongLe() : $size.element;
                    $compressedSize.element = $compressedSize.element == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE ? $this_readCentralDirectoryZipEntry.readLongLe() : 0L;
                    $offset.element = $offset.element == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE ? $this_readCentralDirectoryZipEntry.readLongLe() : 0L;
                } else {
                    throw new IOException("bad zip: zip64 extra too short");
                }
                break;
                break;
            case 10:
                if (dataSize < 4) {
                    throw new IOException("bad zip: NTFS extra too short");
                }
                $this_readCentralDirectoryZipEntry.skip(4L);
                readExtra($this_readCentralDirectoryZipEntry, (int) (dataSize - 4), new Function2() {
                    @Override
                    public final Object invoke(Object obj, Object obj2) {
                        return ZipFilesKt.readCentralDirectoryZipEntry$lambda$1$0($ntfsLastModifiedAtFiletime, $this_readCentralDirectoryZipEntry, $ntfsLastAccessedAtFiletime, $ntfsCreatedAtFiletime, ((Integer) obj).intValue(), ((Long) obj2).longValue());
                    }
                });
                break;
                break;
        }
        return Unit.INSTANCE;
    }

    public static final Unit readCentralDirectoryZipEntry$lambda$1$0(Ref.ObjectRef $ntfsLastModifiedAtFiletime, BufferedSource $this_readCentralDirectoryZipEntry, Ref.ObjectRef $ntfsLastAccessedAtFiletime, Ref.ObjectRef $ntfsCreatedAtFiletime, int attributeId, long attributeSize) throws IOException {
        if (attributeId == 1) {
            if ($ntfsLastModifiedAtFiletime.element != 0) {
                throw new IOException("bad zip: NTFS extra attribute tag 0x0001 repeated");
            }
            if (attributeSize != 24) {
                throw new IOException("bad zip: NTFS extra attribute tag 0x0001 size != 24");
            }
            $ntfsLastModifiedAtFiletime.element = Long.valueOf($this_readCentralDirectoryZipEntry.readLongLe());
            $ntfsLastAccessedAtFiletime.element = Long.valueOf($this_readCentralDirectoryZipEntry.readLongLe());
            $ntfsCreatedAtFiletime.element = Long.valueOf($this_readCentralDirectoryZipEntry.readLongLe());
        }
        return Unit.INSTANCE;
    }

    private static final EocdRecord readEocdRecord(BufferedSource $this$readEocdRecord) throws IOException {
        int diskNumber = $this$readEocdRecord.readShortLe() & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
        int diskWithCentralDir = $this$readEocdRecord.readShortLe() & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
        long entryCount = $this$readEocdRecord.readShortLe() & UShort.MAX_VALUE;
        long totalEntryCount = $this$readEocdRecord.readShortLe() & UShort.MAX_VALUE;
        if (entryCount != totalEntryCount || diskNumber != 0 || diskWithCentralDir != 0) {
            throw new IOException("unsupported zip: spanned");
        }
        $this$readEocdRecord.skip(4L);
        long centralDirectoryOffset = MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE & ((long) $this$readEocdRecord.readIntLe());
        int commentByteCount = $this$readEocdRecord.readShortLe() & UShort.MAX_VALUE;
        return new EocdRecord(entryCount, centralDirectoryOffset, commentByteCount);
    }

    private static final EocdRecord readZip64EocdRecord(BufferedSource $this$readZip64EocdRecord, EocdRecord regularRecord) throws IOException {
        $this$readZip64EocdRecord.skip(12L);
        int diskNumber = $this$readZip64EocdRecord.readIntLe();
        int diskWithCentralDirStart = $this$readZip64EocdRecord.readIntLe();
        long entryCount = $this$readZip64EocdRecord.readLongLe();
        long totalEntryCount = $this$readZip64EocdRecord.readLongLe();
        if (entryCount != totalEntryCount || diskNumber != 0 || diskWithCentralDirStart != 0) {
            throw new IOException("unsupported zip: spanned");
        }
        $this$readZip64EocdRecord.skip(8L);
        long centralDirectoryOffset = $this$readZip64EocdRecord.readLongLe();
        return new EocdRecord(entryCount, centralDirectoryOffset, regularRecord.getCommentByteCount());
    }

    private static final void readExtra(BufferedSource $this$readExtra, int extraSize, Function2<? super Integer, ? super Long, Unit> function2) throws IOException {
        long remaining = extraSize;
        while (remaining != 0) {
            if (remaining < 4) {
                throw new IOException("bad zip: truncated header in extra field");
            }
            int headerId = $this$readExtra.readShortLe() & UShort.MAX_VALUE;
            long dataSize = ((long) $this$readExtra.readShortLe()) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
            long remaining2 = remaining - ((long) 4);
            if (remaining2 < dataSize) {
                throw new IOException("bad zip: truncated value in extra field");
            }
            $this$readExtra.require(dataSize);
            long sizeBefore = $this$readExtra.getBuffer().size();
            function2.invoke(Integer.valueOf(headerId), Long.valueOf(dataSize));
            long fieldRemaining = ($this$readExtra.getBuffer().size() + dataSize) - sizeBefore;
            if (fieldRemaining < 0) {
                throw new IOException("unsupported zip: too many bytes processed for " + headerId);
            }
            if (fieldRemaining > 0) {
                $this$readExtra.getBuffer().skip(fieldRemaining);
            }
            remaining = remaining2 - dataSize;
        }
    }

    public static final void skipLocalHeader(BufferedSource $this$skipLocalHeader) throws IOException {
        Intrinsics.checkNotNullParameter($this$skipLocalHeader, "<this>");
        readOrSkipLocalHeader($this$skipLocalHeader, null);
    }

    public static final ZipEntry readLocalHeader(BufferedSource $this$readLocalHeader, ZipEntry centralDirectoryZipEntry) throws IOException {
        Intrinsics.checkNotNullParameter($this$readLocalHeader, "<this>");
        Intrinsics.checkNotNullParameter(centralDirectoryZipEntry, "centralDirectoryZipEntry");
        ZipEntry orSkipLocalHeader = readOrSkipLocalHeader($this$readLocalHeader, centralDirectoryZipEntry);
        Intrinsics.checkNotNull(orSkipLocalHeader);
        return orSkipLocalHeader;
    }

    private static final ZipEntry readOrSkipLocalHeader(final BufferedSource $this$readOrSkipLocalHeader, ZipEntry centralDirectoryZipEntry) throws IOException {
        int signature = $this$readOrSkipLocalHeader.readIntLe();
        if (signature != LOCAL_FILE_HEADER_SIGNATURE) {
            throw new IOException("bad zip: expected " + getHex(LOCAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(signature));
        }
        $this$readOrSkipLocalHeader.skip(2L);
        int bitFlag = $this$readOrSkipLocalHeader.readShortLe() & UShort.MAX_VALUE;
        if ((bitFlag & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + getHex(bitFlag));
        }
        $this$readOrSkipLocalHeader.skip(18L);
        long fileNameLength = ((long) $this$readOrSkipLocalHeader.readShortLe()) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        int extraSize = 65535 & $this$readOrSkipLocalHeader.readShortLe();
        $this$readOrSkipLocalHeader.skip(fileNameLength);
        if (centralDirectoryZipEntry == null) {
            $this$readOrSkipLocalHeader.skip(extraSize);
            return null;
        }
        final Ref.ObjectRef extendedLastModifiedAtSeconds = new Ref.ObjectRef();
        final Ref.ObjectRef extendedLastAccessedAtSeconds = new Ref.ObjectRef();
        final Ref.ObjectRef extendedCreatedAtSeconds = new Ref.ObjectRef();
        readExtra($this$readOrSkipLocalHeader, extraSize, new Function2() {
            @Override
            public final Object invoke(Object obj, Object obj2) {
                return ZipFilesKt.readOrSkipLocalHeader$lambda$0($this$readOrSkipLocalHeader, extendedLastModifiedAtSeconds, extendedLastAccessedAtSeconds, extendedCreatedAtSeconds, ((Integer) obj).intValue(), ((Long) obj2).longValue());
            }
        });
        return centralDirectoryZipEntry.copy$okio((Integer) extendedLastModifiedAtSeconds.element, (Integer) extendedLastAccessedAtSeconds.element, (Integer) extendedCreatedAtSeconds.element);
    }

    public static final Unit readOrSkipLocalHeader$lambda$0(BufferedSource $this_readOrSkipLocalHeader, Ref.ObjectRef $extendedLastModifiedAtSeconds, Ref.ObjectRef $extendedLastAccessedAtSeconds, Ref.ObjectRef $extendedCreatedAtSeconds, int headerId, long dataSize) throws IOException {
        if (headerId == HEADER_ID_EXTENDED_TIMESTAMP) {
            if (dataSize < 1) {
                throw new IOException("bad zip: extended timestamp extra too short");
            }
            int flags = $this_readOrSkipLocalHeader.readByte() & KotlinVersion.MAX_COMPONENT_VALUE;
            boolean hasLastModifiedAtMillis = (flags & 1) == 1;
            boolean hasLastAccessedAtMillis = (flags & 2) == 2;
            boolean hasCreatedAtMillis = (flags & 4) == 4;
            long result = hasLastModifiedAtMillis ? 1 + 4 : 1L;
            if (hasLastAccessedAtMillis) {
                result += 4;
            }
            if (hasCreatedAtMillis) {
                result += 4;
            }
            if (dataSize < result) {
                throw new IOException("bad zip: extended timestamp extra too short");
            }
            if (hasLastModifiedAtMillis) {
                $extendedLastModifiedAtSeconds.element = Integer.valueOf($this_readOrSkipLocalHeader.readIntLe());
            }
            if (hasLastAccessedAtMillis) {
                $extendedLastAccessedAtSeconds.element = Integer.valueOf($this_readOrSkipLocalHeader.readIntLe());
            }
            if (hasCreatedAtMillis) {
                $extendedCreatedAtSeconds.element = Integer.valueOf($this_readOrSkipLocalHeader.readIntLe());
            }
        }
        return Unit.INSTANCE;
    }

    public static final long filetimeToEpochMillis(long filetime) {
        return (filetime / ((long) 10000)) - 11644473600000L;
    }

    public static final Long dosDateTimeToEpochMillis(int date, int time) {
        if (time == -1) {
            return null;
        }
        return Long.valueOf(_ZlibJvmKt.datePartsToEpochMillis(((date >> 9) & 127) + 1980, (date >> 5) & 15, date & 31, (time >> 11) & 31, (time >> 5) & 63, (time & 31) << 1));
    }

    private static final String getHex(int $this$hex) {
        StringBuilder sbAppend = new StringBuilder().append("0x");
        String string = Integer.toString($this$hex, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return sbAppend.append(string).toString();
    }
}
