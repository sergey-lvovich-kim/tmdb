package com.mikyegresl.themoviedatabase.di.activity

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.mikyegresl.themoviedatabase.di.movie_details.MovieDetailsComponent
import com.mikyegresl.themoviedatabase.di.movie_list.MovieListComponent
import com.mikyegresl.themoviedatabase.ui.navigation.TmdbNavigator
import com.mikyegresl.themoviedatabase.ui.navigation.MovieListNavigator
import dagger.*
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
internal annotation class ActivityScope

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

    fun movieListComponent(): MovieListComponent
    fun movieDetailsComponent(): MovieDetailsComponent

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun bindActivity(activity: AppCompatActivity): Builder
        fun build(): ActivityComponent
    }
}

@Module
abstract class ActivityModule {

    companion object {
        @ActivityScope
        @Provides
        fun provideFragmentManager(activity: AppCompatActivity): FragmentManager =
            activity.supportFragmentManager

        @ActivityScope
        @Provides
        fun provideLayoutInflater(activity: AppCompatActivity): LayoutInflater =
            LayoutInflater.from(activity)
    }

    @ActivityScope
    @Binds
    abstract fun bindNavigator(impl: MovieListNavigator): TmdbNavigator
}