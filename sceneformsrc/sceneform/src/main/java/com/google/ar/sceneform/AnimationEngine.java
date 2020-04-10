//package com.google.ar.sceneform;
//
//import com.google.ar.sceneform.rendering.CleanupRegistry;
//import com.google.ar.sceneform.rendering.ModelRenderable;
//import com.google.ar.sceneform.rendering.ResourceManager;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.Set;
//import java.util.WeakHashMap;
//
//public class AnimationEngine {
//    private static AnimationEngine animationEngine = null;
//    private final CleanupRegistry animatorCleanupQueue = new CleanupRegistry();
//    private final CleanupRegistry skeletonRigCleanupQueue = new CleanupRegistry();
//    private final CleanupRegistry animationDataCleanupQueue = new CleanupRegistry();
//    private final WeakHashMap renderableToListener = new WeakHashMap();
//    private final ArrayList gltfAnimators = new ArrayList();
//    private final HashSet renderablesToRemove = new HashSet();
//    private long lastFrameTimeMillis = 0L;
//    private AnimationPlayer gltfAnimationPlayer = null;
//
//    public static AnimationEngine getInstance() {
//        if (animationEngine == null) {
//            animationEngine = new AnimationEngine();
//        }
//
//        return animationEngine;
//    }
//
//    CleanupRegistry getAnimatorCleanupQueue() {
//        return this.animatorCleanupQueue;
//    }
//
//    CleanupRegistry getSkeletonRigCleanupQueue() {
//        return this.skeletonRigCleanupQueue;
//    }
//
//    CleanupRegistry getAnimationDataCleanupQueue() {
//        return this.animationDataCleanupQueue;
//    }
//
//    private AnimationEngine() {
//        ResourceManager.getInstance().addResourceHolder(this.animatorCleanupQueue);
//        ResourceManager.getInstance().addResourceHolder(this.skeletonRigCleanupQueue);
//        ResourceManager.getInstance().addResourceHolder(this.animationDataCleanupQueue);
//    }
//
//    public void update(long var1) {
//        Set var3;
//        (var3 = this.renderableToListener.keySet()).removeAll(this.renderablesToRemove);
//        this.renderablesToRemove.clear();
//        Iterator var4 = var3.iterator();
//
//        ModelRenderable var5;
//        AnimationEngine$AnimationEngineListener var6;
//        while(var4.hasNext()) {
//            var5 = (ModelRenderable)var4.next();
//            if ((var6 = (AnimationEngine$AnimationEngineListener)this.renderableToListener.get(var5)) != null) {
//                var6.onPreUpdate(var1);
//            }
//        }
//
//        ArrayList var7;
//        int var8 = (var7 = (ArrayList)this.gltfAnimators).size();
//        int var9 = 0;
//        var4 = null;
//
//        AnimationEngine$AnimationEngineListener var14;
//        Object var10000;
//        while(var9 < var8) {
//            var10000 = var7.get(var9);
//            ++var9;
//            if ((var14 = (AnimationEngine$AnimationEngineListener)var10000) != null) {
//                var14.onPreUpdate(var1);
//            }
//        }
//
//        if (AnimationLibraryLoader.isNativeLibraryInitialized()) {
//            advanceFrame(1L);
//        }
//
//        if (!this.gltfAnimators.isEmpty()) {
//            long var13 = var1 - this.lastFrameTimeMillis;
//            this.advanceGltfFrame(var13);
//        }
//
//        var4 = var3.iterator();
//
//        while(var4.hasNext()) {
//            (var5 = (ModelRenderable)var4.next()).onAnimationEngineUpdated();
//            if ((var6 = (AnimationEngine$AnimationEngineListener)this.renderableToListener.get(var5)) != null) {
//                var6.onPostUpdate();
//            }
//        }
//
//        ArrayList var10;
//        int var11 = (var10 = (ArrayList)this.gltfAnimators).size();
//        int var12 = 0;
//        var4 = null;
//
//        while(var12 < var11) {
//            var10000 = var10.get(var12);
//            ++var12;
//            if ((var14 = (AnimationEngine$AnimationEngineListener)var10000) != null) {
//                var14.onPostUpdate();
//            }
//        }
//
//        this.lastFrameTimeMillis = var1;
//    }
//
//    public void addRenderable(ModelRenderable var1, AnimationEngine$AnimationEngineListener var2) {
//        if (var1 != null) {
//            if (this.renderablesToRemove.contains(var1)) {
//                this.renderablesToRemove.remove(var1);
//            } else if (this.renderableToListener.containsKey(var1)) {
//                throw new IllegalStateException("Only one ModelAnimator may play on a ModelRenderable at a time");
//            }
//
//            this.renderableToListener.put(var1, var2);
//        }
//    }
//
//    public void addGltfAnimator(AnimationEngine$AnimationEngineListener var1) {
//        this.gltfAnimators.add(var1);
//    }
//
//    public void removeGltfAnimator(AnimationEngine$AnimationEngineListener var1) {
//        this.gltfAnimators.remove(var1);
//    }
//
//    public void removeRenderable(ModelRenderable var1) {
//        if (var1 != null) {
//            this.renderablesToRemove.add(var1);
//        }
//    }
//
//    public boolean hasRenderable(ModelRenderable var1) {
//        return this.renderableToListener.containsKey(var1);
//    }
//
//    private void advanceGltfFrame(long var1) {
//    }
//
//    private static native void advanceFrame(long var0);
//}
