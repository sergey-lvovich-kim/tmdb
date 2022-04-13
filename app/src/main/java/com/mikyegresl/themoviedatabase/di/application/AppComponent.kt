package com.mikyegresl.themoviedatabase.di.application

import android.app.Application
import com.mikyegresl.themoviedatabase.data.service.TmdbService
import com.mikyegresl.themoviedatabase.di.activity.ActivityComponent
import com.mikyegresl.themoviedatabase.di.configuration.ConfigurationComponent
import com.mikyegresl.themoviedatabase.di.tmdb.TmdbComponent
import com.mikyegresl.themoviedatabase.utils.Constants
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Scope
import kotlin.math.log

@Scope
@Retention(AnnotationRetention.RUNTIME)
internal annotation class AppScope

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {

//    fun configurationComponent(): ConfigurationComponent

    fun tmdbComponent(): TmdbComponent

    fun activityComponent(): ActivityComponent
}

@Module
internal class AppModule(private val application: Application) {

    @Provides
    fun provideApplication() = application

    @AppScope
    @Provides
    fun provideGsonConverterFactory(): Converter.Factory =
        GsonConverterFactory.create()

    @AppScope
    @Provides
    fun provideRxCallAdapterFactory(): CallAdapter.Factory =
        RxJava2CallAdapterFactory.create()

    @AppScope
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @AppScope
    @Provides
    fun provideHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(loggingInterceptor)
            .build()

    @AppScope
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: Converter.Factory,
        rxCallAdapterFactory: CallAdapter.Factory,
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(Constants.TMDB_BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(rxCallAdapterFactory)
            .client(okHttpClient)
            .build()

    @AppScope
    @Provides
    fun provideTmdbService(retrofit: Retrofit): TmdbService =
        retrofit.create(TmdbService::class.java)
}