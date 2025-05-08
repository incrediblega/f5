//algo to automate concepts and scripts and title locations and track the movements and requirements

import java.util.*;

public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Take input for the movie script
        System.out.println("Enter the movie script (type 'END' on a new line to finish):");
        StringBuilder scriptBuilder = new StringBuilder();
        String line;
        while (!(line = scanner.nextLine()).equals("END")) {
            scriptBuilder.append(line).append("\n");
        }
        String script = scriptBuilder.toString();

        // Step 2: Process the script to identify scenes and characters
        Map<String, List<String>> characterDialogues = processScript(script);

        // Step 3: Display the formatted output
        System.out.println("\nFormatted Output:");
        for (Map.Entry<String, List<String>> entry : characterDialogues.entrySet()) {
            System.out.println("Character: " + entry.getKey());
            System.out.println("Dialogues:");
            for (String dialogue : entry.getValue()) {
                System.out.println("  - " + dialogue);
            }
            System.out.println();
        }

        scanner.close();
    }

    private static Map<String, List<String>> processScript(String script) {
        Map<String, List<String>> characterDialogues = new LinkedHashMap<>();

        // Split the script into lines
        String[] lines = script.split("\\n");

        // Assume each line starts with the character's name followed by a colon and dialogue
        for (String line : lines) {
            if (line.contains(":")) {
                String[] parts = line.split(":", 2);
                String character = parts[0].trim();
                String dialogue = parts[1].trim();

                // Add the dialogue to the character's list
                characterDialogues.putIfAbsent(character, new ArrayList<>());
                characterDialogues.get(character).add(dialogue);
            }
        }

        return characterDialogues;
    }
}
