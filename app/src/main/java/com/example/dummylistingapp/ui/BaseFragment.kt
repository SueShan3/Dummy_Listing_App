package com.example.dummylistingapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BaseFragment : Fragment(), CoroutineScope {

    // job is background task in coroutines
    private lateinit var job: Job

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
    // Dispatchers to define our threads where we want to execute the job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Create Job instance
        job = Job()
    }

    override fun onDestroy() {
        super.onDestroy()
        // When fragment is destroyed, then just cancel the job
        job.cancel()
    }
}