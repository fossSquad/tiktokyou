package Z;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.windukk.mod.Main;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import ni.shikatu.kotlin.NoWhenBranchMatchedException;
import ni.shikatu.kotlin.Result;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.collections.SetsKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

public final class b0 {
    public static final b0 a;
    public static final Handler b;
    public static final AtomicBoolean c;
    public static final AtomicBoolean d;
    public static final AtomicBoolean e;
    public static final ExecutorService f;
    public static final a0 g;

    static {
        a = new b0();
        b = new Handler(Looper.getMainLooper());
        c = new AtomicBoolean(false);
        d = new AtomicBoolean(false);
        e = new AtomicBoolean(false);
        f = Executors.newSingleThreadExecutor(new ThreadFactory() {
            @Override
            public final Thread newThread(Runnable runnable) {
                return b0.a(runnable);
            }
        });
        g = new a0();
    }

    public static final void a() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(Main.getApplicationContext());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        Context context = (Context) obj;
        if (context == null) {
            g7.a(6, g7.a("Init skipped: context is null", new Object[0]), (Throwable) null);
            return;
        }
        b0 b0Var = a;
        String strDecrypt = "init";
        b0Var.getClass();
        a(context, strDecrypt, 20000L);
    }

    public static final void b() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(Main.getApplicationContext());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        Context context = (Context) obj;
        if (context == null) {
            return;
        }
        b0 b0Var = a;
        String strDecrypt = "settings";
        b0Var.getClass();
        a(context, strDecrypt, 20000L);
    }

    public static final void b(Context context, String str) {
        Object obj;
        try {
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.constructor-impl(Main.getApplicationContext());
            } catch (Throwable th) {
                try {
                    g7.a(6, g7.a("Deferred run failed (" + str + ")", new Object[0]), th);
                    return;
                } finally {
                    d.set(false);
                }
            }
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th2));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        Context context2 = (Context) obj;
        if (context2 != null) {
            context = context2;
        }
        a.getClass();
        a(context, str);
        d.set(false);
    }

    public static final Thread a(Runnable runnable) {
        Thread thread = new Thread(runnable, "auto-streak-nudge");
        thread.setDaemon(true);
        return thread;
    }

    public static final void a(Context context, String str, LocalDate localDate) {
        try {
            a.getClass();
            b(context, str, localDate);
        } finally {
            e.set(false);
        }
    }

    public static void a(long j, long j2) {
        Math.max(1L, SystemClock.elapsedRealtimeNanos() - j);
        Math.max(0L, Debug.threadCpuTimeNanos() - j2);
        Debug.getPss();
    }

    public static void b(final Context context, final String str, long j) {
        if (d.compareAndSet(false, true)) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            b.postDelayed(new Runnable() {
                @Override
                public final void run() {
                    b0.b(context, str);
                }
            }, j);
        }
    }

    public static Set a(Context context, LocalDate localDate) {
        HashSet hashSet;
        SharedPreferences sharedPreferences = context.getSharedPreferences("ttmod_auto_streak_send", 0);
        if (!Intrinsics.areEqual(sharedPreferences.getString("date", ""), localDate.toString())) {
            return SetsKt.emptySet();
        }
        try {
            Set<String> stringSet = sharedPreferences.getStringSet("convs", null);
            return (stringSet == null || (hashSet = CollectionsKt.toHashSet(stringSet)) == null) ? SetsKt.emptySet() : hashSet;
        } catch (Exception e2) {
            return SetsKt.emptySet();
        }
    }

    public static void b(Context context, String str, LocalDate localDate) {
        boolean z;
        String str2;
        Object obj;
        LocalDate localDate2;
        boolean z2;
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        long jThreadCpuTimeNanos = Debug.threadCpuTimeNanos();
        Debug.getPss();
        ?? r7 = 4;
        try {
            l0 l0VarC = z.c();
            if (l0VarC instanceof k0) {
                try {
                    g7.a(4, g7.a("Will retry later: failed to fetch streak data", new Object[0]), (Throwable) null);
                    a(jElapsedRealtimeNanos, jThreadCpuTimeNanos);
                    return;
                } catch (Throwable th) {
                    th = th;
                    str2 = str;
                    z = false;
                }
            } else {
                if (!(l0VarC instanceof j0)) {
                    try {
                        throw new NoWhenBranchMatchedException();
                    } catch (Throwable th2) {
                        th = th2;
                        z = false;
                        str2 = str;
                        g7.a(6, g7.a("Failed (%s)", new Object[]{str2}), th);
                        if (!z) {
                            String strA = g7.a("Will retry later: failed to fetch streak data", new Object[0]);
                        }
                    }
                }
                try {
                    u0.a.getClass();
                    synchronized (u0.c) {
                        try {
                            u0.d = false;
                            u0.e = null;
                            Unit unit = Unit.INSTANCE;
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    }
                    HashSet hashSet = CollectionsKt.toHashSet(a(context, localDate));
                    ArrayList arrayList = ((j0) l0VarC).a;
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj2 = arrayList.get(i);
                        i++;
                        d0 d0Var = (d0) obj2;
                        g0.a.getClass();
                        g0.a(d0Var.c, d0Var.a, false);
                    }
                    g0 g0Var = g0.a;
                    ArrayList arrayList2 = ((j0) l0VarC).a;
                    g0Var.getClass();
                    g0.a((List) arrayList2);
                    ArrayList arrayList3 = ((j0) l0VarC).a;
                    int size2 = arrayList3.size();
                    int i2 = 0;
                    int i3 = 0;
                    int i4 = 0;
                    while (true) {
                        if (i2 >= size2) {
                            l0VarC = l0VarC;
                            break;
                        }
                        i2++;
                        d0 d0Var2 = (d0) arrayList3.get(i2);
                        ZonedDateTime zonedDateTimeNow = ZonedDateTime.now();
                        ac acVar = ac.a;
                        acVar.getClass();
                        arrayList3 = arrayList3;
                        ZonedDateTime zonedDateTimeWithNano = zonedDateTimeNow.withHour(ac.e().u).withMinute(ac.e().v).withSecond(0).withNano(0);
                        size2 = size2;
                        l0VarC = l0VarC;
                        if (!zonedDateTimeNow.isBefore(zonedDateTimeWithNano) && zonedDateTimeNow.isBefore(zonedDateTimeWithNano.plusHours(12L))) {
                            localDate2 = zonedDateTimeWithNano.toLocalDate();
                        } else {
                            ZonedDateTime zonedDateTimeMinusDays = zonedDateTimeWithNano.minusDays(1L);
                            if (zonedDateTimeNow.isBefore(zonedDateTimeMinusDays) || !zonedDateTimeNow.isBefore(zonedDateTimeMinusDays.plusHours(12L))) {
                                localDate2 = null;
                            } else {
                                localDate2 = zonedDateTimeMinusDays.toLocalDate();
                            }
                            if (localDate2 != null) {
                                break;
                            }
                            String str3 = d0Var2.a;
                            acVar.getClass();
                            if (ac.c() && (str3 == null || ac.b().contains(str3))) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                            if (!z2 && hashSet.add(d0Var2.b)) {
                                i3++;
                                u0 u0Var = u0.a;
                                String str4 = d0Var2.a;
                                String str5 = d0Var2.b;
                                u0Var.getClass();
                                if (u0.a(str4, str5)) {
                                    a(context, localDate, hashSet);
                                    i4++;
                                    try {
                                        Thread.sleep(3000L);
                                    } catch (InterruptedException e2) {
                                        Thread.currentThread().interrupt();
                                    }
                                } else {
                                    hashSet.remove(d0Var2.b);
                                }
                            }
                            th = th;
                            r7 = str;
                            z = true;
                            str2 = r7;
                        }
                        if (localDate2 != null) {
                            break;
                            break;
                        }
                        String str6 = d0Var2.a;
                        acVar.getClass();
                        if (ac.c()) {
                            z2 = true;
                        } else {
                            z2 = true;
                        }
                        if (!z2) {
                        }
                        th = th;
                        r7 = str;
                        z = true;
                        str2 = r7;
                    }
                    ArrayList arrayList4 = ((j0) l0VarC).a;
                    ArrayList arrayList5 = new ArrayList();
                    int size3 = arrayList4.size();
                    int i5 = 0;
                    while (i5 < size3) {
                        Object obj3 = arrayList4.get(i5);
                        i5++;
                        ac acVar2 = ac.a;
                        String str7 = ((d0) obj3).a;
                        acVar2.getClass();
                        if (ac.c() || !(str7 == null || ac.b().contains(str7))) {
                            arrayList5.add(obj3);
                        }
                    }
                    Set setA = a(context, localDate);
                    if (!arrayList5.isEmpty() && !arrayList5.isEmpty()) {
                        int size4 = arrayList5.size();
                        int i6 = 0;
                        do {
                            if (i6 >= size4) {
                                ac acVar3 = ac.a;
                                String string = localDate.toString();
                                acVar3.getClass();
                                ac.e().a(string);
                                break;
                            }
                            obj = arrayList5.get(i6);
                            i6++;
                        } while (setA.contains(((d0) obj).b));
                    } else {
                        ac acVar4 = ac.a;
                        String string2 = localDate.toString();
                        acVar4.getClass();
                        ac.e().a(string2);
                        break;
                    }
                    g7.a(4, g7.a("Finished (%s): eligible=%d sent=%d", new Object[]{str, Integer.valueOf(i3), Integer.valueOf(i4)}), (Throwable) null);
                    a(jElapsedRealtimeNanos, jThreadCpuTimeNanos);
                    return;
                } catch (Throwable th4) {
                    th = th4;
                    r7 = str;
                }
            }
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            g7.a(6, g7.a("Failed (%s)", new Object[]{str2}), th);
            if (!z) {
                String strA2 = g7.a("Will retry later: failed to fetch streak data", new Object[0]);
            }
        } finally {
            if (!z) {
                g7.a(4, g7.a("Will retry later: failed to fetch streak data", new Object[0]), (Throwable) null);
            }
            a(jElapsedRealtimeNanos, jThreadCpuTimeNanos);
        }
    }

    public static void a(Context context, LocalDate localDate, HashSet hashSet) {
        context.getSharedPreferences("ttmod_auto_streak_send", 0).edit().putString("date", localDate.toString()).putStringSet("convs", new HashSet(hashSet)).apply();
    }

    public static void a(Context context, String str, long j) {
        if (ac.b == null) {
            Context applicationContext = context.getApplicationContext();
            ac.a(applicationContext);
        }
        ac.a.getClass();
        if (!ac.e().t) {
            a(context);
            c.set(false);
            b.removeCallbacks(g);
            return;
        }
        b(context);
        if (c.compareAndSet(false, true)) {
            Handler handler = b;
            a0 a0Var = g;
            handler.removeCallbacks(a0Var);
            handler.postDelayed(a0Var, 300000L);
        }
        b(context, str, j);
    }

    public static void a(final Context context, final String str) {
        LocalDate localDate;
        if (ac.b == null) {
            Context applicationContext = context.getApplicationContext();
            ac.a(applicationContext);
        }
        ac acVar = ac.a;
        acVar.getClass();
        if (ac.e().t) {
            ZonedDateTime zonedDateTimeNow = ZonedDateTime.now();
            acVar.getClass();
            ZonedDateTime zonedDateTimeWithNano = zonedDateTimeNow.withHour(ac.e().u).withMinute(ac.e().v).withSecond(0).withNano(0);
            final LocalDate localDate2 = null;
            if (!zonedDateTimeNow.isBefore(zonedDateTimeWithNano) && zonedDateTimeNow.isBefore(zonedDateTimeWithNano.plusHours(12L))) {
                localDate = zonedDateTimeWithNano.toLocalDate();
            } else {
                ZonedDateTime zonedDateTimeMinusDays = zonedDateTimeWithNano.minusDays(1L);
                localDate = (zonedDateTimeNow.isBefore(zonedDateTimeMinusDays) || !zonedDateTimeNow.isBefore(zonedDateTimeMinusDays.plusHours(12L))) ? null : zonedDateTimeMinusDays.toLocalDate();
            }
            if (localDate != null) {
                String string = localDate.toString();
                acVar.getClass();
                String str2 = ac.e().w;
                if (str2 == null) {
                    str2 = "";
                }
                if (!Intrinsics.areEqual(string, str2)) {
                    localDate2 = localDate;
                }
            }
            if (localDate2 != null && e.compareAndSet(false, true)) {
                f.execute(new Runnable() {
                    @Override
                    public final void run() {
                        b0.a(context, str, localDate2);
                    }
                });
            }
        }
    }

    public static void a(Context context) {
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(AlarmManager.class);
            if (alarmManager == null) {
                return;
            }
            alarmManager.cancel(a(context, "com.windukk.mod.AUTO_STREAK_NUDGE", 44021));
            alarmManager.cancel(a(context, "com.windukk.mod.AUTO_STREAK_NUDGE_BACKUP", 44022));
        } catch (Throwable th) {
            g7.a(6, g7.a("Cancel failed", new Object[0]), th);
        }
    }

    public static PendingIntent a(Context context, String str, int i) {
        Intent action = new Intent(context, (Class<?>) c0.class).setAction(str);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, i, action, 201326592);
        return broadcast;
    }

    public static void b(Context context) {
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(AlarmManager.class);
            if (alarmManager == null) {
                return;
            }
            ZonedDateTime zonedDateTimeNow = ZonedDateTime.now();
            ac.a.getClass();
            int i = ac.e().u;
            ZonedDateTime zonedDateTimeWithNano = zonedDateTimeNow.withHour(i).withMinute(ac.e().v).withSecond(0).withNano(0);
            if (!zonedDateTimeNow.isBefore(zonedDateTimeWithNano)) {
                zonedDateTimeWithNano = zonedDateTimeWithNano.plusDays(1L);
            }
            long epochMilli = zonedDateTimeWithNano.toInstant().toEpochMilli();
            try {
                alarmManager.setExactAndAllowWhileIdle(0, epochMilli, a(context, "com.windukk.mod.AUTO_STREAK_NUDGE", 44021));
            } catch (SecurityException e2) {
            }
            alarmManager.setAndAllowWhileIdle(0, epochMilli, a(context, "com.windukk.mod.AUTO_STREAK_NUDGE_BACKUP", 44022));
        } catch (Throwable th) {
            g7.a(6, g7.a("Schedule failed", new Object[0]), th);
        }
    }
}
