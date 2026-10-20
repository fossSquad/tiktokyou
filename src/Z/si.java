package Z;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ni.shikatu.kotlin.Pair;
import ni.shikatu.kotlin.TuplesKt;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.ranges.RangesKt;

public abstract class si {
    public static WeakReference d;
    public static final float[] b = {0.18f, 0.66f, 0.5f, 0.34f, 0.82f, 0.66f};
    public static final float[] c = {0.18f, 0.34f, 0.5f, 0.66f, 0.82f, 0.34f};
    public static final Rect e = new Rect();
    public static final int[] f = new int[2];

    public static void a(ViewGroup viewGroup, View view, int i, int i2, Function0 function0, Function0 function1, Function0 function2) {
        FrameLayout frameLayout = null;
        oi oiVarA;
        boolean z;
        int i3;
        int i4;
        int iMin;
        WeakReference weakReference = d;
        if (weakReference == null || (oiVarA = (oi) weakReference.get()) == null) {
            a();
            frameLayout = viewGroup instanceof FrameLayout ? (FrameLayout) viewGroup : null;
            if (frameLayout == null) {
                return;
            }
            oiVarA = a(frameLayout);
            frameLayout.addView(oiVarA.a);
            frameLayout.addView(oiVarA.k);
            d = new WeakReference(oiVarA);
        } else {
            if (oiVarA.a.getParent() != viewGroup) {
                oiVarA = null;
            }
            if (oiVarA == null) {
                a();
                if (viewGroup instanceof FrameLayout) {
                }
                if (frameLayout == null) {
                    return;
                }
                oiVarA = a(frameLayout);
                frameLayout.addView(oiVarA.a);
                frameLayout.addView(oiVarA.k);
                d = new WeakReference(oiVarA);
            }
        }
        oiVarA.q = function0;
        oiVarA.r = function1;
        oiVarA.s = function2;
        ImageView imageView = oiVarA.d;
        float[] fArr = b;
        boolean z2 = i < i2;
        hi hiVar = oiVarA.f;
        imageView.setImageDrawable(new zd(z2 ? hiVar.e() : oiVarA.g, hiVar.a(2.0f), hiVar.a(18.0f), fArr));
        imageView.setEnabled(z2);
        ImageView imageView2 = oiVarA.e;
        float[] fArr2 = c;
        boolean z3 = i > 1;
        hi hiVar2 = oiVarA.f;
        imageView2.setImageDrawable(new zd(z3 ? hiVar2.e() : oiVarA.g, hiVar2.a(2.0f), hiVar2.a(18.0f), fArr2));
        imageView2.setEnabled(z3);
        hi hiVar3 = oiVarA.f;
        int i5 = oiVarA.h + oiVarA.j;
        int i6 = oiVarA.i;
        int iA = hiVar3.a(4.0f);
        int iA2 = hiVar3.a(8.0f);
        int[] iArr = f;
        viewGroup.getLocationInWindow(iArr);
        int i7 = iArr[0];
        int i8 = iArr[1];
        view.getLocationInWindow(iArr);
        int i9 = iArr[0] - i7;
        int i10 = iArr[1] - i8;
        int width = view.getWidth() + i9;
        int height = view.getHeight() + i10;
        int height2 = (view.getHeight() / 2) + i10;
        int i11 = (i9 + width) / 2;
        int iC = hi.c(viewGroup.getContext()) + iA2;
        int height3 = (viewGroup.getHeight() - hi.b(viewGroup.getContext())) - iA2;
        int iCoerceAtLeast = RangesKt.coerceAtLeast(height3 - i6, iC);
        int i12 = oiVarA.h / 2;
        ArrayList arrayList = new ArrayList();
        int i13 = (i9 - iA) - i5;
        if (i13 >= iA2) {
            arrayList.add(TuplesKt.to(Integer.valueOf(i13), Boolean.TRUE));
        }
        int i14 = width + iA;
        if (i14 + i5 <= viewGroup.getWidth() - iA2) {
            arrayList.add(TuplesKt.to(Integer.valueOf(i14), Boolean.FALSE));
        }
        if (arrayList.isEmpty()) {
            arrayList.add(TuplesKt.to(Integer.valueOf(iA2), Boolean.TRUE));
        }
        int iMax = Math.max(iC, (height2 - i6) + i12);
        int iMin2 = Math.min(iCoerceAtLeast, height2 - i12);
        int iCoerceIn = RangesKt.coerceIn(height2 - (i6 / 2), iC, iCoerceAtLeast);
        List listDistinct = iMax <= iMin2 ? CollectionsKt.distinct(CollectionsKt.listOf(new Integer[]{Integer.valueOf(RangesKt.coerceIn(iCoerceIn, iMax, iMin2)), Integer.valueOf(iMin2), Integer.valueOf(iMax)})) : CollectionsKt.listOf(Integer.valueOf(iCoerceIn));
        int i15 = oiVarA.n;
        int i16 = oiVarA.o + oiVarA.p;
        int iCoerceAtLeast2 = RangesKt.coerceAtLeast(height3 - i16, iC);
        int iCoerceAtLeast3 = RangesKt.coerceAtLeast((viewGroup.getWidth() - i15) - iA2, iA2);
        List listListOf = CollectionsKt.listOf(new Pair[]{TuplesKt.to(Integer.valueOf(height), Boolean.TRUE), TuplesKt.to(Integer.valueOf(i10 - i16), Boolean.FALSE)});
        ArrayList arrayList2 = new ArrayList();
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            Iterator it2 = it;
            Object next = it2.next();
            int i17 = i6;
            int iIntValue = ((Number) ((Pair) next).component1()).intValue();
            if (iC <= iIntValue && iIntValue <= iCoerceAtLeast2) {
                arrayList2.add(next);
            }
            it = it2;
            i6 = i17;
        }
        int i18 = i6;
        int iIntValue2 = ((Number) ((Pair) CollectionsKt.first(arrayList)).getFirst()).intValue();
        boolean zBooleanValue = ((Boolean) ((Pair) CollectionsKt.first(arrayList)).getSecond()).booleanValue();
        int iIntValue3 = ((Number) CollectionsKt.first(listDistinct)).intValue();
        int iIntValue4 = ((Number) CollectionsKt.first(a(i11, i15, iA2, iCoerceAtLeast3, i5, iA, width, i9, iIntValue2))).intValue();
        Pair pair = (Pair) CollectionsKt.firstOrNull(arrayList2);
        int iIntValue5 = pair != null ? ((Number) pair.getFirst()).intValue() : RangesKt.coerceIn(height - i16, iC, iCoerceAtLeast2);
        Pair pair2 = (Pair) CollectionsKt.firstOrNull(arrayList2);
        boolean zBooleanValue2 = pair2 != null ? ((Boolean) pair2.getSecond()).booleanValue() : true;
        int width2 = (viewGroup.getWidth() - iA2) - i5;
        Iterator it3 = CollectionsKt.listOf(new Boolean[]{Boolean.FALSE, Boolean.TRUE}).iterator();
        loop1: while (true) {
            if (!it3.hasNext()) {
                z = zBooleanValue;
                i3 = iIntValue4;
                i4 = iIntValue2;
                break;
            }
            boolean zBooleanValue3 = ((Boolean) it3.next()).booleanValue();
            Iterator it4 = it3;
            int size = arrayList.size();
            int i19 = iIntValue3;
            int i20 = 0;
            while (i20 < size) {
                Object obj = arrayList.get(i20);
                i20++;
                Pair pair3 = (Pair) obj;
                int iIntValue6 = ((Number) pair3.component1()).intValue();
                boolean zBooleanValue4 = ((Boolean) pair3.component2()).booleanValue();
                int i21 = size;
                int i22 = iIntValue6;
                Iterator it5 = a(i11, i15, iA2, iCoerceAtLeast3, i5, iA, width, i9, iIntValue6).iterator();
                while (it5.hasNext()) {
                    int i23 = i20;
                    int iIntValue7 = ((Number) it5.next()).intValue();
                    int i24 = iIntValue5;
                    int size2 = arrayList2.size();
                    ArrayList arrayList3 = arrayList;
                    int i25 = 0;
                    while (i25 < size2) {
                        Object obj2 = arrayList2.get(i25);
                        int i26 = i25 + 1;
                        Pair pair4 = (Pair) obj2;
                        ArrayList arrayList4 = arrayList2;
                        int iIntValue8 = ((Number) pair4.component1()).intValue();
                        boolean zBooleanValue5 = ((Boolean) pair4.component2()).booleanValue();
                        if (zBooleanValue3) {
                            iMin = zBooleanValue4 ? Math.min(i22, (iIntValue7 - iA) - i5) : Math.max(i22, iIntValue7 + i15 + iA);
                        } else {
                            iMin = i22;
                        }
                        if (!zBooleanValue3 || (iMin != i22 && iMin >= iA2 && iMin <= width2)) {
                            Iterator it6 = listDistinct.iterator();
                            while (it6.hasNext()) {
                                int i27 = i22;
                                int iIntValue9 = ((Number) it6.next()).intValue();
                                int i28 = i26;
                                if (iIntValue7 >= iMin + i5 || iIntValue7 + i15 <= iMin || iIntValue8 >= iIntValue9 + i18 || iIntValue8 + i16 <= iIntValue9) {
                                    int i29 = iMin;
                                    iIntValue5 = iIntValue8;
                                    i4 = i29;
                                    i3 = iIntValue7;
                                    zBooleanValue2 = zBooleanValue5;
                                    iIntValue3 = iIntValue9;
                                    z = zBooleanValue4;
                                    break loop1;
                                }
                                i26 = i28;
                                i22 = i27;
                            }
                        }
                        arrayList2 = arrayList4;
                        size2 = size2;
                        i25 = i26;
                        i22 = i22;
                    }
                    iIntValue5 = i24;
                    i20 = i23;
                    arrayList = arrayList3;
                }
                size = i21;
            }
            it3 = it4;
            iIntValue3 = i19;
        }
        float fCoerceIn = RangesKt.coerceIn(height2 - iIntValue3, i12, i18 - i12);
        oiVarA.c.f = z;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) oiVarA.b.getLayoutParams();
        int i30 = z ? 0 : oiVarA.j;
        if (layoutParams.leftMargin != i30) {
            layoutParams.leftMargin = i30;
            oiVarA.b.setLayoutParams(layoutParams);
            oiVarA.a.invalidateOutline();
        }
        float f2 = oiVarA.o / 2.0f;
        float fCoerceIn2 = RangesKt.coerceIn(i11 - i3, f2, i15 - f2);
        oiVarA.m.f = zBooleanValue2;
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) oiVarA.l.getLayoutParams();
        int i31 = zBooleanValue2 ? oiVarA.p : 0;
        if (layoutParams2.topMargin != i31) {
            layoutParams2.topMargin = i31;
            oiVarA.l.setLayoutParams(layoutParams2);
            oiVarA.k.invalidateOutline();
        }
        a(oiVarA, i4, iIntValue3, fCoerceIn, i3, iIntValue5, fCoerceIn2);
    }

    public static final void b(oi oiVar, View view) {
        oiVar.r.invoke();
    }

    public static final void c(oi oiVar, View view) {
        oiVar.s.invoke();
    }

    public static void a() {
        ValueAnimator valueAnimator;
        WeakReference weakReference = d;
        oi oiVar = weakReference != null ? (oi) weakReference.get() : null;
        d = null;
        if (oiVar != null && (valueAnimator = oiVar.u) != null) {
            valueAnimator.cancel();
        }
        ViewParent parent = oiVar != null ? oiVar.a.getParent() : null;
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(oiVar.a);
        }
        ViewParent parent2 = oiVar != null ? oiVar.k.getParent() : null;
        ViewGroup viewGroup2 = parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null;
        if (viewGroup2 != null) {
            viewGroup2.removeView(oiVar.k);
        }
    }

    public static final List a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int iMin;
        int iCoerceIn = RangesKt.coerceIn(i - (i2 / 2), i3, i4);
        if (i9 < i) {
            iMin = Math.max(iCoerceIn, i9 + i5 + i6);
        } else {
            iMin = Math.min(iCoerceIn, (i9 - i6) - i2);
        }
        List listListOf = CollectionsKt.listOf(new Integer[]{Integer.valueOf(iCoerceIn), Integer.valueOf(RangesKt.coerceIn(iMin, i3, i4)), Integer.valueOf(i7 - i2), Integer.valueOf(i8)});
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listListOf, 10));
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(RangesKt.coerceIn(((Number) it.next()).intValue(), i3, i4)));
        }
        return CollectionsKt.distinct(arrayList);
    }

    public static final void a(oi oiVar, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        oiVar.a.setX(((f3 - f2) * fFloatValue) + f2);
        oiVar.a.setY(((f5 - f4) * fFloatValue) + f4);
        ni niVar = oiVar.c;
        niVar.g = ((f7 - f6) * fFloatValue) + f6;
        niVar.invalidateSelf();
        oiVar.k.setX(((f9 - f8) * fFloatValue) + f8);
        oiVar.k.setY(((f11 - f10) * fFloatValue) + f10);
        pi piVar = oiVar.m;
        piVar.g = ((f13 - f12) * fFloatValue) + f12;
        piVar.invalidateSelf();
    }

    public static oi a(FrameLayout frameLayout) {
        Context context = frameLayout.getContext();
        boolean zA = hi.a(context);
        hi hiVar = new hi(context, zA, null);
        int iA = hiVar.a(38.0f);
        int iA2 = hiVar.a(80.0f);
        int iA3 = hiVar.a(6.0f);
        int i = zA ? -10855842 : -3684404;
        ni niVar = new ni(zA ? -14935010 : -1, iA3, hiVar.a(11.0f));
        FrameLayout frameLayout2 = new FrameLayout(context);
        frameLayout2.setTag("UiHideDepthControl");
        frameLayout2.setClickable(true);
        frameLayout2.setBackground(niVar);
        frameLayout2.setElevation(hiVar.a(6.0f));
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(iA + iA3, iA2, 8388659));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        frameLayout2.addView(linearLayout, new FrameLayout.LayoutParams(iA, iA2));
        frameLayout2.setOutlineProvider(new qi(linearLayout, iA, iA2));
        ImageView imageView = new ImageView(context);
        ImageView.ScaleType scaleType = ImageView.ScaleType.CENTER;
        imageView.setScaleType(scaleType);
        imageView.setContentDescription(k7.a("ui_hide_depth_up"));
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        View view = new View(context);
        int i2 = zA ? -12040118 : -3026474;
        float fA = hiVar.a(1.25f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i2);
        gradientDrawable.setCornerRadius(fA);
        view.setBackground(gradientDrawable);
        linearLayout.addView(view, new LinearLayout.LayoutParams(hiVar.a(14.0f), hiVar.a(2.5f)));
        ImageView imageView2 = new ImageView(context);
        imageView2.setScaleType(scaleType);
        imageView2.setContentDescription(k7.a("ui_hide_depth_down"));
        linearLayout.addView(imageView2, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        int iA4 = hiVar.a(7.0f);
        int iA5 = hiVar.a(40.0f);
        pi piVar = new pi(zA ? -14935010 : -1, iA4, hiVar.a(14.0f));
        FrameLayout frameLayout3 = new FrameLayout(context);
        frameLayout3.setTag("UiHideDepthHide");
        frameLayout3.setClickable(true);
        frameLayout3.setBackground(piVar);
        frameLayout3.setElevation(hiVar.a(6.0f));
        frameLayout3.setContentDescription(k7.a("ui_hide_action"));
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        linearLayout2.setPadding(hiVar.a(18.0f), 0, hiVar.a(18.0f), 0);
        TextView textView = new TextView(context);
        textView.setText(k7.a("ui_hide_action"));
        textView.setTextSize(2, 15.0f);
        textView.setTextColor(hiVar.e());
        textView.setSingleLine(true);
        linearLayout2.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        linearLayout2.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(iA5, 1073741824));
        int measuredWidth = linearLayout2.getMeasuredWidth();
        frameLayout3.addView(linearLayout2, new FrameLayout.LayoutParams(measuredWidth, iA5));
        frameLayout3.setLayoutParams(new FrameLayout.LayoutParams(measuredWidth, iA5 + iA4, 8388659));
        frameLayout3.setOutlineProvider(new ri(linearLayout2, measuredWidth, iA5));
        final oi oiVar = new oi(frameLayout2, linearLayout, niVar, imageView, imageView2, hiVar, i, iA, iA2, iA3, frameLayout3, linearLayout2, piVar, measuredWidth, iA5, iA4);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view2) {
                si.a(oiVar, view2);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view2) {
                si.b(oiVar, view2);
            }
        });
        frameLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view2) {
                si.c(oiVar, view2);
            }
        });
        return oiVar;
    }

    public static final void a(oi oiVar, View view) {
        oiVar.q.invoke();
    }

    public static void a(final oi oiVar, final float f2, final float f3, final float f4, final float f5, final float f6, final float f7) {
        ValueAnimator valueAnimator = oiVar.u;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        oiVar.u = null;
        if (!oiVar.t) {
            oiVar.t = true;
            oiVar.a.setX(f2);
            oiVar.a.setY(f3);
            ni niVar = oiVar.c;
            niVar.g = f4;
            niVar.invalidateSelf();
            oiVar.k.setX(f5);
            oiVar.k.setY(f6);
            pi piVar = oiVar.m;
            piVar.g = f7;
            piVar.invalidateSelf();
            FrameLayout frameLayout = oiVar.a;
            frameLayout.setAlpha(0.0f);
            frameLayout.setScaleX(0.8f);
            frameLayout.setScaleY(0.8f);
            frameLayout.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(140L).setInterpolator(new DecelerateInterpolator()).start();
            FrameLayout frameLayout2 = oiVar.k;
            frameLayout2.setAlpha(0.0f);
            frameLayout2.setScaleX(0.8f);
            frameLayout2.setScaleY(0.8f);
            frameLayout2.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(140L).setInterpolator(new DecelerateInterpolator()).start();
            return;
        }
        final float x = oiVar.a.getX();
        final float y = oiVar.a.getY();
        final float f8 = oiVar.c.g;
        final float x2 = oiVar.k.getX();
        final float y2 = oiVar.k.getY();
        final float f9 = oiVar.m.g;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(150L);
        valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator(1.6f));
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                si.a(oiVar, x, f2, y, f3, f8, f4, x2, f5, y2, f6, f9, f7, valueAnimator2);
            }
        });
        oiVar.u = valueAnimatorOfFloat;
        valueAnimatorOfFloat.start();
    }
}
