package sa.gov.mc.eservices.uiScreen

import android.widget.EditText
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.MaterialTheme.shapes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalLayoutDirection
import sa.gov.mc.eservices.ui.theme.*

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import sa.gov.mc.eservices.R
import sa.gov.mc.eservices.Screens


@Composable
fun otpScreen(navController: NavController,loginViewModel: LoginViewModel) {

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Column(
            modifier = Modifier
                .fillMaxWidth().padding(10.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(200.dp))
            Text(
                text = "رمز التحقق", style = Typography.body1
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "تم ارسال رمز التحقق برسالة نصية على رقم جوالك", style = Typography.body1
            )

            Spacer(modifier = Modifier.height(24.dp))
            Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                Text(
                    "1",
                    modifier = Modifier
                        .size(59.dp, 56.dp)
                        .border(1.dp, Gray,
                            shape = Shapes.small)
                        .drawBehind {
                            drawRoundRect(
                                White,
                                cornerRadius = CornerRadius(10.dp.toPx())
                            )
                        }, textAlign = TextAlign.Center,

                    )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    "2",
                    modifier = Modifier
                        .size(59.dp, 56.dp)
                        .border(1.dp, Gray, shape = Shapes.small)
                        .drawBehind {
                            drawRoundRect(
                                White,
                                cornerRadius = CornerRadius(10.dp.toPx())
                            )
                        },textAlign = TextAlign.Center,

                    )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    "3",
                    modifier = Modifier
                        .size(59.dp, 56.dp)
                        .border(1.dp, Gray, shape = Shapes.small)
                        .drawBehind {
                            drawRoundRect(
                                White,
                                cornerRadius = CornerRadius(10.dp.toPx())
                            )
                        },textAlign = TextAlign.Center,

                    )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    "4",
                    modifier = Modifier
                        .size(59.dp, 56.dp)
                        .border(1.dp, Gray, shape = Shapes.small)
                        .drawBehind {
                            drawRoundRect(
                                White,
                                cornerRadius = CornerRadius(10.dp.toPx())
                            )
                        },textAlign = TextAlign.Center,

                    )

            }
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text ="اْعادة ارسال الرمز مرة أخرى خلال 15 ثانية",
                fontFamily = FontFamily(
                    Font(R.font.frutiger_roman)
                ),
                textAlign = TextAlign.Right,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Gray,
                modifier = Modifier.absolutePadding(left = 1.dp, right = 1.dp))

            Spacer(modifier = Modifier.height(16.dp))




            OutlinedButton(
                shape = shapes.small,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .absolutePadding(right = 65.dp, left = 66.dp),

                onClick = {
//loginViewModel.checkOtp()
                    navController.navigate(route = Screens.HomeScreen.route)
                },
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = Green100,
                    contentColor = White
                )
            ) {
                Text(text = "تحقق", color = White,  fontSize=16.sp)
            }

        }


    }
}


