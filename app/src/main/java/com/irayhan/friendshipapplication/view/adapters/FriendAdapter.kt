package com.irayhan.friendshipapplication.view.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.card.MaterialCardView
import com.irayhan.friendshipapplication.R
import com.irayhan.friendshipapplication.base.BaseRecycleAdapter
import com.irayhan.friendshipapplication.models.ModelFriend

class FriendAdapter(
    context: Context,
    layoutResource: Int,
    private val listener: OnCardClickListener
) :
    BaseRecycleAdapter<FriendAdapter.FriendAdapterViewHolder, ModelFriend>(
        context,
        layoutResource
    ) {

    override fun onCreateView(viewHolder: View?): FriendAdapterViewHolder {
        return FriendAdapterViewHolder(viewHolder!!)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: FriendAdapterViewHolder, position: Int) {
        val friend = get(position)

        holder.apply {

            // image
            Glide.with(mContext).load(friend.picture?.thumbnail).into(imgFriend)

            // name
            txtName.text = friend.name?.first

            // country
            txtCountry.text = friend.location?.country

            // click listener
            cardRoot.setOnClickListener {
                listener.onClick(friend)
            }

        }

    }

    class FriendAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardRoot: MaterialCardView = itemView.findViewById(R.id.card_friend)
        val imgFriend: ImageView = itemView.findViewById(R.id.img_friend)
        val txtName: TextView = itemView.findViewById(R.id.txt_name)
        val txtCountry: TextView = itemView.findViewById(R.id.txt_country)
    }


    interface OnCardClickListener {
        fun onClick(friend: ModelFriend)
    }
}