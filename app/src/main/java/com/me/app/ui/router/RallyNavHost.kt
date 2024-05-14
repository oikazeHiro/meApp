package com.me.app.ui.router

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.me.app.ui.index.IndexPage
import com.me.app.ui.login.LoginPage

@Composable
fun RallyNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    NavHost(
        navController = navController,
        startDestination = "index",
        modifier = modifier,
    ){
        composable("index"){
            IndexPage(navController = navController)
        }
        composable("login"){
            LoginPage(navController = navController)
        }
    }
}