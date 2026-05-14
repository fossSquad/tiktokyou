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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class m {
    public static final Handler a = new Handler(Looper.getMainLooper());
    public static final AtomicBoolean b = new AtomicBoolean(false);
    public static final AtomicBoolean c = new AtomicBoolean(false);
    public static final h d = new h();

    public static String a(Object obj, String str) throws IllegalAccessException {
        Object obj2 = e4.a(obj.getClass(), "userStreak").get(obj);
        if (obj2 instanceof List) {
            String str2 = null;
            for (Object obj3 : (List) obj2) {
                String strValueOf = String.valueOf(e4.a(obj3.getClass(), "uid").getLong(obj3));
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

    public static  void b(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            c(applicationContext, str);
        }
    }

    public static void c(final Context context, final String str) {
        b(context);
        if (y3.a().k && ZonedDateTime.now().getHour() == 12) {
            String string = LocalDate.now().toString();
            String str2 = y3.a().l;
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

    public static List b() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        Method methodA;
        Object obj = e4.a(Class.forName("X.06hN"), "LIZIZ").get(null);
        if (obj == null) {
            return null;
        }
        Class<?> cls = Class.forName("X.06hZ");
        ArrayList arrayList = new ArrayList(2);
        try {
            arrayList.add(Enum.valueOf(cls, "USER"));
        } catch (IllegalArgumentException e) {
            int i = v3.a;
        }
        try {
            arrayList.add(Enum.valueOf(cls, "CONVERSATION"));
        } catch (IllegalArgumentException e2) {
            int i2 = v3.a;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        Class<?> cls2 = obj.getClass();
        int i3 = 0;
        String[] strArr = {"LIZ", "LJ"};
        Class[] clsArr = {List.class};
        while (true) {
            if (i3 >= 2) {
                methodA = null;
                break;
            }
            try {
                methodA = e4.a(cls2, strArr[i3], clsArr);
                break;
            } catch (NoSuchMethodException e3) {
                i3++;
            }
        }
        if (methodA != null) {
            Object objInvoke = methodA.invoke(obj, arrayList);
            if (objInvoke instanceof List) {
                return (List) objInvoke;
            }
            return null;
        }
        throw new NoSuchMethodException(obj.getClass().getName().concat("#streakList(List)"));
    }

    public static void a(Context context, String str) {
        boolean z;
        boolean zEquals;
        try {
            String strA = a();
            if (TextUtils.isEmpty(strA)) {
                int i = v3.a;
                c.set(false);
                return;
            }
            List listB = b();
            z = listB != null;
            try {
                if (listB == null) {
                    int i2 = v3.a;
                    c.set(false);
                    return;
                }
                HashSet hashSet = new HashSet();
                int i3 = 0;
                int i4 = 0;
                for (Object obj : listB) {
                    try {
                        try {
                            if (!(ZonedDateTime.now().getHour() == 12)) {
                                break;
                            }
                            if (obj == null) {
                                zEquals = false;
                            } else {
                                zEquals = Boolean.TRUE.equals(e4.a(Class.forName("X.06gv"), "LIZLLL", obj.getClass()).invoke(null, obj));
                            }
                            if (zEquals) {
                                Object obj2 = e4.a(obj.getClass(), "convId").get(obj);
                                String str2 = obj2 instanceof String ? (String) obj2 : null;
                                if (!TextUtils.isEmpty(str2)) {
                                    String strA2 = a(obj, strA);
                                    if (!TextUtils.isEmpty(strA2) && hashSet.add(str2)) {
                                        i3++;
                                        if (a(strA2, str2)) {
                                            i4++;
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
                            th.getMessage();
                            int i5 = v3.a;
                        }
                        th.getMessage();
                        int i6 = v3.a;
                    } finally {
                        if (!z) {
                            int i7 = v3.a;
                        }
                        c.set(false);
                    }
                    th = th;
                }
                if (i4 > 0 || i3 == 0) {
                    y3 y3VarA = y3.a();
                    String string = LocalDate.now().toString();
                    y3VarA.getClass();
                    if (string == null) {
                        string = "";
                    }
                    y3VarA.l = string;
                    y3.p.edit().putString("auto_streak_nudge_last_run_date", y3VarA.l).apply();
                }
                int i8 = v3.a;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            z = false;
        }
    }

    public static void c(Context context) {
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
            int i = v3.a;
        }
    }

    public static void b(Context context) {
        if (y3.p == null || y3.a() == null) {
            y3.a(context);
        }
    }

    public static boolean a(String str, String str2) {
        boolean z;
        Method methodA;
        Method methodA2;
        Object objInvoke;
        try {
            Class<?> cls = Class.forName("com.ss.android.ugc.aweme.im.sdk.chat.feature.nudge.IMNudgeAndStreakService");
            Object obj = e4.a(cls, "LJFF").get(null);
            if (obj == null) {
                return false;
            }
            Class<?> cls2 = Class.forName("X.0lkW");
            Object objA = a(cls2, Class.forName("X.0lil"), Class.forName("X.0g9G"), Class.forName("X.0liN"), str);
            Class<?> cls3 = Class.forName("X.0lke");
            Object objNewInstance = cls3.getConstructor(null).newInstance(null);
            Class<?> cls4 = Class.forName("X.0ETb");
            String[] strArr = {"LJJJJI", "LIZJ"};
            Class[] clsArr = new Class[6];
            clsArr[0] = cls2;
            clsArr[1] = Boolean.TYPE;
            clsArr[2] = String.class;
            clsArr[3] = cls3;
            clsArr[4] = cls4;
            z = false;
            try {
                clsArr[5] = String.class;
                int i = 0;
                while (true) {
                    if (i >= 2) {
                        methodA = null;
                        break;
                    }
                    try {
                        methodA = e4.a(cls, strArr[i], clsArr);
                        break;
                    } catch (NoSuchMethodException e) {
                        i++;
                    }
                }
                if (methodA != null) {
                    objInvoke = methodA.invoke(obj, objA, Boolean.FALSE, str2, objNewInstance, null, null);
                } else {
                    String[] strArr2 = {"LJJ", "LJJJJI"};
                    Class[] clsArr2 = {cls2, String.class, cls3, cls4, String.class};
                    int i2 = 0;
                    while (true) {
                        if (i2 >= 2) {
                            methodA2 = null;
                            break;
                        }
                        try {
                            methodA2 = e4.a(cls, strArr2[i2], clsArr2);
                            break;
                        } catch (NoSuchMethodException e2) {
                            i2++;
                        }
                    }
                    if (methodA2 != null) {
                        objInvoke = methodA2.invoke(obj, objA, str2, objNewInstance, null, null);
                    } else {
                        throw new NoSuchMethodException(cls.getName().concat("#sendStreakNudge"));
                    }
                }
                return Boolean.TRUE.equals(objInvoke);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            z = false;
        }
        th.getMessage();
        int i3 = v3.a;
        return z;
    }

    public static String a() throws IllegalAccessException, InvocationTargetException {
        Object objInvoke;
        Object obj = e4.a(Class.forName("X.06Gl"), "LJFF").get(null);
        if (obj == null || (objInvoke = e4.a(obj.getClass(), "LIZ", new Class[0]).invoke(obj, null)) == null) {
            return null;
        }
        if (!Boolean.TRUE.equals(e4.a(objInvoke.getClass(), "isLogin", new Class[0]).invoke(objInvoke, null))) {
            return null;
        }
        Object objInvoke2 = e4.a(objInvoke.getClass(), "getCurUserId", new Class[0]).invoke(objInvoke, null);
        if (objInvoke2 instanceof String) {
            String str = (String) objInvoke2;
            if (!h4$$ExternalSyntheticBackport0.m(str)) {
                return str;
            }
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
            int i = v3.a;
        }
    }

    public static Object a(Class cls, Class cls2, Class cls3, Class cls4, String str) {
        return cls.getConstructor(cls2, cls3, Boolean.TYPE, cls4, Serializable.class, String.class, Class.forName("com.ss.android.ugc.aweme.im.message.template.component.AttachmentComponent"), ReferenceInfo.class, Integer.TYPE).newInstance(Enum.valueOf(cls2, "NO_FREQUENCY_CONTROL"), Enum.valueOf(cls3, "ACTION_BAR"), Boolean.FALSE, null, null, str, null, null, 92);
    }
}
