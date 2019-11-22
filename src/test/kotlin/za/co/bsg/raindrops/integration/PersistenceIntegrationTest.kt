package za.co.bsg.raindrops.integration

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import za.co.bsg.raindrops.model.dao.PersonalInfoDAO
import za.co.bsg.raindrops.repository.PersonalInfoRepository

@SpringBootTest
internal class PersistenceIntegrationTest(@Autowired val personalInfoRepository: PersonalInfoRepository) {

    @Test
    fun givenStagedPersonalInfo_whenSaved_thenFound() {
        val personalInfoToSave = PersonalInfoDAO("lmarch0", "E5940093", "ABSbn3Rm",
                "https://robohash.org/sedteneturnumquam.bmp?size=50x50&amp;set=set1", "Honorable",
                "Jr", "Lorilyn", "March", "Lorilyn March", "Female",
                "+55 502 816 2475")
        personalInfoRepository.save(personalInfoToSave)
        val personalInfoFound = personalInfoRepository.getPersonalInfoByUsername(personalInfoToSave.username)
        assert(personalInfoToSave == personalInfoFound)
    }
}