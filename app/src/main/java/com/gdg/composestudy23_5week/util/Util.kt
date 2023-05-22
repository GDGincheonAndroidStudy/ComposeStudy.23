package com.gdg.composestudy23_5week.util

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

fun showMessage(context: Context,message:String){
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}
