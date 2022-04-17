package com.annisa.guntingbatukertas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //kalau mencet salah satu button bakalan muncul di idplayer sesuai button yg dipencet, di idcomputer bakalan munculin image random

        val gunting: Button = findViewById(R.id.gunting)
        val batu: Button = findViewById(R.id.batu)
        val kertas: Button = findViewById(R.id.kertas)
        val player: ImageView = findViewById(R.id.player)

        gunting.setOnClickListener {
            player.setImageResource(R.drawable.gunting)
            val pilihanComputer = computerChoose()
            check(0, pilihanComputer)
        }

        batu.setOnClickListener {
            player.setImageResource(R.drawable.batu)
            val pilihanComputer = computerChoose()
            check(1, pilihanComputer)
        }
        kertas.setOnClickListener {
            player.setImageResource(R.drawable.kertas)
            val pilihanComputer = computerChoose()
            check(2, pilihanComputer)
        }

    }

    fun computerChoose(): Int {
        val computer: ImageView = findViewById(R.id.computer)
        var random = (0..2).random()
        if (random == 0) {
            computer.setImageResource(R.drawable.gunting)
        } else if (random == 1) {
            computer.setImageResource(R.drawable.batu)
        } else {
            computer.setImageResource(R.drawable.kertas)
        }
        return random
    }

    fun check(pilihPlayer: Int, pilihComputer: Int) {
        var hasil: String = ""
        if (pilihPlayer == pilihComputer) {
            hasil = "Kalian Seri"
        } else if (pilihPlayer == 0 && pilihComputer == 1) {
            hasil = "Computer Menang"
        } else if (pilihPlayer == 0 && pilihComputer == 2) {
            hasil = "Player Menang"
        } else if (pilihPlayer == 1 && pilihComputer == 0) {
            hasil = "Player Menang"
        } else if (pilihPlayer == 1 && pilihComputer == 2) {
            hasil = "Computer Menang"
        } else if (pilihPlayer == 2 && pilihComputer == 0) {
            hasil = "Computer Menang"
        } else if (pilihPlayer == 2 && pilihComputer == 1) {
            hasil = "Player Menang"
        }


        Toast.makeText(applicationContext, "${hasil}", Toast.LENGTH_SHORT).show()

    }
}