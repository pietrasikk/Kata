package org.kata.pointofsale;

import java.math.BigDecimal;

class PointOfSale {

    private static final String BARCODE_12345 = "12345";
    private static final String BARCODE_23456 = "23456";
    private static final String BARCODE_99999 = "99999";

    public BigDecimal scanBarcode(String... barcodes) {
        BigDecimal total = BigDecimal.ZERO;
        for (String barcode : barcodes) {
            if (barcode.equals(BARCODE_12345)) total = total.add(BigDecimal.valueOf(7.25));
            if (barcode.equals(BARCODE_23456)) total = total.add(BigDecimal.valueOf(12.50));
            if (barcode.equals(BARCODE_99999)) throw new IllegalArgumentException("Error: barcode not found");
            if (barcode.isBlank()) throw new IllegalArgumentException("Error: empty barcode");
        }
        return total;
    }
}
