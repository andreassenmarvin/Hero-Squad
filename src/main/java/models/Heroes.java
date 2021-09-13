package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Heroes {
    private String name;
    private String superPower;
    private String role;
    private static List<Heroes> allHeroes = new ArrayList<>();

    public Heroes(String name, String power, String role){
        this.name = name;
        this.superPower = power;
        this.role = role;
        allHeroes.add(this);
    }

    public String getName() {
        return name;
    }

    public String getSuperPower() {
        return superPower;
    }

    public String getRole() {
        return role;
    }

    public static List<Heroes> getAllHeroes() {
        return allHeroes;
    }

    public static void clearAllHeroes(){
        allHeroes.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Heroes kitten = (Heroes) o;

        return name.equals(kitten.name); //more properties would be taken into account here for a more complex model
    }
}
