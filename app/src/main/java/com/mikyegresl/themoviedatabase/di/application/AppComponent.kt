package com.mikyegresl.themoviedatabase.di.application

import com.mikyegresl.themoviedatabase.data.repository.*
import com.mikyegresl.themoviedatabase.data.service.TmdbService
import com.mikyegresl.themoviedatabase.di.activity.ActivityComponent
import com.mikyegresl.themoviedatabase.utils.Constants
import dagger.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
internal annotation class AppScope

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {

    fun activityComponentBuilder(): ActivityComponent.Builder
}

@Module
internal abstract class AppModule {

    companion object {
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

    @AppScope
    @Binds
    abstract fun bindConfigurationRepository(impl: ConfigurationRepository): IConfigurationRepository

    @AppScope
    @Binds
    abstract fun bindMovieListRepository(impl: MovieListRepository): IMovieListRepository

    @AppScope
    @Binds
    abstract fun bindMovieDetailsRepository(impl: MovieDetailsRepository): IMovieDetailsRepository
}