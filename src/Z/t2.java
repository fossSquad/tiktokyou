package Z;

import android.app.Activity;
import android.app.Application;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;

public final class t2 implements Application.ActivityLifecycleCallbacks {
    @Override
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override
    public final void onActivityDestroyed(Activity activity) {
        if (((Activity) u2.f.get()) == activity) {
            u2.f = new WeakReference(null);
        }
    }

    @Override
    public final void onActivityPaused(Activity activity) {
        if (((Activity) u2.f.get()) == activity) {
            u2.f = new WeakReference(null);
        }
    }

    @Override
    public final void onActivityResumed(final Activity activity) {
        u2.f = new WeakReference(activity);
        u2.a((ContextWrapper) activity);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public final void run() {
                u2.a(activity);
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
