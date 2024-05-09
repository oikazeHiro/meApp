package com.me.app.ui.component.index.layout

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.me.app.R

@Composable
fun MeDestination(){
    Text(text = R.string.me.toString(), maxLines = 1)
}