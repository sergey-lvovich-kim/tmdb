package com.mikyegresl.themoviedatabase.di.activity

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.mikyegresl.themoviedatabase.di.configuration.ConfigurationComponent
import dagger.*
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
internal annotation class ActivityScope

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

    fun configurationComponent(): ConfigurationComponent
}

@Module
internal class ActivityModule(activity: AppCompatActivity) {

    @ActivityScope
    @Provides
    fun bindFragmentManager(activity: AppCompatActivity): FragmentManager =
        activity.supportFragmentManager

    @ActivityScope
    @Provides
    fun bindLayoutInflater(activity: AppCompatActivity): LayoutInflater =
        LayoutInflater.from(activity)
}