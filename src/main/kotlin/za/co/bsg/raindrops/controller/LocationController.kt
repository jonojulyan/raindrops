package za.co.bsg.raindrops.controller

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import za.co.bsg.raindrops.model.dto.LocationDTO
import za.co.bsg.raindrops.service.LocationService

@RestController
@RequestMapping("/locations")
class LocationController @Autowired constructor(
        private val locationService: LocationService) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @GetMapping("/load")
    fun fullLoad(): ResponseEntity<String> {
        logger.debug("Endpoint hit to remotely call and store a list of Location objects")
        return try {
            locationService.getAndStoreLocation()
            ResponseEntity("Successfully fetched and loaded list of Location objects", HttpStatus.OK)
        } catch (e: Exception) {
            logger.error("Caught exception form LocationService: {}", e.message)
            ResponseEntity("Failed to fetched and load list of Location objects. Exception: ${e.message}",
                    HttpStatus.SERVICE_UNAVAILABLE)
        }
    }

    @GetMapping("/{buildingId}")
    fun getByBuildingId(@PathVariable(value = "buildingId") buildingId: String): ResponseEntity<LocationDTO> {
        logger.debug("Endpoint hit to return Location object with buildingId: {}", buildingId)
        return ResponseEntity(locationService.getLocation(buildingId), HttpStatus.OK)
    }

    @GetMapping("/")
    fun getAll(): ResponseEntity<List<LocationDTO>> {
        logger.debug("Endpoint hit to return all Location objects")
        return ResponseEntity(locationService.getAllLocation(), HttpStatus.OK)
    }
}
