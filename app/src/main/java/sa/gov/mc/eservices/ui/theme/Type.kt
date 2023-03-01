package sa.gov.mc.eservices.ui.theme

import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import sa.gov.mc.eservices.R

val frutiger = FontFamily(
    listOf(
        Font(R.font.frutiger_light, FontWeight.Light),
        Font(R.font.frutiger_light, FontWeight.Normal),
        Font(R.font.frutiger_light, FontWeight.Medium),
        Font(R.font.frutiger_bold, FontWeight.SemiBold),
       Font(R.font.frutiger_bold, FontWeight.Bold),
        Font(R.font.frutiger_black, FontWeight.Black),
    )
)



val Typography = Typography(
    h1 = TextStyle(
        fontFamily = frutiger
        ,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 40.sp
    ),
    h2 = TextStyle(
        fontFamily = frutiger,
        fontWeight = FontWeight.Black,
        fontSize = 32.sp
    ),
    h3 = TextStyle(
        fontFamily = frutiger,
        fontWeight = FontWeight.Black,
        fontSize = 16.sp,
        color=Gray
    ),
    body1 = TextStyle(
        fontFamily = frutiger,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = Color.Black
    ),
    body2 = TextStyle(
        fontFamily = FontFamily(
            Font(R.font.frutiger_roman)),
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        color = Gray,

        ),

    button = TextStyle(
        fontFamily = frutiger,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = Color.Gray
    ),
    subtitle1 = TextStyle(
        fontFamily = frutiger,
        fontWeight = FontWeight.Light,
        fontSize = 32.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = frutiger,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        color = Gray
    )


)










@get:Composable
val customStyle: TextStyle
    get()=TextStyle(
        fontFamily = FontFamily(Font(R.font.frutiger_bold)),
        color = Green100
    )


@get:Composable
val customStyleMc: TextStyle
    get()=TextStyle(
        fontFamily = FontFamily(Font(R.font.frutiger_bold)),
        color = Black
    )