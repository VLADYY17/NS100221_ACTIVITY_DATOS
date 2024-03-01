package sv.edu.ufg.fis.amb.activity_datos01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button

class Activity_Recepcion_Datos : AppCompatActivity() {

    private lateinit var Nombres:TextView
    private lateinit var Apellidos:TextView
    private lateinit var Email:TextView
    private lateinit var Salir:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recepcion_datos)

        Nombres = findViewById(R.id.lbl_nombres_result)
        Apellidos = findViewById(R.id.lbl_apellidos_result)
        Email = findViewById(R.id.lbl_email_result)
        Salir = findViewById(R.id.btn_salir)

        val intent = intent
        val nombres = intent.getStringExtra("nombres")
        val apellidos = intent.getStringExtra("apellidos")
        val email = intent.getStringExtra("email")

        Nombres.text = nombres
        Apellidos.text = apellidos
        Email.text = email

        Salir.setOnClickListener {
            finish()
        }

    }
}