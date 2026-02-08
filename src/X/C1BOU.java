package X;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.lang.ref.WeakReference;

public abstract class C1BOU extends Binder implements IInterface {
    public C1BOU() {
        attachInterface(this, "com.coloros.gamespace.gamesdk.IHyperBoostNotifier");
    }

    @Override
    public final IBinder asBinder() {
        return this;
    }

    @Override
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1598968902) {
            parcel2.writeString("com.coloros.gamespace.gamesdk.IHyperBoostNotifier");
            return true;
        }
        if (i != 1) {
            return super.onTransact(i, parcel, parcel2, i2);
        }
        parcel.enforceInterface("com.coloros.gamespace.gamesdk.IHyperBoostNotifier");
        String string = parcel.readString();
        C1BOl c1BOl = (C1BOl) this;
        WeakReference<C1BOY> weakReference = c1BOl.LL.LIZLLL;
        if (weakReference != null && weakReference.get() != null) {
            c1BOl.LL.LIZLLL.get().LIZ(string);
        }
        parcel2.writeNoException();
        return true;
    }
}
