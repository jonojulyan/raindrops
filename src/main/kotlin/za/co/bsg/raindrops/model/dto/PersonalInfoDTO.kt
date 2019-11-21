package za.co.bsg.raindrops.model.dto

import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "person")
data class PersonalInfoDTO @JvmOverloads constructor(
        @XmlElement(name = "username") val username: String,
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
)