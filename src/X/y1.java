package X;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.ss.android.ugc.aweme.comment.model.Comment;
import com.ss.android.ugc.aweme.experiment.CommentTimeSortFeatExp;
import com.windukk.hook.HookBridge;
import com.windukk.hook.ReplaceMethod;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class y1 {
    public static void a() {
        o5[] o5VarArr = {z5.a, y5.a};
        for (int i = 0; i < 2; i++) {
            o5 o5Var = o5VarArr[i];
            try {
                int i2 = 0;
                for (Method method : Class.forName(o5Var.b).getDeclaredMethods()) {
                    String name = method.getName();
                    for (String str : (String[]) z5.b.c.clone()) {
                        if (str.equals(name)) {
                            Class<?> returnType = method.getReturnType();
                            Class<?> cls = Boolean.TYPE;
                            if (returnType == cls) {
                                Class<?>[] parameterTypes = method.getParameterTypes();
                                if (parameterTypes.length != 0 && (parameterTypes.length != 1 || parameterTypes[0] != cls)) {
                                    break;
                                }
                                HookBridge.hookMethod(method, ReplaceMethod.returnConstant(Boolean.TRUE));
                                i2++;
                                break;
                            }
                            break;
                        }
                    }
                }
                int i3 = g5.a;
                if (i2 > 0) {
                    break;
                }
            } catch (Throwable th) {
                String str2 = o5Var.b;
                th.getMessage();
                int i4 = g5.a;
            }
        }
        try {
            HookBridge.hookAllMethods(CommentTimeSortFeatExp.class, w5.a.c[0], new t1());
            int i5 = g5.a;
        } catch (Throwable th2) {
            th2.getMessage();
            int i6 = g5.a;
        }
        try {
            t6 t6Var = r5.a;
            HookBridge.hookAllMethods(Class.forName("X.0mAM"), r5.a.c[0], new u1());
        } catch (Throwable th3) {
            th3.getMessage();
            int i7 = g5.a;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(a6.a, a6.b);
        linkedHashMap.put(b6.a, b6.b);
        linkedHashMap.put(x5.a, x5.b);
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            o5 o5Var2 = (o5) entry.getKey();
            String[] strArr = (String[]) ((t6) entry.getValue()).c.clone();
            try {
                a(Class.forName(o5Var2.b), strArr);
                String.join(",", strArr);
                int i8 = g5.a;
            } catch (Throwable th4) {
                String str3 = o5Var2.b;
                th4.getMessage();
                int i9 = g5.a;
            }
        }
        try {
            o5 o5Var3 = x5.a;
            a(Class.forName("X.0BVW"), (String[]) x5.b.c.clone());
            int i10 = g5.a;
        } catch (Throwable th5) {
            th5.getMessage();
            int i11 = g5.a;
        }
        try {
            Boolean bool = Boolean.TRUE;
            HookBridge.hookAllMethods(Comment.class, "getAllowDownloadPhoto", ReplaceMethod.returnConstant(bool));
            HookBridge.hookAllMethods(Comment.class, "getForbidVideoReply", ReplaceMethod.returnConstant(bool));
        } catch (Throwable th6) {
            th6.getMessage();
            int i12 = g5.a;
        }
        try {
            k6 k6Var = p5.a;
            Class<?> cls2 = Class.forName("X.0mFu");
            p1 p1Var = new p1();
            int i13 = 0;
            for (String str4 : (String[]) p5.c.c.clone()) {
                for (Method method2 : cls2.getDeclaredMethods()) {
                    if (str4.equals(method2.getName()) && method2.getParameterCount() == 0 && method2.getReturnType() == Void.TYPE) {
                        HookBridge.hookMethod(method2, p1Var);
                        i13++;
                    }
                }
                if (i13 > 0) {
                    break;
                }
            }
            if (i13 > 0) {
                int i14 = g5.a;
            } else {
                int i15 = g5.a;
            }
        } catch (Throwable th7) {
            th7.getMessage();
            int i16 = g5.a;
        }
        try {
            HookBridge.hookAllMethods(Class.forName("com.ss.android.ugc.aweme.favorites.business.comment.CommentCollectViewHolder"), "copy", new q1());
        } catch (Throwable th8) {
            th8.getMessage();
            int i17 = g5.a;
        }
    }

    public static boolean a(Object obj) {
        Object objA;
        Object objA2;
        Object objInvoke;
        if (obj == null) {
            return false;
        }
        try {
            Object objInvoke2 = ha.a(obj.getClass(), "isLandscapeMode", new Class[0]).invoke(obj, null);
            if ((objInvoke2 instanceof Boolean) && ((Boolean) objInvoke2).booleanValue()) {
                return false;
            }
            Object objInvoke3 = ha.a(obj.getClass(), "isFriendsSimpleDetail", new Class[0]).invoke(obj, null);
            if ((objInvoke3 instanceof Boolean) && ((Boolean) objInvoke3).booleanValue()) {
                return false;
            }
            try {
                objA = ha.a(obj.getClass(), "getBlockSortFeatInFriendsV3", new Class[0]).invoke(obj, null);
            } catch (NoSuchMethodException e) {
                objA = ha.a(obj, "blockSortFeatInFriendsV3", Object.class);
            }
            if ((objA instanceof Boolean) && ((Boolean) objA).booleanValue()) {
                return false;
            }
            try {
                objA2 = ha.a(obj.getClass(), "getAweme", new Class[0]).invoke(obj, null);
            } catch (NoSuchMethodException e2) {
                objA2 = ha.a(obj, "aweme", Object.class);
            }
            if (objA2 == null || (objInvoke = ha.a(objA2.getClass(), "getStatistics", new Class[0]).invoke(objA2, null)) == null) {
                return false;
            }
            Object objInvoke4 = ha.a(objInvoke.getClass(), "getCommentCount", new Class[0]).invoke(objInvoke, null);
            return (objInvoke4 instanceof Number) && ((Number) objInvoke4).longValue() > 0;
        } catch (Throwable th) {
            return false;
        }
    }

    public static Method a(Class cls) {
        Class<?> returnType;
        for (Method method : cls.getDeclaredMethods()) {
            if (Modifier.isStatic(method.getModifiers()) && method.getParameterCount() == 0 && ((returnType = method.getReturnType()) == Context.class || Context.class.isAssignableFrom(returnType))) {
                method.setAccessible(true);
                return method;
            }
        }
        return null;
    }

    public static void a(Class cls, String[] strArr) {
        for (Method method : cls.getDeclaredMethods()) {
            for (String str : strArr) {
                if (str.equals(method.getName())) {
                    Class<?> returnType = method.getReturnType();
                    if (returnType != Boolean.TYPE && returnType != Boolean.class) {
                        break;
                    }
                    HookBridge.hookMethod(method, ReplaceMethod.returnConstant(Boolean.TRUE));
                    break;
                }
            }
        }
    }

    public static void a(Context context, String str) {
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(ClipData.newPlainText("comment", str));
        }
    }

    public static void a(Fragment fragment, Context context) {
        String string;
        try {
            t6 t6Var = x7.a;
            Class<?> cls = Class.forName("X.0zi9");
            Object objNewInstance = cls.getDeclaredConstructor(Fragment.class).newInstance(fragment);
            try {
                string = context.getString(2131893616);
            } catch (Throwable th) {
                string = "Скопировано";
            }
            x7.a.a(cls, CharSequence.class).invoke(objNewInstance, string);
            new Handler(Looper.getMainLooper()).post(new w1(cls, objNewInstance));
        } catch (Throwable th2) {
            th2.getMessage();
            int i = g5.a;
        }
    }

    public static void a(View view, Context context) {
        String string;
        try {
            t6 t6Var = x7.a;
            Class<?> cls = Class.forName("X.0zi9");
            Object objNewInstance = cls.getDeclaredConstructor(View.class).newInstance(view);
            try {
                string = context.getString(2131893616);
            } catch (Throwable th) {
                string = "Скопировано";
            }
            x7.a.a(cls, CharSequence.class).invoke(objNewInstance, string);
            new Handler(Looper.getMainLooper()).post(new x1(cls, objNewInstance));
        } catch (Throwable th2) {
            th2.getMessage();
            int i = g5.a;
        }
    }
}
