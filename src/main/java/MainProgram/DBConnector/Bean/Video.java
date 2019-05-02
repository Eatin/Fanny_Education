package MainProgram.DBConnector.Bean;

//'{"ID":' + tabLen.rows[i].cells[0].innerHTML + ',"Sport":"' + tabLen.rows[i].cells[1].innerHTML + '","Enterain":' + tabLen.rows[i].cells[2].innerHTML + ',"Event":"' + tabLen.rows[i].cells[3].innerHTML + '"},'
public class Video {

    int ID;
    String Name;
    double Sport;
    double Entertain;
    double Event;
    int Weight;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getSport() {
        return Sport;
    }

    public void setSport(double sport) {
        Sport = sport;
    }

    public double getEntertain() {
        return Entertain;
    }

    public void setEntertain(double entertain) {
        Entertain = entertain;
    }

    public double getEvent() {
        return Event;
    }

    public void setEvent(double event) {
        Event = event;
    }

    public int getWeight() {
        return Weight;
    }

    public void setWeight(int weight) {
        Weight = weight;
    }

    @Override
    public String toString() {
        return "Video{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", Sport=" + Sport +
                ", Entertain=" + Entertain +
                ", Event=" + Event +
                ", Weight=" + Weight +
                '}';
    }
}
