package com.fdhasna21.androidstudio_dicoding_myfaves

lateinit var selectedRow : Group
data class Group(
    val name : String,
    val intro : String,
    val desc : String,
    val logo : Int,
    val photo : Int,
    val kpopwiki : String,
    val wikipedia : String,
    val kprofile : String
)
