package uz.smartmuslim.ismlarmanosi.presentation.ui.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import org.orbitmvi.orbit.compose.collectAsState
import uz.smartmuslim.ismlarmanosi.R
import uz.smartmuslim.ismlarmanosi.presentation.ui.theme.Bg_Color

class SplashScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel: SplashViewModel = getViewModel<SplashViewModelImpl>()
        val uiState = viewModel.collectAsState().value
        SplashScreenContent(uiState, viewModel::onEventDispatcher)
    }
}

@Composable
fun SplashScreenContent(uiState: SplashUIState, onEventDispatcher: (SplashIntent) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Bg_Color),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        LaunchedEffect(key1 = true) {
//            onEventDispatcher(SplashIntent.OpenMaiScreen)
//        }

        Text(
            text = "Ismlar ma'nosi",
            Modifier.padding(20.dp),
            fontSize = 40.sp,
            fontFamily = FontFamily(Font((R.font.geometria_medium))),
            color = Color.White,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "O'z ismingiz qanday ma'no anglatishini bilib oling",
            Modifier.padding(20.dp),
            textAlign = TextAlign.Center,
            fontFamily = FontFamily(Font((R.font.geometria_medium))),
            fontSize = 20.sp,
            color = Color.White
        )
        Image(
            painter = painterResource(id = R.drawable.splash),
            contentDescription = "icon",
            Modifier
                .padding(60.dp)
                .size(240.dp)
        )

    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Text(
            text = "Smart Muslim Production",
            Modifier.padding(20.dp),
            textAlign = TextAlign.Center,
            fontFamily = FontFamily(Font((R.font.geometria_medium))),
            fontSize = 20.sp,
            color = Color.White
        )
    }
}
