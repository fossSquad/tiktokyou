package X;

import android.app.Activity;
import com.bytedance.i18n.location.core.LocationClientImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

public final  class RunnableC00061Ajx implements Runnable {
    public final  LocationClientImpl LL;
    public final  long LLILL;
    public final  Function2 LLILLIZIL;

    public  RunnableC00061Ajx(LocationClientImpl locationClientImpl, long j, Function2 function2) {
        this.LL = locationClientImpl;
        this.LLILL = j;
        this.LLILLIZIL = function2;
    }

    @Override
    public final void run() {
        0bmk r1;
        final LocationClientImpl locationClientImpl = this.LL;
        final long j = this.LLILL;
        final Function2 function2 = this.LLILLIZIL;
        0zxW.LIZ("LocationClientImpl@13bd.checkConsentAsync$1L");
        locationClientImpl.getClass();
        0bn7 r0 = 0bn7.LIZ;
        0bn7.LIZLLL("LocationClient", "checkConsent:");
        0bmk r2 = locationClientImpl.LIZLLL;
        if (r2 == null || !r2.LJIJ() || (r1 = locationClientImpl.LIZLLL) == null) {
            0bn7.LIZJ("LocationClient", "init: not need consent", (Throwable) null);
            if (!locationClientImpl.isInitialized()) {
                locationClientImpl.LJJI(function2);
            } else if (function2 != null) {
                function2.invoke(0, "success");
            }
        } else {
            0boT r3 = locationClientImpl.LJI;
            if (r3 == null) {
                r3 = null;
            }
            if (r1.LJIIL((String) r3.LJJIIZI.invoke())) {
                0bn7.LIZJ("LocationClient", "init: not need consent", (Throwable) null);
                if (!locationClientImpl.isInitialized()) {
                    locationClientImpl.LJJI(function2);
                } else if (function2 != null) {
                    function2.invoke(0, "success");
                }
            } else {
                0bn7.LIZLLL("LocationClient", "checkConsent: need consent");
                0boT r4 = locationClientImpl.LJI;
                if (r4 == null) {
                    r4 = null;
                }
                Function0 function0 = r4.LJIJJLI;
                String str = function0 != null ? (String) function0.invoke() : null;
                0boT r5 = locationClientImpl.LJI;
                if (r5 == null) {
                    r5 = null;
                }
                final 0boP r10 = r5.LJJIJ;
                if (r10 != null) {
                    0bn7.LIZLLL("LocationClient", "checkConsent:");
                    Activity activity = (Activity) r10.LIZJ.invoke();
                    if (activity != null) {
                        StringBuilder sbLIZ = 0wS0.LIZ();
                        sbLIZ.append("checkConsent: ");
                        sbLIZ.append(activity);
                        0bn7.LIZLLL("LocationClient", 0wS0.LIZIZ(sbLIZ));
                        0bno r9 = new 0bno(r10, locationClientImpl, j, function2) {
                            public final  0boP LIZ;
                            public final  LocationClientImpl LIZIZ;
                            public final  Function2<Integer, String, Unit> LIZJ;

                            {
                                this.LIZJ = function2;
                            }

                            public final void LIZ(0bmt r6) {
                                0bn7 r7 = 0bn7.LIZ;
                                StringBuilder sbLIZ2 = 0wS0.LIZ();
                                sbLIZ2.append("onConsentResult ");
                                sbLIZ2.append(r6);
                                0bn7.LIZLLL("LocationClient", 0wS0.LIZIZ(sbLIZ2));
                                0bno r8 = this.LIZ.LIZLLL;
                                if (r8 != null) {
                                    r8.LIZ(r6);
                                }
                                this.LIZIZ.LJJI(this.LIZJ);
                            }
                        };
                        0bmk r6 = locationClientImpl.LIZLLL;
                        if (r6 != null) {
                            r6.LJJII(activity, r10.LIZ, (0bnO) r10.LIZIZ.invoke(), r9);
                            if (Unit.LIZ == null) {
                                0bn7.LIZJ("LocationClient", "checkConsent: activity is null, can't show consent", (Throwable) null);
                                if (function2 != null) {
                                    function2.invoke(-1003, "unconsented");
                                }
                                0N3e r7 = 0N3e.LIZ;
                                0N3e.LJFF(str, "Null activity");
                            }
                        } else {
                            0bn7.LIZJ("LocationClient", "checkConsent: activity is null, can't show consent", (Throwable) null);
                            if (function2 != null) {
                                function2.invoke(-1003, "unconsented");
                            }
                            0N3e r8 = 0N3e.LIZ;
                            0N3e.LJFF(str, "Null activity");
                        }
                    } else {
                        0bn7.LIZJ("LocationClient", "checkConsent: activity is null, can't show consent", (Throwable) null);
                        if (function2 != null) {
                            function2.invoke(-1003, "unconsented");
                        }
                        0N3e r11 = 0N3e.LIZ;
                        0N3e.LJFF(str, "Null activity");
                    }
                } else {
                    0bn7.LJ("LocationClient", "init: no PermissionDowngradeConsentConfig");
                    0N3e r12 = 0N3e.LIZ;
                    0N3e.LJFF(str, "No PermissionDowngradeConsentConfig");
                    if (function2 != null) {
                        function2.invoke(-1003, "unconsented");
                    }
                }
            }
        }
        0zxW.LIZIZ("LocationClientImpl@13bd.checkConsentAsync$1L");
    }
}
