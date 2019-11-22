package za.co.bsg.raindrops.model

import org.springframework.stereotype.Component
import za.co.bsg.raindrops.model.dao.PersonalInfoDAO
import za.co.bsg.raindrops.model.dto.PersonalInfoDTO

@Component
class PersonalInfoMapper {
    fun toDAO(personalInfoDTO: PersonalInfoDTO): PersonalInfoDAO =
            PersonalInfoDAO(personalInfoDTO.username, personalInfoDTO.employeeId, personalInfoDTO.alternateEmployeeId,
                    personalInfoDTO.profilePic, personalInfoDTO.title, personalInfoDTO.suffix, personalInfoDTO.firstName,
                    personalInfoDTO.lastName, personalInfoDTO.fullName, personalInfoDTO.gender, personalInfoDTO.mobileNumber)

    fun toDAO(personalInfoDTOList: List<PersonalInfoDTO>): List<PersonalInfoDAO> {
        val personalInfoDAOList = mutableListOf<PersonalInfoDAO>()
        for (personalInfoDTO in personalInfoDTOList) {
            personalInfoDAOList.add(toDAO(personalInfoDTO))
        }
        return personalInfoDAOList
    }

    fun toDTO(personalInfoDAO: PersonalInfoDAO): PersonalInfoDTO {
        var personalInfoId = 0L
        if (personalInfoDAO.getId() != null) {
            personalInfoId = personalInfoDAO.getId()!!
        }
        return PersonalInfoDTO(personalInfoId, personalInfoDAO.username, personalInfoDAO.employeeId, personalInfoDAO.alternateEmployeeId,
                personalInfoDAO.profilePic, personalInfoDAO.title, personalInfoDAO.suffix, personalInfoDAO.firstName,
                personalInfoDAO.lastName, personalInfoDAO.fullName, personalInfoDAO.gender, personalInfoDAO.mobileNumber)
    }

    fun toDTO(personalInfoDAOList: List<PersonalInfoDAO>): List<PersonalInfoDTO> {
        val personalInfoDTOList = mutableListOf<PersonalInfoDTO>()
        for (personalInfoDAO in personalInfoDAOList) {
            personalInfoDTOList.add(toDTO(personalInfoDAO))
        }
        return personalInfoDTOList
    }
}