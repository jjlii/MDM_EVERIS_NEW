package com.example.mdm_everis.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

abstract class BaseViewModel(application : Application): AndroidViewModel(application) {
    val loadingMLD = MutableLiveData<Boolean>()
}