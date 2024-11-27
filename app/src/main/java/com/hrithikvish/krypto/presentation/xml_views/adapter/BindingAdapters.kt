package com.hrithikvish.krypto.presentation.xml_views.adapter

import androidx.databinding.BindingAdapter
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

@BindingAdapter("chipsList")
fun setChipsList(chipGroup: ChipGroup, tags: List<String>?) {
    tags?.forEach {
        val chip = Chip(chipGroup.context).apply {
            text = it
            setEnsureMinTouchTargetSize(false)
        }
        chipGroup.addView(chip)
    }
}