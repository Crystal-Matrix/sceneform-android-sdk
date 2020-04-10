package com.google.ar.sceneform;

//public final class AnimationLibraryLoader {
//    private static final String ANIMATION_LIBRARY = "sceneform_animation";
//    private static boolean isNativeLibraryInitialized;
//    private static boolean isJavaOnlyInitialized = false;
//
//    private static boolean loadUnifiedJni() {
//        return false;
//    }
//
//    public static void initialize() {
//        if (!isJavaOnlyInitialized) {
//            if (!loadUnifiedJni()) {
//                System.loadLibrary("sceneform_animation");
//            }
//
//            isNativeLibraryInitialized = true;
//            initializeFactories();
//        }
//    }
//
//    public static void initializeWithoutNativeLibrary() {
//        initializeFactories();
//        isJavaOnlyInitialized = true;
//    }
//
//    public static void deinitializeFactories() {
//        AnimatorImpl.setFactory(AnimatorImpl.makeDefaultFactory());
//        AnimationData.setFactory(AnimationData.makeDefaultFactory());
//        SkeletonRig.setFactory(SkeletonRig.makeDefaultFactory());
//    }
//
//    public static boolean isNativeLibraryInitialized() {
//        return isNativeLibraryInitialized;
//    }
//
//    private static void initializeFactories() {
//        ModelAnimatorImpl.a();
//        ModelAnimationData.a();
//        ModelSkeletonRig.initializeFactory();
//    }
//
//    private AnimationLibraryLoader() {
//    }
//}
