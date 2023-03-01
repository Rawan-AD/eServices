package sa.gov.mc.eservices.uiScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import sa.gov.mc.eservices.uiScreen.components.BottomBar


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalPagerApi::class)
@Composable
fun ParentHomeScreen(navController: NavController) {
    var bottomState by remember { mutableStateOf("الرئيسية") }

    Scaffold(


        content = {
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

//                HomeScreen(navController = navController)



                if(bottomState.equals("بياناتي")){
                    profileScreen(navController)
                } else if(bottomState.equals("الاشعارات")){
                    NotificationScreen(navController  )
                }
                else if(bottomState.equals("الطلبات")){
                   ordersScreen(navController)
                }

                else if(bottomState.equals("الرئيسية")){
                    HomeScreen(navController )

                }





            }
        },
        bottomBar = {
            BottomBar({bottomState=it},bottomState)
        }
    )
}