package com.juniverse.search.algorithms;

/**
 * Fábrica que crea el algoritmo de búsqueda según {@link TypesSearch}.
 *
 * @author linux
 */
public final class SearchFactory {

    /** Clase de utilidades: no se instancia. */
    private SearchFactory() {

    }

    /**
     * Crea el algoritmo pedido.
     * @param type algoritmo
     * @throws IllegalArgumentException si el tipo no es válido
     */
    public static SearchBase createFactory(TypesSearch type) {
        switch (type) {            
            case BINARY_SEARCH -> {
                return new BinarySearch();
            }
            case LINEAR_SEARCH -> {
                return new LinearSearch();
            }
            default -> throw new IllegalArgumentException("La opcion no es valida");
        }
    }
}
