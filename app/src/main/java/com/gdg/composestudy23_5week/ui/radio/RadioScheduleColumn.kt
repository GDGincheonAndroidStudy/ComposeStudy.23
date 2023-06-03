package com.gdg.composestudy23_5week.ui.radio

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gdg.composestudy23_5week.data.RadioSchedule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RadioScheduleColumn(
    radioList: List<RadioSchedule>,
    coroutineScope: CoroutineScope,
    modalSheetState: ModalBottomSheetState
) {
    radioList.forEach {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column() {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {

                    Image(
                        painter = painterResource(id = it.image),
                        contentDescription = "radio image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clip(
                                shape = RoundedCornerShape(5.dp)
                            )
                            .size(120.dp)
                            .clickable {
                                coroutineScope.launch {
                                    modalSheetState.show()
                                }
                            }
                    )

                    Spacer(modifier = Modifier.padding(10.dp))

                    Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                        Text(
                            text = it.time,
                            fontWeight = FontWeight.Bold,
                            fontSize = 11.sp,
                            color = Color.Gray,
                        )
                        Text(
                            text = it.radioTitle,
                            fontWeight = FontWeight.Bold,
                            fontSize = 17.sp,
                            color = Color.Black,
                        )
                        Text(
                            text = it.radioDescription,
                            fontSize = 15.sp,
                            color = Color.Gray,
                        )
                    }
                }
            }
        }

        Divider(modifier = Modifier.padding(vertical = 10.dp))
    }
}
