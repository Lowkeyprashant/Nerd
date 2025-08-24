package com.codewithprashant.nerd

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState // Added
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll // Added
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.luffy), // Assuming luffy.jpg is in res/drawable
                            contentDescription = "User Avatar",
                            contentScale = ContentScale.Crop, // Or ContentScale.Fit, depending on your image
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = "Home",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "Notifications",
                            tint = Color.Black
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                )
            )
        },
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                currentRoute = "home"
            )
        },
        containerColor = Color.White
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding) // Apply padding from Scaffold for system bars
                .padding(16.dp)        // Apply your original overall content padding
                .verticalScroll(rememberScrollState()) // Make content scrollable
        ) {
            // Spacer(modifier = Modifier.height(16.dp)) // This was after TopAppBar, might be adjusted by innerPadding

            Text(
                text = "Hello, Prashant",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Text(
                text = "Ready to learn something new today?",
                fontSize = 16.sp,
                color = Color.Gray,
                modifier = Modifier.padding(top = 4.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Recommended for you",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                RecommendedCard(
                    title = "Mastering the Art of Public Speaking",
                    subtitle = "Learn to captivate any audience with confidence.",
                    backgroundColor = Color(0xFF95C7A3),
                    modifier = Modifier.weight(1f),
                    onClick = { navController.navigate("lesson/Public Speaking") }
                )

                RecommendedCard(
                    title = "The Science of Happiness",
                    subtitle = "Explore the science of happiness and well-being.",
                    backgroundColor = Color(0xFFFDCB6E),
                    modifier = Modifier.weight(1f),
                    onClick = { navController.navigate("lesson/Science of Happiness") }
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Continue learning",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(16.dp))

            ContinueLearningItem(
                title = "Data Science...",
                subtitle = "Introduction to Data Science",
                progress = 0.6f,
                progressText = "60"
            )

            Spacer(modifier = Modifier.height(12.dp))

            ContinueLearningItem(
                title = "Spanish for...",
                subtitle = "Advanced Spanish",
                progress = 0.3f,
                progressText = "30"
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Recent activity",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(16.dp))

            RecentActivityItem(
                title = "Python Programming",
                subtitle = "Completed: Introduction to Python",
                timeText = "2d"
            )

            Spacer(modifier = Modifier.height(12.dp))

            RecentActivityItem(
                title = "Negotiation Skills",
                subtitle = "Completed: The Art of Negotiation",
                timeText = "5d"
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Upcoming lessons",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(16.dp))

            UpcomingLessonItem(
                title = "Photography Masterclass",
                subtitle = "Lesson 3: Advanced Techniques",
                timeText = "Tomorrow"
            )

            Spacer(modifier = Modifier.height(12.dp))

            UpcomingLessonItem(
                title = "Digital Marketing",
                subtitle = "Lesson 2: Intermediate Concepts",
                timeText = "2d"
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Daily streak",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(Color(0xFFF5F5F5), RoundedCornerShape(12.dp))
                    .padding(20.dp)
            ) {
                Column {
                    Text(
                        text = "Days",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                    Text(
                        text = "7",
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
            }
            // Spacer(modifier = Modifier.weight(1f)) // Removed, Scaffold handles bottom bar
        }
    }
}

@Composable
fun RecommendedCard(
    title: String,
    subtitle: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .height(180.dp)
            .background(backgroundColor, RoundedCornerShape(16.dp))
            .clickable { onClick() }
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
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
                color = Color.Black.copy(alpha = 0.7f)
            )
        }
    }
}

@Composable
fun ContinueLearningItem(
    title: String,
    subtitle: String,
    progress: Float,
    progressText: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(Color(0xFF2D3436), RoundedCornerShape(8.dp))
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
            Text(
                text = subtitle,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }

        Column(horizontalAlignment = Alignment.End) {
            Text(
                text = progressText,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(4.dp))

            LinearProgressIndicator(
                progress = progress,
                modifier = Modifier
                    .width(60.dp)
                    .height(4.dp),
                color = Color(0xFF00B894),
                trackColor = Color.Gray.copy(alpha = 0.3f)
            )
        }
    }
}

@Composable
fun RecentActivityItem(
    title: String,
    subtitle: String,
    timeText: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(Color.Black, RoundedCornerShape(8.dp))
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
            Text(
                text = subtitle,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }

        Text(
            text = timeText,
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun UpcomingLessonItem(
    title: String,
    subtitle: String,
    timeText: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(Color(0xFFFDCB6E), RoundedCornerShape(8.dp))
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
            Text(
                text = subtitle,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }

        Text(
            text = timeText,
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}
