package com.bd.uidesignbankingappdemo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bd.uidesignbankingappdemo.ui.theme.Purple40
import com.bd.uidesignbankingappdemo.ui.theme.Purple80
import com.bd.uidesignbankingappdemo.ui.theme.PurpleGrey40
import com.bd.uidesignbankingappdemo.ui.theme.PurpleGrey80

val cards: List<Card> = listOf(

    Card(
        cardType = "VISA",
        cardNumber = "2664 7865 3786 3976",
        cardName = "Business",
        balance = 46.456,
        color = getGradient(Purple40, Purple80)
    ),
    Card(
        cardType = "MASTER CARD",
        cardNumber = "1234 7865 3786 0001",
        cardName = "Saving",
        balance = 12.456,
        color = getGradient(PurpleGrey40, PurpleGrey80)
    ),
    Card(
        cardType = "VISA",
        cardNumber = "3215 7865 3786 6678",
        cardName = "School",
        balance = 72.456,
        color = getGradient(Purple40, Purple80)
    ),
    Card(
        cardType = "VISA",
        cardNumber = "2664 7865 3786 3976",
        cardName = "Business",
        balance = 98.567,
        color = getGradient(PurpleGrey40, PurpleGrey80)
    )
)

fun getGradient(
    startColor: Color,
    endColor: Color
): Brush {
    return Brush.horizontalGradient(
        colors = listOf(startColor,endColor)
    )
}

@Preview
@Composable
fun CardsSection(){
    LazyRow {
        items(cards.size){index ->
            CardItem(index)
        }
    }
}

@Composable
fun CardItem(index: Int){
    val card = cards[index]
    var lastItemPaddingEnd = 0.dp
    if(index == cards.size-1){
        lastItemPaddingEnd = 16.dp
    }
    var image = painterResource(id = R.drawable.visa)
    if(card.cardType == "MASTER CARD"){
        image = painterResource(id = R.drawable.mastercard)
    }
    Box(
        modifier = Modifier.padding(start = 16.dp, end = lastItemPaddingEnd)
    ){
        Column(
            modifier = Modifier.clip(RoundedCornerShape(25.dp)).background(card.color).width(250.dp).height(160.dp) .clickable{}.padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween){
            Image(
                painter = image,
                contentDescription = card.cardName,
                modifier = Modifier.width(60.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = card.cardName, color = Color.White, fontSize = 17.sp, fontWeight = FontWeight.Bold)
            Text(text = card.cardNumber, color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)

            }
    }
}