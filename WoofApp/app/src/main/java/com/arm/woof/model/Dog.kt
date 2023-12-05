package com.arm.woof.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Dog(
    @DrawableRes val picture: Int,
    @StringRes val name: Int,
    val year: Int,
    @StringRes val dogHobby : Int
)