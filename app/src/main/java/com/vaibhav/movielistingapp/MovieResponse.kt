package com.vaibhav.movielistingapp

import com.google.gson.annotations.SerializedName


data class MovieResponse (

  @SerializedName("docs"   ) var docs   : ArrayList<Docs> = arrayListOf(),
  @SerializedName("total"  ) var total  : Int?            = null,
  @SerializedName("limit"  ) var limit  : Int?            = null,
  @SerializedName("offset" ) var offset : Int?            = null,
  @SerializedName("page"   ) var page   : Int?            = null,
  @SerializedName("pages"  ) var pages  : Int?            = null

)