package util

import android.content.Context

class Prefutil {
    companion object{
        fun getTimerLength(context: Context): Int{
            return 1
        }
        private const val PREVIOUS_TIMER_LENGTH_SECONDS_ID = "com.giannos.timer.previous.timer.length"

    }
}