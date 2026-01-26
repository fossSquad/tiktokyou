package com.windukk.mod;

import android.R;
import android.app.Notification;
import android.app.NotificationChannel;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.telephony.CellInfo;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.ss.android.ugc.aweme.app.host.AwemeHostApplication;
import com.ss.android.ugc.aweme.base.model.UrlModel;
import com.ss.android.ugc.aweme.feed.model.ACLCommonShare;
import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.ss.android.ugc.aweme.feed.model.FeedItemList;
import com.ss.android.ugc.aweme.feed.model.PhotoModeImageUrlModel;
import com.ss.android.ugc.aweme.feed.model.Video;
import com.ss.android.ugc.aweme.feed.model.VideoUrlModel;
import com.ss.android.ugc.aweme.setting.ui.SettingContainerActivity;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class Main {
    public static final String LOG_TAG = "TikTokMod";
    public static final String PASHALKA = "Добро пожаловать в основой класс мода. Кто прочитал тот лох). БЕБЕБЕБЕБЕБЕБЕБЕБЕББЕБЕБЕБЕБЕБЕБЕБЕБЕБЕБЕБЕБЕБЕБЕБЕБЕБЕБЕБЕБЕ";
    public static AwemeHostApplication mainApplication;
    private static final ArrayList<XC_MethodHook.Unhook> hooks = new ArrayList<>();
    public static int versionCode = 0;
    private static Uri customSoundUri = null;

    private static void addAllHooks(XC_MethodHook.Unhook... hooksToAdd) {
        hooks.addAll(Arrays.asList(hooksToAdd));
    }

    @SafeVarargs
    private static void addAllHooks(Set<XC_MethodHook.Unhook>... hooksToAdd) {
        for (Set<XC_MethodHook.Unhook> set : hooksToAdd) {
            hooks.addAll(set);
        }
    }

    public static Context getApplicationContext() {
        return mainApplication.getApplicationContext();
    }

    public static void log(String fmt, Object... args) {
        Log.d(LOG_TAG, String.format(fmt, args));
    }

    public static boolean shouldFilterAweme(Aweme aweme) {
        boolean isAdContent = aweme.isAd() || aweme.getIsAdFiled() || aweme.getAwemeRawAd() != null;
        return (isAdContent && ModSettings.get().isHideAdsEnabled()) || (aweme.isLive() && ModSettings.get().isHideLivesEnabled()) || (aweme.isPhotoMode() && ModSettings.get().isHidePhotosEnabled());
    }

    public static int dp(float px) {
        return (int) TypedValue.applyDimension(1, px, getApplicationContext().getResources().getDisplayMetrics());
    }

    public static Uri getCustomSoundUri() {
        if (customSoundUri != null) {
            return customSoundUri;
        }
        Context context = getApplicationContext();
        if (context != null) {
            try {
                File soundFile = new File(context.getCacheDir(), "tiktok_customized_tone.mp3");
                if (!soundFile.exists()) {
                    InputStream is = context.getAssets().open("tiktok_customized_tone.mp3");
                    try {
                        FileOutputStream fos = new FileOutputStream(soundFile);
                        try {
                            byte[] buffer = new byte[4096];
                            while (true) {
                                int read = is.read(buffer);
                                if (read == -1) {
                                    break;
                                }
                                fos.write(buffer, 0, read);
                                if (is != null) {
                                    try {
                                        is.close();
                                    } catch (Throwable th) {
                                        Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th);
                                    }
                                }
                                throw th;
                            }
                            fos.close();
                            if (is != null) {
                                is.close();
                            }
                        } catch (Throwable th2) {
                            try {
                                fos.close();
                            } catch (Throwable th3) {
                                Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th2, th3);
                            }
                            throw th2;
                        }
                    } catch (Throwable th4) {
                        if (is != null) {
                            is.close();
                        }
                        throw th4;
                    }
                }
                customSoundUri = Uri.fromFile(soundFile);
                return customSoundUri;
            } catch (Exception e) {
                log("getCustomSoundUri: %s", e.getMessage());
                return null;
            }
        }
        return null;
    }

    public static void start(AwemeHostApplication application) {
        mainApplication = application;
        try {
            versionCode = application.getPackageManager().getPackageInfo(application.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            versionCode = 0;
        }
        ModSettings.init(application.getApplicationContext());
        Localization.init();
        try {
            addAllHooks(XposedBridge.hookMethod(TelephonyManager.class.getMethod("getSimCountryIso", new Class[0]), new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) {
                    if (ModSettings.get().isRegionSpoofEnabled()) {
                        param.setResult(ModSettings.get().getCurrentRegion().countryIso);
                    }
                }
            }), XposedBridge.hookMethod(TelephonyManager.class.getMethod("getNetworkCountryIso", new Class[0]), new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) {
                    if (ModSettings.get().isRegionSpoofEnabled()) {
                        param.setResult(ModSettings.get().getCurrentRegion().countryIso);
                    }
                }
            }), XposedBridge.hookMethod(TelephonyManager.class.getMethod("getNetworkOperator", new Class[0]), new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) {
                    if (ModSettings.get().isRegionSpoofEnabled()) {
                        param.setResult(ModSettings.get().getCurrentRegion().operatorCode);
                    }
                }
            }), XposedBridge.hookMethod(TelephonyManager.class.getMethod("getSimOperatorName", new Class[0]), new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) {
                    if (ModSettings.get().isRegionSpoofEnabled()) {
                        param.setResult(ModSettings.get().getCurrentRegion().operatorName);
                    }
                }
            }), XposedBridge.hookMethod(TelephonyManager.class.getMethod("getNetworkOperatorName", new Class[0]), new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) {
                    if (ModSettings.get().isRegionSpoofEnabled()) {
                        param.setResult(ModSettings.get().getCurrentRegion().operatorName);
                    }
                }
            }), XposedBridge.hookMethod(TelephonyManager.class.getMethod("getSimOperator", new Class[0]), new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) {
                    if (ModSettings.get().isRegionSpoofEnabled()) {
                        param.setResult(ModSettings.get().getCurrentRegion().operatorCode);
                    }
                }
            }), XposedBridge.hookMethod(TelephonyManager.class.getMethod("getAllCellInfo", new Class[0]), new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) {
                    if (ModSettings.get().isRegionSpoofEnabled()) {
                        param.setResult(new ArrayList<CellInfo>() {
                        });
                    }
                }
            }), XposedBridge.hookMethod(TelephonyManager.class.getMethod("getSimState", new Class[0]), new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) {
                    if (ModSettings.get().isRegionSpoofEnabled()) {
                        param.setResult(5);
                    }
                }
            }), XposedBridge.hookMethod(Notification.Builder.class.getMethod("setSmallIcon", Icon.class), new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) {
                    Context context = Main.getApplicationContext();
                    if (context == null) {
                        return;
                    }
                    try {
                        InputStream is = context.getAssets().open("ic_mod_logo_status.png");
                        try {
                            Bitmap originalBitmap = BitmapFactory.decodeStream(is);
                            if (originalBitmap != null) {
                                float density = context.getResources().getDisplayMetrics().density;
                                int targetSize = Math.round(24.0f * density);
                                Bitmap scaledBitmap = Bitmap.createScaledBitmap(originalBitmap, targetSize, targetSize, true);
                                if (originalBitmap != scaledBitmap) {
                                    originalBitmap.recycle();
                                }
                                param.args[0] = Icon.createWithBitmap(scaledBitmap);
                            }
                            if (is != null) {
                                is.close();
                            }
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
                    } catch (Exception e2) {
                        Main.log(e2.getMessage(), new Object[0]);
                    }
                }
            }), XposedBridge.hookMethod(NotificationChannel.class.getMethod("setSound", Uri.class, AudioAttributes.class), new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) {
                    Uri customUri = Main.getCustomSoundUri();
                    if (customUri != null) {
                        param.args[0] = customUri;
                    }
                }
            }));
            addAllHooks((Set<XC_MethodHook.Unhook>[]) new Set[]{XposedBridge.hookAllMethods(Notification.Builder.class, "setSound", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) {
                    Uri customUri = Main.getCustomSoundUri();
                    if (customUri != null) {
                        param.args[0] = customUri;
                    }
                }
            })});
            addAllHooks((Set<XC_MethodHook.Unhook>[]) new Set[]{XposedBridge.hookAllMethods(SettingContainerActivity.class, "onCreate", new AnonymousClass12()), XposedBridge.hookAllMethods(FeedItemList.class, "getAwemeList", new AnonymousClass13()), XposedBridge.hookAllMethods(FeedItemList.class, "setItems", new AnonymousClass14()), XposedBridge.hookAllMethods(FeedItemList.class, "setPreloadAds", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) {
                    if (ModSettings.get().isHideAdsEnabled()) {
                        param.args[0] = new ArrayList();
                    }
                }
            }), XposedBridge.hookAllMethods(FeedItemList.class, "getItems", new AnonymousClass16())});
            XC_MethodHook downloadHook = new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(XC_MethodHook.MethodHookParam param) {
                    Video video = (Video) param.thisObject;
                    VideoUrlModel playAddr = video.getPlayAddr();
                    if (playAddr != null && playAddr.getUrlList() != null && !playAddr.getUrlList().isEmpty()) {
                        param.setResult(playAddr);
                    }
                }
            };
            addAllHooks((Set<XC_MethodHook.Unhook>[]) new Set[]{XposedBridge.hookAllMethods(Video.class, "getDownloadAddr", downloadHook), XposedBridge.hookAllMethods(Video.class, "getNewDownloadAddr", downloadHook), XposedBridge.hookAllMethods(Video.class, "getDownloadNoWatermarkAddr", downloadHook), XposedBridge.hookAllMethods(Video.class, "getPlayAddrH264", downloadHook)});
            try {
                Class<?> downloadProtocolClass = Class.forName("com.ss.android.ugc.trill.download.protocol.download.AwemeVideoDownloadAbilityProtocol");
                final Class<?> qfhClass = Class.forName("X.0qFH");
                final Class<?> qepClass = Class.forName("X.0qEP");
                addAllHooks((Set<XC_MethodHook.Unhook>[]) new Set[]{XposedBridge.hookAllConstructors(downloadProtocolClass, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) {
                        VideoUrlModel playAddr;
                        try {
                            Object qfh = param.args[0];
                            Field ljiilField = qfhClass.getField("LJIIL");
                            Object qep = ljiilField.get(qfh);
                            if (qep == null) {
                                return;
                            }
                            Class<?> qhiClass = Class.forName("X.0qHI");
                            Field awemeField = qhiClass.getField("LJFF");
                            Object awemeObj = awemeField.get(qfh);
                            if (awemeObj instanceof Aweme) {
                                Aweme aweme = (Aweme) awemeObj;
                                Video video = aweme.getVideo();
                                if (video != null && (playAddr = video.getPlayAddr()) != null && playAddr.getUrlList() != null && !playAddr.getUrlList().isEmpty()) {
                                    Field lizField = qepClass.getField("LIZ");
                                    lizField.setAccessible(true);
                                    lizField.set(qep, playAddr);
                                    Main.log("AwemeVideoDownloadAbilityProtocol: patched with playAddr", new Object[0]);
                                }
                            }
                        } catch (Exception e2) {
                            Main.log("AwemeVideoDownloadAbilityProtocol hook error: %s", e2.getMessage());
                        }
                    }
                })});
                log("Hooked AwemeVideoDownloadAbilityProtocol constructor", new Object[0]);
            } catch (Exception e2) {
                log("AwemeVideoDownloadAbilityProtocol class not found: %s", e2.getMessage());
            }
            XC_MethodHook photoNoWatermarkHook = new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(XC_MethodHook.MethodHookParam param) {
                    PhotoModeImageUrlModel photo = (PhotoModeImageUrlModel) param.thisObject;
                    UrlModel noWatermark = photo.getDisplayImageNoWatermark();
                    if (noWatermark != null && noWatermark.getUrlList() != null && !noWatermark.getUrlList().isEmpty()) {
                        param.setResult(noWatermark);
                    }
                }
            };
            addAllHooks((Set<XC_MethodHook.Unhook>[]) new Set[]{XposedBridge.hookAllMethods(PhotoModeImageUrlModel.class, "getOwnerWatermarkImage", photoNoWatermarkHook), XposedBridge.hookAllMethods(PhotoModeImageUrlModel.class, "getUserWatermarkImage", photoNoWatermarkHook), XposedBridge.hookAllMethods(PhotoModeImageUrlModel.class, "getThumbnail", photoNoWatermarkHook)});
            addAllHooks(XposedBridge.hookMethod(ACLCommonShare.class.getMethod("getCode", new Class[0]), new XC_MethodReplacement() {
                @Override
                protected Object replaceHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                    return 0;
                }
            }), XposedBridge.hookMethod(ACLCommonShare.class.getMethod("getShowType", new Class[0]), new XC_MethodReplacement() {
                @Override
                protected Object replaceHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                    return 2;
                }
            }), XposedBridge.hookMethod(ACLCommonShare.class.getMethod("getTranscode", new Class[0]), new XC_MethodReplacement() {
                @Override
                protected Object replaceHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                    return 3;
                }
            }));
            addAllHooks((Set<XC_MethodHook.Unhook>[]) new Set[]{XposedBridge.hookAllMethods(UrlModel.class, "getUrlList", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(XC_MethodHook.MethodHookParam param) {
                    List<?> urls = (List) param.getResult();
                    if (urls == null || urls.isEmpty()) {
                        return;
                    }
                    String url = urls.get(0).toString();
                    if (url.contains("/video/") && url.contains("tiktokcdn")) {
                        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
                        StringBuilder sb = new StringBuilder();
                        for (int i = 3; i < Math.min(15, stack.length); i++) {
                            sb.append("\n  ").append(stack[i].toString());
                        }
                        Main.log("VIDEO_URL stack:%s", sb.toString());
                    }
                }
            })});
            ThemeHelper.initHooks();
        } catch (Exception e3) {
            Log.d(LOG_TAG, e3.toString());
        }
    }

    class AnonymousClass12 extends XC_MethodHook {
        AnonymousClass12() {
        }

        @Override
        protected void afterHookedMethod(XC_MethodHook.MethodHookParam param) {
            final SettingContainerActivity activity = (SettingContainerActivity) param.thisObject;
            ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id.content);
            if (viewGroup == null) {
                return;
            }
            boolean isDark = (activity.getResources().getConfiguration().uiMode & 48) == 32;
            FrameLayout frameLayout = new FrameLayout(activity);
            frameLayout.setBackgroundColor(isDark ? -16777216 : Color.parseColor("#FFF5F5F5"));
            int height = Main.dp(72.0f);
            int heightButton = Main.dp(48.0f);
            FrameLayout.LayoutParams containerParams = new FrameLayout.LayoutParams(-1, height);
            containerParams.gravity = 8388693;
            TextView modButton = new TextView(activity);
            modButton.setText(Localization.get().getString("settings_title"));
            modButton.setTextSize(2, 14.0f);
            modButton.setTextColor(-1);
            modButton.setGravity(17);
            modButton.setTypeface(Typeface.create("sans-serif-medium", 0));
            GradientDrawable modButtonBg = new GradientDrawable();
            modButtonBg.setCornerRadius(102.0f);
            modButtonBg.setColor(-119980);
            modButton.setBackground(modButtonBg);
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-1, heightButton);
            params.setMargins(Main.dp(24.0f), Main.dp(8.0f), Main.dp(24.0f), Main.dp(8.0f));
            modButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    Main.AnonymousClass12.lambda$afterHookedMethod$0(activity, view);
                }
            });
            frameLayout.addView(modButton, params);
            viewGroup.addView(frameLayout, containerParams);
        }

        static  void lambda$afterHookedMethod$0(SettingContainerActivity activity, View v) {
            Intent intent = new Intent((Context) activity, (Class<?>) SettingsActivity.class);
            activity.startActivity(intent);
        }
    }

    class AnonymousClass13 extends XC_MethodHook {
        AnonymousClass13() {
        }

        @Override
        protected void afterHookedMethod(XC_MethodHook.MethodHookParam param) {
            List<Aweme> list = (List) param.getResult();
            if (list == null || list.isEmpty()) {
                return;
            }
            list.removeIf(new Predicate() {
                @Override
                public final boolean test(Object obj) {
                    return Main.shouldFilterAweme((Aweme) obj);
                }
            });
        }
    }

    class AnonymousClass14 extends XC_MethodHook {
        AnonymousClass14() {
        }

        @Override
        protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) {
            List<Aweme> list = (List) param.args[0];
            if (list == null || list.isEmpty()) {
                return;
            }
            list.removeIf(new Predicate() {
                @Override
                public final boolean test(Object obj) {
                    return Main.shouldFilterAweme((Aweme) obj);
                }
            });
        }
    }

    class AnonymousClass16 extends XC_MethodHook {
        AnonymousClass16() {
        }

        @Override
        protected void afterHookedMethod(XC_MethodHook.MethodHookParam param) {
            List<Aweme> list = (List) param.getResult();
            if (list == null || list.isEmpty()) {
                return;
            }
            list.removeIf(new Predicate() {
                @Override
                public final boolean test(Object obj) {
                    return Main.shouldFilterAweme((Aweme) obj);
                }
            });
        }
    }
}
