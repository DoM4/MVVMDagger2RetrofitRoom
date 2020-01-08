package com.domenicoaumenta.mvvm_dagger2_retrofit_room.userlist

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.domenicoaumenta.mvvm_dagger2_retrofit_room.R
import com.domenicoaumenta.mvvm_dagger2_retrofit_room.base.BaseActivty
import com.domenicoaumenta.mvvm_dagger2_retrofit_room.model.User
import com.domenicoaumenta.mvvm_dagger2_retrofit_room.ui.UserListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class UserListActivity : BaseActivty() {

    lateinit var viewModel: UserListViewModel
    var usersAdapter: UsersAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this)[UserListViewModel::class.java]

        viewModel.loadingVisibility.observe(this,Observer{
            visibility -> pbUserListActivity.visibility = visibility
        })

        viewModel.errorMessage.observe(this, Observer {
                errorMessage -> if(errorMessage != null)
                    showError(errorMessage, viewModel.errorOnClickListener) else hideError()
        })

        viewModel.userResultList.observe(this, Observer {
            userList -> populateList(userList)
        })

    }

    private fun populateList(userList : List<User>){
        usersAdapter?.setUsers(userList) ?: run {
            usersAdapter = UsersAdapter()
            rvUserListActivity.adapter = usersAdapter
            usersAdapter?.setUsers(userList)
        }
    }
}
