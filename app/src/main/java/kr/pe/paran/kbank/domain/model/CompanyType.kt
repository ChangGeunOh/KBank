package kr.pe.paran.kbank.domain.model

import androidx.annotation.DrawableRes
import kr.pe.paran.kbank.R


enum class CompanyType(
    val company: String,
    @DrawableRes val icon: Int,
    val isBank: Boolean = false,
) {
    KAKAO(
        company = "카카오뱅크",
        icon = R.drawable.ic_bank_kakao,
        isBank = true
    ),
    NONGHYUP(
        company = "NH농협은행",
        icon = R.drawable.ic_bank_nonghyup,
        isBank = true
    ),
    KEB(
        company = "KEB하나은행",
        icon = R.drawable.ic_bank_keb,
        isBank = true
    ),
    KBANK(
        company = "Kbank",
        icon = R.drawable.ic_bank_kbank,
        isBank = true
    ),
}
