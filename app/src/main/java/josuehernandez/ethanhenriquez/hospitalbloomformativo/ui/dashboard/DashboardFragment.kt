package josuehernandez.ethanhenriquez.hospitalbloomformativo.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import josuehernandez.ethanhenriquez.hospitalbloomformativo.databinding.FragmentDashboardBinding
import kotlinx.coroutines.CoroutineScope
import modelo.ClaseConexion

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        dashboardViewModel.text.observe(viewLifecycleOwner) {
        }
        return root

        //NO SE DONDE VA ESTO Xd

        //1-Mandamos a llamar a todos los datos
        //val txtnombrePaciente = findViewById<EditText>(R.id.txtnombrePaciente)
        //val txtapellidoPaciente = findViewById<EditText>(R.id.txtapellidoPaciente)
        //val txtenfermedadPaciente = findViewById<EditText>(R.id.txtenfermedadPaciente)
        //val txtedadPaciente = findViewById<EditText>(R.id.txtedadPaciente)
        //val txtnumHabitacion = findViewById<EditText>(R.id.txtnumHabitacion)
        //val txtnumCama = findViewById<EditText>(R.id.txtnumCama)

        //2-Programamos los botones
        //btnagregar.setOnClickListener {
        //  CoroutineScope(Dispatchers.IO).launch {
                //1- Creamos un objeto de la base Conexion

        //      val objConexion = ClaseConexion.cadenaConexion()
        //    }
        //}

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}