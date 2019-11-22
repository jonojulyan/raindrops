package za.co.bsg.raindrops.controller

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import za.co.bsg.raindrops.model.dto.PersonalInfoDTO
import za.co.bsg.raindrops.service.PersonalInfoService

@RestController
@RequestMapping("/personalInfo")
class PersonalInfoController @Autowired constructor(
        private val personalInfoService: PersonalInfoService) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @GetMapping("/load")
    fun fullLoad(): ResponseEntity<String> {
        logger.debug("Endpoint hit to remotely call and store a list of PersonalInfo objects")
        return try {
            personalInfoService.getAndStorePersonalInfo()
            ResponseEntity("Successfully fetched and loaded list of PersonalInfo objects", HttpStatus.OK)
        } catch (e: Exception) {
            logger.error("Caught exception form PersonalInfoService: {}", e.message)
            ResponseEntity("Failed to fetched and load list of PersonalInfo objects. Exception: ${e.message}",
                    HttpStatus.SERVICE_UNAVAILABLE)
        }
    }

    @GetMapping("/{username}")
    fun getByUsername(@PathVariable(value = "username") username: String): ResponseEntity<PersonalInfoDTO> {
        logger.debug("Endpoint hit to return PersonalInfo object with username: {}", username)
        return ResponseEntity(personalInfoService.getPersonalInfoByUsername(username), HttpStatus.OK)
    }

    @GetMapping("/")
    fun getAll(): ResponseEntity<List<PersonalInfoDTO>> {
        logger.debug("Endpoint hit to return all PersonalInfo objects")
        return ResponseEntity(personalInfoService.getAllPersonalInfo(), HttpStatus.OK)
    }
}
