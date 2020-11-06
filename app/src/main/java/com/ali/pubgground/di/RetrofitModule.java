package com.ali.pubgground.di;

import com.ali.pubgground.data.source.remote.PubggApiService;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import okhttp3.OkHttpClient;


@Module
@InstallIn(ApplicationComponent.class)
public class RetrofitModule {


    @Provides
    @Singleton
    public static HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }


    @Provides
    @Singleton
    public static  OkHttpClient provideOkHttpClient( HttpLoggingInterceptor interceptor){
        return new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }

    @Provides
    @Singleton
    public static GsonConverterFactory provideGsonConverterFactory() {
        return GsonConverterFactory.create();
    }


    @Provides
    @Singleton
    public static RxJava3CallAdapterFactory provideRxJavaCallAdapterFactory(){
        return RxJava3CallAdapterFactory.create();
    }

    @Provides
    @Singleton
    public static Retrofit  provideRetrofitBuilder(GsonConverterFactory gsonConverterFactory
            , RxJava3CallAdapterFactory rxJava3CallAdapterFactory , OkHttpClient client){
         return new Retrofit.Builder()
                .baseUrl("https://missions.pubgground.com/Api/")
                 .addConverterFactory(gsonConverterFactory)
                 .addCallAdapterFactory(rxJava3CallAdapterFactory)
                 .client(client)
                 .build();
    }

    @Provides
    @Singleton
    public static PubggApiService provideApiService(Retrofit retrofit){
       return  retrofit.create(PubggApiService.class);
    }


}