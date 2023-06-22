package uz.smartmuslim.ismlarmanosi.presentation.ui.screen.names

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getScreenModel
import cafe.adriel.voyager.hilt.getViewModel
import org.orbitmvi.orbit.compose.collectAsState
import uz.smartmuslim.ismlarmanosi.R
import uz.smartmuslim.ismlarmanosi.data.model.NameData
import uz.smartmuslim.ismlarmanosi.presentation.ui.theme.Bg_Main_Color
import uz.smartmuslim.ismlarmanosi.presentation.ui.theme.Bg_Search_Color
import uz.smartmuslim.ismlarmanosi.presentation.ui.theme.Bg_Stroke_Color
import uz.smartmuslim.ismlarmanosi.utils.myLog

class NamesScreen(private val status: Int) : AndroidScreen() {

    @Composable
    override fun Content() {

        val screenModel: NamesScreenContract.Model = getScreenModel<NamesModel>()
        val uiState = screenModel.collectAsState().value

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Bg_Main_Color),
        ) {
            NamesScreenContent(uiState, screenModel::onEventDispatcher, status)
        }
    }
}

@Composable
fun NamesScreenContent(
    uiState: NamesScreenContract.NamesUiState,
    onEventDispatcher: (NamesScreenContract.NamesIntent) -> Unit,
    status: Int
) {
    when (uiState) {
        is NamesScreenContract.NamesUiState.Names -> {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Bg_Main_Color),
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .clip(RoundedCornerShape(bottomEnd = 26.dp, bottomStart = 26.dp))
                        .background(Color.White)
                ) {

                    Text(
                        text = "O'g'il bolalar ismlari",
                        Modifier.padding(10.dp),
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font((R.font.geometria_medium))),
                        color = Color.Black,
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .clip(RoundedCornerShape(bottomEnd = 26.dp, bottomStart = 26.dp))
                            .background(Color.White),
                    ) {

                        Box(
                            modifier = Modifier
                                .weight(6f)
                                .fillMaxHeight()
                                .padding(vertical = 8.dp, horizontal = 10.dp)
                                .border(
                                    BorderStroke(
                                        width = 0.8.dp, color = Bg_Stroke_Color
                                    ),
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .background(Color.White)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(Bg_Search_Color)
                            )
                            {

                            }
                        }

                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .background(Color.White)
                                .fillMaxHeight()

                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(vertical = 8.dp, horizontal = 8.dp)
                                    .border(
                                        BorderStroke(
                                            width = 0.8.dp, color = Bg_Stroke_Color
                                        ), shape = RoundedCornerShape(8.dp)
                                    )
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(Bg_Search_Color)
                                    .align(Alignment.Center)
                            ) {

                            }
                        }

                    }


                }
                LazyColumn(
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ) {

                    if (status == 1) {
                        items(items = uiState.boysNameList, itemContent = {
                            NameItem(nameData = it)
                        })
                    } else if (status == 2) {
                        items(items = uiState.girlsNameList, itemContent = {
                            NameItem(nameData = it)
                        })
                    }
                }
            }
        }

    }
}

@Composable
fun NameItem(nameData: NameData) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(top = 2.dp, bottom = 2.dp)
            .background(Color.White)
            .clip(RoundedCornerShape(6.dp))
            .background(Color.White),
    ) {
        Text(
            text = nameData.latinName,
            Modifier
                .padding(start = 10.dp)
                .align(Alignment.Center),
            fontSize = 18.sp,
            fontFamily = FontFamily(Font((R.font.geometria_medium))),
            color = Color.Black,
        )
    }
}