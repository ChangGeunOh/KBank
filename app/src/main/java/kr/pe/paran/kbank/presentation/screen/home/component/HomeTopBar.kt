package kr.pe.paran.kbank.presentation.screen.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.pe.paran.kbank.R
import kr.pe.paran.kbank.domain.model.ButtonType
import kr.pe.paran.kbank.ui.theme.MainBackgroundColor

@Preview(showBackground = true)
@Composable
fun HomeTopBar(
    onClick: (ButtonType) -> Unit = {},
) {
    Row(
        modifier = Modifier
            .background(MainBackgroundColor)
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .width(76.dp)
                .height(19.dp),
            painter = painterResource(id = R.drawable.img_kbank_logo),
            contentDescription = "Kbank Logo"
        )
        Spacer(modifier = Modifier.weight(1f))
        Image(
            modifier = Modifier
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null,
                ) {
                    onClick(ButtonType.TOP_CHUL_CHECK)
                },
            painter = painterResource(id = R.drawable.img_chul_check),
            contentDescription = "Chul Check"
        )
        Spacer(modifier = Modifier.width(8.dp))
        Image(
            modifier = Modifier
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null,
                ) {
                    onClick(ButtonType.TOP_CHUL_CHECK)
                },
            painter = painterResource(id = R.drawable.ic_chul_check),
            contentDescription = "Chul Check"
        )
        Spacer(modifier = Modifier.width(16.dp))
        Image(
            modifier = Modifier
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null,
                ) {
                    onClick(ButtonType.TOP_BENEFITS)
                },
            painter = painterResource(id = R.drawable.ic_benefits),
            contentDescription = "Benefits"
        )
    }
}