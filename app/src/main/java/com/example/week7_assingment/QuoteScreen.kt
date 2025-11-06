package com.example.week7_assingment

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun QuoteScreen(
    viewModel: QuoteViewModel,
    onShakeDetected: () -> Unit
) {
    LaunchedEffect(viewModel.isShakeDetected) {
        if (viewModel.isShakeDetected) {
            onShakeDetected()
            viewModel.onShakeAnimationComplete()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE1BEE7))
    ) {
        Header()
        QuoteContent(
            quote = viewModel.currentQuote,
            isShakeEnabled = viewModel.isShakeEnabled,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF6A1B9A))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Shake to Get a Quote",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Box(
            modifier = Modifier
                .size(24.dp)
                .background(Color.White.copy(alpha = 0.3f))
        )
    }
}

@Composable
fun QuoteContent(
    quote: String,
    isShakeEnabled: Boolean,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        AnimatedQuoteText(quote = quote)

        InstructionText(
            isEnabled = isShakeEnabled,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        )
    }
}

@Composable
fun AnimatedQuoteText(quote: String) {
    var visible by remember { mutableStateOf(true) }

    LaunchedEffect(quote) {
        visible = false
        kotlinx.coroutines.delay(150)
        visible = true
    }

    val scale by animateFloatAsState(
        targetValue = if (visible) 1f else 0.8f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = "quoteScale"
    )

    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(tween(300)) + scaleIn(
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessLow
            )
        ),
        exit = fadeOut(tween(150)) + scaleOut()
    ) {
        Text(
            text = quote,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF6A1B9A),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                }
        )
    }
}

@Composable
fun InstructionText(
    isEnabled: Boolean,
    modifier: Modifier = Modifier
) {
    val text = if (isEnabled) {
        "Shake your phone to get motivated! 💡"
    } else {
        "Shake detection paused"
    }

    Text(
        text = text,
        fontSize = 14.sp,
        color = Color(0xFF6A1B9A).copy(alpha = 0.7f),
        textAlign = TextAlign.Center,
        modifier = modifier
    )
}