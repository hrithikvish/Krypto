package com.hrithikvish.krypto.presentation.coin_list

import com.hrithikvish.krypto.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)