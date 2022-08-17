package za.ac.cput.service.lookup.Impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.lookup.ParentChild;
import za.ac.cput.factory.lookup.ParentChildFactory;
import za.ac.cput.repository.lookup.IParentChildRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ParentChildServiceImplTest {
    private ParentChild parentChild;
    @Autowired
    private ParentChildServiceImpl service;
    @Autowired @Mock
    private IParentChildRepository repository;

    @BeforeEach
    void setUp() {
        this.parentChild = ParentChildFactory.buildParentChild("test-parent-id", "test-child-id");
        this.service = new ParentChildServiceImpl(this.repository);
        ParentChild saved = this.service.save(this.parentChild);
        assertEquals(this.parentChild, saved);
    }

    @AfterEach
    void tearDown() {
        this.service.delete(this.parentChild);
        List<ParentChild> parentChildList = this.service.findAll();
        assertEquals(0, parentChildList.size());
    }

    @Test
    void read() {
        Optional<ParentChild> read = this.service.read(new ParentChild.ParentChildID(parentChild.getParentID(), parentChild.getChildID()));
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(parentChild, read.get())
        );
    }

    @Test
    void findByParentChildID() {
        List<ParentChild> parentChildList = this.service.findAll();
        assertEquals(1, parentChildList.size());
    }

    @Test
    void deleteById() {
        this.service.deleteById(new ParentChild.ParentChildID(parentChild.getParentID(), parentChild.getChildID()));
        List<ParentChild> parentChildList = this.service.findAll();
        assertAll(
                () -> assertEquals(0, parentChildList.size())
        );
    }
}