package org.kata.pointofsale;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PointOfSaleTest {

    PointOfSale pointOfSale = new PointOfSale();

    @Test
    void shouldReturnSpecificPrice_whenPassBarcode12345() {
        String barcode = "12345";
        BigDecimal expectedResult = BigDecimal.valueOf(7.25);
        BigDecimal result = pointOfSale.scanBarcode(barcode);
        assertEquals(expectedResult, result);
    }

    @Test
    void shouldReturnSpecificPrice_whenPassBarcode23456() {
        String barcode = "23456";
        BigDecimal expectedResult = BigDecimal.valueOf(12.50);
        BigDecimal result = pointOfSale.scanBarcode(barcode);
        assertEquals(expectedResult, result);
    }

    @Test
    void shouldThrowError_whenPassBarcode99999() {
        String barcode = "99999";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> pointOfSale.scanBarcode(barcode));
        assertEquals("Error: barcode not found", exception.getMessage());
    }

    @Test
    void shouldThrowError_whenPassEmptyBarcode() {
        String barcode = "";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> pointOfSale.scanBarcode(barcode));
        assertEquals("Error: empty barcode", exception.getMessage());
    }

    @Test
    void shouldReturnCalculatedPrice_whenPassAtLeastTwoProperBarcodes() {
        String barcodeOne = "12345";
        String barcodeTwo = "23456";
        BigDecimal expectedResult = BigDecimal.valueOf(19.75);
        BigDecimal result = pointOfSale.scanBarcode(barcodeOne, barcodeTwo);
        assertEquals(expectedResult, result);
    }

    @Test
    void shouldThrowError_whenPassBarcode99999AndBarcode23456() {
        String barcodeOne = "23456";
        String barcodeTwo = "99999";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> pointOfSale.scanBarcode(barcodeOne, barcodeTwo));
        assertEquals("Error: barcode not found", exception.getMessage());
    }
}
