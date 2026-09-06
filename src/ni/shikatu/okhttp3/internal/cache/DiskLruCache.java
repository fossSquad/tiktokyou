package ni.shikatu.okhttp3.internal.cache;

import java.io.Closeable;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.NoSuchElementException;
import ni.shikatu.kotlin.ExceptionsKt;
import ni.shikatu.kotlin.KotlinNothingValueException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.markers.KMutableIterator;
import ni.shikatu.kotlin.text.Regex;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import ni.shikatu.okhttp3.internal._UtilCommonKt;
import ni.shikatu.okhttp3.internal._UtilJvmKt;
import ni.shikatu.okhttp3.internal.concurrent.Lockable;
import ni.shikatu.okhttp3.internal.concurrent.Task;
import ni.shikatu.okhttp3.internal.concurrent.TaskQueue;
import ni.shikatu.okhttp3.internal.concurrent.TaskRunner;
import ni.shikatu.okhttp3.internal.platform.Platform;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.BufferedSink;
import ni.shikatu.okio.BufferedSource;
import ni.shikatu.okio.FileSystem;
import ni.shikatu.okio.ForwardingFileSystem;
import ni.shikatu.okio.ForwardingSource;
import ni.shikatu.okio.Okio;
import ni.shikatu.okio.Path;
import ni.shikatu.okio.Sink;
import ni.shikatu.okio.Source;

