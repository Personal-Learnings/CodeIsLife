package com.learnings.practise.designpatterns;

/**
 * At any point of time we will have only one instance for the class per JVM.
 * Primarily used in Logging, Caching, Thread Pool and Configuration Classes.
 * In spring the default scope singleton is not one instance per JVM it is per spring container,
 *      so we don't have to use private constructor.
 * If we are not going to hold state data inside classes then Singleton is enough.
 */
public class Singleton {

    /** Lazy Initialization - only initialized when it is called for the first time */
    private Singleton singleton = null;

    public Singleton getInstance() {
        return (singleton == null) ? new Singleton() : singleton;
    }

    private Singleton() { }
}

class SingletonEager {
    /** Eager Initialization - Object is readily Initialized when the class loaded */
    private SingletonEager singleton = new SingletonEager();

    public SingletonEager getInstance() {
        return singleton;
    }

    private SingletonEager() { }
}

class SingletonThreadSafe {
    /** Lazy Initialization - only initialized when it is called for the first time */
    private SingletonThreadSafe singleton = null;

    /** The problem here is it will be slow as it can server only one thread at a time **/
    public SingletonThreadSafe getInstance() {
        synchronized (SingletonThreadSafe.class) {
            return (singleton == null) ? new SingletonThreadSafe() : singleton;
        }
    }

    private SingletonThreadSafe() { }
}

class SingletonThreadSafeFaster {
    /** Lazy Initialization - only initialized when it is called for the first time */
    private SingletonThreadSafeFaster singleton = null;

    /** To improve the performance we have to do a double lock kind of approach **/
    public SingletonThreadSafeFaster getInstance() {
        if(singleton == null) {
            synchronized (SingletonThreadSafeFaster.class) {
                return (singleton == null) ? new SingletonThreadSafeFaster() : singleton;
            }
        }
        return singleton;
    }

    private SingletonThreadSafeFaster() { }
}