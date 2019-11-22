package za.co.bsg.raindrops.repository

import org.springframework.data.jpa.repository.JpaRepository
import za.co.bsg.raindrops.model.dao.LocationDAO

interface LocationRepository : JpaRepository<LocationDAO, Long> {
    fun getLocationDAOByBuildingId(buildingId: String): LocationDAO?
}