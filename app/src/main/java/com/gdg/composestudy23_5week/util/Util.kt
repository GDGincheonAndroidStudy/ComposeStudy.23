package com.gdg.composestudy23_5week.util

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun showMessage(message:String){
    Toast.makeText(LocalContext.current, message, Toast.LENGTH_SHORT).show()
}
