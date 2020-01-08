package com.domenicoaumenta.mvvm_dagger2_retrofit_room.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class User(
    @SerializedName("about_me")
    @Expose
    val aboutMe: String,
    @SerializedName("accept_rate")
    @Expose
    val acceptRate: Int,
    @SerializedName("account_id")
    @Expose
    val accountId: Int,
    @SerializedName("answer_count")
    @Expose
    val answerCount: Int,
    @SerializedName("badge_counts")
    @Expose
    val badgeCounts: BadgeCounts,
    @SerializedName("creation_date")
    @Expose
    val creationDate: Int,
    @SerializedName("display_name")
    @Expose
    val displayName: String,
    @SerializedName("down_vote_count")
    @Expose
    val downVoteCount: Int,
    @SerializedName("is_employee")
    @Expose
    val isEmployee: Boolean,
    @SerializedName("last_access_date")
    @Expose
    val lastAccessDate: Int,
    @SerializedName("last_modified_date")
    @Expose
    val lastModifiedDate: Int,
    @SerializedName("link")
    @Expose
    val link: String,
    @SerializedName("location")
    @Expose
    val location: String,
    @SerializedName("profile_image")
    @Expose
    val profileImage: String,
    @SerializedName("question_count")
    @Expose
    val questionCount: Int,
    @SerializedName("reputation")
    @Expose
    val reputation: Int,
    @SerializedName("reputation_change_day")
    @Expose
    val reputationChangeDay: Int,
    @SerializedName("reputation_change_month")
    @Expose
    val reputationChangeMonth: Int,
    @SerializedName("reputation_change_quarter")
    @Expose
    val reputationChangeQuarter: Int,
    @SerializedName("reputation_change_week")
    @Expose
    val reputationChangeWeek: Int,
    @SerializedName("reputation_change_year")
    @Expose
    val reputationChangeYear: Int,
    @SerializedName("up_vote_count")
    @Expose
    val upVoteCount: Int,
    @SerializedName("user_id")
    @Expose
    val userId: Int,
    @SerializedName("user_type")
    @Expose
    val userType: String,
    @SerializedName("view_count")
    @Expose
    val viewCount: Int,
    @SerializedName("website_url")
    @Expose
    val websiteUrl: String,

    var isFollowed: Boolean = false,

    var isBlocked: Boolean = false
)