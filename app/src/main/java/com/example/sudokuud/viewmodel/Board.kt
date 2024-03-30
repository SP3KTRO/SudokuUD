package com.example.sudokuud.viewmodel

import android.widget.Button
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.sudokuud.MainActivity
import com.example.sudokuud.R
import kotlin.random.Random
import kotlin.random.nextInt


class Board(private val activity: MainActivity) {
    fun board() {
        val d = Random.nextInt(1..9)
        val e = Random.nextInt(1..9)
        val f = Random.nextInt(1..9)
        val i = Random.nextInt(1..9)
        val j = Random.nextInt(1..9)
        val k = Random.nextInt(1..9)
        val l = Random.nextInt(1..9)
        val m = Random.nextInt(1..9)
        val n = Random.nextInt(1..9)

        //botones del xml
        var botones = Array(81) { index ->
            val buttonId = activity.resources.getIdentifier("b${index + 1}", "id", activity.packageName)
            activity.findViewById<Button>(buttonId)
        }
        val uno: Button = activity.findViewById(R.id.uno);val dos: Button = activity.findViewById(R.id.dos);val tres: Button = activity.findViewById(
            R.id.tres);val cuatro: Button = activity.findViewById(R.id.cuatro)
        val cinco: Button = activity.findViewById(R.id.cinco);val seis: Button = activity.findViewById(R.id.seis);val siete: Button = activity.findViewById(
            R.id.siete);val ocho: Button = activity.findViewById(R.id.ocho);val nueve: Button = activity.findViewById(
            R.id.nueve)
        val borrar: Button = activity.findViewById(R.id.borrar); val pista: Button = activity.findViewById(R.id.pista); val fin: Button = activity.findViewById(
            R.id.fin)
        val defaultButton: Button = activity.findViewById(R.id.defaultButton)


        val buttonUsed = arrayListOf<Button>(defaultButton)
        val buttonUse = arrayListOf<Button>(defaultButton)
        val hi = arrayListOf<Button>(botones[0],botones[1],botones[2],botones[3],botones[4],botones[5],botones[6],botones[7],botones[8],
            botones[18],botones[19],botones[20],botones[21],botones[22],botones[23],botones[24],botones[25],botones[26],
            botones[36],botones[37],botones[38],botones[39],botones[40],botones[41],botones[42],botones[43],botones[44],
            botones[54],botones[55],botones[56],botones[57],botones[58],botones[59],botones[60],botones[61],botones[62],
            botones[72],botones[73],botones[74],botones[75],botones[76],botones[77],botones[78],botones[79],botones[80])
        var start = 0
        val buttonColor = arrayListOf<Int>()

        var trys = 0
        var a = 0

        //funcion para generar las pistas y la seleccion de cuadros del tablero
        fun keys(buSelected: Button){
            var trats = 0
            var buttonColorSize = buttonColor.size.toInt()

            buSelected.setOnClickListener {
                if (hi.contains(buSelected)){
                    buttonUse.add(buSelected);buttonUse[0].setBackgroundResource(R.drawable.borde_negro);buttonUse.remove(buttonUse[0])
                    buttonUsed[0].setBackgroundResource(R.drawable.borde_azul)
                }
                else{
                    buttonUsed.add(buSelected);buttonUsed[0].setBackgroundResource(R.drawable.borde_azul);buttonUsed.remove(buttonUsed[0])
                    buttonUse[0].setBackgroundResource(R.drawable.borde_negro)
                }
                buSelected.setTextColor(activity.resources.getColor(R.color.black))
                buSelected.setBackgroundColor(ContextCompat.getColor(activity, R.color.green))

                uno.setOnClickListener { buSelected.text="1";start=0;buSelected.setBackgroundColor(
                    ContextCompat.getColor(activity, R.color.green));start=0;buttonColorSize = buttonColor.size.toInt();trats=0 }
                dos.setOnClickListener { buSelected.text="2";start=0;buSelected.setBackgroundColor(
                    ContextCompat.getColor(activity, R.color.green));start=0;buttonColorSize = buttonColor.size.toInt();trats=0 }
                tres.setOnClickListener { buSelected.text="3";start=0;buSelected.setBackgroundColor(
                    ContextCompat.getColor(activity, R.color.green));start=0;buttonColorSize = buttonColor.size.toInt();trats=0 }
                cuatro.setOnClickListener { buSelected.text="4";start=0;buSelected.setBackgroundColor(
                    ContextCompat.getColor(activity, R.color.green));start=0;buttonColorSize = buttonColor.size.toInt();trats=0 }
                cinco.setOnClickListener { buSelected.text="5";start=0;buSelected.setBackgroundColor(
                    ContextCompat.getColor(activity, R.color.green));start=0;buttonColorSize = buttonColor.size.toInt();trats=0 }
                seis.setOnClickListener { buSelected.text="6";start=0;buSelected.setBackgroundColor(
                    ContextCompat.getColor(activity, R.color.green));start=0;buttonColorSize = buttonColor.size.toInt();trats=0 }
                siete.setOnClickListener { buSelected.text="7";start=0;buSelected.setBackgroundColor(
                    ContextCompat.getColor(activity, R.color.green));start=0;buttonColorSize = buttonColor.size.toInt();trats=0 }
                ocho.setOnClickListener { buSelected.text="8";start=0;buSelected.setBackgroundColor(
                    ContextCompat.getColor(activity, R.color.green));start=0;buttonColorSize = buttonColor.size.toInt();trats=0 }
                nueve.setOnClickListener { buSelected.text="9";start=0;buSelected.setBackgroundColor(
                    ContextCompat.getColor(activity, R.color.green));start=0;buttonColorSize = buttonColor.size.toInt();trats=0 }
                borrar.setOnClickListener { buSelected.text=" " }
                pista.setOnClickListener {
                    trys ++
                    val abc = 5 -trys
                    if (trys <= 5){
                        pista.text = "x$abc"

                        when(buSelected){
                            //bloque 1
                            botones[0] -> {botones[0].text = "$d"}; botones[1] -> { botones[1].text = "$f" }; botones[2] -> { botones[2].text = "$k" }; botones[3] -> { botones[3].text = "$e" }
                            botones[4] -> { botones[4].text = "$n" }; botones[5] -> { botones[5].text = "$l" }; botones[6] -> { botones[6].text = "$m" };botones[7] -> { botones[7].text = "$i" }
                            botones[8] -> { botones[8].text = "$j" }
                            //bloque 2
                            botones[9] -> { botones[9].text = "$i" }; botones[10] -> { botones[10].text = "$l" }; botones[11] -> { botones[11].text = "$m" }; botones[12] -> { botones[12].text = "$d" }
                            botones[13] -> { botones[13].text = "$k" }; botones[14] -> { botones[14].text = "$j" }; botones[15] -> { botones[15].text = "$f" }; botones[16] -> { botones[16].text = "$n" }
                            botones[17] ->  { botones[17].text = "$e" }
                            //bloque 3
                            botones[18] -> { botones[18].text = "$j" }; botones[19] -> { botones[19].text = "$e" }; botones[20] -> { botones[20].text = "$n" }; botones[21] -> { botones[21].text = "$i" }
                            botones[22] -> { botones[22].text = "$m" }; botones[23] -> { botones[23].text = "$f" }; botones[24] -> { botones[24].text = "$k" }; botones[25] -> { botones[25].text = "$d" }
                            botones[26] -> { botones[26].text = "$l" }
                            //bloque 4
                            botones[27] -> { botones[27].text = "$k" }; botones[28] -> { botones[28].text = "$m" }; botones[29] -> { botones[29].text = "$f" }; botones[30] -> { botones[30].text = "$i" }
                            botones[31] -> { botones[31].text = "$j" }; botones[32] -> { botones[32].text = "$n" }; botones[33] -> { botones[33].text = "$l" }; botones[34] -> { botones[34].text = "$e" }
                            botones[35] -> { botones[35].text = "$d" }
                            //bloque 5
                            botones[36] -> { botones[36].text = "$l" }; botones[37] -> { botones[37].text = "$e" }; botones[38] -> { botones[38].text = "$n" }; botones[39] -> { botones[39].text = "$k" }
                            botones[40] -> { botones[40].text = "$d" }; botones[41] -> { botones[41].text = "$f" }; botones[42] -> { botones[42].text = "$m" }; botones[43] -> { botones[43].text = "$j" }
                            botones[44] -> { botones[44].text = "$i" };
                            //bloque 6
                            botones[45] -> { botones[45].text = "$d" }; botones[46] -> { botones[46].text = "$i" }; botones[47] -> { botones[47].text = "$j" }; botones[48] -> { botones[48].text = "$e" }
                            botones[49] -> { botones[49].text = "$l" }; botones[50] ->  { botones[50].text = "$m" }; botones[51] -> { botones[51].text = "$f" }; botones[52] ->  { botones[52].text = "$n" }
                            botones[53] ->  { botones[53].text = "$k" }
                            //bloque 7
                            botones[54] -> { botones[54].text = "$j" }; botones[55] -> { botones[55].text = "$d" }; botones[56] ->  { botones[56].text = "$i" }; botones[57] ->  { botones[57].text = "$f" }
                            botones[58] ->  { botones[58].text = "$l" }; botones[59] ->  { botones[59].text = "$m" }; botones[60] -> { botones[60].text = "$n" }; botones[61] -> { botones[61].text = "$k" }
                            botones[62] ->  { botones[62].text = "$e" }
                            //bloque 8
                            botones[63] -> { botones[63].text = "$n" }; botones[64] -> { botones[64].text = "$f" }; botones[65] -> { botones[65].text = "$l" }; botones[66] -> { botones[66].text = "$e" }
                            botones[67] -> { botones[67].text = "$i" }; botones[68] -> { botones[68].text = "$k" }; botones[69] -> { botones[69].text = "$j" }; botones[70] -> { botones[70].text = "$m" }
                            botones[71] -> { botones[71].text = "$d" }
                            //bloque 9
                            botones[72] ->  { botones[72].text = "$m" }; botones[73] ->  { botones[73].text = "$k" }; botones[74] ->  { botones[74].text = "$e" }; botones[75] ->  { botones[75].text = "$n" }
                            botones[76] ->  { botones[76].text = "$j" }; botones[77] ->  { botones[77].text = "$d" }; botones[78] ->  { botones[78].text = "$l" }; botones[79] ->  { botones[79].text = "$f" }
                            botones[80] ->  { botones[80].text = "$i" }
                        }
                    }else{
                        Toast.makeText(activity, "No tienes mas ayudas", Toast.LENGTH_SHORT).show()}
                }

            }
        }

        //funcion para verificar las posiciones correctas o erroneas
        fun check() {
            fin.setOnClickListener {
                //bloque 1
                if (botones[0].text != "$d") {
                    botones[0].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[1].text != "$f") {
                    botones[1].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[2].text != "$k") {
                    botones[2].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[3].text != "$e") {
                    botones[3].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[4].text != "$n") {
                    botones[4].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[5].text != "$l") {
                    botones[5].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[6].text != "$m") {
                    botones[6].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[7].text != "$i") {
                    botones[7].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[8].text != "$j") {
                    botones[8].setBackgroundResource(R.drawable.borde_rojo)
                }
                //bloque 2
                if (botones[9].text != "$i") {
                    botones[9].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[10].text != "$l") {
                    botones[10].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[11].text != "$m") {
                    botones[11].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[12].text != "$d") {
                    botones[12].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[13].text != "$k") {
                    botones[13].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[14].text != "$j") {
                    botones[14].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[15].text != "$f") {
                    botones[15].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[16].text != "$n") {
                    botones[16].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[17].text != "$e") {
                    botones[17].setBackgroundResource(R.drawable.borde_rojo)
                }
                //bloque 3
                if (botones[18].text != "$j") {
                    botones[18].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[19].text != "$e") {
                    botones[19].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[20].text != "$n") {
                    botones[20].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[21].text != "$i") {
                    botones[21].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[22].text != "$m") {
                    botones[22].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[23].text != "$f") {
                    botones[23].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[24].text != "$k") {
                    botones[24].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[25].text != "$d") {
                    botones[25].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[26].text != "$l") {
                    botones[26].setBackgroundResource(R.drawable.borde_rojo)
                }
                //bloque 4
                if (botones[27].text != "$k") {
                    botones[27].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[28].text != "$m") {
                    botones[28].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[29].text != "$f") {
                    botones[29].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[30].text != "$i") {
                    botones[30].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[31].text != "$j") {
                    botones[31].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[32].text != "$n") {
                    botones[32].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[33].text != "$l") {
                    botones[33].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[34].text != "$e") {
                    botones[34].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[35].text != "$d") {
                    botones[35].setBackgroundResource(R.drawable.borde_rojo)
                }
                //bloque 5
                if (botones[36].text != "$l") {
                    botones[36].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[37].text != "$e") {
                    botones[37].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[38].text != "$n") {
                    botones[38].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[39].text != "$k") {
                    botones[39].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[40].text != "$d") {
                    botones[40].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[41].text != "$f") {
                    botones[41].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[42].text != "$m") {
                    botones[42].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[43].text != "$j") {
                    botones[43].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[44].text != "$i") {
                    botones[44].setBackgroundResource(R.drawable.borde_rojo)
                }
                //bloque 6
                if (botones[45].text != "$d") {
                    botones[45].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[46].text != "$i") {
                    botones[46].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[47].text != "$j") {
                    botones[47].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[48].text != "$e") {
                    botones[48].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[49].text != "$l") {
                    botones[49].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[50].text != "$m") {
                    botones[50].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[51].text != "$f") {
                    botones[51].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[52].text != "$n") {
                    botones[52].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[53].text != "$k") {
                    botones[53].setBackgroundResource(R.drawable.borde_rojo)
                }
                //bloque 7
                if (botones[54].text != "$j") {
                    botones[54].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[55].text != "$d") {
                    botones[55].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[56].text != "$i") {
                    botones[56].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[57].text != "$f") {
                    botones[57].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[58].text != "$l") {
                    botones[58].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[59].text != "$m") {
                    botones[59].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[60].text != "$n") {
                    botones[60].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[61].text != "$k") {
                    botones[61].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[62].text != "$e") {
                    botones[62].setBackgroundResource(R.drawable.borde_rojo)
                }
                //bloque 8
                if (botones[63].text != "$n") {
                    botones[63].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[64].text != "$f") {
                    botones[64].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[65].text != "$l") {
                    botones[65].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[66].text != "$e") {
                    botones[66].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[67].text != "$i") {
                    botones[67].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[68].text != "$k") {
                    botones[68].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[69].text != "$j") {
                    botones[69].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[70].text != "$m") {
                    botones[70].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[71].text != "$d") {
                    botones[71].setBackgroundResource(R.drawable.borde_rojo)
                }
                //bloque 9
                if (botones[72].text != "$m") {
                    botones[72].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[73].text != "$k") {
                    botones[73].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[74].text != "$e") {
                    botones[74].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[75].text != "$n") {
                    botones[75].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[76].text != "$j") {
                    botones[76].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[77].text != "$d") {
                    botones[77].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[78].text != "$l") {
                    botones[78].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[79].text != "$f") {
                    botones[79].setBackgroundResource(R.drawable.borde_rojo)
                }
                if (botones[80].text != "$i") {
                    botones[80].setBackgroundResource(R.drawable.borde_rojo)
                }

                if ((botones[0].text == "$d") && (botones[1].text == "$f") && (botones[2].text == "$k") && (botones[3].text == "$e") && (botones[4].text == "$n")
                    && (botones[5].text == "$l") && (botones[6].text == "$m") && (botones[7].text == "$i") && (botones[8].text == "$j") && (botones[9].text == "$i")
                    && (botones[10].text == "$l") && (botones[11].text == "$m") && (botones[12].text == "$d") && (botones[13].text == "$k") && (botones[14].text == "$j")
                    && (botones[15].text == "$f") && (botones[16].text == "$n") && (botones[17].text == "$e") && (botones[18].text == "$j") && (botones[19].text == "$e")
                    && (botones[20].text == "$n") && (botones[21].text == "$i") && (botones[22].text == "$m") && (botones[23].text == "$f") && (botones[24].text == "$k")
                    && (botones[25].text == "$d") && (botones[26].text == "$l") && (botones[27].text == "$k") && (botones[28].text == "$m") && (botones[29].text == "$f")
                    && (botones[30].text == "$i") && (botones[31].text == "$j") && (botones[32].text == "$n") && (botones[33].text == "$l") && (botones[34].text == "$e")
                    && (botones[35].text == "$d") && (botones[36].text == "$l") && (botones[37].text == "$e") && (botones[38].text == "$n") && (botones[39].text == "$k")
                    && (botones[40].text == "$d") && (botones[41].text == "$f") && (botones[42].text == "$m") && (botones[43].text == "$j") && (botones[44].text == "$i")
                    && (botones[45].text == "$d") && (botones[46].text == "$i") && (botones[47].text == "$j") && (botones[48].text == "$e") && (botones[49].text == "$l")
                    && (botones[50].text == "$m") && (botones[51].text == "$f") && (botones[52].text == "$n") && (botones[53].text == "$k") && (botones[54].text == "$j")
                    && (botones[55].text == "$d") && (botones[56].text == "$i") && (botones[57].text == "$f") && (botones[58].text == "$l") && (botones[59].text == "$m")
                    && (botones[60].text == "$n") && (botones[61].text == "$k") && (botones[62].text == "$e") && (botones[63].text == "$n") && (botones[64].text == "$f")
                    && (botones[65].text == "$l") && (botones[66].text == "$e") && (botones[67].text == "$i") && (botones[68].text == "$k") && (botones[69].text == "$j")
                    && (botones[70].text == "$m") && (botones[71].text == "$d") && (botones[72].text == "$m") && (botones[73].text == "$k") && (botones[74].text == "$e")
                    && (botones[75].text == "$n") && (botones[76].text == "$j") && (botones[77].text == "$d") && (botones[78].text == "$l") && (botones[79].text == "$f")
                    && (botones[80].text == "$i")
                ) {
                    Toast.makeText(activity, "☺ Ganaste ☺", Toast.LENGTH_SHORT).show()
                }
            }
        }

        check()
        //configurando los botones del tablero 9x9
        if (d != e && d != f && f != e) {
            if (i != j && i != k && k != j && d != i && d != j && d != k && e != i && e != j && e != k && f != i && f != j && f != k) {
                if (l != m && l != n && n != m && d != l && d != m && d != n && e != l && e != m && e != n && f != l && f != m && f != n && i != l && i != m && i != n && j != l && j != m && j != n && k != l && k != m && k != n) {
                    //bloque 1
                    botones[0].text = "$d";botones[0].setBackgroundResource(R.drawable.borde_negro);botones[0].setOnClickListener { botones[0].text = "$d" }
                    botones[1].text = "$f";botones[1].setBackgroundResource(R.drawable.borde_negro);botones[1].setOnClickListener { botones[1].text = "$f" }
                    botones[2].text = "$k";botones[2].setBackgroundResource(R.drawable.borde_negro);botones[2].setOnClickListener { botones[2].text = "$k" }
                    botones[3].text = "$e";botones[3].setBackgroundResource(R.drawable.borde_negro);botones[3].setOnClickListener { botones[3].text = "$e" }
                    botones[4].text = "$n";botones[4].setBackgroundResource(R.drawable.borde_negro);botones[4].setOnClickListener { botones[4].text = "$n" }
                    botones[5].text = "$l";botones[5].setBackgroundResource(R.drawable.borde_negro);botones[5].setOnClickListener { botones[5].text = "$l" }
                    botones[6].text = "$m";botones[6].setBackgroundResource(R.drawable.borde_negro);botones[6].setOnClickListener { botones[6].text = "$m" }
                    botones[7].text = "$i";botones[7].setBackgroundResource(R.drawable.borde_negro);botones[7].setOnClickListener { botones[7].text = "$i" }
                    botones[8].text = "$j";botones[8].setBackgroundResource(R.drawable.borde_negro);botones[8].setOnClickListener { botones[8].text = "$j" }
                    //bloque 2
                    botones[9].text = "$i";botones[9].setBackgroundResource(R.drawable.borde_azul);botones[9].setOnClickListener { botones[9].text = "$i" }
                    botones[10].text = "$l";botones[10].setBackgroundResource(R.drawable.borde_azul);botones[10].setOnClickListener { botones[10].text = "$l" }
                    botones[11].text = "$m";botones[11].setBackgroundResource(R.drawable.borde_azul);botones[11].setOnClickListener { botones[11].text = "$m" }
                    botones[12].text = "$d";botones[12].setBackgroundResource(R.drawable.borde_azul);botones[12].setOnClickListener { botones[12].text = "$d" }
                    botones[13].text = "$k";botones[13].setBackgroundResource(R.drawable.borde_azul);botones[13].setOnClickListener { botones[13].text = "$k" }
                    botones[14].text = "$j";botones[14].setBackgroundResource(R.drawable.borde_azul);botones[14].setOnClickListener { botones[14].text = "$j" }
                    botones[15].text = "$f";botones[15].setBackgroundResource(R.drawable.borde_azul);botones[15].setOnClickListener { botones[15].text = "$f" }
                    botones[16].text = "$n";botones[16].setBackgroundResource(R.drawable.borde_azul);botones[16].setOnClickListener { botones[16].text = "$n" }
                    botones[17].text = "$e";botones[17].setBackgroundResource(R.drawable.borde_azul);botones[17].setOnClickListener { botones[17].text = "$e" }
                    //bloque 3
                    botones[18].text = "$j";botones[18].setBackgroundResource(R.drawable.borde_negro);botones[18].setOnClickListener { botones[18].text = "$j" }
                    botones[19].text = "$e";botones[19].setBackgroundResource(R.drawable.borde_negro);botones[19].setOnClickListener { botones[19].text = "$e" }
                    botones[20].text = "$n";botones[20].setBackgroundResource(R.drawable.borde_negro);botones[20].setOnClickListener { botones[20].text = "$n" }
                    botones[21].text = "$i";botones[21].setBackgroundResource(R.drawable.borde_negro);botones[21].setOnClickListener { botones[21].text = "$i" }
                    botones[22].text = "$m";botones[22].setBackgroundResource(R.drawable.borde_negro);botones[22].setOnClickListener { botones[22].text = "$m" }
                    botones[23].text = "$f";botones[23].setBackgroundResource(R.drawable.borde_negro);botones[23].setOnClickListener { botones[23].text = "$f" }
                    botones[24].text = "$k";botones[24].setBackgroundResource(R.drawable.borde_negro);botones[24].setOnClickListener { botones[24].text = "$k" }
                    botones[25].text = "$d";botones[25].setBackgroundResource(R.drawable.borde_negro);botones[25].setOnClickListener { botones[25].text = "$d" }
                    botones[26].text = "$l";botones[26].setBackgroundResource(R.drawable.borde_negro);botones[26].setOnClickListener { botones[26].text = "$l" }
                    //bloque 4
                    botones[27].text = "$k";botones[27].setBackgroundResource(R.drawable.borde_azul);botones[27].setOnClickListener { botones[27].text = "$k" }
                    botones[28].text = "$m";botones[28].setBackgroundResource(R.drawable.borde_azul);botones[28].setOnClickListener { botones[28].text = "$m" }
                    botones[29].text = "$f";botones[29].setBackgroundResource(R.drawable.borde_azul);botones[29].setOnClickListener { botones[29].text = "$f" }
                    botones[30].text = "$i";botones[30].setBackgroundResource(R.drawable.borde_azul);botones[30].setOnClickListener { botones[30].text = "$i" }
                    botones[31].text = "$j";botones[31].setBackgroundResource(R.drawable.borde_azul);botones[31].setOnClickListener { botones[31].text = "$j" }
                    botones[32].text = "$n";botones[32].setBackgroundResource(R.drawable.borde_azul);botones[32].setOnClickListener { botones[32].text = "$n" }
                    botones[33].text = "$l";botones[33].setBackgroundResource(R.drawable.borde_azul);botones[33].setOnClickListener { botones[33].text = "$l" }
                    botones[34].text = "$e";botones[34].setBackgroundResource(R.drawable.borde_azul);botones[34].setOnClickListener { botones[34].text = "$e" }
                    botones[35].text = "$d";botones[35].setBackgroundResource(R.drawable.borde_azul);botones[35].setOnClickListener { botones[35].text = "$d" }
                    //bloque 5
                    botones[36].text = "$l";botones[36].setBackgroundResource(R.drawable.borde_negro);botones[36].setOnClickListener { botones[36].text = "$l" }
                    botones[37].text = "$e";botones[37].setBackgroundResource(R.drawable.borde_negro);botones[37].setOnClickListener { botones[37].text = "$e" }
                    botones[38].text = "$n";botones[38].setBackgroundResource(R.drawable.borde_negro);botones[38].setOnClickListener { botones[38].text = "$n" }
                    botones[39].text = "$k";botones[39].setBackgroundResource(R.drawable.borde_negro);botones[39].setOnClickListener { botones[39].text = "$k" }
                    botones[40].text = "$d";botones[40].setBackgroundResource(R.drawable.borde_negro);botones[40].setOnClickListener { botones[40].text = "$d" }
                    botones[41].text = "$f";botones[41].setBackgroundResource(R.drawable.borde_negro);botones[41].setOnClickListener { botones[41].text = "$f" }
                    botones[42].text = "$m";botones[42].setBackgroundResource(R.drawable.borde_negro);botones[42].setOnClickListener { botones[42].text = "$m" }
                    botones[43].text = "$j";botones[43].setBackgroundResource(R.drawable.borde_negro);botones[43].setOnClickListener { botones[43].text = "$j" }
                    botones[44].text = "$i";botones[44].setBackgroundResource(R.drawable.borde_negro);botones[44].setOnClickListener { botones[44].text = "$i" }
                    //bloque 6
                    botones[45].text = "$d";botones[45].setBackgroundResource(R.drawable.borde_azul);botones[45].setOnClickListener { botones[45].text = "$d" }
                    botones[46].text = "$i";botones[46].setBackgroundResource(R.drawable.borde_azul);botones[46].setOnClickListener { botones[46].text = "$i" }
                    botones[47].text = "$j";botones[47].setBackgroundResource(R.drawable.borde_azul);botones[47].setOnClickListener { botones[47].text = "$j" }
                    botones[48].text = "$e";botones[48].setBackgroundResource(R.drawable.borde_azul);botones[48].setOnClickListener { botones[48].text = "$e" }
                    botones[49].text = "$l";botones[49].setBackgroundResource(R.drawable.borde_azul);botones[49].setOnClickListener { botones[49].text = "$l" }
                    botones[50].text = "$m";botones[50].setBackgroundResource(R.drawable.borde_azul);botones[50].setOnClickListener { botones[50].text = "$m" }
                    botones[51].text = "$f";botones[51].setBackgroundResource(R.drawable.borde_azul);botones[51].setOnClickListener { botones[51].text = "$f" }
                    botones[52].text = "$n";botones[52].setBackgroundResource(R.drawable.borde_azul);botones[52].setOnClickListener { botones[52].text = "$n" }
                    botones[53].text = "$k";botones[53].setBackgroundResource(R.drawable.borde_azul);botones[53].setOnClickListener { botones[53].text = "$k" }
                    //bloque 7
                    botones[54].text = "$j";botones[54].setBackgroundResource(R.drawable.borde_negro);botones[54].setOnClickListener { botones[54].text = "$j" }
                    botones[55].text = "$d";botones[55].setBackgroundResource(R.drawable.borde_negro);botones[55].setOnClickListener { botones[55].text = "$d" }
                    botones[56].text = "$i";botones[56].setBackgroundResource(R.drawable.borde_negro);botones[56].setOnClickListener { botones[56].text = "$i" }
                    botones[57].text = "$f";botones[57].setBackgroundResource(R.drawable.borde_negro);botones[57].setOnClickListener { botones[57].text = "$f" }
                    botones[58].text = "$l";botones[58].setBackgroundResource(R.drawable.borde_negro);botones[58].setOnClickListener { botones[58].text = "$l" }
                    botones[59].text = "$m";botones[59].setBackgroundResource(R.drawable.borde_negro);botones[59].setOnClickListener { botones[59].text = "$m" }
                    botones[60].text = "$n";botones[60].setBackgroundResource(R.drawable.borde_negro);botones[60].setOnClickListener { botones[60].text = "$n" }
                    botones[61].text = "$k";botones[61].setBackgroundResource(R.drawable.borde_negro);botones[61].setOnClickListener { botones[61].text = "$k" }
                    botones[62].text = "$e";botones[62].setBackgroundResource(R.drawable.borde_negro);botones[62].setOnClickListener { botones[62].text = "$e" }
                    //bloque 8
                    botones[63].text = "$n";botones[63].setBackgroundResource(R.drawable.borde_azul);botones[63].setOnClickListener { botones[63].text = "$n" }
                    botones[64].text = "$f";botones[64].setBackgroundResource(R.drawable.borde_azul);botones[64].setOnClickListener { botones[64].text = "$f" }
                    botones[65].text = "$l";botones[65].setBackgroundResource(R.drawable.borde_azul);botones[65].setOnClickListener { botones[65].text = "$l" }
                    botones[66].text = "$e";botones[66].setBackgroundResource(R.drawable.borde_azul);botones[66].setOnClickListener { botones[66].text = "$e" }
                    botones[67].text = "$i";botones[67].setBackgroundResource(R.drawable.borde_azul);botones[67].setOnClickListener { botones[67].text = "$i" }
                    botones[68].text = "$k";botones[68].setBackgroundResource(R.drawable.borde_azul);botones[68].setOnClickListener { botones[68].text = "$k" }
                    botones[69].text = "$j";botones[69].setBackgroundResource(R.drawable.borde_azul);botones[69].setOnClickListener { botones[69].text = "$j" }
                    botones[70].text = "$m";botones[70].setBackgroundResource(R.drawable.borde_azul);botones[70].setOnClickListener { botones[70].text = "$m" }
                    botones[71].text = "$d";botones[71].setBackgroundResource(R.drawable.borde_azul);botones[71].setOnClickListener { botones[71].text = "$d" }
                    //bloque 9
                    botones[72].text = "$m";botones[72].setBackgroundResource(R.drawable.borde_negro);botones[72].setOnClickListener { botones[72].text = "$m" }
                    botones[73].text = "$k";botones[73].setBackgroundResource(R.drawable.borde_negro);botones[73].setOnClickListener { botones[73].text = "$k" }
                    botones[74].text = "$e";botones[74].setBackgroundResource(R.drawable.borde_negro);botones[74].setOnClickListener { botones[74].text = "$e" }
                    botones[75].text = "$n";botones[75].setBackgroundResource(R.drawable.borde_negro);botones[75].setOnClickListener { botones[75].text = "$n" }
                    botones[76].text = "$j";botones[76].setBackgroundResource(R.drawable.borde_negro);botones[76].setOnClickListener { botones[76].text = "$j" }
                    botones[77].text = "$d";botones[77].setBackgroundResource(R.drawable.borde_negro);botones[77].setOnClickListener { botones[77].text = "$d" }
                    botones[78].text = "$l";botones[78].setBackgroundResource(R.drawable.borde_negro);botones[78].setOnClickListener { botones[78].text = "$l" }
                    botones[79].text = "$f";botones[79].setBackgroundResource(R.drawable.borde_negro);botones[79].setOnClickListener { botones[79].text = "$f" }
                    botones[80].text = "$i";botones[80].setBackgroundResource(R.drawable.borde_negro);botones[80].setOnClickListener { botones[80].text = "$i" }

                    //configurando celdas en blanco
                    val random = Random.nextInt(50..53)
                    var a = 0
                    while (a <= random){
                        val r = Random.nextInt(1..81)
                        when(r){
                            1 -> {botones[0].text = "";keys(buSelected = botones[0]);botones[0].setBackgroundResource(
                                R.drawable.borde_negro)}
                            2 -> {botones[1].text = "";keys(buSelected = botones[1]);botones[1].setBackgroundResource(
                                R.drawable.borde_negro)}
                            3 -> {botones[2].text = "";keys(buSelected = botones[2]);botones[2].setBackgroundResource(
                                R.drawable.borde_negro)}
                            4 -> {botones[3].text = "";keys(buSelected = botones[3]);botones[3].setBackgroundResource(
                                R.drawable.borde_negro)}
                            5 -> {botones[4].text = "";keys(buSelected = botones[4]);botones[4].setBackgroundResource(
                                R.drawable.borde_negro)}
                            6 -> {botones[5].text = "";keys(buSelected = botones[5]);botones[5].setBackgroundResource(
                                R.drawable.borde_negro)}
                            7 -> {botones[6].text = "";keys(buSelected = botones[6]);botones[6].setBackgroundResource(
                                R.drawable.borde_negro)}
                            8 -> {botones[7].text = "";keys(buSelected = botones[7]);botones[7].setBackgroundResource(
                                R.drawable.borde_negro)}
                            9 -> {botones[8].text = "";keys(buSelected = botones[8]);botones[8].setBackgroundResource(
                                R.drawable.borde_negro)}

                            10 -> {botones[9].text = "";keys(buSelected = botones[9]);botones[9].setBackgroundResource(
                                R.drawable.borde_azul)}
                            11 -> {botones[10].text = "";keys(buSelected = botones[10]);botones[10].setBackgroundResource(
                                R.drawable.borde_azul)}
                            12 -> {botones[11].text = "";keys(buSelected = botones[11]);botones[11].setBackgroundResource(
                                R.drawable.borde_azul)}
                            13 -> {botones[12].text = "";keys(buSelected = botones[12]);botones[12].setBackgroundResource(
                                R.drawable.borde_azul)}
                            14 -> {botones[13].text = "";keys(buSelected = botones[13]);botones[13].setBackgroundResource(
                                R.drawable.borde_azul)}
                            15 -> {botones[14].text = "";keys(buSelected = botones[14]);botones[14].setBackgroundResource(
                                R.drawable.borde_azul)}
                            16 -> {botones[15].text = "";keys(buSelected = botones[15]);botones[15].setBackgroundResource(
                                R.drawable.borde_azul)}
                            17 -> {botones[16].text = "";keys(buSelected = botones[16]);botones[16].setBackgroundResource(
                                R.drawable.borde_azul)}
                            18 -> {botones[17].text = "";keys(buSelected = botones[17]);botones[17].setBackgroundResource(
                                R.drawable.borde_azul)}

                            19 -> {botones[18].text = "";keys(buSelected = botones[18]);botones[18].setBackgroundResource(
                                R.drawable.borde_negro)}
                            20 -> {botones[19].text = "";keys(buSelected = botones[19]);botones[19].setBackgroundResource(
                                R.drawable.borde_negro)}
                            21 -> {botones[20].text = "";keys(buSelected = botones[20]);botones[20].setBackgroundResource(
                                R.drawable.borde_negro)}
                            22 -> {botones[21].text = "";keys(buSelected = botones[21]);botones[21].setBackgroundResource(
                                R.drawable.borde_negro)}
                            23 -> {botones[22].text = "";keys(buSelected = botones[22]);botones[22].setBackgroundResource(
                                R.drawable.borde_negro)}
                            24 -> {botones[23].text = "";keys(buSelected = botones[23]);botones[23].setBackgroundResource(
                                R.drawable.borde_negro)}
                            25 -> {botones[24].text = "";keys(buSelected = botones[24]);botones[24].setBackgroundResource(
                                R.drawable.borde_negro)}
                            26 -> {botones[25].text = "";keys(buSelected = botones[25]);botones[25].setBackgroundResource(
                                R.drawable.borde_negro)}
                            27 -> {botones[26].text = "";keys(buSelected = botones[26]);botones[26].setBackgroundResource(
                                R.drawable.borde_negro)}

                            28 -> {botones[27].text = "";keys(buSelected = botones[27]);botones[27].setBackgroundResource(
                                R.drawable.borde_azul)}
                            29 -> {botones[28].text = "";keys(buSelected = botones[28]);botones[28].setBackgroundResource(
                                R.drawable.borde_azul)}
                            30 -> {botones[29].text = "";keys(buSelected = botones[29]);botones[29].setBackgroundResource(
                                R.drawable.borde_azul)}
                            31 -> {botones[30].text = "";keys(buSelected = botones[30]);botones[30].setBackgroundResource(
                                R.drawable.borde_azul)}
                            32 -> {botones[31].text = "";keys(buSelected = botones[31]);botones[31].setBackgroundResource(
                                R.drawable.borde_azul)}
                            33 -> {botones[32].text = "";keys(buSelected = botones[32]);botones[32].setBackgroundResource(
                                R.drawable.borde_azul)}
                            34 -> {botones[33].text = "";keys(buSelected = botones[33]);botones[33].setBackgroundResource(
                                R.drawable.borde_azul)}
                            35 -> {botones[34].text = "";keys(buSelected = botones[34]);botones[34].setBackgroundResource(
                                R.drawable.borde_azul)}
                            36 -> {botones[35].text = "";keys(buSelected = botones[35]);botones[35].setBackgroundResource(
                                R.drawable.borde_azul)}

                            37 -> {botones[36].text = "";keys(buSelected = botones[36]);botones[36].setBackgroundResource(
                                R.drawable.borde_negro)}
                            38 -> {botones[37].text = "";keys(buSelected = botones[37]);botones[37].setBackgroundResource(
                                R.drawable.borde_negro)}
                            39 -> {botones[38].text = "";keys(buSelected = botones[38]);botones[38].setBackgroundResource(
                                R.drawable.borde_negro)}
                            40 -> {botones[39].text = "";keys(buSelected = botones[39]);botones[39].setBackgroundResource(
                                R.drawable.borde_negro)}
                            41 -> {botones[40].text = "";keys(buSelected = botones[40]);botones[40].setBackgroundResource(
                                R.drawable.borde_negro)}
                            42 -> {botones[41].text = "";keys(buSelected = botones[41]);botones[41].setBackgroundResource(
                                R.drawable.borde_negro)}
                            43 -> {botones[42].text = "";keys(buSelected = botones[42]);botones[42].setBackgroundResource(
                                R.drawable.borde_negro)}
                            44 -> {botones[43].text = "";keys(buSelected = botones[43]);botones[43].setBackgroundResource(
                                R.drawable.borde_negro)}
                            45 -> {botones[44].text = "";keys(buSelected = botones[44]);botones[44].setBackgroundResource(
                                R.drawable.borde_negro)}

                            46 -> {botones[45].text = "";keys(buSelected = botones[45]);botones[45].setBackgroundResource(
                                R.drawable.borde_azul)}
                            47 -> {botones[46].text = "";keys(buSelected = botones[46]);botones[46].setBackgroundResource(
                                R.drawable.borde_azul)}
                            48 -> {botones[47].text = "";keys(buSelected = botones[47]);botones[47].setBackgroundResource(
                                R.drawable.borde_azul)}
                            49 -> {botones[48].text = "";keys(buSelected = botones[48]);botones[48].setBackgroundResource(
                                R.drawable.borde_azul)}
                            50 -> {botones[49].text = "";keys(buSelected = botones[49]);botones[49].setBackgroundResource(
                                R.drawable.borde_azul)}
                            51 -> {botones[50].text = "";keys(buSelected = botones[50]);botones[50].setBackgroundResource(
                                R.drawable.borde_azul)}
                            52 -> {botones[51].text = "";keys(buSelected = botones[51]);botones[51].setBackgroundResource(
                                R.drawable.borde_azul)}
                            53 -> {botones[52].text = "";keys(buSelected = botones[52]);botones[52].setBackgroundResource(
                                R.drawable.borde_azul)}
                            54 -> {botones[53].text = "";keys(buSelected = botones[53]);botones[53].setBackgroundResource(
                                R.drawable.borde_azul)}

                            55 -> {botones[54].text = "";keys(buSelected = botones[54]);botones[54].setBackgroundResource(
                                R.drawable.borde_negro)}
                            56 -> {botones[55].text = "";keys(buSelected = botones[55]);botones[55].setBackgroundResource(
                                R.drawable.borde_negro)}
                            57 -> {botones[56].text = "";keys(buSelected = botones[56]);botones[56].setBackgroundResource(
                                R.drawable.borde_negro)}
                            58 -> {botones[57].text = "";keys(buSelected = botones[57]);botones[57].setBackgroundResource(
                                R.drawable.borde_negro)}
                            59 -> {botones[58].text = "";keys(buSelected = botones[58]);botones[58].setBackgroundResource(
                                R.drawable.borde_negro)}
                            60 -> {botones[59].text = "";keys(buSelected = botones[59]);botones[59].setBackgroundResource(
                                R.drawable.borde_negro)}
                            61 -> {botones[60].text = "";keys(buSelected = botones[60]);botones[60].setBackgroundResource(
                                R.drawable.borde_negro)}
                            62 -> {botones[61].text = "";keys(buSelected = botones[61]);botones[61].setBackgroundResource(
                                R.drawable.borde_negro)}
                            63 -> {botones[62].text = "";keys(buSelected = botones[62]);botones[62].setBackgroundResource(
                                R.drawable.borde_negro)}

                            64 -> {botones[63].text = "";keys(buSelected = botones[63]);botones[63].setBackgroundResource(
                                R.drawable.borde_azul)}
                            65 -> {botones[64].text = "";keys(buSelected = botones[64]);botones[64].setBackgroundResource(
                                R.drawable.borde_azul)}
                            66 -> {botones[65].text = "";keys(buSelected = botones[65]);botones[65].setBackgroundResource(
                                R.drawable.borde_azul)}
                            67 -> {botones[66].text = "";keys(buSelected = botones[66]);botones[66].setBackgroundResource(
                                R.drawable.borde_azul)}
                            68 -> {botones[67].text = "";keys(buSelected = botones[67]);botones[67].setBackgroundResource(
                                R.drawable.borde_azul)}
                            69 -> {botones[68].text = "";keys(buSelected = botones[68]);botones[68].setBackgroundResource(
                                R.drawable.borde_azul)}
                            70 -> {botones[69].text = "";keys(buSelected = botones[69]);botones[69].setBackgroundResource(
                                R.drawable.borde_azul)}
                            71 -> {botones[70].text = "";keys(buSelected = botones[70]);botones[70].setBackgroundResource(
                                R.drawable.borde_azul)}
                            72 -> {botones[71].text = "";keys(buSelected = botones[71]);botones[71].setBackgroundResource(
                                R.drawable.borde_azul)}

                            73 -> {botones[72].text = "";keys(buSelected = botones[72]);botones[72].setBackgroundResource(
                                R.drawable.borde_negro)}
                            74 -> {botones[73].text = "";keys(buSelected = botones[73]);botones[73].setBackgroundResource(
                                R.drawable.borde_negro)}
                            75 -> {botones[74].text = "";keys(buSelected = botones[74]);botones[74].setBackgroundResource(
                                R.drawable.borde_negro)}
                            76 -> {botones[75].text = "";keys(buSelected = botones[75]);botones[75].setBackgroundResource(
                                R.drawable.borde_negro)}
                            77 -> {botones[76].text = "";keys(buSelected = botones[76]);botones[76].setBackgroundResource(
                                R.drawable.borde_negro)}
                            78 -> {botones[77].text = "";keys(buSelected = botones[77]);botones[77].setBackgroundResource(
                                R.drawable.borde_negro)}
                            79 -> {botones[78].text = "";keys(buSelected = botones[78]);botones[78].setBackgroundResource(
                                R.drawable.borde_negro)}
                            80 -> {botones[79].text = "";keys(buSelected = botones[79]);botones[79].setBackgroundResource(
                                R.drawable.borde_negro)}
                            81 -> {botones[80].text = "";keys(buSelected = botones[80]);botones[80].setBackgroundResource(
                                R.drawable.borde_negro)}
                        }
                        a++
                    }

                }
                else if (l == m || l == n || n == m || d == l || d == m || d == n || e == l || e == m || e == n || f == l || f == m || f == n || i == l || i == m || i == n || j == l || j == m || j == n || k == l || k == m || k == n) { board() }
            }
            else if (i == j || i == k || k == j || d == i || d == j || d == k || e == i || e == j || e == k || f == i || f == j || f == k) { board()}
        }
        else if (d == e || d == f || f == e) { board()}
    }

}