package sa.gov.mc.eservices

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import sa.gov.mc.eservices.ui.theme.EServicesTheme
@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EServicesTheme {
                var bottomState by remember { mutableStateOf("Home") }

                // TODO 3: to remember which screen
                navController = rememberNavController()

                // TODO 5: Navigation setup
                SetupNavGraph(navController = navController)



            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

}