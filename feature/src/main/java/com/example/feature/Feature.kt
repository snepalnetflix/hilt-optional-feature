package com.example.feature

import android.content.Context
import com.google.common.base.Optional
import dagger.BindsOptionalOf
import dagger.Module
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.components.SingletonComponent

interface Feature {
    fun perform()

    @Module
    @InstallIn(SingletonComponent::class)
    interface FeatureModule {
        @BindsOptionalOf
        fun optionalFeature(): Feature
    }

    @EntryPoint
    @InstallIn(SingletonComponent::class)
    interface FeatureSingletonAccessor {
        fun getFeature(): Optional<Feature>
    }

    companion object {
        fun get(context: Context): Optional<Feature> {
            return EntryPointAccessors.fromApplication(
                context.applicationContext,
                FeatureSingletonAccessor::class.java
            ).getFeature()
        }
    }
}