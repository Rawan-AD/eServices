package sa.gov.mc.eservices.uiScreen
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.*

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme.typography

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.livedata.observeAsState

import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.LiveData

import androidx.lifecycle.MutableLiveData

import sa.gov.mc.eservices.R
import sa.gov.mc.eservices.Screens
import sa.gov.mc.eservices.data.model.LoginResponse


import sa.gov.mc.eservices.ui.theme.Green100
import sa.gov.mc.eservices.ui.theme.customStyle

@Composable
fun loginScreen(navController: NavHostController,loginViewModel:LoginViewModel) {
    var captchText: MutableLiveData<String> = MutableLiveData("oo")
    loginViewModel.getCaptchaInfo()
    captchText.value=loginViewModel.captcha.value
    var answer by remember { mutableStateOf("") }


    val isCheck = remember { mutableStateOf(false) }
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

        Column(modifier= Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .absolutePadding(right = 12.dp), horizontalAlignment = Alignment.Start) {
            Spacer(Modifier.height(32.dp))
            Text(text = "مرحبا بك",modifier=Modifier.absolutePadding(right=20.dp),style= customStyle, fontSize = 18.sp)
            Spacer(Modifier.height(10.dp))
            Text(text = "في تطبيق البوابة الالكترونية الموحدة بوزارة التجارة",color= Gray, fontFamily = FontFamily(
                Font(R.font.frutiger_roman),
            ), fontSize = 16.sp)
        }


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier =Modifier.fillMaxWidth()
        ){
            Spacer(Modifier.height(200.dp))

            Text(text = "تسجيل الدخول",style= customStyle,fontSize=18.sp)
            Spacer(Modifier.height(20.dp))
            OutlinedTextField(value = userName, onValueChange = { userName = it }, label = {

                Text(
                    "اسم المستخدم",
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Right,
                    fontSize = 15.sp,
                    color = Color.Gray
                )

            }, leadingIcon = {
                Image(
                    painterResource(id = R.drawable.icon_metro_user),
                    contentDescription = "icon_image"
                )
            }, modifier = Modifier
                .wrapContentSize()
                .height(60.dp)


                .absolutePadding(right = 65.5.dp, left = 65.5.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    cursorColor = Gray,
                    focusedIndicatorColor = Green,
                    errorIndicatorColor = Red
                )
            )

            OutlinedTextField(value = password, onValueChange = { password = it }, label = {

                Text(
                    "كلمة المرور",
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Right,
                    fontSize = 15.sp,
                    color = Gray
                )

            }, leadingIcon = {
                Image(
                    painterResource(id = R.drawable.icon_open_lock_locked),
                    contentDescription = "icon_image"
                )
            }, modifier = Modifier
                .wrapContentSize()
                .height(60.dp)


                .absolutePadding(right = 65.5.dp, left = 65.5.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    cursorColor = Gray,
                    focusedIndicatorColor = Color.Green,
                    errorIndicatorColor = Red
                ))

            Spacer(modifier = Modifier.height(15.dp))
            Row(
                Modifier
                    .width(200.dp)
                    .height(90.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    painterResource(id = R.drawable.reload),
                    contentDescription = "reload",
                    modifier = Modifier
                        .size(25.dp)
                        .clickable {

                        })

            }



            var captcha= loginViewModel.captcha.observeAsState()
            var uuid=loginViewModel.uuid.observeAsState()


            if(captcha.value!=null){

//               var s= captchText.observeAsState()
//                var  captchaAsString:State<String?> = s
                var captchaAsBitMap:LiveData<Bitmap?> = decode(captcha.value)
                BitmapImage(captchaAsBitMap.value)
            }





            Spacer(Modifier.height(20.dp))

            OutlinedTextField(
                value = answer,
                onValueChange = { answer= it },

                label = {
                    Text(
                        text = "اكتب كودالتحقق هنا",
                        fontFamily = FontFamily(Font(R.font.frutiger_roman)),
                        fontWeight = FontWeight.Normal,
                        color = Gray,
                        textAlign = TextAlign.Center,
                        fontSize = 14.sp,
                        modifier = Modifier.absolutePadding(right = 60.dp)


                    )
                },

                modifier = Modifier
                    .height(60.dp)

                    .absolutePadding(right = 65.5.dp, left = 65.5.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = White,
                    cursorColor = Green100,
                    focusedIndicatorColor = Green100,
                    errorIndicatorColor = Red
                )
            )

val answerFixed =answer
            var loginResponse by remember { mutableStateOf<LoginResponse?>(LoginResponse(222,"2")) }
            Spacer(Modifier.height(20.dp))

            Row( horizontalArrangement = Arrangement.End){
                Card(
                    modifier = Modifier.background(White),
                    elevation = 0.dp,
                    shape = RoundedCornerShape(6.dp),
                    border = BorderStroke(1.dp, color = Gray)
                ) {
                    Box(
                        modifier = Modifier
                            .size(25.dp)
                            .background(if (isCheck.value) Green100 else White)
                            .clickable {
                                isCheck.value = !isCheck.value
                            },
                        contentAlignment = Alignment.TopStart
                    ) {
                        if(isCheck.value)
                            Icon(Icons.Default.Check, contentDescription = "", tint =White)
                    }
                }

                Text(
                    modifier = Modifier
//                        .align(Alignment.Start)
                        .padding(start = 10.dp),
                    text = "تذكرني",

                    )
            }
            Spacer(Modifier.height(20.dp))


            OutlinedButton(  modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .absolutePadding(right = 65.dp, left = 66.dp),onClick = {

                uuid.value?.let {
                    loginViewModel.signIn("uat1","asdf@mc100", it,answerFixed ) }



                navController.navigate(Screens.OptScreen.route) }  ,  colors = ButtonDefaults.buttonColors(backgroundColor = Green100)
            )

            {

                Text(
                    text = "دخول",
                    style = typography.body1,
                    color =White,
                    textAlign = TextAlign.Center,
                    fontSize=16.sp
                )
            }




        }
    }}

fun decode(d:String?): LiveData<Bitmap?> {
    var decodeStr: ByteArray? = Base64.decode(d, Base64.DEFAULT)
    var decoded:Bitmap? = decodeStr?.let { BitmapFactory.decodeByteArray(decodeStr, 0, it.size) }
    var decodLive=MutableLiveData<Bitmap?>(decoded)
    return decodLive
}

//@Composable
//fun getCaptcha( loginViewModel: LoginViewModel):String{
//    loginViewModel.getCaptchaInfo()
//    if(loginViewModel.result.value!=null) {
//       return loginViewModel.captcha.value!!
//   }
//    return "sss"
//
//}


@Composable
fun BitmapImage(bitmap:Bitmap?){
    bitmap?.asImageBitmap()?.let {
        Image(
            bitmap = it,
            contentDescription = "image", modifier = Modifier.fillMaxWidth()
        )
    }
}