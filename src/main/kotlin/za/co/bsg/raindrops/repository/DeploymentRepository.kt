package za.co.bsg.raindrops.repository

import org.springframework.data.jpa.repository.JpaRepository
import za.co.bsg.raindrops.model.dao.DeploymentDAO

interface DeploymentRepository : JpaRepository<DeploymentDAO, Long> {
}