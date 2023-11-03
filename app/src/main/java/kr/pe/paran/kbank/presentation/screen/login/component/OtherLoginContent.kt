package kr.pe.paran.kbank.presentation.screen.login.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.rounded.Help
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.pe.paran.kbank.common.utils.Logcat
import kr.pe.paran.kbank.presentation.screen.login.viewmodel.LoginEvent
import kr.pe.paran.kbank.presentation.screen.login.viewmodel.OtherAuthEvent

@Composable
fun OtherLoginContent(
    onEvent: (LoginEvent) -> Unit = {},
) {
    val itemTextStyle = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
        color = Color(0xFF444D55)
    )
    Column(
        modifier = Modifier
            .padding(30.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "다른 인증 선택",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black
                )
            )
            Spacer(modifier = Modifier.weight(1f))
            Image(
                modifier = Modifier
                    .clickable(
                        interactionSource = MutableInteractionSource(),
                        indication = null,
                        onClick = {
                            onEvent(
                                LoginEvent.OnClickOtherAuth(otherAuthEvent = OtherAuthEvent.Close)
                            )
                        }
                    ),
                imageVector = Icons.Default.Close,
                contentDescription = "Close"
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Text(modifier = Modifier
            .clickable(
                interactionSource = MutableInteractionSource(),
                indication = null,
                onClick = {
                    onEvent(
                        LoginEvent.OnClickOtherAuth(otherAuthEvent = OtherAuthEvent.BioAuth)
                    )
                }
            ),
            text = "바이오인증",
            style = itemTextStyle
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(modifier = Modifier
            .clickable(
                interactionSource = MutableInteractionSource(),
                indication = null,
                onClick = {
                    onEvent(
                        LoginEvent.OnClickOtherAuth(otherAuthEvent = OtherAuthEvent.CertAuth)
                    )
                }
            ),
            text = "인증서",
            style = itemTextStyle
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(modifier = Modifier
            .clickable(
                interactionSource = MutableInteractionSource(),
                indication = null,
                onClick = {
                    onEvent(
                        LoginEvent.OnClickOtherAuth(otherAuthEvent = OtherAuthEvent.PassAuth)
                    )
                }
            ),
            text = "아이디/비밀번호",
            style = itemTextStyle
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null,
                    onClick = {
                        onEvent(
                            LoginEvent.OnClickOtherAuth(otherAuthEvent = OtherAuthEvent.Help)
                        )
                    }
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(16.dp),
                imageVector = Icons.Rounded.Help,
                contentDescription = "Help",
                colorFilter = ColorFilter.tint(Color(0xFFCFD3D6))
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "도움이 필요하신가요",
                style = TextStyle(
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    color = Color(0xFF818181)
                )
            )
            Spacer(modifier = Modifier.width(4.dp))
            Image(
                modifier = Modifier.size(16.dp),
                imageVector = Icons.Default.ArrowForwardIos,
                contentDescription = "Close",
                colorFilter = ColorFilter.tint(Color(0xFFCFD3D6))
            )
            Spacer(modifier = Modifier.height(36.dp))
        }
    }
}