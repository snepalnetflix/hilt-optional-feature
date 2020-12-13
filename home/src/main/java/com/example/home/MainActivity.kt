package com.example.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.feature.Feature
import com.google.common.base.Optional
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint(AppCompatActivity::class)
class MainActivity : Hilt_MainActivity() {
    // Note, you must do a clean build after uncommenting these lines.
    //@Inject
    //lateinit var memberVariableFeature: Optional<Feature>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // This causes a compile failure.
        // Note, you must do a clean build after uncommenting these lines.
        //if (memberVariableFeature.isPresent) {
        //    memberVariableFeature.get().perform()
        //}

        // This causes a runtime crash.
        val entryPointFeature = Feature.get(this)
        if (entryPointFeature.isPresent) {
            entryPointFeature.get().perform()
        }
    }
}