//package com.google.ar.sceneform;
//
//import android.support.annotation.Nullable;
//
//public abstract class AnimationData {
//    private static AnimationData.Factory factory = makeDefaultFactory();
//
//    public AnimationData() {
//    }
//
//    @Nullable
//    public static AnimationData createInstance(byte[] animationData, String name) {
//        return factory.create(animationData, name);
//    }
//
//    public static void setFactory(AnimationData.Factory factory) {
//        AnimationData.factory = factory;
//    }
//
//    public static AnimationData.Factory makeDefaultFactory() {
//        return new AnimationData.Factory() {
//            @Nullable
//            public AnimationData create(byte[] animationData, String name) {
//                return new AnimationData(this) {
//                    public String getName() {
//                        return "";
//                    }
//
//                    public long getDurationMs() {
//                        return 0L;
//                    }
//                };
//            }
//        };
//    }
//
//    public abstract String getName();
//
//    public abstract long getDurationMs();
//
//    public abstract static class Factory {
//        public Factory() {
//        }
//
//        @Nullable
//        public abstract AnimationData create(byte[] animationData, String name);
//    }
//}
