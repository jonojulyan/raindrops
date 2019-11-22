package za.co.bsg.raindrops.model.mapper

import org.springframework.stereotype.Component
import za.co.bsg.raindrops.model.dao.LocationDAO
import za.co.bsg.raindrops.model.dto.LocationDTO

@Component
class LocationMapper {
    fun toDAO(locationDTO: LocationDTO): LocationDAO =
            LocationDAO(locationDTO.buildingId, locationDTO.buildingName, locationDTO.streetNumber,
                    locationDTO.streetName, locationDTO.streetType, locationDTO.fullAddress, locationDTO.postalCode,
                    locationDTO.city, locationDTO.regionCode, locationDTO.region, locationDTO.countryCode, locationDTO.country)

    fun toDAO(locationDTOList: List<LocationDTO>): List<LocationDAO> {
        val locationDAOList = mutableListOf<LocationDAO>()
        for (locationDTO in locationDTOList) {
            locationDAOList.add(toDAO(locationDTO))
        }
        return locationDAOList
    }

    fun toDTO(locationDAO: LocationDAO): LocationDTO {
        var locationId = 0L
        if (locationDAO.getId() != null) {
            locationId = locationDAO.getId()!!
        }
        return LocationDTO(locationId, locationDAO.buildingId, locationDAO.buildingName, locationDAO.streetNumber,
                locationDAO.streetName, locationDAO.streetType, locationDAO.fullAddress, locationDAO.postalCode,
                locationDAO.city, locationDAO.regionCode, locationDAO.region, locationDAO.countryCode, locationDAO.country)
    }

    fun toDTO(locationDAOList: List<LocationDAO>): List<LocationDTO> {
        val locationDTOList = mutableListOf<LocationDTO>()
        for (locationDAO in locationDAOList) {
            locationDTOList.add(toDTO(locationDAO))
        }
        return locationDTOList
    }
}