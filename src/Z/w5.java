package Z;

import android.app.DatePickerDialog;
import android.text.TextUtils;
import android.text.method.DigitsKeyListener;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.function.LongConsumer;

public final class w5 {
    public final t5 a;
    public final Runnable b;

    public w5(t5 t5Var, Runnable runnable) {
        this.a = t5Var;
        this.b = runnable;
    }

    public final void a(long j) {
        ac.a().getClass();
        ac.e().a(j);
        this.b.run();
    }

    public final void b() {
        a(k7.a("filter_likes_sheet_title"), k7.a("filter_likes_sheet_desc"), y5.a().B, new LongConsumer() {
            @Override
            public final void accept(long j) {
                w5.this.a(j);
            }
        });
    }

    public final void c() {
        a(k7.a("filter_views_sheet_title"), k7.a("filter_views_sheet_desc"), y5.a().C, new LongConsumer() {
            @Override
            public final void accept(long j) {
                w5.this.b(j);
            }
        });
    }

    public final void a() {
        String str;
        fc fcVarA = new fc(this.a).b((CharSequence) k7.a("filter_date_sheet_title")).a((CharSequence) k7.a("filter_date_sheet_desc"));
        final long[] jArr = {y5.a().D};
        ec ecVar = new ec(fcVarA);
        String strA = k7.a("filter_input_from");
        if (ecVar.c == null) {
            TextView textViewA = fcVarA.a(14.0f, false, fcVarA.i);
            ecVar.c = textViewA;
            ecVar.a.addView(textViewA, 0);
        }
        ecVar.c.setText(strA);
        final EditText editText = ecVar.b;
        editText.setFocusable(false);
        editText.setCursorVisible(false);
        editText.setInputType(0);
        long j = jArr[0];
        if (j > 0) {
            str = new SimpleDateFormat("dd.MM.yyyy", Locale.US).format(new Date(j * 1000));
        } else {
            str = "";
        }
        editText.setText(str);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                w5.this.a(jArr, editText, view);
            }
        });
        ecVar.a.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                w5.this.b(jArr, editText, view);
            }
        });
        ecVar.a("ic_restart", new Runnable() {
            @Override
            public final void run() {
                w5.this.a(jArr, editText);
            }
        });
        fcVarA.a().addView(ecVar.b());
        fcVarA.b(k7.a("filter_save"), new Runnable() {
            @Override
            public final void run() {
                w5.this.a(jArr);
            }
        });
        fcVarA.d(k7.a("filter_cancel"), null);
        fcVarA.g();
    }

    public final void b(long j) {
        ac.a().getClass();
        ac.e().c(j);
        this.b.run();
    }

    public final  void b(long[] jArr, EditText editText, View view) {
        b(jArr, editText);
    }

    public final void b(final long[] jArr, final EditText editText) {
        Calendar calendar = Calendar.getInstance();
        long j = jArr[0];
        if (j > 0) {
            calendar.setTimeInMillis(j * 1000);
        }
        DatePickerDialog datePickerDialog = new DatePickerDialog(this.a, new DatePickerDialog.OnDateSetListener() {
            @Override
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                w5.a(jArr, editText, datePicker, i, i2, i3);
            }
        }, calendar.get(1), calendar.get(2), calendar.get(5));
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePickerDialog.show();
    }

    public final  void a(long[] jArr, EditText editText, View view) {
        b(jArr, editText);
    }

    public final void a(long[] jArr, EditText editText) {
        jArr[0] = 0;
        editText.setText("");
        ac.a().getClass();
        ac.e().b(0L);
        this.b.run();
    }

    public final void a(long[] jArr) {
        ac acVarA = ac.a();
        long jMax = Math.max(0L, jArr[0]);
        acVarA.getClass();
        ac.e().b(jMax);
        this.b.run();
    }

    public static void a(long[] jArr, TextView textView, DatePicker datePicker, int i, int i2, int i3) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(i, i2, i3, 0, 0, 0);
        calendar.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis() / 1000;
        jArr[0] = timeInMillis;
        textView.setText(new SimpleDateFormat("dd.MM.yyyy", Locale.US).format(new Date(timeInMillis * 1000)));
    }

    public final void a(String str, String str2, long j, final LongConsumer longConsumer) {
        final fc fcVarA = new fc(this.a).b((CharSequence) str).a((CharSequence) str2);
        fcVarA.w = true;
        final ec ecVar = new ec(fcVarA);
        String strA = k7.a("filter_input_from");
        if (ecVar.c == null) {
            TextView textViewA = fcVarA.a(14.0f, false, fcVarA.i);
            ecVar.c = textViewA;
            ecVar.a.addView(textViewA, 0);
        }
        ecVar.c.setText(strA);
        final EditText editText = ecVar.b;
        editText.setInputType(2);
        editText.setKeyListener(DigitsKeyListener.getInstance("0123456789"));
        if (j > 0) {
            editText.setText(String.valueOf(j));
        }
        editText.setSelection(editText.getText().length());
        fcVarA.a().addView(ecVar.b());
        final TextView textViewA2 = fcVarA.a(k7.a("filter_save"), (Runnable) null);
        fcVarA.d(k7.a("filter_cancel"), null);
        final boolean[] zArr = {false};
        Runnable runnable = new Runnable() {
            @Override
            public final void run() {
                w5.a(editText, zArr, ecVar, textViewA2, longConsumer);
            }
        };
        editText.addTextChangedListener(new v5(runnable));
        runnable.run();
        textViewA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                w5.a(editText, longConsumer, fcVarA, view);
            }
        });
        fcVarA.y.add(new Runnable() {
            @Override
            public final void run() {
                ecVar.a();
            }
        });
        fcVarA.g();
    }

    public static void a(final EditText editText, final boolean[] zArr, ec ecVar, TextView textView, final LongConsumer longConsumer) {
        long j;
        String str;
        String str2;
        String strTrim = editText.getText().toString().trim();
        if (strTrim.isEmpty()) {
            j = 0;
        } else {
            j = -1;
            try {
                long j2 = Long.parseLong(strTrim);
                if (j2 <= 100000000000L) {
                    j = j2;
                }
            } catch (NumberFormatException e) {
            }
        }
        boolean z = j < 0;
        zArr[0] = z;
        String strA = z ? k7.a("filter_error_too_big") : null;
        ecVar.b();
        boolean zIsEmpty = TextUtils.isEmpty(strA);
        if (!zIsEmpty) {
            ecVar.e.setText(strA);
        }
        ecVar.e.setVisibility(!zIsEmpty ? 0 : 4);
        ecVar.b.setTextColor(!zIsEmpty ? ecVar.g.e : ecVar.g.h);
        fc.a(textView, !zArr[0]);
        ecVar.a((zArr[0] ? "ic_close" : "ic_restart"), new Runnable() {
            @Override
            public final void run() {
                w5.a(editText, zArr, longConsumer);
            }
        });
    }

    public static  void a(EditText editText, boolean[] zArr, LongConsumer longConsumer) {
        editText.setText("");
        if (zArr[0]) {
            return;
        }
        longConsumer.accept(0L);
    }

    public static void a(EditText editText, LongConsumer longConsumer, fc fcVar, View view) {
        long j;
        String strTrim = editText.getText().toString().trim();
        if (strTrim.isEmpty()) {
            j = 0;
        } else {
            j = -1;
            try {
                long j2 = Long.parseLong(strTrim);
                if (j2 <= 100000000000L) {
                    j = j2;
                }
            } catch (NumberFormatException e) {
            }
        }
        if (j < 0) {
            return;
        }
        longConsumer.accept(j);
        fcVar.c((Runnable) null);
    }
}
