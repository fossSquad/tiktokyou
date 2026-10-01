package Z;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.os.Process;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import com.windukk.stable.DynamicStatus;
import com.windukk.stable.DynamicUpdates;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class gh extends Activity {
    public static final int i = Color.parseColor("#F5F5F5");
    public static final int j = Color.parseColor("#1E1E1E");
    public static final int k = Color.parseColor("#8A8A8E");
    public static final int l = Color.parseColor("#FE2C55");
    public static final Pattern m = Pattern.compile("Dynamic version (\\d+) is not newer than the accepted version (\\d+)");
    public boolean a;
    public int b;
    public int c;
    public FrameLayout d;
    public Uri e;
    public String f = "";
    public DynamicStatus g;
    public boolean h;

    public final void b() {
        final Uri uri;
        if (!this.h && (uri = this.e) != null) {
            this.h = true;
            a(this.g, l6.a("dynamic_import_progress_title"), l6.a("dynamic_import_progress_message"), false, 0);
            new Thread(new Runnable() {
                @Override
                public final void run() {
                    gh.this.b(uri);
                }
            }, "TTModTtyDynOpen").start();
        }
    }

    public final void a(Uri uri) {
         DynamicStatus status;
        try {
            status = DynamicUpdates.getStatus(this);
        } catch (Throwable th) {
            status = null;
        }
        if (!d(uri)) {
            b(status, l6.a("dynamic_import_error"), null, false);
            return;
        }
        this.g = status;
        try {
            DynamicUpdates.preview(this, uri);
        } catch (Throwable th2) {
            String message = th2.getMessage();
            if (message != null && (message.startsWith("Variant mismatch") || message.startsWith("Stable API mismatch") || message.startsWith("Dynamic version "))) {
                a(status, th2);
                return;
            }
        }
        final DynamicStatus statusF = status;
        runOnUiThread(new Runnable() {
            @Override
            public final void run() {
                gh.this.a(statusF);
            }
        });
    }

    public final boolean d(Uri uri) {
        String path;
        if (uri == null) {
            return false;
        }
        String str = this.f;
        if ((str == null || !str.toLowerCase(Locale.US).endsWith(".ttydyn")) && ((path = uri.getPath()) == null || !path.toLowerCase(Locale.US).endsWith(".ttydyn"))) {
            return getIntent() != null && getIntent().getBooleanExtra("fromSettings", false);
        }
        return true;
    }

    @Override

    public void onCreate(android.os.Bundle r11) {

        throw new UnsupportedOperationException("Method not decompiled: Z.gh.onCreate(android.os.Bundle):void");
    }

    public final  void a(DynamicStatus dynamicStatus) {
        if (isFinishing() || isDestroyed() || this.h) {
            return;
        }
        a(dynamicStatus, l6.a("dynamic_open_confirm_title"), l6.a("dynamic_open_confirm_message"), false, 1);
    }

    public final void a(DynamicStatus dynamicStatus, Throwable th) {
        String message = th.getMessage() != null ? th.getMessage() : th.toString();
        String strA = l6.a("dynamic_import_error");
        if (message.startsWith("Variant mismatch")) {
            strA = l6.a("dynamic_error_variant_title");
            message = a(message, "dynamic_error_variant", "dynamic_error_variant_plain");
        } else if (message.startsWith("Stable API mismatch")) {
            strA = l6.a("dynamic_error_api_title");
            message = a(message, "dynamic_error_api", "dynamic_error_api_plain");
        } else if (message.startsWith("Dynamic version ")) {
            Matcher matcher = m.matcher(message);
            if (matcher.find()) {
                strA = l6.a("dynamic_error_version_title");
                message = String.format(Locale.US, l6.a("dynamic_error_version"), matcher.group(1), matcher.group(2));
            }
        }
        b(dynamicStatus, strA, message, false);
    }

    public final void b(Uri uri) {
        DynamicStatus status = this.g;
        DynamicStatus status2 = null;
        if (status == null) {
            try {
                status = DynamicUpdates.getStatus(this);
            } catch (Throwable th) {
                status = null;
            }
        }
        if (!d(uri)) {
            b(status, l6.a("dynamic_import_error"), null, false);
            return;
        }
        try {
            DynamicUpdates.importFile(this, uri);
            DynamicStatus status3 = DynamicUpdates.getStatus(this);
            if (status3.pendingSha256 != null) {
                b(status3, l6.a("ota_ready_title"), l6.a("dynamic_open_ready"), true);
                return;
            }
            throw new IllegalStateException("Dynamic package was not committed to the pending slot");
        } catch (Throwable th2) {
            try {
                status2 = DynamicUpdates.getStatus(this);
            } catch (Throwable th3) {
            }
            if (status2 != null) {
                status = status2;
            }
            a(status, th2);
        }
    }

    public static String a(String str, String str2, String str3) {
        int iIndexOf = str.indexOf("expected ");
        int iIndexOf2 = str.indexOf(", package is ");
        if (iIndexOf >= 0 && iIndexOf2 > iIndexOf) {
            return String.format(Locale.US, l6.a(str2), str.substring("expected ".length() + iIndexOf, iIndexOf2), str.substring(", package is ".length() + iIndexOf2).trim());
        }
        return l6.a(str3);
    }

    public final void b(final DynamicStatus dynamicStatus, final String str, final String str2, final boolean z) {
        runOnUiThread(new Runnable() {
            @Override
            public final void run() {
                gh.this.a(dynamicStatus, str, str2, z);
            }
        });
    }

    public final  void b(View view) {
        b();
    }

    public final  void a(DynamicStatus dynamicStatus, String str, String str2, boolean z) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        a(dynamicStatus, str, str2, z, 2);
    }

    public final void a(DynamicStatus dynamicStatus, String str, String str2, final boolean z, int i2) {
        int iA = 0;
        int i3;
        LinearLayout linearLayout;
        int i4;
        int i5;
        int i6;
        int i7;
        String str3;
        String strA;
        long j2;
        String str4;
        long j3;
        String str5;
        long j4;
        ProgressBar progressBar;
        int i8;
        this.d.removeAllViews();
        ScrollView scrollView = new ScrollView(this);
        scrollView.setVerticalScrollBarEnabled(false);
        int i9 = this.c;
        if (i2 != 1) {
            if (i2 == 2) {
                i3 = 96;
            } else {
                iA = a(28);
            }
            scrollView.setPadding(a(16), a(12) + this.b, a(16), i9 + iA);
            scrollView.setClipToPadding(false);
            linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(1);
            scrollView.addView(linearLayout);
            this.d.addView(scrollView, new FrameLayout.LayoutParams(-1, -1));
            String strDecrypt = "TikTok You";
            i4 = k;
            linearLayout.addView(a(strDecrypt, 13, i4, false));
            String strA2 = l6.a("dynamic_screen_title");
            if (this.a) {
                i5 = -1;
            } else {
                i5 = -16777216;
            }
            View viewA = a(strA2, 28, i5, true);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = a(6);
            linearLayout.addView(viewA, layoutParams);
            if (this.a) {
                i6 = -1;
            } else {
                i6 = -16777216;
            }
            View viewA2 = a(str, 16, i6, true);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = a(18);
            linearLayout.addView(viewA2, layoutParams2);
            if (str2 != null && !str2.isEmpty()) {
                if (i2 == 2 || z) {
                    i8 = i4;
                } else {
                    i8 = l;
                }
                TextView textViewA = a(str2, 15, i8, false);
                textViewA.setLineSpacing(a(2), 1.0f);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams3.topMargin = a(6);
                linearLayout.addView(textViewA, layoutParams3);
            }
            if (!this.f.isEmpty()) {
                View viewA3 = a(this.f, 13, i4, false);
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams4.topMargin = a(8);
                linearLayout.addView(viewA3, layoutParams4);
            }
            if (i2 == 0) {
                progressBar = new ProgressBar(this);
                if (progressBar.getIndeterminateDrawable() != null) {
                    progressBar.getIndeterminateDrawable().setColorFilter(l, PorterDuff.Mode.SRC_IN);
                }
                LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(a(28), a(28));
                layoutParams5.topMargin = a(18);
                linearLayout.addView(progressBar, layoutParams5);
            }
            if (dynamicStatus == null || i2 != 0) {
                LinearLayout linearLayout2 = new LinearLayout(this);
                linearLayout2.setOrientation(1);
                GradientDrawable gradientDrawable = new GradientDrawable();
                if (this.a) {
                    i7 = j;
                } else {
                    i7 = -1;
                }
                gradientDrawable.setColor(i7);
                gradientDrawable.setCornerRadius(a(12));
                linearLayout2.setBackground(gradientDrawable);
                linearLayout2.setPadding(a(16), a(4), a(16), a(4));
                String strA3 = l6.a("dynamic_slot_running");
                if (dynamicStatus == null) {
                    strA = l6.a("dynamic_slot_none");
                } else {
                    str3 = dynamicStatus.activeSha256;
                    if (str3 != null) {
                        strA = a(dynamicStatus.activeVersion, str3);
                    } else {
                        strA = a(dynamicStatus.bundledVersion, dynamicStatus.bundledSha256);
                    }
                }
                a(linearLayout2, strA3, strA, false);
                String strA4 = l6.a("dynamic_slot_pending");
                if (dynamicStatus == null) {
                    j2 = 0;
                } else {
                    j2 = dynamicStatus.pendingVersion;
                }
                if (dynamicStatus == null) {
                    str4 = null;
                } else {
                    str4 = dynamicStatus.pendingSha256;
                }
                a(linearLayout2, strA4, a(j2, str4), true);
                String strA5 = l6.a("dynamic_slot_previous");
                if (dynamicStatus == null) {
                    j3 = 0;
                } else {
                    j3 = dynamicStatus.previousVersion;
                }
                if (dynamicStatus == null) {
                    str5 = null;
                } else {
                    str5 = dynamicStatus.previousSha256;
                }
                a(linearLayout2, strA5, a(j3, str5), true);
                String strA6 = l6.a("dynamic_slot_bundled");
                if (dynamicStatus == null) {
                    j4 = 0;
                } else {
                    j4 = dynamicStatus.bundledVersion;
                }
                a(linearLayout2, strA6, a(j4, dynamicStatus != null ? dynamicStatus.bundledSha256 : null), true);
                LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams6.topMargin = a(22);
                linearLayout.addView(linearLayout2, layoutParams6);
            }
            if (i2 == 1) {
                if (i2 == 2) {
                    TextView textViewA2 = a(l6.a("ota_ready_button"), 16, -1, true);
                    textViewA2.setGravity(17);
                    GradientDrawable gradientDrawable2 = new GradientDrawable();
                    gradientDrawable2.setColor(l);
                    gradientDrawable2.setCornerRadius(a(14));
                    GradientDrawable gradientDrawable3 = new GradientDrawable();
                    gradientDrawable3.setCornerRadius(a(14));
                    gradientDrawable3.setColor(-1);
                    textViewA2.setBackground(new RippleDrawable(ColorStateList.valueOf(872415231), gradientDrawable2, gradientDrawable3));
                    textViewA2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public final void onClick(View view) {
                            gh.this.a(z, view);
                        }
                    });
                    int iA2 = a(52);
                    int iA3 = a(16) + this.c;
                    FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(-1, iA2);
                    layoutParams7.gravity = 80;
                    layoutParams7.leftMargin = a(16);
                    layoutParams7.rightMargin = a(16);
                    layoutParams7.bottomMargin = iA3;
                    this.d.addView(textViewA2, layoutParams7);
                    return;
                }
                return;
            }
            TextView textViewA3 = a(l6.a("dynamic_open_install"), 16, -1, true);
            textViewA3.setGravity(17);
            GradientDrawable gradientDrawable4 = new GradientDrawable();
            gradientDrawable4.setColor(l);
            gradientDrawable4.setCornerRadius(a(14));
            GradientDrawable gradientDrawable5 = new GradientDrawable();
            gradientDrawable5.setCornerRadius(a(14));
            gradientDrawable5.setColor(-1);
            textViewA3.setBackground(new RippleDrawable(ColorStateList.valueOf(872415231), gradientDrawable4, gradientDrawable5));
            textViewA3.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    gh.this.b(view);
                }
            });
            int iA4 = a(52);
            int iA5 = a(72) + this.c;
            FrameLayout.LayoutParams layoutParams8 = new FrameLayout.LayoutParams(-1, iA4);
            layoutParams8.gravity = 80;
            layoutParams8.leftMargin = a(16);
            layoutParams8.rightMargin = a(16);
            layoutParams8.bottomMargin = iA5;
            this.d.addView(textViewA3, layoutParams8);
            TextView textViewA4 = a();
            int iA6 = a(48);
            int iA7 = a(16) + this.c;
            FrameLayout.LayoutParams layoutParams9 = new FrameLayout.LayoutParams(-1, iA6);
            layoutParams9.gravity = 80;
            layoutParams9.leftMargin = a(16);
            layoutParams9.rightMargin = a(16);
            layoutParams9.bottomMargin = iA7;
            this.d.addView(textViewA4, layoutParams9);
        }
        i3 = 148;
        iA = a(i3);
        scrollView.setPadding(a(16), a(12) + this.b, a(16), i9 + iA);
        scrollView.setClipToPadding(false);
        linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        scrollView.addView(linearLayout);
        this.d.addView(scrollView, new FrameLayout.LayoutParams(-1, -1));
        String strDecrypt2 = "TikTok You";
        i4 = k;
        linearLayout.addView(a(strDecrypt2, 13, i4, false));
        String strA7 = l6.a("dynamic_screen_title");
        if (this.a) {
            i5 = -1;
        } else {
            i5 = -16777216;
        }
        View viewA4 = a(strA7, 28, i5, true);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams10.topMargin = a(6);
        linearLayout.addView(viewA4, layoutParams10);
        if (this.a) {
            i6 = -1;
        } else {
            i6 = -16777216;
        }
        View viewA5 = a(str, 16, i6, true);
        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams11.topMargin = a(18);
        linearLayout.addView(viewA5, layoutParams11);
        if (str2 != null) {
            if (i2 == 2) {
                i8 = i4;
            } else {
                i8 = i4;
            }
            TextView textViewA5 = a(str2, 15, i8, false);
            textViewA5.setLineSpacing(a(2), 1.0f);
            LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams12.topMargin = a(6);
            linearLayout.addView(textViewA5, layoutParams12);
        }
        if (!this.f.isEmpty()) {
            View viewA6 = a(this.f, 13, i4, false);
            LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams13.topMargin = a(8);
            linearLayout.addView(viewA6, layoutParams13);
        }
        if (i2 == 0) {
            progressBar = new ProgressBar(this);
            if (progressBar.getIndeterminateDrawable() != null) {
                progressBar.getIndeterminateDrawable().setColorFilter(l, PorterDuff.Mode.SRC_IN);
            }
            LinearLayout.LayoutParams layoutParams14 = new LinearLayout.LayoutParams(a(28), a(28));
            layoutParams14.topMargin = a(18);
            linearLayout.addView(progressBar, layoutParams14);
        }
        if (dynamicStatus == null) {
            LinearLayout linearLayout3 = new LinearLayout(this);
            linearLayout3.setOrientation(1);
            GradientDrawable gradientDrawable6 = new GradientDrawable();
            if (this.a) {
                i7 = j;
            } else {
                i7 = -1;
            }
            gradientDrawable6.setColor(i7);
            gradientDrawable6.setCornerRadius(a(12));
            linearLayout3.setBackground(gradientDrawable6);
            linearLayout3.setPadding(a(16), a(4), a(16), a(4));
            String strA8 = l6.a("dynamic_slot_running");
            if (dynamicStatus == null) {
                strA = l6.a("dynamic_slot_none");
            } else {
                str3 = dynamicStatus.activeSha256;
                if (str3 != null) {
                    strA = a(dynamicStatus.activeVersion, str3);
                } else {
                    strA = a(dynamicStatus.bundledVersion, dynamicStatus.bundledSha256);
                }
            }
            a(linearLayout3, strA8, strA, false);
            String strA9 = l6.a("dynamic_slot_pending");
            if (dynamicStatus == null) {
                j2 = 0;
            } else {
                j2 = dynamicStatus.pendingVersion;
            }
            if (dynamicStatus == null) {
                str4 = null;
            } else {
                str4 = dynamicStatus.pendingSha256;
            }
            a(linearLayout3, strA9, a(j2, str4), true);
            String strA10 = l6.a("dynamic_slot_previous");
            if (dynamicStatus == null) {
                j3 = 0;
            } else {
                j3 = dynamicStatus.previousVersion;
            }
            if (dynamicStatus == null) {
                str5 = null;
            } else {
                str5 = dynamicStatus.previousSha256;
            }
            a(linearLayout3, strA10, a(j3, str5), true);
            String strA11 = l6.a("dynamic_slot_bundled");
            if (dynamicStatus == null) {
                j4 = 0;
            } else {
                j4 = dynamicStatus.bundledVersion;
            }
            a(linearLayout3, strA11, a(j4, dynamicStatus != null ? dynamicStatus.bundledSha256 : null), true);
            LinearLayout.LayoutParams layoutParams15 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams15.topMargin = a(22);
            linearLayout.addView(linearLayout3, layoutParams15);
        } else {
            LinearLayout linearLayout4 = new LinearLayout(this);
            linearLayout4.setOrientation(1);
            GradientDrawable gradientDrawable7 = new GradientDrawable();
            if (this.a) {
                i7 = j;
            } else {
                i7 = -1;
            }
            gradientDrawable7.setColor(i7);
            gradientDrawable7.setCornerRadius(a(12));
            linearLayout4.setBackground(gradientDrawable7);
            linearLayout4.setPadding(a(16), a(4), a(16), a(4));
            String strA12 = l6.a("dynamic_slot_running");
            if (dynamicStatus == null) {
                strA = l6.a("dynamic_slot_none");
            } else {
                str3 = dynamicStatus.activeSha256;
                if (str3 != null) {
                    strA = a(dynamicStatus.activeVersion, str3);
                } else {
                    strA = a(dynamicStatus.bundledVersion, dynamicStatus.bundledSha256);
                }
            }
            a(linearLayout4, strA12, strA, false);
            String strA13 = l6.a("dynamic_slot_pending");
            if (dynamicStatus == null) {
                j2 = 0;
            } else {
                j2 = dynamicStatus.pendingVersion;
            }
            if (dynamicStatus == null) {
                str4 = null;
            } else {
                str4 = dynamicStatus.pendingSha256;
            }
            a(linearLayout4, strA13, a(j2, str4), true);
            String strA14 = l6.a("dynamic_slot_previous");
            if (dynamicStatus == null) {
                j3 = 0;
            } else {
                j3 = dynamicStatus.previousVersion;
            }
            if (dynamicStatus == null) {
                str5 = null;
            } else {
                str5 = dynamicStatus.previousSha256;
            }
            a(linearLayout4, strA14, a(j3, str5), true);
            String strA15 = l6.a("dynamic_slot_bundled");
            if (dynamicStatus == null) {
                j4 = 0;
            } else {
                j4 = dynamicStatus.bundledVersion;
            }
            a(linearLayout4, strA15, a(j4, dynamicStatus != null ? dynamicStatus.bundledSha256 : null), true);
            LinearLayout.LayoutParams layoutParams16 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams16.topMargin = a(22);
            linearLayout.addView(linearLayout4, layoutParams16);
        }
        if (i2 == 1) {
            if (i2 == 2) {
                TextView textViewA6 = a(l6.a("ota_ready_button"), 16, -1, true);
                textViewA6.setGravity(17);
                GradientDrawable gradientDrawable8 = new GradientDrawable();
                gradientDrawable8.setColor(l);
                gradientDrawable8.setCornerRadius(a(14));
                GradientDrawable gradientDrawable9 = new GradientDrawable();
                gradientDrawable9.setCornerRadius(a(14));
                gradientDrawable9.setColor(-1);
                textViewA6.setBackground(new RippleDrawable(ColorStateList.valueOf(872415231), gradientDrawable8, gradientDrawable9));
                textViewA6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public final void onClick(View view) {
                        gh.this.a(z, view);
                    }
                });
                int iA8 = a(52);
                int iA9 = a(16) + this.c;
                FrameLayout.LayoutParams layoutParams17 = new FrameLayout.LayoutParams(-1, iA8);
                layoutParams17.gravity = 80;
                layoutParams17.leftMargin = a(16);
                layoutParams17.rightMargin = a(16);
                layoutParams17.bottomMargin = iA9;
                this.d.addView(textViewA6, layoutParams17);
                return;
            }
            return;
        }
        TextView textViewA7 = a(l6.a("dynamic_open_install"), 16, -1, true);
        textViewA7.setGravity(17);
        GradientDrawable gradientDrawable10 = new GradientDrawable();
        gradientDrawable10.setColor(l);
        gradientDrawable10.setCornerRadius(a(14));
        GradientDrawable gradientDrawable11 = new GradientDrawable();
        gradientDrawable11.setCornerRadius(a(14));
        gradientDrawable11.setColor(-1);
        textViewA7.setBackground(new RippleDrawable(ColorStateList.valueOf(872415231), gradientDrawable10, gradientDrawable11));
        textViewA7.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                gh.this.b(view);
            }
        });
        int iA10 = a(52);
        int iA11 = a(72) + this.c;
        FrameLayout.LayoutParams layoutParams18 = new FrameLayout.LayoutParams(-1, iA10);
        layoutParams18.gravity = 80;
        layoutParams18.leftMargin = a(16);
        layoutParams18.rightMargin = a(16);
        layoutParams18.bottomMargin = iA11;
        this.d.addView(textViewA7, layoutParams18);
        TextView textViewA8 = a();
        int iA12 = a(48);
        int iA13 = a(16) + this.c;
        FrameLayout.LayoutParams layoutParams19 = new FrameLayout.LayoutParams(-1, iA12);
        layoutParams19.gravity = 80;
        layoutParams19.leftMargin = a(16);
        layoutParams19.rightMargin = a(16);
        layoutParams19.bottomMargin = iA13;
        this.d.addView(textViewA8, layoutParams19);
    }

    public final TextView a() {
        TextView textViewA = a(l6.a("ota_ready_button"), 16, this.a ? -1 : -16777216, true);
        textViewA.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(a(14));
        gradientDrawable.setColor(-1);
        textViewA.setBackground(new RippleDrawable(ColorStateList.valueOf(this.a ? 872415231 : 520093696), null, gradientDrawable));
        textViewA.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                gh.this.a(view);
            }
        });
        return textViewA;
    }

    public final  void a(View view) {
        finish();
    }

    public static String a(long j2, String str) {
        if (str == null && j2 <= 0) {
            return l6.a("dynamic_slot_none");
        }
        String strSubstring = str == null ? "" : str.substring(0, Math.min(12, str.length()));
        if (j2 <= 0 || strSubstring.isEmpty()) {
            return j2 > 0 ? "v" + j2 : strSubstring;
        }
        return new StringBuilder("v").append(j2).append(" · ").append(strSubstring).toString();
    }

    public final void a(LinearLayout linearLayout, String str, String str2, boolean z) {
        String str3;
        String str4;
        if (z) {
            View view = new View(this);
            view.setBackgroundColor(Color.parseColor((this.a ? "#2C2C2E" : "#EEEEEE")));
            linearLayout.addView(view, new LinearLayout.LayoutParams(-1, Math.max(1, a(1) / 2)));
        }
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        linearLayout2.setMinimumHeight(a(52));
        linearLayout2.addView(a(str, 16, this.a ? -1 : -16777216, true), new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView textViewA = a(str2, 14, k, false);
        textViewA.setGravity(8388613);
        textViewA.setMaxLines(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = a(12);
        linearLayout2.addView(textViewA, layoutParams);
        linearLayout.addView(linearLayout2);
    }

    public final TextView a(String str, int i2, int i3, boolean z) {
        Typeface typefaceCreate;
        TextView textView = new TextView(this);
        textView.setText(str);
        textView.setTextSize(2, i2);
        textView.setTextColor(i3);
        if (z) {
            typefaceCreate = Typeface.create("sans-serif-medium", 1);
        } else {
            typefaceCreate = Typeface.create("sans-serif", 0);
        }
        textView.setTypeface(typefaceCreate);
        return textView;
    }

    public final void a(boolean z, View view) {
        if (z) {
            finishAffinity();
            Process.killProcess(Process.myPid());
        } else {
            finish();
        }
    }

    public final int a(int i2) {
        return Math.round(i2 * getResources().getDisplayMetrics().density);
    }
}
