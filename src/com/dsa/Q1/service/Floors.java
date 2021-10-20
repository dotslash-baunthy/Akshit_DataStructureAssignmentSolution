package com.dsa.Q1.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Floors {

    // Accept order from user and enqueue
    public Queue<Integer> getFloorsFromUser(int noOfFloors) {
        Queue<Integer> queue = new LinkedList<Integer>();
        Scanner scanner = new Scanner(System.in);
        int currentFloor;
        for (int i = 0; i < noOfFloors; i++) {
            System.out.print("Enter the floor size given on day: " + (i + 1) + " - ");
            currentFloor = scanner.nextInt();

            // Entered floor values cannot be less than 0 or greated than the max no. of
            // floors
            if (currentFloor < 1 || currentFloor > noOfFloors) {
                throw new ArithmeticException("No. of floors have to be between 1 and " + noOfFloors + " inclusive.");
            }

            // Entered floor values have ti be unique. Two factories will not construct the
            // same floor
            else if (queue.contains(currentFloor)) {
                throw new ArithmeticException("All floors must be unique. We cannot have duplicate floor nos.");
            } else {
                queue.add(currentFloor);
            }
        }
        return queue;
    }

    public void floorConstruction(Queue<Integer> queue, int noOfFloors) {

        // An ArrayList is created because we do not know the size of the floors which
        // need to be put in. Floors may or may not arrive in order
        ArrayList<Integer> orderedFloors = new ArrayList<Integer>();
        int floorBeingSearchedFor = noOfFloors;
        int day = 1;
        while (day <= noOfFloors) {
            System.out.println("Day: " + day++);
            int currentFloor = queue.remove();
            // If current floor matches the floor being searched for, sort ordered floors
            // array in reverse and display
            if (currentFloor == floorBeingSearchedFor) {
                int lastOutput = 0;
                orderedFloors.add(currentFloor);
                Collections.sort(orderedFloors, Collections.reverseOrder());
                while (lastOutput == 0 || lastOutput == orderedFloors.get(0) + 1) {
                    lastOutput = orderedFloors.get(0);
                    System.out.print(orderedFloors.get(0) + " ");
                    orderedFloors.remove(0);

                    // Condition to break from loop in case the ordered floors ArrayList does not
                    // have any element (no more floors to process). This condition is in place to
                    // consider the case where all floors are assembled on the last day
                    if (orderedFloors.size() == 0) {
                        break;
                    }
                }
                floorBeingSearchedFor -= orderedFloors.size();
            }
            // Else simply add the current floor to the ordered floors ArrayList
            else {
                orderedFloors.add(currentFloor);
            }
            System.out.println("");
        }

        // If floors have still not been output, print them
        if (!orderedFloors.isEmpty()) {
            Collections.sort(orderedFloors, Collections.reverseOrder());
            for (int i = 0; i < orderedFloors.size(); i++) {
                System.out.print(orderedFloors.get(i) + " ");
            }
        }
    }
}