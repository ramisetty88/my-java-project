package view;

import model.Player;
import java.util.List;
import java.util.Scanner;

public class PlayerView {
    private final Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("\n=== IPL Player Management ===");
        System.out.println("1. Add Player");
        System.out.println("2. View All Players");
        System.out.println("3. Update Player Stats");
        System.out.println("4. View Top Scorer & Wicket-Taker");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    public String inputString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public int inputInt(String message) {
        System.out.print(message);
        return Integer.parseInt(scanner.nextLine());
    }

    public void displayPlayers(List<Player> players) {
        if (players.isEmpty()) {
            System.out.println("No players found.");
            return;
        }
        System.out.println("\n--- Player List ---");
        for (Player p : players) {
            System.out.println(p.getId() + " | " + p.getName() + " | Team: " + p.getTeam() +
                    " | Role: " + p.getRole() + " | Runs: " + p.getRuns() + " | Wickets: " + p.getWickets());
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
