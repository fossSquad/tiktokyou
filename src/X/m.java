package X;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.im.core.proto.ReferenceInfo;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class m {
    public static final Handler a = new Handler(Looper.getMainLooper());
    public static final AtomicBoolean b = new AtomicBoolean(false);
    public static final AtomicBoolean c = new AtomicBoolean(false);
    public static final h d = new h();

    public static void a(Context context, String str) {
        boolean z;
        try {
            String strA = a();
            if (TextUtils.isEmpty(strA)) {
                ArrayList arrayList = r1.a;
                c.set(false);
                return;
            }
            List listB = b();
            z = listB != null;
            try {
                if (listB == null) {
                    ArrayList arrayList2 = r1.a;
                    c.set(false);
                    return;
                }
                HashSet hashSet = new HashSet();
                int i = 0;
                int i2 = 0;
                for (Object obj : listB) {
                    try {
                        if (!(ZonedDateTime.now().getHour() == 12)) {
                            break;
                        }
                        if (a(obj)) {
                            Object obj2 = a((Class) obj.getClass(), "convId").get(obj);
                            String str2 = obj2 instanceof String ? (String) obj2 : null;
                            if (!TextUtils.isEmpty(str2) && hashSet.add(str2)) {
                                String strA2 = a(obj, strA);
                                if (!TextUtils.isEmpty(strA2)) {
                                    i++;
                                    if (a(strA2, str2)) {
                                        i2++;
                                        try {
                                            Thread.sleep(3000L);
                                        } catch (InterruptedException e) {
                                            Thread.currentThread().interrupt();
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                    }
                    th = th;
                    try {
                        th.getMessage();
                        ArrayList arrayList3 = r1.a;
                    } finally {
                        if (!z) {
                            ArrayList arrayList4 = r1.a;
                        }
                        c.set(false);
                    }
                }
                if (i2 > 0 || i == 0) {
                    t1 t1VarA = t1.a();
                    String string = LocalDate.now().toString();
                    t1VarA.getClass();
                    if (string == null) {
                        string = "";
                    }
                    t1VarA.l = string;
                    t1.m.edit().putString("auto_streak_nudge_last_run_date", t1VarA.l).apply();
                }
                ArrayList arrayList5 = r1.a;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            z = false;
        }
    }

    public static  void b(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            c(applicationContext, str);
        }
    }

    public static void c(final Context context, final String str) {
        if (t1.m == null || t1.a() == null) {
            if (t1.m == null) {
                t1.m = context.getSharedPreferences("ttmod_settings", 0);
            }
            if (t1.n == null) {
                t1.n = new t1();
            }
        }
        if (t1.a().k && ZonedDateTime.now().getHour() == 12) {
            String string = LocalDate.now().toString();
            String str2 = t1.a().l;
            if (str2 == null) {
                str2 = "";
            }
            if (!string.equals(str2) && c.compareAndSet(false, true)) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public final void run() {
                        m.a(context, str);
                    }
                }, "auto-streak-nudge");
                thread.setDaemon(true);
                thread.start();
            }
        }
    }

    public static void d(final Context context, final String str) {
        a.postDelayed(new Runnable() {
            @Override
            public final void run() {
                m.b(context, str);
            }
        }, 20000L);
    }

    public static List b() throws IllegalAccessException, InvocationTargetException {
        Object obj = a((Class) Class.forName("X.0UPv"), "LIZIZ").get(null);
        if (obj == null) {
            return null;
        }
        Object objInvoke = a(obj.getClass(), "LIZ", List.class).invoke(obj, Collections.singletonList(Enum.valueOf(Class.forName("X.0UPU"), "USER")));
        if (!(objInvoke instanceof List)) {
            return null;
        }
        return (List) objInvoke;
    }

    public static void b(Context context) {
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(AlarmManager.class);
            if (alarmManager == null) {
                return;
            }
            Intent intent = new Intent(context, (Class<?>) n.class);
            intent.setAction("com.windukk.mod.AUTO_STREAK_NUDGE");
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 44021, intent, 201326592);
            ZonedDateTime zonedDateTimeNow = ZonedDateTime.now();
            ZonedDateTime zonedDateTimeWithNano = zonedDateTimeNow.withHour(12).withMinute(0).withSecond(0).withNano(0);
            if (!zonedDateTimeNow.isBefore(zonedDateTimeWithNano)) {
                zonedDateTimeWithNano = zonedDateTimeWithNano.plusDays(1L);
            }
            alarmManager.setAndAllowWhileIdle(0, zonedDateTimeWithNano.toInstant().toEpochMilli(), broadcast);
        } catch (Throwable th) {
            th.getMessage();
            ArrayList arrayList = r1.a;
        }
    }

    public static boolean a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("com.ss.android.ugc.aweme.im.sdk.chat.feature.nudge.IMNudgeAndStreakService");
            Object obj = a((Class) cls, "LJFF").get(null);
            if (obj == null) {
                return false;
            }
            Class<?> cls2 = Class.forName("X.0Qyl");
            Object objA = a(cls2, Class.forName("X.0Qyo"), Class.forName("X.0Qzg"), Class.forName("X.0Qzd"), str);
            Class<?> cls3 = Class.forName("X.0Qym");
            return Boolean.TRUE.equals(a(cls, "LIZJ", cls2, Boolean.TYPE, String.class, cls3, Class.forName("X.0Qza"), String.class).invoke(obj, objA, Boolean.FALSE, str2, cls3.getConstructor(null).newInstance(null), null, null));
        } catch (Throwable th) {
            th.getMessage();
            ArrayList arrayList = r1.a;
            return false;
        }
    }

    public static String a() throws IllegalAccessException, InvocationTargetException {
        Object objInvoke;
        Object obj = a((Class) Class.forName("X.0QQR"), "LJFF").get(null);
        if (obj != null && (objInvoke = a(obj.getClass(), "LIZ", new Class[0]).invoke(obj, null)) != null) {
            if (!Boolean.TRUE.equals(a(objInvoke.getClass(), "isLogin", new Class[0]).invoke(objInvoke, null))) {
                return null;
            }
            Object objInvoke2 = a(objInvoke.getClass(), "getCurUserId", new Class[0]).invoke(objInvoke, null);
            if (objInvoke2 instanceof String) {
                String str = (String) objInvoke2;
                if (!m$$ExternalSyntheticBackport0.m(str)) {
                    return str;
                }
            }
            return null;
        }
        return null;
    }

    public static void a(Context context) {
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(AlarmManager.class);
            if (alarmManager == null) {
                return;
            }
            Intent intent = new Intent(context, (Class<?>) n.class);
            intent.setAction("com.windukk.mod.AUTO_STREAK_NUDGE");
            alarmManager.cancel(PendingIntent.getBroadcast(context, 44021, intent, 201326592));
        } catch (Throwable th) {
            th.getMessage();
            ArrayList arrayList = r1.a;
        }
    }

    public static Object a(Class cls, Class cls2, Class cls3, Class cls4, String str) {
        return cls.getConstructor(cls2, cls3, Boolean.TYPE, cls4, Serializable.class, String.class, Class.forName("com.ss.android.ugc.aweme.im.message.template.component.AttachmentComponent"), ReferenceInfo.class, Integer.TYPE).newInstance(Enum.valueOf(cls2, "NO_FREQUENCY_CONTROL"), Enum.valueOf(cls3, "ACTION_BAR"), Boolean.FALSE, null, null, str, null, null, 92);
    }

    public static String a(Object obj, String str) throws IllegalAccessException {
        Object obj2 = a((Class) obj.getClass(), "userStreak").get(obj);
        if (obj2 instanceof List) {
            String str2 = null;
            for (Object obj3 : (List) obj2) {
                String strValueOf = String.valueOf(a((Class) obj3.getClass(), "uid").getLong(obj3));
                if (!TextUtils.isEmpty(strValueOf) && !"0".equals(strValueOf)) {
                    if (str2 == null) {
                        str2 = strValueOf;
                    }
                    if (!strValueOf.equals(str)) {
                        return strValueOf;
                    }
                }
            }
            if (!TextUtils.equals(str2, str)) {
                return str2;
            }
        }
        return null;
    }

    public static boolean a(Object obj) throws IllegalAccessException, InvocationTargetException {
        if (obj == null) {
            return false;
        }
        int i = a((Class) obj.getClass(), "convType").getInt(obj);
        Enum enumValueOf = Enum.valueOf(Class.forName("X.0UPU"), "USER");
        Object objInvoke = a(enumValueOf.getClass(), "getValue", new Class[0]).invoke(enumValueOf, null);
        if (i != (objInvoke instanceof Number ? ((Number) objInvoke).intValue() : 1)) {
            return false;
        }
        return Boolean.TRUE.equals(a(Class.forName("X.0UPW"), "LIZLLL", obj.getClass()).invoke(null, obj));
    }

    public static Field a(Class cls, String str) throws NoSuchFieldException {
        for (Class superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Field declaredField = superclass.getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField;
            } catch (NoSuchFieldException e) {
            }
        }
        throw new NoSuchFieldException(cls.getName() + "#" + str);
    }

    public static Method a(Class cls, String str, Class... clsArr) throws NoSuchMethodException {
        for (Class superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Method declaredMethod = superclass.getDeclaredMethod(str, clsArr);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (NoSuchMethodException e) {
            }
        }
        throw new NoSuchMethodException(cls.getName() + "#" + str);
    }
}
