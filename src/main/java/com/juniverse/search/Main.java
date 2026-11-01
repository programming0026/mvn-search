package com.juniverse.search;

import com.juniverse.search.algorithms.SearchBase;
import com.juniverse.search.algorithms.SearchFactory;
import com.juniverse.search.algorithms.TypesSearch;
import java.util.Arrays;
import java.util.Random;

import java.util.logging.Logger;
/**
 * Busca valores (únicos y repetidos) con búsqueda binaria y lineal e imprime las posiciones.
 *
 * @author linux
 */
public class Main {
    private static final Logger LOGGER = AppLogger.get(Main.class);


    /**
     * Ejecuta las cuatro pruebas de búsqueda.
     * @param args no se usan
     */
    public static void main(String[] args) {
        int[] nums = readNums(20);
        int key = nums[0];
        search(TypesSearch.BINARY_SEARCH, "==Busqueda Binaria==", nums, key);
     
        nums = repeatNums();
        key = nums[2];
        searchRepeat(TypesSearch.BINARY_SEARCH, "==Busqueda Binaria Repeticion==", nums, key);
        
        nums = readNums(20);
        key = nums[0];
        search(TypesSearch.LINEAR_SEARCH, "==Busqueda Lineal==", nums, key);
        
        
        nums = repeatNums();
        key = nums[0];
        searchRepeat(TypesSearch.LINEAR_SEARCH, "==Busqueda Lineal Repeticion==", nums, key);
        
    }
    
    /** Arreglo con valores repetidos para probar la búsqueda de varias coincidencias. */
    private static int[] repeatNums() {
        int nums[] = {1,1,4,500,4,2,3,4,5,0,4};
        return nums;
    }

    /**
     * Genera números aleatorios entre 0 y 99.
     * @param max cantidad de números
     */
    private static int[] readNums(int max) {
        int[] nums = new int[max];
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(100);
        }
        return nums;
    }

    /** Busca un valor y muestra su posición (ordena antes si el algoritmo es binario). */
    private static void search(TypesSearch type, String text, int[] nums, int key) {
        SearchBase searchBase = SearchFactory.createFactory(type);
        LOGGER.info(text);
        LOGGER.info("Datos introducidos:");
        searchBase.print(nums);
        LOGGER.info("Numero a buscar: " + key);
        if (type != TypesSearch.LINEAR_SEARCH) {
            Arrays.sort(nums);
        }
        int pos = searchBase.search(nums, key);
        if (pos >= 0) {
            LOGGER.info("El numero " + nums[pos] + " se encontro en la posicion: " + (pos + 1));
            searchBase.print(nums, pos);
        } else {
            LOGGER.info("Valor no encotrando");
        }
        
    }
    
    /** Busca todas las apariciones de un valor y las muestra (ordena antes si el algoritmo es binario). */
    private static void searchRepeat(TypesSearch type, String text, int[] nums, int key) {
        SearchBase searchBase = SearchFactory.createFactory(type);
        LOGGER.info(text);
        LOGGER.info("Datos introducidos:");
        searchBase.print(nums);
        LOGGER.info("Numero a buscar: " + key);
        if (type != TypesSearch.LINEAR_SEARCH) {
            Arrays.sort(nums);
        }
        
        Integer[] result = searchBase.searchList(nums, key);

        if (result.length > 0) {
            for (Integer index : result) {
                LOGGER.info("El numero " + nums[index] + " se encontro en la posicion: " + (index + 1));
            }
        } else {
            LOGGER.info("El valor no existe");
        }

        LOGGER.info("\nLos valores en el array son los siguientes: ");
        searchBase.print(nums, result);
    }
    
}
