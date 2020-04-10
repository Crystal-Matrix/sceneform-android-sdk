//package com.google.ar.sceneform;
//
//import android.animation.TimeInterpolator;
//import android.support.annotation.Nullable;
//import com.google.ar.sceneform.rendering.ModelRenderable;
//
//public class AnimatorImpl {
//    private static AnimatorImpl.Factory factory = makeDefaultFactory();
//
//    public static AnimatorImpl createInstance(AnimationData data, ModelRenderable target) {
//        return factory.create(data, target);
//    }
//
//    public static AnimatorImpl createInstance(AnimatorImpl source) {
//        return factory.create(source);
//    }
//
//    public static void setFactory(AnimatorImpl.Factory newFactory) {
//        factory = newFactory;
//    }
//
//    public static AnimatorImpl.Factory makeDefaultFactory() {
//        return new AnimatorImpl.Factory() {
//            @Nullable
//            public AnimatorImpl create(@Nullable AnimationData data, @Nullable ModelRenderable renderable) {
//                return new AnimatorImpl();
//            }
//
//            public AnimatorImpl create(AnimatorImpl source) {
//                return new AnimatorImpl();
//            }
//        };
//    }
//
//    protected AnimatorImpl() {
//    }
//
//    @Nullable
//    public ModelRenderable getTarget() {
//        return null;
//    }
//
//    public String getName() {
//        return "";
//    }
//
//    public void setTarget(@Nullable ModelRenderable target) {
//    }
//
//    @Nullable
//    public AnimationData getAnimationData() {
//        return null;
//    }
//
//    public long getDurationMs() {
//        return 0L;
//    }
//
//    public long getTotalDurationMs() {
//        return 0L;
//    }
//
//    public long getStartDelayMs() {
//        return 0L;
//    }
//
//    public int getRepeatCount() {
//        return 0;
//    }
//
//    public boolean isRunning() {
//        return false;
//    }
//
//    public boolean isStarted() {
//        return false;
//    }
//
//    public void setDurationMs(long durationMs) {
//    }
//
//    public void setInterpolator(TimeInterpolator value) {
//    }
//
//    public void setStartDelayMs(long startDelayMs) {
//    }
//
//    public void setRepeatCount(int repeatCount) {
//    }
//
//    public void start() {
//    }
//
//    public void pause() {
//    }
//
//    public void resume() {
//    }
//
//    public void end() {
//    }
//
//    public void cancel() {
//    }
//
//    @Nullable
//    protected SkeletonRig getTargetSkeletonRig() {
//        ModelRenderable target = this.getTarget();
//        return target != null ? target.getSkeletonRig() : null;
//    }
//
//    public abstract static class Factory {
//        public Factory() {
//        }
//
//        @Nullable
//        public abstract AnimatorImpl create(@Nullable AnimationData data, @Nullable ModelRenderable renderable);
//
//        public abstract AnimatorImpl create(AnimatorImpl source);
//    }
//}
