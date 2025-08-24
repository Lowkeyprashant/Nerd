package com.codewithprashant.nerd

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
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
fun CoursesScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TopAppBar(
            title = {
                Text(
                    text = "Study",
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

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Featured",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(horizontal = 16.dp)
                .background(Color(0xFFFDCB6E), RoundedCornerShape(12.dp))
                .clickable { }
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Premium",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                    Text(
                        text = "Unlock Full Access",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Text(
                        text = "Get unlimited access to all courses and exclusive content.",
                        fontSize = 12.sp,
                        color = Color.Black.copy(alpha = 0.7f)
                    )
                }

                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "Upgrade",
                        fontSize = 12.sp,
                        color = Color.White
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Courses",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                CourseCard(
                    title = "Math Fundamentals",
                    lessons = "12 Lessons",
                    duration = "2h 30m",
                    backgroundColor = Color(0xFFF5F5F5)
                )
            }

            item {
                CourseCard(
                    title = "Science Explorations",
                    lessons = "15 Lessons",
                    duration = "3h 15m",
                    backgroundColor = Color(0xFF74B9FF)
                )
            }

            item {
                CourseCard(
                    title = "Exam Prep: Algebra",
                    lessons = "10 Lessons",
                    duration = "2h 00m",
                    backgroundColor = Color(0xFFFDCB6E)
                )
            }

            item {
                CourseCard(
                    title = "History of the World",
                    lessons = "20 Lessons",
                    duration = "4h 00m",
                    backgroundColor = Color(0xFFF5F5F5)
                )
            }

            item {
                CourseCard(
                    title = "Advanced Calculus",
                    lessons = "18 Lessons",
                    duration = "3h 45m",
                    backgroundColor = Color(0xFF2D3436)
                )
            }

            item {
                CourseCard(
                    title = "Physics for Beginners",
                    lessons = "14 Lessons",
                    duration = "2h 45m",
                    backgroundColor = Color(0xFF74B9FF)
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        BottomNavigationBar(
            navController = navController,
            currentRoute = "courses"
        )
    }
}

@Composable
fun CourseCard(
    title: String,
    lessons: String,
    duration: String,
    backgroundColor: Color
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
            .background(backgroundColor, RoundedCornerShape(12.dp))
            .clickable { }
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.align(Alignment.BottomStart)
        ) {
            Text(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = if (backgroundColor == Color(0xFF2D3436)) Color.White else Color.Black
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "$lessons • $duration",
                fontSize = 12.sp,
                color = if (backgroundColor == Color(0xFF2D3436)) Color.White.copy(alpha = 0.7f) else Color.Gray
            )
        }
    }
}