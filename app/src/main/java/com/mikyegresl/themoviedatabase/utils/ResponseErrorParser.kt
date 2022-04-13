//package com.mikyegresl.themoviedatabase.utils
//
//import androidx.annotation.StringRes
//import com.mikyegresl.themoviedatabase.R
//import retrofit2.HttpException
//import java.io.IOException
//import javax.net.ssl.SSLHandshakeException
//import javax.net.ssl.SSLPeerUnverifiedException
//
//class ResponseErrorParser: IErrorParser {
//    override fun getDefaultErrorText(): String =
//        getErrorText(null)
//
//    override fun getErrorText(throwable: Throwable?): String =
//        getErrorText(throwable, R.string.default_error_message)
//
//    override fun getErrorText(
//        throwable: Throwable?,
//        @StringRes
//        defaultErrorText: Int
//    ): String {
//        return when (throwable) {
//            is ResponseAPIException -> getResponseErrorMessage(throwable.errors)
//            is HttpException -> getErrorTextForHttpException(throwable)
//            is SSLPeerUnverifiedException, is SSLHandshakeException -> resourcesService.getString(R.string.error_pinned_cert_cant_connect)
//            is IOException -> resourcesService.getString(R.string.server_error)
//            else -> {
//                throwable?.let(crashlyticsRepository::logException)
//                if (defaultErrorText == R.string.default_error_message) {
//                    coreAnalyticsInteractor.sendDefaultErrorEvent()
//                }
//                resourcesService.getString(defaultErrorText)
//            }
//        }
//    }
//
//    override fun hasErrorCode(throwable: Throwable?, vararg codes: Int): Boolean =
//        when (throwable) {
//            is ResponseAPIException -> hasErrorCodeResponseAPIException(throwable, codes)
//            is HttpException -> hasErrorCodeHttpException(throwable, codes)
//            else -> false
//        }
//
//    override fun getErrorCode(throwable: Throwable): Int =
//        getErrorResponseApiModel(throwable)?.errorCode ?: CommonConstants.INVALID
//
//    override fun getErrorResponseApiModel(throwable: Throwable): IErrorResponseModel? =
//        when (throwable) {
//            is HttpException -> httpExceptionConverter.convert(throwable)
//            is ResponseAPIException -> throwable.errors?.firstOrNull()
//            else -> null
//        }
//
//    private fun hasErrorCodeResponseAPIException(responseAPIException: ResponseAPIException, codes: IntArray): Boolean {
//        val firstError = responseAPIException.errors?.firstOrNull() ?: return false
//        return codes.any { firstError.errorCode == it }
//    }
//
//    private fun hasErrorCodeHttpException(
//        httpException: HttpException,
//        codes: IntArray
//    ): Boolean {
//        val errorResponseApi = httpExceptionConverter.convert(httpException)
//        val statusCode = errorResponseApi?.errorCode ?: httpException.code()
//        return statusCode in codes
//    }
//
//    private fun getErrorTextForHttpException(exception: HttpException): String {
//        val errorResponseApi = httpExceptionConverter.convert(exception)
//        return if (errorResponseApi != null) {
//            getResponseErrorMessage(errorResponseApi)
//        } else {
//            resourcesService.getString(R.string.server_error)
//        }
//    }
//
//    private fun getResponseErrorMessage(errors: List<IErrorResponseModel>?): String =
//        getResponseErrorMessage(errors?.firstOrNull())
//
//    private fun getResponseErrorMessage(error: IErrorResponseModel?): String {
//        val displayMessage = error?.displayMessage
//        return if (displayMessage.isNullOrEmpty())
//            resourcesService.getString(R.string.server_error)
//        else
//            displayMessage
//    }
//}