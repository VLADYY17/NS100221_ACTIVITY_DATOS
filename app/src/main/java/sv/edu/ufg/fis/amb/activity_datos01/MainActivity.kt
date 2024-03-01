package sv.edu.ufg.fis.amb.activity_datos01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog


class MainActivity : AppCompatActivity() {
    private lateinit var txtNombres:EditText
    private lateinit var txtApellidos:EditText
    private lateinit var txtEmail:EditText
    private lateinit var botonGuardar:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtNombres = findViewById(R.id.txt_nombres)
        txtApellidos = findViewById(R.id.txt_apellidos)
        txtEmail = findViewById(R.id.txt_email)
        botonGuardar = findViewById(R.id.btnguardar)

        botonGuardar.setOnClickListener {
            if (txtNombres.text.toString().isNullOrEmpty() || txtApellidos.text.toString().isNullOrEmpty() || txtEmail.text.toString().isNullOrEmpty()) {
                mensaje("Campos Vacios", "SE HA DETECTADO QUE ALMENOS UN CAMPO ESTÁ VACÍO, ¿Desea continuar?")
            } else {
                val intent = Intent(this, Activity_Recepcion_Datos::class.java)
                intent.putExtra("nombres", txtNombres.text.toString())
                intent.putExtra("apellidos", txtApellidos.text.toString())
                intent.putExtra("email", txtEmail.text.toString())
                startActivity(intent)

            }

        }
    }
    fun mensaje(titulo:String,mensaje:String){
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder
            .setMessage(mensaje)
            .setTitle(titulo)
            .setPositiveButton("Aceptar") { _, _ ->
                // Do something.
            }
        /*.setNegativeButton("Cancelar") { _, _ ->
            // Do something else.
        }*/

        val dialog: AlertDialog = builder.create()
        dialog.show()
    }


}