package za.co.bsg.raindrops.repository

import org.springframework.data.jpa.repository.JpaRepository
import za.co.bsg.raindrops.model.dao.PersonalInfoDAO

interface PersonalInfoRepository : JpaRepository<PersonalInfoDAO, Long> {
    fun getPersonalInfoByUsername(username: String): PersonalInfoDAO?

    fun getAll(): List<PersonalInfoDAO>?
}