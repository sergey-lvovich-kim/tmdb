package com.mikyegresl.themoviedatabase.utils

import android.os.Bundle

fun withArgs(args: (Bundle) -> Unit): Bundle = Bundle().apply {
    args(this)
}