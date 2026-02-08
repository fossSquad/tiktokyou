package com.oplus.ocs.base.task;

public interface OnCompleteListener<TResult> {
    void onComplete(Task<TResult> task);
}
