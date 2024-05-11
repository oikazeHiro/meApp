package com.me.app.ui.component.index

import androidx.annotation.StringRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Message
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.me.app.R
import com.me.app.ui.component.index.layout.ContactDestination
import com.me.app.ui.component.index.layout.HomeDestination
import com.me.app.ui.component.index.layout.MeDestination
import com.me.app.ui.component.index.layout.MessageDestination

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun IndexPage(modifier: Modifier = Modifier) {
    var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.HOME) }

    Scaffold(
        bottomBar = {
            NavigationBar(modifier = modifier) {
                for (navItem in AppDestinations.entries) {
                    NavigationBarItem(
                        selected = navItem == currentDestination,
                        onClick = { currentDestination = navItem },
                        icon = {
                            Icon(
                                imageVector = navItem.icon,
                                contentDescription = stringResource(id = navItem.label)
                            )
                        },
                        label = {
                            Text(stringResource(navItem.label), maxLines = 1)
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        DetailsScreenButtonBar(currentDestination, Modifier.padding(innerPadding))
    }

}

@Composable
fun DetailsScreenButtonBar(
    appDestinations: AppDestinations,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        when (appDestinations) {
            AppDestinations.HOME -> HomeDestination()
            AppDestinations.CONTACT -> ContactDestination()
            AppDestinations.MESSAGE -> MessageDestination()
            AppDestinations.ME -> MeDestination()
        }
    }
}

enum class AppDestinations(
    @StringRes val label: Int,
    val icon: ImageVector,
    @StringRes val contentDescription: Int,
    val needLogin: Boolean = false
) {
    HOME(R.string.home, Icons.Default.Home, R.string.home),
    CONTACT(R.string.contact, Icons.Default.Contacts, R.string.contact),
    MESSAGE(R.string.message, Icons.AutoMirrored.Filled.Message, R.string.message),
    ME(R.string.me, Icons.Default.Person, R.string.me),
}

