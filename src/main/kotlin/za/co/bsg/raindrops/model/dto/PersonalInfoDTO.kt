package za.co.bsg.raindrops.model.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
data class PersonalInfoDTO @JvmOverloads constructor(
        @JsonProperty(value = "id") val id: Long,
        @JsonProperty(value = "username") val username: String,
        @JsonProperty(value = "employeeId") val employeeId: String,
        @JsonProperty(value = "alternateEmployeeId") val alternateEmployeeId: String,
        @JsonProperty(value = "profilePic") val profilePic: String,
        @JsonProperty(value = "title") val title: String,
        @JsonProperty(value = "suffix") val suffix: String,
        @JsonProperty(value = "firstName") val firstName: String,
        @JsonProperty(value = "lastName") val lastName: String,
        @JsonProperty(value = "fullName") val fullName: String,
        @JsonProperty(value = "gender") val gender: String,
        @JsonProperty(value = "mobileNumber") val mobileNumber: String
)