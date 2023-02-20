package org.example;


import org.example.heapsort.HeapSort;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.exit;
import static java.lang.System.in;
import static org.example.bruitforcesearch.BruteForceSearch.linearSearch;


public class Main {
    public static void main(String args[])
    {
        int option = 0;
        while (option != 3){
            System.out.println("Escoja una opcion:\n\t1) HeapSort.\n\t2) Bruit Force Search.\n\t3) Salir.\n");
            Scanner cs = new Scanner(System.in);
            String input =  cs.nextLine();

            option = validateInt(input);
            switch (option) {
                case 1 -> Sort();
                case 2 -> Search();
                case 3 -> exit(0);
                default -> System.out.println("Opcion incorrecta");
            }
        }
    }

    @SuppressWarnings({"Duplicates"})
    private static void Sort(){
        int option = 0;
        while (option != 4){
            System.out.println("Seleccione una opcion:\n\t1) Array al azar.\n\t2) Ingrese los numeros ud.\n\t3) Regresar al menu.\n\t4) Salir.");
            Scanner cs = new Scanner(System.in);
            String input =  cs.nextLine();
            option = validateInt(input);
            switch (option) {
                case 1 -> {
                    System.out.println("Ingrese el tamano del array:\n");
                    input = cs.nextLine();
                    int size = validateInt(input);
                    if (size == -1){
                        continue;
                    }
                    int[] arr = new int[size];
                    Random random = new Random(); // create a Random object
                    for (int i = 0; i < arr.length; i++) {
                        arr[i] = random.nextInt(10000); // assign a random number to each element
                    }

                    System.out.println("El arreglo desordenado es");
                    HeapSort.printArray(arr);
                    System.out.println();

                    HeapSort.sort(arr);
                    System.out.println("El arreglo ordenado es");
                    HeapSort.printArray(arr);
                    System.out.println();
                }
                case 2 -> {
                    System.out.println("Ingrese los numeros uno a uno, al finalizar ingrese cualquier numero negativo:\n");
                    ArrayList<Integer> list = new ArrayList<>();
                    input = cs.nextLine();
                    int num = validateInt(input);
                    while (num != -1){
                        list.add(num);
                        input = cs.nextLine();
                        num = validateInt(input);
                    }
                    int[] arr = list.stream().mapToInt(i -> i).toArray();


                    System.out.println("El arreglo desordenado es");
                    HeapSort.printArray(arr);
                    System.out.println();


                    HeapSort.sort(arr);
                    System.out.println("El arreglo ordenado es");
                    HeapSort.printArray(arr);
                    System.out.println();
                }
                case 3 -> {
                    return;
                }
                case 4 -> exit(0);
                default -> System.out.println("Opcion incorrecta");
            }
        }
    }

    @SuppressWarnings({"Duplicates"})
    private static void Search(){
        int option = 0;
        while (option != 4){
            System.out.println("Seleccione una opcion:\n\t1) Array al azar.\n\t2) Ingrese los numeros ud.\n\t3) Regresar al menu.\n\t4) Salir.");
            Scanner cs = new Scanner(System.in);
            String input =  cs.nextLine();
            option = validateInt(input);
            switch (option) {
                case 1 -> {
                    System.out.println("Ingrese el tamano del array:\n");
                    input = cs.nextLine();
                    int size = validateInt(input);
                    if (size == -1){
                        System.out.println("Opcion incorrecta");
                        continue;
                    }
                    int[] arr = new int[size];
                    Random random = new Random(); // create a Random object
                    for (int i = 0; i < arr.length; i++) {
                        arr[i] = random.nextInt(10000); // assign a random number to each element
                    }
                    System.out.println("El arreglo es:");
                    HeapSort.printArray(arr);
                    System.out.println();

                    System.out.println("Ingrese el numero a buscar:");
                    input = cs.nextLine();
                    int searchNum = validateInt(input);
                    if (searchNum == -1){
                        System.out.println("Opcion incorrecta");
                        continue;
                    }



                    int searchPos = linearSearch(arr, searchNum);
                    if(searchPos == -1){
                        System.out.println("Valor no encontrado");
                    }else {
                        System.out.printf("El valor se encontro en la posicion %d.\n", searchPos + 1);
                    }

                }
                case 2 -> {
                    System.out.println("Ingrese los numeros uno a uno, al finalizar ingrese cualquier numero negativo:\n");
                    ArrayList<Integer> list = new ArrayList<>();
                    input = cs.nextLine();
                    int num = validateInt(input);
                    while (num != -1){
                        list.add(num);
                        input = cs.nextLine();
                        num = validateInt(input);
                    }
                    int[] arr = list.stream().mapToInt(i -> i).toArray();

                    System.out.println("El arreglo es:");
                    HeapSort.printArray(arr);
                    System.out.println();

                    System.out.println("Ingrese el numero a buscar:");
                    input = cs.nextLine();
                    int searchNum = validateInt(input);
                    if (searchNum == -1){
                        System.out.println("Opcion incorrecta");
                        continue;
                    }

                    int searchPos = linearSearch(arr, searchNum);
                    if(searchPos == -1){
                        System.out.println("Valor no encontrado");
                    }else {
                        System.out.printf("El valor se encontro en la posicion %d.\n", searchPos + 1);
                    }

                }
                case 3 -> {
                    return;
                }
                case 4 -> exit(0);
                default -> System.out.println("Opcion incorrecta");
            }
        }

    }
    //receive a strings and returns its value as integer, if it's invalid it returns -1.
    public static int validateInt(String input){
        int value = -1;
        try {
            value = Integer.parseInt(input);
            if (value <0){value =  -1;}
        } catch (NumberFormatException e) {
            System.out.println("Not an integer");
        }
        return value;
    }
}