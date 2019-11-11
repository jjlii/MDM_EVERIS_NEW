package com.example.domain.user

import com.sun.xml.internal.ws.developer.Serialization
import java.io.Serializable

data class UserResponse(val id : String,
                        var email : String,
                        var name : String,
                        var favourites : MutableList<String>) : Serializable