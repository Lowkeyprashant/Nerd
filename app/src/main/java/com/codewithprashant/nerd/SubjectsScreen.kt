package com.codewithprashant.nerd

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubjectsScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
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
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
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
            text = "Subjects",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            item {
                SubjectItem(
                    category = "Math",
                    title = "Algebra",
                    subtitle = "Master equations and functions",
                    backgroundColor = Color(0xFF2D3436),
                    onClick = { navController.navigate("math_topics") }
                )
            }

            item {
                SubjectItem(
                    category = "Science",
                    title = "Biology",
                    subtitle = "Explore the wonders of life",
                    backgroundColor = Color(0xFF00B894),
                    onClick = { navController.navigate("courses") }
                )
            }

            item {
                SubjectItem(
                    category = "History",
                    title = "World History",
                    subtitle = "Uncover the past's mysteries",
                    backgroundColor = Color(0xFF74B9FF),
                    onClick = { navController.navigate("courses") }
                )
            }

            item {
                SubjectItem(
                    category = "Literature",
                    title = "Classic Novels",
                    subtitle = "Dive into timeless stories",
                    backgroundColor = Color(0xFF2D3436),
                    onClick = { navController.navigate("courses") }
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        BottomNavigationBar(
            navController = navController,
            currentRoute = "subjects"
        )
    }
}

@Composable
fun SubjectItem(
    category: String,
    title: String,
    subtitle: String,
    backgroundColor: Color,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = category,
                fontSize = 14.sp,
                color = Color.Gray
            )
            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(vertical = 4.dp)
            )
            Text(
                text = subtitle,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Box(
            modifier = Modifier
                .size(80.dp, 60.dp)
                .background(backgroundColor, RoundedCornerShape(8.dp))
        )
    }
}