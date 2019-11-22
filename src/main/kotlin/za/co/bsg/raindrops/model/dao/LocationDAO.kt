package za.co.bsg.raindrops.model.dao

import javax.persistence.Entity

@Entity(name = "Location")
data class LocationDAO constructor(
        val buildingId: String,
        val buildingName: String,
        val streetNumber: String,
        val streetName: String,
        val streetType: String,
        val fullAddress: String,
        val postalCode: String,
        val city: String,
        val regionCode: String,
        val region: String,
        val countryCode: String,
        val country: String
) : Persistable<Long>()