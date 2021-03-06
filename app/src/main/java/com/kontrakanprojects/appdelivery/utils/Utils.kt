package com.kontrakanprojects.appdelivery.utils

import android.app.Activity
import android.view.View
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.snackbar.Snackbar
import com.kontrakanprojects.appdelivery.R
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import www.sanju.motiontoast.MotionToast
import java.io.File

fun View.snackbar(message: String) {
    Snackbar.make(
        this,
        message,
        Snackbar.LENGTH_LONG
    ).also { snackbar ->
        snackbar.setAction("OKE") {
            snackbar.dismiss()
        }
//        snackbar.view.apply {
//            setBackgroundColor(backgroundColor)
//        }
    }.show()
}

fun showMessage(
    activity: Activity,
    title: String,
    message: String = "Cek Koneksi Internet Dan Coba Lagi!",
    style: String,
) {
    MotionToast.createColorToast(
        activity,
        title,
        message,
        style,
        MotionToast.GRAVITY_BOTTOM,
        MotionToast.LONG_DURATION,
        ResourcesCompat.getFont(activity, R.font.helvetica_regular)
    )
}

fun createPartFromString(descriptionString: String): RequestBody {
    return descriptionString.toRequestBody("text/plain".toMediaTypeOrNull())
}

fun reqFileImage(path: String?, name: String): MultipartBody.Part {
    val fileImage = File(path!!)
    val reqFileImage =
        fileImage.asRequestBody("image/jpeg/jpg/png".toMediaTypeOrNull())
    return MultipartBody.Part.createFormData(
        name, fileImage.name, reqFileImage
    )
}

fun reqFileImageEmpty(name: String): MultipartBody.Part {
    val reqFileImage = ""
        .toRequestBody("image/jpeg/jpg/png".toMediaTypeOrNull())
    return MultipartBody.Part.createFormData(name, "", reqFileImage)
}