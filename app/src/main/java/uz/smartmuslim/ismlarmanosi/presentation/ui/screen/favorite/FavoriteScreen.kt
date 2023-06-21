package uz.smartmuslim.ismlarmanosi.presentation.ui.screen.favorite

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import uz.smartmuslim.ismlarmanosi.R


object FavoritePage : Tab {

    override val options: TabOptions
        @Composable
        get() {
            val title = "Yoqganlar"
            val icon =
                rememberVectorPainter(image = ImageVector.vectorResource(id = R.drawable.baseline_home_24))

            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Blue)
                .wrapContentSize(Alignment.Center)
        ) {
            Text(
                text = "Favorite View",
                fontWeight = FontWeight.Bold,
                color = Color.Magenta,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center,
                fontSize = 25.sp
            )
        }
    }
}