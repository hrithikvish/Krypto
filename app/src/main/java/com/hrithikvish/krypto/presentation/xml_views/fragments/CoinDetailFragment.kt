package com.hrithikvish.krypto.presentation.xml_views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.hrithikvish.krypto.databinding.FragmentCoinDetailBinding
import com.hrithikvish.krypto.presentation.coin_detail.CoinDetailViewModel
import com.hrithikvish.krypto.presentation.xml_views.adapter.TagsRvAdapter
import com.hrithikvish.krypto.presentation.xml_views.adapter.TeamRvAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CoinDetailFragment : Fragment() {

    private lateinit var binding: FragmentCoinDetailBinding
    val args by navArgs<CoinDetailFragmentArgs>()
    val coinDetailViewModel by viewModels<CoinDetailViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCoinDetailBinding.inflate(layoutInflater, container, false)

        val coinDetailState = coinDetailViewModel.state2

        val tagAdapter = TagsRvAdapter()

        val teamAdapter = TeamRvAdapter()
        binding.teamMembersRv.adapter = teamAdapter

        lifecycleScope.launch {
            coinDetailState.collect { coinDetailState ->
                binding.isLoading = coinDetailState?.isLoading
                coinDetailState?.coin?.let {
                    binding.error = coinDetailState.error
                    binding.coin = it
                    //tagAdapter.submitTags(coinDetailState.coin.tags)
                    teamAdapter.submitTeam(coinDetailState.coin.team)
                }
            }
        }

        return binding.root
    }

}