package com.example.sudokuud

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.sudokuud.viewmodel.Board


class level2_Activity : ComponentActivity() {
    private lateinit var board: Board
    private lateinit var mediaPlayer: MediaPlayer
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.level2)

        board = Board(this)
        board.board()
        mediaPlayer = MediaPlayer.create(this, R.raw.sound_level2)

        val nuevo: Button = findViewById(R.id.nuevo)
        nuevo.setOnClickListener {
            board.board()
            mediaPlayer.start()
        }
        val timer= findViewById<TextView>(R.id.timer)
        nuevo.setOnClickListener { board.board() }

        val liveTimer = object : CountDownTimer(420000, 1000) {
            @SuppressLint("SetTextI18n")
            override fun onTick(millisUntilFinished: Long) {
                // Actualizar el TextView cada segundo
                timer.text = "Tiempo: ${millisUntilFinished / 1000}"
            }

            override fun onFinish() {
                // Mostrar el AlertDialog cuando el tiempo llegue a 0
                val builder = AlertDialog.Builder(this@level2_Activity)
                builder.setTitle("Tiempo agotado")
                builder.setMessage("El juego ha terminado, serás redirigido al menú principal.")
                builder.setPositiveButton("Aceptar") { _, _ ->

                    val intent= Intent(this@level2_Activity,Menu::class.java)
                    startActivity(intent)

                }
                builder.show()
            }
        }
        liveTimer.start()
    }
    override fun onPause() {
        super.onPause()
        mediaPlayer.pause()
    }

    override fun onResume() {
        super.onResume()
        mediaPlayer.start()
    }

    override fun onStop() {
        super.onStop()
        mediaPlayer.stop()
        mediaPlayer.release()
    }
}