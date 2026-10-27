package com.windukk.mod.hooks;

import Z.m5;
import com.windukk.hook.HookMethod;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class c extends HookMethod {
    final Class a;
    final Method b;

    public c(Class cls, Method method) {
        this.a = cls;
        this.b = method;
    }

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] args = hookMethodParam.args;
        Object first = args[0];
        if (first instanceof List) {
            List list = (List) first;
            Class cls = this.a;
            Method method = this.b;
            List allowed = m5.b;
            List reordered = new ArrayList();
            ArrayList original = new ArrayList();
            for (Object obj : list) {
                if (cls.isInstance(obj)) {
                    Object value = null;
                    try {
                        value = method.invoke(obj, null);
                    } catch (Throwable ignored) {
                    }
                    if (allowed.contains(value)) {
                        reordered.add(obj);
                    }
                }
                original.add(obj);
            }
            if (!reordered.isEmpty()) {
                reordered.addAll(original);
                if (!reordered.equals(list)) {
                    for (int i = 0; i < reordered.size(); i++) {
                        try {
                            list.set(i, reordered.get(i));
                        } catch (UnsupportedOperationException e) {
                            list = reordered;
                        }
                    }
                }
            }
            args[0] = list;
        }
    }
}
