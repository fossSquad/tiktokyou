package X;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class y {
    public static final Handler a = new Handler(Looper.getMainLooper());
    public static final AtomicBoolean b = new AtomicBoolean(false);
    public static final AtomicBoolean c = new AtomicBoolean(false);
    public static final AtomicBoolean d = new AtomicBoolean(false);
    public static final x e = new x();

    public static  void a(Context context, String str) {
        try {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                b(applicationContext, str);
            }
        } finally {
            c.set(false);
        }
    }

    public static void b(final Context context, final String str) {
        LocalDate localDate;
        b(context);
        if (d7.a().m) {
            ZonedDateTime zonedDateTimeNow = ZonedDateTime.now();
            d7 d7VarA = d7.a();
            ZonedDateTime zonedDateTimeWithNano = zonedDateTimeNow.withHour(d7VarA != null ? d7VarA.n : 12).withMinute(d7VarA != null ? d7VarA.o : 0).withSecond(0).withNano(0);
            final LocalDate localDate2 = null;
            if (zonedDateTimeNow.isBefore(zonedDateTimeWithNano) || !zonedDateTimeNow.isBefore(zonedDateTimeWithNano.plusHours(12L))) {
                ZonedDateTime zonedDateTimeMinusDays = zonedDateTimeWithNano.minusDays(1L);
                localDate = (zonedDateTimeNow.isBefore(zonedDateTimeMinusDays) || !zonedDateTimeNow.isBefore(zonedDateTimeMinusDays.plusHours(12L))) ? null : zonedDateTimeMinusDays.toLocalDate();
            } else {
                localDate = zonedDateTimeWithNano.toLocalDate();
            }
            if (localDate != null) {
                String str2 = d7.a().p;
                if (str2 == null) {
                    str2 = "";
                }
                if (!localDate.toString().equals(str2)) {
                    localDate2 = localDate;
                }
            }
            if (localDate2 != null && d.compareAndSet(false, true)) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public final void run() {
                        y.a(context, str, localDate2);
                    }
                }, "auto-streak-nudge");
                thread.setDaemon(true);
                thread.start();
            }
        }
    }

    public static void c(final Context context, final String str) {
        if (c.compareAndSet(false, true)) {
            a.postDelayed(new Runnable() {
                @Override
                public final void run() {
                    y.a(context, str);
                }
            }, 20000L);
        }
    }

    public static void c(Context context) {
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(AlarmManager.class);
            if (alarmManager == null) {
                return;
            }
            ZonedDateTime zonedDateTimeNow = ZonedDateTime.now();
            d7 d7VarA = d7.a();
            ZonedDateTime zonedDateTimeWithNano = zonedDateTimeNow.withHour(d7VarA != null ? d7VarA.n : 12).withMinute(d7VarA != null ? d7VarA.o : 0).withSecond(0).withNano(0);
            if (!zonedDateTimeNow.isBefore(zonedDateTimeWithNano)) {
                zonedDateTimeWithNano = zonedDateTimeWithNano.plusDays(1L);
            }
            long epochMilli = zonedDateTimeWithNano.toInstant().toEpochMilli();
            Intent intent = new Intent(context, (Class<?>) z.class);
            intent.setAction("com.windukk.mod.AUTO_STREAK_NUDGE");
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 44021, intent, 201326592);
            Intent intent2 = new Intent(context, (Class<?>) z.class);
            intent2.setAction("com.windukk.mod.AUTO_STREAK_NUDGE_BACKUP");
            PendingIntent broadcast2 = PendingIntent.getBroadcast(context, 44022, intent2, 201326592);
            try {
                alarmManager.setExactAndAllowWhileIdle(0, epochMilli, broadcast);
            } catch (SecurityException e2) {
            }
            alarmManager.setAndAllowWhileIdle(0, epochMilli, broadcast2);
        } catch (Throwable th) {
            th.getMessage();
            int i = p4.a;
        }
    }

    public static void a(Context context, String str, LocalDate localDate) {
        boolean z;
        String str2;
        LocalDate localDate2;
        boolean zEquals;
        ?? r1;
        String str3;
        String str4;
        String strA;
        int i;
        int i2 = 0;
        try {
            String strA2 = a();
            if (TextUtils.isEmpty(strA2)) {
                int i3 = p4.a;
                d.set(false);
                return;
            }
            List listB = b();
            z = listB != null;
            try {
                if (listB == null) {
                    int i4 = p4.a;
                    d.set(false);
                    return;
                }
                HashSet hashSet = new HashSet();
                Iterator it = listB.iterator();
                int i5 = 0;
                int i6 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i2 = i2;
                        break;
                    }
                    Object next = it.next();
                    try {
                        ZonedDateTime zonedDateTimeNow = ZonedDateTime.now();
                        d7 d7VarA = d7.a();
                        ZonedDateTime zonedDateTimeWithNano = zonedDateTimeNow.withHour(d7VarA != null ? d7VarA.n : 12).withMinute(d7VarA != null ? d7VarA.o : i2).withSecond(i2).withNano(i2);
                        if (zonedDateTimeNow.isBefore(zonedDateTimeWithNano) || !zonedDateTimeNow.isBefore(zonedDateTimeWithNano.plusHours(12L))) {
                            i2 = i2;
                            str2 = strA2;
                            ZonedDateTime zonedDateTimeMinusDays = zonedDateTimeWithNano.minusDays(1L);
                            if (zonedDateTimeNow.isBefore(zonedDateTimeMinusDays) || !zonedDateTimeNow.isBefore(zonedDateTimeMinusDays.plusHours(12L))) {
                                localDate2 = null;
                            } else {
                                localDate2 = zonedDateTimeMinusDays.toLocalDate();
                            }
                            if (localDate2 != null) {
                                break;
                            }
                            if (next == null) {
                                r1 = i2;
                            } else {
                                x5 x5Var = s6.a;
                                Class<?> cls = Class.forName("X.05kA");
                                Class[] clsArr = new Class[1];
                                clsArr[i2] = next.getClass();
                                zEquals = Boolean.TRUE.equals(x5Var.a(cls, clsArr).invoke(null, next));
                            }
                            if (r1 == 0) {
                                r1 = zEquals;
                                str3 = str2;
                            } else {
                                r1 = zEquals;
                                try {
                                    Object obj = g8.a((Class) next.getClass(), "convId").get(next);
                                    str4 = obj instanceof String ? (String) obj : null;
                                    if (TextUtils.isEmpty(str4)) {
                                        str3 = str2;
                                    } else {
                                        str3 = str2;
                                        strA = a(next, str3);
                                        if (!TextUtils.isEmpty(strA) && hashSet.add(str4)) {
                                            i = i5 + 1;
                                            if (a(strA, str4)) {
                                                i6++;
                                                try {
                                                    Thread.sleep(3000L);
                                                } catch (InterruptedException e2) {
                                                    Thread.currentThread().interrupt();
                                                }
                                                strA2 = str3;
                                                i5 = i;
                                            } else {
                                                strA2 = str3;
                                                i5 = i;
                                            }
                                        }
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    try {
                                        th.getMessage();
                                        int i7 = p4.a;
                                        d.set(i2);
                                    } catch (Throwable th2) {
                                        if (!z) {
                                            int i8 = p4.a;
                                        }
                                        d.set(false);
                                        throw th2;
                                    }
                                }
                            }
                            strA2 = str3;
                        } else {
                            localDate2 = zonedDateTimeWithNano.toLocalDate();
                            i2 = i2;
                            str2 = strA2;
                        }
                        if (localDate2 != null) {
                            break;
                            break;
                        }
                        if (next == null) {
                            r1 = i2;
                        } else {
                            x5 x5Var2 = s6.a;
                            Class<?> cls2 = Class.forName("X.05kA");
                            Class[] clsArr2 = new Class[1];
                            clsArr2[i2] = next.getClass();
                            zEquals = Boolean.TRUE.equals(x5Var2.a(cls2, clsArr2).invoke(null, next));
                        }
                        if (r1 == 0) {
                            r1 = zEquals;
                            str3 = str2;
                        } else {
                            r1 = zEquals;
                            Object obj2 = g8.a((Class) next.getClass(), "convId").get(next);
                            if (obj2 instanceof String) {
                            }
                            if (TextUtils.isEmpty(str4)) {
                                str3 = str2;
                            } else {
                                str3 = str2;
                                strA = a(next, str3);
                                if (!TextUtils.isEmpty(strA)) {
                                    i = i5 + 1;
                                    if (a(strA, str4)) {
                                        i6++;
                                        Thread.sleep(3000L);
                                        strA2 = str3;
                                        i5 = i;
                                    } else {
                                        strA2 = str3;
                                        i5 = i;
                                    }
                                }
                            }
                        }
                        strA2 = str3;
                    } catch (Throwable th3) {
                        th = th3;
                        i2 = i2;
                        th.getMessage();
                        int i9 = p4.a;
                    }
                }
                if (i6 > 0 || i5 == 0) {
                    d7 d7VarA2 = d7.a();
                    String string = localDate.toString();
                    d7VarA2.getClass();
                    if (string == null) {
                        string = "";
                    }
                    d7VarA2.p = string;
                    d7.u.edit().putString("auto_streak_nudge_last_run_date", d7VarA2.p).apply();
                }
                int i10 = p4.a;
                d.set(i2);
            } catch (Throwable th4) {
                th = th4;
                i2 = 0;
            }
        } catch (Throwable th5) {
            th = th5;
            i2 = 0;
            z = false;
        }
    }

    public static List b() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, InvocationTargetException {
        p5 p5Var = r6.a;
        Field fieldA = r6.a.a(Class.forName("X.05kH"));
        fieldA.setAccessible(true);
        Object obj = fieldA.get(null);
        if (obj == null) {
            return null;
        }
        Class<?> cls = Class.forName("X.05kU");
        ArrayList arrayList = new ArrayList(2);
        try {
            arrayList.add(Enum.valueOf(cls, "USER"));
        } catch (IllegalArgumentException e2) {
            int i = p4.a;
        }
        try {
            arrayList.add(Enum.valueOf(cls, "CONVERSATION"));
        } catch (IllegalArgumentException e3) {
            int i2 = p4.a;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        Object objInvoke = q6.a.a(obj.getClass(), List.class).invoke(obj, arrayList);
        if (!(objInvoke instanceof List)) {
            return null;
        }
        return (List) objInvoke;
    }

    public static void b(Context context) {
        if (d7.u == null || d7.a() == null) {
            d7.a(context);
        }
    }

    public static String a(Object obj, String str) throws IllegalAccessException {
        Object obj2 = g8.a((Class) obj.getClass(), "userStreak").get(obj);
        if (obj2 instanceof List) {
            String str2 = null;
            for (Object obj3 : (List) obj2) {
                String strValueOf = String.valueOf(g8.a((Class) obj3.getClass(), "uid").getLong(obj3));
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

    public static boolean a(String str, String str2) {
        Object objNewInstance;
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            Class<?> cls = Class.forName("com.ss.android.ugc.aweme.im.lightinteract.impl.serviceimpl.LightInteractionManager");
            Class<?> superclass = cls;
            loop0: while (true) {
                if (superclass == null) {
                    objNewInstance = null;
                    break;
                }
                for (Field field : superclass.getDeclaredFields()) {
                    if (Modifier.isStatic(field.getModifiers()) && cls.isAssignableFrom(field.getType())) {
                        field.setAccessible(true);
                        objNewInstance = field.get(null);
                        if (cls.isInstance(objNewInstance)) {
                            break loop0;
                        }
                    }
                }
                superclass = superclass.getSuperclass();
            }
            if (objNewInstance == null) {
                Constructor<?> declaredConstructor = cls.getDeclaredConstructor(null);
                declaredConstructor.setAccessible(true);
                objNewInstance = declaredConstructor.newInstance(null);
            }
            if (objNewInstance == null) {
                return false;
            }
            HashMap map = new HashMap();
            map.put("enter_from", "streak_inbox");
            map.put("enter_method", "auto_streak");
            g8.b(cls, String.class, String.class, String.class, Map.class, Map.class).invoke(objNewInstance, "spark_v1", str2, str, map, null, null, null, null, null, null, null);
            return true;
        } catch (Throwable th) {
            th.getMessage();
            int i = p4.a;
            return false;
        }
    }

    public static String a() throws IllegalAccessException, NoSuchFieldException, InvocationTargetException {
        Object objInvoke;
        p5 p5Var = t5.a;
        Field fieldA = t5.a.a(Class.forName("X.0mA4"));
        fieldA.setAccessible(true);
        Object obj = fieldA.get(null);
        if (obj == null || (objInvoke = t5.b.a(obj.getClass(), new Class[0]).invoke(obj, null)) == null || !Boolean.TRUE.equals(g8.a(objInvoke.getClass(), "isLogin", new Class[0]).invoke(objInvoke, null))) {
            return null;
        }
        Object objInvoke2 = g8.a(objInvoke.getClass(), "getCurUserId", new Class[0]).invoke(objInvoke, null);
        if (objInvoke2 instanceof String) {
            String str = (String) objInvoke2;
            if (!a1$$ExternalSyntheticBackport0.m(str)) {
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
            Intent intent = new Intent(context, (Class<?>) z.class);
            intent.setAction("com.windukk.mod.AUTO_STREAK_NUDGE");
            alarmManager.cancel(PendingIntent.getBroadcast(context, 44021, intent, 201326592));
            Intent intent2 = new Intent(context, (Class<?>) z.class);
            intent2.setAction("com.windukk.mod.AUTO_STREAK_NUDGE_BACKUP");
            alarmManager.cancel(PendingIntent.getBroadcast(context, 44022, intent2, 201326592));
        } catch (Throwable th) {
            th.getMessage();
            int i = p4.a;
        }
    }
}
