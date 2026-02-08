package com.uber.h3core.util;

import X.0Vx6;
import java.util.Objects;

public class LatLng {
    public final double lat;
    public final double lng;

    public LatLng(double d, double d2) {
        this.lat = d;
        this.lng = d2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LatLng latLng = (LatLng) obj;
        return Double.compare(latLng.lat, this.lat) == 0 && Double.compare(latLng.lng, this.lng) == 0;
    }

    public int hashCode() {
        return Objects.hash(Double.valueOf(this.lat), Double.valueOf(this.lng));
    }

    public String toString() {
        return 0Vx6.m0("LatLng{lat=%f, lng=%f}", new Object[]{Double.valueOf(this.lat), Double.valueOf(this.lng)});
    }
}
