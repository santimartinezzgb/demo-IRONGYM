import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app_crud_mongodb.API.Ejercicio
import com.example.app_crud_mongodb.R

class EjercicioAdapter(
    private val lista: List<Ejercicio>,
    private val onEditarClick: (Ejercicio) -> Unit,
    private val onEliminarClick: (Ejercicio) -> Unit
) : RecyclerView.Adapter<EjercicioAdapter.ViewHolder>() {

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val datos: TextView = v.findViewById(R.id.datos)
        val btnEditar: Button = v.findViewById(R.id.btnEditar)
        val btnEliminar: Button = v.findViewById(R.id.btnEliminar)
    }

    override fun onCreateViewHolder(p: ViewGroup, vt: Int): ViewHolder {
        val v = LayoutInflater.from(p.context)
            .inflate(R.layout.item, p, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, pos: Int) {
        val e = lista[pos]
        holder.datos.text = "\n${e.nombre}" +
                "\nPeso: ${e.peso} kg" +
                "\nSeries: ${e.series}x${e.repeticiones}"

        holder.btnEditar.setOnClickListener { onEditarClick(e) }
        holder.btnEliminar.setOnClickListener { onEliminarClick(e) }
    }

    override fun getItemCount() = lista.size

}
