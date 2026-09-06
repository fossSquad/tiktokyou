package Z;

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

public abstract class j2 {
    public static void a() {
        int i;
        int i2 = 2;
        int i3 = 0;
        w6[] w6VarArr = {h7.a, g7.a};
        int i4 = 0;
        while (true) {
            if (i4 >= i2) {
                i = i3;
                break;
            }
            w6 w6Var = w6VarArr[i4];
            try {
                Method[] declaredMethods = Class.forName(w6Var.b).getDeclaredMethods();
                int length = declaredMethods.length;
                int i5 = i3;
                int i6 = i5;
                while (i5 < length) {
                    Method method = declaredMethods[i5];
                    String name = method.getName();
                    String[] strArr = (String[]) h7.b.c.clone();
                    int length2 = strArr.length;
                    int i7 = i3;
                    while (true) {
                        if (i7 >= length2) {
                            i = i3;
                            break;
                        }
                        i = i3;
                        try {
                            if (strArr[i7].equals(name)) {
                                Class<?> returnType = method.getReturnType();
                                Class<?> cls = Boolean.TYPE;
                                if (returnType == cls) {
                                    Class<?>[] parameterTypes = method.getParameterTypes();
                                    if (parameterTypes.length != 0 && (parameterTypes.length != 1 || parameterTypes[i] != cls)) {
                                        break;
                                    }
                                    HookBridge.hookMethod(method, ReplaceMethod.returnConstant(Boolean.TRUE));
                                    i6++;
                                    break;
                                }
                                break;
                            }
                            i7++;
                            i3 = i;
                        } catch (Throwable th) {
                            th = th;
                            h6.a(6, h6.a("Direct gate hook error (%s)", new Object[]{w6Var.b}), th);
                            i4++;
                            i3 = i;
                            i2 = 2;
                        }
                    }
                    i5++;
                    i3 = i;
                }
                i = i3;
                if (i6 > 0) {
                    break;
                }
                i4++;
                i3 = i;
                i2 = 2;
            } catch (Throwable th2) {
                th = th2;
                i = i3;
            }
        }
        try {
            HookBridge.hookAllMethods(CommentTimeSortFeatExp.class, e7.a.c[i], new e2());
        } catch (Throwable th3) {
            String strDecrypt = "Second style sort hook error";
            Object obj = h6.a;
            h6.a(6, String.valueOf(strDecrypt), th3);
        }
        try {
            p8 p8Var = z6.a;
            HookBridge.hookAllMethods(Class.forName("X.0EZo"), z6.a.c[i], new f2());
        } catch (Throwable th4) {
            String strDecrypt2 = "CommentHooks inline sort placement hook error";
            Object obj2 = h6.a;
            h6.a(6, String.valueOf(strDecrypt2), th4);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(i7.a, i7.b);
        linkedHashMap.put(j7.a, j7.b);
        linkedHashMap.put(f7.a, f7.b);
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            w6 w6Var2 = (w6) entry.getKey();
            String[] strArr2 = (String[]) ((p8) entry.getValue()).c.clone();
            try {
                a(Class.forName(w6Var2.b), strArr2);
                String.join(",", strArr2);
            } catch (Throwable th5) {
                h6.a(6, h6.a("Translation gate hook error (%s)", new Object[]{w6Var2.b}), th5);
            }
        }
        try {
            w6 w6Var3 = f7.a;
            a(Class.forName("X.08vu"), (String[]) f7.b.c.clone());
        } catch (Throwable th6) {
            String strDecrypt3 = "Translation canShow hook error";
            Object obj3 = h6.a;
            h6.a(6, String.valueOf(strDecrypt3), th6);
        }
        try {
            String strDecrypt4 = "getAllowDownloadPhoto";
            Boolean bool = Boolean.TRUE;
            HookBridge.hookAllMethods(Comment.class, strDecrypt4, ReplaceMethod.returnConstant(bool));
            HookBridge.hookAllMethods(Comment.class, "getForbidVideoReply", ReplaceMethod.returnConstant(bool));
        } catch (Throwable th7) {
            String strDecrypt5 = "Exception during init";
            Object obj4 = h6.a;
            h6.a(6, String.valueOf(strDecrypt5), th7);
        }
        try {
            z7 z7Var = x6.a;
            Class<?> cls2 = Class.forName("X.1JL9");
            a2 a2Var = new a2();
            String[] strArr3 = (String[]) x6.c.c.clone();
            int length3 = strArr3.length;
            int i8 = i;
            int i9 = i8;
            while (i8 < length3) {
                String str = strArr3[i8];
                Method[] declaredMethods2 = cls2.getDeclaredMethods();
                int length4 = declaredMethods2.length;
                for (int i10 = i; i10 < length4; i10++) {
                    Method method2 = declaredMethods2[i10];
                    if (str.equals(method2.getName()) && method2.getParameterCount() == 0 && method2.getReturnType() == Void.TYPE) {
                        HookBridge.hookMethod(method2, a2Var);
                        i9++;
                    }
                }
                if (i9 > 0) {
                    break;
                } else {
                    i8++;
                }
            }
            if (i9 > 0) {
            } else {
            }
        } catch (Throwable th8) {
            String strDecrypt6 = "CommentHooks mGv hook error";
            Object obj5 = h6.a;
            h6.a(6, String.valueOf(strDecrypt6), th8);
        }
        try {
            HookBridge.hookAllMethods(Class.forName("com.ss.android.ugc.aweme.favorites.business.comment.CommentCollectViewHolder"), "copy", new b2());
        } catch (Throwable th9) {
            String strDecrypt7 = "Collect hook error";
            Object obj6 = h6.a;
            h6.a(6, String.valueOf(strDecrypt7), th9);
        }
    }

