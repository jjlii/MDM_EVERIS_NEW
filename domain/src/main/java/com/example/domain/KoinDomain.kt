package com.example.domain

import com.example.domain.devices.DevicesUseCase
import com.example.domain.login.LoginUseCase
import com.example.domain.sign_up.SignUpUseCase
import com.example.domain.user.GetUserByIdUserCase
import org.koin.dsl.module.module

class KoinDomain {
    val domainModule by lazy {
        module{
            factory { LoginUseCase(get()) }
            factory { DevicesUseCase(get()) }
            factory { SignUpUseCase(get()) }
            factory { GetUserByIdUserCase(get()) }
        }
    }
}