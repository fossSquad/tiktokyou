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

public final class C1BOo implements C1BOb {
    public Context LIZ;
    public C1BOX LIZIZ;
    public boolean LIZJ;
    public WeakReference<C1BOY> LIZLLL;
    public final ServiceConnection LJ = new ServiceConnection() {
        @Override
        public final void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
            C1BOX c1box = null;
            if (new 0xR1().LIZIZ(11064, "com/oplus/ocs/hyperboost/OplusHyperBoostUnitImpl$1", "onServiceConnected", this, new Object[]{componentName, iBinder}, "void", new 0xPp(false, "(Landroid/content/ComponentName;Landroid/os/IBinder;)V", new 06HP("dzBzEg0qU9/PG1giVlyMf35aYwVEHZPCkyd+y9YIFU2QkCwI5+XP25tli4eGP75Z", (String[]) null))).LIZ) {
                return;
            }
            C1BOo c1BOo = this.LL;
            if (iBinder != null) {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.oplus.cosa.gamemanagersdk.IOplusHyperBoostService");
                c1box = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof C1BOX)) ? new C1BOX(iBinder) {
                    public final IBinder LL;

                    {
                        this.LL = iBinder;
                    }

                    @Override
                    public final void LJJL() {
                        Parcel parcelObtain = Parcel.obtain();
                        Parcel parcelObtain2 = Parcel.obtain();
                        try {
                            parcelObtain.writeInterfaceToken("com.oplus.cosa.gamemanagersdk.IOplusHyperBoostService");
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
                            parcelObtain.writeInterfaceToken("com.oplus.cosa.gamemanagersdk.IOplusHyperBoostService");
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
                            parcelObtain.writeInterfaceToken("com.oplus.cosa.gamemanagersdk.IOplusHyperBoostService");
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
                } : (C1BOX) iInterfaceQueryLocalInterface;
            }
            c1BOo.LIZIZ = c1box;
            this.LL.getClass();
        }

        @Override
        public final void onServiceDisconnected(ComponentName componentName) {
            this.LL.LIZIZ = null;
        }
    };
    public final C1BOn LJFF = new C1BOn(this);

    @Override
    public final void LIZ(Context context) {
        this.LIZ = context;
        Intent intent = new Intent("com.oplus.cosa.gamemanagersdk.IOplusHyperBoostService");
        intent.setPackage("com.oplus.cosa");
        Context context2 = this.LIZ;
        if (context2 != null) {
            0xGu.LJJJIL(context2, intent, this.LJ, 1, new 06HP("dzBzEg0qU9/PG1giVlyMf35aYwVEHZPCkyd+y9YIFU2QkCwI5+XP25tli4eGP75Z", (String[]) null));
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
        C1BOX c1box = this.LIZIZ;
        if (c1box == null || !this.LIZJ) {
            return false;
        }
        try {
            c1box.LJJL();
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    @Override
    public final boolean registerClient() {
        C1BOX c1box = this.LIZIZ;
        if (c1box == null || !this.LIZJ) {
            return false;
        }
        try {
            C1BOn c1BOn = this.LJFF;
            c1BOn.getClass();
            return c1box.LJJLIIJ(c1BOn);
        } catch (Exception unused) {
            return false;
        }
    }
}
