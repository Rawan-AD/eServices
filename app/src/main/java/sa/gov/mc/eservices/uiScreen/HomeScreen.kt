package sa.gov.mc.eservices.uiScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.ExperimentalMaterialApi
import sa.gov.mc.eservices.ui.theme.*
import androidx.compose.material.Text
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

import sa.gov.mc.eservices.ui.theme.Green100

import sa.gov.mc.eservices.uiScreen.components.RowComponent
import sa.gov.mc.eservices.uiScreen.components.Search
import sa.gov.mc.eservices.uiScreen.components.serviceBox


@OptIn(ExperimentalMaterialApi::class, ExperimentalPagerApi::class)
@Composable
fun HomeScreen(navController: NavController) {
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberBottomSheetScaffoldState()
    var currentBottomSheet: BottomSheetScreen? by remember {
        mutableStateOf(null)
    }



    if (scaffoldState.bottomSheetState.isCollapsed)
        currentBottomSheet = null

    // to set the current sheet to null when the bottom sheet closes
    if (scaffoldState.bottomSheetState.isCollapsed)
        currentBottomSheet = null


    val closeSheet: () -> Unit = {
        scope.launch {
            scaffoldState.bottomSheetState.collapse()

        }
    }

    val openSheet: (BottomSheetScreen) -> Unit = {
        scope.launch {
            currentBottomSheet = it
            scaffoldState.bottomSheetState.expand()
        }

    }
    BottomSheetScaffold(sheetPeekHeight = 0.5.dp, scaffoldState = scaffoldState,
        sheetShape = BottomSheetShape,
        sheetContent = {
            currentBottomSheet?.let { currentSheet ->
                SheetLayout(currentSheet, closeSheet, navController)
            }
        }) { paddingValues ->

        val pagerState = rememberPagerState()


    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
            .absolutePadding(right = 20.dp, left = 20.dp)

        ) {
            val (header, content) = createRefs()

            Row(

                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(header) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.Start,
            ) {


                Text(
                    "أهلا,",
                    fontSize = 18.sp,
                    style =Typography.subtitle2,
                    color= Green100
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    "محمد عبد الرحمن",
                    style =Typography.subtitle2,
                    color= Color.Gray,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,

                )


            }
            Spacer(Modifier.height(37.dp))

            Column(
                modifier = Modifier
                    .fillMaxSize()


                    .constrainAs(content) {
                        top.linkTo(header.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        height = Dimension.fillToConstraints
                    },    horizontalAlignment = Alignment.Start

                ) {
                Spacer(Modifier.height(9.dp))
                var list = mutableListOf("ddd","ddd","Ddddddd")
                Search(title = "بحث")
                Spacer(Modifier.height(9.dp))
                RowComponent(openSheet)
                Spacer(Modifier.height(16.dp))
                LazyColumn() {
                    items(5) { item ->
                       serviceBox()
                        Spacer(Modifier.height(12.dp))
                    }
                }
                
                



}}}}}