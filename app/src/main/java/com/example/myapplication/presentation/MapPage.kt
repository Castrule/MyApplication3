package com.example.myapplication.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState


@Composable
@Preview(showBackground = true)
fun MapPage(navController: NavHostController = rememberNavController()){
    Scaffold(
        topBar = {
            TopBar()
        },
        bottomBar = {
            BottomBar(navController)
        }
    ) {
        MapPageBody(navController)
    }
}
@Composable
fun MapPageBody(navController: NavHostController){
    val singapore = LatLng(1.35, 103.87)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(singapore, 10f)
    }
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {
        Marker(
            position = singapore,
            title = "Singapore",
            snippet = "Marker in Singapore"
        )
    }
}