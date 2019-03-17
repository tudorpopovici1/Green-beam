package server.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmissionReductionsTest {
    EmissionReductions emissionReduction=new EmissionReductions(0f, 0f, 0f, 0f, 0f);

    @Test
    public void getLocalProduceEmissionTest() {
        float emission1 = 1234;
        emissionReduction.setLocalProduceEmission(emission1);
        float setLocalProduceEmission = emissionReduction.getLocalProduceEmission();
        float expected = 1234;
        Assert.assertEquals(setLocalProduceEmission, expected,  0.0001);
    }

    @Test
    public void setLocalProduceEmissionTest() {
        float emission1 = 1234;
        emissionReduction.setLocalProduceEmission(emission1);
        float setLocalProduceEmission = emissionReduction.getLocalProduceEmission();
        float expected = 1234;
        Assert.assertEquals(setLocalProduceEmission, expected,  0.0001);
    }

    @Test
    public void setPublicTransportationEmissionTest() {
        float emission1 = 1234;
        emissionReduction.setPublicTransportationEmission(emission1);
        float setPublicTransportationEmission = emissionReduction.getPublicTransportationEmission();
        float expected = 1234;
        Assert.assertEquals(setPublicTransportationEmission, expected,  0.0001);
    }
    @Test
    public void getPublicTransportationEmissionTest() {
        float emission1 = 1234;
        emissionReduction.setPublicTransportationEmission(emission1);
        float setPublicTransportationEmission = emissionReduction.getPublicTransportationEmission();
        float expected = 1234;
        Assert.assertEquals(setPublicTransportationEmission, expected,  0.0001);
    }
    @Test
    public void setVegetarianMealEmissionTest() {
        float emission1 = 1234;
        emissionReduction.setVegetarianMealEmission(emission1);
        float setVegetarianMealEmission = emissionReduction.getVegetarianMealEmission();
        float expected = 1234;
        Assert.assertEquals(setVegetarianMealEmission, expected,  0.0001);
    }
    @Test
    public void getVegetarianMealEmissionTest() {
        float emission1 = 1234;
        emissionReduction.setVegetarianMealEmission(emission1);
        float setVegetarianMealEmission = emissionReduction.getVegetarianMealEmission();
        float expected = 1234;
        Assert.assertEquals(setVegetarianMealEmission, expected,  0.0001);
    }
    @Test
    public void getLoweringTemperatureEmissionTest() {
        float emission1 = 1234;
        emissionReduction.setLoweringTemperatureEmission(emission1);
        float setLoweringTemperatureEmission= emissionReduction.getLoweringTemperatureEmission();
        float expected = 1234;
        Assert.assertEquals(setLoweringTemperatureEmission, expected,  0.0001);
    }

    @Test
    public void setLoweringTemperatureEmissionTest() {
        float emission1 = 1234;
        emissionReduction.setLoweringTemperatureEmission(emission1);
        float setLoweringTemperatureEmission= emissionReduction.getLoweringTemperatureEmission();
        float expected = 1234;
        Assert.assertEquals(setLoweringTemperatureEmission, expected,  0.0001);
    }
    @Test
    public void setRideBikeEmissionTest() {
        float emission1 = 1234;
        emissionReduction.setRideBikeEmission(emission1);
        float setRideBikeEmission= emissionReduction.getRideBikeEmission();
        float expected = 1234;
        Assert.assertEquals(setRideBikeEmission, expected,  0.0001);
    }
    @Test
    public void getRideBikeEmissionTest() {
        float emission1 = 1234;
        emissionReduction.setRideBikeEmission(emission1);
        float setRideBikeEmission= emissionReduction.getRideBikeEmission();
        float expected = 1234;
        Assert.assertEquals(setRideBikeEmission, expected,  0.0001);
    }

    @Test
    public void toStringTest() {
        EmissionReductions emissionreduction = new EmissionReductions(1.2f, 3.4f, 5.6f, 7.8f, 9.0f);
        String expected = "EmissionReductions{rideBikeEmission=1.2, publicTransportationEmission=3.4, localProduceEmission=5.6, loweringTemperatureEmission=7.8, vegetarianMealEmission=9.0}";
        Assert.assertEquals(emissionreduction.toString(), expected);
    }

}