package sa.gov.mc.eservices

sealed class Screens(val route: String){
    object LoginScreen: Screens(route = "login")
    object OptScreen: Screens(route = "otp")
    object HomeScreen: Screens(route = "home")
    object Notification: Screens(route = "notify")
    object Orders: Screens(route = "orders")

    object Profile: Screens(route = "profile")
}




