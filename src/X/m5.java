package X;

import android.R;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.ss.android.ugc.aweme.setting.ui.SettingContainerActivity;
import de.robv.android.xposed.XC_MethodHook;

class m5 extends XC_MethodHook {

    public static  void a(SettingContainerActivity settingContainerActivity, View view) {
        settingContainerActivity.startActivity(new Intent(settingContainerActivity.peekAvailableContext(), (Class<?>) a4.class));
    }

    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        final SettingContainerActivity settingContainerActivity = (SettingContainerActivity) methodHookParam.thisObject;
        ViewGroup viewGroup = (ViewGroup) settingContainerActivity.findViewById(R.id.content);
        if (viewGroup != null && viewGroup.findViewWithTag("ttmod_settings_button_container") == null) {
            boolean z = (settingContainerActivity.getResources().getConfiguration().uiMode & 48) == 32;
            FrameLayout frameLayout = new FrameLayout(settingContainerActivity.peekAvailableContext());
            frameLayout.setTag("ttmod_settings_button_container");
            frameLayout.setBackgroundColor(z ? -16777216 : Color.parseColor("#FFF5F5F5"));
            int iApplyDimension = (int) TypedValue.applyDimension(1, 48.0f, p2.b().getResources().getDisplayMetrics());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 8388693;
            TextView textView = new TextView(settingContainerActivity.peekAvailableContext());
            textView.setText(o2.a().a("settings_title"));
            textView.setTextSize(2, 14.0f);
            textView.setTextColor(-1);
            textView.setGravity(17);
            textView.setTypeface(Typeface.create("sans-serif-medium", 0));
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(102.0f);
            gradientDrawable.setColor(-119980);
            textView.setBackground(gradientDrawable);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, iApplyDimension);
            layoutParams2.setMargins((int) TypedValue.applyDimension(1, 24.0f, p2.b().getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, 8.0f, p2.b().getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, 24.0f, p2.b().getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, 8.0f, p2.b().getResources().getDisplayMetrics()));
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    m5.a(settingContainerActivity, view);
                }
            });
            frameLayout.addView(textView, layoutParams2);
            viewGroup.addView(frameLayout, layoutParams);
            frameLayout.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                @Override
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return m5.a(view, windowInsets);
                }
            });
            frameLayout.requestApplyInsets();
        }
    }

    public static  WindowInsets a(View view, WindowInsets windowInsets) {
        view.setPadding(0, 0, 0, windowInsets != null ? windowInsets.getSystemWindowInsetBottom() : 0);
        return windowInsets;
    }
}
