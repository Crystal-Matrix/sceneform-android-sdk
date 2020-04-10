//package com.google.ar.sceneform;
//
//import android.animation.Animator;
//import android.animation.TimeInterpolator;
//import com.google.ar.sceneform.rendering.ModelRenderable;
//import java.lang.ref.WeakReference;
//import java.util.ArrayList;
//
//class ModelAnimatorImpl extends AnimatorImpl implements AnimationEngineListener {
//    private ModelAnimator a;
//    private WeakReference b;
//    private WeakReference c;
//    private TimeInterpolator d;
//    private long e;
//    private long f;
//    private long g;
//    private boolean h;
//    private boolean i;
//    private boolean j;
//    private boolean k;
//    private long l;
//    private long m;
//    private int n;
//    private float o;
//    private float p;
//    private float q;
//    private float r;
//    private long s;
//
//    static void a() {
//        setFactory(new d());
//    }
//
//    private ModelAnimatorImpl(AnimationData var1, ModelRenderable var2) {
//        this.b = new WeakReference((Object)null);
//        this.c = new WeakReference((Object)null);
//        this.d = null;
//        this.e = 0L;
//        this.f = 0L;
//        this.h = false;
//        this.i = false;
//        this.j = false;
//        this.k = false;
//        this.m = -1L;
//        this.n = 0;
//        this.s = 0L;
//        this.b = new WeakReference(var1);
//        this.c = new WeakReference(var2);
//        this.e = var1 == null ? 0L : var1.getDurationMs();
//        this.f = this.e;
//        if (AnimationLibraryLoader.isNativeLibraryInitialized()) {
//            this.s = this.createAnimatorNative();
//            AnimationEngine.getInstance().getAnimatorCleanupQueue().register(this, new c(this.s));
//        }
//
//    }
//
//    private ModelAnimatorImpl(ModelAnimatorImpl var1) {
//        this.b = new WeakReference((Object)null);
//        this.c = new WeakReference((Object)null);
//        this.d = null;
//        this.e = 0L;
//        this.f = 0L;
//        this.h = false;
//        this.i = false;
//        this.j = false;
//        this.k = false;
//        this.m = -1L;
//        this.n = 0;
//        this.s = 0L;
//        this.a = null;
//        this.b = new WeakReference((AnimationData)var1.b.get());
//        this.c = new WeakReference((ModelRenderable)var1.c.get());
//        this.d = var1.d;
//        this.e = var1.e;
//        this.f = var1.f;
//        this.g = var1.g;
//        this.n = var1.n;
//        this.k = false;
//        this.j = false;
//        this.l = -1L;
//        if (AnimationLibraryLoader.isNativeLibraryInitialized()) {
//            this.s = this.createAnimatorNative();
//            AnimationEngine.getInstance().getAnimatorCleanupQueue().register(this, new c(this.s));
//        }
//
//    }
//
//    public final void a(ModelAnimator var1) {
//        this.a = var1;
//    }
//
//    public ModelRenderable getTarget() {
//        return (ModelRenderable)this.c.get();
//    }
//
//    public void setTarget(ModelRenderable var1) {
//        if (this.i) {
//            throw new IllegalStateException("setTarget() is not allowed on started ModelAnimator");
//        } else {
//            this.c = new WeakReference(var1);
//        }
//    }
//
//    public AnimationData getAnimationData() {
//        return (AnimationData)this.b.get();
//    }
//
//    public String getName() {
//        AnimationData var1;
//        return (var1 = (AnimationData)this.b.get()) == null ? "" : var1.getName();
//    }
//
//    public long getDurationMs() {
//        return this.e;
//    }
//
//    public long getTotalDurationMs() {
//        return this.n == -1 ? -1L : this.g + this.e * (long)(this.n + 1);
//    }
//
//    public int getRepeatCount() {
//        return this.n;
//    }
//
//    public long getStartDelayMs() {
//        return this.g;
//    }
//
//    public boolean isRunning() {
//        return this.h;
//    }
//
//    public boolean isStarted() {
//        return this.i;
//    }
//
//    public void setRepeatCount(int var1) {
//        if (var1 < -1) {
//            throw new IllegalArgumentException("Repeat count must be -1 or greater.");
//        } else {
//            this.n = var1;
//            this.a(var1 != 0);
//        }
//    }
//
//    public void setDurationMs(long var1) {
//        if (this.i) {
//            throw new IllegalStateException("setDuration() is not allowed on started ModelAnimator");
//        } else if (var1 < 0L) {
//            throw new IllegalArgumentException("setDuration() may not be negative");
//        } else {
//            this.e = var1;
//        }
//    }
//
//    public void setInterpolator(TimeInterpolator var1) {
//        this.d = var1;
//    }
//
//    public void setStartDelayMs(long var1) {
//        this.g = var1;
//    }
//
//    public void start() {
//        if (this.isStarted()) {
//            throw new IllegalStateException("Cannot call start while isStarted() is true.");
//        } else {
//            this.i = true;
//            this.k = false;
//            this.h = false;
//            this.m = -1L;
//            this.o = 0.0F;
//            this.q = 0.0F;
//            if (this.g == 0L) {
//                this.b();
//            }
//
//            AnimationEngine.getInstance().addRenderable(this.getTarget(), this);
//        }
//    }
//
//    public void pause() {
//        if (!this.k) {
//            this.k = true;
//            this.l = -1L;
//            this.j = false;
//        }
//    }
//
//    public void resume() {
//        if (!this.j && this.k) {
//            this.j = true;
//            this.k = false;
//            if (this.l > 0L) {
//                AnimationEngine.getInstance().addRenderable(this.getTarget(), this);
//            }
//
//        }
//    }
//
//    public void end() {
//        if (this.i) {
//            this.c();
//            if (this.s != 0L) {
//                ModelSkeletonRig var2 = (ModelSkeletonRig)this.getTargetSkeletonRig();
//                ModelAnimationData var3 = this.f();
//                if (var2 != null && var3 != null) {
//                    this.endAnimationNative(this.s, var3.b(), var2.getNativePointer());
//                }
//            }
//
//        }
//    }
//
//    public void cancel() {
//        if (this.i) {
//            this.d();
//            ModelAnimator var2;
//            ArrayList var3;
//            if ((var2 = this.a) != null && (var3 = var2.getListeners()) != null) {
//                ArrayList var6;
//                int var7 = (var6 = (ArrayList)var3).size();
//                int var8 = 0;
//                Object var4 = null;
//
//                while(var8 < var7) {
//                    Object var10000 = var6.get(var8);
//                    ++var8;
//                    Animator.AnimatorListener var5;
//                    if ((var5 = (Animator.AnimatorListener)var10000) != null) {
//                        var5.onAnimationCancel(var2);
//                    }
//                }
//            }
//
//            this.b(0.0F);
//        }
//    }
//
//    public void onPreUpdate(long var1) {
//        if (this.m < 0L) {
//            this.m = var1 + this.g;
//        }
//
//        if (this.k) {
//            this.l = var1;
//            AnimationEngine.getInstance().removeRenderable(this.getTarget());
//            this.b(0.0F);
//        } else {
//            if (this.j) {
//                this.j = false;
//                if (this.l > 0L) {
//                    this.m += var1 - this.l;
//                }
//            }
//
//            if (!this.h) {
//                if (this.m > var1) {
//                    return;
//                }
//
//                this.b();
//            }
//
//            float var3 = Math.max((float)(var1 - this.m), 0.0F);
//            if (this.e == 0L) {
//                this.p = var3;
//                this.r = var3;
//                this.b(3.4028235E38F);
//            } else {
//                this.p = Math.max(var3 / (float)this.e, this.o);
//                float var6 = this.p;
//                float var10001;
//                if (this.d == null) {
//                    var10001 = var6;
//                } else {
//                    float var7 = (float)Math.floor((double)var6);
//                    float var8 = var6 - var7;
//                    float var10 = Math.max(this.d.getInterpolation(var8) + var7, 0.0F);
//                    int var11;
//                    var10001 = (var11 = this.g()) == -1 ? var10 : Math.min(var10, (float)(var11 + 1));
//                }
//
//                this.r = Math.max(var10001, this.q);
//                float var4 = (this.r - this.q) * (float)this.f;
//                this.b(var4);
//            }
//        }
//    }
//
//    public void onPostUpdate() {
//        if (this.h && !this.k) {
//            boolean var1 = (int)this.p > (int)this.o;
//            int var2 = this.g();
//            this.q = this.a(this.r);
//            this.o = this.a(this.p);
//            boolean var3 = this.o >= (float)var2 && var2 != -1;
//            boolean var4 = this.o >= (float)(var2 + 1) && var2 != -1;
//            if (var1 && !var4) {
//                ModelAnimator var6;
//                ArrayList var7;
//                if ((var6 = this.a) != null && (var7 = var6.getListeners()) != null) {
//                    ArrayList var10;
//                    int var11 = (var10 = (ArrayList)var7).size();
//                    int var12 = 0;
//                    Object var8 = null;
//
//                    while(var12 < var11) {
//                        Object var10000 = var10.get(var12);
//                        ++var12;
//                        Animator.AnimatorListener var9;
//                        if ((var9 = (Animator.AnimatorListener)var10000) != null) {
//                            var9.onAnimationRepeat(var6);
//                        }
//                    }
//                }
//
//                if (var3) {
//                    this.a(false);
//                    return;
//                }
//            } else if (var4) {
//                this.c();
//            }
//
//        }
//    }
//
//    private final float a(float var1) {
//        int var2 = this.g();
//        if (var1 < 0.0F) {
//            var1 = 0.0F;
//        } else if (var2 != -1) {
//            var1 = Math.min(var1, (float)(var2 + 1));
//        }
//
//        return var1;
//    }
//
//    public String toString() {
//        String var2 = super.toString();
//        String var3 = String.valueOf(this.b.get());
//        String var4 = String.valueOf(this.c.get());
//        boolean var5 = this.i;
//        boolean var6 = this.h;
//        boolean var7 = this.k;
//        boolean var8 = this.j;
//        long var9 = this.m;
//        long var11 = this.e;
//        return (new StringBuilder(168 + String.valueOf(var2).length() + String.valueOf(var3).length() + String.valueOf(var4).length())).append(var2).append(", animationData=").append(var3).append(", target=").append(var4).append(", isStarted=").append(var5).append(", isRunning=").append(var6).append(", isPaused=").append(var7).append(", isResumed=").append(var8).append(", startTimeMs=").append(var9).append(", effectiveDurationMs=").append(var11).toString();
//    }
//
//    private final void b() {
//        this.h = true;
//        this.e();
//        if (this.s != 0L) {
//            ModelSkeletonRig var2 = (ModelSkeletonRig)this.getTargetSkeletonRig();
//            ModelAnimationData var3 = this.f();
//            if (var2 != null && var3 != null) {
//                this.a(this.n != 0);
//                this.playAnimationNative(this.s, var3.b(), var2.getNativePointer());
//            }
//        }
//
//    }
//
//    private final void c() {
//        if (this.i && !this.h) {
//            this.e();
//        }
//
//        this.d();
//        ModelAnimator var2;
//        ArrayList var3;
//        if ((var2 = this.a) != null && (var3 = var2.getListeners()) != null) {
//            ArrayList var6;
//            int var7 = (var6 = (ArrayList)var3).size();
//            int var8 = 0;
//            Object var4 = null;
//
//            while(var8 < var7) {
//                Object var10000 = var6.get(var8);
//                ++var8;
//                Animator.AnimatorListener var5;
//                if ((var5 = (Animator.AnimatorListener)var10000) != null) {
//                    var5.onAnimationEnd(var2);
//                }
//            }
//        }
//
//    }
//
//    private final void d() {
//        AnimationEngine.getInstance().removeRenderable(this.getTarget());
//        this.i = false;
//        this.h = false;
//        this.k = false;
//        this.j = false;
//        this.m = -1L;
//    }
//
//    private final void e() {
//        ModelAnimator var1;
//        if ((var1 = this.a) != null) {
//            ArrayList var2;
//            if ((var2 = var1.getListeners()) != null) {
//                ArrayList var5;
//                int var6 = (var5 = (ArrayList)var2).size();
//                int var7 = 0;
//                Object var3 = null;
//
//                while(var7 < var6) {
//                    Object var10000 = var5.get(var7);
//                    ++var7;
//                    Animator.AnimatorListener var4;
//                    if ((var4 = (Animator.AnimatorListener)var10000) != null) {
//                        var4.onAnimationStart(var1);
//                    }
//                }
//
//            }
//        }
//    }
//
//    private final ModelAnimationData f() {
//        AnimationData var1 = (AnimationData)this.b.get();
//        if (!AnimationLibraryLoader.isNativeLibraryInitialized()) {
//            throw new IllegalStateException("Native library called, but native library not found.");
//        } else if (var1 != null && !(var1 instanceof ModelAnimationData)) {
//            String var2 = var1.getClass().getName();
//            String var3 = ModelAnimationData.class.getName();
//            throw new IllegalStateException((new StringBuilder(17 + String.valueOf(var2).length() + String.valueOf(var3).length())).append("Cannot cast ").append(var2).append(" to  ").append(var3).toString());
//        } else {
//            return (ModelAnimationData)var1;
//        }
//    }
//
//    private final void b(float var1) {
//        if (this.s != 0L) {
//            ModelSkeletonRig var2;
//            if ((var2 = (ModelSkeletonRig)this.getTargetSkeletonRig()) != null) {
//                this.setPlaybackRateNative(this.s, var2.getNativePointer(), var1);
//            }
//        }
//    }
//
//    private final void a(boolean var1) {
//        if (this.s != 0L) {
//            ModelSkeletonRig var2 = (ModelSkeletonRig)this.getTargetSkeletonRig();
//            ModelAnimationData var3 = this.f();
//            if (var2 != null && var3 != null) {
//                this.setLoopingNative(this.s, var3.b(), var2.getNativePointer(), var1);
//            }
//        }
//
//    }
//
//    private native long createAnimatorNative();
//
//    private static native void destroyAnimatorNative(long var0);
//
//    private native void playAnimationNative(long var1, long var3, long var5);
//
//    private native void endAnimationNative(long var1, long var3, long var5);
//
//    private native void setPlaybackRateNative(long var1, long var3, float var5);
//
//    private native void setLoopingNative(long var1, long var3, long var5, boolean var7);
//
//    private final int g() {
//        return this.n == -1 ? this.n : Math.max((int)this.o, this.n);
//    }
//
//    static {
//        ModelAnimatorImpl.class.getSimpleName();
//    }
//}
