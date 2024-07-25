package josuehernandez.ethanhenriquez.hospitalbloomformativo.ui.notifications

import RecycleViewHelpers.Adaptador
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import josuehernandez.ethanhenriquez.hospitalbloomformativo.R
import josuehernandez.ethanhenriquez.hospitalbloomformativo.databinding.FragmentNotificationsBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import modelo.ClaseConexion
import modelo.Paciente

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root


        notificationsViewModel.text.observe(viewLifecycleOwner) {
        }

        val spPaciente = root.findViewById<Spinner>(R.id. spPaciente)
        val rcvPaciente = root.findViewById<RecyclerView>(R.id.rcvPaciente)
        rcvPaciente.layoutManager = LinearLayoutManager(requireContext())


        fun obtenerPacientes(): List<Paciente>{

            val objConexion = ClaseConexion().cadenaConexion()
            val statement = objConexion?.createStatement()
            val resultSet = statement?.executeQuery("select * from Paciente")!!

            val listadoPaciente = mutableListOf<Paciente>()
            while (resultSet.next()){
                val uuid = resultSet.getString("uuid")
                val nombre = resultSet.getString("nombre")
                val apellido = resultSet.getString("apellido")
                val edad = resultSet.getInt("edad")
                val numHabitacion = resultSet.getInt("numHabitacion")
                val numCama = resultSet.getInt("numCama")
                val fechaIngreso = resultSet.getString("fechaIngreso")
                val enfermedad = resultSet.getInt("enfermedad")
                val medicamento = resultSet.getInt("medicamento")
                val valoresJuntos = Paciente(uuid, nombre, apellido, edad, numHabitacion, numCama, fechaIngreso, enfermedad, medicamento)

                listadoPaciente.add(valoresJuntos)

            }
            return listadoPaciente
        }


        //asignar el adaptador al rcv
        CoroutineScope(Dispatchers.IO).launch {
            val pacientesDB = obtenerPacientes()
            withContext(Dispatchers.Main){
                val adaptador = Adaptador(pacientesDB)
                rcvPaciente.adapter = adaptador
            }
        }



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}