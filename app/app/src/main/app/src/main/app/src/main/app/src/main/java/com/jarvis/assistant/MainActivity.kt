package com.jarvis.assistant

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Button
import android.view.Gravity

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.gravity = Gravity.CENTER
        layout.setPadding(32, 32, 32, 32)
        layout.setBackgroundColor(Color.rgb(5, 12, 25))

        val title = TextView(this)
        title.text = "J.A.R.V.I.S"
        title.textSize = 32f
        title.setTextColor(Color.CYAN)
        title.gravity = Gravity.CENTER

        val status = TextView(this)
        status.text = "Sistemas inicializados"
        status.textSize = 18f
        status.setTextColor(Color.WHITE)
        status.gravity = Gravity.CENTER

        val button = Button(this)
        button.text = "ATIVAR JARVIS"

        button.setOnClickListener {
            status.text = "Aguardando comandos, senhor."
        }

        layout.addView(title)
        layout.addView(status)
        layout.addView(button)

        setContentView(layout)
    }
}
