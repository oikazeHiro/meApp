package com.me.app.ui.login

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.me.app.R

@Composable
fun LoginPage(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    Column {
        Text(text = "loginPage")
        Button(onClick = {
            navController.navigate("index")
        }) {
            Text(text = stringResource(id = R.string.login))
        }
    }
}