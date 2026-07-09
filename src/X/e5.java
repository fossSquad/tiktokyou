package X;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import com.bytedance.ies.foundation.activity.BaseActivity;
import java.util.ArrayList;
import java.util.Collections;

public abstract class e5 {
    public static ArrayList a(Context context) {
        ActivityInfo[] activityInfoArr;
        ArrayList arrayList = new ArrayList();
        if (context == null) {
            return arrayList;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 513);
            if (packageInfo != null && (activityInfoArr = packageInfo.activities) != null) {
                for (ActivityInfo activityInfo : activityInfoArr) {
                    String str = activityInfo.name;
                    if (str != null && str.startsWith("com.windukk.mod.icon.")) {
                        arrayList.add(new d5(activityInfo.name.substring(21), new ComponentName(packageName, activityInfo.name), activityInfo.icon));
                    }
                }
            }
        } catch (Throwable th) {
            th.getMessage();
            int i = g5.a;
        }
        Collections.sort(arrayList, new c5());
        return arrayList;
    }

    public static String a() {
        String str = l8.a().s;
        if (str == null) {
            str = "default";
        }
        return str.isEmpty() ? "default" : str;
    }

    public static void a(Context context, String str) {
        Object obj;
        if (str == null) {
            return;
        }
        ArrayList arrayListA = a(context);
        if (arrayListA.isEmpty()) {
            return;
        }
        int size = arrayListA.size();
        int i = 0;
        int i2 = 0;
        do {
            if (i2 >= size) {
                str = "default";
                break;
            } else {
                obj = arrayListA.get(i2);
                i2++;
            }
        } while (!((d5) obj).a.equals(str));
        PackageManager packageManager = context.getPackageManager();
        int size2 = arrayListA.size();
        int i3 = 0;
        while (i3 < size2) {
            Object obj2 = arrayListA.get(i3);
            i3++;
            d5 d5Var = (d5) obj2;
            if (d5Var.a.equals(str)) {
                ComponentName componentName = d5Var.b;
                try {
                    packageManager.setComponentEnabledSetting(componentName, 1, 1);
                } catch (Throwable th) {
                    String.valueOf(componentName);
                    th.getMessage();
                    int i4 = g5.a;
                }
            }
        }
        int size3 = arrayListA.size();
        while (i < size3) {
            Object obj3 = arrayListA.get(i);
            i++;
            d5 d5Var2 = (d5) obj3;
            if (!d5Var2.a.equals(str)) {
                ComponentName componentName2 = d5Var2.b;
                try {
                    packageManager.setComponentEnabledSetting(componentName2, 2, 1);
                } catch (Throwable th2) {
                    String.valueOf(componentName2);
                    th2.getMessage();
                    int i5 = g5.a;
                }
            }
        }
        l8.a().a(str);
    }

    public static Drawable a(BaseActivity baseActivity, d5 d5Var) {
        if (d5Var == null) {
            return null;
        }
        PackageManager packageManager = baseActivity.getPackageManager();
        try {
            return packageManager.getActivityInfo(d5Var.b, 512).loadIcon(packageManager);
        } catch (Throwable th) {
            try {
                return packageManager.getApplicationIcon(baseActivity.getPackageName());
            } catch (Throwable th2) {
                return null;
            }
        }
    }

    public static String a(String str) {
        String[] strArrSplit = str.replace('-', '_').split("_");
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArrSplit) {
            if (!str2.isEmpty()) {
                if (sb.length() > 0) {
                    sb.append(' ');
                }
                sb.append(Character.toUpperCase(str2.charAt(0)));
                if (str2.length() > 1) {
                    sb.append(str2.substring(1));
                }
            }
        }
        return sb.length() == 0 ? str : sb.toString();
    }
}
