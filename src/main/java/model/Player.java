package model;

public class Player {
    private String id;
    private String name;
    private String team;
    private String role;
    private int runs;
    private int wickets;

    public Player(String id, String name, String team, String role, int runs, int wickets) {
        this.id = id;
        this.name = name;
        this.team = team;
        this.role = role;
        this.runs = runs;
        this.wickets = wickets;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getTeam() { return team; }
    public String getRole() { return role; }
    public int getRuns() { return runs; }
    public int getWickets() { return wickets; }

    public void setRuns(int runs) { this.runs = runs; }
    public void setWickets(int wickets) { this.wickets = wickets; }
}
