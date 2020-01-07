package com.domenicoaumenta.mvvm_dagger2_retrofit_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.domenicoaumenta.mvvm_dagger2_retrofit_room.base.BaseActivty
import com.domenicoaumenta.mvvm_dagger2_retrofit_room.ui.UserListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivty() {

    lateinit var viewModel: UserListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(UserListViewModel::class.java)

        viewModel.loadingVisibility.observe(this,Observer<Int>{
            visibility -> progressBar.visibility = visibility
        })

        viewModel.errorMessage.observe(this, Observer {
                errorMessage -> if(errorMessage != null)
                    showError(errorMessage, viewModel.errorOnClickListener) else hideError()
        })

    }
}
