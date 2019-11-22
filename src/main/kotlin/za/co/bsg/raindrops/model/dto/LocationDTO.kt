package za.co.bsg.raindrops.model.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
data class LocationDTO constructor(
        @JsonProperty(value = "id") val id: Long,
        @JsonProperty(value = "buildingId") val buildingId: String,
        @JsonProperty(value = "buildingName") val buildingName: String,
        @JsonProperty(value = "streetNumber") val streetNumber: String,
        @JsonProperty(value = "streetName") val streetName: String,
        @JsonProperty(value = "streetType") val streetType: String,
        @JsonProperty(value = "fullAddress") val fullAddress: String,
        @JsonProperty(value = "postalCode") val postalCode: String,
        @JsonProperty(value = "city") val city: String,
        @JsonProperty(value = "regionCode") val regionCode: String,
        @JsonProperty(value = "region") val region: String,
        @JsonProperty(value = "countryCode") val countryCode: String,
        @JsonProperty(value = "country") val country: String
)