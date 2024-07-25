package RecycleViewHelpers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import josuehernandez.ethanhenriquez.hospitalbloomformativo.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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

        val paciente = Datos[position]
        holder.txtCardNombre.text =paciente.nombre
        holder.txtcardApellido.text = paciente.apellido
        holder.txtcardedad.text = paciente.edad.toString()
        holder.txtcardNumH.text = paciente.numHabitacion.toString()
        holder.txtcardNumcama.text = paciente.numCama.toString()
        holder.txtcardFechaIngreso.text = paciente.fechaIngreso
        holder.txtcardenfermedad.text = paciente.enfermedad.toString()
        holder.txtcarMedicamento.text = paciente.medicamento.toString()

        holder.btnEliminar.setOnClickListener{
            //alert
            val context = holder.itemView.context

            val builder = AlertDialog.Builder(context)
            builder.setTitle("Eliminar")
            builder.setTitle("¿Desea eliminar los datos del paciente?")
            //botones
            builder.setPositiveButton("Si"){dialog, switch -> paraEliminar(paciente. nombre, position)

            }

            builder.setNegativeButton("No"){dialog, switch -> dialog.dismiss()

            }
            val dialog = builder.create()
            dialog.show()
        }

        ////////////////////para eliminar ////////////////

        fun paActualizar(nuevaLista: List<Paciente>){
            Datos = nuevaLista
            notifyDataSetChanged() /////////notificamos
        }



        fun actualizaciondePantalla(newNombre: String, newApellido: String, newEdad: Number, newNumHabitacion: Number, newNumCama: Number, newFechaIngreso: String, newEnfermedad: Number, newMedicamento: Number, uuid: String){
            GlobalScope.launch(Dispatchers.IO) {
                val objConexion = ClaseConexion().cadenaConexion()

                val updatePaciente = objConexion?.prepareStatement("update Paciente set nombre = ?, apellido = ?, edad = ?, numHabitacion = ?, numCama = ?, fechaIngreso = ?, enfermedad = ?, medicamento = ? where uuid = ?")!!
                updatePaciente.setString(1, newNombre)
                updatePaciente.setString(2, newApellido)
                updatePaciente.setInt(3, newEdad.toInt())
                updatePaciente.setInt(4, newNumHabitacion.toInt())
                updatePaciente.setInt(5, newNumCama.toInt())
                updatePaciente.setString(6, newFechaIngreso)
                updatePaciente.setInt(7, newEnfermedad.toInt())
                updatePaciente.setInt(8, newMedicamento.toInt())
                updatePaciente.setString(8, uuid)

                updatePaciente.executeUpdate()
                withContext(Dispatchers.Main){
                    actualizaciondePantalla(newNombre, newApellido, newEdad, newNumHabitacion, newNumCama, newFechaIngreso, newEnfermedad, newMedicamento, uuid)
                }



            }
        }


    }



}