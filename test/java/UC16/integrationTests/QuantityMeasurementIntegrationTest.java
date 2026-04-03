package com.app.quantitymeasurement.integrationTests;

import com.app.quantitymeasurement.QuantityMeasurementApp;
import com.app.quantitymeasurement.controller.QuantityMeasurementController;
import com.app.quantitymeasurement.entity.QuantityDTO;
import com.app.quantitymeasurement.repository.IQuantityMeasurementRepository;
import org.junit.*;

public class QuantityMeasurementIntegrationTest {

    private QuantityMeasurementApp app;
    private QuantityMeasurementController controller;
    private IQuantityMeasurementRepository repository;

    @BeforeClass
    public static void setUpTestEnvironment() {
        System.setProperty("app.env", "test");
    }

    @Before
    public void setup() {
        app = QuantityMeasurementApp.getInstance();
        controller = app.getController();
        repository = app.getRepository();
        repository.deleteAll();
    }

    @After
    public void tearDown() {
        repository.deleteAll();
    }

    @Test
    public void testEndToEngLengthComparison() {
        QuantityDTO q1 = new QuantityDTO(1.0, QuantityDTO.LengthUnit.FEET.getUnitName(), QuantityDTO.LengthUnit.FEET.getMeasurementType());
        QuantityDTO q2 = new QuantityDTO(12.0, QuantityDTO.LengthUnit.INCHES.getUnitName(), QuantityDTO.LengthUnit.INCHES.getMeasurementType());
        
        boolean result = controller.performComparison(q1, q2);
        
        Assert.assertTrue(result);
        Assert.assertEquals(1, repository.getTotalCount());
    }

    @Test
    public void testEndToEndTemperatureConversion() {
        QuantityDTO thisDto = new QuantityDTO(0.0, QuantityDTO.TemperatureUnit.CELSIUS.getUnitName(), QuantityDTO.TemperatureUnit.CELSIUS.getMeasurementType());
        QuantityDTO thatDto = new QuantityDTO(32.0, QuantityDTO.TemperatureUnit.FAHRENHEIT.getUnitName(), QuantityDTO.TemperatureUnit.FAHRENHEIT.getMeasurementType());
        
        QuantityDTO resultDTO = controller.performConversion(thisDto, thatDto);
        
        Assert.assertNotNull(resultDTO);
        Assert.assertEquals(32.0, resultDTO.getValue(), 0.01);
        Assert.assertEquals(1, repository.getTotalCount());
    }

    @Test
    public void testRepositoryPersistenceAcrossOperations() {
        QuantityDTO q1 = new QuantityDTO(5.0, QuantityDTO.LengthUnit.FEET.getUnitName(), QuantityDTO.LengthUnit.FEET.getMeasurementType());
        QuantityDTO q2 = new QuantityDTO(5.0, QuantityDTO.LengthUnit.FEET.getUnitName(), QuantityDTO.LengthUnit.FEET.getMeasurementType());
        
        controller.performAddition(q1, q2);
        controller.performComparison(q1, q2);
        
        Assert.assertEquals(2, repository.getTotalCount());
    }
}
