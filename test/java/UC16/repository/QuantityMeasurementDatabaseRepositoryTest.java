package com.app.quantitymeasurement.repository;

import com.app.quantitymeasurement.entity.QuantityModel;
import com.app.quantitymeasurement.entity.QuantityMeasurementEntity;
import com.app.quantitymeasurement.unit.LengthUnit;
import org.junit.*;

import java.util.List;

public class QuantityMeasurementDatabaseRepositoryTest {

    private QuantityMeasurementDatabaseRepository repository;

    @BeforeClass
    public static void setUpDatabase() {
        // Set test database environment
        System.setProperty("app.env", "test");
    }

    @Before
    public void setup() {
        repository = QuantityMeasurementDatabaseRepository.getInstance();
        repository.deleteAll(); // Clean database before each test
    }

    @After
    public void tearDown() {
        repository.deleteAll();
    }

    @Test
    public void testSaveEntity() {
        QuantityMeasurementEntity entity = createTestEntity();
        repository.save(entity);
        Assert.assertNotEquals(0, entity.getId());
        Assert.assertEquals(1, repository.getTotalCount());
    }

    @Test
    public void testGetAllMeasurements() {
        repository.save(createTestEntity());
        repository.save(createTestEntity());
        List<QuantityMeasurementEntity> result = repository.getAllMeasurements();
        Assert.assertEquals(2, result.size());
    }

    @Test
    public void testGetMeasurementsByOperation() {
        QuantityMeasurementEntity entity = createTestEntity();
        entity.operation = "COMPARE";
        repository.save(entity);
        
        List<QuantityMeasurementEntity> result = repository.getMeasurementsByOperation("COMPARE");
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("COMPARE", result.get(0).operation);
    }

    @Test
    public void testGetMeasurementsByType() {
        QuantityMeasurementEntity entity = createTestEntity();
        entity.thisMeasurementType = "LENGTH";
        repository.save(entity);
        
        List<QuantityMeasurementEntity> result = repository.getMeasurementsByType("LENGTH");
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("LENGTH", result.get(0).thisMeasurementType);
    }

    @Test
    public void testDeleteAll() {
        repository.save(createTestEntity());
        repository.deleteAll();
        Assert.assertEquals(0, repository.getTotalCount());
    }

    private QuantityMeasurementEntity createTestEntity() {
        QuantityModel<LengthUnit> q1 = new QuantityModel<>(1.0, LengthUnit.FEET);
        QuantityModel<LengthUnit> q2 = new QuantityModel<>(12.0, LengthUnit.INCHES);
        return new QuantityMeasurementEntity(q1, q2, "COMPARE", "Equal");
    }
}
