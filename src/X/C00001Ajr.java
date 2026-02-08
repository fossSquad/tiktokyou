package X;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.i18n.location.api.LocationData;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function0;

public final class C00001Ajr {
    public final 0boT LIZ;
    public final C1AjX LIZIZ;
    public final C1Ajq LIZJ = new BroadcastReceiver() {
        @Override
        public final void onReceive(Context context, Intent intent) {
            if (!0z7Y.LJIIJJI && intent != null) {
                if (!((ArrayList) 0N0j.LIZ).contains(intent.getAction()) && 0N0j.LIZ("onBroadcastReceiverReceive")) {
                    18E1.LIZIZ();
                }
            }
            if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                0bn7.LIZLLL("AppStatus", "onReceive");
                this.LIZ.LIZIZ.LIZ(1000L, "provider_status_change");
            } else {
                0xYo.LIZ();
                0bn7.LIZLLL("AppStatus", "onReceive");
                this.LIZ.LIZIZ.LIZ(1000L, "provider_status_change");
            }
        }
    };
    public final AtomicBoolean LIZLLL = new AtomicBoolean(false);
    public final AtomicBoolean LJ = new AtomicBoolean(true);
    public final Runnable LJFF = new Runnable() {
        @Override
        public final void run() {
            String strCertToken;
            final C00001Ajr c00001Ajr = this.LL;
            0zxW.LIZ("AppStatusManager@9e6.<init>$1L");
            0boT r13 = c00001Ajr.LIZ;
            0bn7 r0 = 0bn7.LIZ;
            StringBuilder sbLIZ = 0wS0.LIZ();
            sbLIZ.append("checkParamsAndReportIfNeeded coldStart=");
            sbLIZ.append(c00001Ajr.LJ.get());
            0bn7.LIZLLL("AppStatus", 0wS0.LIZIZ(sbLIZ));
            03qq r8 = r13.LJIIJJI;
            if (r8.LIZ && c00001Ajr.LJ.getAndSet(false)) {
                final long jCurrentTimeMillis = System.currentTimeMillis();
                long j = c00001Ajr.LIZ().LIZIZ().getLong("last_report_time", 0L);
                final 01o1 r7 = new 01o1();
                r7.element = c00001Ajr.LIZ().LIZIZ().getLong("first_report_time", 0L);
                final 01r3 r14 = new 01r3();
                int i = c00001Ajr.LIZ().LIZIZ().getInt("report_count", 0);
                r14.element = i;
                boolean z = jCurrentTimeMillis - j >= r8.LIZJ && i < r8.LIZIZ;
                final boolean z2 = jCurrentTimeMillis - r7.element >= r8.LIZLLL;
                StringBuilder sbLIZ2 = 0wS0.LIZ();
                sbLIZ2.append("checkParamsAndReport: last: ");
                sbLIZ2.append(jCurrentTimeMillis);
                sbLIZ2.append('-');
                sbLIZ2.append(j);
                sbLIZ2.append(' ');
                sbLIZ2.append(z ? ">=" : "<");
                sbLIZ2.append(' ');
                sbLIZ2.append(r8.LIZJ);
                0bn7.LIZLLL("AppStatus", 0wS0.LIZIZ(sbLIZ2));
                StringBuilder sbLIZ3 = 0wS0.LIZ();
                sbLIZ3.append("checkParamsAndReport: first: ");
                sbLIZ3.append(jCurrentTimeMillis);
                sbLIZ3.append('-');
                sbLIZ3.append(r7.element);
                sbLIZ3.append(' ');
                sbLIZ3.append(z2 ? ">=" : "<");
                sbLIZ3.append(' ');
                sbLIZ3.append(r8.LIZLLL);
                0bn7.LIZLLL("AppStatus", 0wS0.LIZIZ(sbLIZ3));
                StringBuilder sbLIZ4 = 0wS0.LIZ();
                sbLIZ4.append("checkParamsAndReport: reportCount=");
                sbLIZ4.append(r14.element);
                sbLIZ4.append(" maxReportCount=");
                sbLIZ4.append(r8.LIZIZ);
                0bn7.LIZLLL("AppStatus", 0wS0.LIZIZ(sbLIZ4));
                if (z || z2) {
                    Cert cert = r13.LJIIJ.LIZJ;
                    054k r5 = new 054k("getLocation", cert, (Cert) null, 4);
                    if (cert == null || (strCertToken = cert.certToken()) == null) {
                        strCertToken = "boot_request_location_info";
                    }
                    06vM.LIZ.LIZIZ(new 07Un() {
                        public final void accept(Object obj) {
                            01o1 r6 = r7;
                            long j2 = jCurrentTimeMillis;
                            boolean z3 = z2;
                            01r3 r4 = r14;
                            C00001Ajr c00001Ajr2 = c00001Ajr;
                            LocationData locationData = (LocationData) obj;
                            if (!locationData.LIZIZ()) {
                                0bn7 r1 = 0bn7.LIZ;
                                StringBuilder sbLIZ5 = 0wS0.LIZ();
                                sbLIZ5.append("get an invalid location due to:  err_code:");
                                sbLIZ5.append(locationData.errCode);
                                sbLIZ5.append(" err_msg:");
                                sbLIZ5.append(locationData.errMsg);
                                0bn7.LIZJ("AppStatus", 0wS0.LIZIZ(sbLIZ5), (Throwable) null);
                                return;
                            }
                            long j3 = r6.element;
                            if (j3 == 0) {
                                j3 = j2;
                            }
                            r6.element = j3;
                            if (z3) {
                                r6.element = j2;
                                r4.element = 0;
                            }
                            r4.element++;
                            c00001Ajr2.LIZ().LIZIZ().edit().putLong("last_report_time", j2).apply();
                            c00001Ajr2.LIZ().LIZIZ().edit().putLong("info_report", j2).apply();
                            c00001Ajr2.LIZ().LIZIZ().edit().putLong("first_report_time", r6.element).apply();
                            c00001Ajr2.LIZ().LIZIZ().edit().putInt("report_count", r4.element).apply();
                        }
                    }, new 054j(r5, 0L, 0L, strCertToken, 22));
                } else {
                    StringBuilder sbLIZ5 = 0wS0.LIZ();
                    sbLIZ5.append("checkParams: last collected at ");
                    sbLIZ5.append(j);
                    sbLIZ5.append(", first collected at ");
                    sbLIZ5.append(r7.element);
                    sbLIZ5.append(", will not collect in every ");
                    sbLIZ5.append((r8.LIZLLL / ((long) 1000)) / ((long) 60));
                    sbLIZ5.append(" minutes for ");
                    sbLIZ5.append(r8.LIZIZ);
                    sbLIZ5.append(" times");
                    0bn7.LIZLLL("AppStatus", 0wS0.LIZIZ(sbLIZ5));
                }
            }
            0bn7.LIZLLL("AppStatus", "check device info");
            long j2 = r13.LJIJJ;
            long j3 = c00001Ajr.LIZ().LIZIZ().getLong("info_report", 0L);
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            StringBuilder sbLIZ6 = 0wS0.LIZ();
            sbLIZ6.append("last ");
            sbLIZ6.append(j3);
            0bn7.LIZLLL("AppStatus", 0wS0.LIZIZ(sbLIZ6));
            if (jCurrentTimeMillis2 - j3 >= j2) {
                StringBuilder sbLIZ7 = 0wS0.LIZ();
                sbLIZ7.append("have expired ");
                sbLIZ7.append(j2);
                sbLIZ7.append(", will report info soon");
                0bn7.LIZLLL("AppStatus", 0wS0.LIZIZ(sbLIZ7));
                c00001Ajr.LIZIZ.LIZ(0L, "boot_upload_device_info");
                c00001Ajr.LIZ().LIZIZ().edit().putLong("info_report", jCurrentTimeMillis2).apply();
            } else {
                0bn7.LIZLLL("AppStatus", "Will not report info for again");
            }
            0zxW.LIZIZ("AppStatusManager@9e6.<init>$1L");
        }
    };
    public final 06vB LJI = 02vO.LIZIZ(new Function0() {
        public final Object invoke() {
            return this.LL.LIZIZ.LIZJ;
        }
    });

    public C00001Ajr(0boT r3, C1AjX c1AjX) {
        this.LIZ = r3;
        this.LIZIZ = c1AjX;
    }

    public final C1AkP LIZ() {
        return (C1AkP) this.LJI.getValue();
    }
}
