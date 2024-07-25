package RecycleViewHelpers

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import josuehernandez.ethanhenriquez.hospitalbloomformativo.R

class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

    //A qui se va a mandar a llamar a los elementos de la card
    val txtCardNombre = view.findViewById<TextView>(R.id.txtCardNombre)
    val txtcardApellido = view.findViewById<TextView>(R.id.txtcardApellido)
    val txtcardedad = view.findViewById<TextView>(R.id.txtcardedad)
    val txtcardNumH = view.findViewById<TextView>(R.id.txtcardNumH)
    val txtcardNumcama = view.findViewById<TextView>(R.id.txtcardNumcama)
    val txtcardFechaIngreso = view.findViewById<TextView>(R.id.txtcardFechaIngreso)
    val txtcardenfermedad = view.findViewById<TextView>(R.id.txtcardenfermedad)
    val txtcarMedicamento = view.findViewById<TextView>(R.id.txtcarMedicamento)
    val btnEditar = view.findViewById<TextView>(R.id.btnEditar)
    val btnEliminar = view.findViewById<TextView>(R.id.btnEliminar)


}