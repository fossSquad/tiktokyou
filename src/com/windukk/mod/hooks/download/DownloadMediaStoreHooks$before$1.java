package com.windukk.mod.hooks.download;

import android.content.ContentValues;
import android.net.Uri;
import com.windukk.hook.HookMethod;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.ArraysKt;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006¸\u0006\u0000"}, d2 = {"ni/shikatu/extensions/HookUtilsKt$before$2", "Lcom/windukk/hook/HookMethod;", "beforeHookedMethod", "", "param", "Lcom/windukk/hook/HookMethod$HookMethodParam;", "ttmod:mod_release"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class DownloadMediaStoreHooks$before$1 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        b4 b4VarA;
        try {
            Object[] objArr = hookMethodParam.args;
            Object orNull = ArraysKt.getOrNull(objArr, 1);
            ContentValues contentValues = orNull instanceof ContentValues ? (ContentValues) orNull : null;
            if (contentValues != null && (b4VarA = c4.a(contentValues)) != null) {
                DownloadMediaStoreHooks.a.set(b4VarA);
                ThreadLocal threadLocal = DownloadMediaStoreHooks.a;
                DownloadMediaStoreHooks.a(contentValues, b4VarA);
                if (b4VarA.c) {
                    Object[] objArr2 = hookMethodParam.args;
                    Object orNull2 = ArraysKt.getOrNull(objArr2, 0);
                    hookMethodParam.args[0] = DownloadMediaStoreHooks.a(orNull2 instanceof Uri ? (Uri) orNull2 : null);
                }
            }
        } catch (Throwable th) {
            h6.a(6, h6.a(new StringBuilder().append("Unhandled hook exception on ").append(hookMethodParam.method.getName()).toString(), new Object[0]), th);
        }
    }
}
