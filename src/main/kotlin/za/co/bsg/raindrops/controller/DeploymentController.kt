package za.co.bsg.raindrops.controller

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import za.co.bsg.raindrops.model.dto.DeploymentDTO
import za.co.bsg.raindrops.service.DeploymentService

@RestController
@RequestMapping("/deployments")
class DeploymentController @Autowired constructor(
        private val deploymentService: DeploymentService) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @GetMapping("/load")
    fun fullLoad(): ResponseEntity<String> {
        logger.debug("Endpoint hit to remotely call and store a list of Deployment objects")
        return try {
            deploymentService.getAndStoreDeployments()
            ResponseEntity("Successfully fetched and loaded list of Deployment objects", HttpStatus.OK)
        } catch (e: Exception) {
            logger.error("Caught exception form DeploymentService: {}", e.message)
            ResponseEntity("Failed to fetched and load list of Deployment objects. Exception: ${e.message}",
                    HttpStatus.SERVICE_UNAVAILABLE)
        }
    }

    @GetMapping("/")
    fun getAll(): ResponseEntity<List<DeploymentDTO>> {
        logger.debug("Endpoint hit to return all Deployment objects")
        return ResponseEntity(deploymentService.getAllDeployments(), HttpStatus.OK)
    }
}
