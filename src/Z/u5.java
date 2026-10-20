package Z;

import android.content.Context;
import android.content.Intent;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Objects;

public final class u5 {
    public final t5 a;
    public final hi b;
    public final zf c;
    public final w5 d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;

    public u5(t5 t5Var, final hi hiVar) {
        this.a = t5Var;
        this.b = hiVar;
        this.c = new zf(t5Var, hiVar);
        this.d = new w5(t5Var, new Runnable() {
            @Override
            public final void run() {
                u5.this.a(hiVar);
            }
        });
    }

    public final void a(hi hiVar) {
        g();
        Runnable runnable = hiVar.c;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final LinearLayout b() {
        LinearLayout linearLayoutC = this.b.c();
        this.e = this.c.a();
        linearLayoutC.addView(this.c.a("ic_pencil", k7.a("filter_words"), this.e, new Runnable() {
            @Override
            public final void run() {
                u5.this.e();
            }
        }));
        this.f = this.c.a();
        zf zfVar = this.c;
        String strDecrypt = "ic_like";
        String strA = k7.a("filter_likes");
        TextView textView = this.f;
        final w5 w5Var = this.d;
        Objects.requireNonNull(w5Var);
        linearLayoutC.addView(zfVar.a(strDecrypt, strA, textView, new Runnable() {
            @Override
            public final void run() {
                w5Var.b();
            }
        }));
        this.g = this.c.a();
        zf zfVar2 = this.c;
        String strDecrypt2 = "ic_views";
        String strA2 = k7.a("filter_views");
        TextView textView2 = this.g;
        final w5 w5Var2 = this.d;
        Objects.requireNonNull(w5Var2);
        linearLayoutC.addView(zfVar2.a(strDecrypt2, strA2, textView2, new Runnable() {
            @Override
            public final void run() {
                w5Var2.c();
            }
        }));
        this.h = this.c.a();
        zf zfVar3 = this.c;
        String strDecrypt3 = "ic_clock";
        String strA3 = k7.a("filter_publish_date");
        TextView textView3 = this.h;
        final w5 w5Var3 = this.d;
        Objects.requireNonNull(w5Var3);
        linearLayoutC.addView(zfVar3.a(strDecrypt3, strA3, textView3, new Runnable() {
            @Override
            public final void run() {
                w5Var3.a();
            }
        }));
        g();
        linearLayoutC.setClipToOutline(true);
        return linearLayoutC;
    }

    public final LinearLayout c() {
        LinearLayout linearLayoutC = this.b.c();
        final ac acVarA = ac.a();
        zf zfVar = this.c;
        String strDecrypt = "ic_live";
        String strA = k7.a("hide_lives");
        acVarA.getClass();
        linearLayoutC.addView(zfVar.a(strDecrypt, strA, ac.e().c, new gi() {
            @Override
            public final void a(boolean z) {
                acVarA.e(z);
            }
        }, false));
        linearLayoutC.addView(this.c.a("ic_ads", k7.a("hide_ads"), ac.e().d, new gi() {
            @Override
            public final void a(boolean z) {
                acVarA.d(z);
            }
        }, false));
        linearLayoutC.addView(this.c.a("ic_photo_disable", k7.a("hide_photos"), ac.e().e, new gi() {
            @Override
            public final void a(boolean z) {
                acVarA.f(z);
            }
        }, false));
        linearLayoutC.addView(this.c.a("ic_hidestory", k7.a("hide_stories"), ac.e().j, new gi() {
            @Override
            public final void a(boolean z) {
                acVarA.g(z);
            }
        }, false));
        linearLayoutC.setClipToOutline(true);
        return linearLayoutC;
    }

    public final  void d() {
        this.a.startActivity(new Intent((Context) this.a, (Class<?>) t5.class).putExtra("ttmod_section", "anti_burnout"));
    }

    public final  void e() {
        this.a.startActivityForResult(new Intent((Context) this.a, (Class<?>) c6.class), 1004);
    }

    public final LinearLayout f() {
        LinearLayout linearLayoutC = this.b.c();
        final ac acVarA = ac.a();
        zf zfVar = this.c;
        String strDecrypt = "ic_skip_download_selector";
        String strA = k7.a("skip_quality_picker");
        acVarA.getClass();
        linearLayoutC.addView(zfVar.a(strDecrypt, strA, ac.e().z, new gi() {
            @Override
            public final void a(boolean z) {
                acVarA.h(z);
            }
        }, false));
        linearLayoutC.addView(this.c.a("ic_videoslider", k7.a("force_progress_bar"), ac.e().p, new gi() {
            @Override
            public final void a(boolean z) {
                acVarA.a(z);
            }
        }, false));
        linearLayoutC.setClipToOutline(true);
        return linearLayoutC;
    }

    public final void g() {
        ac acVarA = ac.a();
        TextView textView = this.e;
        if (textView != null) {
            acVarA.getClass();
            bc bcVarE = ac.e();
            if (bcVarE.A == null) {
                bcVarE.A = new LinkedHashSet();
            }
            LinkedHashSet linkedHashSet = bcVarE.A;
            textView.setText(String.valueOf(linkedHashSet.size()));
        }
        TextView textView2 = this.f;
        if (textView2 != null) {
            acVarA.getClass();
            textView2.setText(String.valueOf(ac.e().B));
        }
        TextView textView3 = this.g;
        if (textView3 != null) {
            acVarA.getClass();
            textView3.setText(String.valueOf(ac.e().C));
        }
        if (this.h != null) {
            acVarA.getClass();
            long j = ac.e().D;
            this.h.setText(j > 0 ? new SimpleDateFormat("dd.MM.yyyy", Locale.US).format(new Date(j * 1000)) : "");
        }
    }

    public final void a(LinearLayout linearLayout) {
        linearLayout.addView(a());
        linearLayout.addView(this.c.a(k7.a("section_content_filter")));
        linearLayout.addView(b());
        linearLayout.addView(this.c.a(k7.a("section_playback")));
        linearLayout.addView(f());
        linearLayout.addView(this.c.a(k7.a("section_hiding")));
        linearLayout.addView(c());
    }

    public final LinearLayout a() {
        LinearLayout linearLayoutC = this.b.c();
        linearLayoutC.addView(this.c.a("ic_lightbulb_off", k7.a("anti_burnout"), (TextView) null, new Runnable() {
            @Override
            public final void run() {
                u5.this.d();
            }
        }));
        linearLayoutC.setClipToOutline(true);
        return linearLayoutC;
    }
}
