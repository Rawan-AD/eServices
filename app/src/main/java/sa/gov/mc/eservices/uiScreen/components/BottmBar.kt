package sa.gov.mc.eservices.uiScreen.components

import android.annotation.SuppressLint
import android.graphics.Color.BLACK
import androidx.compose.foundation.background


import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*


import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray

import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource



import androidx.compose.ui.unit.dp


import sa.gov.mc.eservices.R



@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "ResourceType")
@Composable
fun BottomBar( onclick:(String)->Unit,bottomState:String) {
    BottomAppBar(modifier = Modifier.background(Color.Transparent),
//        contentColorFor(backgroundColor = GrayBackground ),
        colorResource(id = R.color.white))

    {


//        var bottomState by remember { mutableStateOf("الرئيسية") }

        BottomNavigation(
//            elevation=5.dp,
            backgroundColor =White,
//            contentColor = Color(0xfff999999),
            modifier = Modifier
                .background(White)
//
//                .clip(
//                    shape = RoundedCornerShape(
//                        30.dp
//                    )
//                )
        ) {


            BottomNavigationItem(
                selected =bottomState== "بيناتي",
                onClick = {
                    onclick("بياناتي")

                },
                label = { Text(text = "الحساب الشخصي",color=Gray) },
                icon = {
                    Icon(
                        painter= painterResource(id = R.drawable.icon_open_home ),
                        contentDescription = null
                    )

                },

                )

            BottomNavigationItem(selected = bottomState == "الاشعارات", onClick = {
                onclick("الاشعارات")
            },
                label = { Text(text = "الاشعارات",color=Gray) },
                icon = {
                    Icon(
                        painter= painterResource(id = R.drawable.icon_open_home ),
                        contentDescription = null
                    )
                }
            )

            BottomNavigationItem(selected = bottomState == "الطلبات", onClick = {
                onclick("الطلبات")
            },
                label = { Text(text = "الطلبات",color=Gray)},
                icon = {
                    Icon(
                        painter= painterResource(id = R.drawable.icon_open_home ),
                        contentDescription = null
                    )

                }
            )



            BottomNavigationItem(selected = bottomState == "الرئيسية", onClick = {
                onclick("الرئيسية")
            },
                label = { Text(text = "الرئيسية",color=Gray) },
                icon = {
                    Icon(
                        painter= painterResource(id = R.drawable.icon_open_home ),
                        contentDescription = null
                    )
                }
            )


        }
    }
}