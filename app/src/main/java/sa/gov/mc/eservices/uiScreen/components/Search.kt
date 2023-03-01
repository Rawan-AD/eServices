package sa.gov.mc.eservices.uiScreen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sa.gov.mc.eservices.ui.theme.ExtraMedium
import sa.gov.mc.eservices.ui.theme.PinkGray
import sa.gov.mc.eservices.ui.theme.Shapes
import sa.gov.mc.eservices.ui.theme.frutiger


@Composable
fun Search(title:String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = Shapes.ExtraMedium)
, backgroundColor = White,
        border = BorderStroke(1.dp,PinkGray)
    ) {
        Row (verticalAlignment = Alignment.CenterVertically){
            Text(
                text =title,
                fontFamily = frutiger,
                textAlign = TextAlign.Right,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Gray,
                modifier = Modifier.padding(horizontal = 9.dp, vertical = 10.dp)
            )

            Icon(
                Icons.Default.Search,
                contentDescription = "search_icon",
                tint = Gray,
                modifier = Modifier.absolutePadding(10.dp, 10.dp, 260.dp)
            )
        }

    }
}



