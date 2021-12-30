package com.gucheng.rxjavaapp;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;

/**
 * Created on 2021/12/21.
 */
public class CreateOperatorDemo {

    public static void test1() {
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
