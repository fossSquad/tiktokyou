package Z;
import com.windukk.hook.HookMethod;
import java.io.File;
import java.lang.reflect.Field;
import ni.shikatu.kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006"}, d2 = {"com/windukk/mod/hooks/download/DownloadMediaStoreHooks$hookPhotoGalleryTempDir$1", "Lcom/windukk/hook/HookMethod;", "afterHookedMethod", "", "param", "Lcom/windukk/hook/HookMethod$HookMethodParam;", "ttmod:mod_release"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class d4$hookPhotoGalleryTempDir$1 extends HookMethod {
    final  File a;
    final  Field b;

    public d4$hookPhotoGalleryTempDir$1(File file, Field field) {
        this.a = file;
        this.b = field;
    }

    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) throws IllegalAccessException {
        if (this.a.mkdirs() || this.a.isDirectory()) {
            this.b.set(hookMethodParam.thisObject, this.a.getAbsolutePath());
        }
    }
}
