package com.oplus.ocs.base.task;

public interface Continuation<TResult, TContinuationResult> {
    TContinuationResult then(Task<TResult> task);
}
