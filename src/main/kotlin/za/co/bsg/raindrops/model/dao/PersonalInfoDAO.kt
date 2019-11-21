package za.co.bsg.raindrops.model.dao

import za.co.bsg.raindrops.model.dao.Persistable
import javax.persistence.Entity

@Entity
data class PersonalInfoDAO @JvmOverloads constructor (
        val username: String,
        val employeeId: String,
        val alternateEmployeeId: String,
        val profilePic: String,
        val title: String,
        val suffix: String,
        val firstName: String,
        val lastName: String,
        val fullName: String,
        val gender: String,
        val mobileNumber: String
) : Persistable<Long>()