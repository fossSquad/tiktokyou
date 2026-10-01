package a;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class e {

    public final String f1a;
    public final List b;
    public final File c;
    public final boolean d;
    public final String e;

    public e(String str, List list, File file, boolean z, String str2) {
        this.f1a = str;
        this.b = Collections.unmodifiableList(new ArrayList(list));
        this.c = file;
        this.d = z;
        this.e = str2;
    }
}
