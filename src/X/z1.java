package X;

import android.app.Activity;
import android.app.Application;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;

public final class z1 implements Application.ActivityLifecycleCallbacks {
    @Override
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override
    public final void onActivityDestroyed(Activity activity) {
        if (((Activity) a2.f.get()) == activity) {
            a2.f = new WeakReference(null);
        }
    }

    @Override
    public final void onActivityPaused(Activity activity) {
        if (((Activity) a2.f.get()) == activity) {
            a2.f = new WeakReference(null);
        }
    }

    @Override
    public final void onActivityResumed(final Activity activity) {
        a2.f = new WeakReference(activity);
        a2.a((ContextWrapper) activity);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public final void run() {
                a2.a(activity);
            }
        }, 500L);
    }

    @Override
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override
    public final void onActivityStarted(Activity activity) {
    }

    @Override
    public final void onActivityStopped(Activity activity) {
    }
}
