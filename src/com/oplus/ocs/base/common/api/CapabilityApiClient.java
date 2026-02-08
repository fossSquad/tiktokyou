package com.oplus.ocs.base.common.api;

import X.0wS0;
import android.content.Context;
import com.oplus.ocs.base.common.AuthResult;
import com.oplus.ocs.base.common.CapabilityInfo;
import com.oplus.ocs.base.common.CapabilityListener;
import com.oplus.ocs.base.internal.ClientSettings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CapabilityApiClient {
    public static final String TAG = "CapabilityApiClient";
    public static volatile Map<Api, CapabilityInfo> sApis = new HashMap();

    public static CapabilityInfo buildCapabilityInfo(Context context, int i) {
        return new CapabilityInfo(new ArrayList(), 100011, new AuthResult(context.getPackageName(), 0, 0, i, new byte[4]));
    }

    public static synchronized void callback(Api[] apiArr, int[] iArr, CapabilityListener capabilityListener) {
        for (int i : iArr) {
            if (i == 0) {
                return;
            }
        }
        if (capabilityListener != null) {
            capabilityListener.onResult(apiArr, iArr);
        }
    }

    public static boolean checkCapability(Api api) {
        CapabilityInfo capabilityInfo;
        return sApis.containsKey(api) && (capabilityInfo = sApis.get(api)) != null && capabilityInfo.getAuthResult() != null && capabilityInfo.getAuthResult().getErrrorCode() == 1001;
    }

    public static void checkSelfCapabilities(final Context context, final Api[] apiArr, final CapabilityListener capabilityListener) {
        if (apiArr == null || apiArr.length == 0) {
            if (capabilityListener != null) {
                capabilityListener.onResult(new Api[0], new int[0]);
            }
            com.oplus.ocs.base.utils.a.a(TAG, "capa apis is empty");
            return;
        }
        final int[] iArr = new int[apiArr.length];
        for (final int i = 0; i < apiArr.length; i++) {
            final Api api = apiArr[i];
            if (sApis.containsKey(api)) {
                CapabilityInfo capabilityInfo = sApis.get(api);
                if (capabilityInfo == null || capabilityInfo.getAuthResult() == null) {
                    String str = TAG;
                    StringBuilder sbLIZ = 0wS0.LIZ();
                    sbLIZ.append(api.getName());
                    sbLIZ.append("sapis none");
                    com.oplus.ocs.base.utils.a.a(str, 0wS0.LIZIZ(sbLIZ));
                    iArr[i] = 7;
                } else {
                    iArr[i] = capabilityInfo.getAuthResult().getErrrorCode();
                }
                callback(apiArr, iArr, capabilityListener);
            } else if (api.isAuth()) {
                final l lVarA = l.a(context);
                ClientSettings clientSettings = new ClientSettings(context.getPackageName());
                i iVar = new i() {
                    @Override
                    public final void a(CapabilityInfo capabilityInfo2) {
                        if (capabilityInfo2 == null || capabilityInfo2.getAuthResult() == null) {
                            String str2 = CapabilityApiClient.TAG;
                            StringBuilder sbLIZ2 = 0wS0.LIZ();
                            sbLIZ2.append(api.getName());
                            sbLIZ2.append(" fail, capability is null");
                            com.oplus.ocs.base.utils.a.a(str2, 0wS0.LIZIZ(sbLIZ2));
                            iArr[i] = 7;
                            capabilityInfo2 = CapabilityApiClient.buildCapabilityInfo(context, 7);
                        } else {
                            iArr[i] = capabilityInfo2.getAuthResult().getErrrorCode();
                        }
                        CapabilityApiClient.sApis.put(api, capabilityInfo2);
                        CapabilityApiClient.callback(apiArr, iArr, capabilityListener);
                    }
                };
                com.oplus.ocs.base.utils.d.a(api, "api not be null");
                com.oplus.ocs.base.utils.d.a(clientSettings, "clientsettings not be null");
                if (!l.c.containsKey(api.getClientKey())) {
                    m mVar = new m(lVarA.a, api, null, clientSettings);
                    mVar.setOnClearListener(new j() {
                        public final  Api a;

                        public AnonymousClass3() {
                            api = api;
                        }

                        @Override
                        public final void a() {
                            l.a(api.getClientKey());
                        }
                    });
                    mVar.setOnCapabilityAuthListener(iVar);
                    l.c.put(api.getClientKey(), mVar);
                    lVarA.a(api);
                }
            } else {
                com.oplus.ocs.base.utils.a.a(TAG, "current capa doesn't need to authenticate.");
                iArr[i] = 1001;
                sApis.put(api, buildCapabilityInfo(context, 1001));
                callback(apiArr, iArr, capabilityListener);
            }
        }
    }

    public static CapabilityInfo getCapabilityInfo(Api api) {
        return sApis.get(api);
    }
}
