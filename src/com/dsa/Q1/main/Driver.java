package com.dsa.Q1.main;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import com.dsa.Q1.service.Floors;

public class Driver {
    public static void main(String[] args) {
        int noOfFloors;

        // The floors must be in a queue because we will be following a FIFO method to
        // process floors
        Queue<Integer> queue = new LinkedList<Integer>();
        Scanner scanner = new Scanner(System.in);
        
        // Create object of Floors class which has insertion and processing functions
        Floors floors = new Floors();

        System.out.print("Enter the total number of floors in the building: ");
        noOfFloors = scanner.nextInt();

        // Accept floors from users
        queue = floors.getFloorsFromUser(noOfFloors);

        System.out.println("The order of construction is as follows - ");
        // Process entered floors and determine construction method
        floors.floorConstruction(queue, noOfFloors);
    }
}