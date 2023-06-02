package com.example.programmeringseksamensemester3.RepositoryTest;

import com.example.programmeringseksamensemester3.model.Sejlbåd;
import com.example.programmeringseksamensemester3.repository.SejlbådRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SejlbådTest {

    @Autowired
    private SejlbådRepository sejlbådRepository;

    @Test
    public void testSaveSejlbåd() {
        // Create a Sejlbåd instance
        Sejlbåd sejlbåd = new Sejlbåd();
        sejlbåd.setNavn("Boat1");
        sejlbåd.setBådtype("Type1");

        // Save the Sejlbåd
        Sejlbåd savedSejlbåd = sejlbådRepository.save(sejlbåd);

        // Verify the saved Sejlbåd has an ID
        assertNotNull(savedSejlbåd.getSejlbådId(), "Sejlbåd ID should not be null");

        // Retrieve the Sejlbåd from the repository
        Sejlbåd retrievedSejlbåd = sejlbådRepository.findById(savedSejlbåd.getSejlbådId()).orElse(null);

        // Verify the retrieved Sejlbåd is not null
        assertNotNull(retrievedSejlbåd, "Retrieved Sejlbåd should not be null");

        // Verify the retrieved Sejlbåd has the same attributes as the saved Sejlbåd
        assertEquals(savedSejlbåd.getNavn(), retrievedSejlbåd.getNavn(), "Sejlbåd Navn should match");
        assertEquals(savedSejlbåd.getBådtype(), retrievedSejlbåd.getBådtype(), "Sejlbåd Bådtype should match");
    }
}
