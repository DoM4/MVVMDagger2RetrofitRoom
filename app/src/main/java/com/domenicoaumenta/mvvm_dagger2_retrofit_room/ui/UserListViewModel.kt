package com.domenicoaumenta.mvvm_dagger2_retrofit_room.ui

import android.util.Log
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.MutableLiveData
import com.domenicoaumenta.mvvm_dagger2_retrofit_room.R
import com.domenicoaumenta.mvvm_dagger2_retrofit_room.base.BaseViewModel
import com.domenicoaumenta.mvvm_dagger2_retrofit_room.model.User
import com.domenicoaumenta.mvvm_dagger2_retrofit_room.network.UserApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


/**
 * Created by domenicoaumenta on 2020-01-02.
 */
class UserListViewModel : BaseViewModel(){

    @Inject
    lateinit var userApi: UserApi

    private lateinit var subscription : Disposable

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage : MutableLiveData<Int> = MutableLiveData()
    val errorOnClickListener = View.OnClickListener {
        loadUsers()
    }

    init {
        loadUsers()
    }

    private fun loadUsers(){
        subscription = userApi
            .getTop100Users()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe{onRetrievePostListStart()}
            .doOnComplete{onRetrievePostListFinish()}
            .subscribe({
                result ->
                run {
                    Log.d("UserListViewModel", result.toString())
                    onRetrieveUserListSuccess(result.users)
                }
            },
                {error -> onRetrieveUserListError(error)})

    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    private fun onRetrievePostListStart(){
        loadingVisibility.value = VISIBLE
        errorMessage.value = null
    }

    private fun onRetrievePostListFinish(){
        loadingVisibility.value = GONE
    }

    private fun onRetrieveUserListSuccess(result: List<User>?) {
        Log.d("UserListViewModel",result.toString())
    }

    private fun onRetrieveUserListError(error: Throwable) {
        Log.d("UserListViewModel", "error ${error.message}")
        errorMessage.value = R.string.user_error
    }
}