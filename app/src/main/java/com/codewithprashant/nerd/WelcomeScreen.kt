package com.codewithprashant.nerd

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen(navController: NavController) {
    var selectedSubjects by remember { mutableStateOf(setOf<String>()) }
    val subjects = listOf("Mathematics", "Science", "History", "Literature", "Art", "Music")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        TopAppBar(
            title = {
                Text(
                    text = "Learn",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            },
            actions = {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "Settings",
                        tint = Color.Black
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.White
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Welcome back, Ethan!",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Ready to continue your learning journey? Select your preferred subjects to get personalized recommendations.",
            fontSize = 16.sp,
            color = Color.Gray,
            lineHeight = 24.sp
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Choose your subjects",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(16.dp))

        subjects.chunked(3).forEach { rowSubjects ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                rowSubjects.forEach { subject ->
                    val isSelected = selectedSubjects.contains(subject)
                    FilterChip(
                        onClick = {
                            selectedSubjects = if (isSelected) {
                                selectedSubjects - subject
                            } else {
                                selectedSubjects + subject
                            }
                        },
                        label = {
                            Text(
                                text = subject,
                                fontSize = 14.sp,
                                color = if (isSelected) Color.White else Color.Black
                            )
                        },
                        selected = isSelected,
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = Color.Black,
                            containerColor = Color.Gray.copy(alpha = 0.1f)
                        )
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Featured",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            FeaturedCard(
                title = "Structured Learning Paths",
                subtitle = "Follow a curated learning path tailored to your goals.",
                backgroundColor = Color(0xFFFDCB6E),
                modifier = Modifier.weight(1f),
                onClick = { navController.navigate("home") }
            )

            FeaturedCard(
                title = "Interactive Videos",
                subtitle = "Engage with expert-led interactive video sessions.",
                backgroundColor = Color(0xFFE17055),
                modifier = Modifier.weight(1f),
                onClick = { navController.navigate("home") }
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        BottomNavigationBar(
            navController = navController,
            currentRoute = "welcome"
        )
    }
}

@Composable
fun FeaturedCard(
    title: String,
    subtitle: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .height(200.dp)
            .background(backgroundColor, RoundedCornerShape(16.dp))
            .clickable { onClick() }
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.align(Alignment.BottomStart)
        ) {
            Text(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = subtitle,
                fontSize = 12.sp,
                color = Color.Black.copy(alpha = 0.7f),
                lineHeight = 16.sp
            )
        }
    }
}