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

public abstract class h1 {
    public static void a() {
        String[] strArr = {"X.0B1u", "X.0BkU"};
        for (int i = 0; i < 2; i++) {
            try {
                int i2 = 0;
                for (Method method : Class.forName(strArr[i]).getDeclaredMethods()) {
                    String name = method.getName();
                    if (name.equals("LIZ") || name.equals("LIZIZ")) {
                        Class<?> returnType = method.getReturnType();
                        Class<?> cls = Boolean.TYPE;
                        if (returnType == cls) {
                            Class<?>[] parameterTypes = method.getParameterTypes();
                            if (parameterTypes.length == 0 || (parameterTypes.length == 1 && parameterTypes[0] == cls)) {
                                HookBridge.hookMethod(method, ReplaceMethod.returnConstant(Boolean.TRUE));
                                i2++;
                            }
                        }
                    }
                }
                int i3 = v3.a;
                if (i2 > 0) {
                    break;
                }
            } catch (Throwable th) {
                th.getMessage();
                int i4 = v3.a;
            }
        }
        try {
            HookBridge.hookAllMethods(CommentTimeSortFeatExp.class, "LIZ", new c1());
            int i5 = v3.a;
        } catch (Throwable th2) {
            th2.getMessage();
            int i6 = v3.a;
        }
        try {
            HookBridge.hookAllMethods(Class.forName("X.0m1J"), "LIZIZ", new d1());
        } catch (Throwable th3) {
            th3.getMessage();
            int i7 = v3.a;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("X.0Qre", new String[]{"LIZ", "LIZIZ", "LIZJ"});
        linkedHashMap.put("X.0Moc", new String[]{"LIZ", "LIZIZ", "LIZJ"});
        linkedHashMap.put("X.0BcE", new String[]{"LIZJ"});
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str = (String) entry.getKey();
            String[] strArr2 = (String[]) entry.getValue();
            try {
                a(Class.forName(str), strArr2);
                String.join(",", strArr2);
                int i8 = v3.a;
            } catch (Throwable th4) {
                th4.getMessage();
                int i9 = v3.a;
            }
        }
        try {
            a(Class.forName("X.0BcE"), new String[]{"LIZJ"});
            int i10 = v3.a;
        } catch (Throwable th5) {
            th5.getMessage();
            int i11 = v3.a;
        }
        try {
            Boolean bool = Boolean.TRUE;
            HookBridge.hookAllMethods(Comment.class, "getAllowDownloadPhoto", ReplaceMethod.returnConstant(bool));
            HookBridge.hookAllMethods(Comment.class, "getForbidVideoReply", ReplaceMethod.returnConstant(bool));
        } catch (Throwable th6) {
            th6.getMessage();
            int i12 = v3.a;
        }
        try {
            Class<?> cls2 = Class.forName("X.0m52");
            y0 y0Var = new y0();
            String[] strArr3 = {"LJIILL", "LJIILJJIL"};
            int i13 = 0;
            for (int i14 = 0; i14 < 2; i14++) {
                String str2 = strArr3[i14];
                for (Method method2 : cls2.getDeclaredMethods()) {
                    if (str2.equals(method2.getName()) && method2.getParameterCount() == 0 && method2.getReturnType() == Void.TYPE) {
                        HookBridge.hookMethod(method2, y0Var);
                        i13++;
                    }
                }
                if (i13 > 0) {
                    break;
                }
            }
            if (i13 > 0) {
                int i15 = v3.a;
            } else {
                int i16 = v3.a;
            }
        } catch (Throwable th7) {
            th7.getMessage();
            int i17 = v3.a;
        }
        try {
            HookBridge.hookAllMethods(Class.forName("com.ss.android.ugc.aweme.favorites.business.comment.CommentCollectViewHolder"), "copy", new z0());
        } catch (Throwable th8) {
            th8.getMessage();
            int i18 = v3.a;
        }
    }

    public static boolean a(Object obj) {
        Object objInvoke;
        Object objInvoke2;
        if (obj == null) {
            return false;
        }
        try {
            Object objInvoke3 = e4.a(obj.getClass(), "isLandscapeMode", new Class[0]).invoke(obj, null);
            if ((objInvoke3 instanceof Boolean) && ((Boolean) objInvoke3).booleanValue()) {
                return false;
            }
            Object objInvoke4 = e4.a(obj.getClass(), "isFriendsSimpleDetail", new Class[0]).invoke(obj, null);
            if ((objInvoke4 instanceof Boolean) && ((Boolean) objInvoke4).booleanValue()) {
                return false;
            }
            Object objInvoke5 = e4.a(obj.getClass(), "getBlockSortFeatInFriendsV3", new Class[0]).invoke(obj, null);
            if (((objInvoke5 instanceof Boolean) && ((Boolean) objInvoke5).booleanValue()) || (objInvoke = e4.a(obj.getClass(), "getAweme", new Class[0]).invoke(obj, null)) == null || (objInvoke2 = e4.a(objInvoke.getClass(), "getStatistics", new Class[0]).invoke(objInvoke, null)) == null) {
                return false;
            }
            Object objInvoke6 = e4.a(objInvoke2.getClass(), "getCommentCount", new Class[0]).invoke(objInvoke2, null);
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
            Class<?> cls = Class.forName("X.0hxa");
            Object objNewInstance = cls.getDeclaredConstructor(Fragment.class).newInstance(fragment);
            try {
                string = context.getString(2131893616);
            } catch (Throwable th) {
                string = "Скопировано";
            }
            e4.a(cls, "LJIIIZ", CharSequence.class).invoke(objNewInstance, string);
            new Handler(Looper.getMainLooper()).post(new f1(cls, objNewInstance));
        } catch (Throwable th2) {
            th2.getMessage();
            int i = v3.a;
        }
    }

    public static void a(View view, Context context) {
        String string;
        try {
            Class<?> cls = Class.forName("X.0hxa");
            Object objNewInstance = cls.getDeclaredConstructor(View.class).newInstance(view);
            try {
                string = context.getString(2131893616);
            } catch (Throwable th) {
                string = "Скопировано";
            }
            e4.a(cls, "LJIIIZ", CharSequence.class).invoke(objNewInstance, string);
            new Handler(Looper.getMainLooper()).post(new g1(cls, objNewInstance));
        } catch (Throwable th2) {
            th2.getMessage();
            int i = v3.a;
        }
    }
}
