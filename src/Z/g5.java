package Z;

import android.view.View;
import android.view.ViewGroup;

public final class g5 extends ViewGroup {
    public int a;

    public g5(h5 h5Var) {
        super(h5Var);
    }

    @Override
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int width = (getWidth() - paddingLeft) - getPaddingRight();
        int paddingTop = getPaddingTop();
        int i5 = paddingLeft;
        int iMax = 0;
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (i5 > paddingLeft && i5 + measuredWidth > paddingLeft + width) {
                    paddingTop += iMax + this.a;
                    i5 = paddingLeft;
                    iMax = 0;
                }
                childAt.layout(i5, paddingTop, i5 + measuredWidth, paddingTop + measuredHeight);
                i5 += measuredWidth + this.a;
                iMax = Math.max(iMax, measuredHeight);
            }
        }
    }

    @Override
    public final void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingLeft, Integer.MIN_VALUE);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int i3 = 0;
        int iMax = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, iMakeMeasureSpec, iMakeMeasureSpec2);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (i4 > 0 && i4 + measuredWidth > paddingLeft) {
                    i4 = 0;
                    i3 = iMax + this.a + i3;
                    iMax = 0;
                }
                i4 += measuredWidth + this.a;
                iMax = Math.max(iMax, measuredHeight);
            }
        }
        setMeasuredDimension(size, getPaddingBottom() + getPaddingTop() + i3 + iMax);
    }
}
