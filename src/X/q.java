package X;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.ss.android.ugc.aweme.comment.model.Comment;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ni.shikatu.kotlin.Pair;
import ni.shikatu.kotlin.TuplesKt;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

public final class q {
    public static String a;

    public static final void a() {
        try {
            XposedBridge.hookAllMethods(Class.forName("X.0Mq2"), "LIZ", new h());
            XposedBridge.hookAllMethods(Class.forName("X.0wi9"), "LIZ", new m());
            XposedBridge.hookAllMethods(Class.forName("X.0ybD"), "LIZ", new n());
            ArrayList arrayList = g1.a;
        } catch (Throwable th) {
            th.getMessage();
            ArrayList arrayList2 = g1.a;
        }
        try {
            Class<?> cls = Class.forName("com.ss.android.ugc.aweme.commentv2.actionbar.CommentPageActionBarAssem");
            g gVar = new g();
            XposedBridge.hookAllMethods(cls, "Fm", gVar);
            XposedBridge.hookAllMethods(cls, "Pn", gVar);
        } catch (Throwable th2) {
            th2.getMessage();
            ArrayList arrayList3 = g1.a;
        }
        for (Pair pair : CollectionsKt.listOf(new Pair[]{TuplesKt.to("X.0BFJ", CollectionsKt.listOf(new String[]{"LIZ", "LIZIZ", "LIZJ"})), TuplesKt.to("X.0KVp", CollectionsKt.listOf(new String[]{"LIZ", "LIZIZ", "LIZJ"})), TuplesKt.to("X.0BYe", CollectionsKt.listOf("LIZIZ")), TuplesKt.to("X.0AtW", CollectionsKt.listOf("LIZIZ"))})) {
            String str = (String) pair.component1();
            List list = (List) pair.component2();
            try {
                Class<?> cls2 = Class.forName(str);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    XposedBridge.hookAllMethods(cls2, (String) it.next(), XC_MethodReplacement.returnConstant(Boolean.TRUE));
                }
                CollectionsKt.joinToString$default(list, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                ArrayList arrayList4 = g1.a;
            } catch (Throwable th3) {
                th3.getMessage();
                ArrayList arrayList5 = g1.a;
            }
        }
        try {
            XposedBridge.hookAllMethods(Class.forName("X.0BYe"), "LIZ", XC_MethodReplacement.returnConstant(Boolean.TRUE));
            ArrayList arrayList6 = g1.a;
        } catch (Throwable th4) {
            th4.getMessage();
            ArrayList arrayList7 = g1.a;
        }
        try {
            Class<?> cls3 = Class.forName("com.ss.android.ugc.aweme.experiment.CommentTimeSortFeatExp");
            Boolean bool = Boolean.FALSE;
            XposedBridge.hookAllMethods(cls3, "LIZ", XC_MethodReplacement.returnConstant(bool));
            XposedBridge.hookAllMethods(cls3, "LIZIZ", XC_MethodReplacement.returnConstant(bool));
        } catch (Throwable th5) {
            th5.getMessage();
            ArrayList arrayList8 = g1.a;
        }
        try {
            Boolean bool2 = Boolean.TRUE;
            XposedBridge.hookAllMethods(Comment.class, "getAllowDownloadPhoto", XC_MethodReplacement.returnConstant(bool2));
            XposedBridge.hookAllMethods(Comment.class, "getForbidVideoReply", XC_MethodReplacement.returnConstant(bool2));
        } catch (Throwable th6) {
            th6.getMessage();
            ArrayList arrayList9 = g1.a;
        }
        try {
            XposedBridge.hookAllMethods(Class.forName("X.0o6j"), "LJJLJ", new o());
        } catch (Throwable th7) {
            th7.getMessage();
            ArrayList arrayList10 = g1.a;
        }
        try {
            XposedBridge.hookAllMethods(Class.forName("com.ss.android.ugc.aweme.favorites.business.comment.CommentCollectViewHolder"), "copy", new p());
        } catch (Throwable th8) {
            th8.getMessage();
            ArrayList arrayList11 = g1.a;
        }
    }

