package Assignment.Clinic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class RemoveTimeSlots {

    public RemoveTimeSlots() {
        String timeSlotStr = JOptionPane.showInputDialog("Enter the time slot to remove (e.g. 'Mon 9:00-10:00'):");

        ArrayList<String> timeSlots = new ArrayList<>();
        try {
            File file = new File("time_slots.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.startsWith(timeSlotStr)) {
                    timeSlots.add(line);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error: time_slots.txt not found.");
            return;
        }

        try {
            File file = new File("updated_time_slots.txt");
            FileWriter writer = new FileWriter(file);
            for (String slot : timeSlots) {
                writer.write(slot + "\n");
            }
            writer.close();
            JOptionPane.showMessageDialog(null, "Time slot removed successfully.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error writing to updated_time_slots.txt.");
        }
    }

    public void setVisible(boolean b) {
    }

}
