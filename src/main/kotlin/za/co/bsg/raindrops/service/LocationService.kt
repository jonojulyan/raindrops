package za.co.bsg.raindrops.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import za.co.bsg.raindrops.api.LocationApiClient
import za.co.bsg.raindrops.model.mapper.LocationMapper
import za.co.bsg.raindrops.model.dto.LocationDTO
import za.co.bsg.raindrops.repository.LocationRepository

@Service
class LocationService @Autowired constructor(
        private val locationMapper: LocationMapper,
        private val locationApiClient: LocationApiClient,
        private val locationRepository: LocationRepository) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @Throws(Exception::class)
    fun getAndStoreLocation() {
        return try {
            logger.debug("Attempting to call and then store Location objects")
            val locationDTOList: List<LocationDTO> = ObjectMapper().readValue(locationApiClient.getLocation())
            locationRepository.saveAll(locationMapper.toDAO(locationDTOList))
            logger.debug("Successfully called and then stored Location objects")
        } catch (e: Exception) {
            logger.error(e.message)
            throw e
        }
    }

    fun getLocation(buildingId: String): LocationDTO? {
        logger.debug("Attempting to retrieve Location with buildingId - {} from data store", buildingId)
        return locationRepository.getLocationDAOByBuildingId(buildingId)?.let { locationMapper.toDTO(it) }
    }

    fun getAllLocation(): List<LocationDTO>? {
        logger.debug("Attempting to retrieve all Location objects from data store")
        return locationMapper.toDTO(locationRepository.findAll())
    }
}