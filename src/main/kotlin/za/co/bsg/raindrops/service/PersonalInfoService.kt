package za.co.bsg.raindrops.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import za.co.bsg.raindrops.api.PersonalInfoApiClient
import za.co.bsg.raindrops.model.mapper.PersonalInfoMapper
import za.co.bsg.raindrops.model.dto.PersonalInfoDTO
import za.co.bsg.raindrops.repository.PersonalInfoRepository

@Service
class PersonalInfoService @Autowired constructor(
        private val personalInfoMapper: PersonalInfoMapper,
        private val personalInfoApiClient: PersonalInfoApiClient,
        private val personalInfoRepository: PersonalInfoRepository) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @Throws(Exception::class)
    fun getAndStorePersonalInfo() {
        return try {
            logger.debug("Attempting to call and then store PersonalInfo objects")
            val personInfoDTOList: List<PersonalInfoDTO> = ObjectMapper().readValue(personalInfoApiClient.getPersonalInfo())
            personalInfoRepository.saveAll(personalInfoMapper.toDAO(personInfoDTOList))
            logger.debug("Successfully called and then stored PersonalInfo objects")
        } catch (e: Exception) {
            logger.error(e.message)
            throw e
        }
    }

    fun getPersonalInfo(username: String): PersonalInfoDTO? {
        logger.debug("Attempting to retrieve PersonalInfo with username - {} from data store", username)
        return personalInfoRepository.getPersonalInfoByUsername(username)?.let { personalInfoMapper.toDTO(it) }
    }

    fun getAllPersonalInfo(): List<PersonalInfoDTO>? {
        logger.debug("Attempting to retrieve all PersonalInfo objects from data store")
        return personalInfoMapper.toDTO(personalInfoRepository.findAll())
    }
}