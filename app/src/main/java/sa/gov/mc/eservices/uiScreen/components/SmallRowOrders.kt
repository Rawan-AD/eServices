package sa.gov.mc.eservices.uiScreen.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun SmallRowOrders() {

    Row(
    Modifier
    .fillMaxWidth()

    ,
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.Start
    ) {
        small_row_orders(width = 80.dp, height = 22.dp, color = Color.White, title = "إنشاء وكالة")
        Spacer(modifier = Modifier.width(5.dp))
        small_row_orders(
            width = 60.dp,
            height = 22.dp,
            color = Color.White,
            title = "تجديد وكالة"
        )
        Spacer(modifier = Modifier.width(5.dp))
//

        small_row_orders(
            width = 60.dp,
            height = 22.dp,
            color = Color.White,
            title = "حذف وكالة"
        )

        Spacer(modifier = Modifier.width(5.dp))

        small_row_orders(
            width = 60.dp,
            height = 22.dp,
            color = Color.White,
            title = "تعديل وكالة"
        )


    }


}