package RecycleViewHelpers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import josuehernandez.ethanhenriquez.hospitalbloomformativo.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import modelo.ClaseConexion
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
        holder.txtCardNombre.text =item.nombre
        holder.txtcardApellido.text = item.apellido
        holder.txtcardedad.text = item.edad.toString()
        holder.txtcardNumH.text = item.numHabitacion.toString()
        holder.txtcardNumcama.text = item.numCama.toString()
        holder.txtcardFechaIngreso.text = item.fechaIngreso
        holder.txtcardenfermedad.text = item.enfermedad.toString()
        holder.txtcarMedicamento.text = item.medicamento.toString()

    }

    fun paraEliminar(nombre: String, position: Int){
        val ListaDatos = Datos.toMutableList()
        ListaDatos.removeAt(position)

        GlobalScope.launch(Dispatchers.IO){
            val objConexion = ClaseConexion().cadenaConexion()

            //variable con el PrepareStatement
            val deletePaciente = objConexion?.prepareStatement("delete from Paciente where nombre = ?")!!
            deletePaciente.setString(1, nombre)
            deletePaciente.executeUpdate()

            val commit = objConexion.prepareStatement("commit")
            commit.executeUpdate()
        }

        Datos = ListaDatos.toList()
        notifyItemRemoved(position)
        notifyDataSetChanged()
    }



}