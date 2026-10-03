package Z;

import Z.h6;
import Z.ta;

import android.content.Context;
import android.view.View;
import com.windukk.hook.HookBridge;
import com.windukk.hook.HookMethod;
import com.windukk.mod.Main;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import ni.shikatu.kotlin.Result;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.collections.CollectionsKt;

public abstract class SimpleModeHooks {
    public static final WeakHashMap a = new WeakHashMap();
    public static volatile boolean b;

    public static final void a() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            Context contextA = Main.getApplicationContext();
            List listListOf = CollectionsKt.listOf(new String[]{"k8_", "oju", "ojx"});
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listListOf, 10));
            Iterator it = listListOf.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(contextA.getResources().getIdentifier((String) it.next(), "id", contextA.getPackageName())));
            }
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                if (((Number) obj2).intValue() != 0) {
                    arrayList2.add(obj2);
                }
            }
            int[] intArray = CollectionsKt.toIntArray(arrayList2);
            Class<?> cls = Class.forName("X.05NQ");
            ta.a().getClass();
            b = ta.d().v;
            Method declaredMethod = View.class.getDeclaredMethod("onAttachedToWindow", null);
            HookBridge.hookMethod(declaredMethod, new SimpleModeHooks$after$1(intArray, cls));
            Method declaredMethod2 = View.class.getDeclaredMethod("setVisibility", Integer.TYPE);
            HookMethod.Unhook unhookHookMethod = HookBridge.hookMethod(declaredMethod2, new SimpleModeHooks$before$1(intArray, cls));
            obj = RCompat.m6constructorimpl(unhookHookMethod);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = RCompat.m6constructorimpl(ResultKt.createFailure(th));
        }
        Throwable th2 = RCompat.m9exceptionOrNullimpl(obj);
        if (th2 != null) {
            h6.a(6, h6.a("Simple mode initialization error", new Object[0]), th2);
        }
    }
}
