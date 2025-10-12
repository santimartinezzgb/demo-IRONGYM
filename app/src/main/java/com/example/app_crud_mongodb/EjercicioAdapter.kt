import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app_crud_mongodb.API.Ejercicios

class EjercicioAdapter(private val lista: List<Ejercicios>) :
    RecyclerView.Adapter<EjercicioAdapter.ViewHolder>() {

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val tv = v.findViewById<TextView>(android.R.id.text1)
    }

    override fun onCreateViewHolder(p: ViewGroup, vt: Int): ViewHolder {
        val v = LayoutInflater.from(p.context)
            .inflate(android.R.layout.simple_list_item_1, p, false)
        return ViewHolder(v)
    }


    override fun onBindViewHolder(h: ViewHolder, pos: Int) {
        val e = lista[pos]
        h.tv.text = "${e.nombre} - ${e.grupomuscular} (${e.series}x${e.repeticiones})"
    }

    override fun getItemCount() = lista.size
}
