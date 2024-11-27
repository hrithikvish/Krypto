package com.hrithikvish.krypto.presentation.coin_detail

import com.hrithikvish.krypto.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)