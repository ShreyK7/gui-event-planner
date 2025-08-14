import java.util.ArrayList;
import java.util.Arrays;

public class Event {
    private String name;
    private String address;
    private String headcount;
    private String budget;
    private String attendees;

    Event(String name, String address, String headcount, String budget, String attendees) {
        this.name = name;
        this.address = address;
        this.headcount = headcount;
        this.budget = budget;
        this.attendees = attendees;
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setAddress(String newAddress) {
        address = newAddress;
    }

    public void setHeadcount(String newHeadcount) {
        headcount = newHeadcount;
    }

    public void setBudget(String newBudget) {
        budget = newBudget;
    }

    public void setAttendees(String newAttendees) {
        attendees = newAttendees;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getHeadcount() {
        return headcount;
    }

    public String getBudget() {
        return budget;
    }

    public String getAttendees() {
        return attendees;
    }


    @Override
    public String toString() {
        return (name + "|" + address + "|" + headcount + "|" + budget + "|" + attendees);
    }
}
