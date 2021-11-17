package com.example.simplecryptoapp.data.repository

import com.example.simplecryptoapp.data.remote.CoinPaprikaApi
import com.example.simplecryptoapp.data.remote.dto.CoinDetailDto
import com.example.simplecryptoapp.data.remote.dto.CoinDtoItem
import com.example.simplecryptoapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api : CoinPaprikaApi
) : CoinRepository{
    override suspend fun getCoin(): List<CoinDtoItem> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId = coinId)
    }
}