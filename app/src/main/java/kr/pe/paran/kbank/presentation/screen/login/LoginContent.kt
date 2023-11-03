package kr.pe.paran.kbank.presentation.screen.login

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kr.pe.paran.kbank.R
import kr.pe.paran.kbank.common.utils.Logcat
import kr.pe.paran.kbank.presentation.screen.login.component.KeyPadLayout
import kr.pe.paran.kbank.presentation.screen.login.viewmodel.LoginEvent
import kr.pe.paran.kbank.presentation.screen.login.viewmodel.LoginState
import kr.pe.paran.kbank.ui.theme.ActivatedColor
import kr.pe.paran.kbank.ui.theme.DeActivatedColor
import kotlin.reflect.KFunction1

@Composable
fun LoginContent(
    innerPadding: PaddingValues,
    state: LoginState,
    onEvent: KFunction1<LoginEvent, Unit>,
) {

    val coroutineScope = rememberCoroutineScope()
//    var isShowKeyPad by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(120.dp))
        Image(
            modifier = Modifier.width(100.dp),
            painter = painterResource(id = R.drawable.img_kbank_logo),
            contentDescription = "KBank Logo"
        )
        Spacer(modifier = Modifier.height(48.dp))
        Row(
            modifier = Modifier
                .clickable(interactionSource = MutableInteractionSource(), indication = null) {
                    onEvent(LoginEvent.OnShowKeyPad)
                }
                .width(180.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            for (i in 1..6) {
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                        .background(
                            if (i <= state.password.length) ActivatedColor else DeActivatedColor
                        )
                )
            }
        }

        Spacer(modifier = Modifier.height(69.dp))
        FilledTonalButton(onClick = {
            Logcat.i("비밀번호 재등록")
        }) {
            Text(
                text = "비밀번호 재등록",
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                )
            )
        }

        Spacer(modifier = Modifier.weight(1f))
        TextButton(onClick = {
            Logcat.i("onClickOther")
            onEvent(LoginEvent.OnClickOther)
        } ) {
            Text(
                text = "다른 방법으로 로그인하기",
                style = TextStyle(
                    color = Color(0xFF7D7D7D),
                    textDecoration = TextDecoration.Underline,
                )
            )

        }
        Spacer(modifier = Modifier.height(16.dp))

        AnimatedVisibility(visible = state.isShowKeyPad) {
            KeyPadLayout(
                onClick = {
                    onEvent(LoginEvent.OnClickKeyPad(it))
                }
            )
        }

    }

}

