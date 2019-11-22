package za.co.bsg.raindrops.api

import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class PersonalInfoApiClient {

    fun getPersonalInfo(): String {
        val header = HttpHeaders()
        header.set("X-API-Key", ClientEndpoints.PERSONAL_INFO.key)
        val httpEntity = HttpEntity<String>(header)
        return RestTemplate()
                .exchange(ClientEndpoints.PERSONAL_INFO.uri, HttpMethod.GET, httpEntity, String::class.java)
                .body
                .toString()
    }
}