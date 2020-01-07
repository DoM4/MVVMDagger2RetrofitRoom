package com.domenicoaumenta.mvvm_dagger2_retrofit_room.base

import android.view.View
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.domenicoaumenta.mvvm_dagger2_retrofit_room.R
import com.google.android.material.snackbar.Snackbar


/**
 * Created by domenicoaumenta on 2020-01-06.
 */
open class BaseActivty : AppCompatActivity(){

    private var mSnackBar : Snackbar ? = null

    /**
     * @param errorMessage string resource to error message
     * @param onClickListener action to be performed by the snackbar
     */
    fun showError(@StringRes errorMessage : Int, onClickListener: View.OnClickListener?){
        val view = findViewById<View>(android.R.id.content)
        mSnackBar = Snackbar.make(view, errorMessage, Snackbar.LENGTH_INDEFINITE)
        mSnackBar?.setAction(R.string.retry, onClickListener)
        mSnackBar?.show()
    }

    fun hideError(){
        mSnackBar?.dismiss()
    }
}