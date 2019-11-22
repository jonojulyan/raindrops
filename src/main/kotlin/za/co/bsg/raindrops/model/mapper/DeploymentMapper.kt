package za.co.bsg.raindrops.model.mapper

import org.springframework.stereotype.Component
import za.co.bsg.raindrops.model.dao.DeploymentDAO
import za.co.bsg.raindrops.model.dto.DeploymentDTO
import java.time.LocalDate

@Component
class DeploymentMapper {
    fun toDAO(deploymentDTO: DeploymentDTO): DeploymentDAO =
            DeploymentDAO(deploymentDTO.jobTitle, deploymentDTO.department, deploymentDTO.company,
                    LocalDate.parse(deploymentDTO.positionStartDate), LocalDate.parse(deploymentDTO.positionEndDate), deploymentDTO.jobDescription)

    fun toDAO(deploymentDTOList: List<DeploymentDTO>): List<DeploymentDAO> {
        val deploymentDAOList = mutableListOf<DeploymentDAO>()
        for (deploymentDTO in deploymentDTOList) {
            deploymentDAOList.add(toDAO(deploymentDTO))
        }
        return deploymentDAOList
    }

    fun toDTO(deploymentDAO: DeploymentDAO): DeploymentDTO {
        var deploymentId = 0L
        if (deploymentDAO.getId() != null) {
            deploymentId = deploymentDAO.getId()!!
        }
        return DeploymentDTO(deploymentId, deploymentDAO.jobTitle, deploymentDAO.department, deploymentDAO.company,
                deploymentDAO.positionStartDate.toString(), deploymentDAO.positionEndDate.toString(), deploymentDAO.jobDescription)
    }

    fun toDTO(deploymentDAOList: List<DeploymentDAO>): List<DeploymentDTO> {
        val deploymentDTOList = mutableListOf<DeploymentDTO>()
        for (deploymentDAO in deploymentDAOList) {
            deploymentDTOList.add(toDTO(deploymentDAO))
        }
        return deploymentDTOList
    }
}