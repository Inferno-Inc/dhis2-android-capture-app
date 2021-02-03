package dhis2.org.analytics.charts.mappers

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import dhis2.org.R
import dhis2.org.analytics.charts.data.Graph
import dhis2.org.databinding.ItemSingleValueBinding

class GraphToValue {
    fun map(context: Context, graph: Graph): View {
        if (graph.series.isEmpty()) {
            return TextView(context).apply {
                text = context.getString(R.string.no_data)
            }
        }
        return LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = ViewGroup.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            graph.series.forEach {
                addView(
                    ItemSingleValueBinding.inflate(LayoutInflater.from(this.context)).apply {
                        singleValueTitle.text = graph.title
                        singleValue.text = it.coordinates.last().fieldValue.toString()
                    }.root
                )
            }
        }
    }
}
