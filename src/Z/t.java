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

public final class t {
    public static final t a;
    public static final Handler b;
    public static final AtomicBoolean c;
    public static final AtomicBoolean d;
    public static final AtomicBoolean e;
    public static final ExecutorService f;
    public static final s g;

    static {
        a = new t();
        b = new Handler(Looper.getMainLooper());
        c = new AtomicBoolean(false);
        d = new AtomicBoolean(false);
        e = new AtomicBoolean(false);
        f = Executors.newSingleThreadExecutor(new ThreadFactory() {
            @Override
            public final Thread newThread(Runnable runnable) {
                return t.a(runnable);
            }
        });
        g = new s();
    }

    public static final void a() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = RCompat.m6constructorimpl(Main.getApplicationContext());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = RCompat.m6constructorimpl(ResultKt.createFailure(th));
        }
        if (RCompat.m12isFailureimpl(obj)) {
            obj = null;
        }
        Context context = (Context) obj;
        if (context == null) {
            h6.a(6, h6.a("Init skipped: context is null", new Object[0]), (Throwable) null);
            return;
        }
        t tVar = a;
        String strDecrypt = "init";
        tVar.getClass();
        a(context, strDecrypt, 20000L);
    }

    public static final void b() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = RCompat.m6constructorimpl(Main.getApplicationContext());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = RCompat.m6constructorimpl(ResultKt.createFailure(th));
        }
        if (RCompat.m12isFailureimpl(obj)) {
            obj = null;
        }
        Context context = (Context) obj;
        if (context == null) {
            return;
        }
        t tVar = a;
        String strDecrypt = "settings";
        tVar.getClass();
        a(context, strDecrypt, 20000L);
    }

    public static final void b(Context context, String str) {
        Object obj;
        try {
            try {
                Result.Companion companion = Result.Companion;
                obj = RCompat.m6constructorimpl(Main.getApplicationContext());
            } catch (Throwable th) {
                try {
                    h6.a(6, h6.a("Deferred run failed (" + str + ")", new Object[0]), th);
                    return;
                } finally {
                    d.set(false);
                }
            }
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = RCompat.m6constructorimpl(ResultKt.createFailure(th2));
        }
        if (RCompat.m12isFailureimpl(obj)) {
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

    public static void b(Context context, final String str, long j) {
        if (d.compareAndSet(false, true)) {
            Context applicationContext = context.getApplicationContext();
            final Context ctxF = applicationContext != null ? applicationContext : context;
            b.postDelayed(new Runnable() {
                @Override
                public final void run() {
                    t.b(ctxF, str);
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
        Throwable th = null;
        boolean z = false;
        String str2 = null;
        Object obj;
        boolean z2 = false;
        LocalDate localDate2;
        SharedPreferences sharedPreferences;
        boolean z3;
        boolean z4;
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        long jThreadCpuTimeNanos = Debug.threadCpuTimeNanos();
        Debug.getPss();
        String r7 = null;
        boolean z5 = false;
        try {
            c0 c0VarC = r.c();
            if (c0VarC instanceof b0) {
                try {
                    h6.a(4, h6.a("Will retry later: failed to fetch streak data", new Object[0]), (Throwable) null);
                    a(jElapsedRealtimeNanos, jThreadCpuTimeNanos);
                    return;
                } catch (Throwable th_2) {
                    th = th_2;
                    str2 = str;
                    z = false;
                }
            } else {
                if (!(c0VarC instanceof a0)) {
                    try {
                        throw new NoWhenBranchMatchedException();
                    } catch (Throwable th2) {
                        th = th2;
                        z = false;
                        str2 = str;
                        h6.a(6, h6.a("Failed (%s)", new Object[]{str2}), th);
                        if (!z) {
                            String strA = h6.a("Will retry later: failed to fetch streak data", new Object[0]);
                        }
                    }
                }
                try {
                    k0.a.getClass();
                    synchronized (k0.c) {
                        try {
                            try {
                                k0.d = false;
                                k0.e = null;
                                Unit unit = Unit.INSTANCE;
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        } catch (Throwable th4) {
                            throw th4;
                        }
                    }
                    HashSet hashSet = CollectionsKt.toHashSet(a(context, localDate));
                    ArrayList arrayList = ((a0) c0VarC).a;
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        try {
                            Object obj2 = arrayList.get(i);
                            i++;
                            v vVar = (v) obj2;
                            y.a.getClass();
                            y.a(vVar.c, vVar.a, false);
                        } catch (Throwable th5) {
                            th = th5;
                            str2 = str;
                            z = true;
                        }
                    }
                    ArrayList arrayList2 = ((a0) c0VarC).a;
                    int size2 = arrayList2.size();
                    int i2 = 0;
                    int i3 = 0;
                    int i4 = 0;
                    while (true) {
                        if (i2 >= size2) {
                            c0VarC = c0VarC;
                            break;
                        }
                        i2++;
                        v vVar2 = (v) arrayList2.get(i2);
                        ZonedDateTime zonedDateTimeNow = ZonedDateTime.now();
                        ta taVar = ta.a;
                        taVar.getClass();
                        arrayList2 = arrayList2;
                        ZonedDateTime zonedDateTimeWithNano = zonedDateTimeNow.withHour(ta.d().p).withMinute(ta.d().q).withSecond(0).withNano(0);
                        size2 = size2;
                        c0VarC = c0VarC;
                        if (zonedDateTimeNow.isBefore(zonedDateTimeWithNano) || !zonedDateTimeNow.isBefore(zonedDateTimeWithNano.plusHours(12L))) {
                            ZonedDateTime zonedDateTimeMinusDays = zonedDateTimeWithNano.minusDays(1L);
                            if (zonedDateTimeNow.isBefore(zonedDateTimeMinusDays) || !zonedDateTimeNow.isBefore(zonedDateTimeMinusDays.plusHours(12L))) {
                                localDate2 = null;
                            } else {
                                localDate2 = zonedDateTimeMinusDays.toLocalDate();
                            }
                            if (localDate2 != null) {
                                break;
                            }
                            String str3 = vVar2.a;
                            taVar.getClass();
                            sharedPreferences = ta.b;
                            if (sharedPreferences != null) {
                                z3 = sharedPreferences.getBoolean("auto_streak_recipients_all", true);
                            } else {
                                z3 = true;
                            }
                            if (z3 && (str3 == null || ta.b().contains(str3))) {
                                z4 = false;
                            } else {
                                z4 = true;
                            }
                            if (!z4 && hashSet.add(vVar2.b)) {
                                i3++;
                                k0 k0Var = k0.a;
                                String str4 = vVar2.a;
                                String str5 = vVar2.b;
                                k0Var.getClass();
                                if (k0.a(str4, str5)) {
                                    a(context, localDate, hashSet);
                                    i4++;
                                    try {
                                        Thread.sleep(3000L);
                                    } catch (InterruptedException e2) {
                                        Thread.currentThread().interrupt();
                                    }
                                } else {
                                    hashSet.remove(vVar2.b);
                                }
                            }
                        } else {
                            localDate2 = zonedDateTimeWithNano.toLocalDate();
                        }
                        if (localDate2 != null) {
                            break;
                        }
                        String str6 = vVar2.a;
                        taVar.getClass();
                        sharedPreferences = ta.b;
                        if (sharedPreferences != null) {
                            z3 = sharedPreferences.getBoolean("auto_streak_recipients_all", true);
                        } else {
                            z3 = true;
                        }
                        if (z3) {
                            z4 = true;
                        } else {
                            z4 = true;
                        }
                        if (!z4) {
                        }
                    }
                    ArrayList arrayList3 = ((a0) c0VarC).a;
                    ArrayList arrayList4 = new ArrayList();
                    int i5 = 0;
                    for (int size3 = arrayList3.size(); i5 < size3; size3 = size3) {
                        try {
                            Object obj3 = arrayList3.get(i5);
                            i5++;
                            ta taVar2 = ta.a;
                            String str7 = ((v) obj3).a;
                            taVar2.getClass();
                            SharedPreferences sharedPreferences2 = ta.b;
                            if (sharedPreferences2 != null) {
                                z5 = true;
                                try {
                                    z2 = sharedPreferences2.getBoolean("auto_streak_recipients_all", true);
                                } catch (Throwable th6) {
                                    th = th6;
                                    r7 = str;
                                    z = z5;
                                    str2 = r7;
                                    h6.a(6, h6.a("Failed (%s)", new Object[]{str2}), th);
                                    if (!z) {
                                        String strA2 = h6.a("Will retry later: failed to fetch streak data", new Object[0]);
                                    }
                                }
                            } else {
                                z5 = true;
                                z2 = true;
                            }
                            if ((z2 || !(str7 == null || ta.b().contains(str7))) ? z5 : false) {
                                arrayList4.add(obj3);
                            }
                            arrayList3 = arrayList3;
                        } catch (Throwable th7) {
                            th = th7;
                            z5 = true;
                            r7 = str;
                            z = z5;
                            str2 = r7;
                            h6.a(6, h6.a("Failed (%s)", new Object[]{str2}), th);
                            if (!z) {
                                String strA3 = h6.a("Will retry later: failed to fetch streak data", new Object[0]);
                            }
                        }
                    }
                    z5 = true;
                    Set setA = a(context, localDate);
                    tBreak: {
                    if (arrayList4.isEmpty() || arrayList4.isEmpty()) {
                        ta taVar3 = ta.a;
                        String string = localDate.toString();
                        taVar3.getClass();
                        ta.d().a(string);
                        break tBreak;
                    }
                    }
                    int size4 = arrayList4.size();
                    int i6 = 0;
                    do {
                        if (i6 >= size4) {
                            ta taVar4 = ta.a;
                            String string2 = localDate.toString();
                            taVar4.getClass();
                            ta.d().a(string2);
                            break;
                        }
                        obj = arrayList4.get(i6);
                        i6++;
                    } while (setA.contains(((v) obj).b));
                    h6.a(4, h6.a("Finished (%s): eligible=%d sent=%d", new Object[]{str, Integer.valueOf(i3), Integer.valueOf(i4)}), (Throwable) null);
                    a(jElapsedRealtimeNanos, jThreadCpuTimeNanos);
                    return;
                } catch (Throwable th8) {
                    th = th8;
                    r7 = str;
                    z5 = true;
                }
            }
        } catch (Throwable th9) {
            th = th9;
        }
        try {
            h6.a(6, h6.a("Failed (%s)", new Object[]{str2}), th);
            if (!z) {
                String strA4 = h6.a("Will retry later: failed to fetch streak data", new Object[0]);
            }
        } finally {
            if (!z) {
                h6.a(4, h6.a("Will retry later: failed to fetch streak data", new Object[0]), (Throwable) null);
            }
            a(jElapsedRealtimeNanos, jThreadCpuTimeNanos);
        }
    }

    public static void a(Context context, LocalDate localDate, HashSet hashSet) {
        context.getSharedPreferences("ttmod_auto_streak_send", 0).edit().putString("date", localDate.toString()).putStringSet("convs", new HashSet(hashSet)).apply();
    }

    public static void a(Context context, String str, long j) {
        if (ta.b == null) {
            Context applicationContext = context.getApplicationContext();
            ta.a(applicationContext);
        }
        ta.a.getClass();
        if (!ta.d().o) {
            a(context);
            c.set(false);
            b.removeCallbacks(g);
            return;
        }
        b(context);
        if (c.compareAndSet(false, true)) {
            Handler handler = b;
            s sVar = g;
            handler.removeCallbacks(sVar);
            handler.postDelayed(sVar, 300000L);
        }
        b(context, str, j);
    }

    public static void a(final Context context, final String str) {
        LocalDate localDate;
        if (ta.b == null) {
            Context applicationContext = context.getApplicationContext();
            ta.a(applicationContext);
        }
        ta taVar = ta.a;
        taVar.getClass();
        if (ta.d().o) {
            ZonedDateTime zonedDateTimeNow = ZonedDateTime.now();
            taVar.getClass();
            ZonedDateTime zonedDateTimeWithNano = zonedDateTimeNow.withHour(ta.d().p).withMinute(ta.d().q).withSecond(0).withNano(0);
            LocalDate localDate2 = null;
            if (!zonedDateTimeNow.isBefore(zonedDateTimeWithNano) && zonedDateTimeNow.isBefore(zonedDateTimeWithNano.plusHours(12L))) {
                localDate = zonedDateTimeWithNano.toLocalDate();
            } else {
                ZonedDateTime zonedDateTimeMinusDays = zonedDateTimeWithNano.minusDays(1L);
                localDate = (zonedDateTimeNow.isBefore(zonedDateTimeMinusDays) || !zonedDateTimeNow.isBefore(zonedDateTimeMinusDays.plusHours(12L))) ? null : zonedDateTimeMinusDays.toLocalDate();
            }
            if (localDate != null) {
                String string = localDate.toString();
                taVar.getClass();
                String str2 = ta.d().r;
                if (str2 == null) {
                    str2 = "";
                }
                if (!Intrinsics.areEqual(string, str2)) {
                    localDate2 = localDate;
                }
            }
            if (localDate2 != null && e.compareAndSet(false, true)) {
                final LocalDate localDate2F = localDate2;
            f.execute(new Runnable() {
                    @Override
                    public final void run() {
                        t.a(context, str, localDate2F);
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
            h6.a(6, h6.a("Cancel failed", new Object[0]), th);
        }
    }

    public static PendingIntent a(Context context, String str, int i) {
        Intent action = new Intent(context, (Class<?>) u.class).setAction(str);
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
            ta.a.getClass();
            int i = ta.d().p;
            ZonedDateTime zonedDateTimeWithNano = zonedDateTimeNow.withHour(i).withMinute(ta.d().q).withSecond(0).withNano(0);
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
            h6.a(6, h6.a("Schedule failed", new Object[0]), th);
        }
    }
}
