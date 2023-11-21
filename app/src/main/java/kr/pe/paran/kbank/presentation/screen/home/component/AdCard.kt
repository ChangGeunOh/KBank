package kr.pe.paran.kbank.presentation.screen.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.pe.paran.kbank.R
import kr.pe.paran.kbank.domain.model.AdData
import kr.pe.paran.kbank.domain.model.ButtonType
import kr.pe.paran.kbank.ui.theme.MainTextColor
import kr.pe.paran.kbank.ui.theme.SubTextColor

@Preview
@Composable
fun AdCard(
    adData: AdData = AdData(
        icon = R.drawable.ic_ad_percent,
        title = "코드K 정기예금",
        description = "오창근님,\n" + "연 4% 이자 드려요",
        summary = "(23.09.13, 12년 기준, 세전)"
    ),
    onClick: (ButtonType) -> Unit = {},
) {
    Card(
        modifier = Modifier
            .clickable(
                interactionSource = MutableInteractionSource(),
                indication = null,
                onClick = {
                    onClick(ButtonType.CARD)
                }
            )
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        shape = RoundedCornerShape(corner = CornerSize(14.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 24.dp),
        ) {
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(52.dp),
                    painter = painterResource(id = adData.icon),
                    contentDescription = "AD Icon",
                )

                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = adData.title,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            color = SubTextColor
                        )
                    )
                    Text(
                        text = adData.description,
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = MainTextColor
                        )
                    )
                    Text(
                        text = adData.summary,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            color = SubTextColor
                        )
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                modifier = Modifier
                    .clickable(
                        interactionSource = MutableInteractionSource(),
                        indication = null,
                        onClick = {
                            onClick(ButtonType.CLOSE)
                        }
                    ),
                imageVector = Icons.Default.Close,
                contentDescription = "Close Icon",
                tint = Color.LightGray
            )
        }
    }
}