    public static final void b(Object obj, View view) {
        try {
            Field declaredField = obj.getClass().getDeclaredField("LLJLL");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            boolean z = !i1.a().k;
            a(z);
            i1.a().b(z);
            if (obj2 != null) {
                try {
                    Field declaredField2 = obj2.getClass().getDeclaredField("LIZIZ");
                    if (declaredField2 != null) {
                        declaredField2.setAccessible(true);
                        declaredField2.setBoolean(obj2, z);
                    }
                } catch (Throwable th) {
                }
            }
            try {
                obj.getClass().getMethod("Ln", Boolean.TYPE).invoke(obj, Boolean.valueOf(z));
            } catch (Throwable th2) {
            }
            a(a(obj, "LLJJJJ"), a(obj, "LLJJJIL"), z);
            a(obj, a(obj, "LLJJJIL"));
            a(obj, a(obj, "LLJJJJ"));
            ArrayList arrayList = g1.a;
        } catch (Throwable th3) {
            th3.getMessage();
            ArrayList arrayList2 = g1.a;
        }
    }

    public static final void b(Class cls, Object obj) throws IllegalAccessException, InvocationTargetException {
        cls.getDeclaredMethod("LJIIJ", null).invoke(obj, null);
    }

    public static Object a(final Object obj, final Map map) {
        Class<?>[] interfaces = obj.getClass().getInterfaces();
        Intrinsics.checkNotNull(interfaces);
        if (interfaces.length == 0) {
            return obj;
        }
        Object objNewProxyInstance = Proxy.newProxyInstance(obj.getClass().getClassLoader(), interfaces, new InvocationHandler() {
            @Override
            public final Object invoke(Object obj2, Method method, Object[] objArr) {
                return q.a(map, obj, obj2, method, objArr);
            }
        });
        Intrinsics.checkNotNullExpressionValue(objNewProxyInstance, "newProxyInstance(...)");
        return objNewProxyInstance;
    }

    public static final Object a(Map map, Object obj, Object obj2, Method method, Object[] objArr) {
        if (map.containsKey(method.getName())) {
            return map.get(method.getName());
        }
        if (objArr == null) {
            objArr = new Object[0];
        }
        return method.invoke(obj, Arrays.copyOf(objArr, objArr.length));
    }