    public static boolean a(Object obj) {
        Object objA;
        Object objA2;
        if (obj == null) {
            return false;
        }
        try {
            Object objInvoke = dd.a(obj.getClass(), "isLandscapeMode", new Class[0]).invoke(obj, null);
            if ((objInvoke instanceof Boolean) && ((Boolean) objInvoke).booleanValue()) {
                return false;
            }
            Object objInvoke2 = dd.a(obj.getClass(), "isFriendsSimpleDetail", new Class[0]).invoke(obj, null);
            if ((objInvoke2 instanceof Boolean) && ((Boolean) objInvoke2).booleanValue()) {
                return false;
            }
            String strDecrypt = "getBlockSortFeatInFriendsV3";
            String strDecrypt2 = "blockSortFeatInFriendsV3";
            try {
                objA = dd.a(obj.getClass(), strDecrypt, new Class[0]).invoke(obj, null);
            } catch (NoSuchMethodException e) {
                objA = dd.a(obj, strDecrypt2, Object.class);
            }
            if ((objA instanceof Boolean) && ((Boolean) objA).booleanValue()) {
                return false;
            }
            String strDecrypt3 = "getAweme";
            String strDecrypt4 = "aweme";
            try {
                objA2 = dd.a(obj.getClass(), strDecrypt3, new Class[0]).invoke(obj, null);
            } catch (NoSuchMethodException e2) {
                objA2 = dd.a(obj, strDecrypt4, Object.class);
            }
            if (objA2 == null) {
                return false;
            }
            Object objInvoke3 = dd.a(objA2.getClass(), "getStatistics", new Class[0]).invoke(objA2, null);
            if (objInvoke3 == null) {
                return false;
            }
            Object objInvoke4 = dd.a(objInvoke3.getClass(), "getCommentCount", new Class[0]).invoke(objInvoke3, null);
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
        String strDecrypt;
        try {
            p8 p8Var = ha.a;
            Class<?> cls = Class.forName("X.17gj");
            Object objNewInstance = cls.getDeclaredConstructor(Fragment.class).newInstance(fragment);
            try {
                strDecrypt = context.getString(2131829885);
            } catch (Throwable th) {
                strDecrypt = "Скопировано";
            }
            ha.a.a(cls, CharSequence.class).invoke(objNewInstance, strDecrypt);
            new Handler(Looper.getMainLooper()).post(new h2(cls, objNewInstance));
        } catch (Throwable th2) {
            String strDecrypt2 = "Toast (Fragment) error";
            Object obj = h6.a;
            h6.a(6, String.valueOf(strDecrypt2), th2);
        }
    }

    public static void a(View view, Context context) {
        String strDecrypt;
        try {
            p8 p8Var = ha.a;
            Class<?> cls = Class.forName("X.17gj");
            Object objNewInstance = cls.getDeclaredConstructor(View.class).newInstance(view);
            try {
                strDecrypt = context.getString(2131829885);
            } catch (Throwable th) {
                strDecrypt = "Скопировано";
            }
            ha.a.a(cls, CharSequence.class).invoke(objNewInstance, strDecrypt);
            new Handler(Looper.getMainLooper()).post(new i2(cls, objNewInstance));
        } catch (Throwable th2) {
            String strDecrypt2 = "Toast (View) error";
            Object obj = h6.a;
            h6.a(6, String.valueOf(strDecrypt2), th2);
        }
    }
}
