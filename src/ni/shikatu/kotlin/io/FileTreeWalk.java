package ni.shikatu.kotlin.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.NoWhenBranchMatchedException;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin._Assertions;
import ni.shikatu.kotlin.collections.AbstractIterator;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.sequences.Sequence;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001b\u001c\u001dB\u008b\u0001\bB\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007\u00128\u0010\u000b\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\n\u0018\u00010\f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015B\u001b\bP\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0014\u0010\u0016J\u0010\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018H\u0096\u0082\u0004J\u001e\u0010\u0006\u001a\u00020\u00002\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007H\u0086\u0080\u0004J\u001e\u0010\t\u001a\u00020\u00002\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\u0007H\u0086\u0080\u0004J$\u0010\u000b\u001a\u00020\u00002\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n0\fH\u0086\u0080\u0004J\u0012\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0013H\u0086\u0080\u0004R\u000f\u0010\u0003\u001a\u00020\u0002X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0004\u001a\u00020\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007X\u0082\u0084\b¢\u0006\u0002\n\u0000RA\u0010\u000b\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\n\u0018\u00010\fX\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0012\u001a\u00020\u0013X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lni/shikatu/kotlin/io/FileTreeWalk;", "Lni/shikatu/kotlin/sequences/Sequence;", "Ljava/io/File;", "start", "direction", "Lni/shikatu/kotlin/io/FileWalkDirection;", "onEnter", "Lni/shikatu/kotlin/Function1;", _UrlKt.FRAGMENT_ENCODE_SET, "onLeave", _UrlKt.FRAGMENT_ENCODE_SET, "onFail", "Lni/shikatu/kotlin/Function2;", "Lni/shikatu/kotlin/ParameterName;", "name", "f", "Ljava/io/IOException;", "e", "maxDepth", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;I)V", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;)V", "iterator", _UrlKt.FRAGMENT_ENCODE_SET, "function", "depth", "WalkState", "DirectoryState", "FileTreeWalkIterator", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class FileTreeWalk implements Sequence<File> {
    private final FileWalkDirection direction;
    private final int maxDepth;
    private final Function1<File, Boolean> onEnter;
    private final Function2<File, IOException, Unit> onFail;
    private final Function1<File, Unit> onLeave;
    private final File start;

    private FileTreeWalk(File start, FileWalkDirection direction, Function1<? super File, Boolean> function1, Function1<? super File, Unit> function2, Function2<? super File, ? super IOException, Unit> function3, int maxDepth) {
        this.start = start;
        this.direction = direction;
        this.onEnter = function1;
        this.onLeave = function2;
        this.onFail = function3;
        this.maxDepth = maxDepth;
    }

     FileTreeWalk(File file, FileWalkDirection fileWalkDirection, Function1 function1, Function1 function2, Function2 function3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        FileWalkDirection fileWalkDirection2;
        int i3;
        if ((i2 & 2) == 0) {
            fileWalkDirection2 = fileWalkDirection;
        } else {
            fileWalkDirection2 = FileWalkDirection.TOP_DOWN;
        }
        if ((i2 & 32) == 0) {
            i3 = i;
        } else {
            i3 = Integer.MAX_VALUE;
        }
        this(file, fileWalkDirection2, function1, function2, function3, i3);
    }

    public FileTreeWalk(File start, FileWalkDirection direction) {
        this(start, direction, null, null, null, 0, 32, null);
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(direction, "direction");
    }

    public  FileTreeWalk(File file, FileWalkDirection fileWalkDirection, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i & 2) != 0 ? FileWalkDirection.TOP_DOWN : fileWalkDirection);
    }

    @Override
    public Iterator<File> iterator() {
        return new FileTreeWalkIterator();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\"\u0018\u00002\u00020\u0001B\u0011\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\b\u001a\u0004\u0018\u00010\u0003H¦\u0080\u0004R\u0015\u0010\u0002\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lni/shikatu/kotlin/io/FileTreeWalk$WalkState;", _UrlKt.FRAGMENT_ENCODE_SET, "root", "Ljava/io/File;", "<init>", "(Ljava/io/File;)V", "getRoot", "()Ljava/io/File;", "step", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private static abstract class WalkState {
        private final File root;

        public abstract File step();

        public WalkState(File root) {
            Intrinsics.checkNotNullParameter(root, "root");
            this.root = root;
        }

        public final File getRoot() {
            return this.root;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\"\u0018\u00002\u00020\u0001B\u0011\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lni/shikatu/kotlin/io/FileTreeWalk$DirectoryState;", "Lni/shikatu/kotlin/io/FileTreeWalk$WalkState;", "rootDir", "Ljava/io/File;", "<init>", "(Ljava/io/File;)V", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private static abstract class DirectoryState extends WalkState {

        public DirectoryState(File rootDir) {
            super(rootDir);
            Intrinsics.checkNotNullParameter(rootDir, "rootDir");
            if (!_Assertions.ENABLED) {
                return;
            }
            boolean zIsDirectory = rootDir.isDirectory();
            if (_Assertions.ENABLED && !zIsDirectory) {
                throw new AssertionError("rootDir must be verified to be directory beforehand.");
            }
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000e\u000f\u0010B\t\bF¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010\b\u001a\u00020\tH\u0094\u0080\u0004J\u0012\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0082\u0080\u0004J\f\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0082\u0090\u0004R\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lni/shikatu/kotlin/io/FileTreeWalk$FileTreeWalkIterator;", "Lni/shikatu/kotlin/collections/AbstractIterator;", "Ljava/io/File;", "<init>", "(Lkotlin/io/FileTreeWalk;)V", "state", "Ljava/util/ArrayDeque;", "Lni/shikatu/kotlin/io/FileTreeWalk$WalkState;", "computeNext", _UrlKt.FRAGMENT_ENCODE_SET, "directoryState", "Lni/shikatu/kotlin/io/FileTreeWalk$DirectoryState;", "root", "gotoNext", "BottomUpDirectoryState", "TopDownDirectoryState", "SingleFileState", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private final class FileTreeWalkIterator extends AbstractIterator<File> {
        private final ArrayDeque<WalkState> state = new ArrayDeque<>();

        @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
        public static final  class WhenMappings {
            public static final  int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[FileWalkDirection.values().length];
                try {
                    iArr[FileWalkDirection.TOP_DOWN.ordinal()] = 1;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[FileWalkDirection.BOTTOM_UP.ordinal()] = 2;
                } catch (NoSuchFieldError e2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public FileTreeWalkIterator() {
            if (FileTreeWalk.this.start.isDirectory()) {
                this.state.push(directoryState(FileTreeWalk.this.start));
            } else if (FileTreeWalk.this.start.isFile()) {
                this.state.push(new SingleFileState(this, FileTreeWalk.this.start));
            } else {
                done();
            }
        }

        @Override
        protected void computeNext() {
            File nextFile = gotoNext();
            if (nextFile != null) {
                setNext(nextFile);
            } else {
                done();
            }
        }

        private final DirectoryState directoryState(File root) {
            switch (WhenMappings.$EnumSwitchMapping$0[FileTreeWalk.this.direction.ordinal()]) {
                case 1:
                    return new TopDownDirectoryState(this, root);
                case 2:
                    return new BottomUpDirectoryState(this, root);
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }

        private final File gotoNext() {
            while (true) {
                WalkState topState = this.state.peek();
                if (topState == null) {
                    return null;
                }
                File file = topState.step();
                if (file == null) {
                    this.state.pop();
                } else {
                    if (Intrinsics.areEqual(file, topState.getRoot()) || !file.isDirectory() || this.state.size() >= FileTreeWalk.this.maxDepth) {
                        return file;
                    }
                    this.state.push(directoryState(file));
                }
            }
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0011\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0096\u0080\u0004R\u000f\u0010\u0006\u001a\u00020\u0007X\u0082\u008e\b¢\u0006\u0002\n\u0000R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tX\u0082\u008e\b¢\u0006\u0004\n\u0002\u0010\nR\u000f\u0010\u000b\u001a\u00020\fX\u0082\u008e\b¢\u0006\u0002\n\u0000R\u000f\u0010\r\u001a\u00020\u0007X\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lni/shikatu/kotlin/io/FileTreeWalk$FileTreeWalkIterator$BottomUpDirectoryState;", "Lni/shikatu/kotlin/io/FileTreeWalk$DirectoryState;", "rootDir", "Ljava/io/File;", "<init>", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "rootVisited", _UrlKt.FRAGMENT_ENCODE_SET, "fileList", _UrlKt.FRAGMENT_ENCODE_SET, "[Ljava/io/File;", "fileIndex", _UrlKt.FRAGMENT_ENCODE_SET, "failed", "step", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
        private final class BottomUpDirectoryState extends DirectoryState {
            private boolean failed;
            private int fileIndex;
            private File[] fileList;
            private boolean rootVisited;
            final  FileTreeWalkIterator this$0;

            public BottomUpDirectoryState(FileTreeWalkIterator this$0, File rootDir) {
                super(rootDir);
                Intrinsics.checkNotNullParameter(rootDir, "rootDir");
                this.this$0 = this$0;
            }

            @Override
            public File step() {
                if (!this.failed && this.fileList == null) {
                    Function1 function1 = FileTreeWalk.this.onEnter;
                    boolean z = false;
                    if (function1 != null && !((Boolean) function1.invoke(getRoot())).booleanValue()) {
                        z = true;
                    }
                    if (z) {
                        return null;
                    }
                    this.fileList = getRoot().listFiles();
                    if (this.fileList == null) {
                        Function2 function2 = FileTreeWalk.this.onFail;
                        if (function2 != null) {
                            function2.invoke(getRoot(), new AccessDeniedException(getRoot(), null, "Cannot list files in a directory", 2, null));
                        }
                        this.failed = true;
                    }
                }
                if (this.fileList != null) {
                    int i = this.fileIndex;
                    File[] fileArr = this.fileList;
                    Intrinsics.checkNotNull(fileArr);
                    if (i < fileArr.length) {
                        File[] fileArr2 = this.fileList;
                        Intrinsics.checkNotNull(fileArr2);
                        int i2 = this.fileIndex;
                        this.fileIndex = i2 + 1;
                        return fileArr2[i2];
                    }
                }
                if (this.rootVisited) {
                    Function1 function3 = FileTreeWalk.this.onLeave;
                    if (function3 != null) {
                        function3.invoke(getRoot());
                    }
                    return null;
                }
                this.rootVisited = true;
                return getRoot();
            }
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0011\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0096\u0080\u0004R\u000f\u0010\u0006\u001a\u00020\u0007X\u0082\u008e\b¢\u0006\u0002\n\u0000R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tX\u0082\u008e\b¢\u0006\u0004\n\u0002\u0010\nR\u000f\u0010\u000b\u001a\u00020\fX\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lni/shikatu/kotlin/io/FileTreeWalk$FileTreeWalkIterator$TopDownDirectoryState;", "Lni/shikatu/kotlin/io/FileTreeWalk$DirectoryState;", "rootDir", "Ljava/io/File;", "<init>", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "rootVisited", _UrlKt.FRAGMENT_ENCODE_SET, "fileList", _UrlKt.FRAGMENT_ENCODE_SET, "[Ljava/io/File;", "fileIndex", _UrlKt.FRAGMENT_ENCODE_SET, "step", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
        private final class TopDownDirectoryState extends DirectoryState {
            private int fileIndex;
            private File[] fileList;
            private boolean rootVisited;
            final  FileTreeWalkIterator this$0;

            public TopDownDirectoryState(FileTreeWalkIterator this$0, File rootDir) {
                super(rootDir);
                Intrinsics.checkNotNullParameter(rootDir, "rootDir");
                this.this$0 = this$0;
            }

            @Override

            public File step() {
                Function2 function2;
                if (!this.rootVisited) {
                    Function1 function1 = FileTreeWalk.this.onEnter;
                    boolean z = false;
                    if (function1 != null && !((Boolean) function1.invoke(getRoot())).booleanValue()) {
                        z = true;
                    }
                    if (z) {
                        return null;
                    }
                    this.rootVisited = true;
                    return getRoot();
                }
                if (this.fileList != null) {
                    int i = this.fileIndex;
                    File[] fileArr = this.fileList;
                    Intrinsics.checkNotNull(fileArr);
                    if (i >= fileArr.length) {
                        Function1 function3 = FileTreeWalk.this.onLeave;
                        if (function3 != null) {
                            function3.invoke(getRoot());
                        }
                        return null;
                    }
                }
                if (this.fileList == null) {
                    this.fileList = getRoot().listFiles();
                    if (this.fileList == null && (function2 = FileTreeWalk.this.onFail) != null) {
                        function2.invoke(getRoot(), new AccessDeniedException(getRoot(), null, "Cannot list files in a directory", 2, null));
                    }
                    if (this.fileList != null) {
                        File[] fileArr2 = this.fileList;
                        Intrinsics.checkNotNull(fileArr2);
                    }
                    Function1 function4 = FileTreeWalk.this.onLeave;
                    if (function4 != null) {
                        function4.invoke(getRoot());
                    }
                    return null;
                }
                File[] fileArr3 = this.fileList;
                Intrinsics.checkNotNull(fileArr3);
                int i2 = this.fileIndex;
                this.fileIndex = i2 + 1;
                return fileArr3[i2];
            }
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0011\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0096\u0080\u0004R\u000f\u0010\u0006\u001a\u00020\u0007X\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lni/shikatu/kotlin/io/FileTreeWalk$FileTreeWalkIterator$SingleFileState;", "Lni/shikatu/kotlin/io/FileTreeWalk$WalkState;", "rootFile", "Ljava/io/File;", "<init>", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "visited", _UrlKt.FRAGMENT_ENCODE_SET, "step", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
        private final class SingleFileState extends WalkState {
            final  FileTreeWalkIterator this$0;
            private boolean visited;

            public SingleFileState(FileTreeWalkIterator this$0, File rootFile) {
                super(rootFile);
                Intrinsics.checkNotNullParameter(rootFile, "rootFile");
                this.this$0 = this$0;
                if (!_Assertions.ENABLED) {
                    return;
                }
                boolean zIsFile = rootFile.isFile();
                if (_Assertions.ENABLED && !zIsFile) {
                    throw new AssertionError("rootFile must be verified to be file beforehand.");
                }
            }

            @Override
            public File step() {
                if (this.visited) {
                    return null;
                }
                this.visited = true;
                return getRoot();
            }
        }
    }

    public final FileTreeWalk onEnter(Function1<? super File, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "function");
        return new FileTreeWalk(this.start, this.direction, function1, this.onLeave, this.onFail, this.maxDepth);
    }

    public final FileTreeWalk onLeave(Function1<? super File, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "function");
        return new FileTreeWalk(this.start, this.direction, this.onEnter, function1, this.onFail, this.maxDepth);
    }

    public final FileTreeWalk onFail(Function2<? super File, ? super IOException, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "function");
        return new FileTreeWalk(this.start, this.direction, this.onEnter, this.onLeave, function2, this.maxDepth);
    }

    public final FileTreeWalk maxDepth(int depth) {
        if (depth <= 0) {
            throw new IllegalArgumentException("depth must be positive, but was " + depth + '.');
        }
        return new FileTreeWalk(this.start, this.direction, this.onEnter, this.onLeave, this.onFail, depth);
    }
}
