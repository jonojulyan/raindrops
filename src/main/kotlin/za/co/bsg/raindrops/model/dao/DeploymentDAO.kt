package za.co.bsg.raindrops.model.dao

import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity

@Entity(name = "Deployment")
data class DeploymentDAO constructor(
        val jobTitle: String,
        val department: String,
        val company: String,
        val positionStartDate: LocalDate,
        val positionEndDate: LocalDate,
        @Column(columnDefinition = "TEXT") val jobDescription: String
) : Persistable<Long>()