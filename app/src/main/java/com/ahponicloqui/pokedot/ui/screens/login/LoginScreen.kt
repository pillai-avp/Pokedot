package com.ahponicloqui.pokedot.ui.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahponicloqui.pokedot.R
import com.ahponicloqui.pokedot.ui.Destinations
import com.ahponicloqui.pokedot.ui.PokedotNavController
import com.ahponicloqui.pokedot.ui.rememberPokedotNavController

@Composable
fun LoginScreen(modifier: Modifier = Modifier, pokedotNavController: PokedotNavController) {
    Scaffold(modifier = modifier.fillMaxSize()) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues = paddingValues)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_launcher_foreground),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.height(24.dp))
                Button(onClick = {
                    pokedotNavController.navController.navigate(Destinations.PARENT_HOME_ROUTE)
                }) { Text(text = "Parent login") }

                Spacer(modifier = Modifier.height(24.dp))
                Button(onClick = {
                    pokedotNavController.navController.navigate(Destinations.CHILD_HOME_ROUTE)
                }) { Text(text = "Child login") }
            }
        }

    }
}

@Preview
@Composable
fun LoginScreenPreview(modifier: Modifier = Modifier) {
    LoginScreen(pokedotNavController = rememberPokedotNavController())
}