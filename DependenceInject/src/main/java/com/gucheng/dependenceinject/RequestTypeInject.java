package com.gucheng.dependenceinject;

import android.app.Activity;
import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created on 2021/12/28.
 */
public class RequestTypeInject {
    public static final String TAG = "Reflection";

    public static void inject(Object object,Map map) {
        injectView(object, map);
    }

    public static void injectView(Object obj, Map map){
        Class clazz = obj.getClass();
//        Log.i(TAG, clazz.getDeclaredMethods().toString());
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(RequestType.class)) {
                RequestType requestType = method.getAnnotation(RequestType.class);
                map.put(requestType.type(),method.getName());
                Log.d("donald","requesttype is " + requestType.type()
                        +",method name is " + method.getName().toString());
                Log.d("donald", "map size is " + map.size());
                try {
                    method.invoke(obj);
                } catch (IllegalAccessException e) {
                    Log.d("donald", "access exception is " + e.getMessage());
                } catch (InvocationTargetException e) {
                    Log.d("donald", "invoke target exception is " + e.getMessage());
                }
            }
        }
    }
}
