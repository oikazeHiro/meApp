package com.me.app.ui.login

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.navigation.NavHostController
import com.me.app.R
import com.me.app.data.dto.LoginModel
import com.me.app.util.network.http.NetworkService
import com.tencent.mmkv.MMKV
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

val tag = "Login test"
@Composable
fun LoginPage(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    var username by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    Column {

        Text(text = "loginPage")
        OutlinedTextField(
            value = username,
            onValueChange = {
                username = it.replace("\n", "").trim()
            },
            label = {
                Text(text = stringResource(R.string.username))
            }
        )
        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it.replace("\n", "").trim()
            },
            label = {
                Text(text = stringResource(R.string.password))
            },
            visualTransformation = PasswordVisualTransformation()
        )
        Button(onClick = {
//            doLogin(navController,username,password)
        }) {
            Text(text = stringResource(id = R.string.login))
        }
    }
}



suspend fun doLogin(navController: NavHostController, username:String, password:String){
        val login = NetworkService.api.login(LoginModel(username, password))
        if (login.code == 200){
            val mmkv = MMKV.defaultMMKV()
            mmkv.encode("USERNAME",username)
            mmkv.encode("PASSWORD",password)
            mmkv.encode("TOKEN",login.data?.token)
            Log.d(tag,"username: $username")
            Log.d(tag,"password: $password")
            Log.d(tag,"TOKEN: ${login.data?.token}")
            navController.navigate("index")

        }
}