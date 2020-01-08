package com.domenicoaumenta.mvvm_dagger2_retrofit_room.network

import com.domenicoaumenta.mvvm_dagger2_retrofit_room.model.UserResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by domenicoaumenta on 2020-01-02.
 */
interface UserApi {

    @GET("2.2/users")
    fun getUsersByReputation(
        @Query("pagesize") pageSize : Int = 1,
        @Query("order") order : String ? = "desc",
        @Query("sort") sort : String ? = "reputation",
        @Query("site") site : String? = "stackoverflow"
     ) : Observable<UserResponse>

}