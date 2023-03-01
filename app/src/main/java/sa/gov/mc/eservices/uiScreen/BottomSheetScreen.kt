package sa.gov.mc.eservices.uiScreen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import sa.gov.mc.eservices.Screens
import sa.gov.mc.eservices.ui.theme.Green100
import sa.gov.mc.eservices.uiScreen.components.RowOrders

import sa.gov.mc.eservices.uiScreen.components.RowServices


sealed class BottomSheetScreen (){
    object sortRequest: BottomSheetScreen()

}


@Composable
fun SheetLayout(currentScreen: BottomSheetScreen,onCloseBottomSheet :()->Unit,navController: NavController) {
    BottomSheetWithCloseDialog(onCloseBottomSheet){
        when(currentScreen){
            BottomSheetScreen.sortRequest-> SortServices(navController)


        }

    }
}

@Composable
fun SortServices(navController: NavController) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {


        ConstraintLayout(
            modifier = Modifier
                .height(450.dp)
                .padding(horizontal = 16.dp)
        ) {
            val (header, content) = createRefs()
            Column( modifier = Modifier
                .constrainAs(header) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)

                },horizontalAlignment = Alignment.CenterHorizontally) {

                Spacer(Modifier.height(18.dp))
                Text(
                    "تصفية الطلبات",
                    style = MaterialTheme.typography.subtitle2,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Green100
                )
            }
            Spacer(Modifier.height(9.dp))
            Column(
                modifier = Modifier

                    .padding(vertical = 18.dp)



                    .constrainAs(content) {
                        top.linkTo(header.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        height = Dimension.fillToConstraints
                    },horizontalAlignment = Alignment.Start



            ){

                Spacer(Modifier.height(18.dp))
                Text(
                    "أختر النظام",
                    style = MaterialTheme.typography.subtitle2,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Green100
                )



                Spacer(Modifier.height(18.dp))
                RowOrders ()

                Spacer(Modifier.height(9.dp))
                RowOrders ()


                Spacer(Modifier.height(27.dp))
                Text(
                    "أختر الخدمه",
                    style = MaterialTheme.typography.subtitle2,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Green100
                )

                Spacer(Modifier.height(27.dp))

           RowServices()
                Spacer(Modifier.height(27.dp))


                OutlinedButton(  modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .absolutePadding(right = 65.dp, left = 66.dp),onClick = { navController.navigate(
                    Screens.HomeScreen.route) }  ,  colors = ButtonDefaults.buttonColors(backgroundColor = Green100)
                )

                {
                    Text(
                        text = "تطبيق",
                        style = MaterialTheme.typography.body1,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontSize=16.sp
                    )
                }



}








}}}


@Composable
fun BottomSheetWithCloseDialog(
    onClosePressed: () -> Unit,
    modifier: Modifier = Modifier,
    closeButtonColor: Color = Color.Gray,
    content: @Composable() () -> Unit
) {
    Box(modifier.fillMaxWidth()) {
        content()

        IconButton(
            onClick = onClosePressed,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
                .size(29.dp)

        ) {
            Icon(Icons.Filled.Close, tint = closeButtonColor, contentDescription = null)
        }

    }
}