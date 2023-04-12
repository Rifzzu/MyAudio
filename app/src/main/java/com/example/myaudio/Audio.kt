package com.example.myaudio

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Audio(
    val name: String,
    val desc: String,
    val detail: String,
    val photo: Int
) : Parcelable