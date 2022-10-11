package za.ac.cput.service.entity.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.entity.Parent;
import za.ac.cput.factory.entity.ParentFactory;
import za.ac.cput.repository.entity.IParentRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ParentServiceImplTest {

    private Parent parent;
    @Autowired
    private ParentServiceImpl service;
    @Autowired @Mock
    private IParentRepository repository;

    @BeforeEach
    void setUp() {
        this.parent = ParentFactory.buildParent("test-id", "Tester", "TestSurname", "123 Test Street", "0234567899");
        this.service = new ParentServiceImpl(this.repository);
        Parent saved = this.service.save(this.parent);
        assertEquals(this.parent, saved);
    }

    @AfterEach
    void tearDown() {
        this.service.delete(this.parent);
        List<Parent> parentList = this.service.findAll();
        assertEquals(0, parentList.size());
    }

    @Test
    void read() {
        Optional<Parent> read = this.service.read(parent.getParentID());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(parent, read.get())
        );
    }

    @Test
    void findByParentID() {
        List<Parent> parentList = this.service.findAll();
        assertEquals(1, parentList.size());
    }

    @Test
    void deleteById() {
        this.service.deleteById(parent.getParentID());
        List<Parent> parentList = this.service.findAll();
        assertAll(
                () -> assertEquals(0, parentList.size())
        );
    }
}