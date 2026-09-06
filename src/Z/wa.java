package Z;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.widget.FrameLayout;
public abstract class wa {
    public static Dialog a(Activity activity) {
        Dialog dialog = new Dialog(activity, R.style.Theme.Translucent.NoTitleBar);
        try {
            dialog.requestWindowFeature(1);
            return dialog;
        } catch (Throwable th) {
            return dialog;
        }
    }

    public static void a(Dialog dialog, ViewGroup viewGroup, int i, float f) {
        try {
            a(dialog.getWindow(), i, f);
            a(viewGroup);
            viewGroup.addOnAttachStateChangeListener(new va(dialog, i, f));
        } catch (Throwable th) {
            String strDecrypt = "Sheet window bind failed";
            Object obj = h6.a;
            h6.a(6, String.valueOf(strDecrypt), th);
        }
    }

    public static FrameLayout a(Activity activity, ViewGroup viewGroup, int i, View.OnClickListener onClickListener) {
        FrameLayout frameLayout = new FrameLayout(activity);
        frameLayout.setFitsSystemWindows(false);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if (onClickListener != null) {
            frameLayout.setOnClickListener(onClickListener);
        }
        viewGroup.setClickable(true);
        frameLayout.addView(viewGroup, new FrameLayout.LayoutParams(-1, i, 80));
        return frameLayout;
    }

    public static void a(Window window, int i, float f) {
        WindowInsetsController insetsController;
        if (window == null) {
            return;
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setWindowAnimations(0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        attributes.gravity = 80;
        if (f >= 0.0f) {
            attributes.dimAmount = f;
        }
        attributes.flags = (attributes.flags | (-2147483392)) & (-201327105);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            attributes.layoutInDisplayCutoutMode = 1;
        }
        window.setAttributes(attributes);
        if (f > 0.0f) {
            window.addFlags(2);
        } else if (f == 0.0f) {
            window.clearFlags(2);
        }
        View decorView = window.getDecorView();
        decorView.setFitsSystemWindows(false);
        if (i2 >= 30) {
            window.setDecorFitsSystemWindows(false);
        }
        View viewFindViewById = window.findViewById(R.id.content);
        if (viewFindViewById != null) {
            viewFindViewById.setFitsSystemWindows(false);
            if (viewFindViewById instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) viewFindViewById;
                viewGroup.setClipToPadding(false);
                viewGroup.setClipChildren(false);
            }
        }
        boolean z = Color.luminance(i) > 0.5f;
        decorView.setSystemUiVisibility(z ? 1808 : 1792);
        window.setStatusBarColor(0);
        window.setNavigationBarColor(i);
        if (i2 >= 27) {
            window.setNavigationBarDividerColor(i);
        }
        if (i2 >= 29) {
            window.setNavigationBarContrastEnforced(false);
        }
        if (i2 < 30 || (insetsController = window.getInsetsController()) == null) {
            return;
        }
        insetsController.setSystemBarsAppearance(z ? 16 : 0, 16);
    }

    public static void a(ViewGroup viewGroup) {
        final int paddingLeft = viewGroup.getPaddingLeft();
        final int paddingTop = viewGroup.getPaddingTop();
        final int paddingRight = viewGroup.getPaddingRight();
        final int paddingBottom = viewGroup.getPaddingBottom();
        viewGroup.setFitsSystemWindows(false);
        viewGroup.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
            @Override
            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                return wa.a(paddingLeft, paddingTop, paddingRight, paddingBottom, view, windowInsets);
            }
        });
        viewGroup.requestApplyInsets();
    }

    public static WindowInsets a(int i, int i2, int i3, int i4, View view, WindowInsets windowInsets) {
        int systemWindowInsetBottom;
        if (Build.VERSION.SDK_INT >= 30) {
            systemWindowInsetBottom = Math.max(windowInsets.getInsets(WindowInsets.Type.navigationBars()).bottom, windowInsets.getInsets(WindowInsets.Type.ime()).bottom);
        } else {
            systemWindowInsetBottom = windowInsets.getSystemWindowInsetBottom();
        }
        view.setPadding(i, i2, i3, i4 + systemWindowInsetBottom);
        return windowInsets;
    }
}
