package com.mikyegresl.themoviedatabase.ui.common.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

abstract class BaseAdapter(
    layoutInflater: LayoutInflater,
    viewGroup: ViewGroup?,
    @LayoutRes layoutRes: Int,
) {
    abstract val root: View
    protected val context: Context get() =
        root.context
}