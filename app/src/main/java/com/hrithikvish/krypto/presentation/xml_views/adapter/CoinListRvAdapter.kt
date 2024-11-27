package com.hrithikvish.krypto.presentation.xml_views.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hrithikvish.krypto.databinding.MainListScreenItemBinding
import com.hrithikvish.krypto.domain.model.Coin
import com.hrithikvish.krypto.presentation.xml_views.adapter.CoinListRvAdapter.CoinListViewHolder

class CoinListRvAdapter(
    private val onItemClick: (String) -> Unit
): RecyclerView.Adapter<CoinListViewHolder>() {

    private val coinList = mutableListOf<Coin>()

    @SuppressLint("NotifyDataSetChanged")
    fun submitCoins(coinsList: List<Coin>) {
        coinList.clear()
        coinList.addAll(coinsList)
        notifyDataSetChanged()
    }

    inner class CoinListViewHolder(val binding: MainListScreenItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinListViewHolder {
        val binding = MainListScreenItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CoinListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoinListViewHolder, position: Int) {
        with(holder.binding) {
            coin = coinList[position]
            root.setOnClickListener {
                onItemClick(coin!!.id)
            }
        }
    }

    override fun getItemCount(): Int = coinList.size

}