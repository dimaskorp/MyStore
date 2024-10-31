package com.example.mystore.data_models

data class Suggestions(
    var suggestions: List<Suggestion> = listOf()
)


data class Suggestion(
    var value: String? = null,
    var unrestricted_value: String? = null,
    var data: Data? = Data()
)

data class Data(
    var country: String? = "",
    var house: String? = "",
    var city: String? = "",
    var region_with_type: String? = "",
    var street_with_type: String? = "",


    )
