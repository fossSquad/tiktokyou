package com.oplus.ocs.base.task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class o implements Continuation<Void, Task<List<Task<?>>>> {
    public Collection a;

    public o(Collection collection) {
        this.a = collection;
    }

    @Override
    public final  Task<List<Task<?>>> then(Task<Void> task) {
        com.oplus.ocs.base.utils.d.a(task);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.a);
        return Tasks.forResult(arrayList);
    }
}
