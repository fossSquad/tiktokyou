package com.coloros.ocs.base;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.oplus.ocs.base.common.CapabilityInfo;

public interface IAuthenticationListener extends IInterface {

    public static class Default implements IAuthenticationListener {
        @Override
        public IBinder asBinder() {
            return null;
        }

        @Override
        public void onFail(int i) {
        }

        @Override
        public void onSuccess(CapabilityInfo capabilityInfo) {
        }
    }

    public static abstract class Stub extends Binder implements IAuthenticationListener {

        public static class Proxy implements IAuthenticationListener {
            public static IAuthenticationListener sDefaultImpl;
            public IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.coloros.ocs.base.IAuthenticationListener";
            }

            @Override
            public void onFail(int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coloros.ocs.base.IAuthenticationListener");
                    parcelObtain.writeInt(i);
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onFail(i);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override
            public void onSuccess(CapabilityInfo capabilityInfo) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coloros.ocs.base.IAuthenticationListener");
                    if (capabilityInfo != null) {
                        parcelObtain.writeInt(1);
                        capabilityInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onSuccess(capabilityInfo);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.coloros.ocs.base.IAuthenticationListener");
        }

        public static IAuthenticationListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.coloros.ocs.base.IAuthenticationListener");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IAuthenticationListener)) ? new Proxy(iBinder) : (IAuthenticationListener) iInterfaceQueryLocalInterface;
        }

        public static IAuthenticationListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IAuthenticationListener iAuthenticationListener) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iAuthenticationListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = iAuthenticationListener;
            return true;
        }

        @Override
        public IBinder asBinder() {
            return this;
        }

        @Override
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString("com.coloros.ocs.base.IAuthenticationListener");
                return true;
            }
            if (i == 1) {
                parcel.enforceInterface("com.coloros.ocs.base.IAuthenticationListener");
                onSuccess(parcel.readInt() != 0 ? CapabilityInfo.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i != 2) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.coloros.ocs.base.IAuthenticationListener");
            onFail(parcel.readInt());
            parcel2.writeNoException();
            return true;
        }
    }

    void onFail(int i);

    void onSuccess(CapabilityInfo capabilityInfo);
}
