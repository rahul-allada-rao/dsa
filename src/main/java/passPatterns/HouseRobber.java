package passPatterns;

import java.util.HashMap;
import java.util.List;

public class HouseRobber {
    public int robHouse(List<Integer> houses){
        return robHouse(houses, new HashMap<Integer, Integer>());
    }

    public int robHouse(List<Integer> houses, HashMap<Integer, Integer> memo){
        int maxAmount = 0;

        for (int i = 0; i < houses.size() ; i = i+2){
            maxAmount = maxAmount + houses.get(i);
        }
        return maxAmount;
    }
}