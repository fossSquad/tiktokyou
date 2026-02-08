package com.oplus.ocs.base.utils;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Field;
import java.util.HashMap;

public class c {
    public static final String a = "c";
    public static final HashMap<ClassLoader, HashMap<String, Parcelable.Creator<?>>> b = new HashMap<>();

    public static final <T extends Parcelable> T a(Parcel parcel, ClassLoader classLoader, String str) {
        Parcelable.Creator<?> creatorB = b(parcel, classLoader, str);
        if (creatorB == null) {
            return null;
        }
        return creatorB instanceof Parcelable.ClassLoaderCreator ? (T) ((Parcelable.ClassLoaderCreator) creatorB).createFromParcel(parcel, classLoader) : (T) creatorB.createFromParcel(parcel);
    }

    public static void a(Parcel parcel, Parcelable parcelable, String str) {
        if (parcelable == null) {
            parcel.writeString(null);
        } else {
            parcel.writeString(str);
            parcelable.writeToParcel(parcel, 0);
        }
    }

    public static Parcelable.Creator<?> b(Parcel parcel, ClassLoader classLoader, String str) {
        HashMap<String, Parcelable.Creator<?>> map;
        Parcelable.Creator<?> creator;
        if (parcel.readString() == null) {
            return null;
        }
        HashMap<ClassLoader, HashMap<String, Parcelable.Creator<?>>> map2 = b;
        synchronized (map2) {
            map = map2.get(classLoader);
            if (map == null) {
                map = new HashMap<>();
                map2.put(classLoader, map);
            }
            creator = map.get(str);
        }
        if (creator != null) {
            return creator;
        }
        try {
            Class<?> cls = Class.forName(str, false, classLoader);
            if (!Parcelable.class.isAssignableFrom(cls)) {
                throw new BadParcelableException("Parcelable protocol requires subclassing from Parcelable on class ".concat(String.valueOf(str)));
            }
            Field field = cls.getField("CREATOR");
            if ((field.getModifiers() & 8) == 0) {
                throw new BadParcelableException("Parcelable protocol requires the CREATOR object to be static on class ".concat(String.valueOf(str)));
            }
            if (!Parcelable.Creator.class.isAssignableFrom(field.getType())) {
                throw new BadParcelableException("Parcelable protocol requires a Parcelable.Creator object called CREATOR on class ".concat(String.valueOf(str)));
            }
            Parcelable.Creator<?> creator2 = (Parcelable.Creator) field.get(null);
            if (creator2 == null) {
                throw new BadParcelableException("Parcelable protocol requires a non-null Parcelable.Creator object called CREATOR on class ".concat(String.valueOf(str)));
            }
            synchronized (map2) {
                map.put(str, creator2);
            }
            return creator2;
        } catch (ClassNotFoundException unused) {
            throw new BadParcelableException("ClassNotFoundException when unmarshalling: ".concat(String.valueOf(str)));
        } catch (IllegalAccessException unused2) {
            throw new BadParcelableException("IllegalAccessException when unmarshalling: ".concat(String.valueOf(str)));
        } catch (NoSuchFieldException unused3) {
            throw new BadParcelableException("Parcelable protocol requires a Parcelable.Creator object called CREATOR on class ".concat(String.valueOf(str)));
        }
    }
}
