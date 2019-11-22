package za.co.bsg.raindrops.model.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

@JsonInclude(JsonInclude.Include.NON_NULL)
data class DeploymentDTO constructor(
        @JsonProperty(value = "id") val id: Long,
        @JsonProperty(value = "jobTitle") val jobTitle: String,
        @JsonProperty(value = "department") val department: String,
        @JsonProperty(value = "company") val company: String,
        @JsonProperty(value = "positionStartDate") val positionStartDate: String,
        @JsonProperty(value = "positionEndDate") val positionEndDate: String,
        @JsonProperty(value = "jobDescription") val jobDescription: String
)