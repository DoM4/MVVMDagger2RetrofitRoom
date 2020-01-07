package com.domenicoaumenta.mvvm_dagger2_retrofit_room.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by domenicoaumenta on 2020-01-05.
 */
class UserResponse {
    @SerializedName("items")
    @Expose
    var users: List<User>? = null
    @SerializedName("hasMore")
    var hasMore: Boolean? = null
    @SerializedName("quotaMax")
    var quotaMax: Int? = null
    @SerializedName("quotaRemaining")
    var quotaRemaining: Int? = null

    override fun toString(): String {
        return "UserResponse(users=$users, hasMore=$hasMore, quotaMax=$quotaMax, quotaRemaining=$quotaRemaining)"
    }


}