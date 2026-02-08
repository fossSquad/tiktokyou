package com.oplus.ocs.base.internal;

import com.oplus.ocs.base.common.Feature;
import java.util.ArrayList;
import java.util.List;

public class ClientSettings {
    public String a;
    public int b;
    public List<Feature> c;

    public ClientSettings(String str) {
        this.a = str;
        this.b = 100011;
        this.c = new ArrayList();
    }

    public ClientSettings(String str, int i, List<Feature> list) {
        this.a = str;
        this.b = i;
        this.c = list;
    }

    public List<Feature> getList() {
        return this.c;
    }

    public String getPackageName() {
        return this.a;
    }

    public int getVersionCode() {
        return this.b;
    }
}
