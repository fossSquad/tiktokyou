package com.windukk.hook.callbacks;

public interface UnhookInterface<T> {
    T getCallback();

    void unhook();
}
