package za.co.bsg.raindrops.repository

import org.springframework.data.jpa.repository.JpaRepository
import za.co.bsg.raindrops.model.dao.PersonalInfoDAO

interface StagedPersonalInfoRepository : JpaRepository<PersonalInfoDAO, Long> {
    fun getStagedPersonalInfoByUsername(username: String): PersonalInfoDAO?
}