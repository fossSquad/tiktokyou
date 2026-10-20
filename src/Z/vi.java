package Z;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

public final class vi implements Application.ActivityLifecycleCallbacks {
    @Override
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override
    public final void onActivityPaused(Activity activity) {
        ImageView imageView;
        WeakReference weakReference = wi.b;
        if (((weakReference == null || (imageView = (ImageView) weakReference.get()) == null) ? null : imageView.getContext()) == activity) {
            pj pjVar = pj.a;
            pj.o();
            wi.d();
        }
    }

    @Override
    public final void onActivityResumed(Activity activity) {
        if (pj.f) {
            wi.f(activity);
        }
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
