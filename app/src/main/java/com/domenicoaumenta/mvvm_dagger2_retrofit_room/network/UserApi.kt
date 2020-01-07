package com.domenicoaumenta.mvvm_dagger2_retrofit_room.network

import com.domenicoaumenta.mvvm_dagger2_retrofit_room.model.UserResponse
import io.reactivex.Observable
import retrofit2.http.GET


/**
 * Created by domenicoaumenta on 2020-01-02.
 */
interface UserApi {

    @GET("2.2/users?pagesize=100&order=desc&sort=reputation&site=stackoverflow")
    fun getTop100Users() : Observable<UserResponse>

}