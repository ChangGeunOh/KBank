package kr.pe.paran.kbank.presentation.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.pe.paran.kbank.R
import kr.pe.paran.kbank.presentation.screen.splash.viewmodel.SplashState

@Composable
fun SplashContent(
    innerPadding: PaddingValues = PaddingValues(),
    state: SplashState,
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .background(Color.White)
                .padding(horizontal = 40.dp, vertical = 100.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
        ) {

            Image(painter = painterResource(id = R.drawable.img_makemoney), contentDescription = "Make Money")
            Spacer(modifier = Modifier.height(58.dp))
            Image(painter = painterResource(id = R.drawable.img_kbank_logo), contentDescription = "KBank Logo")
        }

        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = Color(0xFF00F8F8),
            )
        }
    }
}
