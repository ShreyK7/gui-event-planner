import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.ArrayList;

public class EventFileSystem {
    private String filePath;
    public EventFileSystem(String fn) { 
        this.filePath = fn;
    }
    public boolean createEventsFile() {
        try {
            File newFile = new File(filePath);
            if (newFile.createNewFile()) {
                return true;
            }
            else {
                deleteEventsFile();
                createEventsFile();
                return true;
            }
        } catch (IOException e) {
            System.out.println("ERROR: ");
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteEventsFile() {
        try {
            File newFile = new File(filePath);
            newFile.delete();
            return true;
        } catch (Exception e) {
            System.out.println("ERROR: ");
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Event> getEventsFromFile() {
        ArrayList<Event> events = new ArrayList<Event>();
        try {

            File tmpFile = new File(filePath);
            tmpFile.createNewFile();

            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String nextEvent;
            while ((nextEvent = reader.readLine()) != null) {
                String[] eventFields = nextEvent.split("\\|");
                Event event = new Event(eventFields[0], eventFields[1], eventFields[2], eventFields[3], eventFields[4]);
                events.add(event);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("ERROR: ");
            e.printStackTrace();
        }
        return events;
    }

    public boolean addEventToFile(Event event) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
            writer.write(event.toString() + "\n");
            writer.close();
            return true;
        } catch (IOException e) {
            System.out.println("ERROR: ");
            e.printStackTrace();
        }
        return false;
    }

    public boolean removeEventFromFile(String eventName) {
        try {
            File oldFile = new File(filePath);
            File tempFile = new File("tmp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile, true));

            String curLine;
            boolean flag = false;
            while ((curLine = reader.readLine()) != null) {
                String[] eventProperties = curLine.split("\\|");
                if (eventProperties[0].trim().equals(eventName) && !flag) { 
                    flag = true;
                    continue; 
                }
                writer.write(curLine + "\n");
            }
            reader.close();
            writer.close();
            oldFile.delete();
            tempFile.renameTo(oldFile);
            return true;
        } catch (Exception e) {
            System.out.println("ERROR: ");
            e.printStackTrace();
        }
        return false;
    }

    public boolean modifyEventInFile(String eventName, Event modifiedEvent) {
        removeEventFromFile(eventName);
        addEventToFile(modifiedEvent);
        return true;
    }
}