package com.oplus.ocs.base;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface IServiceBroker extends IInterface {

    public static class Default implements IServiceBroker {
        @Override
        public IBinder asBinder() {
            return null;
        }

        @Override
        public IBinder getBinder(String str, String str2) {
            return null;
        }

        @Override
        public void handleAuthentication(String str, String str2, IAuthenticationListener iAuthenticationListener) {
        }
    }

    public static abstract class Stub extends Binder implements IServiceBroker {

        public static class Proxy implements IServiceBroker {
            public static IServiceBroker sDefaultImpl;
            public IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override
            public IBinder getBinder(String str, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.oplus.ocs.base.IServiceBroker");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getBinder(str, str2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readStrongBinder();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "com.oplus.ocs.base.IServiceBroker";
            }

            @Override
            public void handleAuthentication(String str, String str2, IAuthenticationListener iAuthenticationListener) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.oplus.ocs.base.IServiceBroker");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(iAuthenticationListener != null ? iAuthenticationListener.asBinder() : null);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().handleAuthentication(str, str2, iAuthenticationListener);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.oplus.ocs.base.IServiceBroker");
        }

        public static IServiceBroker asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.oplus.ocs.base.IServiceBroker");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IServiceBroker)) ? new Proxy(iBinder) : (IServiceBroker) iInterfaceQueryLocalInterface;
        }

        public static IServiceBroker getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IServiceBroker iServiceBroker) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iServiceBroker == null) {
                return false;
            }
            Proxy.sDefaultImpl = iServiceBroker;
            return true;
        }

        @Override
        public IBinder asBinder() {
            return this;
        }

        @Override
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString("com.oplus.ocs.base.IServiceBroker");
                return true;
            }
            if (i == 1) {
                parcel.enforceInterface("com.oplus.ocs.base.IServiceBroker");
                handleAuthentication(parcel.readString(), parcel.readString(), IAuthenticationListener.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i != 2) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.oplus.ocs.base.IServiceBroker");
            IBinder binder = getBinder(parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            parcel2.writeStrongBinder(binder);
            return true;
        }
    }

    IBinder getBinder(String str, String str2);

    void handleAuthentication(String str, String str2, IAuthenticationListener iAuthenticationListener);
}
