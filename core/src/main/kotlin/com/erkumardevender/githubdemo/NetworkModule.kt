package com.erkumardevender.githubdemo

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.erkumardevender.core.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(@ApplicationContext context: Context):OkHttpClient{
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        } else {
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE)
        }
        val builder = OkHttpClient.Builder()
        builder.networkInterceptors().add(httpLoggingInterceptor)
        builder.addInterceptor(ChuckerInterceptor.Builder(context).build())
        builder.addInterceptor(
            Interceptor {
                    chain:Interceptor.Chain->
                val original = chain.request()
                val requestBuilder: Request.Builder = original
                    .newBuilder()
                    .header("Accept", "application/vnd.github+json")
                    .header("Authorization", BuildConfig.ACCESS_TOKEN)
                val request: Request = requestBuilder.build()
                chain.proceed(request)
            }
        )
        return builder
            .readTimeout(Constant.API_READ_TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(Constant.API_CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(Constant.API_WRITE_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient):Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .baseUrl(BuildConfig.BASE_URL)
            .build()
    }

}