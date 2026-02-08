package com.oplus.ocs.base.common;

import com.oplus.ocs.base.common.api.Api;

public interface CapabilityListener {
    void onResult(Api[] apiArr, int[] iArr);
}
