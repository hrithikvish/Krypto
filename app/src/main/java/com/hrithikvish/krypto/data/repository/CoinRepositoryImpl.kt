package com.hrithikvish.krypto.data.repository

import com.hrithikvish.krypto.data.remote.CoinPaprikaApi
import com.hrithikvish.krypto.data.remote.dto.CoinDetailDto
import com.hrithikvish.krypto.data.remote.dto.CoinDto
import com.hrithikvish.krypto.domain.respository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }

}