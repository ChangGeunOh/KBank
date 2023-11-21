package kr.pe.paran.kbank.presentation.screen.home.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.pe.paran.kbank.domain.model.ButtonData
import kr.pe.paran.kbank.domain.model.ButtonType
import kr.pe.paran.kbank.ui.theme.ActivatedColor

@Preview(showBackground = true)
@Composable
fun AccountButton(
    buttonDataList: List<ButtonData> = emptyList(),
    onClick: (ButtonType) -> Unit = {},
) {
    if (buttonDataList.isNotEmpty()) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
        ) {

            OutlinedButton(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                shape = RoundedCornerShape(corner = CornerSize(8.dp)),
                border = BorderStroke(1.dp, Color(0xFFE6E9EE)),
                onClick = {
                    onClick(buttonDataList.first().type)
                }
            ) {
                Text(
                    text = buttonDataList.first().name,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = ActivatedColor,
                    )
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            if (buttonDataList.size > 1) {
                Row(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(2f)
                        .border(
                            width = 1.dp,
                            color = Color(0xFFE6E9EE),
                            shape = RoundedCornerShape(corner = CornerSize(8.dp))
                        )
                        .clip(shape = RoundedCornerShape(corner = CornerSize(8.dp)))
                        .background(Color(0xFFF2F6FA)),
                    verticalAlignment = Alignment.CenterVertically,
                ) {

                    buttonDataList.subList(1, buttonDataList.size)
                        .forEachIndexed { index, buttonData ->
                            TextButton(
                                modifier = Modifier
                                    .weight(1f),
                                onClick = { onClick(buttonData.type) }
                            ) {
                                Text(
                                    text = buttonData.name,
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        color = ActivatedColor,
                                    )
                                )
                            }
                            if (index != buttonDataList.size - 2) {
                                Divider(
                                    modifier = Modifier
                                        .padding(top = 4.dp)
                                        .height(16.dp)
                                        .width(1.dp),
                                    color = Color(0xFFE6E9EE)
                                )
                            }
                        }
                }
            }
        }
    }
}
