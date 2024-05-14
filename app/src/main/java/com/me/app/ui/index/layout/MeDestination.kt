package com.me.app.ui.index.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.me.app.R

@Composable
fun MeDestination(navController: NavHostController,){
    Column {
        Text(text = stringResource(id = R.string.me), maxLines = 1)
        Button(onClick = {
            navController.navigate("login")
        }) {
            Text(text = stringResource(id = R.string.login))
        }
    }
}