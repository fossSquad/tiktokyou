package Z;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashSet;
import java.util.Set;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.collections.SetsKt;
import ni.shikatu.kotlin.jvm.JvmStatic;

public final class ta {
    public static final ta a;
    public static SharedPreferences b;
    public static ua c;

    static {
        a = new ta();
    }

    public static final void a(Context context) {
        if (c == null) {
            int i = ua.C;
            SharedPreferences sharedPreferences = context.getSharedPreferences("ttmod_settings", 0);
            b = sharedPreferences;
            c = new ua(sharedPreferences);
        }
    }

    public static ed c() {
        ed edVar;
        int i = d().b;
        if (i >= 0) {
            ed[] edVarArr = fd.a;
            if (i < 191) {
                edVar = edVarArr[i];
            } else {
                edVar = fd.a[ua.C];
            }
        } else {
            edVar = fd.a[ua.C];
        }
        return edVar;
    }

    public static ua d() {
        ua uaVar = c;
        if (uaVar != null) {
            return uaVar;
        }
        throw new IllegalStateException("ModSettings.init() has not been called".toString());
    }

    public final void b(boolean z) {
        d().b(z);
    }

    public final void e(boolean z) {
        d().h(z);
    }

    public final void f(boolean z) {
        d().i(z);
    }

    public final void g(boolean z) {
        d().j(z);
    }

    public final void h(boolean z) {
        d().k(z);
    }

    public final void i(boolean z) {
        d().m(z);
    }

    public final void j(boolean z) {
        d().n(z);
    }

    public static Set b() {
        HashSet hashSet;
        Set<String> stringSet = null;
        try {
            SharedPreferences sharedPreferences = b;
            if (sharedPreferences != null) {
                stringSet = sharedPreferences.getStringSet("auto_streak_recipients_excluded", null);
            }
        } catch (Exception e) {
        }
        return (stringSet == null || (hashSet = CollectionsKt.toHashSet(stringSet)) == null) ? SetsKt.emptySet() : hashSet;
    }

    public static String e() {
        String str = d().j;
        return str;
    }

    public final void d(boolean z) {
        d().f(z);
    }

    public final boolean f() {
        return d().l;
    }

    public final void c(boolean z) {
        d().d(z);
    }

    public static void b(String str) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorPutString;
        SharedPreferences sharedPreferences = b;
        if (sharedPreferences == null || (editorEdit = sharedPreferences.edit()) == null || (editorPutString = editorEdit.putString("auto_streak_sticker", str)) == null) {
            return;
        }
        editorPutString.apply();
    }

    public static void c(String str) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorPutString;
        SharedPreferences sharedPreferences = b;
        if (sharedPreferences == null || (editorEdit = sharedPreferences.edit()) == null || (editorPutString = editorEdit.putString("auto_streak_sticker_url", str)) == null) {
            return;
        }
        editorPutString.apply();
    }

    @JvmStatic
    public static final ta a() {
        return a;
    }

    public final void a(boolean z) {
        d().a(z);
    }

    public final void a(int i) {
        d().b(i);
    }

    public static void a(Set set) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorPutStringSet;
        SharedPreferences sharedPreferences = b;
        if (sharedPreferences == null || (editorEdit = sharedPreferences.edit()) == null || (editorPutStringSet = editorEdit.putStringSet("auto_streak_recipients_excluded", CollectionsKt.toHashSet(set))) == null) {
            return;
        }
        editorPutStringSet.apply();
    }

    public static void a(String str) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorPutString;
        SharedPreferences sharedPreferences = b;
        if (sharedPreferences == null || (editorEdit = sharedPreferences.edit()) == null || (editorPutString = editorEdit.putString("auto_streak_sticker_id", str)) == null) {
            return;
        }
        editorPutString.apply();
    }
}
