package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Heroes {
    private String squadName;
    private int maxSize;
    private String motive;
    private static List<Heroes> allHeroes = new ArrayList<>();

    public Heroes(String squadName, int maxSize, String motive){
        this.squadName = squadName;
        this.maxSize = maxSize;
        this.motive = motive;
        allHeroes.add(this);
    }

    public String getName() {
        return squadName;
    }

    public int getSuperPower() {
        return maxSize;
    }

    public String getRole() {
        return motive;
    }

    public static List<Heroes> getAllHeroes() {
        return allHeroes;
    }

    public static void clearAllHeroes(){
        allHeroes.clear();
    }

}
