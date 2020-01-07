package com.domenicoaumenta.mvvm_dagger2_retrofit_room.di

import com.domenicoaumenta.mvvm_dagger2_retrofit_room.ui.UserListViewModel
import dagger.Component


/**
 * Created by domenicoaumenta on 2020-01-02.
 */
@Component(modules = [NetworkModule::class])
interface ViewModelComponent {

    @Component.Builder
    interface Builder{
        fun build() : ViewModelComponent

        fun buildNetworkModule(networkModule : NetworkModule) : Builder
    }

    fun inject(userListViewModel: UserListViewModel)

}