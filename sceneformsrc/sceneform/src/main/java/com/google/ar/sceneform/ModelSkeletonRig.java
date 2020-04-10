//package com.google.ar.sceneform;
//
//import com.google.ar.sceneform.math.Matrix;
//import com.google.ar.sceneform.lullmodel.Mat4x3;
//import com.google.ar.sceneform.lullmodel.ModelInstanceDef;
//import com.google.ar.sceneform.lullmodel.SkeletonDef;
//import java.nio.FloatBuffer;
//
//public class ModelSkeletonRig extends SkeletonRig {
//    private static final String TAG = ModelSkeletonRig.class.getSimpleName();
//    private final FloatBuffer boneTransformsBuffer = makeBufferForBones(this.getBoneCount());
//    private long nativePointer;
//
//    public ModelSkeletonRig(SkeletonDef var1, ModelInstanceDef var2) {
//        super(var1, var2);
//        float[] var3 = new float[16];
//
//        for(int var4 = 0; var4 < this.getBoneCount(); ++var4) {
//            putMat4x3InBuffer(var3, this.boneTransformsBuffer, var1.boneTransforms(var4));
//        }
//
//        int[] var6 = new int[var2.shaderToMeshBonesLength()];
//
//        for(int var5 = 0; var5 < var6.length; ++var5) {
//            var6[var5] = var2.shaderToMeshBones(var5);
//        }
//
//        if (AnimationLibraryLoader.isNativeLibraryInitialized()) {
//            this.nativePointer = this.createSkeletonRigNative(this.boneTransformsBuffer, this.getBoneCount(), this.getMaterialBoneTransformsBuffer(), var6);
//        }
//
//        this.registerCleanupCallback();
//    }
//
//    private ModelSkeletonRig(ModelSkeletonRig var1) {
//        super(var1);
//        if (AnimationLibraryLoader.isNativeLibraryInitialized()) {
//            this.nativePointer = this.copySkeletonRigNative(var1.nativePointer, this.boneTransformsBuffer, this.getMaterialBoneTransformsBuffer());
//        }
//
//        this.registerCleanupCallback();
//    }
//
//    private void registerCleanupCallback() {
//        if (AnimationEngine.getInstance().getSkeletonRigCleanupQueue() != null && this.nativePointer != 0L) {
//            AnimationEngine.getInstance().getSkeletonRigCleanupQueue().register(this, new f(this.nativePointer));
//        }
//    }
//
//    public void getMatrixForBone(int var1, Matrix var2) {
//        int var3;
//        if (var1 >= this.getBoneCount()) {
//            var3 = this.getBoneCount();
//            throw new IllegalArgumentException((new StringBuilder(71)).append("boneIndex is out of range. boneIndex=").append(var1).append(", boneCount=").append(var3).toString());
//        } else {
//            var3 = var1 << 4;
//            if (this.boneTransformsBuffer.position() != var3) {
//                this.boneTransformsBuffer.position(var3);
//            }
//
//            this.boneTransformsBuffer.get(var2.data);
//        }
//    }
//
////    public boolean isAnimating(ModelRenderable var1) {
////        return AnimationEngine.getInstance().hasRenderable(var1);
////    }
//
//    public void updateBoneTransforms() {
//        if (this.nativePointer != 0L) {
//            this.updateBoneTransformsNative(this.nativePointer);
//        }
//
//    }
//
//    public ModelSkeletonRig makeCopy() {
//        return new ModelSkeletonRig(this);
//    }
//
//    long getNativePointer() {
//        return this.nativePointer;
//    }
//
//    private static void putMat4x3InBuffer(float[] var0, FloatBuffer var1, Mat4x3 var2) {
//        initializeMatrix(var0, var2);
//
//        for(int var3 = 0; var3 < var0.length; ++var3) {
//            var1.put(var0[var3]);
//        }
//
//    }
//
//    public static void initializeFactory() {
//        SkeletonRig.setFactory(new e());
//    }
//
//    private native long createSkeletonRigNative(FloatBuffer var1, int var2, FloatBuffer var3, int[] var4);
//
//    private native long copySkeletonRigNative(long var1, FloatBuffer var3, FloatBuffer var4);
//
//    private static native void destroySkeletonRigNative(long var0);
//
//    private native void updateBoneTransformsNative(long var1);
//}
