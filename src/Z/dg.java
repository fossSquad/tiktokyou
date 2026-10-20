package Z;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.windukk.mod.Main;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import ni.shikatu.kotlin.Result;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.internal.Ref;
import ni.shikatu.kotlin.jvm.internal.StringCompanionObject;

public final class dg {
    public static final dg a;
    public static final Handler b;
    public static final AtomicBoolean c;

    static {
        a = new dg();
        b = new Handler(Looper.getMainLooper());
        c = new AtomicBoolean(false);
    }

    public static void a(final int i) {
        b.postDelayed(new Runnable() {
            @Override
            public final void run() {
                dg.b(i);
            }
        }, i == 0 ? 1500L : 1000L);
    }

    public static final void b(int i) {
        ac.a.getClass();
        if (ac.e().H) {
            return;
        }
        Activity activity = (Activity) f3.f.get();
        dg dgVar = a;
        dgVar.getClass();
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            dgVar.a(activity);
        } else if (i < 20) {
            a(i + 1);
        }
    }

    public static final void c(dg dgVar, Activity activity) {
        dgVar.getClass();
        try {
            Result.Companion companion = Result.Companion;
            activity.finishAffinity();
            ResultCompat.constructor(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            ResultCompat.constructor(ResultKt.createFailure(th));
        }
        Process.killProcess(Process.myPid());
    }

    public static final void a() {
        dd.a.getClass();
        dd.a(false, (bd) null);
    }

    public final void a(final Activity activity) {
        Object obj;
        ac.a.getClass();
        if (ac.e().H || !c.compareAndSet(false, true)) {
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            booleanRef.element = true;
            final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
            booleanRef2.element = true;
            final Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = 4;
            final fc fcVarA = new fc(activity).b("ic_startup_logo").b((CharSequence) k7.a("startup_title", "TikTok You")).a((CharSequence) k7.a("startup_subtitle", "Прежде чем продолжить"));
            fcVarA.v = false;
            fcVarA.b.setCancelable(false);
            LinearLayout linearLayoutA = fcVarA.a(12);
            LinearLayout linearLayoutA2 = fcVarA.a(4);
            String strDecrypt = "ic_startup_faq";
            String strA = k7.a("startup_faq", "Ознакомьтесь с нашим FAQ");
            ImageView imageViewA = fcVarA.a(fcVarA.k, "ic_startup_chevron");
            imageViewA.setLayoutParams(new LinearLayout.LayoutParams(Main.dp(20.0f), Main.dp(20.0f)));
            linearLayoutA2.addView(fcVarA.a(strDecrypt, strA, null, imageViewA, new Runnable() {
                @Override
                public final void run() {
                    dg.a(dg.this, activity);
                }
            }));
            String strDecrypt2 = "ic_startup_legal";
            String strA2 = k7.a("privacy_information", "Правовая информация");
            ImageView imageViewA2 = fcVarA.a(fcVarA.k, "ic_startup_chevron");
            imageViewA2.setLayoutParams(new LinearLayout.LayoutParams(Main.dp(20.0f), Main.dp(20.0f)));
            linearLayoutA2.addView(fcVarA.a(strDecrypt2, strA2, null, imageViewA2, new Runnable() {
                @Override
                public final void run() {
                    dg.b(dg.this, activity);
                }
            }));
            linearLayoutA.addView(linearLayoutA2);
            LinearLayout linearLayoutA3 = fcVarA.a(4);
            final ImageView imageViewA3 = fcVarA.a(booleanRef.element);
            final ImageView imageViewA4 = fcVarA.a(booleanRef2.element);
            linearLayoutA3.addView(fcVarA.a("ic_download", k7.a("startup_auto_updates", "Автоматические обновления"), k7.a("startup_auto_updates_desc", "Получать и устанавливать их"), imageViewA3, new Runnable() {
                @Override
                public final void run() {
                    dg.a(booleanRef, fcVarA, imageViewA3);
                }
            }));
            linearLayoutA3.addView(fcVarA.a("ic_startup_stats", k7.a("startup_statistics", "Делиться анонимной статистикой"), k7.a("startup_statistics_desc", "Помогите улучшить приложение"), imageViewA4, new Runnable() {
                @Override
                public final void run() {
                    dg.b(booleanRef2, fcVarA, imageViewA4);
                }
            }));
            linearLayoutA.addView(linearLayoutA3);
            fcVarA.a().addView(fcVarA.a(linearLayoutA, 0.45f));
            TextView textViewA = fcVarA.a("", new Runnable() {
                @Override
                public final void run() {
                    dg.this.a(intRef, dg.this, booleanRef, booleanRef2, fcVarA);
                }
            });
            fcVarA.c(k7.a("startup_close", "Закрыть приложение"), new Runnable() {
                @Override
                public final void run() {
                    dg.c(dg.this, activity);
                }
            });
            a(intRef, textViewA);
            final cg cgVar = new cg(fcVarA, intRef, textViewA);
            fcVarA.b.setCanceledOnTouchOutside(false);
            fcVarA.b.setOnKeyListener(new DialogInterface.OnKeyListener() {
                @Override
                public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    return dg.a(dialogInterface, i, keyEvent);
                }
            });
            fcVarA.x = new Runnable() {
                @Override
                public final void run() {
                    dg.a(cgVar);
                }
            };
            if (fcVarA.g()) {
                b.postDelayed(cgVar, 1000L);
                g7.a(4, g7.a("Shown", new Object[0]), (Throwable) null);
                obj = ResultCompat.constructor(Boolean.TRUE);
                Throwable th = ResultCompat.exceptionOrNull(obj);
                if (th != null) {
                    c.set(false);
                    g7.a(6, g7.a("Show failed", new Object[0]), th);
                }
                Boolean bool = Boolean.FALSE;
                if (ResultCompat.isFailure(obj)) {
                    obj = bool;
                }
                ((Boolean) obj).getClass();
                return;
            }
            throw new IllegalStateException("sheet not shown".toString());
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = ResultCompat.constructor(ResultKt.createFailure(th2));
        }
    }

    public static final void b(dg dgVar, Activity activity) {
        String strDecrypt = "https://tiktokyou.ru/legal.html";
        dgVar.getClass();
        a(activity, strDecrypt);
    }

    public static final void b(Ref.BooleanRef booleanRef, fc fcVar, ImageView imageView) {
        boolean z = !booleanRef.element;
        booleanRef.element = z;
        fcVar.a(imageView, z);
    }

    public static final void a(dg dgVar, Activity activity) {
        String strDecrypt = "https://tiktokyou.ru/knowledge.html";
        dgVar.getClass();
        a(activity, strDecrypt);
    }

    public static final void a(Ref.BooleanRef booleanRef, fc fcVar, ImageView imageView) {
        boolean z = !booleanRef.element;
        booleanRef.element = z;
        fcVar.a(imageView, z);
    }

    public static final void a(Ref.IntRef intRef, dg dgVar, Ref.BooleanRef booleanRef, Ref.BooleanRef booleanRef2, fc fcVar) {
        if (intRef.element > 0) {
            return;
        }
        boolean z = booleanRef.element;
        boolean z2 = booleanRef2.element;
        dgVar.getClass();
        ac.a.getClass();
        ac.e().e(z);
        ac.e().m(z2);
        ac.e().b();
        fcVar.c(new Runnable() {
            @Override
            public final void run() {
                dg.a();
            }
        });
    }

    public static final void a(Ref.IntRef intRef, TextView textView) {
        if (intRef.element > 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(Locale.getDefault(), k7.a("startup_accept_countdown", "Принять через %d..."), Arrays.copyOf(new Object[]{Integer.valueOf(intRef.element)}, 1));
            textView.setText(str);
            fc.a(textView, false);
            return;
        }
        textView.setText(k7.a("startup_accept", "Принимаю"));
        fc.a(textView, true);
    }

    public static final boolean a(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 4) {
            return keyEvent.getAction() == 0 || keyEvent.getAction() == 1;
        }
        return false;
    }

    public static final void a(cg cgVar) {
        b.removeCallbacks(cgVar);
        c.set(false);
    }

    public static void a(Activity activity, String str) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            obj = ResultCompat.constructor(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = ResultCompat.constructor(ResultKt.createFailure(th));
        }
        Throwable th2 = ResultCompat.exceptionOrNull(obj);
        if (th2 != null) {
            g7.a(6, g7.a("Open url failed", new Object[0]), th2);
        }
    }
}
