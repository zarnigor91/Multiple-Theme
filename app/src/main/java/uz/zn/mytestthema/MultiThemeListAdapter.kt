package uz.zn.mytestthema

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_theme.view.*
import uz.zn.mytestthema.model.ThemeModel

class MultiThemeListAdapter(val listener: ThemeChangeListener) : RecyclerView.Adapter<ViewHolder>() {

    private var themesList: ArrayList<ThemeModel> = ArrayList()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.list_theme, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return themesList.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val themeModel = themesList[position]

        when (position) {
            0 -> {
                viewHolder.itemView.view.setBackgroundColor(Color.parseColor("#008577"))
            }
            1 -> {
                viewHolder.itemView.view.setBackgroundColor(Color.parseColor("#000000"))
            }
            2 -> {
                viewHolder.itemView.view.setBackgroundColor(Color.parseColor("#8BC34A"))
            }
            3 -> {
                viewHolder.itemView.view.setBackgroundColor(Color.parseColor("#673AB7"))
            }
        }
        viewHolder.itemView.setOnClickListener {
            listener.onThemeChanged(themeModel)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return 4
    }

    fun setData(themesList: ArrayList<ThemeModel>) {
        this.themesList = themesList
  notifyDataSetChanged()
    }
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(themeModel: ThemeModel) {
        itemView.view.setBackgroundColor(Color.parseColor("#8BC34A"))
    }
}

interface ThemeChangeListener {
    fun onThemeChanged(themeModel: ThemeModel)
}