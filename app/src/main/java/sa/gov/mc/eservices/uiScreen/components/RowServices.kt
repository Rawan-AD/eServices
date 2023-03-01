package sa.gov.mc.eservices.uiScreen.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RowServices() {
    Row(
        Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        news_row_ui(
            width = 105.dp,
            height = 27.dp,
            color = Color.White,
            title = "إنشاء وكالة"
        )
        Spacer(modifier = Modifier.width(5.dp))
        news_row_ui(
            width = 70.dp,
            height = 27.dp,
            color = Color.White,
            title = "تجديد وكالة"
        )
        Spacer(modifier = Modifier.width(5.dp))
//

        news_row_ui(
            width = 70.dp,
            height = 27.dp,
            color = Color.White,
            title = "شطب وكالة"
        )

        Spacer(modifier = Modifier.width(5.dp))

        news_row_ui(
            width = 60.dp,
            height = 27.dp,
            color = Color.White,
            title = "تعديل وكالة"
        )


    }
}