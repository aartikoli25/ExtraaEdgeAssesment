package com.spacex.rockets.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.bumptech.glide.Glide
import com.smarteist.autoimageslider.SliderViewAdapter
import com.spacex.rockets.R
import java.util.*

class SliderAdapter(
    var context: Context,
    var listdata: ArrayList<String>
) : SliderViewAdapter<SliderAdapter.SliderAdapterVH>() {

    override fun onCreateViewHolder(parent: ViewGroup): SliderAdapterVH {
        val inflate: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.slider_item, null)
        return SliderAdapterVH(inflate)
    }

    override fun onBindViewHolder(
        viewHolder: SliderAdapterVH,
        position: Int
    ) {
        Glide.with(context)
            .load(listdata.get(position))
            .fitCenter()
            .into(viewHolder.image)
    }

    override fun getCount(): Int {
        return listdata.size
    }

    inner class SliderAdapterVH(itemView: View) :
        ViewHolder(itemView) {

        var image: ImageView

        init {
            image = itemView.findViewById<ImageView>(R.id.iv_image)
        }
    }
}
