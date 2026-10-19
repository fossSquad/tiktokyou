package Z;

import android.content.SharedPreferences;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public final class bc {
    public static final int I;
    public LinkedHashSet A;
    public long B;
    public long C;
    public long D;
    public boolean E;
    public boolean F;
    public long G;
    public boolean H;
    public final SharedPreferences a;
    public int b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public String n;
    public String o;
    public boolean p;
    public boolean q;
    public int r;
    public int s;
    public boolean t;
    public int u;
    public int v;
    public String w;
    public boolean x;
    public String y;
    public boolean z;

    static {
        int i = 0;
        while (true) {
            te[] teVarArr = ue.a;
            if (i >= 191) {
                i = -1;
                break;
            } else if (teVarArr[i].d.equalsIgnoreCase("kz")) {
                break;
            } else {
                i++;
            }
        }
        I = i >= 0 ? i : 0;
    }

    public bc(SharedPreferences sharedPreferences) {
        this.a = sharedPreferences;
        a();
    }

    public final void a() {
        te teVar;
        this.a.getBoolean("region_spoof_enabled", true);
        String string = this.a.getString("selected_region_iso", null);
        int i = -1;
        if (string != null) {
            int i2 = 0;
            while (true) {
                te[] teVarArr = ue.a;
                if (i2 >= 191) {
                    break;
                }
                if (teVarArr[i2].d.equalsIgnoreCase(string)) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (i < 0) {
                i = I;
            }
        } else if (this.a.contains("selected_region")) {
            int i3 = this.a.getInt("selected_region", I);
            if (i3 >= 138) {
                i3++;
            }
            te[] teVarArr2 = ue.a;
            int i4 = 0;
            while (true) {
                if (i4 >= 191) {
                    teVar = null;
                    break;
                }
                teVar = teVarArr2[i4];
                if (teVar.a == i3) {
                    break;
                } else {
                    i4++;
                }
            }
            if (teVar != null) {
                String str = teVar.d;
                int i5 = 0;
                while (true) {
                    te[] teVarArr3 = ue.a;
                    if (i5 >= 191) {
                        break;
                    }
                    if (teVarArr3[i5].d.equalsIgnoreCase(str)) {
                        i = i5;
                        break;
                    }
                    i5++;
                }
            }
            if (i < 0) {
                i = I;
            }
            this.a.edit().putInt("selected_region", i).putString("selected_region_iso", ue.a[i].d).apply();
        } else {
            i = I;
        }
        this.b = i;
        this.c = this.a.getBoolean("hide_lives", false);
        this.d = this.a.getBoolean("hide_ads", true);
        this.e = this.a.getBoolean("hide_photos", false);
        this.f = this.a.getBoolean("anti_burnout", false);
        this.g = this.a.getBoolean("anti_burnout_show_on_main", true);
        this.h = this.a.getBoolean("anti_burnout_enable_on_start", false);
        this.i = this.a.getBoolean("anti_burnout_hide_system_bars", false);
        this.j = this.a.getBoolean("hide_stories", false);
        this.a.getBoolean("hide_series", false);
        this.a.getBoolean("hide_paid", false);
        this.k = this.a.getBoolean("simple_mode", false);
        this.l = this.a.getBoolean("ui_hide_enabled", false);
        this.m = this.a.getBoolean("ui_hide_edit_mode", false);
        this.n = this.a.getString("ui_hide_rules", "[]");
        this.o = this.a.getString("selected_font", "default");
        this.p = this.a.getBoolean("always_show_progress_bar", false);
        this.q = this.a.getBoolean("custom_colors_enabled", false);
        this.r = this.a.getInt("accent_color", 0);
        int i6 = 100;
        int i7 = this.a.getInt("feed_overlay_transparency", 100);
        if (i7 < 0) {
            i6 = 0;
        } else if (i7 <= 100) {
            i6 = i7;
        }
        this.s = i6;
        this.a.getBoolean("comment_translation_enabled", false);
        this.t = this.a.getBoolean("auto_streak_nudge_enabled", true);
        int i8 = 12;
        int i9 = this.a.getInt("auto_streak_nudge_hour", 12);
        if (i9 >= 0 && i9 <= 23) {
            i8 = i9;
        }
        this.u = i8;
        int i10 = this.a.getInt("auto_streak_nudge_minute", 0);
        if (i10 < 0 || i10 > 59) {
            i10 = 0;
        }
        this.v = i10;
        this.w = this.a.getString("auto_streak_nudge_last_run_date", "");
        this.x = this.a.getBoolean("rainbow_mode_enabled", false);
        this.y = this.a.getString("launcher_icon", "default");
        this.z = this.a.getBoolean("skip_quality_picker", false);
        this.a.getString("spoofed_device_id", null);
        this.a.getString("random_android_id", null);
        this.A = new LinkedHashSet(this.a.getStringSet("hide_by_words_filter", Collections.EMPTY_SET));
        this.B = this.a.getLong("hide_by_likes", 0L);
        this.C = this.a.getLong("hide_by_views", 0L);
        this.D = this.a.getLong("hide_by_publish_date", 0L);
        this.E = this.a.getBoolean("statistics_enable", false);
        this.F = this.a.getBoolean("auto_updates_enable", true);
        this.G = this.a.getLong("update_notice_snooze_until", 0L);
        this.H = this.a.getBoolean("startup_consent_accepted", false);
    }

    public final void b(boolean z) {
        this.h = z;
        this.a.edit().putBoolean("anti_burnout_enable_on_start", z).apply();
    }

    public final void c(int i) {
        if (i < 0 || i >= 191) {
            i = I;
        }
        this.b = i;
        this.a.edit().putInt("selected_region", i).putString("selected_region_iso", ue.a[i].d).apply();
    }

    public final void d(boolean z) {
        this.i = z;
        this.a.edit().putBoolean("anti_burnout_hide_system_bars", z).apply();
    }

    public final void e(boolean z) {
        this.F = z;
        this.a.edit().putBoolean("auto_updates_enable", this.F).apply();
    }

    public final void f(boolean z) {
        this.q = z;
        this.a.edit().putBoolean("custom_colors_enabled", z).apply();
    }

    public final void g(boolean z) {
        this.d = z;
        this.a.edit().putBoolean("hide_ads", z).apply();
    }

    public final void h(boolean z) {
        this.c = z;
        this.a.edit().putBoolean("hide_lives", z).apply();
    }

    public final void i(boolean z) {
        this.e = z;
        this.a.edit().putBoolean("hide_photos", z).apply();
    }

    public final void j(boolean z) {
        this.j = z;
        this.a.edit().putBoolean("hide_stories", z).apply();
    }

    public final void k(boolean z) {
        this.k = z;
        this.a.edit().putBoolean("simple_mode", z).apply();
    }

    public final void l(boolean z) {
        this.z = z;
        this.a.edit().putBoolean("skip_quality_picker", z).apply();
    }

    public final void m(boolean z) {
        this.E = z;
        this.a.edit().putBoolean("statistics_enable", this.E).apply();
    }

    public final void n(boolean z) {
        this.m = z;
        this.a.edit().putBoolean("ui_hide_edit_mode", z).apply();
    }

    public final void o(boolean z) {
        this.l = z;
        this.a.edit().putBoolean("ui_hide_enabled", z).apply();
    }

    public final void b(int i) {
        if (i < 0) {
            i = 0;
        } else if (i > 100) {
            i = 100;
        }
        this.s = i;
        this.a.edit().putInt("feed_overlay_transparency", this.s).apply();
    }

    public final void d(String str) {
        if (str == null) {
            str = "[]";
        }
        this.n = str;
        this.a.edit().putString("ui_hide_rules", this.n).apply();
    }

    public final void b(String str) {
        if (str.isEmpty()) {
            str = "default";
        }
        this.y = str;
        this.a.edit().putString("launcher_icon", this.y).apply();
    }

    public final void d(long j) {
        this.G = j;
        this.a.edit().putLong("update_notice_snooze_until", this.G).apply();
    }

    public final void b(long j) {
        this.D = j;
        this.a.edit().putLong("hide_by_publish_date", this.D).apply();
    }

    public final void c(boolean z) {
        this.f = z;
        this.a.edit().putBoolean("anti_burnout", z).apply();
    }

    public final void b() {
        this.H = true;
        this.a.edit().putBoolean("startup_consent_accepted", this.H).apply();
    }

    public final void c(String str) {
        this.o = str;
        this.a.edit().putString("selected_font", str).apply();
    }

    public final void c(long j) {
        this.C = j;
        this.a.edit().putLong("hide_by_views", this.C).apply();
    }

    public final void a(boolean z) {
        this.p = z;
        this.a.edit().putBoolean("always_show_progress_bar", z).apply();
    }

    public final void a(int i) {
        this.r = i;
        this.a.edit().putInt("accent_color", i).apply();
    }

    public final void a(int i, int i2) {
        if (i < 0 || i > 23) {
            i = 12;
        }
        this.u = i;
        if (i2 < 0 || i2 > 59) {
            i2 = 0;
        }
        this.v = i2;
        this.a.edit().putInt("auto_streak_nudge_hour", this.u).putInt("auto_streak_nudge_minute", this.v).apply();
    }

    public final void a(String str) {
        if (str == null) {
            str = "";
        }
        this.w = str;
        this.a.edit().putString("auto_streak_nudge_last_run_date", this.w).apply();
    }

    public final void a(Set set) {
        this.A = new LinkedHashSet(set);
        this.a.edit().putStringSet("hide_by_words_filter", new HashSet(this.A)).apply();
    }

    public final void a(long j) {
        this.B = j;
        this.a.edit().putLong("hide_by_likes", this.B).apply();
    }
}
