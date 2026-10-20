package Z;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashSet;
import java.util.Set;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.collections.SetsKt;
import ni.shikatu.kotlin.jvm.JvmStatic;

public final class ac {
    public static final ac a;
    public static SharedPreferences b;
    public static bc c;

    static {
        a = new ac();
    }

    public static final void a(Context context) {
        if (c == null) {
            int i = bc.I;
            SharedPreferences sharedPreferences = context.getSharedPreferences("ttmod_settings", 0);
            b = sharedPreferences;
            c = new bc(sharedPreferences);
        }
    }

    public static void b(boolean z) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorPutBoolean;
        SharedPreferences sharedPreferences = b;
        if (sharedPreferences == null || (editorEdit = sharedPreferences.edit()) == null || (editorPutBoolean = editorEdit.putBoolean("auto_streak_recipients_all", z)) == null) {
            return;
        }
        editorPutBoolean.apply();
    }

    public static boolean c() {
        SharedPreferences sharedPreferences = b;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("auto_streak_recipients_all", true);
        }
        return true;
    }

    public static te d() {
        te teVar;
        int i = e().b;
        if (i >= 0) {
            te[] teVarArr = ue.a;
            if (i < 191) {
                teVar = teVarArr[i];
            } else {
                teVar = ue.a[bc.I];
            }
        } else {
            teVar = ue.a[bc.I];
        }
        return teVar;
    }

    public static bc e() {
        bc bcVar = c;
        if (bcVar != null) {
            return bcVar;
        }
        throw new IllegalStateException("ModSettings.init() has not been called".toString());
    }

    public final void f(boolean z) {
        e().i(z);
    }

    public final void g(boolean z) {
        e().j(z);
    }

    public final void h(boolean z) {
        e().l(z);
    }

    public final void i(boolean z) {
        e().m(z);
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

    public static void c(String str) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorPutString;
        SharedPreferences sharedPreferences = b;
        if (sharedPreferences == null || (editorEdit = sharedPreferences.edit()) == null || (editorPutString = editorEdit.putString("auto_streak_sticker_url", str)) == null) {
            return;
        }
        editorPutString.apply();
    }

    public static String f() {
        String str = e().o;
        return str;
    }

    public final void e(boolean z) {
        e().h(z);
    }

    public final boolean g() {
        return e().q;
    }

    public final void c(boolean z) {
        e().e(z);
    }

    public final void d(boolean z) {
        e().g(z);
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

    @JvmStatic
    public static final ac a() {
        return a;
    }

    public final void a(boolean z) {
        e().a(z);
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
