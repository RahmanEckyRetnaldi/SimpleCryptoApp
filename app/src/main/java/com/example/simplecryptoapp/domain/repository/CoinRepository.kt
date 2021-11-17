package com.example.simplecryptoapp.domain.repository

import com.example.simplecryptoapp.data.remote.dto.CoinDetailDto
import com.example.simplecryptoapp.data.remote.dto.CoinDtoItem

interface CoinRepository {

    suspend fun getCoin() : List<CoinDtoItem>

    suspend fun getCoinById(coinId : String) : CoinDetailDto

}