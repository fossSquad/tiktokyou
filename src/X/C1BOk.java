package X;

import android.content.Context;
import android.os.Looper;
import com.oplus.ocs.base.common.CapabilityInfo;
import com.oplus.ocs.base.common.Feature;
import com.oplus.ocs.base.common.api.Api;
import com.oplus.ocs.base.common.api.BaseClient;
import com.oplus.ocs.base.common.api.OplusApi;
import com.oplus.ocs.base.internal.ClientSettings;
import java.util.ArrayList;
import java.util.List;

public final class C1BOk extends OplusApi<Api.ApiOptions.NoOptions, C1BOk> {
    public static final List<Feature> LIZ = new ArrayList();
    public static final Api<Api.ApiOptions.NoOptions> LIZIZ = new Api<>("HyperBoostClient.API", new Api.AbstractClientBuilder() {
        @Override
        public final Api.Client buildClient(final Context context, final Looper looper, ClientSettings clientSettings, Object obj) {
            return new BaseClient(context, looper) {
                @Override
                public final String getClientName() {
                    return "HYPER_BOOST_CLIENT";
                }
            };
        }
    }, new Api.ClientKey());
    public static C1BOk LIZJ = null;
    public static C1BOb LIZLLL = null;

    public C1BOk(Context context, C1BOb c1BOb) {
        super(context, LIZIZ, (Api.ApiOptions) null, new ClientSettings(context.getPackageName(), 100001, LIZ));
        LIZLLL = c1BOb;
        c1BOb.LIZ(context);
        checkCapability();
    }

    @Override
    public final void checkAuthResult(CapabilityInfo capabilityInfo) {
        LIZLLL.LIZIZ(capabilityInfo.getAuthResult());
    }

    @Override
    public final int getVersion() {
        return 100006;
    }

    @Override
    public final boolean hasFeature(String str) {
        return true;
    }

    @Override
    public final void init() {
    }
}
