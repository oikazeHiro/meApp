package com.me.app.ui.component.index.layout

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.me.app.R

@Composable
fun MessageDestination() {
    Text(text = R.string.message.toString(), maxLines = 1)
}