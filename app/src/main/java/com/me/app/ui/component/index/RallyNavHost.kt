package com.me.app.ui.component.index

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.me.app.data.dto.Accounts
import com.me.app.data.dto.Bills
import com.me.app.data.dto.Overview
import com.me.app.data.dto.SingleAccount

@Composable
fun RallyNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    NavHost(
        navController = navController,
        startDestination = Overview.route,
        modifier = modifier
    ){
        composable(route = Overview.route){
            OverviewScreen(
                onClickSeeAllAccounts = {
                    navController.navigateSingleTopTo(Accounts.route)
                },
                onClickSeeAllBills = {
                    navController.navigateSingleTopTo(Bills.route)
                },
                onAccountClick = { accountType ->
                    navController.navigateToSingleAccount(accountType)
                }
            )
        }
        composable(route = Accounts.route) {
//            AccountsScreen(
//                onAccountClick = { accountType ->
//                    navController.navigateToSingleAccount(accountType)
//                }
//            )
            Column(){
                Text(text = "测试1")
            }
        }
        composable(route = Bills.route) {
//            BillsScreen()
            Column(){
                Text(text = "测试2")
            }
        }
        composable(
            route = SingleAccount.routeWithArgs,
            arguments = SingleAccount.arguments,
            deepLinks = SingleAccount.deepLinks
        ) { navBackStackEntry ->
//            val accountType =
//                navBackStackEntry.arguments?.getString(SingleAccount.accountTypeArg)
//            SingleAccountScreen(accountType)
            Column(){
                Text(text = "测试3")
            }
        }
    }
}
fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        // Pop up to the start destination of the graph to
        // avoid building up a large stack of destinations
        // on the back stack as users select items
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ) {
            saveState = true
        }
        // Avoid multiple copies of the same destination when
        // reselecting the same item
        launchSingleTop = true
        // Restore state when reselecting a previously selected item
        restoreState = true
    }

private fun NavHostController.navigateToSingleAccount(accountType: String) {
    this.navigateSingleTopTo("${SingleAccount.route}/$accountType")
}