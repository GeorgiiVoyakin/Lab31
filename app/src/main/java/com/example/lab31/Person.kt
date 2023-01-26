package com.example.lab31

import com.google.gson.annotations.SerializedName

data class Person(val name: String, val sex: Sex, val phoneNumber: String)

enum class Sex {
    @SerializedName("male")
    Male,
    @SerializedName("female")
    Female,
    @SerializedName("other")
    Other
}
