package com.spacex.rockets.roomDb

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.spacex.rockets.R
import com.spacex.rockets.utils.Constants
import com.spacex.rockets.view.activity.RocketDetailActivity
import kotlinx.android.synthetic.main.rocket_list_item.view.*

class RocketListRoomAdapter(private val rocketListResponse: ArrayList<RocketListRoomModel>) :
    RecyclerView.Adapter<RocketListRoomAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(rocketListResponse: RocketListRoomModel) {
            itemView.apply {
                text_name.text = rocketListResponse.name
                text_country.text = context.getString(R.string.country) + rocketListResponse.country
                text_engines_count.text =
                    context.getString(R.string.engines_count) + rocketListResponse.engine_count

                Glide.with(context)
                    .load(rocketListResponse.image)
                    .centerCrop()
                    .placeholder(R.drawable.ic_default)
                    .into(image_view_rocket)

                layout_root.setOnClickListener {
                    if (Constants.isNetworkAvailable) {
                        val intent = Intent(context, RocketDetailActivity::class.java)
                        intent.putExtra("ID", rocketListResponse.id)
                        context.startActivity(intent)
                    } else {
                        Toast.makeText(
                            context,
                            context.getString(R.string.check_connection),
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rocket_list_item, parent, false)
        )

    override fun getItemCount(): Int = rocketListResponse.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(rocketListResponse[position])
    }

    fun addRockets(rocketListResponse: List<RocketListRoomModel>) {
        this.rocketListResponse.apply {
            clear()
            addAll(rocketListResponse)
        }
    }
}