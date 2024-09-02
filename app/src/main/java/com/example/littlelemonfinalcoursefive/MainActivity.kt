package com.example.littlelemonfinalcoursefive

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.littlelemonfinalcoursefive.ui.theme.LittleLemonFinalCourseFiveTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleLemonFinalCourseFiveTheme {
                Navigation()
            }


        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Home.route, builder = {
        composable(Home.route) {
            HomeScreen(navController)
        }

        composable(
            DishDetails.route + "/{${DishDetails.argDishID}}",
            arguments = listOf(navArgument(DishDetails.argDishID) { type = NavType.IntType })
        ) {
            val id =
                requireNotNull(it.arguments?.getInt(DishDetails.argDishID)) { "Dish id is null" }
            DishDetails(id = id)
        }
    })
}

@Preview(showBackground = true)
@Composable
fun PreviewScreen() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    androidx.compose.material.Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = { DrawerPanel(scaffoldState, scope) },
        topBar = { TopAppBar(scaffoldState, scope) },
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Little Lemon")
            Image(
                painter = painterResource(id = R.drawable.greeksalad),
                contentDescription = "Greek Salad"
            )
        }

    }
}