package com.juniverse.search.algorithms;

import java.text.DecimalFormat;

import java.util.logging.Logger;
import com.juniverse.search.AppLogger;
import java.util.Arrays;
/**
 * Clase base de los algoritmos de búsqueda de enteros y de las utilidades para mostrar resultados.
 *
 * @author Java Universe
 */
public abstract class SearchBase {
    private static final Logger LOGGER = AppLogger.get(SearchBase.class);



    /**
     * Busca todas las apariciones de un valor.
     * @param nums arreglo donde buscar
     * @param key valor a buscar
     * @return índices encontrados
     */
    public abstract Integer[] searchList(int[] nums, int key);
    
    /**
     * Busca un valor.
     * @param nums arreglo donde buscar
     * @param key valor a buscar
     * @return índice o -1 si no existe
     */
    public abstract int search(int nums[], int key);

    /**
     * Imprime los elementos en una línea.
     * @param nums arreglo a mostrar
     */
    public void print(int nums[]) {
        LOGGER.info(Arrays.toString(nums));
        LOGGER.info("");
    }

    /**
     * Imprime el arreglo con su posición (base 1) y marca la fila encontrada con una flecha.
     * @param nums arreglo a mostrar
     * @param pos índice a resaltar
     */
    public void print(int nums[], int pos) {
        LOGGER.info("Array    Posicion");
        DecimalFormat d = new DecimalFormat("00");

        for (int i = 0; i < nums.length; i++) {
            if (i == pos) {
                LOGGER.info(d.format(nums[i]) + "  -->  " + d.format((i + 1)));
            } else {
                LOGGER.info(d.format(nums[i]) + "       " + d.format((i + 1)));
            }
        }
    }

    /**
     * Imprime el arreglo con su posición (base 1) y marca todas las filas encontradas.
     * @param nums arreglo a mostrar
     * @param pos índices a resaltar
     */
    public void print(int nums[], Integer pos[]) {
        LOGGER.info("Array    Posicion");
        DecimalFormat d = new DecimalFormat("00");
        boolean bFind;
        for (int i = 0; i < nums.length; i++) {
            bFind = false;
            for (int j = 0; j < pos.length; j++) {
                if (i == pos[j]) {
                    LOGGER.info(d.format(nums[i]) + "  -->  " + d.format((i + 1)));
                    bFind = true;
                }
            }
            if (!bFind) {
                LOGGER.info(d.format(nums[i]) + "       " + d.format((i + 1)));
            }
        }
    }
}
