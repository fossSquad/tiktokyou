package Z;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.windukk.mod.Main;
import java.util.Iterator;
import java.util.List;
import ni.shikatu.kotlin.Triple;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.internal.Ref;

public abstract class yi {
    public static final List a = CollectionsKt.listOf(new Triple[]{new Triple("ic_pencil", "ui_hide_guide_step1_title", "ui_hide_guide_step1_text"), new Triple("ic_chevron_updown", "ui_hide_guide_step2_title", "ui_hide_guide_step2_text"), new Triple("ic_delete", "ui_hide_guide_step3_title", "ui_hide_guide_step3_text"), new Triple("ic_check_active", "ui_hide_guide_step4_title", "ui_hide_guide_step4_text")});

    public static final void a(u uVar) {
        if (y5.a().a.getBoolean("ui_hide_guide_shown", false) || uVar.isFinishing() || uVar.isDestroyed()) {
            return;
        }
        y5.a().a.edit().putBoolean("ui_hide_guide_shown", true).apply();
        a((Activity) uVar, true);
    }

    public static final void a(Ref.IntRef intRef, fc fcVar) {
        if (intRef.element <= 0) {
            fcVar.c((Runnable) null);
        }
    }

    public static final void a(Handler handler, xi xiVar) {
        handler.removeCallbacks(xiVar);
    }

    public static final void a(Activity activity, boolean z) {
        fc fcVar = new fc(activity);
        fcVar.c.setTag("UiHideSheet");
        final fc fcVarA = fcVar.b((CharSequence) k7.a("ui_hide_guide_title")).a((CharSequence) k7.a("ui_hide_guide_subtitle"));
        LinearLayout linearLayoutA = fcVarA.a(4);
        Iterator it = a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Triple triple = (Triple) it.next();
            LinearLayout linearLayoutA2 = fcVarA.a((String) triple.component1(), k7.a((String) triple.component2()), k7.a((String) triple.component3()), null, null);
            ((LinearLayout.LayoutParams) linearLayoutA2.getChildAt(0).getLayoutParams()).setMarginEnd(Main.dp(4.0f));
            linearLayoutA.addView(linearLayoutA2);
        }
        fcVarA.a().addView(linearLayoutA);
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = z ? 5 : 0;
        TextView textViewA = fcVarA.a(k7.a("ui_hide_guide_done"), new Runnable() {
            @Override
            public final void run() {
                yi.a(intRef, fcVarA);
            }
        });
        boolean z2 = intRef.element <= 0;
        fcVarA.v = z2;
        fcVarA.b.setCancelable(z2);
        if (z) {
            String strA = k7.a("ui_hide_guide_accept");
            String strA2 = k7.a("ui_hide_guide_done_in");
            final Handler handler = new Handler(Looper.getMainLooper());
            final xi xiVar = new xi(intRef, textViewA, strA, fcVarA, strA2, handler);
            fcVarA = fcVarA;
            fcVarA.x = new Runnable() {
                @Override
                public final void run() {
                    yi.a(handler, xiVar);
                }
            };
            xiVar.run();
        }
        fcVarA.g();
    }
}
