package za.co.bsg.raindrops.api

import com.fasterxml.jackson.dataformat.xml.XmlMapper
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import za.co.bsg.raindrops.model.dto.PersonalInfoDTO
import za.co.bsg.raindrops.model.dto.PersonalInfoListDTO


@Service
class PersonalInfoApiClient {

    fun getPersonalInfo(): List<PersonalInfoDTO> {
        val url: String = "https://my.api.mockaroo.com/personalInfo.json"
        val header = HttpHeaders()
        header.set("X-API-Key", "83c86d70")
        val httpEntity = HttpEntity<String>(header)

        val restTemplate = RestTemplate()
        val responseString = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String::class.java)
//
//        val responseString = RestTemplate().getForObject("" ,String::class.java)
        val personalInfoObject = XmlMapper().readValue(responseString, PersonalInfoListDTO::class.java)

        return emptyList()
    }
}