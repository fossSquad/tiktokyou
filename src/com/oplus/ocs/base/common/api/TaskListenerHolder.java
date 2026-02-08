package com.oplus.ocs.base.common.api;

import X.0zxW;
import android.os.Looper;
import android.os.Message;
import com.oplus.ocs.base.common.constant.CommonStatusCodes;
import com.oplus.ocs.base.task.TaskImpl;

public class TaskListenerHolder<T> {
    public final String a = "TaskListenerHolder";
    public Looper b;
    public TaskImpl<T> c;
    public int d;
    public SuccessNotifier<T> e;
    public FailureNotifier<T> f;
    public TaskListenerHolder<T>.TaskListenerHandler g;

    public interface FailureNotifier<T> {
        void onNotifyListenerFailed(TaskImpl<T> taskImpl, int i, String str);
    }

    public interface SuccessNotifier<T> {
        void notifyListener(TaskImpl<T> taskImpl);
    }

    public class TaskListenerHandler extends com.oplus.ocs.base.common.a {
        public TaskListenerHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            0zxW.LIZ("TaskListenerHolder$TaskListenerHandler@9e7f.handleMessage");
            super/*android.os.Handler*/.handleMessage(message);
            if (message.what != 1) {
                throw new IllegalArgumentException();
            }
            TaskListenerHolder.a(TaskListenerHolder.this, message.arg1);
            0zxW.LIZIZ("TaskListenerHolder$TaskListenerHandler@9e7f.handleMessage");
        }
    }

    public TaskListenerHolder(Looper looper, TaskImpl<T> taskImpl, SuccessNotifier<T> successNotifier, FailureNotifier<T> failureNotifier) {
        this.b = looper;
        this.c = taskImpl;
        this.e = successNotifier;
        this.f = failureNotifier;
        this.g = new TaskListenerHandler(this.b);
    }

    public static  void a(TaskListenerHolder taskListenerHolder, int i) {
        if (i == 0) {
            SuccessNotifier<T> successNotifier = taskListenerHolder.e;
            if (successNotifier != null) {
                successNotifier.notifyListener(taskListenerHolder.c);
                return;
            }
            return;
        }
        FailureNotifier<T> failureNotifier = taskListenerHolder.f;
        if (failureNotifier != null) {
            failureNotifier.onNotifyListenerFailed(taskListenerHolder.c, i, CommonStatusCodes.getStatusCodeString(i));
        }
    }

    public FailureNotifier<T> getFailureNotifier() {
        return this.f;
    }

    public Looper getLooper() {
        return this.b;
    }

    public SuccessNotifier getOnTaskSuccessListener() {
        return this.e;
    }

    public TaskImpl<T> getTask() {
        return this.c;
    }

    public void setErrorCode(int i) {
        this.d = i;
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        messageObtain.arg1 = this.d;
        this.g.sendMessage(messageObtain);
    }
}
