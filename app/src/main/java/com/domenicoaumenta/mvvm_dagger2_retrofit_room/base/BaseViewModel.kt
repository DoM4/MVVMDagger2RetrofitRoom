package com.domenicoaumenta.mvvm_dagger2_retrofit_room.base

import androidx.lifecycle.ViewModel
import com.domenicoaumenta.mvvm_dagger2_retrofit_room.di.DaggerViewModelComponent
import com.domenicoaumenta.mvvm_dagger2_retrofit_room.di.NetworkModule
import com.domenicoaumenta.mvvm_dagger2_retrofit_room.di.ViewModelComponent
import com.domenicoaumenta.mvvm_dagger2_retrofit_room.ui.UserListViewModel


/**
 * Created by domenicoaumenta on 2020-01-02.
 */
abstract class BaseViewModel : ViewModel(){
    private val injector : ViewModelComponent = DaggerViewModelComponent
        .builder()
        .buildNetworkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    private fun inject(){
        when(this){
            is UserListViewModel -> injector.inject(this)
        }
    }
}