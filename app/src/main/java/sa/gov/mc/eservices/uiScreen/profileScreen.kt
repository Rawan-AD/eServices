package sa.gov.mc.eservices.uiScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import sa.gov.mc.eservices.R
import sa.gov.mc.eservices.ui.theme.Green100
import sa.gov.mc.eservices.ui.theme.Typography


@Composable
fun profileScreen(navController: NavController) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp, )
            ,

        ) {
            val (header, content) = createRefs()

            Column(
                modifier = Modifier
                   .constrainAs(header) {
                       top.linkTo(parent.top)
                       start.linkTo(parent.start)
                       end.linkTo(parent.end)


                   }.absolutePadding(top=27.dp, bottom = 18.dp), horizontalAlignment = Alignment.CenterHorizontally


            ){
Row(modifier=Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                Text(
                    "الحساب الشخصي",
                    fontSize = 14.sp,
                    style = Typography.h2,color=Green100
                )

    Spacer(modifier = Modifier.width(27.dp))



    Image(
        painterResource(id = R.drawable.icon_feather_share),
        contentDescription = null,

        contentScale = ContentScale.Crop
    )

}


                Spacer(modifier = Modifier.height(18.dp))

                Spacer(modifier = Modifier.width(9.dp))

                Image(
                 painterResource(id = R.drawable.person),
                 contentDescription = null,
                 Modifier

                     .size(60.dp)
                     .clip(shape = CircleShape).fillMaxSize(),
                 contentScale = ContentScale.Crop
             )

             Text(
                 "تركي الشهراني",
                 color = Black,
                 style = Typography.subtitle2,
                 fontWeight = FontWeight.Bold,
             )

                Spacer(modifier = Modifier.height(18.dp))


             Text(
                 "مطور تطبيقات",
                 color = Gray,
                 style = Typography.subtitle2,
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
                    },horizontalAlignment = Alignment.CenterHorizontally

            )

            {


            Row(
                modifier = Modifier.fillMaxWidth(),
              verticalAlignment = Alignment.CenterVertically,


            ) {


                Text(
                    "الايميل",
                    fontSize = 18.sp,
                    style = Typography.subtitle2
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    "mabdulrahman@mc.gov.sa",
                    style =Typography.subtitle2 ,
                    color = Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )


    }

                Spacer(modifier = Modifier.height(36.dp))

                Spacer(modifier = Modifier.height(23.dp))


            Row(

                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {


                Text(
                    "رقم الهاتف",
                    fontSize = 18.sp,
                    style = Typography.subtitle2
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    "0504263457",
                    style = Typography.subtitle2,
                    color = Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )


            }

                Spacer(modifier = Modifier.height(36.dp))

//                Spacer(modifier = Modifier.height(23.dp))

            Row(

                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {


                Text(
                    "رقم التحويلة",
                    fontSize = 18.sp,
                    style = Typography.subtitle2
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    "1099",
                    style = Typography.subtitle2,
                    color = Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )


            }

                Spacer(modifier = Modifier.height(36.dp))


            Row(

                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {


                Text(
                    "الإدارة",
                    fontSize = 18.sp,
                    style = Typography.subtitle2
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    "إدارة تقنية المعلومات",
                    style = Typography.subtitle2,
                    color = Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )


            }

                Spacer(modifier = Modifier.height(36.dp))

                Spacer(modifier = Modifier.height(23.dp))

            Row(

                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {


            Text(
                "المدير المباشر",
                fontSize = 18.sp,
                style = Typography.subtitle2
            )

            Spacer(modifier = Modifier.width(27.dp))

            Text(
                "عبدالعزيز خالد",
                style = Typography.subtitle2,
                color = Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )


        }





        }}}
    }