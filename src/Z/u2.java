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
import com.ss.android.ugc.aweme.favorites.business.comment.CommentCollectViewHolder;
import com.windukk.hook.HookBridge;
import com.windukk.hook.ReplaceMethod;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class u2 {
    public static void a() {
        int i;
        int i2 = 2;
        int i3 = 0;
        w7[] w7VarArr = {h8.a, g8.a};
        int i4 = 0;
        while (true) {
            if (i4 >= i2) {
                i = i3;
                break;
            }
            w7 w7Var = w7VarArr[i4];
            try {
                Method[] declaredMethods = Class.forName(w7Var.b).getDeclaredMethods();
                int length = declaredMethods.length;
                int i5 = i3;
                int i6 = i5;
                while (i5 < length) {
                    Method method = declaredMethods[i5];
                    String name = method.getName();
                    String[] strArr = (String[]) h8.b.c.clone();
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
                            g7.a(6, g7.a("Direct gate hook error (%s)", new Object[]{w7Var.b}), th);
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
            HookBridge.hookAllMethods(CommentTimeSortFeatExp.class, e8.a.c[i], new p2());
        } catch (Throwable th3) {
            String strDecrypt = "Second style sort hook error";
            Object obj = g7.a;
            g7.a(6, String.valueOf(strDecrypt), th3);
        }
        try {
            v9 v9Var = z7.a;
            HookBridge.hookAllMethods(Class.forName("X.0FQV"), z7.a.c[i], new q2());
        } catch (Throwable th4) {
            String strDecrypt2 = "CommentHooks inline sort placement hook error";
            Object obj2 = g7.a;
            g7.a(6, String.valueOf(strDecrypt2), th4);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(i8.a, i8.b);
        linkedHashMap.put(j8.a, j8.b);
        linkedHashMap.put(f8.a, f8.b);
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            w7 w7Var2 = (w7) entry.getKey();
            String[] strArr2 = (String[]) ((v9) entry.getValue()).c.clone();
            try {
                a(Class.forName(w7Var2.b), strArr2);
                String.join(",", strArr2);
            } catch (Throwable th5) {
                g7.a(6, g7.a("Translation gate hook error (%s)", new Object[]{w7Var2.b}), th5);
            }
        }
        try {
            w7 w7Var3 = f8.a;
            a(Class.forName("X.08zp"), (String[]) f8.b.c.clone());
        } catch (Throwable th6) {
            String strDecrypt3 = "Translation canShow hook error";
            Object obj3 = g7.a;
            g7.a(6, String.valueOf(strDecrypt3), th6);
        }
        try {
            String strDecrypt4 = "getAllowDownloadPhoto";
            Boolean bool = Boolean.TRUE;
            HookBridge.hookAllMethods(Comment.class, strDecrypt4, ReplaceMethod.returnConstant(bool));
            HookBridge.hookAllMethods(Comment.class, "getForbidVideoReply", ReplaceMethod.returnConstant(bool));
        } catch (Throwable th7) {
            String strDecrypt5 = "Exception during init";
            Object obj4 = g7.a;
            g7.a(6, String.valueOf(strDecrypt5), th7);
        }
        try {
            e9 e9Var = x7.a;
            Class<?> cls2 = Class.forName("X.17FI");
            l2 l2Var = new l2();
            String[] strArr3 = (String[]) x7.c.c.clone();
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
                        HookBridge.hookMethod(method2, l2Var);
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
            Object obj5 = g7.a;
            g7.a(6, String.valueOf(strDecrypt6), th8);
        }
        try {
            HookBridge.hookAllMethods(CommentCollectViewHolder.class, "copy", new m2());
        } catch (Throwable th9) {
            String strDecrypt7 = "Collect hook error";
            Object obj6 = g7.a;
            g7.a(6, String.valueOf(strDecrypt7), th9);
        }
    }

    public static boolean a(Object obj) {
        Object objA;
        Object objA2;
        if (obj == null) {
            return false;
        }
        try {
            Object objInvoke = se.a(obj.getClass(), "isLandscapeMode", new Class[0]).invoke(obj, null);
            if ((objInvoke instanceof Boolean) && ((Boolean) objInvoke).booleanValue()) {
                return false;
            }
            Object objInvoke2 = se.a(obj.getClass(), "isFriendsSimpleDetail", new Class[0]).invoke(obj, null);
            if ((objInvoke2 instanceof Boolean) && ((Boolean) objInvoke2).booleanValue()) {
                return false;
            }
            String strDecrypt = "getBlockSortFeatInFriendsV3";
            String strDecrypt2 = "blockSortFeatInFriendsV3";
            try {
                objA = se.a(obj.getClass(), strDecrypt, new Class[0]).invoke(obj, null);
            } catch (NoSuchMethodException e) {
                objA = se.a(Object.class, obj, strDecrypt2);
            }
            if ((objA instanceof Boolean) && ((Boolean) objA).booleanValue()) {
                return false;
            }
            String strDecrypt3 = "getAweme";
            String strDecrypt4 = "aweme";
            try {
                objA2 = se.a(obj.getClass(), strDecrypt3, new Class[0]).invoke(obj, null);
            } catch (NoSuchMethodException e2) {
                objA2 = se.a(Object.class, obj, strDecrypt4);
            }
            if (objA2 == null) {
                return false;
            }
            Object objInvoke3 = se.a(objA2.getClass(), "getStatistics", new Class[0]).invoke(objA2, null);
            if (objInvoke3 == null) {
                return false;
            }
            Object objInvoke4 = se.a(objInvoke3.getClass(), "getCommentCount", new Class[0]).invoke(objInvoke3, null);
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
            v9 v9Var = pb.a;
            Class<?> cls = Class.forName("X.10IW");
            Object objNewInstance = cls.getDeclaredConstructor(Fragment.class).newInstance(fragment);
            try {
                strDecrypt = context.getString(2131830162);
            } catch (Throwable th) {
                strDecrypt = "Скопировано";
            }
            pb.a.a(cls, CharSequence.class).invoke(objNewInstance, strDecrypt);
            new Handler(Looper.getMainLooper()).post(new s2(cls, objNewInstance));
        } catch (Throwable th2) {
            String strDecrypt2 = "Toast (Fragment) error";
            Object obj = g7.a;
            g7.a(6, String.valueOf(strDecrypt2), th2);
        }
    }

    public static void a(View view, Context context) {
        String strDecrypt;
        try {
            v9 v9Var = pb.a;
            Class<?> cls = Class.forName("X.10IW");
            Object objNewInstance = cls.getDeclaredConstructor(View.class).newInstance(view);
            try {
                strDecrypt = context.getString(2131830162);
            } catch (Throwable th) {
                strDecrypt = "Скопировано";
            }
            pb.a.a(cls, CharSequence.class).invoke(objNewInstance, strDecrypt);
            new Handler(Looper.getMainLooper()).post(new t2(cls, objNewInstance));
        } catch (Throwable th2) {
            String strDecrypt2 = "Toast (View) error";
            Object obj = g7.a;
            g7.a(6, String.valueOf(strDecrypt2), th2);
        }
    }
}
