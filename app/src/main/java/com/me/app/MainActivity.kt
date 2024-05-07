package com.me.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.me.app.data.dto.Overview
import com.me.app.data.dto.rallyTabRowScreens
import com.me.app.ui.component.index.RallyNavHost
import com.me.app.ui.component.index.RallyTabRow
import com.me.app.ui.component.index.navigateSingleTopTo
import com.me.app.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            MyApplicationTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
////                    Greeting("Android")
////                    Router()
//                }
//            }
            RallyApp()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}

@Composable
fun pageOne(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                Color.White
            )
    ) {
        Text(text = "这是页面1")
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            //点击跳转到页面2
            navController.navigate(RouteConfig.ROUTE_PAGE_TWO)
        }) {
            Text(
                text = "跳转页面2",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}


@Composable
fun pageTwo(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                Color.White
            )
    ) {
        Text(text = "这是页面2")
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            //点击跳转到页面2
            navController.navigate(RouteConfig.ROUTE_PAGE_ONE)
        }) {
            Text(
                text = "跳转页面1",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun Router() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = RouteConfig.ROUTE_PAGE_ONE,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {
        composable(RouteConfig.ROUTE_PAGE_ONE) {
            pageOne(navController = navController)
        }
        composable(RouteConfig.ROUTE_PAGE_TWO) {
            pageTwo(navController = navController)
        }
    }
}

object RouteConfig {
    const val ROUTE_PAGE_ONE = "pageOne"
    const val ROUTE_PAGE_TWO = "pageTwo"
}

@Composable
fun RallyApp() {
    MyApplicationTheme {
        val navController = rememberNavController()
        val currentBackStack by navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStack?.destination
        val currentScreen =
            rallyTabRowScreens.find { it.route == currentDestination?.route } ?: Overview
        Scaffold(
            bottomBar = {
                RallyTabRow(
                    allScreens = rallyTabRowScreens,
                    onTabSelected = { newScreen ->
                        navController.navigateSingleTopTo(newScreen.route)
                    },
                    currentScreen = currentScreen
                )
            }
        ) { innerPadding ->
            RallyNavHost(
                navController = navController,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}
