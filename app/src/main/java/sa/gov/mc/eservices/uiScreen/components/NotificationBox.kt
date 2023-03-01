package sa.gov.mc.eservices.uiScreen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sa.gov.mc.eservices.ui.theme.Typography
import sa.gov.mc.eservices.ui.theme.customStyleMc


@Composable
fun NotificationBox (){


    Card (modifier = Modifier.fillMaxWidth()){


        Column(modifier=Modifier.padding(horizontal = 18.dp, vertical = 18.dp)){
            Text(
                "نظام الوكالات التجارية",
                fontSize = 16.sp,
                style = customStyleMc,
                fontWeight = FontWeight.Bold,
                color= Color.Black
            )
//            Spacer(modifier = Modifier.height(12.dp))
            Row(
                Modifier
                    .fillMaxWidth()

//                    .padding(horizontal = 9.dp)
                ,
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Start){

                Text(
                    "رقم الطلب",
                    fontSize = 14.sp,
                    style = Typography.subtitle1,
                    color= Color.Gray
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    "10467432",
                    fontSize = 14.sp,
                    style = Typography.subtitle1,
                    color= Color.Black
                )
                Spacer(modifier = Modifier.width(150.dp))
                Text(
                    "13 ديسمبر 2033",
                    fontSize = 11.sp,
                    style = Typography.subtitle1,
                    color= Color.Gray
                )
            }


//            Spacer(Modifier.height(12.dp))
            Row(
                Modifier
                    .fillMaxWidth()

                    .padding(horizontal = 9.dp),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Start){

                Text(
                    "الخدمة",
                    fontSize = 14.sp,
                    style = Typography.subtitle1,
                    color= Color.Gray
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    "انشاء طلب",
                    fontSize = 14.sp,
                    style = Typography.subtitle1,
                    color= Color.Black
                )


            }
            Spacer(Modifier.height(12.dp))




        }
    }
}