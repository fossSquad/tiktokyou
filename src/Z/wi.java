package Z;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.windukk.hook.HookBridge;
import com.windukk.mod.Main;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import ni.shikatu.kotlin.NoWhenBranchMatchedException;
import ni.shikatu.kotlin.Pair;
import ni.shikatu.kotlin.Result;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.TuplesKt;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.comparisons.ComparisonsKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.Ref;
import ni.shikatu.kotlin.ranges.RangesKt;
import ni.shikatu.kotlin.text.StringsKt;

public abstract class wi {
    public static ObjectAnimator a;
    public static WeakReference b;
    public static WeakReference c;
    public static boolean e;
    public static ui g;
    public static ti d = ti.a;
    public static final Rect f = new Rect();
    public static float i = Float.NaN;
    public static float j = Float.NaN;
    public static final Runnable k = new Runnable() {

        @Override
        public final void run() throws NoWhenBranchMatchedException {
            wi.f();
        }
    };

    public static void a(Activity activity, ti tiVar) throws NoWhenBranchMatchedException {
        ImageView imageView;
        d = tiVar;
        WeakReference weakReference = b;
        if (weakReference == null || (imageView = (ImageView) weakReference.get()) == null) {
            return;
        }
        a(activity, imageView);
    }

    public static final void b(ImageView imageView) {
        ObjectAnimator objectAnimator = a;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        a = null;
        if (g == ui.a && imageView.isAttachedToWindow()) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, (Property<ImageView, Float>) View.ROTATION, 0.0f, -16.0f, 13.0f, -9.0f, 5.0f, -2.0f, 0.0f);
            objectAnimatorOfFloat.setDuration(650L);
            objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
            objectAnimatorOfFloat.start();
            a = objectAnimatorOfFloat;
        }
    }

    public static final Unit c() {
        return Unit.INSTANCE;
    }

    public static final void d() {
        a();
        WeakReference weakReference = b;
        ImageView imageView = weakReference != null ? (ImageView) weakReference.get() : null;
        b = null;
        d = ti.a;
        g = null;
        ObjectAnimator objectAnimator = a;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        a = null;
        ViewParent parent = imageView != null ? imageView.getParent() : null;
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(imageView);
        }
    }

    public static final void e() {
        Application application;
        if (e || (application = Main.mainApplication) == null) {
            return;
        }
        e = true;
        application.registerActivityLifecycleCallbacks(new vi());
    }

    public static final void f() throws NoWhenBranchMatchedException {
        ImageView imageView;
        WeakReference weakReference = b;
        if (weakReference == null || (imageView = (ImageView) weakReference.get()) == null) {
            return;
        }
        Context context = imageView.getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null) {
            return;
        }
        a(activity, imageView);
    }

    public static final Unit c(Activity activity) throws NoWhenBranchMatchedException {
        Object obj;
        Object obj2;
        a();
        pj pjVar = pj.a;
        if (!pj.g) {
            hi.a(activity);
            pj.o = hi.a();
            pj.a(false);
            pj.g = true;
            ArrayList arrayList = pj.h;
            synchronized (arrayList) {
                if (arrayList.isEmpty()) {
                    try {
                        Result.Companion companion = Result.Companion;
                        obj = Result.constructor-impl(Boolean.valueOf(arrayList.add(HookBridge.hookMethod(Activity.class.getDeclaredMethod("dispatchTouchEvent", MotionEvent.class), new wi$before$1(pjVar)))));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    Throwable th2 = Result.exceptionOrNull-impl(obj);
                    if (th2 != null) {
                        g7.a(6, g7.a("Failed to hook Activity#dispatchTouchEvent", new Object[0]), th2);
                    }
                    pj pjVar2 = pj.a;
                    try {
                        Result.Companion companion3 = Result.Companion;
                        obj2 = Result.constructor-impl(Boolean.valueOf(pj.h.add(HookBridge.hookMethod(ViewGroup.class.getDeclaredMethod("dispatchTouchEvent", MotionEvent.class), new wi$before$2(pjVar2)))));
                    } catch (Throwable th3) {
                        Result.Companion companion4 = Result.Companion;
                        obj2 = Result.constructor-impl(ResultKt.createFailure(th3));
                    }
                    Throwable th4 = Result.exceptionOrNull-impl(obj2);
                    if (th4 != null) {
                        g7.a(6, g7.a("Failed to hook ViewGroup#dispatchTouchEvent", new Object[0]), th4);
                    }
                }
            }
        }
        a(activity, ti.c);
        return Unit.INSTANCE;
    }

    public static void a(Activity activity, ImageView imageView) throws NoWhenBranchMatchedException {
        ui uiVar;
        float f2;
        hi hiVar = new hi(activity, hi.a(activity), null);
        int iA = hi.a();
        int iA2 = hiVar.a(56.0f);
        int iA3 = hiVar.a(20.0f);
        ti tiVar = d;
        ti tiVar2 = ti.c;
        if (tiVar != tiVar2) {
            pj pjVar = pj.a;
            if (pj.g) {
                d = tiVar2;
            }
        }
        int iOrdinal = d.ordinal();
        if (iOrdinal == 0) {
            uiVar = ui.a;
        } else if (iOrdinal == 1) {
            uiVar = ui.b;
        } else if (iOrdinal == 2) {
            pj pjVar2 = pj.a;
            uiVar = pj.d() ? ui.d : ui.c;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        int iOrdinal2 = d.ordinal();
        if (iOrdinal2 == 0) {
            imageView.setImageDrawable(hiVar.b(-1, "ic_pencil"));
            float f3 = iA2 / 2.0f;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(iA);
            gradientDrawable.setCornerRadius(f3);
            imageView.setBackground(gradientDrawable);
            imageView.setContentDescription(k7.a("ui_hide_section"));
        } else if (iOrdinal2 == 1) {
            imageView.setImageDrawable(new g3(hiVar.a(2.4f), iA3));
            float f4 = iA2 / 2.0f;
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(iA);
            gradientDrawable2.setCornerRadius(f4);
            imageView.setBackground(gradientDrawable2);
            imageView.setContentDescription(k7.a("ui_hide_close"));
        } else if (iOrdinal2 == 2) {
            pj pjVar3 = pj.a;
            if (pj.d()) {
                imageView.setImageDrawable(hiVar.b(iA, "ic_restart"));
                imageView.setContentDescription(k7.a("ui_hide_reset_selection"));
            } else {
                imageView.setImageDrawable(new zd(iA, hiVar.a(2.4f), iA3, new float[]{0.2f, 0.52f, 0.42f, 0.72f, 0.8f, 0.3f}));
                imageView.setContentDescription(k7.a("ui_hide_confirm"));
            }
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            gradientDrawable3.setColor(-1);
            gradientDrawable3.setCornerRadius(iA2 / 2.0f);
            imageView.setBackground(gradientDrawable3);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        ui uiVar2 = g;
        g = uiVar;
        if (uiVar2 == null) {
            a(imageView);
            return;
        }
        if (uiVar2 != uiVar) {
            ObjectAnimator objectAnimator = a;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            a = null;
            imageView.setCameraDistance(imageView.getResources().getDisplayMetrics().density * 8000.0f);
            ui uiVar3 = ui.a;
            boolean z = (uiVar2 == uiVar3 || uiVar2 == ui.b) != (uiVar == uiVar3 || uiVar == ui.b);
            float f5 = 90.0f;
            if (z) {
                imageView.setRotation(0.0f);
                imageView.setRotationY(uiVar == uiVar3 ? -90.0f : 90.0f);
                imageView.setScaleX(0.9f);
                imageView.setScaleY(0.9f);
            } else {
                switch (uiVar.ordinal()) {
                    case 0:
                        f5 = -120.0f;
                        imageView.setRotation(f5);
                        imageView.setRotationY(0.0f);
                        if (uiVar == ui.c) {
                            f2 = 0.6f;
                        } else {
                            f2 = 0.82f;
                        }
                        imageView.setScaleX(f2);
                        imageView.setScaleY(f2);
                        break;
                    case 1:
                        imageView.setRotation(f5);
                        imageView.setRotationY(0.0f);
                        if (uiVar == ui.c) {
                            f2 = 0.6f;
                        } else {
                            f2 = 0.82f;
                        }
                        imageView.setScaleX(f2);
                        imageView.setScaleY(f2);
                        break;
                    case 2:
                        f5 = 0.0f;
                        imageView.setRotation(f5);
                        imageView.setRotationY(0.0f);
                        if (uiVar == ui.c) {
                            f2 = 0.6f;
                        } else {
                            f2 = 0.82f;
                        }
                        imageView.setScaleX(f2);
                        imageView.setScaleY(f2);
                        break;
                    case 3:
                        f5 = -180.0f;
                        imageView.setRotation(f5);
                        imageView.setRotationY(0.0f);
                        if (uiVar == ui.c) {
                            f2 = 0.6f;
                        } else {
                            f2 = 0.82f;
                        }
                        imageView.setScaleX(f2);
                        imageView.setScaleY(f2);
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }
            imageView.animate().rotation(0.0f).rotationY(0.0f).scaleX(1.0f).scaleY(1.0f).setStartDelay(0L).setDuration(z ? 340L : 300L).setInterpolator(new OvershootInterpolator(z ? 1.2f : 1.8f)).start();
        }
    }

    public static final void f(Activity activity) {
        Object obj;
        if (StringsKt.startsWith$default(activity.getClass().getName(), "com.windukk.mod", false, 2, (Object) null)) {
            return;
        }
        Window window = activity.getWindow();
        View decorView = window != null ? window.getDecorView() : null;
        FrameLayout frameLayout = decorView instanceof FrameLayout ? (FrameLayout) decorView : null;
        if (frameLayout != null && frameLayout.findViewWithTag("UiHideFloatingButton") == null) {
            d();
            try {
                Result.Companion companion = Result.Companion;
                ImageView imageViewA = a(activity, frameLayout);
                frameLayout.addView(imageViewA);
                b = new WeakReference(imageViewA);
                a(activity, imageViewA);
                obj = Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            Throwable th2 = Result.exceptionOrNull-impl(obj);
            if (th2 != null) {
                g7.a(6, g7.a("Failed to show UI hide button", new Object[0]), th2);
            }
        }
    }

    public static final Unit e(Activity activity) throws NoWhenBranchMatchedException {
        a();
        a(activity, ti.a);
        yi.a(activity, false);
        return Unit.INSTANCE;
    }

    public static final Unit d(Activity activity) throws NoWhenBranchMatchedException {
        a();
        a(activity, ti.a);
        tj.b(activity);
        return Unit.INSTANCE;
    }

    public static final Unit b() {
        pj pjVar = pj.a;
        pj.a(false);
        return Unit.INSTANCE;
    }

    public static void b(final Activity activity) throws NoWhenBranchMatchedException {
        final ImageView imageView;
        int i2;
        WeakReference weakReference = b;
        if (weakReference == null || (imageView = (ImageView) weakReference.get()) == null) {
            return;
        }
        ViewParent parent = imageView.getParent();
        final FrameLayout frameLayout = parent instanceof FrameLayout ? (FrameLayout) parent : null;
        if (frameLayout == null) {
            return;
        }
        a();
        final hi hiVar = new hi(activity, hi.a(activity), null);
        FrameLayout frameLayout2 = new FrameLayout(activity);
        frameLayout2.setTag("UiHideFloatingMenu");
        frameLayout2.setClickable(true);
        frameLayout2.setOnClickListener(new View.OnClickListener() {

            @Override
            public final void onClick(View view) throws NoWhenBranchMatchedException {
                wi.a(activity, view);
            }
        });
        final LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(1);
        linearLayout.setClipChildren(false);
        linearLayout.setClickable(true);
        linearLayout.setAlpha(0.0f);
        frameLayout2.addView(linearLayout, new FrameLayout.LayoutParams(-2, -2, 8388659));
        Pair pairA = a(activity, hiVar, "ic_editmode", k7.a("ui_hide_menu_hide"), null, new Function0() {
            public final Object invoke() {
                return wi.c(activity);
            }
        });
        String strB = xj.b();
        List listA = xj.a();
        if ((listA instanceof Collection) && listA.isEmpty()) {
            i2 = 0;
        } else {
            Iterator it = listA.iterator();
            i2 = 0;
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((wj) it.next()).d, strB) && (i2 = i2 + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        String strA = k7.a("ui_hide_section");
        Integer numValueOf = Integer.valueOf(i2);
        if (i2 <= 0) {
            numValueOf = null;
        }
        Pair pairA2 = a(activity, hiVar, "ic_list", strA, numValueOf != null ? String.valueOf(numValueOf.intValue()) : null, new Function0() {
            public final Object invoke() {
                return wi.d(activity);
            }
        });
        Pair pairA3 = a(activity, hiVar, "ic_startup_faq", k7.a("ui_hide_menu_guide"), null, new Function0() {
            public final Object invoke() {
                return wi.e(activity);
            }
        });
        int iCoerceAtMost = RangesKt.coerceAtMost(ComparisonsKt.maxOf(((Number) pairA.getSecond()).intValue(), new int[]{((Number) pairA2.getSecond()).intValue(), ((Number) pairA3.getSecond()).intValue(), hiVar.a(232.0f)}), frameLayout.getWidth() - hiVar.a(24.0f));
        linearLayout.addView((View) pairA.getFirst(), new LinearLayout.LayoutParams(iCoerceAtMost, hiVar.a(52.0f)));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iCoerceAtMost, hiVar.a(52.0f));
        layoutParams.topMargin = hiVar.a(8.0f);
        linearLayout.addView((View) pairA2.getFirst(), layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(iCoerceAtMost, hiVar.a(52.0f));
        layoutParams2.topMargin = hiVar.a(8.0f);
        linearLayout.addView((View) pairA3.getFirst(), layoutParams2);
        frameLayout.addView(frameLayout2, RangesKt.coerceAtLeast(frameLayout.indexOfChild(imageView), 0), new FrameLayout.LayoutParams(-1, -1));
        c = new WeakReference(frameLayout2);
        a(activity, ti.b);
        linearLayout.post(new Runnable() {
            @Override
            public final void run() {
                wi.a(hiVar, frameLayout, linearLayout, imageView, activity);
            }
        });
    }

    public static void a(final ImageView imageView) {
        ObjectAnimator objectAnimator = a;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        a = null;
        imageView.setScaleX(0.0f);
        imageView.setScaleY(0.0f);
        imageView.setRotation(-60.0f);
        imageView.animate().scaleX(1.0f).scaleY(1.0f).rotation(0.0f).setStartDelay(0L).setDuration(420L).setInterpolator(new OvershootInterpolator(2.2f)).withEndAction(new Runnable() {
            @Override
            public final void run() {
                wi.b(imageView);
            }
        }).start();
    }

    public static void a(Activity activity) {
        pj pjVar = pj.a;
        cj cjVar = (cj) CollectionsKt.getOrNull(pj.l, pj.m);
        yj yjVar = null;
        if (cjVar != null) {
            if (cjVar.a.get() == null) {
                pj.a(false);
            } else {
                yjVar = new yj(cjVar.b, cjVar.c);
            }
        }
        if (yjVar == null) {
            pj.o();
            a(activity, ti.a);
        } else {
            zj.a(activity, yjVar, new Function0() {
                public final Object invoke() {
                    return wi.b();
                }
            }, new Function0() {
                public final Object invoke() {
                    return wi.c();
                }
            });
        }
    }

    public static final void a(Activity activity, View view) throws NoWhenBranchMatchedException {
        a();
        a(activity, ti.a);
    }

    public static final void a(hi hiVar, FrameLayout frameLayout, LinearLayout linearLayout, ImageView imageView, Activity activity) {
        float fA = hiVar.a(10.0f);
        float fA2 = hiVar.a(12.0f);
        float width = (frameLayout.getWidth() - linearLayout.getWidth()) - fA2;
        boolean z = (((float) imageView.getWidth()) / 2.0f) + imageView.getX() > ((float) frameLayout.getWidth()) / 2.0f;
        linearLayout.setX(RangesKt.coerceIn(z ? (imageView.getX() + imageView.getWidth()) - linearLayout.getWidth() : imageView.getX(), fA2, RangesKt.coerceAtLeast(width, fA2)));
        float y = (imageView.getY() - fA) - linearLayout.getHeight();
        float y2 = imageView.getY() + imageView.getHeight() + fA;
        float fC = hi.c(activity);
        if (y < fC) {
            y = y2;
        }
        linearLayout.setY(y);
        linearLayout.setPivotX(z ? linearLayout.getWidth() : 0.0f);
        linearLayout.setPivotY(y >= fC ? linearLayout.getHeight() : 0.0f);
        linearLayout.setScaleX(0.9f);
        linearLayout.setScaleY(0.9f);
        linearLayout.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(160L).start();
        boolean z2 = y >= fC;
        int childCount = linearLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = linearLayout.getChildAt(i2);
            int i3 = z2 ? (childCount - 1) - i2 : i2;
            childAt.setAlpha(0.0f);
            childAt.setTranslationY(hiVar.a(z2 ? 14.0f : -14.0f));
            childAt.setScaleX(0.92f);
            childAt.setScaleY(0.92f);
            childAt.animate().alpha(1.0f).translationY(0.0f).scaleX(1.0f).scaleY(1.0f).setStartDelay(((long) i3) * 45).setDuration(260L).setInterpolator(new OvershootInterpolator(1.4f)).start();
        }
    }

    public static void a() {
        WeakReference weakReference = c;
        View view = weakReference != null ? (View) weakReference.get() : null;
        c = null;
        ViewParent parent = view != null ? view.getParent() : null;
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
    }

    public static Pair a(Activity activity, hi hiVar, String str, String str2, String str3, final Function0 function0) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setPadding(hiVar.a(18.0f), 0, hiVar.a(20.0f), 0);
        int i2 = hiVar.b ? -14935010 : -1;
        float fA = hiVar.a(26.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i2);
        gradientDrawable.setCornerRadius(fA);
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setElevation(hiVar.a(4.0f));
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                wi.a(function0, view);
            }
        });
        int paddingRight = linearLayout.getPaddingRight() + linearLayout.getPaddingLeft();
        int iA = hiVar.a(20.0f);
        ImageView imageView = new ImageView(activity);
        imageView.setImageDrawable(hiVar.b(hi.h, str));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(iA, iA));
        TextView textView = new TextView(activity);
        textView.setText(str2);
        textView.setTextSize(2, 16.0f);
        textView.setTextColor(hiVar.e());
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.setMarginStart(hiVar.a(14.0f));
        linearLayout.addView(textView, layoutParams);
        textView.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        int measuredWidth = textView.getMeasuredWidth() + layoutParams.getMarginStart() + paddingRight + iA;
        if (str3 != null) {
            TextView textView2 = new TextView(activity);
            textView2.setText(str3);
            textView2.setTextSize(2, 14.0f);
            textView2.setTextColor(hi.f);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMarginStart(hiVar.a(16.0f));
            linearLayout.addView(textView2, layoutParams2);
            textView2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            measuredWidth += textView2.getMeasuredWidth() + layoutParams2.getMarginStart();
        }
        return TuplesKt.to(linearLayout, Integer.valueOf(measuredWidth));
    }

    public static final void a(Function0 function0, View view) {
        function0.invoke();
    }

    public static ImageView a(final Activity activity, final FrameLayout frameLayout) {
        final hi hiVar = new hi(activity, hi.a(activity), null);
        final int iA = hiVar.a(56.0f);
        int iA2 = (iA - hiVar.a(20.0f)) / 2;
        final ImageView imageView = new ImageView(activity);
        imageView.setTag("UiHideFloatingButton");
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setPadding(iA2, iA2, iA2, iA2);
        imageView.setElevation(hiVar.a(6.0f));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA, iA);
        layoutParams.gravity = 8388659;
        imageView.setLayoutParams(layoutParams);
        imageView.post(new Runnable() {
            @Override
            public final void run() {
                wi.a(frameLayout, iA, hiVar, activity, imageView);
            }
        });
        final int scaledTouchSlop = ViewConfiguration.get(activity).getScaledTouchSlop();
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        final Ref.FloatRef floatRef2 = new Ref.FloatRef();
        final Ref.FloatRef floatRef3 = new Ref.FloatRef();
        final Ref.FloatRef floatRef4 = new Ref.FloatRef();
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final Ref.FloatRef floatRef5 = new Ref.FloatRef();
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return wi.a(floatRef, floatRef2, floatRef5, floatRef3, floatRef4, booleanRef, scaledTouchSlop, activity, frameLayout, view, motionEvent);
            }
        });
        return imageView;
    }

    public static final void a(FrameLayout frameLayout, int i2, hi hiVar, Activity activity, ImageView imageView) {
        float fCoerceAtLeast = RangesKt.coerceAtLeast(frameLayout.getWidth() - i2, 0.0f);
        float fCoerceAtLeast2 = RangesKt.coerceAtLeast(frameLayout.getHeight() - i2, 0.0f);
        if (Float.isNaN(i) || Float.isNaN(j)) {
            i = fCoerceAtLeast - hiVar.a(16.0f);
            j = (fCoerceAtLeast2 - hiVar.a(160.0f)) - hi.b(activity);
        }
        imageView.setX(RangesKt.coerceIn(i, 0.0f, fCoerceAtLeast));
        imageView.setY(RangesKt.coerceIn(j, 0.0f, fCoerceAtLeast2));
    }

    public static final boolean a(Ref.FloatRef floatRef, Ref.FloatRef floatRef2, Ref.FloatRef floatRef3, Ref.FloatRef floatRef4, Ref.FloatRef floatRef5, Ref.BooleanRef booleanRef, int i2, Activity activity, FrameLayout frameLayout, View view, MotionEvent motionEvent) throws NoWhenBranchMatchedException {
        switch (motionEvent.getActionMasked()) {
            case 0:
                floatRef.element = motionEvent.getRawX();
                floatRef2.element = motionEvent.getRawY();
                floatRef3.element = motionEvent.getRawX();
                floatRef4.element = view.getX();
                floatRef5.element = view.getY();
                booleanRef.element = false;
                view.animate().scaleX(0.92f).scaleY(0.92f).setStartDelay(0L).setDuration(80L).setInterpolator(new DecelerateInterpolator()).start();
                return true;
            case 1:
            case 3:
                if (booleanRef.element) {
                    view.animate().scaleX(1.0f).scaleY(1.0f).rotation(0.0f).setStartDelay(0L).setDuration(360L).setInterpolator(new OvershootInterpolator(3.0f)).start();
                } else {
                    view.animate().scaleX(1.0f).scaleY(1.0f).setStartDelay(0L).setDuration(120L).setInterpolator(new DecelerateInterpolator()).start();
                }
                if (booleanRef.element) {
                    i = view.getX();
                    j = view.getY();
                } else if (motionEvent.getActionMasked() == 1) {
                    int iOrdinal = d.ordinal();
                    if (iOrdinal == 0) {
                        b(activity);
                    } else if (iOrdinal == 1) {
                        a();
                        a(activity, ti.a);
                    } else if (iOrdinal == 2) {
                        pj pjVar = pj.a;
                        if (pj.d()) {
                            pj.a(false);
                        } else {
                            pj.o();
                            a(activity, ti.a);
                        }
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                return true;
            case 2:
                float rawX = motionEvent.getRawX() - floatRef.element;
                float rawY = motionEvent.getRawY() - floatRef2.element;
                if (!booleanRef.element) {
                    if ((rawY * rawY) + (rawX * rawX) > i2 * i2) {
                        booleanRef.element = true;
                        ObjectAnimator objectAnimator = a;
                        if (objectAnimator != null) {
                            objectAnimator.cancel();
                        }
                        a = null;
                        if (d == ti.b) {
                            a();
                            a(activity, ti.a);
                        }
                        view.animate().cancel();
                        view.setRotationY(0.0f);
                        view.setScaleX(0.92f);
                        view.setScaleY(0.92f);
                    }
                }
                if (booleanRef.element) {
                    float fCoerceAtLeast = RangesKt.coerceAtLeast(frameLayout.getWidth() - view.getWidth(), 0.0f);
                    float fCoerceAtLeast2 = RangesKt.coerceAtLeast(frameLayout.getHeight() - view.getHeight(), 0.0f);
                    view.setX(RangesKt.coerceIn(floatRef4.element + rawX, 0.0f, fCoerceAtLeast));
                    view.setY(RangesKt.coerceIn(floatRef5.element + rawY, 0.0f, fCoerceAtLeast2));
                    view.setRotation((RangesKt.coerceIn((motionEvent.getRawX() - floatRef3.element) * 1.6f, -22.0f, 22.0f) * 0.25f) + (view.getRotation() * 0.75f));
                }
                floatRef3.element = motionEvent.getRawX();
                return true;
            default:
                return true;
        }
    }
}
