package X;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.lang.ref.WeakReference;

public abstract class C1BOW extends Binder implements IInterface {
    public C1BOW() {
        attachInterface(this, "com.oplus.cosa.gamemanagersdk.IOplusHyperBoostNotifier");
    }

    @Override
    public final IBinder asBinder() {
        return this;
    }

    @Override
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1598968902) {
            parcel2.writeString("com.oplus.cosa.gamemanagersdk.IOplusHyperBoostNotifier");
            return true;
        }
        if (i != 1) {
            return super.onTransact(i, parcel, parcel2, i2);
        }
        parcel.enforceInterface("com.oplus.cosa.gamemanagersdk.IOplusHyperBoostNotifier");
        String string = parcel.readString();
        C1BOn c1BOn = (C1BOn) this;
        WeakReference<C1BOY> weakReference = c1BOn.LL.LIZLLL;
        if (weakReference != null && weakReference.get() != null) {
            c1BOn.LL.LIZLLL.get().LIZ(string);
        }
        parcel2.writeNoException();
        return true;
    }
}
