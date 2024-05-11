package com.me.app.ui.component.index.layout

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.me.app.R

@Composable
fun ContactDestination(){
    Text(text = stringResource(id = R.string.contact), maxLines = 1)
}