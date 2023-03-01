package sa.gov.mc.eservices

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import sa.gov.mc.eservices.uiScreen.*

@Composable
fun SetupNavGraph(
    navController: NavHostController
){
    NavHost(
        navController = navController, startDestination = Screens.LoginScreen.route
    ) {


        composable(
            route = Screens.LoginScreen.route
        ) {
            loginScreen(navController = navController,loginViewModel= hiltViewModel())
        }

        composable(
            route = Screens.OptScreen.route
        ) {
            otpScreen(navController = navController,loginViewModel= hiltViewModel())
        }

        composable(
            route = Screens.HomeScreen.route
        ) {
            ParentHomeScreen(navController = navController)
        }
        composable(
            route = Screens.Notification.route
        ) {
            NotificationScreen(navController = navController)
        }
        composable(
            route = Screens.Orders.route
        ) {
            ordersScreen(navController = navController)
        }
        composable(
            route = Screens.Profile.route
        ) {
            profileScreen(navController = navController)
        }






    }}