package za.co.bsg.raindrops.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import za.co.bsg.raindrops.repository.StagedPersonalInfoRepository

@Service
class PersonalInfoService @Autowired constructor(
        private val stagedPersonalInfoRepository: StagedPersonalInfoRepository) {

    fun callAndStagePersonalInfo(amount: Long) : Boolean {

        return true;
    }
}