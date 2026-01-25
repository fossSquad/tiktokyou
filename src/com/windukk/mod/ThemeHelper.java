package com.windukk.mod;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.tux.icon.TuxIconView;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class ThemeHelper {
    private static final Set<String> TIKTOK_COLOR_STRINGS = new HashSet();
    private static int cachedAccentColor;

    static {
        TIKTOK_COLOR_STRINGS.add("#fe2c55");
        TIKTOK_COLOR_STRINGS.add("#fffe2c55");
        TIKTOK_COLOR_STRINGS.add("#fd2c56");
        TIKTOK_COLOR_STRINGS.add("#fffd2c56");
        TIKTOK_COLOR_STRINGS.add("#ff0050");
        TIKTOK_COLOR_STRINGS.add("#ffff0050");
        TIKTOK_COLOR_STRINGS.add("#ff3b5c");
        TIKTOK_COLOR_STRINGS.add("#ffff3b5c");
        cachedAccentColor = 0;
    }

    public static int getMonetAccentColor() {
        if (cachedAccentColor != 0) {
            return cachedAccentColor;
        }
        if (Build.VERSION.SDK_INT < 31) {
            cachedAccentColor = -16524603;
            return cachedAccentColor;
        }
        try {
            Context context = Main.getApplicationContext();
            if (context == null) {
                cachedAccentColor = -16524603;
                return cachedAccentColor;
            }
            Resources res = context.getResources();
            String[] colorNames = {"system_accent1_500", "system_accent1_600", "system_accent2_500", "system_accent3_500"};
            for (String name : colorNames) {
                int id = res.getIdentifier(name, "color", "android");
                if (id != 0) {
                    cachedAccentColor = res.getColor(id, null);
                    return cachedAccentColor;
                }
            }
            cachedAccentColor = -16524603;
            return cachedAccentColor;
        } catch (Exception e) {
            Main.log("getMonetAccentColor error: %s", e.getMessage());
        }
    }

    public static int fixColor(int color) {
        int alpha;
        if (color == 0 || color == -16777216 || (alpha = (color >>> 24) & 255) == 0) {
            return color;
        }
        int r = (color >> 16) & 255;
        int g = (color >> 8) & 255;
        int b = color & 255;
        if (r >= 160) {
            int maxGB = Math.max(g, b);
            if (r - maxGB >= 48) {
                int accent = getMonetAccentColor() & 16777215;
                int result = (alpha << 24) | accent;
                Main.log("fixColor: %08X -> %08X", Integer.valueOf(color), Integer.valueOf(result));
                return result;
            }
        }
        return color;
    }

    public static ColorStateList fixColorStateList(ColorStateList list) {
        if (list == null) {
            return null;
        }
        try {
            int defaultColor = list.getDefaultColor();
            int fixed = fixColor(defaultColor);
            if (fixed != defaultColor) {
                return ColorStateList.valueOf(fixed);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static int parseColor(String colorString) {
        if (colorString == null) {
            return 0;
        }
        if (TIKTOK_COLOR_STRINGS.contains(colorString.toLowerCase())) {
            return getMonetAccentColor();
        }
        return Color.parseColor(colorString);
    }

    public static void resetCache() {
        cachedAccentColor = 0;
    }

    public static void initHooks() {
        Class<?> lottieViewClass;
        Class<?> lottieViewClass2;
        Class<?> lottiePropertyClass;
        Class<?> keyPathClass;
        String colorFilterFieldName;
        if (Build.VERSION.SDK_INT < 31) {
            return;
        }
        try {
            XposedBridge.hookAllMethods(Color.class, "parseColor", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) {
                    String colorString;
                    if (ModSettings.get().isSystemColorsEnabled() && (colorString = (String) param.args[0]) != null && ThemeHelper.TIKTOK_COLOR_STRINGS.contains(colorString.toLowerCase())) {
                        param.setResult(Integer.valueOf(ThemeHelper.getMonetAccentColor()));
                    }
                }
            });
            XposedBridge.hookAllMethods(Paint.class, "setColor", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) {
                    int color;
                    int fixed;
                    if (ModSettings.get().isSystemColorsEnabled() && (fixed = ThemeHelper.fixColor((color = ((Integer) param.args[0]).intValue()))) != color) {
                        param.args[0] = Integer.valueOf(fixed);
                    }
                }
            });
            XposedBridge.hookAllMethods(TextView.class, "setTextColor", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) {
                    ColorStateList list;
                    ColorStateList fixed;
                    if (ModSettings.get().isSystemColorsEnabled()) {
                        Object arg = param.args[0];
                        if (arg instanceof Integer) {
                            int color = ((Integer) arg).intValue();
                            int fixed2 = ThemeHelper.fixColor(color);
                            if (fixed2 != color) {
                                param.args[0] = Integer.valueOf(fixed2);
                                return;
                            }
                            return;
                        }
                        if ((arg instanceof ColorStateList) && (fixed = ThemeHelper.fixColorStateList((list = (ColorStateList) arg))) != list) {
                            param.args[0] = fixed;
                        }
                    }
                }
            });
            XposedBridge.hookAllMethods(GradientDrawable.class, "setColor", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) {
                    int color;
                    int fixed;
                    if (ModSettings.get().isSystemColorsEnabled()) {
                        Object arg = param.args[0];
                        if ((arg instanceof Integer) && (fixed = ThemeHelper.fixColor((color = ((Integer) arg).intValue()))) != color) {
                            param.args[0] = Integer.valueOf(fixed);
                        }
                    }
                }
            });
            XposedBridge.hookAllMethods(GradientDrawable.class, "setStroke", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) {
                    int color;
                    int fixed;
                    if (ModSettings.get().isSystemColorsEnabled() && param.args.length >= 2 && (param.args[1] instanceof Integer) && (fixed = ThemeHelper.fixColor((color = ((Integer) param.args[1]).intValue()))) != color) {
                        param.args[1] = Integer.valueOf(fixed);
                    }
                }
            });
            XposedBridge.hookAllMethods(View.class, "setBackgroundColor", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) {
                    int color;
                    int fixed;
                    if (ModSettings.get().isSystemColorsEnabled() && (fixed = ThemeHelper.fixColor((color = ((Integer) param.args[0]).intValue()))) != color) {
                        param.args[0] = Integer.valueOf(fixed);
                    }
                }
            });
            XposedBridge.hookAllMethods(Drawable.class, "setTint", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) {
                    int color;
                    int fixed;
                    if (ModSettings.get().isSystemColorsEnabled() && (fixed = ThemeHelper.fixColor((color = ((Integer) param.args[0]).intValue()))) != color) {
                        param.args[0] = Integer.valueOf(fixed);
                    }
                }
            });
            XposedBridge.hookAllMethods(Drawable.class, "setTintList", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) {
                    ColorStateList list;
                    ColorStateList fixed;
                    if (ModSettings.get().isSystemColorsEnabled() && (fixed = ThemeHelper.fixColorStateList((list = (ColorStateList) param.args[0]))) != list) {
                        param.args[0] = fixed;
                    }
                }
            });
            XposedBridge.hookAllMethods(ImageView.class, "setColorFilter", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) {
                    int color;
                    int fixed;
                    if (ModSettings.get().isSystemColorsEnabled() && (param.args[0] instanceof Integer) && (fixed = ThemeHelper.fixColor((color = ((Integer) param.args[0]).intValue()))) != color) {
                        param.args[0] = Integer.valueOf(fixed);
                    }
                }
            });
            XposedBridge.hookAllMethods(ColorStateList.class, "valueOf", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) {
                    int color;
                    int fixed;
                    if (ModSettings.get().isSystemColorsEnabled() && (fixed = ThemeHelper.fixColor((color = ((Integer) param.args[0]).intValue()))) != color) {
                        param.args[0] = Integer.valueOf(fixed);
                    }
                }
            });
            try {
                XposedBridge.hookAllMethods(TuxIconView.class, "setTintColor", new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) {
                        int color;
                        int fixed;
                        if (ModSettings.get().isSystemColorsEnabled() && param.args.length > 0 && (param.args[0] instanceof Integer) && (fixed = ThemeHelper.fixColor((color = ((Integer) param.args[0]).intValue()))) != color) {
                            Main.log("TuxIconView.setTintColor: %08X -> %08X", Integer.valueOf(color), Integer.valueOf(fixed));
                            param.args[0] = Integer.valueOf(fixed);
                        }
                    }
                });
                XposedBridge.hookAllMethods(TuxIconView.class, "setColor", new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) {
                        int color;
                        int fixed;
                        if (ModSettings.get().isSystemColorsEnabled() && param.args.length > 0 && (param.args[0] instanceof Integer) && (fixed = ThemeHelper.fixColor((color = ((Integer) param.args[0]).intValue()))) != color) {
                            param.args[0] = Integer.valueOf(fixed);
                        }
                    }
                });
                Main.log("TuxIconView hooks initialized", new Object[0]);
            } catch (Exception e) {
                Main.log("TuxIconView not found", new Object[0]);
            }
            XposedBridge.hookAllConstructors(ForegroundColorSpan.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) {
                    int color;
                    int fixed;
                    if (ModSettings.get().isSystemColorsEnabled() && param.args.length > 0 && (param.args[0] instanceof Integer) && (fixed = ThemeHelper.fixColor((color = ((Integer) param.args[0]).intValue()))) != color) {
                        param.args[0] = Integer.valueOf(fixed);
                    }
                }
            });
            XposedBridge.hookAllMethods(ImageView.class, "setImageTintList", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) {
                    ColorStateList list;
                    ColorStateList fixed;
                    if (ModSettings.get().isSystemColorsEnabled() && (fixed = ThemeHelper.fixColorStateList((list = (ColorStateList) param.args[0]))) != list) {
                        param.args[0] = fixed;
                    }
                }
            });
            XposedBridge.hookAllMethods(View.class, "setBackgroundTintList", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) {
                    ColorStateList list;
                    ColorStateList fixed;
                    if (ModSettings.get().isSystemColorsEnabled() && (fixed = ThemeHelper.fixColorStateList((list = (ColorStateList) param.args[0]))) != list) {
                        param.args[0] = fixed;
                    }
                }
            });
            XposedBridge.hookAllConstructors(PorterDuffColorFilter.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) {
                    int color;
                    int fixed;
                    if (ModSettings.get().isSystemColorsEnabled() && param.args.length > 0 && (param.args[0] instanceof Integer) && (fixed = ThemeHelper.fixColor((color = ((Integer) param.args[0]).intValue()))) != color) {
                        param.args[0] = Integer.valueOf(fixed);
                    }
                }
            });
            try {
                XposedBridge.hookMethod(Drawable.class.getMethod("setColorFilter", Integer.TYPE, PorterDuff.Mode.class), new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) {
                        int color;
                        int fixed;
                        if (ModSettings.get().isSystemColorsEnabled() && param.args.length > 0 && (param.args[0] instanceof Integer) && (fixed = ThemeHelper.fixColor((color = ((Integer) param.args[0]).intValue()))) != color) {
                            param.args[0] = Integer.valueOf(fixed);
                        }
                    }
                });
            } catch (NoSuchMethodException e2) {
            }
            try {
                Class<?> imageViewCompatClass = Class.forName("androidx.core.widget.ImageViewCompat");
                XposedBridge.hookAllMethods(imageViewCompatClass, "setImageTintList", new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) {
                        ColorStateList list;
                        ColorStateList fixed;
                        if (ModSettings.get().isSystemColorsEnabled() && param.args.length >= 2 && (param.args[1] instanceof ColorStateList) && (fixed = ThemeHelper.fixColorStateList((list = (ColorStateList) param.args[1]))) != list) {
                            param.args[1] = fixed;
                        }
                    }
                });
                Main.log("ImageViewCompat hook initialized", new Object[0]);
            } catch (ClassNotFoundException e3) {
                Main.log("ImageViewCompat not found", new Object[0]);
            }
            try {
                Class<?> drawableCompatClass = Class.forName("androidx.core.graphics.drawable.DrawableCompat");
                XposedBridge.hookAllMethods(drawableCompatClass, "setTint", new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) {
                        int color;
                        int fixed;
                        if (ModSettings.get().isSystemColorsEnabled() && param.args.length >= 2 && (param.args[1] instanceof Integer) && (fixed = ThemeHelper.fixColor((color = ((Integer) param.args[1]).intValue()))) != color) {
                            param.args[1] = Integer.valueOf(fixed);
                        }
                    }
                });
                XposedBridge.hookAllMethods(drawableCompatClass, "setTintList", new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) {
                        ColorStateList list;
                        ColorStateList fixed;
                        if (ModSettings.get().isSystemColorsEnabled() && param.args.length >= 2 && (param.args[1] instanceof ColorStateList) && (fixed = ThemeHelper.fixColorStateList((list = (ColorStateList) param.args[1]))) != list) {
                            param.args[1] = fixed;
                        }
                    }
                });
                Main.log("DrawableCompat hooks initialized", new Object[0]);
            } catch (ClassNotFoundException e4) {
                Main.log("DrawableCompat not found", new Object[0]);
            }
            XposedBridge.hookAllMethods(TypedArray.class, "getColor", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(XC_MethodHook.MethodHookParam param) {
                    int color;
                    int fixed;
                    if (ModSettings.get().isSystemColorsEnabled() && (fixed = ThemeHelper.fixColor((color = ((Integer) param.getResult()).intValue()))) != color) {
                        param.setResult(Integer.valueOf(fixed));
                    }
                }
            });
            XposedBridge.hookAllMethods(TypedArray.class, "getColorStateList", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(XC_MethodHook.MethodHookParam param) {
                    ColorStateList list;
                    ColorStateList fixed;
                    if (ModSettings.get().isSystemColorsEnabled() && (fixed = ThemeHelper.fixColorStateList((list = (ColorStateList) param.getResult()))) != list) {
                        param.setResult(fixed);
                    }
                }
            });
            XposedBridge.hookAllMethods(Resources.class, "getColor", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(XC_MethodHook.MethodHookParam param) {
                    int color;
                    int fixed;
                    if (ModSettings.get().isSystemColorsEnabled() && (fixed = ThemeHelper.fixColor((color = ((Integer) param.getResult()).intValue()))) != color) {
                        param.setResult(Integer.valueOf(fixed));
                    }
                }
            });
            XposedBridge.hookAllMethods(Resources.class, "getColorStateList", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(XC_MethodHook.MethodHookParam param) {
                    ColorStateList list;
                    ColorStateList fixed;
                    if (ModSettings.get().isSystemColorsEnabled() && (fixed = ThemeHelper.fixColorStateList((list = (ColorStateList) param.getResult()))) != list) {
                        param.setResult(fixed);
                    }
                }
            });
            XposedBridge.hookAllMethods(Context.class, "getColor", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(XC_MethodHook.MethodHookParam param) {
                    int color;
                    int fixed;
                    if (ModSettings.get().isSystemColorsEnabled() && (fixed = ThemeHelper.fixColor((color = ((Integer) param.getResult()).intValue()))) != color) {
                        param.setResult(Integer.valueOf(fixed));
                    }
                }
            });
            XposedBridge.hookAllMethods(Context.class, "getColorStateList", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(XC_MethodHook.MethodHookParam param) {
                    ColorStateList list;
                    ColorStateList fixed;
                    if (ModSettings.get().isSystemColorsEnabled() && (fixed = ThemeHelper.fixColorStateList((list = (ColorStateList) param.getResult()))) != list) {
                        param.setResult(fixed);
                    }
                }
            });
            try {
                Class<?> contextCompatClass = Class.forName("androidx.core.content.ContextCompat");
                XposedBridge.hookAllMethods(contextCompatClass, "getColor", new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(XC_MethodHook.MethodHookParam param) {
                        int color;
                        int fixed;
                        if (ModSettings.get().isSystemColorsEnabled() && (fixed = ThemeHelper.fixColor((color = ((Integer) param.getResult()).intValue()))) != color) {
                            param.setResult(Integer.valueOf(fixed));
                        }
                    }
                });
                XposedBridge.hookAllMethods(contextCompatClass, "getColorStateList", new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(XC_MethodHook.MethodHookParam param) {
                        ColorStateList list;
                        ColorStateList fixed;
                        if (ModSettings.get().isSystemColorsEnabled() && (fixed = ThemeHelper.fixColorStateList((list = (ColorStateList) param.getResult()))) != list) {
                            param.setResult(fixed);
                        }
                    }
                });
                Main.log("ContextCompat hooks initialized", new Object[0]);
            } catch (ClassNotFoundException e5) {
                Main.log("ContextCompat not found", new Object[0]);
            }
            try {
                Class<?> resourcesCompatClass = Class.forName("androidx.core.content.res.ResourcesCompat");
                XposedBridge.hookAllMethods(resourcesCompatClass, "getColor", new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(XC_MethodHook.MethodHookParam param) {
                        int color;
                        int fixed;
                        if (ModSettings.get().isSystemColorsEnabled() && (fixed = ThemeHelper.fixColor((color = ((Integer) param.getResult()).intValue()))) != color) {
                            param.setResult(Integer.valueOf(fixed));
                        }
                    }
                });
                XposedBridge.hookAllMethods(resourcesCompatClass, "getColorStateList", new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(XC_MethodHook.MethodHookParam param) {
                        ColorStateList list;
                        ColorStateList fixed;
                        if (ModSettings.get().isSystemColorsEnabled() && (fixed = ThemeHelper.fixColorStateList((list = (ColorStateList) param.getResult()))) != list) {
                            param.setResult(fixed);
                        }
                    }
                });
                Main.log("ResourcesCompat hooks initialized", new Object[0]);
            } catch (ClassNotFoundException e6) {
                Main.log("ResourcesCompat not found", new Object[0]);
            }
            try {
                lottieViewClass = Class.forName("com.airbnb.lottie.LottieAnimationView");
                lottieViewClass2 = Class.forName("com.airbnb.lottie.LottieProperty");
                lottiePropertyClass = Class.forName("com.airbnb.lottie.model.KeyPath");
                keyPathClass = Class.forName("com.airbnb.lottie.value.LottieValueCallback");
                colorFilterFieldName = "COLOR_FILTER";
            } catch (ClassNotFoundException e7) {
                try {
                    Class<?> lottieViewClass3 = Class.forName("X.13AE");
                    Class<?> lottiePropertyClass2 = Class.forName("X.13BU");
                    Class<?> keyPathClass2 = Class.forName("X.13Ay");
                    Class<?> valueCallbackClass = Class.forName("X.13B4");
                    lottieViewClass = lottieViewClass3;
                    lottieViewClass2 = lottiePropertyClass2;
                    lottiePropertyClass = keyPathClass2;
                    keyPathClass = valueCallbackClass;
                    colorFilterFieldName = "LJJIJL";
                } catch (ClassNotFoundException e8) {
                    Main.log("Lottie classes not found (obfuscated?) " + e8.getMessage(), new Object[0]);
                }
            }
            final Class<?> finalLottiePropertyClass = lottieViewClass2;
            final Class<?> finalKeyPathClass = lottiePropertyClass;
            final Class<?> finalValueCallbackClass = keyPathClass;
            final String finalColorFilterFieldName = colorFilterFieldName;
            XC_MethodHook lottieHook = new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(XC_MethodHook.MethodHookParam param) {
                    char c;
                    char c2;
                    if (ModSettings.get().isSystemColorsEnabled()) {
                        try {
                            Object lottieView = param.thisObject;
                            int monetColor = ThemeHelper.getMonetAccentColor();
                            PorterDuffColorFilter colorFilter = new PorterDuffColorFilter(monetColor, PorterDuff.Mode.SRC_IN);
                            Object keyPath = finalKeyPathClass.getConstructor(String[].class).newInstance(new String[]{"**"});
                            Object colorFilterProperty = finalLottiePropertyClass.getField(finalColorFilterFieldName).get(null);
                            Object callback = finalValueCallbackClass.getConstructor(Object.class).newInstance(colorFilter);
                            Method addValueCallbackMethod = null;
                            Method[] methods = lottieView.getClass().getMethods();
                            int length = methods.length;
                            int i = 0;
                            while (true) {
                                if (i >= length) {
                                    c = 1;
                                    c2 = 0;
                                    break;
                                }
                                Method m = methods[i];
                                c = 1;
                                c2 = 0;
                                if (m.getName().equals("addValueCallback") && ThemeHelper$31$$ExternalSyntheticBackport0.m(m) == 3) {
                                    Class<?>[] params = m.getParameterTypes();
                                    if (params[0].isAssignableFrom(finalKeyPathClass)) {
                                        addValueCallbackMethod = m;
                                        break;
                                    }
                                }
                                i++;
                            }
                            if (addValueCallbackMethod != null) {
                                Object[] objArr = new Object[3];
                                objArr[c2] = keyPath;
                                objArr[c] = colorFilterProperty;
                                objArr[2] = callback;
                                addValueCallbackMethod.invoke(lottieView, objArr);
                            }
                        } catch (Exception e9) {
                        }
                    }
                }
            };
            XposedBridge.hookAllMethods(lottieViewClass, "playAnimation", lottieHook);
            XposedBridge.hookAllMethods(lottieViewClass, "setComposition", lottieHook);
            Main.log("Lottie hooks initialized (Classes found)", new Object[0]);
            Main.log("ThemeHelper hooks initialized", new Object[0]);
        } catch (Exception e9) {
            Main.log("ThemeHelper init error: %s", e9.getMessage());
        }
    }
}
