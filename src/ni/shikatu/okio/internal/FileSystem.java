package ni.shikatu.okio.internal;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import ni.shikatu.kotlin.ExceptionsKt;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.ArrayDeque;
import ni.shikatu.kotlin.coroutines.Continuation;
import ni.shikatu.kotlin.coroutines.jvm.internal.ContinuationImpl;
import ni.shikatu.kotlin.coroutines.jvm.internal.DebugMetadata;
import ni.shikatu.kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.internal.IntCompanionObject;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.sequences.Sequence;
import ni.shikatu.kotlin.sequences.SequenceScope;
import ni.shikatu.kotlin.sequences.SequencesKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.BufferedSink;
import ni.shikatu.okio.FileMetadata;
import ni.shikatu.okio.Okio;
import ni.shikatu.okio.Path;
import ni.shikatu.okio.Source;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u001c\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0000\u001a\u001c\u0010\u000b\u001a\u00020\b*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0000\u001a\u001c\u0010\u000e\u001a\u00020\b*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006H\u0000\u001a\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012*\u00020\u00022\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0006H\u0000\u001aF\u0010\u0014\u001a\u00020\b*\b\u0012\u0004\u0012\u00020\u00040\u00152\u0006\u0010\u0016\u001a\u00020\u00022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00182\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0080@¢\u0006\u0002\u0010\u001a\u001a\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u001c"}, d2 = {"commonMetadata", "Lni/shikatu/okio/FileMetadata;", "Lni/shikatu/okio/FileSystem;", "path", "Lni/shikatu/okio/Path;", "commonExists", _UrlKt.FRAGMENT_ENCODE_SET, "commonCreateDirectories", _UrlKt.FRAGMENT_ENCODE_SET, "dir", "mustCreate", "commonCopy", "source", "target", "commonDeleteRecursively", "fileOrDirectory", "mustExist", "commonListRecursively", "Lni/shikatu/kotlin/sequences/Sequence;", "followSymlinks", "collectRecursively", "Lni/shikatu/kotlin/sequences/SequenceScope;", "fileSystem", "stack", "Lni/shikatu/kotlin/collections/ArrayDeque;", "postorder", "(Lkotlin/sequences/SequenceScope;Lokio/FileSystem;Lkotlin/collections/ArrayDeque;Lokio/Path;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "symlinkTarget", "ni.shikatu.okio"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FileSystem {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "ni.shikatu.okio.internal.-FileSystem", f = "FileSystem.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2}, l = {116, 135, 145}, m = "collectRecursively", n = {"$this$collectRecursively", "fileSystem", "stack", "path", "followSymlinks", "postorder", "$this$collectRecursively", "fileSystem", "stack", "path", "children", "symlinkPath", "child", "followSymlinks", "postorder", "symlinkCount", "$this$collectRecursively", "fileSystem", "stack", "path", "children", "followSymlinks", "postorder"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "Z$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "Z$0", "Z$1", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "Z$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        boolean Z$0;
        boolean Z$1;
        int label;
         Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= IntCompanionObject.MIN_VALUE;
            return FileSystem.collectRecursively(null, null, null, null, false, false, this);
        }
    }

    public static final FileMetadata commonMetadata(ni.shikatu.okio.FileSystem $this$commonMetadata, Path path) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonMetadata, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        FileMetadata fileMetadataMetadataOrNull = $this$commonMetadata.metadataOrNull(path);
        if (fileMetadataMetadataOrNull != null) {
            return fileMetadataMetadataOrNull;
        }
        throw new FileNotFoundException("no such file: " + path);
    }

    public static final boolean commonExists(ni.shikatu.okio.FileSystem $this$commonExists, Path path) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonExists, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        return $this$commonExists.metadataOrNull(path) != null;
    }

    public static final void commonCreateDirectories(ni.shikatu.okio.FileSystem $this$commonCreateDirectories, Path dir, boolean mustCreate) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonCreateDirectories, "<this>");
        Intrinsics.checkNotNullParameter(dir, "dir");
        ArrayDeque<Path> directories = new ArrayDeque();
        for (Path path = dir; path != null && !$this$commonCreateDirectories.exists(path); path = path.parent()) {
            directories.addFirst(path);
        }
        if (mustCreate && directories.isEmpty()) {
            throw new IOException(dir + " already exists.");
        }
        for (Path toCreate : directories) {
            ni.shikatu.okio.FileSystem.createDirectory$default($this$commonCreateDirectories, toCreate, false, 2, null);
        }
    }

    public static final void commonDeleteRecursively(ni.shikatu.okio.FileSystem $this$commonDeleteRecursively, Path fileOrDirectory, boolean mustExist) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonDeleteRecursively, "<this>");
        Intrinsics.checkNotNullParameter(fileOrDirectory, "fileOrDirectory");
        Sequence sequence = SequencesKt.sequence(new FileSystem$commonDeleteRecursively$sequence$1($this$commonDeleteRecursively, fileOrDirectory, null));
        Iterator iterator = sequence.iterator();
        while (iterator.hasNext()) {
            Path toDelete = (Path) iterator.next();
            $this$commonDeleteRecursively.delete(toDelete, mustExist && !iterator.hasNext());
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/sequences/SequenceScope;", "Lni/shikatu/okio/Path;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "ni.shikatu.okio.internal.-FileSystem$commonListRecursively$1", f = "FileSystem.kt", i = {0, 0, 0}, l = {96}, m = "invokeSuspend", n = {"$this$sequence", "stack", "child"}, s = {"L$0", "L$1", "L$3"}, v = 1)
    static final class C00281 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {
        final  Path $dir;
        final  boolean $followSymlinks;
        final  ni.shikatu.okio.FileSystem $this_commonListRecursively;
        private  Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        C00281(Path path, ni.shikatu.okio.FileSystem fileSystem, boolean z, Continuation<? super C00281> continuation) {
            super(2, continuation);
            this.$dir = path;
            this.$this_commonListRecursively = fileSystem;
            this.$followSymlinks = z;
        }

        @Override
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C00281 c00281 = new C00281(this.$dir, this.$this_commonListRecursively, this.$followSymlinks, continuation);
            c00281.L$0 = obj;
            return c00281;
        }

        @Override
        public final Object invoke(SequenceScope<? super Path> sequenceScope, Continuation<? super Unit> continuation) {
            return ((C00281) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = r10.L$0
                ni.shikatu.kotlin.sequences.SequenceScope r0 = (ni.shikatu.kotlin.sequences.SequenceScope) r0
                java.lang.Object r1 = ni.shikatu.kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r10.label
                switch(r2) {
                    case 0: goto L28;
                    case 1: goto L15;
                    default: goto Ld;
                }
            Ld:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L15:
                java.lang.Object r2 = r10.L$3
                ni.shikatu.okio.Path r2 = (ni.shikatu.okio.Path) r2
                java.lang.Object r3 = r10.L$2
                java.util.Iterator r3 = (java.util.Iterator) r3
                java.lang.Object r4 = r10.L$1
                ni.shikatu.kotlin.collections.ArrayDeque r4 = (ni.shikatu.kotlin.collections.ArrayDeque) r4
                ni.shikatu.kotlin.ResultKt.throwOnFailure(r11)
                r9 = r10
                r7 = r1
                r8 = r3
                goto L74
            L28:
                ni.shikatu.kotlin.ResultKt.throwOnFailure(r11)
                ni.shikatu.kotlin.collections.ArrayDeque r2 = new ni.shikatu.kotlin.collections.ArrayDeque
                r2.<init>()
                ni.shikatu.okio.Path r3 = r10.$dir
                r2.addLast(r3)
                ni.shikatu.okio.FileSystem r3 = r10.$this_commonListRecursively
                ni.shikatu.okio.Path r4 = r10.$dir
                java.util.List r3 = r3.list(r4)
                java.util.Iterator r3 = r3.iterator()
                r9 = r10
                r7 = r1
                r8 = r3
            L44:
                boolean r1 = r8.hasNext()
                if (r1 == 0) goto L76
                java.lang.Object r1 = r8.next()
                r3 = r1
                ni.shikatu.okio.Path r3 = (ni.shikatu.okio.Path) r3
                ni.shikatu.okio.FileSystem r1 = r9.$this_commonListRecursively
                boolean r4 = r9.$followSymlinks
                r6 = r9
                ni.shikatu.kotlin.coroutines.Continuation r6 = (ni.shikatu.kotlin.coroutines.Continuation) r6
                r9.L$0 = r0
                r9.L$1 = r2
                r9.L$2 = r8
                java.lang.Object r5 = ni.shikatu.kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
                r9.L$3 = r5
                r5 = 1
                r9.label = r5
                r5 = 0
                java.lang.Object r1 = ni.shikatu.okio.internal.FileSystem.collectRecursively(r0, r1, r2, r3, r4, r5, r6)
                if (r1 != r7) goto L72
                return r7
            L72:
                r4 = r2
                r2 = r3
            L74:
                r2 = r4
                goto L44
            L76:
                ni.shikatu.kotlin.Unit r1 = ni.shikatu.kotlin.Unit.INSTANCE
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: ni.shikatu.okio.internal.FileSystem.C00281.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final Sequence<Path> commonListRecursively(ni.shikatu.okio.FileSystem $this$commonListRecursively, Path dir, boolean followSymlinks) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonListRecursively, "<this>");
        Intrinsics.checkNotNullParameter(dir, "dir");
        return SequencesKt.sequence(new C00281(dir, $this$commonListRecursively, followSymlinks, null));
    }

    public static final java.lang.Object collectRecursively(ni.shikatu.kotlin.sequences.SequenceScope<? super ni.shikatu.okio.Path> r18, ni.shikatu.okio.FileSystem r19, ni.shikatu.kotlin.collections.ArrayDeque<ni.shikatu.okio.Path> r20, ni.shikatu.okio.Path r21, boolean r22, boolean r23, ni.shikatu.kotlin.coroutines.Continuation<? super ni.shikatu.kotlin.Unit> r24) {

        throw new UnsupportedOperationException("Method not decompiled: ni.shikatu.okio.internal.FileSystem.collectRecursively(ni.shikatu.kotlin.sequences.SequenceScope, ni.shikatu.okio.FileSystem, ni.shikatu.kotlin.collections.ArrayDeque, ni.shikatu.okio.Path, boolean, boolean, ni.shikatu.kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Path symlinkTarget(ni.shikatu.okio.FileSystem $this$symlinkTarget, Path path) throws IOException {
        Intrinsics.checkNotNullParameter($this$symlinkTarget, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        Path target = $this$symlinkTarget.metadata(path).getSymlinkTarget();
        if (target == null) {
            return null;
        }
        Path pathParent = path.parent();
        Intrinsics.checkNotNull(pathParent);
        return pathParent.resolve(target);
    }

    public static final void commonCopy(ni.shikatu.okio.FileSystem $this$commonCopy, Path source, Path target) throws IOException {
        Object result$iv;
        Intrinsics.checkNotNullParameter($this$commonCopy, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        Closeable $this$use$iv = $this$commonCopy.source(source);
        Throwable thrown$iv = null;
        Object result$iv2 = null;
        try {
            Source bytesIn = (Source) $this$use$iv;
            Closeable $this$use$iv2 = Okio.buffer(ni.shikatu.okio.FileSystem.sink$default($this$commonCopy, target, false, 2, null));
            Throwable thrown$iv2 = null;
            try {
                BufferedSink bytesOut = (BufferedSink) $this$use$iv2;
                result$iv = Long.valueOf(bytesOut.writeAll(bytesIn));
                if ($this$use$iv2 != null) {
                    try {
                        $this$use$iv2.close();
                    } catch (Throwable t$iv) {
                        thrown$iv2 = t$iv;
                    }
                }
            } catch (Throwable t$iv2) {
                thrown$iv2 = t$iv2;
                if ($this$use$iv2 != null) {
                    try {
                        $this$use$iv2.close();
                    } catch (Throwable t$iv3) {
                        ExceptionsKt.addSuppressed(thrown$iv2, t$iv3);
                    }
                }
                result$iv = null;
            }
            if (thrown$iv2 != null) {
                throw thrown$iv2;
            }
            result$iv2 = Long.valueOf(((Number) result$iv).longValue());
            if ($this$use$iv != null) {
                try {
                    $this$use$iv.close();
                } catch (Throwable t$iv4) {
                    thrown$iv = t$iv4;
                }
            }
            if (thrown$iv == null) {
            } else {
                throw thrown$iv;
            }
        } catch (Throwable t$iv5) {
            thrown$iv = t$iv5;
            if ($this$use$iv != null) {
                try {
                    $this$use$iv.close();
                } catch (Throwable t$iv6) {
                    ExceptionsKt.addSuppressed(thrown$iv, t$iv6);
                }
            }
        }
    }
}
