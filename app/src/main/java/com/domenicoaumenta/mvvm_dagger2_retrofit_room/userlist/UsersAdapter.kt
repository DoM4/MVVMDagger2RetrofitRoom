package com.domenicoaumenta.mvvm_dagger2_retrofit_room.userlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.domenicoaumenta.mvvm_dagger2_retrofit_room.R
import com.domenicoaumenta.mvvm_dagger2_retrofit_room.model.User
import com.domenicoaumenta.mvvm_dagger2_retrofit_room.utils.CircleTransform
import com.squareup.picasso.Picasso


/**
 * Created by domenicoaumenta on 2020-01-07.
 */
class UsersAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var users = emptyList<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as UserViewHolder).bind(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }

    fun setUsers(users: List<User>) {
        this.users = users
        notifyDataSetChanged()
    }

    internal inner class UserViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private var userName : TextView? = itemView.findViewById(R.id.userName)
        private var userThumbnail : ImageView? = itemView.findViewById(R.id.userThumbnail)
        private var followUserButton : Button = itemView.findViewById(R.id.followUser)
        private var blockUserButton : Button = itemView.findViewById(R.id.blockUser)
        private var userContainer : ConstraintLayout = itemView.findViewById(R.id.userContainer)

        private var isUserBlocked : Boolean = false
            set(value) {
                field = value
                when(field){
                    true -> {
                        blockUserButton.text = itemView.context.getText(R.string.unblock)
                        userContainer.setBackgroundColor(ContextCompat.getColor(itemView.context,R.color.light_grey))
                    }
                    false ->{
                        blockUserButton.text = itemView.context.getText(R.string.block)
                        userContainer.setBackgroundColor(ContextCompat.getColor(itemView.context,R.color.white))
                    }
                }
            }

        private var isUserFollowed : Boolean = false
            set(value) {
                field = value
                when(field){
                    true -> followUserButton.text = itemView.context.getString(R.string.unfollow)
                    false -> followUserButton.text = itemView.context.getString(R.string.follow)
                }
            }

        fun bind(user: User) {
            userName?.text = user.displayName
            Picasso.get()
                .load(user.profileImage)
                .transform(CircleTransform())
                .into(userThumbnail)

            isUserFollowed = user.isFollowed
            isUserBlocked = user.isBlocked

            followUserButton.setOnClickListener {
                isUserFollowed = !user.isFollowed
                user.isFollowed = isUserFollowed
            }

            blockUserButton.setOnClickListener {
                isUserBlocked = !user.isBlocked
                user.isBlocked = isUserBlocked
            }
        }

    }
}