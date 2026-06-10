package com.ss.android.ugc.aweme.pns.aab.event.api;

import X.04ES;
import X.05WW;
import X.05WY;
import X.C1KJm;
import com.ss.android.ugc.aweme.framework.services.annotation.IAabDelegate;
import com.ss.android.ugc.aweme.pns.aab.event.PNSAabEventServiceImpl;
import java.util.ArrayList;

public final class com_ss_android_ugc_aweme_pns_aab_event_api_IPNSAabEventService_SPI_AAB_DELEGATE implements IAabDelegate {
    public static final com_ss_android_ugc_aweme_pns_aab_event_api_IPNSAabEventService_SPI_AAB_DELEGATE INSTANCE = new com_ss_android_ugc_aweme_pns_aab_event_api_IPNSAabEventService_SPI_AAB_DELEGATE();
    public static final 04ES PNSAabEventServiceImplinstance$delegate = 05WY.LIZ(05WW.PUBLICATION, new C1KJm());

    private final PNSAabEventServiceImpl getPNSAabEventServiceImplinstance() {
        return (PNSAabEventServiceImpl) PNSAabEventServiceImplinstance$delegate.getValue();
    }

    public IPNSAabEventService m7getService() {
        return getPNSAabEventServiceImplinstance();
    }

    public ArrayList<IPNSAabEventService> m8getServices() {
        ArrayList<IPNSAabEventService> arrayList = new ArrayList<>();
        arrayList.add(getPNSAabEventServiceImplinstance());
        return arrayList;
    }
}
