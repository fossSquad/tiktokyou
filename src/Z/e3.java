package Z;

import android.app.Activity;
import android.app.Application;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.Set;

public final class e3 implements Application.ActivityLifecycleCallbacks {
    @Override
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        Set set = f3.g;
        synchronized (set) {
            set.add(activity);
        }
    }

    @Override
    public final void onActivityDestroyed(Activity activity) {
        Set set = f3.g;
        synchronized (set) {
            set.remove(activity);
        }
        if (((Activity) f3.f.get()) == activity) {
            f3.f = new WeakReference(null);
        }
    }

    @Override
    public final void onActivityPaused(Activity activity) {
        if (((Activity) f3.f.get()) == activity) {
            f3.f = new WeakReference(null);
        }
    }

    @Override
    public final void onActivityResumed(final Activity activity) {
        f3.f = new WeakReference(activity);
        Set set = f3.g;
        synchronized (set) {
            set.add(activity);
        }
        f3.a((ContextWrapper) activity);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public final void run() {
                f3.a(activity);
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
