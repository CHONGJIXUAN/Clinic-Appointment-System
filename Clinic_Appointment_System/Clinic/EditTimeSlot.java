package Assignment.Clinic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class EditTimeSlot {

    public EditTimeSlot() {
        String timeSlotStr = JOptionPane.showInputDialog("Enter the time slot to edit (e.g. 'Mon 9:00-10:00'):");
        String newTimeSlotStr = JOptionPane.showInputDialog("Enter the new time slot (e.g. 'Mon 11:00-12:00'):");

        ArrayList<String> timeSlots = new ArrayList<>();
        try {
            File file = new File("time_slots.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.startsWith(timeSlotStr)) {
                    timeSlots.add(line);
                } else {
                    timeSlots.add(newTimeSlotStr);
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
            JOptionPane.showMessageDialog(null, "Time slot updated successfully.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error writing to updated_time_slots.txt.");
        }
    }

    public void setVisible(boolean b) {
    }
}
