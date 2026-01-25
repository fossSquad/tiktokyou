package com.windukk.mod;

import android.R;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Space;
import android.widget.TextView;
import com.bytedance.ies.foundation.activity.BaseActivity;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

public class SettingsActivity extends BaseActivity {
    private static final int COLOR_DARK_BG = -16777216;
    private static final int COLOR_LIGHT_CARD = -1;
    private static final int POSITION_BOTTOM = 1;
    private static final int POSITION_MIDDLE = 3;
    private static final int POSITION_SINGLE = 2;
    private static final int POSITION_TOP = 0;
    private View bulletinView;
    private boolean darkMode;
    private int navBarHeight;
    private FrameLayout rootLayout;
    private int statusBarHeight;
    private static final int COLOR_LIGHT_BG = Color.parseColor("#F5F5F5");
    private static final int COLOR_DARK_CARD = Color.parseColor("#1E1E1E");
    private static final int COLOR_SUBTITLE = Color.parseColor("#858585");
    private static final int COLOR_SECTION = Color.parseColor("#888888");
    private static final int COLOR_ARROW = Color.parseColor("#777778");

    interface OnToggleListener {
        void onToggle(boolean z);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ModSettings.init(this);
        this.darkMode = isDarkMode();
        this.statusBarHeight = getStatusBarHeight();
        this.navBarHeight = getNavigationBarHeight();
        setTransparentBars();
        setContentView(buildUI());
    }

    private View buildUI() {
        this.rootLayout = new FrameLayout(this);
        this.rootLayout.setTag("ModSettingsView");
        this.rootLayout.setClickable(true);
        this.rootLayout.setFocusableInTouchMode(true);
        this.rootLayout.setBackgroundColor(this.darkMode ? COLOR_DARK_BG : COLOR_LIGHT_BG);
        ScrollView scrollView = createScrollView();
        LinearLayout content = createContentLayout();
        scrollView.addView(content);
        this.rootLayout.addView(scrollView, new FrameLayout.LayoutParams(COLOR_LIGHT_CARD, COLOR_LIGHT_CARD));
        TextView largeTitle = createLargeTitle();
        addHeader(this.rootLayout, scrollView, largeTitle);
        addBackButton(this.rootLayout);
        populateContent(content, largeTitle);
        return this.rootLayout;
    }

    private ScrollView createScrollView() {
        ScrollView scrollView = new ScrollView(this);
        scrollView.setVerticalScrollBarEnabled(false);
        scrollView.setPadding(0, dp(56.0f) + this.statusBarHeight, 0, this.navBarHeight);
        scrollView.setClipToPadding(false);
        return scrollView;
    }

    private LinearLayout createContentLayout() {
        LinearLayout content = new LinearLayout(this);
        content.setOrientation(POSITION_BOTTOM);
        content.setPadding(dp(8.0f), 0, dp(8.0f), dp(20.0f) + this.navBarHeight);
        return content;
    }

