package com.mikyegresl.themoviedatabase.utils

import androidx.annotation.StringRes

internal interface IErrorParser {

    fun getDefaultErrorText(): String
    fun getErrorText(throwable: Throwable?): String
    fun getErrorText(throwable: Throwable?, @StringRes defaultErrorText: Int): String

    fun hasErrorCode(throwable: Throwable?, vararg codes: Int): Boolean
    fun getErrorCode(throwable: Throwable): Int
//    fun getErrorResponseApiModel(throwable: Throwable): IErrorResponseModel?
}