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
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class y {
    public static void a() {
        String[] strArr = {"X.0Ab2", "X.0BI8"};
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
                                XposedBridge.hookMethod(method, XC_MethodReplacement.returnConstant(Boolean.TRUE));
                                i2++;
                            }
                        }
                    }
                }
                ArrayList arrayList = r1.a;
                if (i2 > 0) {
                    break;
                }
            } catch (Throwable th) {
                th.getMessage();
                ArrayList arrayList2 = r1.a;
            }
        }
        try {
            XposedBridge.hookAllMethods(CommentTimeSortFeatExp.class, "LIZ", new t());
            ArrayList arrayList3 = r1.a;
        } catch (Throwable th2) {
            th2.getMessage();
            ArrayList arrayList4 = r1.a;
        }
        try {
            XposedBridge.hookAllMethods(Class.forName("X.0tOc"), "LIZIZ", new u());
        } catch (Throwable th3) {
            th3.getMessage();
            ArrayList arrayList5 = r1.a;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("X.0OFP", new String[]{"LIZ", "LIZIZ", "LIZJ"});
        linkedHashMap.put("X.0MiX", new String[]{"LIZ", "LIZIZ", "LIZJ"});
        linkedHashMap.put("X.0BBX", new String[]{"LIZJ"});
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str = (String) entry.getKey();
            String[] strArr2 = (String[]) entry.getValue();
            try {
                a(Class.forName(str), strArr2);
                String.join(",", strArr2);
                ArrayList arrayList6 = r1.a;
            } catch (Throwable th4) {
                th4.getMessage();
                ArrayList arrayList7 = r1.a;
            }
        }
        try {
            a(Class.forName("X.0BBX"), new String[]{"LIZJ"});
            ArrayList arrayList8 = r1.a;
        } catch (Throwable th5) {
            th5.getMessage();
            ArrayList arrayList9 = r1.a;
        }
        try {
            Boolean bool = Boolean.TRUE;
            XposedBridge.hookAllMethods(Comment.class, "getAllowDownloadPhoto", XC_MethodReplacement.returnConstant(bool));
            XposedBridge.hookAllMethods(Comment.class, "getForbidVideoReply", XC_MethodReplacement.returnConstant(bool));
        } catch (Throwable th6) {
            th6.getMessage();
            ArrayList arrayList10 = r1.a;
        }
        try {
            XposedBridge.hookAllMethods(Class.forName("X.0tNy"), "LJIILJJIL", new p());
        } catch (Throwable th7) {
            th7.getMessage();
            ArrayList arrayList11 = r1.a;
        }
        try {
            XposedBridge.hookAllMethods(Class.forName("com.ss.android.ugc.aweme.favorites.business.comment.CommentCollectViewHolder"), "copy", new q());
        } catch (Throwable th8) {
            th8.getMessage();
            ArrayList arrayList12 = r1.a;
        }
    }

    public static boolean a(Object obj) {
        Object objInvoke;
        Object objInvoke2;
        if (obj == null) {
            return false;
        }
        try {
            Object objInvoke3 = obj.getClass().getMethod("isLandscapeMode", null).invoke(obj, null);
            if ((objInvoke3 instanceof Boolean) && ((Boolean) objInvoke3).booleanValue()) {
                return false;
            }
            Object objInvoke4 = obj.getClass().getMethod("isFriendsSimpleDetail", null).invoke(obj, null);
            if ((objInvoke4 instanceof Boolean) && ((Boolean) objInvoke4).booleanValue()) {
                return false;
            }
            Object objInvoke5 = obj.getClass().getMethod("getBlockSortFeatInFriendsV3", null).invoke(obj, null);
            if (((objInvoke5 instanceof Boolean) && ((Boolean) objInvoke5).booleanValue()) || (objInvoke = obj.getClass().getMethod("getAweme", null).invoke(obj, null)) == null || (objInvoke2 = objInvoke.getClass().getMethod("getStatistics", null).invoke(objInvoke, null)) == null) {
                return false;
            }
            Object objInvoke6 = objInvoke2.getClass().getMethod("getCommentCount", null).invoke(objInvoke2, null);
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
                    XposedBridge.hookMethod(method, XC_MethodReplacement.returnConstant(Boolean.TRUE));
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
            Class<?> cls = Class.forName("X.0rjd");
            Object objNewInstance = cls.getDeclaredConstructor(Fragment.class).newInstance(fragment);
            try {
                string = context.getString(2131893616);
            } catch (Throwable th) {
                string = "Скопировано";
            }
            cls.getDeclaredMethod("LJIIIZ", CharSequence.class).invoke(objNewInstance, string);
            new Handler(Looper.getMainLooper()).post(new w(cls, objNewInstance));
        } catch (Throwable th2) {
            th2.getMessage();
            ArrayList arrayList = r1.a;
        }
    }

    public static void a(View view, Context context) {
        String string;
        try {
            Class<?> cls = Class.forName("X.0rjd");
            Object objNewInstance = cls.getDeclaredConstructor(View.class).newInstance(view);
            try {
                string = context.getString(2131893616);
            } catch (Throwable th) {
                string = "Скопировано";
            }
            cls.getDeclaredMethod("LJIIIZ", CharSequence.class).invoke(objNewInstance, string);
            new Handler(Looper.getMainLooper()).post(new x(cls, objNewInstance));
        } catch (Throwable th2) {
            th2.getMessage();
            ArrayList arrayList = r1.a;
        }
    }
}
