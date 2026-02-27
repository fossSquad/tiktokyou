package X;

import android.content.SharedPreferences;

public final class r0 {
    public static SharedPreferences k;
    public static r0 l;
    public boolean a = k.getBoolean("region_spoof_enabled", true);
    public int b = k.getInt("selected_region", 0);
    public boolean c = k.getBoolean("hide_lives", false);
    public boolean d = k.getBoolean("hide_ads", true);
    public boolean e = k.getBoolean("hide_photos", false);
    public boolean f = k.getBoolean("hide_stories", false);
    public String g = k.getString("selected_font", "default");
    public boolean h = k.getBoolean("always_show_progress_bar", false);
    public boolean i = k.getBoolean("custom_colors_enabled", false);
    public int j = k.getInt("accent_color", 0);

    public r0() {
        k.getInt("feed_overlay_opacity", 100);
    }

    public static r0 a() {
        return l;
    }

    public final void b(int i) {
        this.b = i;
        k.edit().putInt("selected_region", i).apply();
    }

    public final void c(boolean z) {
        this.d = z;
        k.edit().putBoolean("hide_ads", z).apply();
    }

    public final void d(boolean z) {
        this.c = z;
        k.edit().putBoolean("hide_lives", z).apply();
    }

    public final void e(boolean z) {
        this.e = z;
        k.edit().putBoolean("hide_photos", z).apply();
    }

    public final void f(boolean z) {
        this.f = z;
        k.edit().putBoolean("hide_stories", z).apply();
    }

    public final void g(boolean z) {
        this.a = z;
        k.edit().putBoolean("region_spoof_enabled", z).apply();
    }

    public final void a(String str) {
        this.g = str;
        k.edit().putString("selected_font", str).apply();
    }

    public final x0 b() {
        int i = this.b;
        if (i >= 0) {
            x0[] x0VarArr = y0.a;
            if (i < 6) {
                return x0VarArr[i];
            }
        }
        return y0.a[0];
    }

    public boolean c() {
        return this.i;
    }

    public final void a(boolean z) {
        this.h = z;
        k.edit().putBoolean("always_show_progress_bar", z).apply();
    }

    public final void a(int i) {
        this.j = i;
        k.edit().putInt("accent_color", i).apply();
    }

    public final void b(boolean z) {
        this.i = z;
        k.edit().putBoolean("custom_colors_enabled", z).apply();
    }
}
