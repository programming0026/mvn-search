package com.juniverse.search.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Búsqueda binaria sobre un arreglo ORDENADO de menor a mayor. O(log n).
 *
 * @author Java Universe
 */
public class BinarySearch extends SearchBase {

    /**
     * Busca {@code key} (el arreglo debe estar ordenado).
     * @param nums arreglo ordenado
     * @param key valor a buscar
     * @return índice de alguna coincidencia o -1 si no existe
     */
    @Override
    public int search(int nums[], int key) {
        int mid;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            mid = left + (right - left) / 2;

            if (nums[mid] == key) {
                return mid;
            }

            if (nums[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Busca todas las apariciones de {@code key} (el arreglo debe estar ordenado).
     * @param nums arreglo ordenado
     * @param key valor a buscar
     * @return índices en orden ascendente; vacío si no existe
     */
    @Override
    public Integer[] searchList(int[] nums, int key) {
        List<Integer> pos = findAllOccurrences(nums, key);
        Integer[] res = new Integer[pos.size()];
        return pos.toArray(res);
    }

    /**
     * Localiza una coincidencia con búsqueda binaria y expande hacia ambos lados para recoger los repetidos.
     * @param arr arreglo ordenado
     * @param target valor a buscar
     */
    private List<Integer> findAllOccurrences(int[] arr, int target) {
        List<Integer> indices = new ArrayList<>();
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                int temp = mid;
                while (temp >= left && arr[temp] == target) {
                    indices.add(temp);
                    temp--;
                }

                temp = mid + 1;
                while (temp <= right && arr[temp] == target) {
                    indices.add(temp);
                    temp++;
                }
                
                break;
            }

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        Collections.sort(indices); // se recorrió hacia atrás desde el centro: se ordenan las posiciones
        return indices;
    }

}
