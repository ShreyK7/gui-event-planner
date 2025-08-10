public class Event {
    private String name;
    private String address;
    private int headcount;
    private int budget;
    private String[] attendees;

    public Event(String name, String address, int headcount, int budget, String[] attendees) {
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

    public void setHeadcount(int newHeadcount) {
        headcount = newHeadcount;
    }

    public void setBudget(int newBudget) {
        budget = newBudget;
    }

    public void setAttendees(String[] newAttendees) {
        attendees = newAttendees;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getHeadcount() {
        return headcount;
    }

    public int getBudget() {
        return budget;
    }

    public String[] getAttendees() {
        return attendees;
    }

    public String formatAttendeesCommaSeperated() {
        String output = "";
        for (String name : attendees) {
            output += name;
            output += ", ";
        }
        return output.substring(0, output.length() - 2);
    }
}
