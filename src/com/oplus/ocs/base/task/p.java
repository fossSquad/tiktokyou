package com.oplus.ocs.base.task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class p<TResult> implements Continuation<Void, List<TResult>> {
    public Collection<? extends Task<?>> a;

    public p(Collection<? extends Task<?>> collection) {
        this.a = collection;
    }

    @Override
    public final  Object then(Task<Void> task) {
        com.oplus.ocs.base.utils.d.a(task);
        ArrayList arrayList = new ArrayList();
        Iterator<? extends Task<?>> it = this.a.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getResult());
        }
        return arrayList;
    }
}
