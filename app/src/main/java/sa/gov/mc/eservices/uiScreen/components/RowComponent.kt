package sa.gov.mc.eservices.uiScreen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import sa.gov.mc.eservices.ui.theme.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import sa.gov.mc.eservices.R
import sa.gov.mc.eservices.ui.theme.Larg_Medium
import sa.gov.mc.eservices.ui.theme.Shapes
import androidx.compose.ui.unit.*
import sa.gov.mc.eservices.uiScreen.BottomSheetScreen

@Composable
fun RowComponent(openSheet: (BottomSheetScreen) -> Unit,){
    Row(
        Modifier
            .fillMaxWidth()

        ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        news_row_ui(width = 105.dp, height = 27.dp, color =White, title = "طبيات قائمة")
        Spacer(modifier = Modifier.width(10.dp))
        news_row_ui(
            width = 105.dp,
            height = 27.dp,
            color = White,
            title = "طلبات منتهية"
        )
        Spacer(modifier = Modifier.width(63.dp))
//        news_row_ui(
//            width = 105.dp,
//            height = 27.dp,
//            color = White,
//            title = "الصحف الدولية"
//        )

        Image(
            painterResource(id = R.drawable.icon_awesome_sort_amount_down_alt),
            contentDescription = null,
            modifier=Modifier.clickable {  run { openSheet(BottomSheetScreen.sortRequest) } }
        )

        Spacer(modifier = Modifier.width(18.dp))
        Image(
            painterResource(id = R.drawable.component_75___1),
            contentDescription = null
        )


    }


}


@Composable
fun news_row_ui(width: Dp, height: Dp, color:Color, title:String)    {
    Row( verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center ){
        Card(shape= Shapes.Larg_Medium,modifier = Modifier

            .size(width, height), border= BorderStroke(1.dp, PinkGray),backgroundColor = color) {
            Text(text =title,style= Typography.subtitle2,fontSize=12.sp, fontWeight = FontWeight.Normal,  textAlign = TextAlign.Center)
        }
    }
}


@Composable
fun small_row_orders(width: Dp, height: Dp, color:Color, title:String)    {
    Row( verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center ){
        Card(shape= Shapes.Larg_Medium,modifier = Modifier

            .size(width, height), border= BorderStroke(1.dp, PinkGray),backgroundColor = color) {
            Text(text =title,style= Typography.subtitle2, fontWeight = FontWeight.Normal,  fontSize = 12.sp, textAlign = TextAlign.Center)
        }
    }
}