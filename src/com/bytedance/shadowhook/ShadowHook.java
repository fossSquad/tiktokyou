package com.bytedance.shadowhook;

public final class ShadowHook {
    private static final int ERRNO_INIT_EXCEPTION = 101;
    private static final int ERRNO_LOAD_LIBRARY_EXCEPTION = 100;
    private static final int ERRNO_OK = 0;
    private static final int ERRNO_UNINIT = 2;
    private static final boolean defaultDebuggable = false;
    private static final boolean defaultDisable = false;
    private static final boolean defaultRecordable = false;
    private static final String libName = "shadowhook";
    private static final int recordItemAll = 2047;
    private static final int recordItemBackupLen = 128;
    private static final int recordItemCallerLibName = 2;
    private static final int recordItemErrno = 256;
    private static final int recordItemFlags = 1024;
    private static final int recordItemLibName = 8;
    private static final int recordItemNewAddr = 64;
    private static final int recordItemOp = 4;
    private static final int recordItemStub = 512;
    private static final int recordItemSymAddr = 32;
    private static final int recordItemSymName = 16;
    private static final int recordItemTimestamp = 1;
    private static boolean loaded = false;
    private static boolean inited = false;
    private static int initErrno = 2;
    private static long initCostMs = -1;
    private static final ILibLoader defaultLibLoader = null;
    private static final int defaultMode = Mode.SHARED.getValue();

    public interface ILibLoader {
        void loadLibrary(String str);
    }

    public enum RecordItem {
        TIMESTAMP,
        CALLER_LIB_NAME,
        OP,
        LIB_NAME,
        SYM_NAME,
        SYM_ADDR,
        NEW_ADDR,
        BACKUP_LEN,
        ERRNO,
        STUB,
        FLAGS
    }

    private static native String nativeGetArch();

    private static native boolean nativeGetDebuggable();

    private static native boolean nativeGetDisable();

    private static native int nativeGetInitErrno();

    private static native int nativeGetMode();

    private static native boolean nativeGetRecordable();

    private static native String nativeGetRecords(int i);

    private static native String nativeGetVersion();

    private static native int nativeInit(int i, boolean z);

    private static native void nativeSetDebuggable(boolean z);

    private static native void nativeSetDisable(boolean z);

    private static native void nativeSetRecordable(boolean z);

    private static native String nativeToErrmsg(int i);

    public static String getVersion() {
        return nativeGetVersion();
    }

    public static int init() {
        return init(null);
    }

    public static synchronized int init(Config config) {
        if (inited) {
            return initErrno;
        }
        inited = true;
        long start = System.currentTimeMillis();
        if (config == null) {
            config = new ConfigBuilder().build();
        }
        if (!loadLibrary(config)) {
            initErrno = ERRNO_LOAD_LIBRARY_EXCEPTION;
            initCostMs = System.currentTimeMillis() - start;
            return initErrno;
        }
        try {
            if (config.getDisable()) {
                nativeSetDisable(true);
            }
            if (config.getRecordable()) {
                nativeSetRecordable(config.getRecordable());
            }
            initErrno = nativeInit(config.getMode(), config.getDebuggable());
        } catch (Throwable th) {
            initErrno = ERRNO_INIT_EXCEPTION;
        }
        initCostMs = System.currentTimeMillis() - start;
        return initErrno;
    }

    public static int getInitErrno() {
        return initErrno;
    }

    public static long getInitCostMs() {
        return initCostMs;
    }

    public static Mode getMode() {
        if (loadLibrary()) {
            int nativeMode = nativeGetMode();
            if (Mode.UNIQUE.getValue() == nativeMode) {
                return Mode.UNIQUE;
            }
            if (Mode.MULTI.getValue() == nativeMode) {
                return Mode.MULTI;
            }
            return Mode.SHARED;
        }
        return Mode.SHARED;
    }

    public static boolean getDebuggable() {
        if (loadLibrary()) {
            return nativeGetDebuggable();
        }
        return false;
    }

    public static void setDebuggable(boolean debuggable) {
        if (loadLibrary()) {
            nativeSetDebuggable(debuggable);
        }
    }

    public static boolean getRecordable() {
        if (loadLibrary()) {
            return nativeGetRecordable();
        }
        return false;
    }

    public static void setRecordable(boolean recordable) {
        if (loadLibrary()) {
            nativeSetRecordable(recordable);
        }
    }

    public static boolean getDisable() {
        if (loadLibrary()) {
            return nativeGetDisable();
        }
        return false;
    }

    public static void setDisable(boolean disable) {
        if (loadLibrary()) {
            nativeSetDisable(disable);
        }
    }

    public static String toErrmsg(int errno) {
        if (errno == 0) {
            return "OK";
        }
        if (errno == 2) {
            return "Not initialized";
        }
        if (errno == ERRNO_LOAD_LIBRARY_EXCEPTION) {
            return "Load libshadowhook.so failed";
        }
        if (errno == ERRNO_INIT_EXCEPTION) {
            return "Init exception";
        }
        if (loadLibrary()) {
            return nativeToErrmsg(errno);
        }
        return "Unknown";
    }

