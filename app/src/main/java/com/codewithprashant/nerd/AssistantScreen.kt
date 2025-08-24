package com.codewithprashant.nerd

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome // Using a "sparkling" icon
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
// import androidx.compose.ui.graphics.Color // No longer explicitly needed due to MaterialTheme
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AssistantScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("AI Assistant") } 
            )
        },
        bottomBar = {
            BottomNavigationBar(navController = navController, currentRoute = "assistant")
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp), 
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Filled.AutoAwesome,
                    contentDescription = "AI Assistant Icon",
                    modifier = Modifier.size(72.dp),
                    tint = MaterialTheme.colorScheme.primary 
                )
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "Pixel AI Assistant",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface 
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Coming Soon!",
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant 
                )
            }
        }
    }
}
