package Z;

import android.content.Context;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.bytedance.ies.foundation.activity.BaseActivity;
import java.io.File;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public final class og {
    public static final AtomicBoolean b = new AtomicBoolean(false);
    public static final AtomicBoolean c = new AtomicBoolean(false);
    public final sf a;

    public og(sf sfVar) {
        this.a = sfVar;
    }

    public final  void a(fc fcVar) {
        fcVar.c(new Runnable() {
            @Override
            public final void run() {
                og.this.e();
            }
        });
    }

    public final  void b(fc fcVar) {
        fcVar.c(new Runnable() {
            @Override
            public final void run() {
                og.this.f();
            }
        });
    }

    public final  void c(fc fcVar) {
        fcVar.c(new Runnable() {
            @Override
            public final void run() {
                og.this.b();
            }
        });
    }

    public final  void d(fc fcVar) {
        fcVar.c(new Runnable() {
            @Override
            public final void run() {
                og.this.a();
            }
        });
    }

    public final void e() {
        String str;
        String str2;
        boolean zA = v1.a(this.a.getApplicationContext(), true, new u1() {
            @Override
            public final void a(boolean z, int i, String str3) {
                og.this.a(z, i, str3);
            }
        });
        BaseActivity baseActivity = this.a;
        Toast.makeText((Context) baseActivity, (CharSequence) (zA ? "Support list refresh started" : "Support list refresh already running"), 0).show();
    }

    public final void f() {
        int i;
        Context applicationContext = this.a.getApplicationContext();
        String[] strArr = v1.a;
        if (applicationContext == null) {
            i = 0;
        } else {
            char[] cArr = x0.a;
            File file = new File(x0.a(applicationContext), "supporters_cache.txt");
            i = (file.exists() && file.delete()) ? 1 : 0;
            File file2 = new File(x0.a(applicationContext), "supporters_fetch.stamp");
            if (file2.exists() && file2.delete()) {
                i++;
            }
            File file3 = new File(x0.a(applicationContext), "supporters_cache.etag");
            if (file3.exists() && file3.delete()) {
                i++;
            }
            v1.p.set(false);
        }
        Toast.makeText((Context) this.a, (CharSequence) ("Support list cache cleaned: " + i), 0).show();
    }

    public final void g() {
        final fc fcVarA = new fc(this.a).b((CharSequence) "DEBUG").a((CharSequence) "Developer tools");
        LinearLayout linearLayoutA = fcVarA.a(4);
        linearLayoutA.addView(fcVarA.a("ic_refresh", "Force refresh support list", null, null, new Runnable() {
            @Override
            public final void run() {
                og.this.a(fcVarA);
            }
        }));
        linearLayoutA.addView(fcVarA.a("ic_refresh", "Clean support list cache", null, null, new Runnable() {
            @Override
            public final void run() {
                og.this.b(fcVarA);
            }
        }));
        linearLayoutA.addView(fcVarA.a("ic_document", "Export logs (.zip)", null, null, new Runnable() {
            @Override
            public final void run() {
                og.this.c(fcVarA);
            }
        }));
        linearLayoutA.addView(fcVarA.a("ic_document", "Export heap dump (.hprof)", null, null, new Runnable() {
            @Override
            public final void run() {
                og.this.d(fcVarA);
            }
        }));
        fcVarA.a().addView(linearLayoutA);
        fcVarA.d(k7.a("ui_hide_close"), null);
        fcVarA.g();
    }

    public final  void a(boolean z, int i, String str) {
        String string;
        BaseActivity baseActivity = this.a;
        if (z) {
            string = "Support list refreshed: " + i;
        } else {
            StringBuilder sbAppend = new StringBuilder().append("Support list refresh failed: ");
            if (TextUtils.isEmpty(str)) {
                str = "unknown error";
            }
            string = sbAppend.append(str).toString();
        }
        Toast.makeText((Context) baseActivity, (CharSequence) string, 1).show();
    }

    public final void b() {
        if (!c.compareAndSet(false, true)) {
            Toast.makeText((Context) this.a, (CharSequence) "Log export is already running", 0).show();
        } else {
            Toast.makeText((Context) this.a, (CharSequence) "Creating log archive...", 0).show();
            new Thread(new Runnable() {
                @Override
                public final void run() {
                    og.this.d();
                }
            }, "TTModLogExporter").start();
        }
    }

    public final void c() {
        try {
            final p6 p6VarA = q6.a(this.a.getApplicationContext());
            this.a.runOnUiThread(new Runnable() {
                @Override
                public final void run() {
                    og.this.a(p6VarA);
                }
            });
            b.set(false);
        } catch (Throwable th) {
            try {
                String strDecrypt = "Heap dump export failed";
                Object obj = g7.a;
                g7.a(6, String.valueOf(strDecrypt), th);
                this.a.runOnUiThread(new Runnable() {
                    @Override
                    public final void run() {
                        og.this.a(th);
                    }
                });
            } finally {
                b.set(false);
            }
        }
    }

    public final void d() {
        try {
            final f7 f7VarA = g7.a(this.a.getApplicationContext());
            this.a.runOnUiThread(new Runnable() {
                @Override
                public final void run() {
                    og.this.a(f7VarA);
                }
            });
            c.set(false);
        } catch (Throwable th) {
            try {
                String strDecrypt = "Log export failed";
                Object obj = g7.a;
                g7.a(6, String.valueOf(strDecrypt), th);
                this.a.runOnUiThread(new Runnable() {
                    @Override
                    public final void run() {
                        og.this.b(th);
                    }
                });
            } finally {
                c.set(false);
            }
        }
    }

    public final  void a(f7 f7Var) {
        Toast.makeText((Context) this.a, (CharSequence) String.format(Locale.US, "Logs exported: %s (%d files, %.1f KiB)", f7Var.a, Integer.valueOf(f7Var.c), Double.valueOf(f7Var.b / 1024.0d)), 1).show();
    }

    public final  void b(Throwable th) {
        Toast.makeText((Context) this.a, (CharSequence) ("Log export failed: " + th.getMessage()), 1).show();
    }

    public final void a() {
        if (!b.compareAndSet(false, true)) {
            Toast.makeText((Context) this.a, (CharSequence) "Heap dump export is already running", 0).show();
        } else {
            Toast.makeText((Context) this.a, (CharSequence) "Creating heap dump. The app may pause for a moment...", 1).show();
            new Thread(new Runnable() {
                @Override
                public final void run() {
                    og.this.c();
                }
            }, "TTModHeapDumpExporter").start();
        }
    }

    public final  void a(p6 p6Var) {
        Toast.makeText((Context) this.a, (CharSequence) String.format(Locale.US, "Heap dump exported: %s (%.1f MiB)", p6Var.a, Double.valueOf(p6Var.b / 1048576.0d)), 1).show();
    }

    public final  void a(Throwable th) {
        Toast.makeText((Context) this.a, (CharSequence) ("Heap dump export failed: " + th.getMessage()), 1).show();
    }
}
