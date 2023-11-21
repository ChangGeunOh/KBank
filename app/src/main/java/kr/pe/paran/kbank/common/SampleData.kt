package kr.pe.paran.kbank.common

import kr.pe.paran.kbank.domain.model.AccountType
import kr.pe.paran.kbank.domain.model.AccountData
import kr.pe.paran.kbank.domain.model.CardData
import kr.pe.paran.kbank.domain.model.CompanyType

val CARD_DATA_LIST = listOf<CardData>(
    CardData(
        title = "",
        accountDataList = listOf(
            AccountData(
                companyData = CompanyType.KBANK,
                accountNumber = "1234-1234-1234",
                accountType = AccountType.NORMAL,
                accountBalance = 8918527,
                isGroup = false,
                hasCard = true,
                isOwner = true,
            ),
        )
    ),

    CardData(
        title = "전자공학과",
        accountDataList = listOf(
            AccountData(
                companyData = CompanyType.KBANK,
                accountNumber = "1234-1234-1234",
                accountType = AccountType.NORMAL,
                accountBalance = 123000,
                isGroup = true,
                hasCard = false,
                isOwner = true,
            ),
        )
    ),

    CardData(
        title = "다른은행",
        accountDataList = listOf(
            AccountData(
                companyData = CompanyType.NONGHYUP,
                accountNumber = "818-12-058528",
                accountType = AccountType.NORMAL,
                accountBalance = 123000,
                isGroup = true,
                hasCard = false,
                isOwner = false,
            ),
            AccountData(
                companyData = CompanyType.KAKAO,
                accountNumber = "3333-02-6684577",
                accountType = AccountType.NORMAL,
                accountBalance = 31164,
                isGroup = false,
                hasCard = false,
                isOwner = false,
            ),
        )
    )

)