package com.imaec.pagingwithcoroutine

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.imaec.pagingwithcoroutine.base.BaseViewModelFactory

object Extensions {

    inline fun <reified V : ViewModel> AppCompatActivity.getViewModel(noinline creator: (() -> V)) : V {
        creator.let {
            return ViewModelProvider(
                this,
                BaseViewModelFactory(creator)
            ).get(V::class.java)
        }
    }
}