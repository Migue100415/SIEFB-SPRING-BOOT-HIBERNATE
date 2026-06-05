package model.enums;

public enum TipoMovimiento {
	ENTRADA("Ingreso de dinero"),
    SALIDA("Salida de dinero");

    private final String descripcion;

    TipoMovimiento(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
