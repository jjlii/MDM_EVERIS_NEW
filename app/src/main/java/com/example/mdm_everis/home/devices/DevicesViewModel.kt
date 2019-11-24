package com.example.mdm_everis.home.devices

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.core.failure.Failure
import com.example.domain.devices.DevicesResponse
import com.example.domain.devices.DevicesUseCase
import com.example.domain.login.LoginUseCase
import com.example.domain.reserves.DeviceReservesUseCase
import com.example.domain.reserves.UserReservesUseCase
import com.example.domain.user.GetUserByIdUserCase
import com.example.mdm_everis.base.BaseViewModel

class DevicesViewModel(application: Application,
                       getUserByIdUserCase: GetUserByIdUserCase,
                       devicesUseCase: DevicesUseCase,
                       userReservesUseCase: UserReservesUseCase,
                       deviceReservesUseCase: DeviceReservesUseCase
) : BaseViewModel(application,getUserByIdUserCase,devicesUseCase,userReservesUseCase,deviceReservesUseCase) {

    //********************************** LiveData **************************************************

    //********************************** End LiveData **********************************************

}
