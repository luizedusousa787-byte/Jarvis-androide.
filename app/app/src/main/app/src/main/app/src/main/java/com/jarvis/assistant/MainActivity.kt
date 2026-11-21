package com.jarvis.assistant

import android.app.Activity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.RecognizerIntent
import android.content.Intent
import android.widget.*
import android.view.Gravity
import java.util.Locale

class MainActivity : Activity(), TextToSpeech.OnInitListener {

    private lateinit var tts: TextToSpeech
    private lateinit var resposta: TextView
    private lateinit var entrada: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tts = TextToSpeech(this, this)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(30, 30, 30, 30)
            setBackgroundColor(0xFF07111F.toInt())
        }

        val titulo = TextView(this).apply {
            text = "J.A.R.V.I.S."
            textSize = 32f
            setTextColor(0xFF00D9FF.toInt())
            gravity = Gravity.CENTER
        }

        entrada = EditText(this).apply {
            hint = "Fale comigo, senhor..."
            setTextColor(-1)
            setHintTextColor(0xFFAAAAAA.toInt())
        }

        resposta = TextView(this).apply {
            text = "Sistema iniciado. Aguardando comandos."
            textSize = 18f
            setTextColor(-1)
            gravity = Gravity.CENTER
        }

        val botao = Button(this).apply {
            text = "ENVIAR COMANDO"
            setOnClickListener {
                responder(entrada.text.toString())
            }
        }

        val layoutParams = LinearLayout.LayoutParams(
            -1, -2
        ).apply {
            setMargins(0, 20, 0, 20)
        }

        layout.addView(titulo, layoutParams)
        layout.addView(entrada, layoutParams)
        layout.addView(botao, layoutParams)
        layout.addView(resposta, layoutParams)

        setContentView(layout)
    }

    private fun responder(comando: String) {
        val texto = when {
            comando.isBlank() -> "Diga alguma coisa, senhor."
            comando.contains("olá", true) ||
            comando.contains("oi", true) ->
                "Olá, senhor. Estou operacional."

            comando.contains("seu nome", true) ->
                "Sou JARVIS, seu assistente pessoal."

            comando.contains("hora", true) ->
                "São ${java.text.SimpleDateFormat("HH:mm", Locale("pt", "BR")).format(java.util.Date())}."

            comando.contains("quem sou", true) ->
                "O senhor é meu administrador principal."

            else ->
                "Comando recebido, senhor. Ainda estou aprendendo essa função."
        }

        resposta.text = texto
        if (::tts.isInitialized) tts.speak(
            texto,
            TextToSpeech.QUEUE_FLUSH,
            null,
            "jarvis"
        )
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            tts.language = Locale("pt", "BR")
        }
    }

    override fun onDestroy() {
        if (::tts.isInitialized) tts.shutdown()
        super.onDestroy()
    }
}
