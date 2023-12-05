package com.arm.coursesapplist.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class CourseTopic(
    @StringRes val name: Int,
    val numAssociates: Int,
    @DrawableRes val picture: Int,
)