    public static final void a(Object obj) throws IllegalAccessException, NoSuchFieldException, InvocationTargetException {
        String str;
        Field declaredField;
        View view;
        View view2;
        Object obj2;
        View view3;
        View view4;
        View viewA = a(obj, "LLJJJIL");
        View viewA2 = a(obj, "LLJJJJ");
        View viewA3 = a(obj, "LLJJIJI");
        Field declaredField2 = obj.getClass().getDeclaredField("LLJLL");
        declaredField2.setAccessible(true);
        Object obj3 = declaredField2.get(obj);
        boolean z = i1.a().k;
        try {
            Object objInvoke = obj.getClass().getMethod("Cn", null).invoke(obj, null);
            if (objInvoke != null) {
                Object objInvoke2 = Class.forName("com.ss.android.ugc.aweme.comment.model.CommentContextSourceKt").getMethod("aweme", Class.forName("com.ss.android.ugc.aweme.comment.model.CommentContextSource")).invoke(null, objInvoke);
                if (objInvoke2 != null) {
                    Object objInvoke3 = objInvoke2.getClass().getMethod("getAid", null).invoke(objInvoke2, null);
                    if (objInvoke3 instanceof String) {
                        str = (String) objInvoke3;
                    }
                    if (obj3 != null) {
                        try {
                            declaredField = obj3.getClass().getDeclaredField("LIZIZ");
                            if (declaredField != null) {
                                declaredField.setAccessible(true);
                                declaredField.setBoolean(obj3, z);
                            }
                        } catch (Throwable th) {
                        }
                    }
                    if (str != null && !Intrinsics.areEqual(str, a)) {
                        a(z);
                        a = str;
                    }
                    if ((viewA2 == null && viewA2.getVisibility() == 0) || (viewA != null && viewA.getVisibility() == 0)) {
                        a(viewA2, viewA, z);
                        Field declaredField3 = obj.getClass().getDeclaredField("LLJJJIL");
                        declaredField3.setAccessible(true);
                        obj2 = declaredField3.get(obj);
                        if (obj2 instanceof View) {
                            view3 = (View) obj2;
                        } else {
                            view3 = null;
                        }
                        if (view3 != null && view3.getVisibility() == 0) {
                            view3.setAlpha(1.0f);
                            view3.setEnabled(true);
                            view3.setClickable(true);
                            view3.bringToFront();
                            view3.requestLayout();
                            view3.invalidate();
                        }
                        Field declaredField4 = obj.getClass().getDeclaredField("LLJJJJ");
                        declaredField4.setAccessible(true);
                        Object obj4 = declaredField4.get(obj);
                        view4 = obj4 instanceof View ? (View) obj4 : null;
                        if (view4 != null && view4.getVisibility() == 0) {
                            view4.setAlpha(1.0f);
                            view4.setEnabled(true);
                            view4.setClickable(true);
                            view4.bringToFront();
                            view4.requestLayout();
                            view4.invalidate();
                        }
                        a(obj, viewA2);
                        a(obj, viewA);
                    }
                    if (z) {
                        view = viewA2;
                    } else {
                        view = viewA;
                    }
                    if (z) {
                        view2 = viewA;
                    } else {
                        view2 = viewA2;
                    }
                    if (view != null) {
                        view.setVisibility(0);
                    }
                    if (view != null) {
                        view.setAlpha(1.0f);
                    }
                    if (view != null) {
                        view.setEnabled(true);
                    }
                    if (view != null) {
                        view.setClickable(true);
                    }
                    if (view != null) {
                        view.bringToFront();
                    }
                    if (view != null) {
                        view.requestLayout();
                    }
                    if (view != null) {
                        view.invalidate();
                    }
                    a(obj, viewA2);
                    a(obj, viewA);
                    if (view2 != null) {
                        view2.setVisibility(8);
                    }
                    if (viewA3 != null) {
                        viewA3.bringToFront();
                        return;
                    }
                    return;
                }
            }
        } catch (Throwable th2) {
        }
        str = null;
        if (obj3 != null) {
            declaredField = obj3.getClass().getDeclaredField("LIZIZ");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                declaredField.setBoolean(obj3, z);
            }
        }
        if (str != null) {
            a(z);
            a = str;
        }
        if (viewA2 == null) {
            if (z) {
                view = viewA2;
            } else {
                view = viewA;
            }
            if (z) {
                view2 = viewA;
            } else {
                view2 = viewA2;
            }
            if (view != null) {
                view.setVisibility(0);
            }
            if (view != null) {
                view.setAlpha(1.0f);
            }
            if (view != null) {
                view.setEnabled(true);
            }
            if (view != null) {
                view.setClickable(true);
            }
            if (view != null) {
                view.bringToFront();
            }
            if (view != null) {
                view.requestLayout();
            }
            if (view != null) {
                view.invalidate();
            }
            a(obj, viewA2);
            a(obj, viewA);
            if (view2 != null) {
                view2.setVisibility(8);
            }
            if (viewA3 != null) {
                viewA3.bringToFront();
                return;
            }
            return;
        }
        if (z) {
            view = viewA2;
        } else {
            view = viewA;
        }
        if (z) {
            view2 = viewA;
        } else {
            view2 = viewA2;
        }
        if (view != null) {
            view.setVisibility(0);
        }
        if (view != null) {
            view.setAlpha(1.0f);
        }
        if (view != null) {
            view.setEnabled(true);
        }
        if (view != null) {
            view.setClickable(true);
        }
        if (view != null) {
            view.bringToFront();
        }
        if (view != null) {
            view.requestLayout();
        }
        if (view != null) {
            view.invalidate();
        }
        a(obj, viewA2);
        a(obj, viewA);
        if (view2 != null) {
            view2.setVisibility(8);
        }
        if (viewA3 != null) {
            viewA3.bringToFront();
            return;
        }
        return;
        a(viewA2, viewA, z);
        Field declaredField5 = obj.getClass().getDeclaredField("LLJJJIL");
        declaredField5.setAccessible(true);
        obj2 = declaredField5.get(obj);
        if (obj2 instanceof View) {
            view3 = (View) obj2;
        } else {
            view3 = null;
        }
        if (view3 != null) {
            view3.setAlpha(1.0f);
            view3.setEnabled(true);
            view3.setClickable(true);
            view3.bringToFront();
            view3.requestLayout();
            view3.invalidate();
        }
        Field declaredField6 = obj.getClass().getDeclaredField("LLJJJJ");
        declaredField6.setAccessible(true);
        Object obj5 = declaredField6.get(obj);
        if (obj5 instanceof View) {
        }
        if (view4 != null) {
            view4.setAlpha(1.0f);
            view4.setEnabled(true);
            view4.setClickable(true);
            view4.bringToFront();
            view4.requestLayout();
            view4.invalidate();
        }
        a(obj, viewA2);
        a(obj, viewA);
    }

    public static View a(Object obj, String str) {
        try {
            Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            if (obj2 instanceof View) {
                return (View) obj2;
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    public static void a(final Object obj, View view) {
        if (view == null) {
            return;
        }
        view.setEnabled(true);
        view.setClickable(true);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view2) {
                q.b(obj, view2);
            }
        });
    }

    public static void a(View view, View view2, boolean z) {
        View view3 = z ? view : view2;
        if (z) {
            view = view2;
        }
        if (view3 != null) {
            view3.setVisibility(0);
        }
        if (view3 != null) {
            view3.setAlpha(1.0f);
        }
        if (view3 != null) {
            view3.setEnabled(true);
        }
        if (view3 != null) {
            view3.setClickable(true);
        }
        if (view3 != null) {
            view3.bringToFront();
        }
        if (view3 != null) {
            view3.requestLayout();
        }
        if (view3 != null) {
            view3.invalidate();
        }
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public static void a(boolean z) throws IllegalAccessException, InvocationTargetException {
        Method method;
        Object objInvoke = Class.forName("X.0Mq2").getMethod("LIZ", null).invoke(null, null);
        if (objInvoke == null) {
            return;
        }
        Method[] methods = objInvoke.getClass().getMethods();
        Intrinsics.checkNotNullExpressionValue(methods, "getMethods(...)");
        int length = methods.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                method = null;
                break;
            }
            method = methods[i];
            if (Intrinsics.areEqual(method.getName(), "LJJZZI") && method.getParameterCount() == 2) {
                break;
            } else {
                i++;
            }
        }
        if (method == null) {
            return;
        }
        method.invoke(objInvoke, Boolean.valueOf(z), null);
    }

    public static final void a(Context context, String str) {
        Object systemService = context.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("comment", str));
    }

    public static void a(Fragment fragment, Context context) {
        String string;
        try {
            final Class<?> cls = Class.forName("X.0S3c");
            final Object objNewInstance = cls.getDeclaredConstructor(Fragment.class).newInstance(fragment);
            try {
                string = context.getString(2131893616);
            } catch (Throwable th) {
                string = "Скопировано";
            }
            Intrinsics.checkNotNull(string);
            cls.getDeclaredMethod("LJIIIZ", CharSequence.class).invoke(objNewInstance, string);
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public final void run() throws IllegalAccessException, InvocationTargetException {
                    q.a(cls, objNewInstance);
                }
            });
        } catch (Throwable th2) {
            th2.getMessage();
            ArrayList arrayList = g1.a;
        }
    }

    public static final void a(Class cls, Object obj) throws IllegalAccessException, InvocationTargetException {
        cls.getDeclaredMethod("LJIIJ", null).invoke(obj, null);
    }

    public static void a(View view, Context context) {
        String string;
        try {
            final Class<?> cls = Class.forName("X.0S3c");
            final Object objNewInstance = cls.getDeclaredConstructor(View.class).newInstance(view);
            try {
                string = context.getString(2131893616);
            } catch (Throwable th) {
                string = "Скопировано";
            }
            Intrinsics.checkNotNull(string);
            cls.getDeclaredMethod("LJIIIZ", CharSequence.class).invoke(objNewInstance, string);
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public final void run() throws IllegalAccessException, InvocationTargetException {
                    q.b(cls, objNewInstance);
                }
            });
        } catch (Throwable th2) {
            th2.getMessage();
            ArrayList arrayList = g1.a;
        }
    }
}
