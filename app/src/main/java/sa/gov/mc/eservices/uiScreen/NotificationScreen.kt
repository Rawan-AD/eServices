package sa.gov.mc.eservices.uiScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import sa.gov.mc.eservices.ui.theme.Green100
import sa.gov.mc.eservices.ui.theme.Typography
import sa.gov.mc.eservices.ui.theme.customStyle
import sa.gov.mc.eservices.uiScreen.components.NotificationBox
import sa.gov.mc.eservices.uiScreen.components.RowComponent
import sa.gov.mc.eservices.uiScreen.components.Search
import sa.gov.mc.eservices.uiScreen.components.serviceBox


@Composable
fun NotificationScreen(navController: NavController) {


    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .absolutePadding(right = 20.dp, left = 20.dp)
        ) {
            val (header, content, bottomBar) = createRefs()
            Column(
                modifier = Modifier
//                    .padding(vertical = 10.dp)
                    .constrainAs(header) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {


                Spacer(modifier = Modifier.height(23.dp))

//                Spacer(modifier = Modifier.height(23.dp))

                Text(
                    "الاشعارات",
                    color = Green100,
                    style = MaterialTheme.typography.subtitle2,
                    modifier = Modifier.graphicsLayer(alpha = 0.99f),
                    fontWeight = FontWeight.Bold
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()


                    .constrainAs(content) {
                        top.linkTo(header.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        height = Dimension.fillToConstraints
                    },    horizontalAlignment = Alignment.Start


            ) {
                Text(
                    "اليوم",
                    fontSize = 14.sp,
                    style = customStyle,
                    modifier = Modifier.absolutePadding()
                )
                Spacer(Modifier.height(12.dp))
//
//                var list = mutableListOf("ddd","ddd","Ddddddd")
                Spacer(Modifier.height(16.dp))
                LazyColumn() {
                    items(5) { item ->
                        NotificationBox()
                        Spacer(Modifier.height(12.dp))
                    }
                }




        }
    }
}}