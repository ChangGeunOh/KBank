package kr.pe.paran.kbank.presentation.screen.login.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.pe.paran.kbank.R

@Composable
fun KeyPadLayout(onClick: (String) -> Unit) {
    val numbers = (0..9).toList()
    val shuffledNumbers = numbers.shuffled()
    val chunkedList = shuffledNumbers.chunked(3)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {
        chunkedList.forEachIndexed { index, list ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (index < chunkedList.size - 1) {
                    list.forEach {
                        KeyPadButton(
                            modifier = Modifier
                                .fillMaxHeight()
                                .weight(1f),
                            text = it.toString(),
                            onClick = onClick
                        )
                    }
                } else {
                    ImagePadButton(
                        modifier = Modifier
                            .weight(1f)
                            .height(60.dp),
                        image = R.drawable.img_detect_face,
                        onClick = { onClick("face") }
                    )
                    KeyPadButton(
                        modifier = Modifier
                            .weight(1f)
                            .height(60.dp),
                        text = list.first().toString(),
                        onClick = onClick

                    )

                    ImagePadButton(
                        modifier = Modifier
                            .weight(1f)
                            .height(60.dp),
                        image = R.drawable.img_arrow_back,
                        onClick = { onClick("back") }
                    )
                }
            }
        }
    }

}

@Composable
fun ImagePadButton(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int,
    onClick: (String) -> Unit = {},
) {
    Box(
        modifier = modifier
            .clickable(
                interactionSource = MutableInteractionSource(),
                indication = null,
            ) {
                onClick(image.toString())
            }
    ) {
        Image(
            modifier = Modifier
                .size(32.dp)
                .align(Alignment.Center),
            painter = painterResource(id = image),
            contentDescription = "ImagePadButton",
            contentScale = ContentScale.Fit
        )

    }
}

@Composable
fun KeyPadButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: (String) -> Unit = {},
) {
    Box(
        modifier = modifier
            .clickable(
                interactionSource = MutableInteractionSource(),
                indication = null,
            ) {
                onClick(text)
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                fontSize = 32.sp,
            ),
            textAlign = TextAlign.Center,
        )
    }
}
