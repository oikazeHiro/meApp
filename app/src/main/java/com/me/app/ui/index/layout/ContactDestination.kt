package com.me.app.ui.index.layout

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.me.app.R

@Composable
fun ContactDestination(navController: NavHostController,){
    Text(text = stringResource(id = R.string.contact), maxLines = 1)
}