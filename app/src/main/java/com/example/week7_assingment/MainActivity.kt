package com.example.week7_assingment

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver

class MainActivity : ComponentActivity() {

    private val viewModel: QuoteViewModel by viewModels()
    private lateinit var shakeDetector: ShakeDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Initialize the ShakeDetector once
        shakeDetector = ShakeDetector(this) {
            viewModel.onShakeDetected()
        }

        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // 2. Pass the initialized detector and viewmodel to the composable
                    QuoteApp(
                        viewModel = viewModel,
                        shakeDetector = shakeDetector
                    )
                }
            }
        }
    }

    // 3. REMOVED: onResume() and onPause() are no longer needed here.
    // The DisposableEffect in QuoteApp will handle this.
}

@Composable
fun QuoteApp(
    viewModel: QuoteViewModel,
    shakeDetector: ShakeDetector
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    // This effect correctly ties the ShakeDetector's lifecycle to the composable's
    DisposableEffect(lifecycleOwner, shakeDetector) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_RESUME -> shakeDetector.start()
                Lifecycle.Event.ON_PAUSE -> shakeDetector.stop()
                else -> {}
            }
        }

        lifecycleOwner.lifecycle.addObserver(observer)

        // This block is called when the composable leaves the screen
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
            // It's good practice to ensure the detector is stopped on final disposal
            shakeDetector.stop()
        }
    }

    // The actual UI that should be visible
    QuoteScreen(
        viewModel = viewModel,
        onShakeDetected = {
            // This callback is triggered from the ViewModel when a shake is confirmed
            Toast.makeText(
                context,
                "🎉 New quote loaded!",
                Toast.LENGTH_SHORT
            ).show()
        }
    )
}
