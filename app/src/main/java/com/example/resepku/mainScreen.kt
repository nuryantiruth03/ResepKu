package com.example.resepku


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen() {
    val currentScreen = remember { mutableStateOf("Home") }
    Scaffold(
        topBar = {
            TopBar(title = currentScreen.value)
        },
        bottomBar = {
            BottomNavigationBar { screen ->
                currentScreen.value = screen
            }
        }
    ) {paddingValues ->
        when (currentScreen.value) {
            "Home" -> ResepListScreen(modifier = Modifier.padding(paddingValues))

        }
    }
}
