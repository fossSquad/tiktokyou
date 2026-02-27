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
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

public final class m {
    public static final void a() {
        try {
            Boolean bool = Boolean.TRUE;
            XposedBridge.hookAllMethods(Comment.class, "getAllowDownloadPhoto", XC_MethodReplacement.returnConstant(bool));
            XposedBridge.hookAllMethods(Comment.class, "getForbidVideoReply", XC_MethodReplacement.returnConstant(bool));
        } catch (Throwable th) {
            th.getMessage();
            ArrayList arrayList = q0.a;
        }
        try {
            XposedBridge.hookAllMethods(Class.forName("X.0o6j"), "LJJLJ", new g());
            ArrayList arrayList2 = q0.a;
        } catch (Throwable th2) {
            th2.getMessage();
            ArrayList arrayList3 = q0.a;
        }
        try {
            XposedBridge.hookAllMethods(Class.forName("com.ss.android.ugc.aweme.favorites.business.comment.CommentCollectViewHolder"), "copy", new h());
        } catch (Throwable th3) {
            th3.getMessage();
            ArrayList arrayList4 = q0.a;
        }
    }

    public static final void b(Class cls, Object obj) throws IllegalAccessException, InvocationTargetException {
        cls.getDeclaredMethod("LJIIJ", null).invoke(obj, null);
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
                    m.a(cls, objNewInstance);
                }
            });
        } catch (Throwable th2) {
            th2.getMessage();
            ArrayList arrayList = q0.a;
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
                    m.b(cls, objNewInstance);
                }
            });
        } catch (Throwable th2) {
            th2.getMessage();
            ArrayList arrayList = q0.a;
        }
    }
}
