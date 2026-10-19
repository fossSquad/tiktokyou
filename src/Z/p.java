package Z;

import android.view.View;
import android.widget.LinearLayout;
public final class p {
    public final t5 a;
    public final hi b;
    public final zf c;
    public o d;
    public LinearLayout e;

    public p(t5 t5Var, hi hiVar) {
        this.a = t5Var;
        this.b = hiVar;
        this.c = new zf(t5Var, hiVar);
    }

    public final void a(LinearLayout linearLayout) {
        final ac acVarA = ac.a();
        zf zfVar = this.c;
        String strDecrypt = "ic_antiburnin_show_on_main_page";
        String strA = k7.a("antiburnout_show_on_main");
        acVarA.getClass();
        linearLayout.addView(zfVar.a(strDecrypt, strA, ac.e().g, new gi() {
            @Override
            public final void a(boolean z) {
                this.f$0.a(acVarA, z);
            }
        }));
        LinearLayout linearLayoutC = this.b.c();
        linearLayoutC.setPadding(this.b.a(4.0f), this.b.a(4.0f), this.b.a(4.0f), this.b.a(4.0f));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.b.a(8.0f);
        linearLayout.addView(linearLayoutC, layoutParams);
        o oVar = new o(this.a, this.b);
        this.d = oVar;
        oVar.setActive(ac.e().h);
        linearLayoutC.addView(this.d);
        LinearLayout linearLayout2 = new LinearLayout(this.a);
        linearLayout2.setOrientation(1);
        this.e = linearLayout2;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.b.a(4.0f);
        linearLayoutC.addView(linearLayout2, layoutParams2);
        View viewA = this.c.a("ic_phone", k7.a("antiburnout_hide_system_bars"), ac.e().i, new gi() {
            @Override
            public final void a(boolean z) {
                this.f$0.b(acVarA, z);
            }
        }, true);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.bottomMargin = this.b.a(4.0f);
        viewA.setLayoutParams(layoutParams3);
        viewA.setBackground(null);
        this.b.a(viewA, 8.0f);
        linearLayout2.addView(viewA);
        View viewA2 = this.c.a("ic_antiburnin_enable_on_start", k7.a("antiburnout_enable_on_start"), ac.e().h, new gi() {
            @Override
            public final void a(boolean z) {
                this.f$0.c(acVarA, z);
            }
        }, true);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.bottomMargin = this.b.a(4.0f);
        viewA2.setLayoutParams(layoutParams4);
        viewA2.setBackground(null);
        this.b.a(viewA2, 8.0f);
        linearLayout2.addView(viewA2);
        linearLayout2.addView(this.c.a("ic_hideui_opacity", k7.a("feed_overlay_opacity"), k7.a("feed_overlay_opacity_hint"), ac.e().s, new fi() {
            @Override
            public final void a(int i) {
                this.f$0.a(acVarA, i);
            }
        }));
        ac.a().getClass();
        boolean z = ac.e().g;
        this.e.setAlpha(z ? 1.0f : 0.3f);
        zf.a(z, this.e);
        this.d.a();
    }

    public final void b(ac acVar, boolean z) {
        acVar.getClass();
        ac.e().d(z);
        this.d.setActive(true);
        this.d.a();
    }

    public final void c(ac acVar, boolean z) {
        acVar.getClass();
        ac.e().b(z);
        this.d.setActive(z);
    }

    public final void a(ac acVar, boolean z) {
        acVar.getClass();
        bc bcVarE = ac.e();
        bcVarE.g = z;
        bcVarE.a.edit().putBoolean("anti_burnout_show_on_main", z).apply();
        ac.a().getClass();
        boolean z2 = ac.e().g;
        this.e.setAlpha(z2 ? 1.0f : 0.3f);
        zf.a(z2, this.e);
        this.d.a();
    }

    public final void a(ac acVar, int i) {
        acVar.getClass();
        ac.e().b(i);
        this.d.setActive(true);
        this.d.a();
    }
}
