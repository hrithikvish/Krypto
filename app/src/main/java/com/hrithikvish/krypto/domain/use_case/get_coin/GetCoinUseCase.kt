package com.hrithikvish.krypto.domain.use_case.get_coin

import com.hrithikvish.krypto.common.Resource
import com.hrithikvish.krypto.data.remote.dto.toCoin
import com.hrithikvish.krypto.data.remote.dto.toCoinDetail
import com.hrithikvish.krypto.domain.model.Coin
import com.hrithikvish.krypto.domain.model.CoinDetail
import com.hrithikvish.krypto.domain.respository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred."))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }

}