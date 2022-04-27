package com.vaibhav.movielistingapp

import com.google.gson.annotations.SerializedName


data class Docs (

  @SerializedName("_id"                        ) var Id                         : String? = null,
  @SerializedName("name"                       ) var name                       : String? = null,
  @SerializedName("runtimeInMinutes"           ) var runtimeInMinutes           : Int?    = null,
  @SerializedName("budgetInMillions"           ) var budgetInMillions           : Int?    = null,
  @SerializedName("boxOfficeRevenueInMillions" ) var boxOfficeRevenueInMillions : Double?    = null,
  @SerializedName("academyAwardNominations"    ) var academyAwardNominations    : Int?    = null,
  @SerializedName("academyAwardWins"           ) var academyAwardWins           : Int?    = null,
  @SerializedName("rottenTomatoesScore"        ) var rottenTomatoesScore        : Double?    = null

)