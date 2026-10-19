package Z;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.windukk.mod.Main;
import java.util.ArrayList;
import java.util.List;
import ni.shikatu.kotlin.Result;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.kotlinx.serialization.builtins.BuiltinSerializersKt;
import ni.shikatu.kotlinx.serialization.json.Json;
import ni.shikatu.kotlinx.serialization.json.JsonBuilder;
import ni.shikatu.kotlinx.serialization.json.JsonKt;

public abstract class xj {
    public static final Json a = JsonKt.Json$default((Json) null, new Function1() {
        public final Object invoke(Object obj) {
            return xj.a((JsonBuilder) obj);
        }
    }, 1, (Object) null);

    public static final List a() {
        Object obj;
        String str = y5.a().n;
        if (str == null) {
            str = "[]";
        }
        if (StringsKt.isBlank(str)) {
            return CollectionsKt.emptyList();
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl((List) a.decodeFromString(BuiltinSerializersKt.ListSerializer(uj.a), str));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            g7.a(6, g7.a("Failed to parse UI hide rules", new Object[0]), th2);
        }
        List listEmptyList = CollectionsKt.emptyList();
        if (Result.isFailure-impl(obj)) {
            obj = listEmptyList;
        }
        return (List) obj;
    }

    public static final String b() {
        Context contextA = Main.getApplicationContext();
        try {
            PackageManager packageManager = contextA.getPackageManager();
            String packageName = contextA.getPackageName();
            String str = (Build.VERSION.SDK_INT >= 33 ? packageManager.getPackageInfo(packageName, PackageManager.PackageInfoFlags.of(0L)) : packageManager.getPackageInfo(packageName, 0)).versionName;
            if (str != null) {
                if (StringsKt.isBlank(str)) {
                    str = null;
                }
                if (str != null) {
                    return str;
                }
            }
            return "47.4.3";
        } catch (Throwable th) {
            g7.a(6, g7.a("Failed to read host version name", new Object[0]), th);
            return "47.4.3";
        }
    }

    public static final Unit a(JsonBuilder jsonBuilder) {
        jsonBuilder.setIgnoreUnknownKeys(true);
        jsonBuilder.setLenient(true);
        jsonBuilder.setEncodeDefaults(true);
        return Unit.INSTANCE;
    }

    public static final void a(String str, String str2, String str3) {
        if (str2 == null) {
            str2 = "";
        }
        List listA = a();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listA) {
            wj wjVar = (wj) obj;
            if (!Intrinsics.areEqual(wjVar.a, str) || !Intrinsics.areEqual(wjVar.e, str2) || !Intrinsics.areEqual(wjVar.d, str3)) {
                arrayList.add(obj);
            }
        }
        a(arrayList);
    }

    public static final wj a(String str) {
        List listSplit$default = StringsKt.split$default(StringsKt.trim(str).toString(), new char[]{'|'}, false, 0, 6, (Object) null);
        if (listSplit$default.size() == 3 && ((CharSequence) listSplit$default.get(0)).length() != 0 && ((CharSequence) listSplit$default.get(1)).length() != 0) {
            return new wj((String) listSplit$default.get(0), (String) listSplit$default.get(0), Intrinsics.areEqual(listSplit$default.get(2), "alpha") ? "alpha" : "gone", "", (String) listSplit$default.get(1), true);
        }
        g7.a(6, g7.a("Invalid UI hide export: " + str, new Object[0]), (Throwable) null);
        return null;
    }

    public static void a(List list) {
        ac acVarA = ac.a();
        String strEncodeToString = a.encodeToString(BuiltinSerializersKt.ListSerializer(uj.a), list);
        acVarA.getClass();
        ac.e().d(strEncodeToString);
    }
}
