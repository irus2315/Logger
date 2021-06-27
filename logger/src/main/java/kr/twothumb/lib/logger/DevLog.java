package kr.twothumb.lib.logger;

import android.util.Log;

/**
 * Created by umjilee on 16. 4. 19..
 * 로그 클래스
 */
public class DevLog {
    private String TAG = "";

    private volatile static DevLog devLog;
    public static boolean enable = true;
    private static boolean setMethod = false;

    public static DevLog getInstance() {
        if (devLog == null) {
            synchronized (DevLog.class) {
                if (devLog == null) {
                    devLog = new DevLog();
                }
            }
        }
        return devLog;
    }

    public void init(String TAG) {
        getInstance().TAG = TAG;
    }


    public void init(String TAG, boolean enable) {
        getInstance();
        DevLog.enable = enable;
        getInstance().TAG = TAG;
    }

    public void setMethod(boolean setMethod) {
        this.setMethod = setMethod;
    }

    public static void v(Object... messages) {
        if (enable)
            Log.v(getInstance().TAG, buildMessage(objectToString(messages)));
    }

    public static void i(Object... messages) {
        if (enable)
            Log.i(getInstance().TAG, buildMessage(objectToString(messages)));
    }

    public static void d(Object... messages) {
        if (enable)
            Log.d(getInstance().TAG, buildMessage(objectToString(messages)));
    }

    public static void e(Object... messages) {
        if (enable)
            Log.e(getInstance().TAG, buildMessage(objectToString(messages)));
    }

    private static String buildMessage(String message) {

        StackTraceElement ste = Thread.currentThread().getStackTrace()[4];

        if (setMethod)
            return "[" +
                    ste.getFileName().replace(".java", "") +
                    "::" +
                    ste.getMethodName() +
                    "]" +
                    message;
        else
            return message;

    }

    private static String objectToString(Object... messages) {
        String message;
        if (messages != null && messages.length == 1) {
            // handle this common case without the extra cost of creating a stringbuffer:
            if (messages[0] == null) {
                message = "null";
            } else {
                message = messages[0].toString();
            }
        } else {
            StringBuilder sb = new StringBuilder();
            if (messages != null) for (Object m : messages) {
                sb.append(m);
            }
            message = sb.toString();
        }
        return message;
    }
}
