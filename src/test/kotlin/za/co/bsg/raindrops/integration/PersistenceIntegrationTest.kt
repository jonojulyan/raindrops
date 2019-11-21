package za.co.bsg.raindrops.integration

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import za.co.bsg.raindrops.model.dao.PersonalInfoDAO
import za.co.bsg.raindrops.repository.StagedPersonalInfoRepository

@SpringBootTest
internal class PersistenceIntegrationTest(@Autowired val stagedPersonalInfoRepository: StagedPersonalInfoRepository) {

    @Test
    fun givenStagedPersonalInfo_whenSaved_thenFound() {
        val personalInfoToSave = PersonalInfoDAO("lmarch0", "E5940093", "ABSbn3Rm",
                "https://robohash.org/sedteneturnumquam.bmp?size=50x50&amp;set=set1", "Honorable",
                "Jr", "Lorilyn", "March", "Lorilyn March", "Female",
                "+55 502 816 2475")
        stagedPersonalInfoRepository.save(personalInfoToSave)
        val personalInfoFound = stagedPersonalInfoRepository.getStagedPersonalInfoByUsername(personalInfoToSave.username)
        assert(personalInfoToSave == personalInfoFound)
    }
}