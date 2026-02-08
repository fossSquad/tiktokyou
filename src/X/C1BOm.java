package X;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.oplus.ocs.base.common.AuthResult;
import java.lang.ref.WeakReference;

public final class C1BOm implements C1BOb {
    public Context LIZ;
    public C1BOV LIZIZ;
    public boolean LIZJ;
    public WeakReference<C1BOY> LIZLLL;
    public final ServiceConnection LJ = new ServiceConnection() {
        @Override
        public final void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
            C1BOV c1bov = null;
            if (new 0xR1().LIZIZ(11064, "com/oplus/ocs/hyperboost/HyperBoostUnitImpl$1", "onServiceConnected", this, new Object[]{componentName, iBinder}, "void", new 0xPp(false, "(Landroid/content/ComponentName;Landroid/os/IBinder;)V", new 06HP("dzBzEg0qU9/PG1giVlyMf35aYwVEHZPCkyB318YJH1u3QdbjtI7RJ5DW2Q==", (String[]) null))).LIZ) {
                return;
            }
            C1BOm c1BOm = this.LL;
            if (iBinder != null) {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.coloros.gamespace.gamesdk.IHyperBoostService");
                c1bov = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof C1BOV)) ? new C1BOV(iBinder) {
                    public final IBinder LL;

                    {
                        this.LL = iBinder;
                    }

                    @Override
                    public final void LJJL() {
                        Parcel parcelObtain = Parcel.obtain();
                        Parcel parcelObtain2 = Parcel.obtain();
                        try {
                            parcelObtain.writeInterfaceToken("com.coloros.gamespace.gamesdk.IHyperBoostService");
                            this.LL.transact(5, parcelObtain, parcelObtain2, 0);
                            parcelObtain2.readException();
                        } finally {
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        }
                    }

                    @Override
                    public final void LJJLIIIJLLLLLLLZ(String str) {
                        Parcel parcelObtain = Parcel.obtain();
                        Parcel parcelObtain2 = Parcel.obtain();
                        try {
                            parcelObtain.writeInterfaceToken("com.coloros.gamespace.gamesdk.IHyperBoostService");
                            parcelObtain.writeString(str);
                            this.LL.transact(4, parcelObtain, parcelObtain2, 0);
                            parcelObtain2.readException();
                        } finally {
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        }
                    }

                    @Override
                    public final boolean LJJLIIJ(IBinder iBinder2) {
                        Parcel parcelObtain = Parcel.obtain();
                        Parcel parcelObtain2 = Parcel.obtain();
                        try {
                            parcelObtain.writeInterfaceToken("com.coloros.gamespace.gamesdk.IHyperBoostService");
                            parcelObtain.writeStrongBinder(iBinder2);
                            this.LL.transact(2, parcelObtain, parcelObtain2, 0);
                            parcelObtain2.readException();
                            return parcelObtain2.readInt() != 0;
                        } finally {
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        }
                    }

                    @Override
                    public final IBinder asBinder() {
                        return this.LL;
                    }
                } : (C1BOV) iInterfaceQueryLocalInterface;
            }
            c1BOm.LIZIZ = c1bov;
            this.LL.getClass();
        }

        @Override
        public final void onServiceDisconnected(ComponentName componentName) {
            this.LL.LIZIZ = null;
        }
    };
    public final C1BOl LJFF = new C1BOl(this);

    @Override
    public final void LIZ(Context context) {
        this.LIZ = context;
        Intent intent = new Intent("com.coloros.gamespace.gamesdk.HyperBoostService");
        intent.setPackage("com.coloros.gamespace");
        Context context2 = this.LIZ;
        if (context2 != null) {
            0xGu.LJJJIL(context2, intent, this.LJ, 1, new 06HP("dzBzEg0qU9/PG1giVlyMf35aYwVEHZPCkyB318YJH1u3QdbjtI7RJ5DW2Q==", (String[]) null));
        }
    }

    @Override
    public final void LIZIZ(AuthResult authResult) {
        this.LIZJ = authResult.getErrrorCode() == 1001;
    }

    @Override
    public final boolean LIZJ(String str) {
        if (this.LIZIZ == null) {
            return false;
        }
        try {
            this.LIZIZ.LJJLIIIJLLLLLLLZ("{\"actionType\":9999,\"actionInfo\":\"" + str + "\"}");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override
    public final boolean LIZLLL(C1BOY c1boy) {
        this.LIZLLL = new WeakReference<>(c1boy);
        C1BOV c1bov = this.LIZIZ;
        if (c1bov == null || !this.LIZJ) {
            return false;
        }
        try {
            c1bov.LJJL();
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    @Override
    public final boolean registerClient() {
        C1BOV c1bov = this.LIZIZ;
        if (c1bov == null || !this.LIZJ) {
            return false;
        }
        try {
            C1BOl c1BOl = this.LJFF;
            c1BOl.getClass();
            return c1bov.LJJLIIJ(c1BOl);
        } catch (Exception unused) {
            return false;
        }
    }
}
