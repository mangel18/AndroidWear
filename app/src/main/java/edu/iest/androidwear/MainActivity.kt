package edu.iest.androidwear

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import edu.iest.androidwear.databinding.ActivityRelojBinding

class MainActivity : Activity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityRelojBinding
    private var textoSeleccionado: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRelojBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvSaludo.text = "Hola amiguito"
        binding.bnCambio.text = "Enviar"

        val adaptador = ArrayAdapter.createFromResource(this, R.array.misOpciones, android.R.layout.simple_spinner_item)

        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spOpciones.adapter = adaptador
        binding.spOpciones.onItemSelectedListener = this


        binding.bnCambio.setOnClickListener {
            var alerta = AlertDialog.Builder(this)
                .setMessage("Quiere enviar el saludo $textoSeleccionado")
                .setCancelable(false)
                .setPositiveButton("OK",
                DialogInterface.OnClickListener{dislogInterface, i -> binding.tvSaludo.text = textoSeleccionado
                })
                .setNegativeButton("Cancelar", DialogInterface.OnClickListener{dialogInterface, i -> Toast.makeText(this, "Una lástima",  Toast.LENGTH_SHORT).show()
                }) .show()

        }

    }




    override fun onItemSelected(vistaPadre: AdapterView<*>?, vistaRow: View?, position: Int, idVision: Long) {
        var textoSeleccionado = vistaPadre?.getItemAtPosition(position)?.toString()
        Toast.makeText(this,"Elegiste $textoSeleccionado", Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }


}