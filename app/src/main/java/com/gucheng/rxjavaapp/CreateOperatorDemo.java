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

    public static void test1() {
        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Object> emitter) throws Throwable {
                //事件产生的地方
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onNext(4);
                emitter.onNext(5);
//                emitter.onComplete();
                emitter.onError(new Throwable("test error"));

            }
        }).map(new Function<Object, Object>() {

            @Override
            public Object apply(Object o) throws Throwable {
                return (Integer)o * 2;
            }
        }).subscribe(new Consumer<Object>() {
            @Override
            public void accept(Object o) throws Throwable {
                System.out.println("accept1... " + o);
                Log.d(TAG,"accept object is " + o);
            }

        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Throwable {
                System.out.println("accept2..." + throwable);
            }
        });
    }


    public static void test2() {
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
                System.out.println("accept1... " + o);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Throwable {
                System.out.println("accept2..." + throwable);
            }
        });
    }

    Observer obeserver = new Observer<Object>() {
        @Override
        public void onSubscribe(@NonNull Disposable d) {
            Log.d(TAG, "");
        }

        @Override
        public void onNext(@NonNull Object o) {

        }

        @Override
        public void onError(@NonNull Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    };
}
