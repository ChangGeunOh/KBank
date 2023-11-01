package kr.pe.paran.kbank.data.repository

import kr.pe.paran.kbank.data.network.Network
import kr.pe.paran.kbank.domain.repository.NetworkDataSource
import javax.inject.Inject

class NetworkDataSourceImpl @Inject constructor(
    private val network: Network,
): NetworkDataSource {
}