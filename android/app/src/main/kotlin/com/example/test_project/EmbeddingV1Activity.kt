
package com.example.test_project
import android.content.Intent
import android.os.Build
import android.os.Bundle
import com.clevertap.android.sdk.CleverTapAPI
import com.clevertap.clevertap_plugin.CleverTapPlugin
import io.flutter.app.FlutterActivity

class EmbeddingV1Activity : FlutterActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CleverTapPlugin.registerWith(registrarFor("com.clevertap.clevertap_plugin"))
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)

        // On Android 12 and above, inform the notification click to get the above mentioned callback on dart side.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val cleverTapDefaultInstance = CleverTapAPI.getDefaultInstance(this)
            cleverTapDefaultInstance?.pushNotificationClickedEvent(intent.extras)
        }
    }
}
