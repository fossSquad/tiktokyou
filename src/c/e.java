package c;

import java.util.ArrayList;
import java.util.Collections;

public final class e {
    public final b a;

    public e(b bVar, ArrayList arrayList) {
        this.a = bVar;
        Collections.unmodifiableList(new ArrayList(arrayList));
    }
}
