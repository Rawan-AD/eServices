package sa.gov.mc.eservices.uiScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import sa.gov.mc.eservices.ui.theme.Green100
import sa.gov.mc.eservices.ui.theme.customStyle
import sa.gov.mc.eservices.uiScreen.components.*


@Composable
fun ordersScreen(navController: NavController) {

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
                "الطلبات",
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
            Spacer(Modifier.height(12.dp))

            var list = mutableListOf("ddd","ddd","Ddddddd")
            Search(title = "بحث")
            Spacer(Modifier.height(9.dp))
            RowOrders ()
            Spacer(Modifier.height(9.dp))
            SmallRowOrders()
            Spacer(Modifier.height(18.dp))
            LazyColumn() {
                items(5) { item ->
                    serviceBox()
                    Spacer(Modifier.height(12.dp))
                }
            }

        }
    }




}