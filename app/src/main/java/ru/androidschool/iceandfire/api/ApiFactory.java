package ru.androidschool.iceandfire.api;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import io.realm.RealmList;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.androidschool.iceandfire.BuildConfig;
import ru.androidschool.iceandfire.content.RealmString;

/**
 * @author Artur Vasilov
 */
public final class ApiFactory {

    private static OkHttpClient sClient;

    private static volatile IceAndFireService sService;

    private ApiFactory() {
    }

    @NonNull
    public static IceAndFireService getIceAndFireService() {
        IceAndFireService service = sService;
        if (service == null) {
            synchronized (ApiFactory.class) {
                service = sService;
                if (service == null) {
                    service = sService = buildRetrofit().create(IceAndFireService.class);
                }
            }
        }
        return service;
    }

    public static void recreate() {
        sClient = null;
        sClient = getClient();
        sService = buildRetrofit().create(IceAndFireService.class);
    }

    @NonNull
    private static Retrofit buildRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.API_ENDPOINT)
                .client(getClient())
                .addConverterFactory(GsonConverterFactory.create(getGson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    private static Gson getGson(){
        return new GsonBuilder()
                .registerTypeAdapter(new TypeToken<RealmList<RealmString>>(){}.getType(),
                        RealmStringListTypeAdapter.INSTANCE).create();
    }

    @NonNull
    private static OkHttpClient getClient() {
        OkHttpClient client = sClient;
        if (client == null) {
            synchronized (ApiFactory.class) {
                client = sClient;
                if (client == null) {
                    client = sClient = buildClient();
                }
            }
        }
        return client;
    }

    @NonNull
    private static OkHttpClient buildClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(LoggingInterceptor.create())
                .build();
    }
}
