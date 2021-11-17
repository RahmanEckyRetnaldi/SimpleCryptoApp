package com.example.simplecryptoapp.domain.use_case.get_coin

import com.example.simplecryptoapp.common.Resource
import com.example.simplecryptoapp.data.remote.dto.toCoinDetail
import com.example.simplecryptoapp.domain.model.CoinDetail
import com.example.simplecryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(coinId : String) : Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Succes<CoinDetail>(coin))
        }catch (e : HttpException){
            emit(Resource.Error<CoinDetail>(
                message = e.localizedMessage?: "An Unexcepted error occured"
            ))
        }catch (e : IOException){
            emit(
                Resource.Error<CoinDetail>(
                    message = "Couln't reach server. check your internet connection"
                )
            )

        }
    }
}