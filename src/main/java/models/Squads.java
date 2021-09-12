package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Map;

public class Squads {
    private String squadName;
    private String theme;
    private String url;
    private int maxHeroes;
    private int id;
    private LocalDateTime createdAt = LocalDateTime.now();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
    private String formatDateTime;
    private static ArrayList<Squads> allSquads = new ArrayList<>();
    private ArrayList<Heroes> heroesInSquad;

    public Squads(String name, String theme, String url, int max){
        this.squadName = name;
        this.theme = theme;
        this.url = url;
        this.maxHeroes = max;
        this.formatDateTime = createdAt.format(formatter);
        allSquads.add(this);
        this.id = allSquads.size();
        heroesInSquad = new ArrayList<>();
    }

    public String getSquadName() {
        return squadName;
    }

    public String getTheme() {
        return theme;
    }

    public int getMaxHeroes() {
        return maxHeroes;
    }

    public String getUrl() { return url; }

    public int getId() { return id; }

    public String getFormatDateTime() {
        return formatDateTime;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public static ArrayList<Squads> getAllSquads() {
        return allSquads;
    }

    public static Squads squadWithId(int id){
        return allSquads.get(id - 1);
    }

    public List<Heroes> getHeroesInSquad() {
        return heroesInSquad;
    }

    public void deleteSquad(){
        allSquads.remove(id -1);
    }
    public static void clearAll(){
        allSquads.clear();
    }

    public void addHero(Heroes newHero) {
        heroesInSquad.add(newHero);
    }
}

