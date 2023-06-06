package uz.smartmuslim.ismlarmanosi.presentation.ui.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import kotlinx.coroutines.MainScope
import uz.smartmuslim.ismlarmanosi.R
import uz.smartmuslim.ismlarmanosi.presentation.ui.screen.main.MainScreen
import uz.smartmuslim.ismlarmanosi.presentation.ui.theme.Bg_Color

class SplashScreen : Screen {

    @Composable
    override fun Content() {
        TODO("Not yet implemented")
    }
}

@Composable
private fun SplashScreenContent(uiState: SplashUiState, navigator: Navigator) {

    Box(modifier = Modifier.fillMaxSize().background(Bg_Color)) {

        val contentDescriptionImage by remember {
            mutableStateOf("Ismlar ma'nosi")
        }

        Image(
            modifier = Modifier
                .size(150.dp)
                .align(Alignment.Center),
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = contentDescriptionImage,
            contentScale = ContentScale.FillBounds
        )

    }
}

@Preview(showSystemUi = true)
@Composable
fun SplashScreenPreview() {
    SplashScreenContent(SplashUiState(), LocalNavigator.currentOrThrow)
}