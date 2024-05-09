package com.me.app.ui.component.index

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Message
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.me.app.R
import com.me.app.ui.component.index.layout.ContactDestination
import com.me.app.ui.component.index.layout.HomeDestination
import com.me.app.ui.component.index.layout.MeDestination
import com.me.app.ui.component.index.layout.MessageDestination

@Composable
fun IndexPage(){
    var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.HOME) }
    NavigationSuiteScaffold(
        navigationSuiteItems = {
            AppDestinations.entries.forEach {
                item(
                    icon = {
                        Icon(
                            it.icon,
                            contentDescription = stringResource(it.contentDescription)
                        )
                    },
                    label = { Text(stringResource(it.label)) },
                    selected = it == currentDestination,
                    onClick = { currentDestination = it }
                )
            }
        },
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
    ) {
        when (currentDestination) {
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
){
    HOME(R.string.home, Icons.Default.Home, R.string.home),
    CONTACT(R.string.contact,Icons.Default.Contacts,R.string.contact),
    MESSAGE(R.string.message, Icons.AutoMirrored.Filled.Message,R.string.message),
    ME(R.string.me,Icons.Default.Person,R.string.me),
}

