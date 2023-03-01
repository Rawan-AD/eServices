package sa.gov.mc.eservices.uiScreen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sa.gov.mc.eservices.ui.theme.PinkGray

import sa.gov.mc.eservices.ui.theme.Typography
import sa.gov.mc.eservices.ui.theme.customStyleMc

@Composable
fun serviceBox (){
    Card (modifier = Modifier.fillMaxWidth()){


    Column(modifier = Modifier.padding(horizontal = 18.dp, vertical = 18.dp)){
        Text(
            "طلب انشاء وكالة",
            fontSize = 16.sp,
            style =customStyleMc,
            fontWeight =FontWeight.Bold,
            color= Black
        )
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            Modifier
                .fillMaxWidth()
//
//                .padding(horizontal = 9.dp)
            ,
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Start){

            Text(
                "رقم الطلب",
                fontSize = 14.sp,
                style = Typography.subtitle1,
                color= Gray
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                "10467432",
                fontSize = 14.sp,
                style = Typography.subtitle1,
                color=Black
            )
            Spacer(modifier = Modifier.width(150.dp))
            Text(
                "13 ديسمبر 2033",
                fontSize = 10.sp,
                style = Typography.subtitle1,
                color= Gray
            )
        }

//
//        Spacer(Modifier.height(9.dp))
        Row(
            Modifier
                .fillMaxWidth()

//                .padding(horizontal = 9.dp)
            ,
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Start){

            Text(
                "حالة الطلب",
                fontSize = 14.sp,
                style = Typography.subtitle1,
                color= Gray
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                "قيد المعالجة",
                fontSize = 14.sp,
                style = Typography.subtitle1,
                color=Black
            )


        }
        Spacer(Modifier.height(12.dp))
        Row(
            Modifier
                .fillMaxWidth()
//
//                .padding(horizontal = 9.dp)
            ,
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Start){

            Text(
                "التوجيه",
                fontSize = 14.sp,
                style = Typography.subtitle1,
                color= Gray
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                "قبول الطلب",
                fontSize = 14.sp,
                style = Typography.subtitle1,
                color=Black
            )


        }
        Spacer(Modifier.height(12.dp))

    }
}}