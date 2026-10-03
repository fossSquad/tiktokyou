package ni.shikatu.kotlin.jvm.internal;

import ni.shikatu.kotlin.Function;

public interface FunctionAdapter {
    Function<?> getFunctionDelegate();
}
