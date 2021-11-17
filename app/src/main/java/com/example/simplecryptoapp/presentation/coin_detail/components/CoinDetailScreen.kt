package com.example.simplecryptoapp.presentation.coin_detail.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.simplecryptoapp.presentation.coin_detail.CoinDetailViewModel
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun CoinDetailScreen(
    viewModel: CoinDetailViewModel = hiltViewModel(),
    m:Modifier = Modifier
){
    val state = viewModel.state.value

    Box(
        modifier = m.fillMaxWidth()
    ) {
        state.coin?.let {
            coinDetail ->

            LazyColumn(
                modifier = m.fillMaxSize(),
                contentPadding = PaddingValues(20.dp)
            ){
                item {
                    Row(
                        modifier = m.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "${coinDetail.rank}. ${coinDetail.name} (${coinDetail.symbol})",
                            style = MaterialTheme.typography.h2,
                            modifier = m.weight(8f)
                        )
                        Text(
                            text = if(coinDetail.isActive) "active" else "inactive",
                            color = if(coinDetail.isActive) Color.Green else Color.Red,
                            fontStyle = FontStyle.Italic,
                            textAlign = TextAlign.End,
                            modifier = m
                                .align(CenterVertically)
                                .weight(2f)
                        )
                    }
                    Spacer(modifier = m.height(15.dp))
                    Text(
                        text = coinDetail.description,
                        style = MaterialTheme.typography.body2
                    )
                    Spacer(modifier = m.height(15.dp))
                    Text(
                        text = "Tags",
                        style = MaterialTheme.typography.h3
                    )
                    Spacer(modifier = m.height(15.dp))
                    FlowRow(
                        mainAxisSpacing = 10.dp,
                        crossAxisSpacing = 10.dp,
                        modifier = m.fillMaxWidth()
                    ) {
                        coinDetail.tags.forEach {
                            CoinTag(tag = it)
                        }

                    }
                    Spacer(modifier = m.height(15.dp))
                    Text(
                        text = "Team member",
                        style = MaterialTheme.typography.h3
                    )
                    Spacer(modifier = m.height(15.dp))
                }
                items(coinDetail.team){
                    teamMamber ->
                    TeamListItem(
                        teamMember = teamMamber,
                        m
                            .fillMaxWidth()
                            .padding(10.dp)
                    )
                    Divider()
                }
            }
        }
        if (state.error.isNotBlank()){
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = m
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Center)
            )
        }
        if(state.isLoading){
            CircularProgressIndicator(
                m.align(Center)
            )
        }
    }
}