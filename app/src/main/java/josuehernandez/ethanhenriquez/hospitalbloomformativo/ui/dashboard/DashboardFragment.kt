package josuehernandez.ethanhenriquez.hospitalbloomformativo.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import josuehernandez.ethanhenriquez.hospitalbloomformativo.R
import josuehernandez.ethanhenriquez.hospitalbloomformativo.databinding.FragmentDashboardBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import modelo.ClaseConexion
import java.util.UUID

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

        //NO SE DONDE VA ESTO Xd
        //ESTOOOO NO ME ACUERDO DONDE VA

        //1-Mandamos a llamar a todos los datos
        val txtnombrePaciente = root.findViewById<EditText>(R.id.txtnombrePaciente)
        val txtapellidoPaciente = root.findViewById<EditText>(R.id.txtapellidoPaciente)
        val txtfechaingreso = root.findViewById<EditText>(R.id.txtFechaIngreso)
        val txtedadPaciente = root.findViewById<EditText>(R.id.txtedadPaciente)
        val txtnumHabitacion = root.findViewById<EditText>(R.id.txtnumHabitacion)
        val txtnumCama = root.findViewById<EditText>(R.id.txtnumCama)
        val btnagregar = root.findViewById<Button>(R.id.btnagregar)

        fun obtenerEnfermedades(): List<tbEnfermedad>{
            val objConexion = ClaseConexion().cadenaConexion()

            val statement = objConexion?.createStatement()
            val resultSet = statement?.executeQuery("SELECT * FROM tbEnfermedad")!!

            val listadoEnfermedades = mutableListOf<tbEnfermedad>()

            while (resultSet.next()){
                val idEnfermedad = resultSet.getInt("idEnfermedad")
                val nombreEnfermedad = resultSet.getString("nombreEnfermedad")

                val enfermedadCompleta = tbEnfermedad(idEnfermedad, nombreEnfermedad)
                listadoEnfermedades.add(enfermedadCompleta)
            }
            return listadoEnfermedades
        }

        dashboardViewModel.text.observe(viewLifecycleOwner) {
        }
        return root


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}