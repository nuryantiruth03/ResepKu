package com.example.resepku

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow


data class Resep(
    val nama: String,
    val gambar: Painter,
    val kategori: String,
    val deskripsi: String
)





@Composable
fun ResepListScreen(modifier: Modifier) {
    // Data dummy untuk resep
    val resepList = listOf(
        Resep("Nasi Goreng", painterResource(id = R.drawable.nasi_goreng), "Makanan Utama", "Resep nasi goreng sederhana."),
        Resep("Martabak Telur", painterResource(id = R.drawable.martabak_telur), "Snack", "Martabak telur menjadi camilan untuk hari raya"),
        Resep("Salad Buah", painterResource(id = R.drawable.salad_buah), "Salad", "Salad buah segar dan sehat."),
        Resep("Sate Ayam", painterResource(id = R.drawable.sate_ayam), "Makanan Utama", "Sate ayam dengan bumbu kacang."),
        Resep("Sup Ayam", painterResource(id = R.drawable.sup_ayam), "Makanan Utama", "Sup ayam segar dan hangat."),
        Resep("Jus Alpukat", painterResource(id = R.drawable.jus_alpukat), "Minuman", "Cuaca Panas? Jus alpukat menjadi pilihan yang tepat untuk menyegarkan harimu"),
        Resep("Rendang", painterResource(id = R.drawable.rendang), "Makanan Utama", "Rendang daging khas Padang."),
        Resep("Kentang Goreng", painterResource(id = R.drawable.kentang_goreng), "Snack", "Kentang Goreng crispy diluar dan lembut di dalam."),
        Resep("Burger", painterResource(id = R.drawable.burger), "Snack", "Burger lezat dengan daging sapi."),
        Resep("Es Buah", painterResource(id = R.drawable.es_buah), "Minuman", "Es buah segar untuk cuaca panas."),
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(resepList.size) { index ->
            ResepCard(resepList[index])
        }
    }
}


@Composable
fun ResepCard(resep: Resep, modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = resep.nama,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Image(
                painter = resep.gambar,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                item {
                    KategoriChip(resep.kategori)
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = resep.deskripsi,
                fontSize = 16.sp,
                textAlign = TextAlign.Justify
            )
        }
    }
}


@Composable
fun KategoriChip(kategori: String, modifier: Modifier = Modifier) {
    Surface(
        color = Color(0xFFE1F5FE),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.padding(4.dp)
    ) {
        Text(
            text = kategori,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
            fontSize = 14.sp,
            color = Color.Black
        )
    }
}
