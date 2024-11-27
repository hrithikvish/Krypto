package com.hrithikvish.krypto.domain.respository

import com.hrithikvish.krypto.data.remote.dto.CoinDetailDto
import com.hrithikvish.krypto.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto

}