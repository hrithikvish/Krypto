package com.hrithikvish.krypto.presentation.coin_detail

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hrithikvish.krypto.common.Constants.PARAM_COIN_ID
import com.hrithikvish.krypto.common.Resource
import com.hrithikvish.krypto.domain.use_case.get_coin.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf(CoinDetailState())
    private val _state2 = MutableStateFlow(CoinDetailState())
    val state: State<CoinDetailState> = _state
    val state2: StateFlow<CoinDetailState?> = _state2

    init {
        savedStateHandle.get<String>(PARAM_COIN_ID)?.let { coinId ->
            getCoin(coinId)
            Log.d("tesstt", "${this::class.simpleName} init: $coinId")
        }
    }

    private fun getCoin(coinId: String) {
        getCoinUseCase(coinId).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = CoinDetailState(coin = result.data)
                    _state2.value = CoinDetailState(coin = result.data)
                }
                is Resource.Loading -> {
                    _state.value = CoinDetailState(isLoading = true)
                    _state2.value = CoinDetailState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = CoinDetailState(error = result.message ?: "An unexpected error occurred")
                    _state2.value = CoinDetailState(error = result.message ?: "An unexpected error occurred")
                }
            }
        }.launchIn(viewModelScope)
    }

}