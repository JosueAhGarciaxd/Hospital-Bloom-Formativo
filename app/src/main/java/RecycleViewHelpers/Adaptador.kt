package RecycleViewHelpers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import josuehernandez.ethanhenriquez.hospitalbloomformativo.R
import modelo.Doctores

class Adaptador(var Datos: List<Doctores>): RecyclerView.Adapter<ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //Unir el Recyclerview con la card
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_card, parent, false)
        return ViewHolder(vista)
    }

    override fun getItemCount() = Datos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //Controlar la card
        val item = Datos[position]
        holder.txtNombreCard.text = item.Nombre
    }


}