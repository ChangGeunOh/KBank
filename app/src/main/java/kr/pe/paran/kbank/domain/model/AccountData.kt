package kr.pe.paran.kbank.domain.model

import androidx.annotation.DrawableRes
import kr.pe.paran.kbank.R

data class AccountData(
    val companyData: CompanyType = CompanyType.KBANK,
    val accountName: String = "듀얼K 입출금 통장",
    val accountNumber: String = "123-456-789012",
    val accountType: AccountType = AccountType.CREDIT,
    val accountBalance: Long = 11743767,
    val hasCard: Boolean = false,
    val isOwner: Boolean = false,
    val isGroup: Boolean = false,
    val groupName: String = "",
    @DrawableRes
    val groupImage: Int = R.drawable.ic_bank_kbank,
) {
    val formattedAccountBalance: String = String.format("%,d원", accountBalance)
}