package za.co.bsg.raindrops.model.dto

import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "personal_info")
data class PersonalInfoListDTO @JvmOverloads constructor(
        @XmlElement(name = "person")
        var personInfoDTO: Any
)