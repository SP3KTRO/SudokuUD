package com.example.sudokuud

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.sudokuud.viewmodel.Board

class level1_Activity : ComponentActivity() {
    private lateinit var board: Board
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.level1)

        board = Board(this)
        board.board()

        val nuevo: Button = findViewById(R.id.nuevo)
    }
}