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
        val txtnombrePaciente = findViewById<EditText>(R.id.txtnombrePaciente)
        val txtapellidoPaciente = findViewById<EditText>(R.id.txtapellidoPaciente)
        val txtenfermedadPaciente = findViewById<EditText>(R.id.txtenfermedadPaciente)
        val txtedadPaciente = findViewById<EditText>(R.id.txtedadPaciente)
        val txtnumHabitacion = findViewById<EditText>(R.id.txtnumHabitacion)
        val txtnumCama = findViewById<EditText>(R.id.txtnumCama)

        //2-Programamos los botones
        btnagregar.setOnClickListener {
         CoroutineScope(Dispatchers.IO).launch {
              //1- Creamos un objeto de la base Conexion
              val objConexion = ClaseConexion.cadenaConexion()
              //2- Creamos la varobale que contenaga un preparestatement
              val Pacientes = objConexion?.prepareStatement("insert into Pacientes (uuid, Nombres, Apellido, Edad, Enfermedad, NumeroHabitacion, NumeroCama, MedicamentoaAsignados, HoraAplicacionMedicamentos) values (?,?,?,?,?,?,?,?,? )")
             Pacientes.setString(1, UUID.randomUUID().toString())
             Pacientes.setString(2, txtnombrePaciente.text.toString())
             Pacientes.setString(3, txtapellidoPaciente.text.toString())
             Pacientes.setString(4, txtedadPaciente.text.toString())
             Pacientes.setString(5, txtenfermedadPaciente.text.toString())
             Pacientes.setString(6, txtnumHabitacion.text.toString())
             Pacientes.setString(7, txtnumCama.text.toString())
             Pacientes.executeUpdate()
         }
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