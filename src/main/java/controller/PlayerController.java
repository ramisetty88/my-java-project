package controller;

import model.Player;
import view.PlayerView;
import java.util.*;

public class PlayerController {
    private final List<Player> players = new ArrayList<>();
    private final PlayerView view = new PlayerView();

    public void start() {
        while (true) {
            view.showMenu();
            int choice = view.inputInt("");
            switch (choice) {
                case 1:
                    addPlayer();
                    break;
                case 2:
                    view.displayPlayers(players);
                    break;
                case 3:
                    updatePlayerStats();
                    break;
                case 4:
                    showTopPlayers();
                    break;
                case 5:
                    view.showMessage("Exiting system. Goodbye!");
                    return;
                default:
                    view.showMessage("Invalid option!");
                    break;
            }
        }
    }

    private void addPlayer() {
        String id = view.inputString("Enter Player ID: ");
        String name = view.inputString("Enter Name: ");
        String team = view.inputString("Enter Team: ");
        String role = view.inputString("Enter Role: ");
        int runs = view.inputInt("Enter Runs: ");
        int wickets = view.inputInt("Enter Wickets: ");

        players.add(new Player(id, name, team, role, runs, wickets));
        view.showMessage("Player added successfully!");
    }

    private void updatePlayerStats() {
        String id = view.inputString("Enter Player ID to update: ");
        for (Player p : players) {
            if (p.getId().equals(id)) {
                int runs = view.inputInt("Enter new Runs: ");
                int wickets = view.inputInt("Enter new Wickets: ");
                p.setRuns(runs);
                p.setWickets(wickets);
                view.showMessage("Player stats updated!");
                return;
            }
        }
        view.showMessage("Player not found!");
    }

    private void showTopPlayers() {
        if (players.isEmpty()) {
            view.showMessage("No players to analyze.");
            return;
        }

        Player topScorer = Collections.max(players, Comparator.comparingInt(Player::getRuns));
        Player topWicketTaker = Collections.max(players, Comparator.comparingInt(Player::getWickets));

        view.showMessage("\nTop Scorer: " + topScorer.getName() + " (" + topScorer.getRuns() + " runs)");
        view.showMessage("Top Wicket-Taker: " + topWicketTaker.getName() + " (" + topWicketTaker.getWickets() + " wickets)");
    }
}
