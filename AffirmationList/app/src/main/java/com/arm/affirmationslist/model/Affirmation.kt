package com.arm.affirmationslist.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Affirmation(@StringRes val stringResourceID: Int,
                       @DrawableRes val imageResourceID: Int)
