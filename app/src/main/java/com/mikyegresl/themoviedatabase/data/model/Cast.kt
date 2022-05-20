package com.mikyegresl.themoviedatabase.data.model

data class Cast(
    val id: Long,
    val castId: Long,
    val creditId: String? = null,
    val name: String,
    val originalName: String? = null,
    val gender: Gender? = Gender.UNDEFINED,
    val profilePath: String? = null,
    val character: String? = null,
    val knownForDepartment: String? = null,
    val order: Int = 0,
    val popularity: Int = 0,
    val isAdult: Boolean = false
)
