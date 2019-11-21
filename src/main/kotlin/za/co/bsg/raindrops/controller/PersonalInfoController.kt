package za.co.bsg.raindrops.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import za.co.bsg.raindrops.api.PersonalInfoApiClient

@RestController
@RequestMapping("/personalInfo")
class PersonalInfoController @Autowired constructor(
        private val personalInfoApiClient: PersonalInfoApiClient) {

    @GetMapping("/load")
    fun fullLoad(@RequestParam(name = "amount", value = "amount", required = false, defaultValue = "1000") amount: Long) : ResponseEntity<String> {
        personalInfoApiClient.getPersonalInfo();
        return ResponseEntity(HttpStatus.OK)
    }

    @GetMapping("/load/{id}")
    fun loadById(@PathVariable(value = "id") jobId: Long) : ResponseEntity<String> {
        return ResponseEntity(HttpStatus.OK)
    }

    @GetMapping("/stage")
    fun stageOnly(@RequestParam(name = "amount", value = "amount", required = false, defaultValue = "1000") amount: Long) : ResponseEntity<String> {
        return ResponseEntity(HttpStatus.OK)
    }
}
