package com.example.simplecryptoapp.data.remote.dto

import com.example.simplecryptoapp.domain.model.Coin

data class CoinDtoItem(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)


fun CoinDtoItem.toCoin() : Coin{

    return Coin(
        id = id,
        is_active = is_active,
        name = name,
        rank = rank,
        symbol = symbol
    )
}