    private void addHeader(FrameLayout root, final ScrollView scrollView, final TextView largeTitle) {
        View headerBg = new View(this);
        headerBg.setBackgroundColor(this.darkMode ? COLOR_DARK_BG : COLOR_LIGHT_BG);
        FrameLayout.LayoutParams headerParams = new FrameLayout.LayoutParams(COLOR_LIGHT_CARD, dp(56.0f) + this.statusBarHeight);
        headerParams.gravity = 48;
        root.addView(headerBg, headerParams);
        final TextView smallTitle = createSmallTitle();
        root.addView(smallTitle);
        scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public final void onScrollChanged() {
                SettingsActivity.lambda$addHeader$0(largeTitle, scrollView, smallTitle);
            }
        });
    }

    static  void lambda$addHeader$0(TextView largeTitle, ScrollView scrollView, TextView smallTitle) {
        int largeTitleBottom = largeTitle.getTop() + largeTitle.getHeight();
        boolean showSmallTitle = scrollView.getScrollY() >= largeTitleBottom;
        smallTitle.setVisibility(showSmallTitle ? 0 : 4);
    }

    private TextView createSmallTitle() {
        TextView tv = new TextView(this);
        tv.setText(Localization.get().getString("settings_title"));
        tv.setTextSize(POSITION_SINGLE, 16.0f);
        tv.setTypeface(Typeface.create("sans-serif", POSITION_BOTTOM));
        tv.setTextColor(this.darkMode ? COLOR_LIGHT_CARD : COLOR_DARK_BG);
        tv.setVisibility(4);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-2, -2);
        params.gravity = 49;
        params.topMargin = dp(16.0f) + this.statusBarHeight;
        tv.setLayoutParams(params);
        return tv;
    }

    private void addBackButton(FrameLayout root) {
        ImageView backIcon = new ImageView(this);
        backIcon.setImageBitmap(loadIcon("ic_back"));
        backIcon.setColorFilter(this.darkMode ? COLOR_LIGHT_CARD : COLOR_DARK_BG, PorterDuff.Mode.SRC_IN);
        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                this.f$0.lambda$addBackButton$1(view);
            }
        });
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(dp(24.0f), dp(24.0f));
        params.leftMargin = dp(16.0f);
        params.topMargin = dp(16.0f) + this.statusBarHeight;
        params.gravity = 51;
        root.addView(backIcon, params);
        backIcon.bringToFront();
    }

    public  void lambda$addBackButton$1(View v) {
        finish();
    }

    private void populateContent(LinearLayout content, TextView largeTitle) {
        content.addView(largeTitle);
        content.addView(createSettingsItem("ic_telegram", Localization.get().getString("telegram_channel"), null, "https://t.me/tikyoutok", POSITION_SINGLE));
        content.addView(createSectionTitle(Localization.get().getString("section_region")));
        content.addView(createRegionCard());
        content.addView(createSectionTitle(Localization.get().getString("section_feed")));
        content.addView(createFeedCard());
        if (Build.VERSION.SDK_INT >= 31) {
            content.addView(createSectionTitle(Localization.get().getString("section_other")));
            content.addView(createOtherCard());
        }
        content.addView(createSectionTitle(Localization.get().getString("section_about")));
        content.addView(createAboutGroup());
        Space space = new Space(this);
        content.addView(space, new LinearLayout.LayoutParams(COLOR_LIGHT_CARD, dp(20.0f)));
    }

    private TextView createLargeTitle() {
        TextView tv = new TextView(this);
        tv.setText(Localization.get().getString("settings_title"));
        tv.setTextSize(POSITION_SINGLE, 28.0f);
        tv.setTextColor(this.darkMode ? COLOR_LIGHT_CARD : COLOR_DARK_BG);
        tv.setTypeface(Typeface.create("sans-serif-medium", POSITION_BOTTOM));
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-2, -2);
        params.leftMargin = dp(16.0f);
        params.topMargin = dp(8.0f);
        params.bottomMargin = dp(22.0f);
        tv.setLayoutParams(params);
        return tv;
    }

    private ViewGroup createRegionCard() {
        ViewGroup card = createCardContainer();
        card.setPadding(dp(16.0f), dp(4.0f), dp(16.0f), dp(4.0f));
        RadioGroup rg = new RadioGroup(this);
        rg.setTag("RegionRadioGroup");
        rg.setOrientation(POSITION_BOTTOM);
        for (int i = 0; i < RegionData.REGIONS.length; i += POSITION_BOTTOM) {
            RegionData.Region region = RegionData.REGIONS[i];
            rg.addView(createRadioItem(region.getLocalizedName(), region.stringId, i));
        }
        rg.check(ModSettings.get().getSelectedRegion());
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
                this.f$0.lambda$createRegionCard$2(radioGroup, i2);
            }
        });
        card.addView(rg);
        return card;
    }

    public  void lambda$createRegionCard$2(RadioGroup group, int checkedId) {
        ModSettings.get().setSelectedRegion(checkedId);
        showBulletin();
    }

    private ViewGroup createOtherCard() {
        ViewGroup card = createCardContainer();
        card.setPadding(dp(16.0f), dp(4.0f), dp(16.0f), dp(4.0f));
        String string = Localization.get().getString("system_colors");
        boolean zIsSystemColorsEnabled = ModSettings.get().isSystemColorsEnabled();
        final ModSettings modSettings = ModSettings.get();
        modSettings.getClass();
        card.addView(createCheckItem(string, "ic_risovalca", zIsSystemColorsEnabled, new OnToggleListener() {
            @Override
            public final void onToggle(boolean z) {
                modSettings.setSystemColorsEnabled(z);
            }
        }));
        return card;
    }

    private ViewGroup createFeedCard() {
        ViewGroup card = createCardContainer();
        card.setPadding(dp(16.0f), dp(4.0f), dp(16.0f), dp(4.0f));
        String string = Localization.get().getString("hide_lives");
        boolean zIsHideLivesEnabled = ModSettings.get().isHideLivesEnabled();
        final ModSettings modSettings = ModSettings.get();
        modSettings.getClass();
        card.addView(createCheckItem(string, "ic_live", zIsHideLivesEnabled, new OnToggleListener() {
            @Override
            public final void onToggle(boolean z) {
                modSettings.setHideLivesEnabled(z);
            }
        }));
        String string2 = Localization.get().getString("hide_ads");
        boolean zIsHideAdsEnabled = ModSettings.get().isHideAdsEnabled();
        final ModSettings modSettings2 = ModSettings.get();
        modSettings2.getClass();
        card.addView(createCheckItem(string2, "ic_ads", zIsHideAdsEnabled, new OnToggleListener() {
            @Override
            public final void onToggle(boolean z) {
                modSettings2.setHideAdsEnabled(z);
            }
        }));
        String string3 = Localization.get().getString("hide_photos");
        boolean zIsHidePhotosEnabled = ModSettings.get().isHidePhotosEnabled();
        final ModSettings modSettings3 = ModSettings.get();
        modSettings3.getClass();
        card.addView(createCheckItem(string3, "ic_photo_disable", zIsHidePhotosEnabled, new OnToggleListener() {
            @Override
            public final void onToggle(boolean z) {
                modSettings3.setHidePhotosEnabled(z);
            }
        }));
        return card;
    }

    private LinearLayout createAboutGroup() {
        LinearLayout group = new LinearLayout(this);
        group.setOrientation(POSITION_BOTTOM);
        group.addView(createSettingsItem("ic_mod_logo", "TikTok You", Localization.get().getString("mod_version"), null, 0));
        group.addView(createSettingsItem("ic_document", Localization.get().getString("privacy_information"), Localization.get().getString("privacy_information_legal"), "https://telegra.ph/Pravovaya-informaciya-i-usloviya-ispolzovaniya-12-29", POSITION_BOTTOM));
        return group;
    }

    private View createSettingsItem(String iconName, String title, String subtitle, final String url, int position) {
        FrameLayout frameLayout = new FrameLayout(this);
        int verticalPadding = dp(subtitle != null ? 12.0f : 14.0f);
        frameLayout.setPadding(0, verticalPadding, 0, verticalPadding);
        frameLayout.setBackground(createRoundedBackground(position));
        if (url != null) {
            frameLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    this.f$0.lambda$createSettingsItem$3(url, view);
                }
            });
        }
        ImageView icon = new ImageView(this);
        icon.setImageBitmap(loadIcon(iconName));
        FrameLayout.LayoutParams iconParams = new FrameLayout.LayoutParams(dp(20.0f), dp(20.0f));
        iconParams.leftMargin = dp(16.0f);
        iconParams.gravity = 19;
        frameLayout.addView(icon, iconParams);
        LinearLayout textLayout = new LinearLayout(this);
        textLayout.setOrientation(POSITION_BOTTOM);
        TextView tvTitle = new TextView(this);
        tvTitle.setText(title);
        tvTitle.setTextSize(POSITION_SINGLE, 16.0f);
        tvTitle.setTextColor(this.darkMode ? COLOR_LIGHT_CARD : COLOR_DARK_BG);
        tvTitle.setTypeface(Typeface.create("sans-serif-medium", 0));
        textLayout.addView(tvTitle);
        if (subtitle != null) {
            TextView tvSub = new TextView(this);
            tvSub.setText(subtitle);
            tvSub.setTextSize(POSITION_SINGLE, 14.0f);
            tvSub.setTextColor(COLOR_SUBTITLE);
            LinearLayout.LayoutParams subParams = new LinearLayout.LayoutParams(-2, -2);
            subParams.topMargin = dp(4.0f);
            textLayout.addView(tvSub, subParams);
        }
        FrameLayout.LayoutParams textParams = new FrameLayout.LayoutParams(-2, -2);
        textParams.leftMargin = dp(48.0f);
        textParams.gravity = 19;
        frameLayout.addView(textLayout, textParams);
        if (url != null) {
            ImageView arrow = new ImageView(this);
            arrow.setImageBitmap(loadIcon("ic_arrow_right"));
            arrow.setColorFilter(COLOR_ARROW);
            FrameLayout.LayoutParams arrowParams = new FrameLayout.LayoutParams(dp(20.0f), dp(20.0f));
            arrowParams.rightMargin = dp(16.0f);
            arrowParams.gravity = 21;
            frameLayout.addView(arrow, arrowParams);
        }
        return frameLayout;
    }

    public  void lambda$createSettingsItem$3(String url, View v) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
    }

    private View createSectionTitle(String text) {
        TextView tv = new TextView(this);
        tv.setText(text);
        tv.setTextSize(POSITION_SINGLE, 14.0f);
        tv.setTextColor(COLOR_SECTION);
        tv.setTypeface(Typeface.create("sans-serif-medium", 0));
        tv.setPadding(dp(28.0f), dp(16.0f), 0, dp(12.0f));
        return tv;
    }

    private View createCheckItem(String text, String iconName, boolean initialChecked, final OnToggleListener listener) throws IllegalAccessException, InvocationTargetException {
        CheckBox cb = new CheckBox(this);
        cb.setSaveEnabled(false);
        cb.setText(text);
        cb.setTextSize(POSITION_SINGLE, 16.0f);
        cb.setTypeface(Typeface.create("sans-serif-medium", 0));
        cb.setMinHeight(dp(48.0f));
        cb.setTextColor(this.darkMode ? COLOR_LIGHT_CARD : COLOR_DARK_BG);
        cb.setButtonDrawable((Drawable) null);
        cb.setBackground(null);
        StateListDrawable checkDrawable = new StateListDrawable();
        checkDrawable.addState(new int[]{R.attr.state_checked}, createDrawableFromAsset("ic_check_active"));
        checkDrawable.addState(new int[0], createDrawableFromAsset("ic_check_inactive"));
        Drawable icon = createDrawableFromAsset(iconName);
        int iconSize = dp(20.0f);
        int checkSize = dp(18.0f);
        if (icon != null) {
            icon.setBounds(0, 0, iconSize, iconSize);
        }
        checkDrawable.setBounds(0, 0, checkSize, checkSize);
        cb.setCompoundDrawables(icon, null, checkDrawable, null);
        cb.setCompoundDrawablePadding(dp(12.0f));
        cb.setLayoutParams(new LinearLayout.LayoutParams(COLOR_LIGHT_CARD, -2));
        cb.setChecked(initialChecked);
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.f$0.lambda$createCheckItem$4(listener, compoundButton, z);
            }
        });
        return cb;
    }

    public  void lambda$createCheckItem$4(OnToggleListener listener, CompoundButton buttonView, boolean isChecked) {
        if (listener != null) {
            listener.onToggle(isChecked);
        }
        showBulletin();
    }

    private View createRadioItem(String text, String stringId, int id) throws IllegalAccessException, InvocationTargetException {
        RadioButton rb = new RadioButton(this);
        if (id != COLOR_LIGHT_CARD) {
            rb.setId(id);
        }
        rb.setSaveEnabled(false);
        rb.setText(text);
        rb.setTextSize(POSITION_SINGLE, 16.0f);
        rb.setTypeface(Typeface.create("sans-serif-medium", 0));
        rb.setMinHeight(dp(48.0f));
        rb.setTextColor(this.darkMode ? COLOR_LIGHT_CARD : COLOR_DARK_BG);
        rb.setButtonDrawable((Drawable) null);
        rb.setBackground(null);
        StateListDrawable radioDrawable = new StateListDrawable();
        radioDrawable.addState(new int[]{R.attr.state_checked}, createDrawableFromAsset("ic_radio_active"));
        radioDrawable.addState(new int[0], createDrawableFromAsset("ic_radio_inactive"));
        Drawable flag = getFlagIcon(stringId);
        int iconSize = dp(20.0f);
        if (flag != null) {
            flag.setBounds(0, 0, iconSize, iconSize);
        }
        radioDrawable.setBounds(0, 0, iconSize, iconSize);
        rb.setCompoundDrawables(flag, null, radioDrawable, null);
        rb.setCompoundDrawablePadding(dp(12.0f));
        rb.setLayoutParams(new LinearLayout.LayoutParams(COLOR_LIGHT_CARD, -2));
        return rb;
    }

    private int dp(float dp) {
        return (int) TypedValue.applyDimension(POSITION_BOTTOM, dp, getResources().getDisplayMetrics());
    }

    private int getStatusBarHeight() {
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            return getResources().getDimensionPixelSize(resourceId);
        }
        return 0;
    }

    private int getNavigationBarHeight() {
        int resourceId = getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0) {
            return getResources().getDimensionPixelSize(resourceId);
        }
        return 0;
    }

    private boolean isDarkMode() {
        int uiMode = getResources().getConfiguration().uiMode;
        return (uiMode & 48) == 32;
    }

    private void setTransparentBars() {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
            window.setNavigationBarColor(0);
            int flags = 1792;
            if (Build.VERSION.SDK_INT >= 23 && !this.darkMode) {
                flags = 1792 | 8192;
            }
            if (Build.VERSION.SDK_INT >= 26 && !this.darkMode) {
                flags |= 16;
            }
            window.getDecorView().setSystemUiVisibility(flags);
        }
    }

    private ViewGroup createCardContainer() {
        LinearLayout container = new LinearLayout(this);
        container.setOrientation(POSITION_BOTTOM);
        GradientDrawable bg = new GradientDrawable();
        bg.setColor(this.darkMode ? COLOR_DARK_CARD : COLOR_LIGHT_CARD);
        bg.setCornerRadius(dp(12.0f));
        container.setBackground(bg);
        return container;
    }

    private GradientDrawable createRoundedBackground(int position) {
        float[] radii;
        GradientDrawable bg = new GradientDrawable();
        bg.setColor(this.darkMode ? COLOR_DARK_CARD : COLOR_LIGHT_CARD);
        float r = dp(8.0f);
        switch (position) {
            case 0:
                radii = new float[]{r, r, r, r, 0.0f, 0.0f, 0.0f, 0.0f};
                break;
            case POSITION_BOTTOM /* 1 */:
                radii = new float[]{0.0f, 0.0f, 0.0f, 0.0f, r, r, r, r};
                break;
            case POSITION_SINGLE /* 2 */:
                radii = new float[]{r, r, r, r, r, r, r, r};
                break;
            default:
                radii = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                break;
        }
        bg.setCornerRadii(radii);
        return bg;
    }

    private Bitmap loadIcon(String iconName) throws IllegalAccessException, InvocationTargetException {
        try {
            InputStream is = getAssets().open("mod_icons/" + iconName + ".png");
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(is);
                if (is != null) {
                    is.close();
                }
                return bitmapDecodeStream;
            } catch (Throwable th) {
                if (is != null) {
                    try {
                        is.close();
                    } catch (Throwable th2) {
                        Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                    }
                }
                throw th;
            }
        } catch (IOException e) {
            return null;
        }
    }

    private Drawable createDrawableFromAsset(String assetName) throws IllegalAccessException, InvocationTargetException {
        Bitmap bmp = loadIcon(assetName);
        if (bmp != null) {
            return new BitmapDrawable(getResources(), bmp);
        }
        return null;
    }

    private Drawable getFlagIcon(String stringId) throws IllegalAccessException, InvocationTargetException {
        String iconName;
        switch (stringId) {
            case "region_usa":
                iconName = "ic_flag_usa";
                break;
            case "region_poland":
                iconName = "ic_flag_poland";
                break;
            case "region_kazakhstan":
                iconName = "ic_flag_kazakhstan";
                break;
            case "region_belarus":
                iconName = "ic_flag_belarus";
                break;
            case "region_egypt":
                iconName = "ic_flag_egypt";
                break;
            case "region_finland":
                iconName = "ic_flag_finland";
                break;
            default:
                iconName = "ic_flag_custom";
                break;
        }
        Bitmap bmp = loadIcon(iconName);
        if (bmp != null) {
            int size = dp(20.0f);
            return new BitmapDrawable(getResources(), getCircularBitmap(bmp, size));
        }
        return createStubFlag();
    }

    private Bitmap getCircularBitmap(Bitmap bitmap, int size) {
        Bitmap scaled = Bitmap.createScaledBitmap(bitmap, size, size, true);
        Bitmap output = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.drawCircle(size / 2.0f, size / 2.0f, size / 2.0f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(scaled, 0.0f, 0.0f, paint);
        return output;
    }

    private Drawable createStubFlag() {
        int size = dp(20.0f);
        GradientDrawable stub = new GradientDrawable();
        stub.setShape(POSITION_BOTTOM);
        stub.setColor(Color.parseColor("#444444"));
        stub.setSize(size, size);
        return stub;
    }

    private void showBulletin() {
        if (this.bulletinView != null) {
            return;
        }
        this.bulletinView = createBulletin();
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(COLOR_LIGHT_CARD, -2);
        params.gravity = 80;
        params.setMargins(dp(8.0f), 0, dp(8.0f), this.navBarHeight + dp(16.0f));
        this.bulletinView.setTranslationY(dp(100.0f));
        this.bulletinView.setAlpha(0.0f);
        this.rootLayout.addView(this.bulletinView, params);
        ObjectAnimator slideUp = ObjectAnimator.ofFloat(this.bulletinView, "translationY", dp(100.0f), 0.0f);
        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(this.bulletinView, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(slideUp, fadeIn);
        animatorSet.setDuration(300L);
        animatorSet.start();
    }

    private void restartApp() {
        Intent intent = getPackageManager().getLaunchIntentForPackage(getPackageName());
        if (intent != null) {
            intent.addFlags(335544320);
            startActivity(intent);
        }
        Runtime.getRuntime().exit(0);
    }

    private View createBulletin() {
        FrameLayout frameLayout = new FrameLayout(this);
        int paddingH = dp(16.0f);
        int paddingV = dp(16.0f);
        frameLayout.setPadding(paddingH, paddingV, paddingH, paddingV);
        GradientDrawable bg = new GradientDrawable();
        bg.setColor(this.darkMode ? COLOR_LIGHT_CARD : Color.parseColor("#1E1E1E"));
        bg.setCornerRadius(dp(8.0f));
        frameLayout.setBackground(bg);
        FrameLayout.LayoutParams containerParams = new FrameLayout.LayoutParams(COLOR_LIGHT_CARD, -2);
        containerParams.setMargins(dp(8.0f), 0, dp(8.0f), 0);
        frameLayout.setLayoutParams(containerParams);
        TextView btnRestart = new TextView(this);
        String btnText = Localization.get().getString("bulletin_button");
        btnRestart.setText(btnText);
        btnRestart.setTextColor(COLOR_LIGHT_CARD);
        btnRestart.setTextSize(POSITION_SINGLE, 14.0f);
        btnRestart.setTypeface(Typeface.create("sans-serif-medium", 0));
        btnRestart.setGravity(17);
        btnRestart.setPadding(dp(20.0f), 0, dp(20.0f), 0);
        GradientDrawable btnBg = new GradientDrawable();
        btnBg.setColor(Color.parseColor("#FE2B54"));
        btnBg.setCornerRadius(dp(68.0f));
        btnRestart.setBackground(btnBg);
        Paint paint = new Paint();
        paint.setTextSize(TypedValue.applyDimension(POSITION_SINGLE, 14.0f, getResources().getDisplayMetrics()));
        int btnTextWidth = (int) paint.measureText(btnText);
        int btnTotalWidth = dp(40.0f) + btnTextWidth + dp(16.0f);
        LinearLayout textLayout = new LinearLayout(this);
        textLayout.setOrientation(POSITION_BOTTOM);
        TextView tvTitle = new TextView(this);
        tvTitle.setText(Localization.get().getString("bulletin_title"));
        tvTitle.setTextSize(POSITION_SINGLE, 14.0f);
        tvTitle.setTextColor(this.darkMode ? COLOR_DARK_BG : COLOR_LIGHT_CARD);
        tvTitle.setTypeface(Typeface.create("sans-serif-medium", POSITION_BOTTOM));
        textLayout.addView(tvTitle);
        TextView tvSub = new TextView(this);
        tvSub.setText(Localization.get().getString("bulletin_subtitle"));
        tvSub.setTextSize(POSITION_SINGLE, 12.0f);
        tvSub.setTextColor(Color.parseColor("#838383"));
        LinearLayout.LayoutParams subParams = new LinearLayout.LayoutParams(-2, -2);
        subParams.topMargin = dp(2.0f);
        textLayout.addView(tvSub, subParams);
        FrameLayout.LayoutParams textParams = new FrameLayout.LayoutParams(COLOR_LIGHT_CARD, -2);
        textParams.gravity = 19;
        textParams.rightMargin = btnTotalWidth;
        frameLayout.addView(textLayout, textParams);
        FrameLayout.LayoutParams btnParams = new FrameLayout.LayoutParams(-2, dp(36.0f));
        btnParams.gravity = 21;
        frameLayout.addView(btnRestart, btnParams);
        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                this.f$0.lambda$createBulletin$5(view);
            }
        });
        return frameLayout;
    }

    public  void lambda$createBulletin$5(View v) {
        restartApp();
    }
}
