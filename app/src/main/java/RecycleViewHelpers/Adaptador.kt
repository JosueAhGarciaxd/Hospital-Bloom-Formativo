package RecycleViewHelpers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import josuehernandez.ethanhenriquez.hospitalbloomformativo.R
import modelo.Paciente

class Adaptador(var Datos: List<Paciente>): RecyclerView.Adapter<ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //Unir el Recyclerview con la card
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_card, parent, false)
        return ViewHolder(vista)
    }

    override fun getItemCount() = Datos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //Controlar la card
        val paciente = Datos[position]
        holder.txtCardNombre.text = paciente.nombre
        holder.txtcardApellido.text = paciente.apellido
        holder.txtcardedad.text = paciente.edad.toString()
        holder.txtcardNumH.text = paciente.numHabitacion.toString()
        holder.txtcardNumcama.text = paciente.numCama.toString()
        holder.txtcardFechaIngreso.text = paciente.fechaIngreso
        holder.txtcardenfermedad.text = paciente.enfermedad.toString()
        holder.txtcarMedicamento.text = paciente.medicamento.toString()


    }

}