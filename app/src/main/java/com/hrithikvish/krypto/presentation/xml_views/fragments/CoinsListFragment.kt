package com.hrithikvish.krypto.presentation.xml_views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.hrithikvish.krypto.databinding.FragmentCoinsListBinding
import com.hrithikvish.krypto.presentation.coin_list.CoinListViewModel
import com.hrithikvish.krypto.presentation.xml_views.adapter.CoinListRvAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlin.getValue

@AndroidEntryPoint
class CoinsListFragment() : Fragment() {

    private lateinit var binding: FragmentCoinsListBinding
    private val coinListViewModel by viewModels<CoinListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCoinsListBinding.inflate(layoutInflater, container, false)

        val coinListState = coinListViewModel.state2

        val adapter = CoinListRvAdapter(
            onItemClick = { coinId ->
                val action = CoinsListFragmentDirections.actionCoinsListFragmentToCoinDetailFragment(coinId = coinId)
                findNavController().navigate(action)
            }
        )
        binding.coinListRv.adapter = adapter

        lifecycleScope.launch {
            coinListState.collect { coinListState ->
                binding.isLoading = coinListState.isLoading
                binding.error = coinListState.error
                adapter.submitCoins(coinListState.coins)
            }
        }

        return binding.root
    }
}