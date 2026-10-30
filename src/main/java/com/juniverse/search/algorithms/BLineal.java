package com.juniverse.search.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Búsqueda lineal: recorre el arreglo de principio a fin. Funciona con datos sin ordenar. O(n).
 *
 * @author linux
 */
public class BLineal extends SearchBase {

    /**
     * Devuelve el índice de la primera coincidencia.
     * @param nums arreglo (no necesita estar ordenado)
     * @param key valor a buscar
     * @return índice o -1 si no existe
     */
    @Override
    public int search(int[] nums, int key) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Devuelve los índices de todas las coincidencias.
     * @param nums arreglo (no necesita estar ordenado)
     * @param key valor a buscar
     * @return índices en orden ascendente; vacío si no existe
     */
    @Override
    public Integer[] searchList(int[] nums, int key) {
        List<Integer> pos = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                pos.add(i);
            }
        }
        Integer[] res = new Integer[pos.size()];
        return pos.toArray(res);
    }

}
