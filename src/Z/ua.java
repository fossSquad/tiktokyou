package Z;

import android.content.SharedPreferences;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public final class ua {
    public static final int C;
    public boolean A;
    public boolean B;
    public final SharedPreferences a;
    public int b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public String j;
    public boolean k;
    public boolean l;
    public int m;
    public int n;
    public boolean o;
    public int p;
    public int q;
    public String r;
    public final boolean s;
    public String t;
    public boolean u;
    public LinkedHashSet v;
    public long w;
    public long x;
    public long y;
    public boolean z;

    static {
        int i = 0;
        while (true) {
            ed[] edVarArr = fd.a;
            if (i >= 191) {
                i = -1;
                break;
            } else if (edVarArr[i].d.equalsIgnoreCase("kz")) {
                break;
            } else {
                i++;
            }
        }
        C = i >= 0 ? i : 0;
    }

    public ua(SharedPreferences sharedPreferences) {
        ed edVar;
        this.a = sharedPreferences;
        sharedPreferences.getBoolean("region_spoof_enabled", true);
        String string = sharedPreferences.getString("selected_region_iso", null);
        int i = -1;
        if (string != null) {
            int i2 = 0;
            while (true) {
                ed[] edVarArr = fd.a;
                if (i2 >= 191) {
                    break;
                }
                if (edVarArr[i2].d.equalsIgnoreCase(string)) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (i < 0) {
                i = C;
            }
        } else if (sharedPreferences.contains("selected_region")) {
            int i3 = sharedPreferences.getInt("selected_region", C);
            i3 = i3 >= 138 ? i3 + 1 : i3;
            ed[] edVarArr2 = fd.a;
            int i4 = 0;
            while (true) {
                if (i4 >= 191) {
                    edVar = null;
                    break;
                }
                edVar = edVarArr2[i4];
                if (edVar.a == i3) {
                    break;
                } else {
                    i4++;
                }
            }
            if (edVar != null) {
                String str = edVar.d;
                int i5 = 0;
                while (true) {
                    ed[] edVarArr3 = fd.a;
                    if (i5 >= 191) {
                        break;
                    }
                    if (edVarArr3[i5].d.equalsIgnoreCase(str)) {
                        i = i5;
                        break;
                    }
                    i5++;
                }
            }
            i = i < 0 ? C : i;
            this.a.edit().putInt("selected_region", i).putString("selected_region_iso", fd.a[i].d).apply();
        } else {
            i = C;
        }
        this.b = i;
        this.c = this.a.getBoolean("hide_lives", false);
        this.d = this.a.getBoolean("hide_ads", true);
        this.e = this.a.getBoolean("hide_photos", false);
        this.f = this.a.getBoolean("anti_burnout", false);
        this.g = this.a.getBoolean("anti_burnout_show_on_main", true);
        this.h = this.a.getBoolean("anti_burnout_enable_on_start", false);
        this.i = this.a.getBoolean("hide_stories", false);
        this.a.getBoolean("hide_series", false);
        this.a.getBoolean("hide_paid", false);
        this.j = this.a.getString("selected_font", "default");
        this.k = this.a.getBoolean("always_show_progress_bar", false);
        this.l = this.a.getBoolean("custom_colors_enabled", false);
        this.m = this.a.getInt("accent_color", 0);
        int i6 = 100;
        int i7 = this.a.getInt("feed_overlay_transparency", 100);
        if (i7 < 0) {
            i6 = 0;
        } else if (i7 <= 100) {
            i6 = i7;
        }
        this.n = i6;
        this.a.getBoolean("comment_translation_enabled", false);
        this.o = this.a.getBoolean("auto_streak_nudge_enabled", true);
        int i8 = 12;
        int i9 = this.a.getInt("auto_streak_nudge_hour", 12);
        if (i9 >= 0 && i9 <= 23) {
            i8 = i9;
        }
        this.p = i8;
        int i10 = this.a.getInt("auto_streak_nudge_minute", 0);
        this.q = (i10 < 0 || i10 > 59) ? 0 : i10;
        this.r = this.a.getString("auto_streak_nudge_last_run_date", "");
        this.s = this.a.getBoolean("rainbow_mode_enabled", false);
        this.t = this.a.getString("launcher_icon", "default");
        this.u = this.a.getBoolean("skip_quality_picker", false);
        this.a.getString("spoofed_device_id", null);
        this.a.getString("random_android_id", null);
        this.v = new LinkedHashSet(this.a.getStringSet("hide_by_words_filter", Collections.EMPTY_SET));
        this.w = this.a.getLong("hide_by_likes", 0L);
        this.x = this.a.getLong("hide_by_views", 0L);
        this.y = this.a.getLong("hide_by_publish_date", 0L);
        this.z = this.a.getBoolean("statistics_enable", false);
        this.A = this.a.getBoolean("auto_updates_enable", true);
        this.B = this.a.getBoolean("startup_consent_accepted", false);
    }

    public final void a(boolean z) {
        this.k = z;
        this.a.edit().putBoolean("always_show_progress_bar", z).apply();
    }

    public final void b(boolean z) {
        this.h = z;
        this.a.edit().putBoolean("anti_burnout_enable_on_start", z).apply();
    }

    public final void c(int i) {
        if (i < 0 || i >= 191) {
            i = C;
        }
        this.b = i;
        this.a.edit().putInt("selected_region", i).putString("selected_region_iso", fd.a[i].d).apply();
    }

    public final void d(boolean z) {
        this.g = z;
        this.a.edit().putBoolean("anti_burnout_show_on_main", z).apply();
    }

    public final void e(boolean z) {
        this.o = z;
        this.a.edit().putBoolean("auto_streak_nudge_enabled", z).apply();
    }

    public final void f(boolean z) {
        this.A = z;
        this.a.edit().putBoolean("auto_updates_enable", this.A).apply();
    }

    public final void g(boolean z) {
        this.l = z;
        this.a.edit().putBoolean("custom_colors_enabled", z).apply();
    }

    public final void h(boolean z) {
        this.d = z;
        this.a.edit().putBoolean("hide_ads", z).apply();
    }

    public final void i(boolean z) {
        this.c = z;
        this.a.edit().putBoolean("hide_lives", z).apply();
    }

    public final void j(boolean z) {
        this.e = z;
        this.a.edit().putBoolean("hide_photos", z).apply();
    }

    public final void k(boolean z) {
        this.i = z;
        this.a.edit().putBoolean("hide_stories", z).apply();
    }

    public final void m(boolean z) {
        this.u = z;
        this.a.edit().putBoolean("skip_quality_picker", z).apply();
    }

    public final void n(boolean z) {
        this.z = z;
        this.a.edit().putBoolean("statistics_enable", this.z).apply();
    }

    public final void a(int i) {
        this.m = i;
        this.a.edit().putInt("accent_color", i).apply();
    }

    public final void b(int i) {
        if (i < 0) {
            i = 0;
        } else if (i > 100) {
            i = 100;
        }
        this.n = i;
        this.a.edit().putInt("feed_overlay_transparency", this.n).apply();
    }

    public final void a(int i, int i2) {
        if (i < 0 || i > 23) {
            i = 12;
        }
        this.p = i;
        if (i2 < 0 || i2 > 59) {
            i2 = 0;
        }
        this.q = i2;
        this.a.edit().putInt("auto_streak_nudge_hour", this.p).putInt("auto_streak_nudge_minute", this.q).apply();
    }

    public final void b(String str) {
        if (str.isEmpty()) {
            str = "default";
        }
        this.t = str;
        this.a.edit().putString("launcher_icon", this.t).apply();
    }

    public final void b(long j) {
        this.y = j;
        this.a.edit().putLong("hide_by_publish_date", this.y).apply();
    }

    public final void c(boolean z) {
        this.f = z;
        this.a.edit().putBoolean("anti_burnout", z).apply();
    }

    public final void c(String str) {
        this.j = str;
        this.a.edit().putString("selected_font", str).apply();
    }

    public final void a(String str) {
        if (str == null) {
            str = "";
        }
        this.r = str;
        this.a.edit().putString("auto_streak_nudge_last_run_date", this.r).apply();
    }

    public final void c(long j) {
        this.x = j;
        this.a.edit().putLong("hide_by_views", this.x).apply();
    }

    public final void a(Set set) {
        this.v = new LinkedHashSet(set);
        this.a.edit().putStringSet("hide_by_words_filter", new HashSet(this.v)).apply();
    }

    public final void a(long j) {
        this.w = j;
        this.a.edit().putLong("hide_by_likes", this.w).apply();
    }

    public final void a() {
        this.B = true;
        this.a.edit().putBoolean("startup_consent_accepted", this.B).apply();
    }
}
