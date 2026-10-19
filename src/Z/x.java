package Z;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.windukk.mod.Main;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public final class x {
    public static final int[] k;
    public final u a;
    public final hi b;
    public LinearLayout c;
    public ViewGroup d;
    public String e;
    public TextView f;
    public LinearLayout g;
    public LinearLayout h;
    public LinearLayout i;
    public TextView j;

    static {
        k = new int[]{-12165909, -1424314, -12726936, -5616918, -1142217, -1226807, -12342807, -7763575};
    }

    public x(u uVar, hi hiVar) {
        this.a = uVar;
        this.b = hiVar;
    }

    public static void f() {
        ac.a().getClass();
        ac.e().f(false);
    }

    public final void a(View view) {
        boolean z = y5.a().m;
        boolean z2 = !z;
        if (!z && !y5.a().l) {
            ac.a().getClass();
            ac.e();
            b(2);
        }
        pj.b(z2);
        if (!z) {
            yi.a(this.a);
        }
        j();
    }

    public final void b(int i) {
        boolean z = i == 1;
        boolean z2 = i == 2;
        if (y5.a().k != z) {
            pj pjVar = pj.a;
            ac.a().getClass();
            ac.e().k(z);
            pj.i();
        }
        if (y5.a().l != z2) {
            pj pjVar2 = pj.a;
            ac.a().getClass();
            ac.e().o(z2);
            pj.i();
        }
        if (!z2 && y5.a().m) {
            pj.b(false);
            j();
        }
        l();
    }

    public final LinearLayout c() {
        LinearLayout linearLayoutC = this.b.c();
        RadioGroup radioGroup = new RadioGroup(this.a);
        radioGroup.setOrientation(1);
        ac.a().getClass();
        String strF = ac.f();
        final ArrayList arrayList = new ArrayList();
        arrayList.add(new String[]{"default", k7.a("font_default"), "ic_font"});
        arrayList.add(new String[]{"system", k7.a("font_system"), "ic_system_font"});
        int i = -1;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            String[] strArr = (String[]) arrayList.get(i2);
            RadioButton radioButtonA = this.b.a(i2, strArr[1], strArr[2]);
            radioButtonA.setMinHeight(this.b.a(52.0f));
            radioButtonA.setPadding(this.b.a(20.0f), 0, this.b.a(20.0f), 0);
            radioGroup.addView(radioButtonA);
            if (strArr[0].equals(strF)) {
                i = i2;
            }
        }
        linearLayoutC.addView(radioGroup);
        linearLayoutC.addView(d());
        if (strF != null && strF.startsWith("file:")) {
            radioGroup.clearCheck();
        } else if (i >= 0) {
            radioGroup.check(i);
        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public final void onCheckedChanged(RadioGroup radioGroup2, int i3) {
                this.f$0.a(arrayList, radioGroup2, i3);
            }
        });
        return linearLayoutC;
    }

    public final LinearLayout d() {
        this.f = new TextView(this.a);
        LinearLayout linearLayoutA = this.b.a("ic_font_file", k7.a("font_pick_file"), this.f, new Runnable() {
            @Override
            public final void run() {
                this.f$0.h();
            }
        });
        linearLayoutA.setMinimumHeight(this.b.a(52.0f));
        linearLayoutA.setPadding(this.b.a(20.0f), 0, this.b.a(20.0f), 0);
        k();
        return linearLayoutA;
    }

    public final LinearLayout e() {
        LinearLayout linearLayoutC = this.b.c();
        linearLayoutC.setPadding(0, this.b.a(16.0f), 0, this.b.a(16.0f));
        linearLayoutC.setClipToPadding(false);
        linearLayoutC.setClipChildren(false);
        final GridLayout gridLayout = new GridLayout(this.a);
        gridLayout.setColumnCount(4);
        gridLayout.setClipToPadding(false);
        gridLayout.setClipChildren(false);
        this.d = gridLayout;
        this.e = j7.a();
        ArrayList arrayListA = j7.a((Context) this.a);
        int size = arrayListA.size();
        i7 i7Var = null;
        int i = 0;
        while (i < size) {
            Object obj = arrayListA.get(i);
            i++;
            i7 i7Var2 = (i7) obj;
            if ("md".equals(i7Var2.a)) {
                i7Var = i7Var2;
            } else {
                LinearLayout linearLayoutA = a(i7Var2, i7Var2.a.equals(this.e));
                GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
                layoutParams.width = 0;
                layoutParams.height = -2;
                layoutParams.columnSpec = GridLayout.spec(Integer.MIN_VALUE, 1.0f);
                layoutParams.setGravity(55);
                layoutParams.topMargin = gridLayout.getChildCount() >= gridLayout.getColumnCount() ? this.b.a(12.0f) : 0;
                gridLayout.addView(linearLayoutA, layoutParams);
            }
        }
        if (i7Var != null) {
            LinearLayout linearLayoutA2 = a(i7Var, "md".equals(this.e));
            GridLayout.LayoutParams layoutParams2 = new GridLayout.LayoutParams();
            layoutParams2.width = 0;
            layoutParams2.height = -2;
            layoutParams2.columnSpec = GridLayout.spec(Integer.MIN_VALUE, 1.0f);
            layoutParams2.setGravity(55);
            layoutParams2.topMargin = gridLayout.getChildCount() >= gridLayout.getColumnCount() ? this.b.a(12.0f) : 0;
            gridLayout.addView(linearLayoutA2, layoutParams2);
        }
        final LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        linearLayoutC.addView(gridLayout, layoutParams3);
        linearLayoutC.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                this.f$0.a(gridLayout, layoutParams3, view, i2, i3, i4, i5, i6, i7, i8, i9);
            }
        });
        return linearLayoutC;
    }

    public final void g() {
        ac.a().getClass();
        ac.e().f(true);
        ac.a().getClass();
        ac.e().a(0);
    }

    public final  void h() {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"font/ttf", "font/otf", "font/sfnt", "application/x-font-ttf", "application/x-font-otf", "application/octet-stream"});
        this.a.startActivityForResult(intent, 1001);
    }

    public final LinearLayout i() {
        LinearLayout linearLayoutC = this.b.c();
        linearLayoutC.setPadding(this.b.a(20.0f), this.b.a(16.0f), this.b.a(20.0f), this.b.a(16.0f));
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setOrientation(0);
        this.g = a(0, "ui_hide_mode_default");
        this.h = a(1, "ui_hide_mode_simple");
        LinearLayout linearLayoutA = a(2, "ui_hide_mode_selected");
        this.i = linearLayoutA;
        LinearLayout[] linearLayoutArr = {this.g, this.h, linearLayoutA};
        int i = 0;
        while (i < 3) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
            layoutParams.leftMargin = i > 0 ? this.b.a(16.0f) : 0;
            linearLayout.addView(linearLayoutArr[i], layoutParams);
            i++;
        }
        linearLayoutC.addView(linearLayout);
        l();
        LinearLayout linearLayout2 = new LinearLayout(this.a);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.b.a(16.0f);
        linearLayoutC.addView(linearLayout2, layoutParams2);
        TextView textView = new TextView(this.a);
        this.j = textView;
        textView.setGravity(17);
        this.j.setTextSize(2, 16.0f);
        this.j.setTypeface(hi.f());
        this.j.setSingleLine(true);
        this.j.setEllipsize(TextUtils.TruncateAt.END);
        this.j.setPadding(this.b.a(16.0f), 0, this.b.a(16.0f), 0);
        this.j.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                this.f$0.a(view);
            }
        });
        linearLayout2.addView(this.j, new LinearLayout.LayoutParams(0, this.b.a(52.0f), 1.0f));
        j();
        ImageView imageView = new ImageView(this.a);
        imageView.setImageDrawable(new w(this.b.e(), this.b.a(1.0f)));
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        int color = this.b.b ? -13882322 : Color.parseColor("#F1F1F2");
        float fA = this.b.a(26.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(color);
        gradientDrawable.setCornerRadius(fA);
        imageView.setBackground(gradientDrawable);
        imageView.setContentDescription(k7.a("ui_hide_section"));
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                this.f$0.b(view);
            }
        });
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(this.b.a(52.0f), this.b.a(52.0f));
        layoutParams3.leftMargin = this.b.a(12.0f);
        linearLayout2.addView(imageView, layoutParams3);
        return linearLayoutC;
    }

    public final void j() {
        String str;
        String str2;
        int iA;
        if (this.j == null) {
            return;
        }
        boolean z = y5.a().m;
        TextView textView = this.j;
        textView.setText(k7.a((z ? "ui_hide_edit_mode_done" : "ui_hide_edit_mode")));
        this.j.setTextColor(z ? this.b.e() : -1);
        TextView textView2 = this.j;
        hi hiVar = this.b;
        if (z) {
            iA = hiVar.b ? -13882322 : Color.parseColor("#F1F1F2");
        } else {
            hiVar.getClass();
            iA = hi.a();
        }
        float fA = this.b.a(26.0f);
        hiVar.getClass();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(iA);
        gradientDrawable.setCornerRadius(fA);
        textView2.setBackground(gradientDrawable);
    }

    public final void k() {
        String strReplaceAll;
        if (this.f == null) {
            return;
        }
        ac.a().getClass();
        String strF = ac.f();
        if (strF == null || !strF.startsWith("file:")) {
            this.f.setText("");
            this.f.setVisibility(8);
            return;
        }
        Typeface typeface = n6.a;
        if ("default".equals(strF) || "system".equals(strF)) {
            strReplaceAll = null;
        } else {
            if (strF.startsWith("file:")) {
                strF = strF.substring("file:".length());
            } else if (strF.startsWith("asset:")) {
                strF = strF.substring("asset:".length());
            }
            strReplaceAll = strF.replaceAll("(?i)\\.(ttf|otf)$", "");
        }
        this.f.setText(strReplaceAll != null ? strReplaceAll : "");
        this.f.setVisibility(0);
    }

    public final void l() {
        char c;
        if (y5.a().l) {
            c = 2;
        } else {
            c = y5.a().k ? (char) 1 : (char) 0;
        }
        a(this.g, c == 0);
        a(this.h, c == 1);
        a(this.i, c == 2);
    }

    public final void a(int i, View view) {
        int i2;
        if (y5.a().l) {
            i2 = 2;
        } else {
            i2 = y5.a().k ? 1 : 0;
        }
        if (i2 != i) {
            b(i);
        }
    }

    public final  void b(View view) {
        this.a.startActivity(new Intent((Context) this.a, (Class<?>) qj.class));
    }

    public final View b() {
        View view = new View(this.a);
        hi hiVar = this.b;
        int i = hiVar.b ? -12961220 : -3289651;
        float fA = hiVar.a(1.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius(fA);
        view.setBackground(gradientDrawable);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.b.a(2.0f), this.b.a(12.0f));
        layoutParams.leftMargin = this.b.a(6.0f);
        layoutParams.rightMargin = this.b.a(6.0f);
        view.setLayoutParams(layoutParams);
        return view;
    }

    public final void a(i7 i7Var, View view) {
        int iA;
        if (i7Var.a.equals(this.e)) {
            return;
        }
        String str = i7Var.a;
        this.e = str;
        j7.a((Context) this.a, str);
        if (this.d != null) {
            for (int i = 0; i < this.d.getChildCount(); i++) {
                View childAt = this.d.getChildAt(i);
                if (childAt instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) childAt;
                    if (viewGroup.getChildCount() >= 2) {
                        String str2 = this.e;
                        boolean z = str2 != null && str2.equals(viewGroup.getTag());
                        View childAt2 = viewGroup.getChildAt(0);
                        if (childAt2 instanceof ViewGroup) {
                            ViewGroup viewGroup2 = (ViewGroup) childAt2;
                            if (viewGroup2.getChildCount() > 0) {
                                viewGroup2.getChildAt(0).setVisibility(z ? 0 : 4);
                            }
                        }
                        View childAt3 = viewGroup.getChildAt(1);
                        if (childAt3 instanceof TextView) {
                            TextView textView = (TextView) childAt3;
                            if (z) {
                                this.b.getClass();
                                iA = hi.a();
                            } else {
                                iA = hi.f;
                            }
                            textView.setTextColor(iA);
                        }
                    }
                }
            }
        }
        Runnable runnable = this.b.c;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void a(LinearLayout linearLayout) {
        linearLayout.addView(i());
        linearLayout.addView(a(k7.a("app_icon")));
        linearLayout.addView(e());
        linearLayout.addView(a(k7.a("section_colors")));
        linearLayout.addView(a());
        linearLayout.addView(a(k7.a("section_font")));
        linearLayout.addView(c());
    }

    public final TextView a(String str) {
        TextView textView = new TextView(this.a);
        textView.setText(str);
        textView.setTextSize(2, 12.0f);
        textView.setTextColor(hi.f);
        textView.setTypeface(hi.f());
        textView.setPadding(this.b.a(20.0f), this.b.a(20.0f), this.b.a(20.0f), this.b.a(12.0f));
        return textView;
    }

    public final LinearLayout a(final int i, String str) {
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        sj sjVar = new sj(this.a, i, this.b.b);
        if (i == 2) {
            sjVar.setCenterIcon(this.b.b("ic_pencil"));
        }
        linearLayout.addView(sjVar, new LinearLayout.LayoutParams(-1, -2));
        TextView textView = new TextView(this.a);
        textView.setText(k7.a(str));
        textView.setTextSize(2, 12.0f);
        textView.setTypeface(hi.f());
        textView.setGravity(17);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.b.a(8.0f);
        linearLayout.addView(textView, layoutParams);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                this.f$0.a(i, view);
            }
        });
        return linearLayout;
    }

    public final void a(LinearLayout linearLayout, boolean z) {
        int iA;
        if (linearLayout == null) {
            return;
        }
        sj sjVar = (sj) linearLayout.getChildAt(0);
        this.b.getClass();
        int iA2 = hi.a();
        sjVar.n = z;
        sjVar.m = iA2;
        sjVar.invalidate();
        TextView textView = (TextView) linearLayout.getChildAt(1);
        if (z) {
            this.b.getClass();
            iA = hi.a();
        } else {
            iA = hi.f;
        }
        textView.setTextColor(iA);
    }

    public final void a(int i, int i2, Intent intent) {
        Uri data;
        String strDecrypt;
        int columnIndex;
        if (i != 1001 || i2 != -1 || intent == null || (data = intent.getData()) == null) {
            return;
        }
        try {
            Cursor cursorQuery = this.a.getContentResolver().query(data, null, null, null, null);
            if (cursorQuery == null) {
                strDecrypt = null;
            } else {
                try {
                    if (!cursorQuery.moveToFirst() || (columnIndex = cursorQuery.getColumnIndex("_display_name")) < 0) {
                        strDecrypt = null;
                    } else {
                        strDecrypt = cursorQuery.getString(columnIndex);
                    }
                } catch (Throwable th) {
                    try {
                        cursorQuery.close();
                        throw th;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                        throw th;
                    }
                }
            }
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Exception e) {
                }
            }
        } catch (Exception e2) {
            strDecrypt = null;
        }
        if (strDecrypt == null) {
            strDecrypt = "custom_font.ttf";
        }
        String lowerCase = strDecrypt.toLowerCase();
        if (lowerCase.endsWith(".ttf") || lowerCase.endsWith(".otf")) {
            File file = new File(this.a.getFilesDir(), "fonts");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, strDecrypt);
            try {
                InputStream inputStreamOpenInputStream = this.a.getContentResolver().openInputStream(data);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    if (inputStreamOpenInputStream == null) {
                        fileOutputStream.close();
                        if (inputStreamOpenInputStream != null) {
                            inputStreamOpenInputStream.close();
                            return;
                        }
                        return;
                    }
                    try {
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int i3 = inputStreamOpenInputStream.read(bArr);
                            if (i3 <= 0) {
                                break;
                            } else {
                                fileOutputStream.write(bArr, 0, i3);
                            }
                            if (inputStreamOpenInputStream != null) {
                                try {
                                    inputStreamOpenInputStream.close();
                                    throw th;
                                } catch (Throwable th3) {
                                    th.addSuppressed(th3);
                                    throw th;
                                }
                            }
                            throw th;
                        }
                        fileOutputStream.close();
                        inputStreamOpenInputStream.close();
                        ac acVarA = ac.a();
                        String strA = di.a("jxU2oKyjv1o85bEI9o3Za6cr9r8BMM8XlRRb4bnIbT8=", "LIjhGW26CftDS7hB", "aes", new StringBuilder(), strDecrypt);
                        acVarA.getClass();
                        ac.e().c(strA);
                        n6.a = null;
                        n6.b = null;
                        n6.c.clear();
                        k();
                        Runnable runnable = this.b.c;
                        if (runnable != null) {
                            runnable.run();
                            return;
                        }
                        return;
                    } catch (Throwable th4) {
                        try {
                            fileOutputStream.close();
                            throw th4;
                        } catch (Throwable th5) {
                            th4.addSuppressed(th5);
                            throw th4;
                        }
                    }
                } catch (Throwable th6) {
                    if (inputStreamOpenInputStream != null) {
                        inputStreamOpenInputStream.close();
                        throw th6;
                    }
                    throw th6;
                }
            } catch (IOException e3) {
                String strDecrypt2 = "Failed to copy font: %s";
                Object obj = g7.a;
                g7.a(6, String.valueOf(strDecrypt2), e3);
            }
            String strDecrypt3 = "Failed to copy font: %s";
            Object obj2 = g7.a;
            g7.a(6, String.valueOf(strDecrypt3), e3);
        }
    }

    public final  void a(final GridLayout gridLayout, final LinearLayout.LayoutParams layoutParams, View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        final int i9 = i3 - i;
        if (i9 == i7 - i5) {
            return;
        }
        final int columnCount = gridLayout.getColumnCount();
        final int iA = this.b.a(20.0f);
        float f = i9;
        float f2 = columnCount;
        final int iRound = Math.round(((((this.b.a(48.0f) / 2.0f) + iA) - (f / (f2 * 2.0f))) * f2) / (f2 - 1.0f));
        final float f3 = (f - (iRound * 2.0f)) / f2;
        gridLayout.post(new Runnable() {
            @Override
            public final void run() {
                x.a(layoutParams, iRound, gridLayout, f3, columnCount, iA, i9);
            }
        });
    }

    public static  void a(LinearLayout.LayoutParams layoutParams, int i, GridLayout gridLayout, float f, int i2, int i3, int i4) {
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        for (int i5 = 0; i5 < gridLayout.getChildCount(); i5++) {
            View childAt = gridLayout.getChildAt(i5);
            if (childAt instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) childAt;
                if (viewGroup.getChildCount() >= 2) {
                    float f2 = (((i5 % i2) + 0.5f) * f) + i;
                    ((TextView) viewGroup.getChildAt(1)).setMaxWidth(Math.round(Math.min(f, Math.min(f2 - i3, (i4 - i3) - f2) * 2.0f)));
                }
            }
        }
        gridLayout.requestLayout();
    }

    public final LinearLayout a(final i7 i7Var, boolean z) {
        int iA;
        int iA2 = this.b.a(48.0f);
        int iA3 = this.b.a(4.0f);
        int i = (iA3 * 2) + iA2;
        int iA4 = this.b.a(12.0f);
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        linearLayout.setTag(i7Var.a);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        FrameLayout frameLayout = new FrameLayout(this.a);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(i, i));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(iA3 + iA4);
        int iA5 = this.b.a(2.0f);
        this.b.getClass();
        gradientDrawable.setStroke(iA5, hi.a());
        View view = new View(this.a);
        view.setBackground(gradientDrawable);
        view.setVisibility(z ? 0 : 4);
        frameLayout.addView(view, new FrameLayout.LayoutParams(i, i));
        ImageView imageView = new ImageView(this.a);
        Drawable drawableA = j7.a(this.a, i7Var);
        if (drawableA instanceof AdaptiveIconDrawable) {
            AdaptiveIconDrawable adaptiveIconDrawable = (AdaptiveIconDrawable) drawableA;
            Drawable background = adaptiveIconDrawable.getBackground();
            Drawable foreground = adaptiveIconDrawable.getForeground();
            if (background == null) {
                background = new ColorDrawable(0);
            }
            if (foreground == null) {
                foreground = new ColorDrawable(0);
            }
            drawableA = new LayerDrawable(new Drawable[]{background, foreground});
        }
        if (drawableA != null) {
            imageView.setImageDrawable(drawableA);
        }
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setClipToOutline(true);
        imageView.setOutlineProvider(new v(iA4));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA2, iA2);
        layoutParams.gravity = 17;
        frameLayout.addView(imageView, layoutParams);
        linearLayout.addView(frameLayout);
        TextView textView = new TextView(this.a);
        textView.setText(i7Var.a());
        textView.setTextSize(2, 12.0f);
        textView.setTypeface(hi.f());
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setGravity(17);
        if (z) {
            this.b.getClass();
            iA = hi.a();
        } else {
            iA = hi.f;
        }
        textView.setTextColor(iA);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = this.b.a(8.0f);
        linearLayout.addView(textView, layoutParams2);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view2) {
                this.f$0.a(i7Var, view2);
            }
        });
        return linearLayout;
    }

    public final LinearLayout a() {
        LinearLayout linearLayoutC = this.b.c();
        linearLayoutC.setPadding(0, this.b.a(16.0f), 0, this.b.a(16.0f));
        linearLayoutC.setClipToPadding(false);
        linearLayoutC.setClipChildren(false);
        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(this.a);
        horizontalScrollView.setHorizontalScrollBarEnabled(false);
        horizontalScrollView.setClipToPadding(false);
        horizontalScrollView.setClipChildren(false);
        horizontalScrollView.setOverScrollMode(2);
        horizontalScrollView.setPadding(this.b.a(14.0f), 0, this.b.a(14.0f), 0);
        LinearLayout linearLayout = new LinearLayout(this.a);
        this.c = linearLayout;
        linearLayout.setOrientation(0);
        this.c.setGravity(16);
        boolean zG = ac.a().g();
        int i = y5.a().r;
        zh.d = false;
        this.c.addView(a(-119980, "ic_tiktok", !zG, new Runnable() {
            @Override
            public final void run() {
                x.f();
            }
        }));
        this.c.addView(b());
        if (Build.VERSION.SDK_INT >= 31) {
            LinearLayout linearLayout2 = this.c;
            Context contextA = Main.getApplicationContext();
            linearLayout2.addView(a(contextA == null ? -16524603 : zh.a(contextA), "ic_android", zG && i == 0, new Runnable() {
                @Override
                public final void run() {
                    this.f$0.g();
                }
            }));
            this.c.addView(b());
        }
        int[] iArr = k;
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            final int i3 = iArr[i2];
            this.c.addView(a(i3, null, zG && i3 == i, new Runnable() {
                @Override
                public final void run() {
                    this.f$0.a(i3);
                }
            }));
        }
        zh.d = true;
        horizontalScrollView.addView(this.c);
        linearLayoutC.addView(horizontalScrollView);
        return linearLayoutC;
    }

    public final void a(int i) {
        ac.a().getClass();
        ac.e().f(true);
        ac.a().getClass();
        ac.e().a(i);
    }

    public final FrameLayout a(int i, String str, boolean z, final Runnable runnable) {
        int iA = this.b.a(36.0f);
        int iA2 = this.b.a(44.0f);
        final FrameLayout frameLayout = new FrameLayout(this.a);
        frameLayout.setTag("accent_swatch");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iA2, iA2);
        layoutParams.leftMargin = this.b.a(2.0f);
        layoutParams.rightMargin = this.b.a(2.0f);
        frameLayout.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(this.b.a(13.0f));
        gradientDrawable.setStroke(this.b.a(2.0f), i);
        View view = new View(this.a);
        view.setBackground(gradientDrawable);
        view.setVisibility(z ? 0 : 4);
        frameLayout.addView(view, new FrameLayout.LayoutParams(iA2, iA2));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(i);
        gradientDrawable2.setCornerRadius(z ? this.b.a(10.0f) : iA / 2.0f);
        View view2 = new View(this.a);
        view2.setBackground(gradientDrawable2);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(iA, iA);
        layoutParams2.gravity = 17;
        frameLayout.addView(view2, layoutParams2);
        if (str != null) {
            ImageView imageView = new ImageView(this.a);
            imageView.setImageDrawable(this.b.b(-1, str));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(this.b.a(20.0f), this.b.a(20.0f));
            layoutParams3.gravity = 17;
            frameLayout.addView(imageView, layoutParams3);
        }
        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view3) {
                this.f$0.a(runnable, frameLayout, view3);
            }
        });
        return frameLayout;
    }

    public final void a(Runnable runnable, FrameLayout frameLayout, View view) {
        runnable.run();
        zh.a = 0;
        zh.b = 0;
        zh.d = false;
        for (int i = 0; i < this.c.getChildCount(); i++) {
            View childAt = this.c.getChildAt(i);
            if ("accent_swatch".equals(childAt.getTag())) {
                FrameLayout frameLayout2 = (FrameLayout) childAt;
                boolean z = childAt == frameLayout;
                View childAt2 = frameLayout2.getChildAt(0);
                ((GradientDrawable) frameLayout2.getChildAt(1).getBackground()).setCornerRadius(z ? this.b.a(10.0f) : this.b.a(36.0f) / 2.0f);
                childAt2.setVisibility(z ? 0 : 4);
            }
        }
        zh.d = true;
        Runnable runnable2 = this.b.c;
        if (runnable2 != null) {
            runnable2.run();
        }
    }

    public final void a(List list, RadioGroup radioGroup, int i) {
        if (i < 0 || i >= list.size()) {
            return;
        }
        ac acVarA = ac.a();
        String str = ((String[]) list.get(i))[0];
        acVarA.getClass();
        ac.e().c(str);
        n6.a = null;
        n6.b = null;
        n6.c.clear();
        k();
        Runnable runnable = this.b.c;
        if (runnable != null) {
            runnable.run();
        }
    }
}
