package com.example.sudokuud.viewmodel

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.sudokuud.Menu
import com.example.sudokuud.R

class level3_Activity : ComponentActivity() {
    private lateinit var board: Board
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.level2)

        board = Board(this)
        board.board()


    }
}