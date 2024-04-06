package com.example.sudokuud

import android.annotation.SuppressLint
import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.sudokuud.viewmodel.Board


class level1_Activity : ComponentActivity() {
    private lateinit var board: Board
    private lateinit var mediaPlayer: MediaPlayer

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.level1)

        // Inicializar el tablero y el objeto MediaPlayer
        board = Board(this@level1_Activity)
        board.board()
        mediaPlayer = MediaPlayer.create(this, R.raw.sound_level1)

        // Botón para iniciar una nueva actividad
        val nuevo: Button = findViewById(R.id.nuevo)
        nuevo.setOnClickListener {
            board.board()
            // Iniciar reproducción de audio
            mediaPlayer.start()
        }
    }

    override fun onPause() {
        super.onPause()
        // Pausar la reproducción del audio cuando la actividad está en pausa
        mediaPlayer.pause()
    }

    override fun onResume() {
        super.onResume()
        // Reanudar la reproducción del audio cuando la actividad se reanuda
        mediaPlayer.start()
    }

    override fun onStop() {
        super.onStop()
        // Detener la reproducción del audio cuando la actividad se detiene
        mediaPlayer.stop()
        mediaPlayer.release()
    }
}

