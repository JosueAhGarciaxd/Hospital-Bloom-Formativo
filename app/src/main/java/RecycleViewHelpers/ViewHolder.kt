package RecycleViewHelpers

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import josuehernandez.ethanhenriquez.hospitalbloomformativo.R

class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

    //A qui se va a mandar a llamar a los elementos de la card
    val txtNombreCard = view.findViewById<TextView>(R.id.txtcardnom)


}