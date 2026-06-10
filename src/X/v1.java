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

public abstract class v1 {
    public static void a() {
        x4[] x4VarArr = {e5.a, d5.a};
        for (int i = 0; i < 2; i++) {
            x4 x4Var = x4VarArr[i];
            try {
                int i2 = 0;
                for (Method method : Class.forName(x4Var.b).getDeclaredMethods()) {
                    String name = method.getName();
                    for (String str : (String[]) e5.b.c.clone()) {
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
                int i3 = p4.a;
                if (i2 > 0) {
                    break;
                }
            } catch (Throwable th) {
                String str2 = x4Var.b;
                th.getMessage();
                int i4 = p4.a;
            }
        }
        try {
            HookBridge.hookAllMethods(CommentTimeSortFeatExp.class, b5.a.c[0], new q1());
            int i5 = p4.a;
        } catch (Throwable th2) {
            th2.getMessage();
            int i6 = p4.a;
        }
        try {
            x5 x5Var = a5.a;
            HookBridge.hookAllMethods(Class.forName("X.0lft"), a5.a.c[0], new r1());
        } catch (Throwable th3) {
            th3.getMessage();
            int i7 = p4.a;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(f5.a, f5.b);
        linkedHashMap.put(g5.a, g5.b);
        linkedHashMap.put(c5.a, c5.b);
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            x4 x4Var2 = (x4) entry.getKey();
            String[] strArr = (String[]) ((x5) entry.getValue()).c.clone();
            try {
                a(Class.forName(x4Var2.b), strArr);
                String.join(",", strArr);
                int i8 = p4.a;
            } catch (Throwable th4) {
                String str3 = x4Var2.b;
                th4.getMessage();
                int i9 = p4.a;
            }
        }
        try {
            x4 x4Var3 = c5.a;
            a(Class.forName("X.0ArS"), (String[]) c5.b.c.clone());
            int i10 = p4.a;
        } catch (Throwable th5) {
            th5.getMessage();
            int i11 = p4.a;
        }
        try {
            Boolean bool = Boolean.TRUE;
            HookBridge.hookAllMethods(Comment.class, "getAllowDownloadPhoto", ReplaceMethod.returnConstant(bool));
            HookBridge.hookAllMethods(Comment.class, "getForbidVideoReply", ReplaceMethod.returnConstant(bool));
        } catch (Throwable th6) {
            th6.getMessage();
            int i12 = p4.a;
        }
        try {
            p5 p5Var = y4.a;
            Class<?> cls2 = Class.forName("X.0lmM");
            m1 m1Var = new m1();
            int i13 = 0;
            for (String str4 : (String[]) y4.c.c.clone()) {
                for (Method method2 : cls2.getDeclaredMethods()) {
                    if (str4.equals(method2.getName()) && method2.getParameterCount() == 0 && method2.getReturnType() == Void.TYPE) {
                        HookBridge.hookMethod(method2, m1Var);
                        i13++;
                    }
                }
                if (i13 > 0) {
                    break;
                }
            }
            if (i13 > 0) {
                int i14 = p4.a;
            } else {
                int i15 = p4.a;
            }
        } catch (Throwable th7) {
            th7.getMessage();
            int i16 = p4.a;
        }
        try {
            HookBridge.hookAllMethods(Class.forName("com.ss.android.ugc.aweme.favorites.business.comment.CommentCollectViewHolder"), "copy", new n1());
        } catch (Throwable th8) {
            th8.getMessage();
            int i17 = p4.a;
        }
    }

    public static boolean a(Object obj) {
        Object objInvoke;
        Object objInvoke2;
        if (obj == null) {
            return false;
        }
        try {
            Object objInvoke3 = g8.a(obj.getClass(), "isLandscapeMode", new Class[0]).invoke(obj, null);
            if ((objInvoke3 instanceof Boolean) && ((Boolean) objInvoke3).booleanValue()) {
                return false;
            }
            Object objInvoke4 = g8.a(obj.getClass(), "isFriendsSimpleDetail", new Class[0]).invoke(obj, null);
            if ((objInvoke4 instanceof Boolean) && ((Boolean) objInvoke4).booleanValue()) {
                return false;
            }
            Object objInvoke5 = g8.a(obj.getClass(), "getBlockSortFeatInFriendsV3", new Class[0]).invoke(obj, null);
            if (((objInvoke5 instanceof Boolean) && ((Boolean) objInvoke5).booleanValue()) || (objInvoke = g8.a(obj.getClass(), "getAweme", new Class[0]).invoke(obj, null)) == null || (objInvoke2 = g8.a(objInvoke.getClass(), "getStatistics", new Class[0]).invoke(objInvoke, null)) == null) {
                return false;
            }
            Object objInvoke6 = g8.a(objInvoke2.getClass(), "getCommentCount", new Class[0]).invoke(objInvoke2, null);
            return (objInvoke6 instanceof Number) && ((Number) objInvoke6).longValue() > 0;
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
            x5 x5Var = u6.a;
            Class<?> cls = Class.forName("X.14OT");
            Object objNewInstance = cls.getDeclaredConstructor(Fragment.class).newInstance(fragment);
            try {
                string = context.getString(2131893616);
            } catch (Throwable th) {
                string = "Скопировано";
            }
            u6.a.a(cls, CharSequence.class).invoke(objNewInstance, string);
            new Handler(Looper.getMainLooper()).post(new t1(cls, objNewInstance));
        } catch (Throwable th2) {
            th2.getMessage();
            int i = p4.a;
        }
    }

    public static void a(View view, Context context) {
        String string;
        try {
            x5 x5Var = u6.a;
            Class<?> cls = Class.forName("X.14OT");
            Object objNewInstance = cls.getDeclaredConstructor(View.class).newInstance(view);
            try {
                string = context.getString(2131893616);
            } catch (Throwable th) {
                string = "Скопировано";
            }
            u6.a.a(cls, CharSequence.class).invoke(objNewInstance, string);
            new Handler(Looper.getMainLooper()).post(new u1(cls, objNewInstance));
        } catch (Throwable th2) {
            th2.getMessage();
            int i = p4.a;
        }
    }
}
