package kr.pe.paran.kbank.presentation.screen.home.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CardItem(
    @DrawableRes iconId: Int,
    accountName: String,
    balance: Long,
    text: String? = null,
    onClick: () -> Unit = {},
    onButtonClick: () -> Unit = {},
) {
    Row(
        modifier = Modifier
            .clickable(
                interactionSource = MutableInteractionSource(),
                indication = null,
                onClick = onClick
            )
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            modifier = Modifier
                .size(34.dp),
            painter = painterResource(id = iconId),
            contentDescription = "Icon"
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = accountName,
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF333333)
                ),
            )
            Text(
                modifier = Modifier
                    .offset(y = (-4).dp),
                text = String.format("%,d", balance) + "원",
                style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                ),
            )
        }

        Spacer(modifier = Modifier.weight(1f))
        text?.let { name ->
            OutlinedButton(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(corner = CornerSize(8.dp))),
                shape = RoundedCornerShape(corner = CornerSize(8.dp)),
                border = BorderStroke(1.dp, Color(0xFFE6E9EE)),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color(0xFFF2F6FA),
                    contentColor = Color(0xFF1A0889)
                ),
                onClick = onButtonClick
            ) {
                Text(
                    text = name,
                    style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                )
            }
        }
    }
}