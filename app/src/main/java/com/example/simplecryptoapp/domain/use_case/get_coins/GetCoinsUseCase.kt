package com.example.simplecryptoapp.domain.use_case.get_coins

import com.example.simplecryptoapp.common.Resource
import com.example.simplecryptoapp.data.remote.dto.toCoin
import com.example.simplecryptoapp.data.remote.dto.toCoinDetail
import com.example.simplecryptoapp.domain.model.Coin
import com.example.simplecryptoapp.domain.model.CoinDetail
import com.example.simplecryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke() : Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoin().map { it.toCoin() }
            emit(Resource.Succes<List<Coin>>(coins))
        }catch (e : HttpException){
            emit(Resource.Error<List<Coin>>(
                message = e.localizedMessage?: "An Unexcepted error occured"
            ))
        }catch (e : IOException){
            emit(
                Resource.Error<List<Coin>>(
                    message = "Couln't reach server. check your internet connection"
                )
            )

        }
    }
}