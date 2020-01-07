package com.domenicoaumenta.mvvm_dagger2_retrofit_room.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BadgeCounts(
    @SerializedName("bronze")
    @Expose
    val bronze: Int,
    @SerializedName("gold")
    @Expose
    val gold: Int,
    @SerializedName("silver")
    @Expose
    val silver: Int
)