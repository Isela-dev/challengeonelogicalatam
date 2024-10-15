
package com.clases.divisa;

import com.service.ProveedorAPI;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class PesoMexicano implements divisas {

    private String claveDivisa;
    private BigDecimal importe;

    public PesoMexicano(BigDecimal importe) {
        if (importe == null) {
            throw new NullPointerException("Valor nulo.");
        }

        if (esImporteInvalido(importe)) {
            throw new IllegalArgumentException("No puede ser menor o igual a cero.");
        }
        this.claveDivisa = CLAVE_DIVISA_MEXICO;
        this.importe = importe;
    }

    /**
     * @return the claveDivisa
     */
    public String getClaveDivisa() {
        return claveDivisa;
    }

    /**
     * @return the importe
     */
    public BigDecimal getImporte() {
        return importe;
    }

    private boolean esImporteInvalido(BigDecimal importe) {
        if (importe.signum() == -1) {
            return true;
        } else if (importe.signum() == 0) {
            return true;
        }
        return false;
    }


    private BigDecimal calcularPrecioMonedaLocal(BigDecimal importeUsuario, BigDecimal importeEquivalente) {
        return importeUsuario.divide(importeEquivalente, 2, RoundingMode.FLOOR);
    }


    private BigDecimal calcularPrecioMonedaExtranjera(BigDecimal importeUsuario, BigDecimal importeEquivalente) {
        return importeUsuario.multiply(importeEquivalente).setScale(2, RoundingMode.FLOOR);
    }

    private BigDecimal getEquivalencia(String claveCambio) {
        return ProveedorAPI.valorDivisaExchangeRatesAPI(this.getClaveDivisa(), claveCambio);
    }


    private String extraerClave(String descripcionConversion) {
        if (descripcionConversion.contains(CLAVE_DIVISA_USA)) {
            descripcionConversion = CLAVE_DIVISA_USA;
        } else if (descripcionConversion.contains(CLAVE_DIVISA_GRAN_BRETANA)) {
            descripcionConversion = CLAVE_DIVISA_GRAN_BRETANA;
        } else if (descripcionConversion.contains(CLAVE_DIVISA_EUROPA)) {
            descripcionConversion = CLAVE_DIVISA_EUROPA;
        } else if (descripcionConversion.contains(CLAVE_DIVISA_WON)) {
            descripcionConversion = CLAVE_DIVISA_WON;
        } else if (descripcionConversion.contains(CLAVE_DIVISA_YEN_JAPONESA)) {
            descripcionConversion = CLAVE_DIVISA_YEN_JAPON;
        }
        return descripcionConversion;
    }


}
