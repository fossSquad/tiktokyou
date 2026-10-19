package Z;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.windukk.mod.Main;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.Ref;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.kotlinx.serialization.json.Json;

public abstract class zj {
    public static final void a(yj yjVar, EditText editText, Ref.BooleanRef booleanRef, String str, wj wjVar, Activity activity, Ref.BooleanRef booleanRef2, fc fcVar, String str2) {
        String str3 = yjVar.a;
        String string = StringsKt.trim(editText.getText().toString()).toString();
        String str4 = string.length() == 0 ? str2 : string;
        String str5 = booleanRef.element ? "alpha" : "gone";
        String str6 = yjVar.b;
        wj wjVar2 = new wj(str3, str4, str5, str, str6, wjVar != null ? wjVar.f : true);
        Json json = xj.a;
        if (str6.length() != 0) {
            List listA = xj.a();
            ArrayList arrayList = new ArrayList();
            for (Object obj : listA) {
                if (!((wj) obj).a(wjVar2)) {
                    arrayList.add(obj);
                }
            }
            xj.a(CollectionsKt.plus(arrayList, wjVar2));
        }
        pj.i();
        Toast.makeText(activity, k7.a("ui_hide_saved"), 0).show();
        booleanRef2.element = true;
        fcVar.c((Runnable) null);
    }

    public static final Unit b(Runnable runnable) {
        runnable.run();
        return Unit.INSTANCE;
    }

    public static final Unit b(Ref.BooleanRef booleanRef, fc fcVar, ImageView imageView, ImageView imageView2) {
        booleanRef.element = true;
        fcVar.b(imageView, false);
        fcVar.b(imageView2, true);
        return Unit.INSTANCE;
    }

    public static final void a(Activity activity, String str, String str2, final Runnable runnable) {
        a(activity, new yj(str, str2), new Function0() {
            public final Object invoke() {
                return zj.a(runnable);
            }
        }, new Function0() {
            public final Object invoke() {
                return zj.b(runnable);
            }
        });
    }

    public static final Unit a(Runnable runnable) {
        runnable.run();
        return Unit.INSTANCE;
    }

    public static void a(final Activity activity, final yj yjVar, final Function0 function0, final Function0 function1) {
        Object next;
        if (activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        final String strB = xj.b();
        Iterator it = xj.a().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            wj wjVar = (wj) next;
            if (Intrinsics.areEqual(wjVar.a, yjVar.a) && Intrinsics.areEqual(wjVar.e, yjVar.b) && Intrinsics.areEqual(wjVar.d, strB)) {
                break;
            }
        }
        final wj wjVar2 = (wj) next;
        final String strA = a(yjVar.a, yjVar.b);
        fc fcVar = new fc(activity);
        fcVar.c.setTag("UiHideSheet");
        final fc fcVarA = fcVar.b((CharSequence) k7.a("ui_hide_sheet_title")).a((CharSequence) strA);
        fcVarA.r.setMaxLines(1);
        fcVarA.r.setEllipsize(TextUtils.TruncateAt.END);
        ec ecVar = new ec(fcVarA);
        final EditText editText = ecVar.b;
        editText.setInputType(16385);
        String str = wjVar2 != null ? wjVar2.b : null;
        if (str == null) {
            str = "";
        }
        editText.setText(str);
        ecVar.b.setHint(k7.a("ui_hide_sheet_custom_name"));
        ecVar.b.addTextChangedListener(new dc(ecVar));
        boolean z = false;
        boolean z2 = ecVar.b.getText().length() == 0;
        ecVar.b.setTextSize(2, z2 ? 14.0f : 16.0f);
        ecVar.b.setTypeface(z2 ? fc.b() : fc.f());
        editText.setSelection(editText.getText().length());
        fcVarA.a().addView(ecVar.a);
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        if (wjVar2 != null && !wjVar2.a()) {
            z = true;
        }
        booleanRef.element = z;
        boolean z3 = true ^ z;
        final ImageView imageView = new ImageView(fcVarA.a);
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_CENTER;
        imageView.setScaleType(scaleType);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(Main.dp(20.0f), Main.dp(20.0f)));
        fcVarA.b(imageView, z3);
        boolean z4 = booleanRef.element;
        final ImageView imageView2 = new ImageView(fcVarA.a);
        imageView2.setScaleType(scaleType);
        imageView2.setLayoutParams(new LinearLayout.LayoutParams(Main.dp(20.0f), Main.dp(20.0f)));
        fcVarA.b(imageView2, z4);
        LinearLayout linearLayoutA = fcVarA.a(4);
        linearLayoutA.addView(a(fcVarA, "ic_delete", k7.a("ui_hide_type_gone"), imageView, new Function0() {
            public final Object invoke() {
                return zj.a(booleanRef, fcVarA, imageView, imageView2);
            }
        }));
        linearLayoutA.addView(a(fcVarA, "ic_hideui_opacity", k7.a("ui_hide_type_alpha"), imageView2, new Function0() {
            public final Object invoke() {
                return zj.b(booleanRef, fcVarA, imageView, imageView2);
            }
        }));
        fcVarA.a().addView(linearLayoutA);
        final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        fcVarA.a(k7.a("filter_save"), new Runnable() {
            @Override
            public final void run() {
                zj.a(yjVar, editText, booleanRef, strB, wjVar2, activity, booleanRef2, fcVarA, strA);
            }
        });
        fcVarA.d(k7.a("filter_cancel"), null);
        fcVarA.x = new Runnable() {
            @Override
            public final void run() {
                zj.a(booleanRef2, function0, function1);
            }
        };
        fcVarA.g();
    }

    public static final Unit a(Ref.BooleanRef booleanRef, fc fcVar, ImageView imageView, ImageView imageView2) {
        booleanRef.element = false;
        fcVar.b(imageView, true);
        fcVar.b(imageView2, false);
        return Unit.INSTANCE;
    }

    public static final void a(Ref.BooleanRef booleanRef, Function0 function0, Function0 function1) {
        if (booleanRef.element) {
            function0.invoke();
        } else {
            function1.invoke();
        }
    }

    public static LinearLayout a(fc fcVar, String str, String str2, ImageView imageView, final Function0 function0) {
        LinearLayout linearLayoutE = fcVar.e();
        linearLayoutE.addView(fcVar.a(fcVar.k, str));
        TextView textViewA = fcVar.a(16.0f, true, fcVar.h);
        textViewA.setText(str2);
        linearLayoutE.addView(textViewA, fc.h());
        linearLayoutE.addView(imageView);
        fcVar.a(linearLayoutE, new Runnable() {
            @Override
            public final void run() {
                zj.a(function0);
            }
        });
        return linearLayoutE;
    }

    public static final void a(Function0 function0) {
        function0.invoke();
    }

    public static String a(String str, String str2) {
        List listSplit$default = StringsKt.split$default(StringsKt.substringAfterLast$default(str2, '/', (String) null, 2, (Object) null), new char[]{':'}, false, 0, 6, (Object) null);
        String str3 = (String) CollectionsKt.getOrNull(listSplit$default, 1);
        if (str3 == null) {
            return str;
        }
        if (str3.length() <= 0) {
            str3 = null;
        }
        if (str3 == null) {
            return str;
        }
        String str4 = (String) CollectionsKt.getOrNull(listSplit$default, 2);
        if (str4 != null) {
            String str5 = str4.length() > 0 ? str4 : null;
            if (str5 != null) {
                str = str5;
            }
        }
        return str3 + ":" + str;
    }
}
