package kr.pe.paran.kbank.presentation.screen.home.component

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import kr.pe.paran.kbank.R
import kr.pe.paran.kbank.domain.model.AccountData
import kr.pe.paran.kbank.domain.model.AccountType
import kr.pe.paran.kbank.domain.model.ButtonData
import kr.pe.paran.kbank.domain.model.ButtonType
import kr.pe.paran.kbank.domain.model.CardData
import kr.pe.paran.kbank.domain.model.CompanyType

@Preview
@Composable
fun AccountCard(
    cardData: CardData = CardData(
        title = "",
        accountDataList = listOf(
            AccountData(
                companyData = CompanyType.KBANK,
                accountName = "듀얼K 입출금통장",
                accountNumber = "123-456-7890123",
                accountBalance = 8918527,
                accountType = AccountType.MINUS,
            )
        )
    ),
    onClick: (ButtonType) -> Unit = {},
) {

    val accountData = cardData.accountDataList.first()

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
            if (cardData.title.isNotEmpty()) {
                Text(
                    text = cardData.title,
                    style = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.Bold)
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Image(
                    modifier = Modifier
                        .size(35.dp)
                        .clip(CircleShape),
                    painter = painterResource(id = accountData.companyData.icon),
                    contentDescription = "Icon"
                )

                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = accountData.accountName,
                        style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Medium)
                    )
                    Text(
                        text = accountData.accountNumber,
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF7D7D7d)
                        )
                    )
                }
                if (accountData.accountType == AccountType.MINUS) {
                    Spacer(modifier = Modifier.width(8.dp))
                    Image(
                        modifier = Modifier
                            .padding(top = 4.dp),
                        alignment = Alignment.TopEnd,
                        painter = painterResource(id = R.drawable.ic_minus),
                        contentDescription = "Minus Icon"
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    modifier = Modifier
                        .clickable(
                            interactionSource = MutableInteractionSource(),
                            indication = null
                        ) {
                            // More Icon Click
                        },
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "More Icon",
                    tint = Color.LightGray
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = accountData.formattedAccountBalance,
                style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(16.dp))

            val buttonDataList = mutableListOf<ButtonData>().apply {
                if (accountData.hasCard) {
                    add(ButtonData("카드조회", ButtonType.REQUEST_CARD_INQUIRY))
                } else {
                    add(ButtonData("카드신청", ButtonType.REQUEST_CARD))
                }
                add(ButtonData("가져오기", ButtonType.REQUEST_BRING))
                add(ButtonData("이체하기", ButtonType.REQUEST_TRANSFER))
            }

            AccountButton(
                buttonDataList = buttonDataList,
                onClick = {
                    onClick(it)
                }
            )
        }
    }

}

// first, second, third


