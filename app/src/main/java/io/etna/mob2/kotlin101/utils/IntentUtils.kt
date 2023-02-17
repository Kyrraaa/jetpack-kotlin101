package io.etna.mob2.kotlin101.utils

import android.app.Activity
import android.os.Build

class IntentUtils {
    companion object {

        // Selon la version d'android, on récupère la donnée différement
        @Suppress("UNCHECKED_CAST")
        fun <T : java.io.Serializable?> getSerializable(activity: Activity, name: String, clazz: Class<T>): T
        {
            return if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
                activity.intent.getSerializableExtra(name, clazz)!!
            else
                activity.intent.getSerializableExtra(name) as T
        }
    }
}