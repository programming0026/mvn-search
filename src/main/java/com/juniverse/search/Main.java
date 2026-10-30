package com.juniverse.search;

import com.juniverse.search.algorithms.SearchBase;
import com.juniverse.search.algorithms.SearchFactory;
import com.juniverse.search.algorithms.TypesSearch;
import java.util.Arrays;
import java.util.Random;

/**
 * Busca valores (únicos y repetidos) con búsqueda binaria y lineal e imprime las posiciones.
 *
 * @author linux
 */
public class Main {

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
        SearchBase searchtBase = SearchFactory.createFactory(type);
        System.out.println(text);
        System.out.println("Datos introducidos:");
        searchtBase.print(nums);
        System.out.println("Numero a buscar: " + key);
        if (type != TypesSearch.LINEAR_SEARCH) {
            Arrays.sort(nums);
        }
        int pos = searchtBase.search(nums, key);
        if (pos >= 0) {
            System.out.println("El numero " + nums[pos] + " se encontro en la posicion: " + (pos + 1));
            searchtBase.print(nums, pos);
        } else {
            System.out.println("Valor no encotrando");
        }
        
    }
    
    /** Busca todas las apariciones de un valor y las muestra (ordena antes si el algoritmo es binario). */
    private static void searchRepeat(TypesSearch type, String text, int[] nums, int key) {
        SearchBase searchtBase = SearchFactory.createFactory(type);
        System.out.println(text);
        System.out.println("Datos introducidos:");
        searchtBase.print(nums);
        System.out.println("Numero a buscar: " + key);
        if (type != TypesSearch.LINEAR_SEARCH) {
            Arrays.sort(nums);
        }
        
        Integer[] result = searchtBase.searchList(nums, key);

        if (result.length > 0) {
            for (Integer index : result) {
                System.out.println("El numero " + nums[index] + " se encontro en la posicion: " + (index + 1));
            }
        } else {
            System.out.println("El valor no existe");
        }

        System.out.println("\nLos valores en el array son los siguientes: ");
        searchtBase.print(nums, result);
    }
    
}
