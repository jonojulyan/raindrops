package za.co.bsg.raindrops.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import za.co.bsg.raindrops.api.DeploymentApiClient
import za.co.bsg.raindrops.model.dto.DeploymentDTO
import za.co.bsg.raindrops.model.dto.PersonalInfoDTO
import za.co.bsg.raindrops.model.mapper.DeploymentMapper
import za.co.bsg.raindrops.repository.DeploymentRepository

@Service
class DeploymentService @Autowired constructor(
        private val deploymentMapper: DeploymentMapper,
        private val deploymentApiClient: DeploymentApiClient,
        private val deploymentRepository: DeploymentRepository) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @Throws(Exception::class)
    fun getAndStoreDeployments() {
        return try {
            logger.debug("Attempting to call and then store Deployment objects")
            val deploymentDTOList: List<DeploymentDTO> = ObjectMapper().readValue(deploymentApiClient.getDeployments())
            deploymentRepository.saveAll(deploymentMapper.toDAO(deploymentDTOList))
            logger.debug("Successfully called and then stored Deployment objects")
        } catch (e: Exception) {
            logger.error(e.message)
            throw e
        }
    }

    fun getAllDeployments(): List<DeploymentDTO>? {
        logger.debug("Attempting to retrieve all Deployment objects from data store")
        return deploymentMapper.toDTO(deploymentRepository.findAll())
    }
}