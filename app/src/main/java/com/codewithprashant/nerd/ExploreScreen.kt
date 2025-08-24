package com.codewithprashant.nerd

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
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
fun ExploreScreen(navController: NavController) {
    var selectedFilter by remember { mutableStateOf(0) }
    val filters = listOf("All", "Trending", "New", "Popular")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TopAppBar(
            title = {
                Text(
                    text = "Explore",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.fillMaxWidth()
                )
            },
            actions = {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Menu",
                        tint = Color.Black
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.White
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = "",
            onValueChange = { },
            placeholder = {
                Text(
                    text = "Search for courses",
                    color = Color.Gray
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = Color.Gray
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Gray.copy(alpha = 0.3f),
                unfocusedBorderColor = Color.Gray.copy(alpha = 0.3f),
                focusedContainerColor = Color.Gray.copy(alpha = 0.1f),
                unfocusedContainerColor = Color.Gray.copy(alpha = 0.1f)
            ),
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            filters.forEachIndexed { index, filter ->
                FilterChip(
                    onClick = { selectedFilter = index },
                    label = {
                        Text(
                            text = filter,
                            fontSize = 14.sp,
                            color = if (selectedFilter == index) Color.White else Color.Black
                        )
                    },
                    selected = selectedFilter == index,
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = Color.Black,
                        containerColor = Color.Gray.copy(alpha = 0.1f)
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Learning Paths",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            LearningPathCard(
                title = "Science",
                backgroundColor = Color(0xFF2D3436),
                modifier = Modifier.weight(1f),
                onClick = { navController.navigate("subjects") }
            )

            LearningPathCard(
                title = "Technology",
                backgroundColor = Color(0xFF74B9FF),
                modifier = Modifier.weight(1f),
                onClick = { navController.navigate("subjects") }
            )

            LearningPathCard(
                title = "Math",
                backgroundColor = Color(0xFF00B894),
                modifier = Modifier.weight(0.3f),
                onClick = { navController.navigate("subjects") }
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Featured Courses",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp)) 

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            FeaturedCourseCard(
                title = "Abstract Art",
                subtitle = "Learn abstract art techniques",
                backgroundColor = Color(0xFFFDCB6E),
                modifier = Modifier.weight(1f),
                onClick = { navController.navigate("courses") }
            )

            FeaturedCourseCard(
                title = "Coding Fundamentals",
                subtitle = "Introduction to coding",
                backgroundColor = Color(0xFF2D3436),
                modifier = Modifier.weight(1f),
                onClick = { navController.navigate("courses") }
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        BottomNavigationBar(
            navController = navController,
            currentRoute = "explore"
        )
    }
}

@Composable
fun LearningPathCard(
    title: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .height(120.dp)
            .background(backgroundColor, RoundedCornerShape(16.dp))
            .clickable { onClick() }
            .padding(16.dp)
    ) {
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(Alignment.BottomStart)
        )
    }
}

@Composable
fun FeaturedCourseCard(
    title: String,
    subtitle: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .height(160.dp)
            .background(backgroundColor, RoundedCornerShape(16.dp))
            .clickable { onClick() }
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.align(Alignment.BottomStart)
        ) {
            Text(
                text = title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = if (backgroundColor == Color(0xFF2D3436)) Color.White else Color.Black
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = subtitle,
                fontSize = 14.sp,
                color = if (backgroundColor == Color(0xFF2D3436)) Color.White.copy(alpha = 0.8f) else Color.Black.copy(alpha = 0.7f)
            )
        }
    }
}
