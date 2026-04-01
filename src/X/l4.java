package X;

import android.R;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.ss.android.ugc.aweme.setting.ui.SettingContainerActivity;
import de.robv.android.xposed.XC_MethodHook;

class l4 extends XC_MethodHook {

    public static  void a(SettingContainerActivity settingContainerActivity, View view) {
        settingContainerActivity.startActivity(new Intent(settingContainerActivity.peekAvailableContext(), (Class<?>) z2.class));
    }

    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        final SettingContainerActivity settingContainerActivity = (SettingContainerActivity) methodHookParam.thisObject;
        ViewGroup viewGroup = (ViewGroup) settingContainerActivity.findViewById(R.id.content);
        if (viewGroup == null) {
            return;
        }
        boolean z = (settingContainerActivity.getResources().getConfiguration().uiMode & 48) == 32;
        FrameLayout frameLayout = new FrameLayout(settingContainerActivity.peekAvailableContext());
        frameLayout.setBackgroundColor(z ? -16777216 : Color.parseColor("#FFF5F5F5"));
        int iA = r1.a(72.0f);
        int iA2 = r1.a(48.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, iA);
        layoutParams.gravity = 8388693;
        TextView textView = new TextView(settingContainerActivity.peekAvailableContext());
        textView.setText(q1.a().a("settings_title"));
        textView.setTextSize(2, 14.0f);
        textView.setTextColor(-1);
        textView.setGravity(17);
        textView.setTypeface(Typeface.create("sans-serif-medium", 0));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(102.0f);
        gradientDrawable.setColor(-119980);
        textView.setBackground(gradientDrawable);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, iA2);
        layoutParams2.setMargins(r1.a(24.0f), r1.a(8.0f), r1.a(24.0f), r1.a(8.0f));
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                l4.a(settingContainerActivity, view);
            }
        });
        frameLayout.addView(textView, layoutParams2);
        viewGroup.addView(frameLayout, layoutParams);
    }
}
