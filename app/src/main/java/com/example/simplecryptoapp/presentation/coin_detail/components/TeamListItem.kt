package com.example.simplecryptoapp.presentation.coin_detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.simplecryptoapp.data.remote.dto.TeamMember
import com.example.simplecryptoapp.presentation.ui.theme.SimpleCryptoAppTheme

@Composable
fun TeamListItem(
    teamMember: TeamMember,
    m:Modifier = Modifier
){
    Column(
        modifier = m,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = teamMember.name,
            style = MaterialTheme.typography.h4
        )
        Spacer(modifier = m.height(4.dp) )
        Text(
            text = teamMember.position,
            style = MaterialTheme.typography.body2,
            fontStyle = FontStyle.Italic
        )

    }
}

@Preview
@Composable
fun priviewTeamMamber(){
    SimpleCryptoAppTheme {
        TeamListItem(teamMember = TeamMember(
            id = "1",
            name = "Andy",
            position = "1"
        ))
    }
}