    public static String getRecords(RecordItem... recordItems) {
        if (loadLibrary()) {
            int itemFlags = ERRNO_OK;
            int length = recordItems.length;
            for (int i = ERRNO_OK; i < length; i += recordItemTimestamp) {
                RecordItem recordItem = recordItems[i];
                switch (AnonymousClass1.$SwitchMap$com$bytedance$shadowhook$ShadowHook$RecordItem[recordItem.ordinal()]) {
                    case recordItemTimestamp /* 1 */:
                        itemFlags |= recordItemTimestamp;
                        break;
                    case 2:
                        itemFlags |= 2;
                        break;
                    case 3:
                        itemFlags |= recordItemOp;
                        break;
                    case recordItemOp /* 4 */:
                        itemFlags |= recordItemLibName;
                        break;
                    case 5:
                        itemFlags |= recordItemSymName;
                        break;
                    case 6:
                        itemFlags |= recordItemSymAddr;
                        break;
                    case 7:
                        itemFlags |= recordItemNewAddr;
                        break;
                    case recordItemLibName /* 8 */:
                        itemFlags |= recordItemBackupLen;
                        break;
                    case 9:
                        itemFlags |= recordItemErrno;
                        break;
                    case 10:
                        itemFlags |= recordItemStub;
                        break;
                    case 11:
                        itemFlags |= recordItemFlags;
                        break;
                }
            }
            if (itemFlags == 0) {
                itemFlags = recordItemAll;
            }
            return nativeGetRecords(itemFlags);
        }
        return null;
    }

    static  class AnonymousClass1 {
        static final  int[] $SwitchMap$com$bytedance$shadowhook$ShadowHook$RecordItem = new int[RecordItem.values().length];

        static {
            try {
                $SwitchMap$com$bytedance$shadowhook$ShadowHook$RecordItem[RecordItem.TIMESTAMP.ordinal()] = ShadowHook.recordItemTimestamp;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$bytedance$shadowhook$ShadowHook$RecordItem[RecordItem.CALLER_LIB_NAME.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$bytedance$shadowhook$ShadowHook$RecordItem[RecordItem.OP.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$bytedance$shadowhook$ShadowHook$RecordItem[RecordItem.LIB_NAME.ordinal()] = ShadowHook.recordItemOp;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$bytedance$shadowhook$ShadowHook$RecordItem[RecordItem.SYM_NAME.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$bytedance$shadowhook$ShadowHook$RecordItem[RecordItem.SYM_ADDR.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$bytedance$shadowhook$ShadowHook$RecordItem[RecordItem.NEW_ADDR.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$bytedance$shadowhook$ShadowHook$RecordItem[RecordItem.BACKUP_LEN.ordinal()] = ShadowHook.recordItemLibName;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$bytedance$shadowhook$ShadowHook$RecordItem[RecordItem.ERRNO.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$bytedance$shadowhook$ShadowHook$RecordItem[RecordItem.STUB.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$bytedance$shadowhook$ShadowHook$RecordItem[RecordItem.FLAGS.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
        }
    }

    public static String getArch() {
        if (loadLibrary()) {
            return nativeGetArch();
        }
        return "unknown";
    }

    private static synchronized boolean loadLibrary(Config config) {
        if (loaded) {
            return true;
        }
        if (config != null) {
            try {
                if (config.getLibLoader() == null) {
                    System.loadLibrary(libName);
                } else {
                    config.getLibLoader().loadLibrary(libName);
                }
            } catch (Throwable th) {
                return false;
            }
        } else {
            System.loadLibrary(libName);
        }
        loaded = true;
        return true;
    }

    private static boolean loadLibrary() {
        return loadLibrary(null);
    }

    public static class Config {
        private boolean debuggable;
        private boolean disable;
        private ILibLoader libLoader;
        private int mode;
        private boolean recordable;

        public void setLibLoader(ILibLoader libLoader) {
            this.libLoader = libLoader;
        }

        public ILibLoader getLibLoader() {
            return this.libLoader;
        }

        public void setMode(int mode) {
            this.mode = mode;
        }

        public int getMode() {
            return this.mode;
        }

        public void setDebuggable(boolean debuggable) {
            this.debuggable = debuggable;
        }

        public boolean getDebuggable() {
            return this.debuggable;
        }

        public void setRecordable(boolean recordable) {
            this.recordable = recordable;
        }

        public boolean getRecordable() {
            return this.recordable;
        }

        public void setDisable(boolean disable) {
            this.disable = disable;
        }

        public boolean getDisable() {
            return this.disable;
        }
    }

    public static class ConfigBuilder {
        private ILibLoader libLoader = ShadowHook.defaultLibLoader;
        private int mode = ShadowHook.defaultMode;
        private boolean debuggable = false;
        private boolean recordable = false;
        private boolean disable = false;

        public ConfigBuilder setLibLoader(ILibLoader libLoader) {
            this.libLoader = libLoader;
            return this;
        }

        public ConfigBuilder setMode(Mode mode) {
            this.mode = mode.getValue();
            return this;
        }

        public ConfigBuilder setDebuggable(boolean debuggable) {
            this.debuggable = debuggable;
            return this;
        }

        public ConfigBuilder setRecordable(boolean recordable) {
            this.recordable = recordable;
            return this;
        }

        public ConfigBuilder setDisable(boolean disable) {
            this.disable = disable;
            return this;
        }

        public Config build() {
            Config config = new Config();
            config.setLibLoader(this.libLoader);
            config.setMode(this.mode);
            config.setDebuggable(this.debuggable);
            config.setRecordable(this.recordable);
            config.setDisable(this.disable);
            return config;
        }
    }

    public enum Mode {
        SHARED(ShadowHook.ERRNO_OK),
        UNIQUE(ShadowHook.recordItemTimestamp),
        MULTI(2);

        private final int value;

        Mode(int value) {
            this.value = value;
        }

        int getValue() {
            return this.value;
        }
    }
}
