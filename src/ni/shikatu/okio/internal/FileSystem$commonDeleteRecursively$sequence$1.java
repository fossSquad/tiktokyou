package ni.shikatu.okio.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.ArrayDeque;
import ni.shikatu.kotlin.coroutines.Continuation;
import ni.shikatu.kotlin.coroutines.intrinsics.IntrinsicsKt;
import ni.shikatu.kotlin.coroutines.jvm.internal.DebugMetadata;
import ni.shikatu.kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import ni.shikatu.kotlin.coroutines.jvm.internal.SpillingKt;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.sequences.SequenceScope;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.FileSystem;
import ni.shikatu.okio.Path;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/sequences/SequenceScope;", "Lni/shikatu/okio/Path;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ni.shikatu.okio.internal.-FileSystem$commonDeleteRecursively$sequence$1", f = "FileSystem.kt", i = {0}, l = {75}, m = "invokeSuspend", n = {"$this$sequence"}, s = {"L$0"}, v = 1)
final class FileSystem$commonDeleteRecursively$sequence$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {
    final  Path $fileOrDirectory;
    final  FileSystem $this_commonDeleteRecursively;
    private  Object L$0;
    int label;

    FileSystem$commonDeleteRecursively$sequence$1(FileSystem fileSystem, Path path, Continuation<? super FileSystem$commonDeleteRecursively$sequence$1> continuation) {
        super(2, continuation);
        this.$this_commonDeleteRecursively = fileSystem;
        this.$fileOrDirectory = path;
    }

    @Override
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FileSystem$commonDeleteRecursively$sequence$1 fileSystem$commonDeleteRecursively$sequence$1 = new FileSystem$commonDeleteRecursively$sequence$1(this.$this_commonDeleteRecursively, this.$fileOrDirectory, continuation);
        fileSystem$commonDeleteRecursively$sequence$1.L$0 = obj;
        return fileSystem$commonDeleteRecursively$sequence$1;
    }

    @Override
    public final Object invoke(SequenceScope<? super Path> sequenceScope, Continuation<? super Unit> continuation) {
        return ((FileSystem$commonDeleteRecursively$sequence$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override
    public final Object invokeSuspend(Object $result) throws Throwable {
        SequenceScope $this$sequence = (SequenceScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$sequence);
                this.label = 1;
                if (FileSystem.collectRecursively($this$sequence, this.$this_commonDeleteRecursively, new ArrayDeque(), this.$fileOrDirectory, false, true, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
