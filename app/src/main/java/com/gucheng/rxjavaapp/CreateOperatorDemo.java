package com.gucheng.rxjavaapp;

import android.util.Log;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;

/**
 * Created on 2021/12/21.
 */
public class CreateOperatorDemo {
    private static final String TAG = "RxJavaTest";
//    public static void main(String[] args) {
//        System.out.println("====================");
//        test1();
//        System.out.println("====================");
//    }

    public static void testCreateAndMap() {
        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Object> emitter) throws Throwable {
                //事件产生的地方
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onNext(4);
                emitter.onNext(5);
                emitter.onComplete();

            }
        }).map(new Function<Object, Object>() {

            @Override
            public Object apply(Object o) throws Throwable {
                return (Integer)o * 2;
            }
        }).subscribe(new Consumer<Object>() {
            @Override
            public void accept(Object o) throws Throwable {
                Log.d(TAG,"accept object is " + o);
            }

        });
    }


    public static void subcribeNextAndError() {
        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Object> emitter) throws Throwable {
                //事件产生的地方
                emitter.onNext("1");
                emitter.onNext("2");
                emitter.onNext("1");
                emitter.onNext("3");
                emitter.onNext("6");
//                emitter.onComplete();
                emitter.onError(new Throwable("test error"));

            }
        }).subscribe(new Consumer<Object>() {
            @Override
            public void accept(Object o) throws Throwable {
                Log.d(TAG, "accept1...");
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Throwable {
                Log.d(TAG, "accept2... exception " + throwable);
            }
        });
    }

    public static void testJust() {
        Observable.just(10).subscribe(observer);
    }

    static Observer observer = new Observer<Object>() {
        @Override
        public void onSubscribe(@NonNull Disposable d) {
            Log.d(TAG, "onSubscribe");
        }

        @Override
        public void onNext(@NonNull Object o) {
            Log.d(TAG, "onNext object is " + o);
        }

        @Override
        public void onError(@NonNull Throwable e) {
            Log.d(TAG, "onError");
        }

        @Override
        public void onComplete() {
            Log.d(TAG, "onComplete");
        }
    };
}
