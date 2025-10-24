package passPatterns;

public class SinglePassPattern {

    //https://leetcode.com/problems/watering-plants/?envType=problem-list-v2&envId=array
    // Input: plants = [2,2,3,3], capacity = 5
    public static int wateringPlants(int[] plants, int capacity) {

        // review edge cases here - bail out early
        if (plants.length == 0 || capacity == 0) {
            System.out.println("Invalid input conditions!");
            return -1;
        }

        // traverse through the plant array
        // check if plant's need is fulfilled by capacity
        // if yes
        // -> reduce from capacity, increment steps
        // if no
        // -> go back to source to refill the can  and come back to same position [total steps + twice the steps] -
        // -> reduce capacity for watering the current plant
        // -> increment total steps

        int totalSteps = 0;
        int originalCapacity = capacity;
        for (int i = 0; i < plants.length; i++) {
            if (plants[i] <= capacity) {
                capacity = capacity - plants[i];
                totalSteps++;
            } else {
                totalSteps = totalSteps + (2 * i);
                capacity = originalCapacity - plants[i];
                totalSteps++;
            }
        }
        return totalSteps;
    }

    public static void main(String[] args) {
//        int[] plants = {1,1,1,4,2,3};
//        int capacity = 4;
//        System.out.println(wateringPlants(plants, capacity));

        int[] refillPlants = {2, 2, 3, 3};
        int capacityA = 5, capacityB = 5;
        System.out.println(minimumRefill(refillPlants, capacityA, capacityB));
    }

    // Input: plants = [2,2,3,3], capacityA = 5, capacityB = 5
    //Output: 1
    /*
    Explanation:
- Initially, Alice and Bob have 5 units of water each in their watering cans.
- Alice waters plant 0, Bob waters plant 3.
- Alice and Bob now have 3 units and 2 units of water respectively.
- Alice has enough water for plant 1, so she waters it. Bob does not have enough water for plant 2, so he refills his can then waters it.
So, the total number of times they have to refill to water all the plants is 0 + 0 + 1 + 0 = 1.
     */
    public static int minimumRefill(int[] plants, int capacityA, int capacityB) {

        int refillCount = 0;
        int originalCapacityA = capacityA;
        int originalCapacityB = capacityB;

        int i = 0, j = plants.length - 1;
        while (i <= j) {
            if (i == j) {
                if (plants[i] <= capacityA) {
                    capacityA = capacityA - plants[i];
                } else if (plants[i] <= capacityB) {
                    capacityB = capacityB - plants[i];
                } else {
                    if (capacityA >= capacityB) {
                        capacityA = capacityA - plants[i];
                        refillCount++;
                    } else {
                        capacityB = capacityB - plants[i];
                        refillCount++;
                    }
                }
                i++;
                j--;
            } else {
                if (plants[i] <= capacityA) {
                    capacityA = capacityA - plants[i];
                } else {
                    capacityA = originalCapacityA - plants[i];
                    refillCount = refillCount + 1;
                }

                if (plants[j] <= capacityB) {
                    capacityB = capacityB - plants[j];
                } else {
                    capacityB = originalCapacityB - plants[j];
                    refillCount = refillCount + 1;
                }
                i++;
                j--;
            }
        }
        return refillCount;
    }
}
