package kr.pe.paran.kbank.presentation.screen.home.component

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.pe.paran.kbank.domain.model.AccountData
import kr.pe.paran.kbank.domain.model.ButtonType
import kr.pe.paran.kbank.domain.model.CardData
import kr.pe.paran.kbank.domain.model.CompanyType

@Preview
@Composable
fun OtherBankCard(
    cardData: CardData = CardData(
        title = "다른은행",
        accountDataList = listOf(
            AccountData(
                companyData = CompanyType.KAKAO,
                accountName = "카카오뱅크(4577)",
                accountNumber = "123-456-7890123",
                accountBalance = 31164,
            ),
            AccountData(
                companyData = CompanyType.NONGHYUP,
                accountName = "NH농협은행(8528)",
                accountNumber = "123-456-7890123",
                accountBalance = 290334,
            )
        ),
    ),
    onClick: () -> Unit = {},
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        shape = RoundedCornerShape(corner = CornerSize(14.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 24.dp),
        ) {
            CardTitle(title = cardData.title)
            Spacer(modifier = Modifier.height(16.dp))
            cardData.accountDataList.forEachIndexed { index, accountData ->
                OtherBankItem(
                    accountData = accountData,
                    onClick = {
                        onClick()
                    }
                )
                if (index != cardData.accountDataList.lastIndex) {
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OtherBankItem(
    accountData: AccountData = AccountData(),
    onClick: (ButtonType) -> Unit = {},
) {

    val accountName = "${accountData.companyData.company}(${accountData.accountNumber.takeLast(4)})"

    Row(
        modifier = Modifier
            .clickable(
                interactionSource = MutableInteractionSource(),
                indication = null,
                onClick = {
                    onClick(ButtonType.CARD)
                }
            )
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            modifier = Modifier
                .size(34.dp)
                .clip(CircleShape),
            painter = painterResource(id = accountData.companyData.icon),
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
                )
            )
            Text(
                text = accountData.formattedAccountBalance,
                style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                )
            )
        }

        Spacer(modifier = Modifier.weight(1f))
        OutlinedButton(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(corner = CornerSize(8.dp))),
            shape = RoundedCornerShape(corner = CornerSize(8.dp)),
            border = BorderStroke(1.dp, Color(0xFFE6E9EE)),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color(0xFFF2F6FA),
                contentColor = Color(0xFF1A0889)
            ),
            onClick = {
                onClick(ButtonType.REQUEST_TRANSFER)
            }
        ) {
            Text(
                text = "이체",
                style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
            )
        }
    }
}