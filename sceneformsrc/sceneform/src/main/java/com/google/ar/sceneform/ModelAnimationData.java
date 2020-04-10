//package com.google.ar.sceneform;
//
//import com.google.ar.sceneform.rendering.CleanupRegistry;
//
//class ModelAnimationData extends AnimationData {
//    private long a;
//
//    static void a() {
//        CleanupRegistry var0 = AnimationEngine.getInstance().getAnimationDataCleanupQueue();
//        AnimationData.setFactory(new b(var0));
//    }
//
//    private ModelAnimationData(byte[] var1, String var2, CleanupRegistry var3) {
//        if (AnimationLibraryLoader.isNativeLibraryInitialized()) {
//            this.a = this.createAnimationDataNative(var1, var2);
//            var3.register(this, new a(this.a));
//        }
//
//    }
//
//    public String getName() {
//        return this.a != 0L ? this.getNameNative(this.a) : "";
//    }
//
//    public long getDurationMs() {
//        return this.a != 0L ? this.getDurationNative(this.a) : 0L;
//    }
//
//    final long b() {
//        return this.a;
//    }
//
//    private native long createAnimationDataNative(byte[] var1, String var2);
//
//    private static native void destroyAnimationDataNative(long var0);
//
//    private native String getNameNative(long var1);
//
//    private native long getDurationNative(long var1);
//
//    static {
//        ModelAnimationData.class.getSimpleName();
//    }
//}
//
