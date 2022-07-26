package com.example.practicecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Animatable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class AnimatedSplashScreen : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Surface(
                modifier = Modifier.background(Color.Green)
            ) {
                Navigation()
            }

//            Box(modifier = Modifier.fillMaxSize(),
//                contentAlignment = Alignment.Center) {
//                Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "")
//            }
        }

    }
}

@Composable
fun Navigation() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash_screen") {
        composable("splash_screen") {
            SplashScreen(navController)
        }

        composable("main_screen") {
            MainScreen(navController = navController)
//            Box(modifier = Modifier.fillMaxSize(),
//                contentAlignment = Alignment.Center) {
//                //Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "")
//                Text("Hello duniya....")
//            }
        }

    }

}

@Composable
fun SplashScreen(navController: NavController) {

   LaunchedEffect(key1 = true) {
       delay(3000L)
       navController.navigate("main_screen")
   }

    Box(modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center) {
        Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "")
    }

}

@Composable
fun MainScreen(navController: NavController) {

    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {
        //Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "")
        Text("Hello duniya....")
    }

}