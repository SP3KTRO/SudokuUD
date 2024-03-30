package com.example.sudokuud

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import com.example.sudokuud.ui.theme.SudokuUDTheme
import com.example.sudokuud.viewmodel.Board
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : ComponentActivity() {
    private lateinit var board: Board
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        board = Board(this)
        board.board()

        val nuevo: Button = findViewById(R.id.nuevo)
        nuevo.setOnClickListener { board.board() }
    }


}