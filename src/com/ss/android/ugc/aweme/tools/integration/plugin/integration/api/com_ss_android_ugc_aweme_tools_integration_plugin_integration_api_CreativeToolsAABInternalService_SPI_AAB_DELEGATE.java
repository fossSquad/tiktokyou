package com.ss.android.ugc.aweme.tools.integration.plugin.integration.api;

import X.02vM;
import X.02vO;
import X.06vB;
import X.C1AFd;
import com.ss.android.ugc.aweme.framework.services.annotation.IAabDelegate;
import com.ss.android.ugc.aweme.tools.aab.CameraDFInternalServiceImpl;
import java.util.ArrayList;

public final class com_ss_android_ugc_aweme_tools_integration_plugin_integration_api_CreativeToolsAABInternalService_SPI_AAB_DELEGATE implements IAabDelegate {
    public static final com_ss_android_ugc_aweme_tools_integration_plugin_integration_api_CreativeToolsAABInternalService_SPI_AAB_DELEGATE INSTANCE = new com_ss_android_ugc_aweme_tools_integration_plugin_integration_api_CreativeToolsAABInternalService_SPI_AAB_DELEGATE();
    public static final 06vB CameraDFInternalServiceImplinstance$delegate = 02vO.LIZ(02vM.PUBLICATION, new C1AFd());

    private final CameraDFInternalServiceImpl getCameraDFInternalServiceImplinstance() {
        return (CameraDFInternalServiceImpl) CameraDFInternalServiceImplinstance$delegate.getValue();
    }

    public CreativeToolsAABInternalService m0getService() {
        return getCameraDFInternalServiceImplinstance();
    }

    public ArrayList<CreativeToolsAABInternalService> m1getServices() {
        ArrayList<CreativeToolsAABInternalService> arrayList = new ArrayList<>();
        arrayList.add(getCameraDFInternalServiceImplinstance());
        return arrayList;
    }
}
