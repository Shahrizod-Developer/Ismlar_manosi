package uz.smartmuslim.ismlarmanosi.presentation.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getScreenModel
import cafe.adriel.voyager.hilt.getViewModel
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import org.orbitmvi.orbit.compose.collectAsState
import uz.smartmuslim.ismlarmanosi.R
import uz.smartmuslim.ismlarmanosi.data.model.Menus
import uz.smartmuslim.ismlarmanosi.presentation.ui.theme.Bg_Color
import uz.smartmuslim.ismlarmanosi.presentation.ui.theme.Bg_Image_Color
import uz.smartmuslim.ismlarmanosi.presentation.ui.theme.Bg_Main_Color

object HomePage : Tab {

    override val options: TabOptions
        @Composable
        get() {
            val title = "Uy"
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
        val screenModel: HomePageContract.ViewModel = getScreenModel<HomeModel>()
        val uiState = screenModel.collectAsState().value
        HomePageContent(uiState, screenModel::onEventDispatcher)
    }
}

@Composable
fun HomePageContent(
    uiState: HomePageContract.HomeUiState,
    onEventDispatchers: (HomePageContract.HomeIntent) -> Unit
) {


    when (uiState) {
        is HomePageContract.HomeUiState.Counts -> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 60.dp)
                    .background(Bg_Main_Color)
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .clip(RoundedCornerShape(bottomEnd = 26.dp, bottomStart = 26.dp))
                        .background(Color.White)
                ) {

                    Box(
                        modifier = Modifier
                            .padding(10.dp)
                            .size(34.dp)
                            .clip(CircleShape)
                            .clickable(onClick = {})
                            .background(Bg_Image_Color)
                            .align(Alignment.CenterVertically)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.splash),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(5.dp),
                            contentScale = ContentScale.FillHeight
                        )
                    }

                    Text(
                        text = "Assalamu alaykum",
                        Modifier
                            .padding(start = 10.dp)
                            .align(Alignment.CenterVertically),
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font((R.font.geometria_medium))),
                        color = Color.Black,
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        Image(
                            painter = painterResource(R.drawable.notification),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(end = 10.dp)
                                .clip(CircleShape)
                                .clickable(onClick = {})
                                .size(30.dp)
                                .padding(5.dp),
                            contentScale = ContentScale.FillHeight
                        )

                        Image(
                            painter = painterResource(R.drawable.drop),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(end = 16.dp, bottom = 10.dp)
                                .size(6.dp),
                            contentScale = ContentScale.FillHeight
                        )
                    }
                }

                val list = remember {
                    listOf(
                        Menus(
                            R.drawable.search,
                            "Eng ko'p qidirilganlar",
                            "Oxirgi 1 hafta ichidagi eng ko'p qidirilagn ismlar ni ko'rishinghiz mumkin",
                            10
                        ),

                        Menus(
                            R.drawable.top,
                            "Eng ko'p yoqqanlar",
                            "Eng ko'p yoqtirilgan top 100 ta ismlar ni ko'rishinghiz mumkin",
                            10
                        ),

                        Menus(
                            R.drawable.abc,
                            "Alifbo bo'yicha",
                            "Har bir harf uchun alifbo tartibida tartiblanganlar ismlarni ko'rishingiz mumkin",
                            10
                        )
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Column(
                        modifier = Modifier
                            .size(width = 180.dp, height = 220.dp)
                            .padding(20.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color.White)
                            .clickable(onClick = {
                                onEventDispatchers.invoke(
                                    HomePageContract.HomeIntent.OpenNamesScreen(
                                        1
                                    )
                                )
                            }),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(R.drawable.boy),
                            contentDescription = null,
                            modifier = Modifier.size(60.dp),
                            contentScale = ContentScale.FillHeight
                        )
                        Text(
                            text = "O'g'il bolalar",
                            Modifier.padding(top = 10.dp),
                            fontSize = 18.sp,
                            fontFamily = FontFamily(Font((R.font.geometria_medium))),
                            color = Color.Black,
                        )

                        Text(
                            text = uiState.boyNameCount.toString(),
                            Modifier.padding(top = 20.dp),
                            fontSize = 18.sp,
                            fontFamily = FontFamily(Font((R.font.geometria_medium))),
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )

                    }

                    Column(
                        modifier = Modifier
                            .size(width = 180.dp, height = 220.dp)
                            .padding(20.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color.White)
                            .clickable(onClick = {
                                onEventDispatchers.invoke(
                                    HomePageContract.HomeIntent.OpenNamesScreen(
                                        2
                                    )
                                )
                            }),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                        Image(
                            painter = painterResource(R.drawable.girl),
                            contentDescription = null,
                            modifier = Modifier.size(60.dp),
                            contentScale = ContentScale.FillHeight
                        )
                        Text(
                            text = "Qiz bolalar",
                            Modifier.padding(top = 10.dp),
                            fontSize = 18.sp,
                            fontFamily = FontFamily(Font((R.font.geometria_medium))),
                            color = Color.Black,
                        )

                        Text(
                            text = uiState.girlNameCount.toString(),
                            Modifier.padding(top = 20.dp),
                            fontSize = 18.sp,
                            fontFamily = FontFamily(Font((R.font.geometria_medium))),
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                LazyColumn(
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    items(items = list, itemContent = {
                        MenuItem(menus = it)
                    })
                }
            }
        }
    }
}

@Composable
fun MenuItem(menus: Menus) {

    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth()
            .height(150.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
            .clickable(onClick = {}), elevation = 2.dp, backgroundColor = Color.White
    ) {

        Row {
            Image(
                painter = painterResource(menus.image),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .width(80.dp)
                    .align(Alignment.CenterVertically)
                    .height(100.dp)
                    .clip(RoundedCornerShape(corner = CornerSize(10.dp))),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = menus.title,
                    Modifier.padding(top = 10.dp),
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font((R.font.geometria_medium))),
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = menus.desc,
                    Modifier.padding(top = 10.dp),
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font((R.font.geometria_medium))),
                    color = Color.Black,
                    fontWeight = FontWeight.Normal
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    contentAlignment = Alignment.BottomEnd
                ) {

                    Card(
                        modifier = Modifier
                            .height(30.dp)
                            .width(100.dp)
                            .clip(RoundedCornerShape(corner = CornerSize(20.dp)))
                            .clickable(onClick = {}),
                        elevation = 2.dp,
                        backgroundColor = Bg_Color,
                        shape = RoundedCornerShape(corner = CornerSize(26.dp))
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = menus.count.toString() + " ta ",
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font((R.font.geometria_medium))),
                                color = Color.White,
                            )
                        }
                    }
                }
            }
        }
    }
}