package RecycleViewHelpers

import android.view.LayoutInflater
import android.view.ViewGroup
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
        val item = Datos[position]
        holder.txtcardnom.text =item.nombre
        holder.txtApellidoCard.text = item.apellido
        holder.txtaedadCard.text = item.edad
        holder.txtcardnumh.text = item.numHabitacion
        holder.txtcardnumcam.text = item.numCama
        holder.txtcardfecha.text = item.fechaIngreso
        holder.txtcardenfermedad.text = item.enfermedad
        holder.txtcardmedicamento.text = item.medicamento

    }


}