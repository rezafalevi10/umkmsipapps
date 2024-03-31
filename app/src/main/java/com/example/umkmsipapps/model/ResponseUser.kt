package com.example.umkmsipapps.model

import com.google.gson.annotations.SerializedName

data class ResponseUser(
    @field:SerializedName("page")
    val page: Int? = null,

    @field:SerializedName("per_Page")
    val perPage: Int? = null,

    @field:SerializedName("total")
    val total: Int? = null,

    @field:SerializedName("total_pages")
    val totalpages: Int? = null,

    @field:SerializedName("data")
    val data: List<DataItem>? = null,
)
