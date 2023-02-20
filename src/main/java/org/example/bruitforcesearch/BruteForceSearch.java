package org.example.bruitforcesearch;

public class BruteForceSearch {
    public static int linearSearch(int[] list, int target) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == target) {
                return i; // return the index of the match
            }
        }
        return -1; // return -1 if target is not found
    }
}
