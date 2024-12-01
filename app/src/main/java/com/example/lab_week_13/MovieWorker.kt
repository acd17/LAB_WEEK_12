package com.example.lab_week_13

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieWorker(
    private val context: Context, params: WorkerParameters
) : Worker(context, params) {
    // doWork() is called in a background thread
    // this is where you put the code that you want to run
    override fun doWork(): Result {
        val movieRepository = (context as MovieApplication)
            .movieRepository

        CoroutineScope(Dispatchers.IO).launch {
            movieRepository.fetchMoviesFromNetwork()
        }
        return Result.success()
    }
}