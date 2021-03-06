package ru.androidschool.iceandfire.test.api;

import android.os.SystemClock;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Random;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author Azat Galiullin
 */

public class MockingInterceptor implements Interceptor {

    private final RequestsHandler mHandlers;

    private final Random mRandom;


    public MockingInterceptor() {
        this.mHandlers = new RequestsHandler();
        this.mRandom = new SecureRandom();
    }

    public static MockingInterceptor create(){
        return new MockingInterceptor();
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        String path = request.url().encodedPath();
        if (mHandlers.shouldIntercept(path)) {
            Response response = mHandlers.proceed(request, path);
            int stubDelay = 500 + mRandom.nextInt(2500);
            SystemClock.sleep(stubDelay);
            return response;
        }
        return chain.proceed(request);
    }
}