@Metadata(d1 = {"\u0000\u0083\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010)\n\u0002\b\u0005*\u00019\u0018\u0000 a2\u00020\u00012\u00020\u00022\u00020\u0003:\u0004^_`aB7\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010;\u001a\u00020<J\b\u0010=\u001a\u00020<H\u0002J\b\u0010>\u001a\u00020!H\u0002J\u0010\u0010?\u001a\u00020<2\u0006\u0010@\u001a\u00020$H\u0002J\b\u0010A\u001a\u00020<H\u0002J\r\u0010B\u001a\u00020<H\u0000¢\u0006\u0002\bCJ\u0017\u0010D\u001a\b\u0018\u00010ER\u00020\u00002\u0006\u0010F\u001a\u00020$H\u0086\u0002J \u0010G\u001a\b\u0018\u00010HR\u00020\u00002\u0006\u0010F\u001a\u00020$2\b\b\u0002\u0010I\u001a\u00020\fH\u0007J\u0006\u0010\u001f\u001a\u00020\fJ!\u0010J\u001a\u00020<2\n\u0010K\u001a\u00060HR\u00020\u00002\u0006\u0010L\u001a\u00020+H\u0000¢\u0006\u0002\bMJ\b\u0010N\u001a\u00020+H\u0002J\u000e\u0010O\u001a\u00020+2\u0006\u0010F\u001a\u00020$J\u0019\u0010P\u001a\u00020+2\n\u0010Q\u001a\u00060%R\u00020\u0000H\u0000¢\u0006\u0002\bRJ\b\u0010S\u001a\u00020<H\u0002J\b\u0010T\u001a\u00020<H\u0016J\u0006\u0010U\u001a\u00020+J\b\u0010V\u001a\u00020<H\u0016J\u0006\u0010W\u001a\u00020<J\b\u0010X\u001a\u00020+H\u0002J\u0006\u0010Y\u001a\u00020<J\u0006\u0010Z\u001a\u00020<J\u0010\u0010[\u001a\u00020<2\u0006\u0010F\u001a\u00020$H\u0002J\u0010\u0010\\\u001a\f\u0012\b\u0012\u00060ER\u00020\u00000]R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R$\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R8\u0010\"\u001a&\u0012\u0004\u0012\u00020$\u0012\b\u0012\u00060%R\u00020\u00000#j\u0012\u0012\u0004\u0012\u00020$\u0012\b\u0012\u00060%R\u00020\u0000`&X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010.\u001a\u00020+X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u000e\u00103\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0004\n\u0002\u0010:¨\u0006b"}, d2 = {"Lni/shikatu/okhttp3/internal/cache/DiskLruCache;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "Lni/shikatu/okhttp3/internal/concurrent/Lockable;", "fileSystem", "Lni/shikatu/okio/FileSystem;", "directory", "Lni/shikatu/okio/Path;", "appVersion", _UrlKt.FRAGMENT_ENCODE_SET, "valueCount", "maxSize", _UrlKt.FRAGMENT_ENCODE_SET, "taskRunner", "Lni/shikatu/okhttp3/internal/concurrent/TaskRunner;", "<init>", "(Lokio/FileSystem;Lokio/Path;IIJLokhttp3/internal/concurrent/TaskRunner;)V", "getDirectory", "()Lokio/Path;", "getValueCount$okhttp", "()I", "getFileSystem$okhttp", "()Lokio/FileSystem;", "value", "getMaxSize", "()J", "setMaxSize", "(J)V", "journalFile", "journalFileTmp", "journalFileBackup", "size", "journalWriter", "Lni/shikatu/okio/BufferedSink;", "lruEntries", "Ljava/util/LinkedHashMap;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/internal/cache/DiskLruCache$Entry;", "Lni/shikatu/kotlin/collections/LinkedHashMap;", "getLruEntries$okhttp", "()Ljava/util/LinkedHashMap;", "redundantOpCount", "hasJournalErrors", _UrlKt.FRAGMENT_ENCODE_SET, "civilizedFileSystem", "initialized", "closed", "getClosed$okhttp", "()Z", "setClosed$okhttp", "(Z)V", "mostRecentTrimFailed", "mostRecentRebuildFailed", "nextSequenceNumber", "cleanupQueue", "Lni/shikatu/okhttp3/internal/concurrent/TaskQueue;", "cleanupTask", "ni/shikatu/okhttp3/internal/cache/DiskLruCache$cleanupTask$1", "Lni/shikatu/okhttp3/internal/cache/DiskLruCache$cleanupTask$1;", "initialize", _UrlKt.FRAGMENT_ENCODE_SET, "readJournal", "newJournalWriter", "readJournalLine", "line", "processJournal", "rebuildJournal", "rebuildJournal$okhttp", "get", "Lni/shikatu/okhttp3/internal/cache/DiskLruCache$Snapshot;", "key", "edit", "Lni/shikatu/okhttp3/internal/cache/DiskLruCache$Editor;", "expectedSequenceNumber", "completeEdit", "editor", "success", "completeEdit$okhttp", "journalRebuildRequired", "remove", "removeEntry", "entry", "removeEntry$okhttp", "checkNotClosed", "flush", "isClosed", "close", "trimToSize", "removeOldestEntry", "delete", "evictAll", "validateKey", "snapshots", _UrlKt.FRAGMENT_ENCODE_SET, "Snapshot", "Editor", "Entry", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DiskLruCache implements Closeable, Flushable, Lockable {
    private final int appVersion;
    private boolean civilizedFileSystem;
    private final TaskQueue cleanupQueue;
    private final DiskLruCache$cleanupTask$1 cleanupTask;
    private boolean closed;
    private final Path directory;
    private final FileSystem fileSystem;
    private boolean hasJournalErrors;
    private boolean initialized;
    private final Path journalFile;
    private final Path journalFileBackup;
    private final Path journalFileTmp;
    private BufferedSink journalWriter;
    private final LinkedHashMap<String, Entry> lruEntries;
    private long maxSize;
    private boolean mostRecentRebuildFailed;
    private boolean mostRecentTrimFailed;
    private long nextSequenceNumber;
    private int redundantOpCount;
    private long size;
    private final int valueCount;
    public static final Companion Companion = new Companion(null);
    public static final String JOURNAL_FILE = "journal";
    public static final String JOURNAL_FILE_TEMP = "journal.tmp";
    public static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    public static final String MAGIC = "libcore.io.DiskLruCache";
    public static final String VERSION_1 = "1";
    public static final long ANY_SEQUENCE_NUMBER = -1;
    public static final Regex LEGAL_KEY_PATTERN = new Regex("[a-z0-9_-]{1,120}");
    public static final String CLEAN = "CLEAN";
    public static final String DIRTY = "DIRTY";
    public static final String REMOVE = "REMOVE";
    public static final String READ = "READ";

    public final Editor edit(String str) throws IOException {
        Intrinsics.checkNotNullParameter(str, "key");
        return edit$default(this, str, 0L, 2, null);
    }

    public DiskLruCache(final FileSystem fileSystem, Path directory, int appVersion, int valueCount, long maxSize, TaskRunner taskRunner) {
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        this.directory = directory;
        this.appVersion = appVersion;
        this.valueCount = valueCount;
        this.fileSystem = new ForwardingFileSystem(fileSystem) {
            @Override
            public Sink sink(Path file, boolean mustCreate) {
                Intrinsics.checkNotNullParameter(file, "file");
                Path it = file.parent();
                if (it != null) {
                    createDirectories(it);
                }
                return super.sink(file, mustCreate);
            }
        };
        this.maxSize = maxSize;
        this.lruEntries = new LinkedHashMap<>(0, 0.75f, true);
        this.cleanupQueue = taskRunner.newQueue();
        final String str = _UtilJvmKt.okHttpName + " Cache";
        this.cleanupTask = new Task(str) {
            @Override
            public long runOnce() {
                DiskLruCache diskLruCache = this.this$0;
                DiskLruCache diskLruCache2 = this.this$0;
                synchronized (diskLruCache) {
                    if (diskLruCache2.initialized && !diskLruCache2.getClosed$okhttp()) {
                        try {
                            diskLruCache2.trimToSize();
                        } catch (IOException e) {
                            diskLruCache2.mostRecentTrimFailed = true;
                        }
                        try {
                            if (diskLruCache2.journalRebuildRequired()) {
                                diskLruCache2.rebuildJournal$okhttp();
                                diskLruCache2.redundantOpCount = 0;
                            }
                        } catch (IOException e2) {
                            diskLruCache2.mostRecentRebuildFailed = true;
                            BufferedSink bufferedSink = diskLruCache2.journalWriter;
                            if (bufferedSink != null) {
                                _UtilCommonKt.closeQuietly(bufferedSink);
                            }
                            diskLruCache2.journalWriter = Okio.buffer(Okio.blackhole());
                        }
                    }
                }
                return -1L;
            }
        };
        if (!(maxSize > 0)) {
            throw new IllegalArgumentException("maxSize <= 0".toString());
        }
        if (!(this.valueCount > 0)) {
            throw new IllegalArgumentException("valueCount <= 0".toString());
        }
        this.journalFile = this.directory.resolve(JOURNAL_FILE);
        this.journalFileTmp = this.directory.resolve(JOURNAL_FILE_TEMP);
        this.journalFileBackup = this.directory.resolve(JOURNAL_FILE_BACKUP);
    }

    public final Path getDirectory() {
        return this.directory;
    }

    public final int getValueCount$okhttp() {
        return this.valueCount;
    }

    public final FileSystem getFileSystem$okhttp() {
        return this.fileSystem;
    }

    public final synchronized long getMaxSize() {
        return this.maxSize;
    }

    public final synchronized void setMaxSize(long value) {
        this.maxSize = value;
        if (this.initialized) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        }
    }

    public final LinkedHashMap<String, Entry> getLruEntries$okhttp() {
        return this.lruEntries;
    }

    public final boolean getClosed$okhttp() {
        return this.closed;
    }

    public final void setClosed$okhttp(boolean z) {
        this.closed = z;
    }

    public final synchronized void initialize() throws IOException {
        DiskLruCache $this$assertLockHeld$iv = this;
        if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock($this$assertLockHeld$iv)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + $this$assertLockHeld$iv);
        }
        if (this.initialized) {
            return;
        }
        if (this.fileSystem.exists(this.journalFileBackup)) {
            if (this.fileSystem.exists(this.journalFile)) {
                this.fileSystem.delete(this.journalFileBackup);
            } else {
                this.fileSystem.atomicMove(this.journalFileBackup, this.journalFile);
            }
        }
        this.civilizedFileSystem = _UtilCommonKt.isCivilized(this.fileSystem, this.journalFileBackup);
        if (this.fileSystem.exists(this.journalFile)) {
            try {
                readJournal();
                processJournal();
                this.initialized = true;
                return;
            } catch (IOException journalIsCorrupt) {
                Platform.Companion.get().log("DiskLruCache " + this.directory + " is corrupt: " + journalIsCorrupt.getMessage() + ", removing", 5, journalIsCorrupt);
                try {
                    delete();
                    this.closed = false;
                    rebuildJournal$okhttp();
                    this.initialized = true;
                } catch (Throwable th) {
                    this.closed = false;
                    throw th;
                }
            }
        }
        rebuildJournal$okhttp();
        this.initialized = true;
    }

    private final void readJournal() throws Throwable {
        FileSystem this_$iv = this.fileSystem;
        Path file$iv = this.journalFile;
        Closeable $this$use$iv$iv = Okio.buffer(this_$iv.source(file$iv));
        Throwable thrown$iv$iv = null;
        try {
            BufferedSource it$iv = (BufferedSource) $this$use$iv$iv;
            String magic = it$iv.readUtf8LineStrict();
            String version = it$iv.readUtf8LineStrict();
            String appVersionString = it$iv.readUtf8LineStrict();
            String valueCountString = it$iv.readUtf8LineStrict();
            String blank = it$iv.readUtf8LineStrict();
            try {
                if (Intrinsics.areEqual(MAGIC, magic)) {
                    try {
                        if (Intrinsics.areEqual(VERSION_1, version) && Intrinsics.areEqual(String.valueOf(this.appVersion), appVersionString) && Intrinsics.areEqual(String.valueOf(this.valueCount), valueCountString)) {
                            if (!(blank.length() > 0)) {
                                int lineCount = 0;
                                while (true) {
                                    try {
                                        readJournalLine(it$iv.readUtf8LineStrict());
                                        lineCount++;
                                    } catch (EOFException e) {
                                        this.redundantOpCount = lineCount - this.lruEntries.size();
                                        if (!it$iv.exhausted()) {
                                            rebuildJournal$okhttp();
                                        } else {
                                            BufferedSink bufferedSink = this.journalWriter;
                                            if (bufferedSink != null) {
                                                _UtilCommonKt.closeQuietly(bufferedSink);
                                            }
                                            this.journalWriter = newJournalWriter();
                                        }
                                        Unit unit = Unit.INSTANCE;
                                        if ($this$use$iv$iv != null) {
                                            try {
                                                $this$use$iv$iv.close();
                                            } catch (Throwable t$iv$iv) {
                                                thrown$iv$iv = t$iv$iv;
                                            }
                                        }
                                        if (thrown$iv$iv == null) {
                                        } else {
                                            throw thrown$iv$iv;
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Throwable th) {
                        t$iv$iv = th;
                        thrown$iv$iv = t$iv$iv;
                        if ($this$use$iv$iv != null) {
                            try {
                                $this$use$iv$iv.close();
                            } catch (Throwable t$iv$iv2) {
                                ExceptionsKt.addSuppressed(thrown$iv$iv, t$iv$iv2);
                            }
                        }
                        if (thrown$iv$iv == null) {
                        } else {
                            throw thrown$iv$iv;
                        }
                    }
                }
                try {
                    throw new IOException("unexpected journal header: [" + magic + ", " + version + ", " + valueCountString + ", " + blank + AbstractJsonLexerKt.END_LIST);
                } catch (Throwable th2) {
                    t$iv$iv = th2;
                    thrown$iv$iv = t$iv$iv;
                    if ($this$use$iv$iv != null) {
                        $this$use$iv$iv.close();
                    }
                    if (thrown$iv$iv == null) {
                    } else {
                        throw thrown$iv$iv;
                    }
                }
            } catch (Throwable th3) {
                t$iv$iv = th3;
            }
        } catch (Throwable th4) {
            t$iv$iv = th4;
        }
    }

    private final BufferedSink newJournalWriter() throws IOException {
        Sink fileSink = this.fileSystem.appendingSink(this.journalFile);
        FaultHidingSink faultHidingSink = new FaultHidingSink(fileSink, new Function1() {
            @Override
            public final Object invoke(Object obj) {
                return DiskLruCache.newJournalWriter$lambda$0(this.f$0, (IOException) obj);
            }
        });
        return Okio.buffer(faultHidingSink);
    }

    public static final Unit newJournalWriter$lambda$0(DiskLruCache this$0, IOException it) {
        Intrinsics.checkNotNullParameter(it, "it");
        DiskLruCache $this$assertLockHeld$iv = this$0;
        if (!_UtilJvmKt.assertionsEnabled || Thread.holdsLock($this$assertLockHeld$iv)) {
            this$0.hasJournalErrors = true;
            return Unit.INSTANCE;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + $this$assertLockHeld$iv);
    }

    private final void readJournalLine(String line) throws IOException {
        String key;
        int firstSpace = StringsKt.indexOf$default((CharSequence) line, ' ', 0, false, 6, (Object) null);
        if (firstSpace == -1) {
            throw new IOException("unexpected journal line: " + line);
        }
        int keyBegin = firstSpace + 1;
        int secondSpace = StringsKt.indexOf$default((CharSequence) line, ' ', keyBegin, false, 4, (Object) null);
        if (secondSpace == -1) {
            key = line.substring(keyBegin);
            Intrinsics.checkNotNullExpressionValue(key, "substring(...)");
            if (firstSpace == REMOVE.length() && StringsKt.startsWith$default(line, REMOVE, false, 2, (Object) null)) {
                this.lruEntries.remove(key);
                return;
            }
        } else {
            key = line.substring(keyBegin, secondSpace);
            Intrinsics.checkNotNullExpressionValue(key, "substring(...)");
        }
        Entry entry = this.lruEntries.get(key);
        if (entry == null) {
            entry = new Entry(this, key);
            this.lruEntries.put(key, entry);
        }
        if (secondSpace != -1 && firstSpace == CLEAN.length() && StringsKt.startsWith$default(line, CLEAN, false, 2, (Object) null)) {
            String strSubstring = line.substring(secondSpace + 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            List<String> listSplit$default = StringsKt.split$default((CharSequence) strSubstring, new char[]{' '}, false, 0, 6, (Object) null);
            entry.setReadable$okhttp(true);
            entry.setCurrentEditor$okhttp(null);
            entry.setLengths$okhttp(listSplit$default);
            return;
        }
        if (secondSpace == -1 && firstSpace == DIRTY.length() && StringsKt.startsWith$default(line, DIRTY, false, 2, (Object) null)) {
            entry.setCurrentEditor$okhttp(new Editor(this, entry));
        } else if (secondSpace != -1 || firstSpace != READ.length() || !StringsKt.startsWith$default(line, READ, false, 2, (Object) null)) {
            throw new IOException("unexpected journal line: " + line);
        }
    }

    private final void processJournal() throws IOException {
        _UtilCommonKt.deleteIfExists(this.fileSystem, this.journalFileTmp);
        Iterator<Entry> it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            Entry entry = next;
            if (entry.getCurrentEditor$okhttp() == null) {
                int i = this.valueCount;
                for (int t = 0; t < i; t++) {
                    this.size += entry.getLengths$okhttp()[t];
                }
            } else {
                entry.setCurrentEditor$okhttp(null);
                int i2 = this.valueCount;
                for (int t2 = 0; t2 < i2; t2++) {
                    _UtilCommonKt.deleteIfExists(this.fileSystem, entry.getCleanFiles$okhttp().get(t2));
                    _UtilCommonKt.deleteIfExists(this.fileSystem, entry.getDirtyFiles$okhttp().get(t2));
                }
                it.remove();
            }
        }
    }

    public final synchronized void rebuildJournal$okhttp() throws IOException {
        BufferedSink bufferedSink = this.journalWriter;
        if (bufferedSink != null) {
            bufferedSink.close();
        }
        FileSystem $this$iv = this.fileSystem;
        Path file$iv = this.journalFileTmp;
        Closeable $this$use$iv$iv = Okio.buffer($this$iv.sink(file$iv, false));
        Throwable thrown$iv$iv = null;
        try {
            BufferedSink it$iv = (BufferedSink) $this$use$iv$iv;
            it$iv.writeUtf8(MAGIC).writeByte(10);
            it$iv.writeUtf8(VERSION_1).writeByte(10);
            it$iv.writeDecimalLong(this.appVersion).writeByte(10);
            it$iv.writeDecimalLong(this.valueCount).writeByte(10);
            it$iv.writeByte(10);
            for (Entry entry : this.lruEntries.values()) {
                Intrinsics.checkNotNullExpressionValue(entry, "next(...)");
                Entry entry2 = entry;
                if (entry2.getCurrentEditor$okhttp() != null) {
                    it$iv.writeUtf8(DIRTY).writeByte(32);
                    it$iv.writeUtf8(entry2.getKey$okhttp());
                    it$iv.writeByte(10);
                } else {
                    it$iv.writeUtf8(CLEAN).writeByte(32);
                    it$iv.writeUtf8(entry2.getKey$okhttp());
                    entry2.writeLengths$okhttp(it$iv);
                    it$iv.writeByte(10);
                }
            }
            Unit unit = Unit.INSTANCE;
            if ($this$use$iv$iv != null) {
                try {
                    $this$use$iv$iv.close();
                } catch (Throwable t$iv$iv) {
                    thrown$iv$iv = t$iv$iv;
                }
            }
        } catch (Throwable t$iv$iv2) {
            thrown$iv$iv = t$iv$iv2;
            if ($this$use$iv$iv != null) {
                try {
                    $this$use$iv$iv.close();
                } catch (Throwable t$iv$iv3) {
                    ExceptionsKt.addSuppressed(thrown$iv$iv, t$iv$iv3);
                }
            }
        }
        if (thrown$iv$iv == null) {
            if (this.fileSystem.exists(this.journalFile)) {
                this.fileSystem.atomicMove(this.journalFile, this.journalFileBackup);
                this.fileSystem.atomicMove(this.journalFileTmp, this.journalFile);
                _UtilCommonKt.deleteIfExists(this.fileSystem, this.journalFileBackup);
            } else {
                this.fileSystem.atomicMove(this.journalFileTmp, this.journalFile);
            }
            BufferedSink bufferedSink2 = this.journalWriter;
            if (bufferedSink2 != null) {
                _UtilCommonKt.closeQuietly(bufferedSink2);
            }
            this.journalWriter = newJournalWriter();
            this.hasJournalErrors = false;
            this.mostRecentRebuildFailed = false;
        } else {
            throw thrown$iv$iv;
        }
    }

    public final synchronized Snapshot get(String key) throws IOException {
        Intrinsics.checkNotNullParameter(key, "key");
        initialize();
        checkNotClosed();
        validateKey(key);
        Entry entry = this.lruEntries.get(key);
        if (entry == null) {
            return null;
        }
        Snapshot snapshot = entry.snapshot$okhttp();
        if (snapshot == null) {
            return null;
        }
        this.redundantOpCount++;
        BufferedSink bufferedSink = this.journalWriter;
        Intrinsics.checkNotNull(bufferedSink);
        bufferedSink.writeUtf8(READ).writeByte(32).writeUtf8(key).writeByte(10);
        if (journalRebuildRequired()) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        }
        return snapshot;
    }

    public static  Editor edit$default(DiskLruCache diskLruCache, String str, long j, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            j = ANY_SEQUENCE_NUMBER;
        }
        return diskLruCache.edit(str, j);
    }

    public final synchronized Editor edit(String key, long expectedSequenceNumber) throws IOException {
        Intrinsics.checkNotNullParameter(key, "key");
        initialize();
        checkNotClosed();
        validateKey(key);
        Entry entry = this.lruEntries.get(key);
        if (expectedSequenceNumber != ANY_SEQUENCE_NUMBER && (entry == null || entry.getSequenceNumber$okhttp() != expectedSequenceNumber)) {
            return null;
        }
        if ((entry != null ? entry.getCurrentEditor$okhttp() : null) != null) {
            return null;
        }
        if (entry != null && entry.getLockingSourceCount$okhttp() != 0) {
            return null;
        }
        if (!this.mostRecentTrimFailed && !this.mostRecentRebuildFailed) {
            BufferedSink journalWriter = this.journalWriter;
            Intrinsics.checkNotNull(journalWriter);
            journalWriter.writeUtf8(DIRTY).writeByte(32).writeUtf8(key).writeByte(10);
            journalWriter.flush();
            if (this.hasJournalErrors) {
                return null;
            }
            if (entry == null) {
                entry = new Entry(this, key);
                this.lruEntries.put(key, entry);
            }
            Editor editor = new Editor(this, entry);
            entry.setCurrentEditor$okhttp(editor);
            return editor;
        }
        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        return null;
    }

    public final synchronized long size() throws IOException {
        initialize();
        return this.size;
    }

    public final synchronized void completeEdit$okhttp(Editor editor, boolean success) throws IOException {
        Intrinsics.checkNotNullParameter(editor, "editor");
        Entry entry = editor.getEntry$okhttp();
        if (!Intrinsics.areEqual(entry.getCurrentEditor$okhttp(), editor)) {
            throw new IllegalStateException("Check failed.");
        }
        if (success && !entry.getReadable$okhttp()) {
            int i = this.valueCount;
            for (int i2 = 0; i2 < i; i2++) {
                boolean[] written$okhttp = editor.getWritten$okhttp();
                Intrinsics.checkNotNull(written$okhttp);
                if (!written$okhttp[i2]) {
                    editor.abort();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                }
                if (!this.fileSystem.exists(entry.getDirtyFiles$okhttp().get(i2))) {
                    editor.abort();
                    return;
                }
            }
        }
        int i3 = this.valueCount;
        for (int i4 = 0; i4 < i3; i4++) {
            Path dirty = entry.getDirtyFiles$okhttp().get(i4);
            if (success && !entry.getZombie$okhttp()) {
                if (this.fileSystem.exists(dirty)) {
                    Path clean = entry.getCleanFiles$okhttp().get(i4);
                    this.fileSystem.atomicMove(dirty, clean);
                    long oldLength = entry.getLengths$okhttp()[i4];
                    Long size = this.fileSystem.metadata(clean).getSize();
                    long newLength = size != null ? size.longValue() : 0L;
                    entry.getLengths$okhttp()[i4] = newLength;
                    this.size = (this.size - oldLength) + newLength;
                }
            } else {
                _UtilCommonKt.deleteIfExists(this.fileSystem, dirty);
            }
        }
        entry.setCurrentEditor$okhttp(null);
        if (entry.getZombie$okhttp()) {
            removeEntry$okhttp(entry);
            return;
        }
        this.redundantOpCount++;
        BufferedSink $this$completeEdit_u24lambda_u240 = this.journalWriter;
        Intrinsics.checkNotNull($this$completeEdit_u24lambda_u240);
        if (entry.getReadable$okhttp() || success) {
            entry.setReadable$okhttp(true);
            $this$completeEdit_u24lambda_u240.writeUtf8(CLEAN).writeByte(32);
            $this$completeEdit_u24lambda_u240.writeUtf8(entry.getKey$okhttp());
            entry.writeLengths$okhttp($this$completeEdit_u24lambda_u240);
            $this$completeEdit_u24lambda_u240.writeByte(10);
            if (success) {
                long j = this.nextSequenceNumber;
                this.nextSequenceNumber = 1 + j;
                entry.setSequenceNumber$okhttp(j);
            }
        } else {
            this.lruEntries.remove(entry.getKey$okhttp());
            $this$completeEdit_u24lambda_u240.writeUtf8(REMOVE).writeByte(32);
            $this$completeEdit_u24lambda_u240.writeUtf8(entry.getKey$okhttp());
            $this$completeEdit_u24lambda_u240.writeByte(10);
        }
        $this$completeEdit_u24lambda_u240.flush();
        if (this.size > this.maxSize || journalRebuildRequired()) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        }
    }

    public final boolean journalRebuildRequired() {
        return this.redundantOpCount >= 2000 && this.redundantOpCount >= this.lruEntries.size();
    }

    public final synchronized boolean remove(String key) throws IOException {
        Intrinsics.checkNotNullParameter(key, "key");
        initialize();
        checkNotClosed();
        validateKey(key);
        Entry entry = this.lruEntries.get(key);
        if (entry == null) {
            return false;
        }
        boolean removed = removeEntry$okhttp(entry);
        if (removed && this.size <= this.maxSize) {
            this.mostRecentTrimFailed = false;
        }
        return removed;
    }

    public final boolean removeEntry$okhttp(Entry entry) throws IOException {
        BufferedSink it;
        Intrinsics.checkNotNullParameter(entry, "entry");
        if (!this.civilizedFileSystem) {
            if (entry.getLockingSourceCount$okhttp() > 0 && (it = this.journalWriter) != null) {
                it.writeUtf8(DIRTY);
                it.writeByte(32);
                it.writeUtf8(entry.getKey$okhttp());
                it.writeByte(10);
                it.flush();
            }
            if (entry.getLockingSourceCount$okhttp() > 0 || entry.getCurrentEditor$okhttp() != null) {
                entry.setZombie$okhttp(true);
                return true;
            }
        }
        Editor currentEditor$okhttp = entry.getCurrentEditor$okhttp();
        if (currentEditor$okhttp != null) {
            currentEditor$okhttp.detach$okhttp();
        }
        int i = this.valueCount;
        for (int i2 = 0; i2 < i; i2++) {
            _UtilCommonKt.deleteIfExists(this.fileSystem, entry.getCleanFiles$okhttp().get(i2));
            this.size -= entry.getLengths$okhttp()[i2];
            entry.getLengths$okhttp()[i2] = 0;
        }
        int i3 = this.redundantOpCount;
        this.redundantOpCount = i3 + 1;
        BufferedSink it2 = this.journalWriter;
        if (it2 != null) {
            it2.writeUtf8(REMOVE);
            it2.writeByte(32);
            it2.writeUtf8(entry.getKey$okhttp());
            it2.writeByte(10);
        }
        this.lruEntries.remove(entry.getKey$okhttp());
        if (journalRebuildRequired()) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        }
        return true;
    }

    private final synchronized void checkNotClosed() {
        if (this.closed) {
            throw new IllegalStateException("cache is closed".toString());
        }
    }

    @Override
    public synchronized void flush() throws IOException {
        if (this.initialized) {
            checkNotClosed();
            trimToSize();
            BufferedSink bufferedSink = this.journalWriter;
            Intrinsics.checkNotNull(bufferedSink);
            bufferedSink.flush();
        }
    }

    public final synchronized boolean isClosed() {
        return this.closed;
    }

    @Override
    public synchronized void close() throws IOException {
        Editor currentEditor$okhttp;
        if (this.initialized && !this.closed) {
            Collection<Entry> collectionValues = this.lruEntries.values();
            Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
            for (Entry entry : (Entry[]) collectionValues.toArray(new Entry[0])) {
                Intrinsics.checkNotNull(entry);
                if (entry.getCurrentEditor$okhttp() != null && (currentEditor$okhttp = entry.getCurrentEditor$okhttp()) != null) {
                    currentEditor$okhttp.detach$okhttp();
                }
            }
            trimToSize();
            BufferedSink bufferedSink = this.journalWriter;
            if (bufferedSink != null) {
                _UtilCommonKt.closeQuietly(bufferedSink);
            }
            this.journalWriter = null;
            this.closed = true;
            return;
        }
        this.closed = true;
    }

    public final void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            if (!removeOldestEntry()) {
                return;
            }
        }
        this.mostRecentTrimFailed = false;
    }

    private final boolean removeOldestEntry() throws IOException {
        for (Entry entry : this.lruEntries.values()) {
            Intrinsics.checkNotNullExpressionValue(entry, "next(...)");
            Entry toEvict = entry;
            if (!toEvict.getZombie$okhttp()) {
                removeEntry$okhttp(toEvict);
                return true;
            }
        }
        return false;
    }

    public final void delete() throws IOException {
        close();
        _UtilCommonKt.deleteContents(this.fileSystem, this.directory);
    }

    public final synchronized void evictAll() throws IOException {
        initialize();
        Collection<Entry> collectionValues = this.lruEntries.values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
        for (Entry entry : (Entry[]) collectionValues.toArray(new Entry[0])) {
            Intrinsics.checkNotNull(entry);
            removeEntry$okhttp(entry);
        }
        this.mostRecentTrimFailed = false;
    }

    private final void validateKey(String key) {
        if (!LEGAL_KEY_PATTERN.matches(key)) {
            throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + key + '\"').toString());
        }
    }

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001J\t\u0010\n\u001a\u00020\u000bH\u0096\u0002J\r\u0010\f\u001a\u00060\u0002R\u00020\u0003H\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016R.\u0010\u0004\u001a\"\u0012\u001e\u0012\u001c \u0007*\r\u0018\u00010\u0005R\u00020\u0003¢\u0006\u0002\b\u00060\u0005R\u00020\u0003¢\u0006\u0002\b\u00060\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0018\u00010\u0002R\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0018\u00010\u0002R\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"ni/shikatu/okhttp3/internal/cache/DiskLruCache$snapshots$1", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/internal/cache/DiskLruCache$Snapshot;", "Lni/shikatu/okhttp3/internal/cache/DiskLruCache;", "delegate", "Lni/shikatu/okhttp3/internal/cache/DiskLruCache$Entry;", "Lni/shikatu/kotlin/jvm/internal/EnhancedNullability;", "ni.shikatu.kotlin.jvm.PlatformType", "nextSnapshot", "removeSnapshot", "hasNext", _UrlKt.FRAGMENT_ENCODE_SET, "next", "remove", _UrlKt.FRAGMENT_ENCODE_SET, "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class AnonymousClass1 implements Iterator<Snapshot>, KMutableIterator {
        private final Iterator<Entry> delegate;
        private Snapshot nextSnapshot;
        private Snapshot removeSnapshot;

        AnonymousClass1() {
            Iterator<Entry> it = new ArrayList(DiskLruCache.this.getLruEntries$okhttp().values()).iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            this.delegate = it;
        }

        @Override
        public boolean hasNext() {
            Snapshot snapshotSnapshot$okhttp;
            if (this.nextSnapshot != null) {
                return true;
            }
            DiskLruCache diskLruCache = DiskLruCache.this;
            DiskLruCache diskLruCache2 = DiskLruCache.this;
            synchronized (diskLruCache) {
                if (diskLruCache2.getClosed$okhttp()) {
                    return false;
                }
                while (this.delegate.hasNext()) {
                    Entry next = this.delegate.next();
                    if (next != null && (snapshotSnapshot$okhttp = next.snapshot$okhttp()) != null) {
                        this.nextSnapshot = snapshotSnapshot$okhttp;
                        return true;
                    }
                }
                Unit unit = Unit.INSTANCE;
                return false;
            }
        }

        @Override
        public Snapshot next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.removeSnapshot = this.nextSnapshot;
            this.nextSnapshot = null;
            Snapshot snapshot = this.removeSnapshot;
            Intrinsics.checkNotNull(snapshot);
            return snapshot;
        }

        @Override
        public void remove() {
            Snapshot removeSnapshot = this.removeSnapshot;
            if (removeSnapshot == null) {
                throw new IllegalStateException("remove() before next()".toString());
            }
            try {
                DiskLruCache.this.remove(removeSnapshot.key());
            } catch (IOException e) {
            } finally {
                this.removeSnapshot = null;
            }
        }
    }

    public final synchronized Iterator<Snapshot> snapshots() throws IOException {
        initialize();
        return new AnonymousClass1();
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B/\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0002\u001a\u00020\u0003J\f\u0010\r\u001a\b\u0018\u00010\u000eR\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lni/shikatu/okhttp3/internal/cache/DiskLruCache$Snapshot;", "Ljava/io/Closeable;", "key", _UrlKt.FRAGMENT_ENCODE_SET, "sequenceNumber", _UrlKt.FRAGMENT_ENCODE_SET, "sources", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okio/Source;", "lengths", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Lokhttp3/internal/cache/DiskLruCache;Ljava/lang/String;JLjava/util/List;[J)V", "edit", "Lni/shikatu/okhttp3/internal/cache/DiskLruCache$Editor;", "Lni/shikatu/okhttp3/internal/cache/DiskLruCache;", "getSource", "index", _UrlKt.FRAGMENT_ENCODE_SET, "getLength", "close", _UrlKt.FRAGMENT_ENCODE_SET, "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class Snapshot implements Closeable {
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        private final List<Source> sources;
        final  DiskLruCache this$0;

        public Snapshot(DiskLruCache this$0, String key, long sequenceNumber, List<? extends Source> list, long[] lengths) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(list, "sources");
            Intrinsics.checkNotNullParameter(lengths, "lengths");
            this.this$0 = this$0;
            this.key = key;
            this.sequenceNumber = sequenceNumber;
            this.sources = list;
            this.lengths = lengths;
        }

        public final String key() {
            return this.key;
        }

        public final Editor edit() throws IOException {
            return this.this$0.edit(this.key, this.sequenceNumber);
        }

        public final Source getSource(int index) {
            return this.sources.get(index);
        }

        public final long getLength(int index) {
            return this.lengths[index];
        }

        @Override
        public void close() {
            for (Source source : this.sources) {
                _UtilCommonKt.closeQuietly(source);
            }
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0018\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0015\b\u0000\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u000f\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0011J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0018\u001a\u00020\u0010J\u0006\u0010\u0019\u001a\u00020\u0010R\u0018\u0010\u0002\u001a\u00060\u0003R\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lni/shikatu/okhttp3/internal/cache/DiskLruCache$Editor;", _UrlKt.FRAGMENT_ENCODE_SET, "entry", "Lni/shikatu/okhttp3/internal/cache/DiskLruCache$Entry;", "Lni/shikatu/okhttp3/internal/cache/DiskLruCache;", "<init>", "(Lokhttp3/internal/cache/DiskLruCache;Lokhttp3/internal/cache/DiskLruCache$Entry;)V", "getEntry$okhttp", "()Lokhttp3/internal/cache/DiskLruCache$Entry;", "written", _UrlKt.FRAGMENT_ENCODE_SET, "getWritten$okhttp", "()[Z", "done", _UrlKt.FRAGMENT_ENCODE_SET, "detach", _UrlKt.FRAGMENT_ENCODE_SET, "detach$okhttp", "newSource", "Lni/shikatu/okio/Source;", "index", _UrlKt.FRAGMENT_ENCODE_SET, "newSink", "Lni/shikatu/okio/Sink;", "commit", "abort", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class Editor {
        private boolean done;
        private final Entry entry;
        final  DiskLruCache this$0;
        private final boolean[] written;

        public Editor(DiskLruCache this$0, Entry entry) {
            Intrinsics.checkNotNullParameter(entry, "entry");
            this.this$0 = this$0;
            this.entry = entry;
            this.written = this.entry.getReadable$okhttp() ? null : new boolean[this.this$0.getValueCount$okhttp()];
        }

        public final Entry getEntry$okhttp() {
            return this.entry;
        }

        public final boolean[] getWritten$okhttp() {
            return this.written;
        }

        public final void detach$okhttp() throws IOException {
            if (Intrinsics.areEqual(this.entry.getCurrentEditor$okhttp(), this)) {
                if (this.this$0.civilizedFileSystem) {
                    this.this$0.completeEdit$okhttp(this, false);
                } else {
                    this.entry.setZombie$okhttp(true);
                }
            }
        }

        public final Source newSource(int index) {
            Source source;
            DiskLruCache diskLruCache = this.this$0;
            DiskLruCache diskLruCache2 = this.this$0;
            synchronized (diskLruCache) {
                if (this.done) {
                    throw new IllegalStateException("Check failed.");
                }
                source = null;
                if (this.entry.getReadable$okhttp() && Intrinsics.areEqual(this.entry.getCurrentEditor$okhttp(), this) && !this.entry.getZombie$okhttp()) {
                    try {
                        source = diskLruCache2.getFileSystem$okhttp().source(this.entry.getCleanFiles$okhttp().get(index));
                    } catch (FileNotFoundException e) {
                    }
                }
            }
            return source;
        }

        public final Sink newSink(int index) {
            DiskLruCache diskLruCache = this.this$0;
            final DiskLruCache diskLruCache2 = this.this$0;
            synchronized (diskLruCache) {
                if (this.done) {
                    throw new IllegalStateException("Check failed.");
                }
                if (!Intrinsics.areEqual(this.entry.getCurrentEditor$okhttp(), this)) {
                    return Okio.blackhole();
                }
                if (!this.entry.getReadable$okhttp()) {
                    boolean[] zArr = this.written;
                    Intrinsics.checkNotNull(zArr);
                    zArr[index] = true;
                }
                Path dirtyFile = this.entry.getDirtyFiles$okhttp().get(index);
                try {
                    Sink sink = diskLruCache2.getFileSystem$okhttp().sink(dirtyFile);
                    return new FaultHidingSink(sink, new Function1() {
                        @Override
                        public final Object invoke(Object obj) {
                            return DiskLruCache.Editor.newSink$lambda$0$0(diskLruCache2, this, (IOException) obj);
                        }
                    });
                } catch (FileNotFoundException e) {
                    return Okio.blackhole();
                }
            }
        }

        public static final Unit newSink$lambda$0$0(DiskLruCache this$0, Editor this$1, IOException it) {
            Intrinsics.checkNotNullParameter(it, "it");
            synchronized (this$0) {
                this$1.detach$okhttp();
                Unit unit = Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }

        public final void commit() throws IOException {
            DiskLruCache diskLruCache = this.this$0;
            DiskLruCache diskLruCache2 = this.this$0;
            synchronized (diskLruCache) {
                if (this.done) {
                    throw new IllegalStateException("Check failed.");
                }
                if (Intrinsics.areEqual(this.entry.getCurrentEditor$okhttp(), this)) {
                    diskLruCache2.completeEdit$okhttp(this, true);
                }
                this.done = true;
                Unit unit = Unit.INSTANCE;
            }
        }

        public final void abort() throws IOException {
            DiskLruCache diskLruCache = this.this$0;
            DiskLruCache diskLruCache2 = this.this$0;
            synchronized (diskLruCache) {
                if (this.done) {
                    throw new IllegalStateException("Check failed.");
                }
                if (Intrinsics.areEqual(this.entry.getCurrentEditor$okhttp(), this)) {
                    diskLruCache2.completeEdit$okhttp(this, false);
                }
                this.done = true;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010/\u001a\u0002002\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u000302H\u0000¢\u0006\u0002\b3J\u0015\u00104\u001a\u0002002\u0006\u00105\u001a\u000206H\u0000¢\u0006\u0002\b7J\u0016\u00108\u001a\u0002092\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u000302H\u0002J\u0013\u0010:\u001a\b\u0018\u00010;R\u00020\u001eH\u0000¢\u0006\u0002\b<J\u0010\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020$H\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R \u0010\u001c\u001a\b\u0018\u00010\u001dR\u00020\u001eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020*X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u0006@"}, d2 = {"Lni/shikatu/okhttp3/internal/cache/DiskLruCache$Entry;", _UrlKt.FRAGMENT_ENCODE_SET, "key", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Lokhttp3/internal/cache/DiskLruCache;Ljava/lang/String;)V", "getKey$okhttp", "()Ljava/lang/String;", "lengths", _UrlKt.FRAGMENT_ENCODE_SET, "getLengths$okhttp", "()[J", "cleanFiles", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okio/Path;", "getCleanFiles$okhttp", "()Ljava/util/List;", "dirtyFiles", "getDirtyFiles$okhttp", "readable", _UrlKt.FRAGMENT_ENCODE_SET, "getReadable$okhttp", "()Z", "setReadable$okhttp", "(Z)V", "zombie", "getZombie$okhttp", "setZombie$okhttp", "currentEditor", "Lni/shikatu/okhttp3/internal/cache/DiskLruCache$Editor;", "Lni/shikatu/okhttp3/internal/cache/DiskLruCache;", "getCurrentEditor$okhttp", "()Lokhttp3/internal/cache/DiskLruCache$Editor;", "setCurrentEditor$okhttp", "(Lokhttp3/internal/cache/DiskLruCache$Editor;)V", "lockingSourceCount", _UrlKt.FRAGMENT_ENCODE_SET, "getLockingSourceCount$okhttp", "()I", "setLockingSourceCount$okhttp", "(I)V", "sequenceNumber", _UrlKt.FRAGMENT_ENCODE_SET, "getSequenceNumber$okhttp", "()J", "setSequenceNumber$okhttp", "(J)V", "setLengths", _UrlKt.FRAGMENT_ENCODE_SET, "strings", _UrlKt.FRAGMENT_ENCODE_SET, "setLengths$okhttp", "writeLengths", "writer", "Lni/shikatu/okio/BufferedSink;", "writeLengths$okhttp", "invalidLengths", _UrlKt.FRAGMENT_ENCODE_SET, "snapshot", "Lni/shikatu/okhttp3/internal/cache/DiskLruCache$Snapshot;", "snapshot$okhttp", "newSource", "Lni/shikatu/okio/Source;", "index", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class Entry {
        private final List<Path> cleanFiles;
        private Editor currentEditor;
        private final List<Path> dirtyFiles;
        private final String key;
        private final long[] lengths;
        private int lockingSourceCount;
        private boolean readable;
        private long sequenceNumber;
        final  DiskLruCache this$0;
        private boolean zombie;

        public Entry(DiskLruCache this$0, String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.this$0 = this$0;
            this.key = key;
            this.lengths = new long[this.this$0.getValueCount$okhttp()];
            this.cleanFiles = new ArrayList();
            this.dirtyFiles = new ArrayList();
            StringBuilder fileBuilder = new StringBuilder(this.key).append('.');
            int truncateTo = fileBuilder.length();
            int valueCount$okhttp = this.this$0.getValueCount$okhttp();
            for (int i = 0; i < valueCount$okhttp; i++) {
                fileBuilder.append(i);
                List<Path> list = this.cleanFiles;
                Path directory = this.this$0.getDirectory();
                String string = fileBuilder.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                list.add(directory.resolve(string));
                fileBuilder.append(".tmp");
                List<Path> list2 = this.dirtyFiles;
                Path directory2 = this.this$0.getDirectory();
                String string2 = fileBuilder.toString();
                Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                list2.add(directory2.resolve(string2));
                fileBuilder.setLength(truncateTo);
            }
        }

        public final String getKey$okhttp() {
            return this.key;
        }

        public final long[] getLengths$okhttp() {
            return this.lengths;
        }

        public final List<Path> getCleanFiles$okhttp() {
            return this.cleanFiles;
        }

        public final List<Path> getDirtyFiles$okhttp() {
            return this.dirtyFiles;
        }

        public final boolean getReadable$okhttp() {
            return this.readable;
        }

        public final void setReadable$okhttp(boolean z) {
            this.readable = z;
        }

        public final boolean getZombie$okhttp() {
            return this.zombie;
        }

        public final void setZombie$okhttp(boolean z) {
            this.zombie = z;
        }

        public final Editor getCurrentEditor$okhttp() {
            return this.currentEditor;
        }

        public final void setCurrentEditor$okhttp(Editor editor) {
            this.currentEditor = editor;
        }

        public final int getLockingSourceCount$okhttp() {
            return this.lockingSourceCount;
        }

        public final void setLockingSourceCount$okhttp(int i) {
            this.lockingSourceCount = i;
        }

        public final long getSequenceNumber$okhttp() {
            return this.sequenceNumber;
        }

        public final void setSequenceNumber$okhttp(long j) {
            this.sequenceNumber = j;
        }

        public final void setLengths$okhttp(List<String> list) throws IOException {
            Intrinsics.checkNotNullParameter(list, "strings");
            if (list.size() != this.this$0.getValueCount$okhttp()) {
                invalidLengths(list);
                throw new KotlinNothingValueException();
            }
            try {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    this.lengths[i] = Long.parseLong(list.get(i));
                }
            } catch (NumberFormatException e) {
                invalidLengths(list);
                throw new KotlinNothingValueException();
            }
        }

        public final void writeLengths$okhttp(BufferedSink writer) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            for (long length : this.lengths) {
                writer.writeByte(32).writeDecimalLong(length);
            }
        }

        private final Void invalidLengths(List<String> list) throws IOException {
            throw new IOException("unexpected journal line: " + list);
        }

        public final Snapshot snapshot$okhttp() {
            Lockable $this$assertLockHeld$iv = this.this$0;
            if (!_UtilJvmKt.assertionsEnabled || Thread.holdsLock($this$assertLockHeld$iv)) {
                if (!this.readable) {
                    return null;
                }
                if (!this.this$0.civilizedFileSystem && (this.currentEditor != null || this.zombie)) {
                    return null;
                }
                List<Source> sources = new ArrayList();
                long[] lengths = (long[]) this.lengths.clone();
                try {
                    int valueCount$okhttp = this.this$0.getValueCount$okhttp();
                    for (int i = 0; i < valueCount$okhttp; i++) {
                        sources.add(newSource(i));
                    }
                    return new Snapshot(this.this$0, this.key, this.sequenceNumber, sources, lengths);
                } catch (FileNotFoundException e) {
                    for (Source source : sources) {
                        _UtilCommonKt.closeQuietly(source);
                    }
                    try {
                        this.this$0.removeEntry$okhttp(this);
                    } catch (IOException e2) {
                    }
                    return null;
                }
            }
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + $this$assertLockHeld$iv);
        }

        private final Source newSource(int index) throws IOException {
            final Source fileSource = this.this$0.getFileSystem$okhttp().source(this.cleanFiles.get(index));
            if (this.this$0.civilizedFileSystem) {
                return fileSource;
            }
            this.lockingSourceCount++;
            final DiskLruCache diskLruCache = this.this$0;
            return new ForwardingSource(fileSource) {
                private boolean closed;

                @Override
                public void close() throws IOException {
                    super.close();
                    if (!this.closed) {
                        this.closed = true;
                        DiskLruCache diskLruCache2 = diskLruCache;
                        DiskLruCache.Entry entry = this;
                        DiskLruCache diskLruCache3 = diskLruCache;
                        synchronized (diskLruCache2) {
                            entry.setLockingSourceCount$okhttp(entry.getLockingSourceCount$okhttp() - 1);
                            if (entry.getLockingSourceCount$okhttp() == 0 && entry.getZombie$okhttp()) {
                                diskLruCache3.removeEntry$okhttp(entry);
                            }
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                }
            };
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000b8\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lni/shikatu/okhttp3/internal/cache/DiskLruCache$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "JOURNAL_FILE", _UrlKt.FRAGMENT_ENCODE_SET, "JOURNAL_FILE_TEMP", "JOURNAL_FILE_BACKUP", "MAGIC", "VERSION_1", "ANY_SEQUENCE_NUMBER", _UrlKt.FRAGMENT_ENCODE_SET, "LEGAL_KEY_PATTERN", "Lni/shikatu/kotlin/text/Regex;", "CLEAN", "DIRTY", "REMOVE", "READ", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
