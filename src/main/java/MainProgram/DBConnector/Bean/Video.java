package MainProgram.DBConnector.Bean;

//'{"ID":' + tabLen.rows[i].cells[0].innerHTML + ',"Sport":"' + tabLen.rows[i].cells[1].innerHTML + '","Enterain":' + tabLen.rows[i].cells[2].innerHTML + ',"Event":"' + tabLen.rows[i].cells[3].innerHTML + '"},'
public class Video {

    int ID;
    String Name;
    int Sport;
    int Entertain;
    int Event;
    int Weight;

    public int getWeight() {
        return Weight;
    }

    public void setWeight(int weight) {
        Weight = weight;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String nmae) {
        Name = nmae;
    }

    public int getSport() {
        return Sport;
    }

    public void setSport(int sport) {
        Sport = sport;
    }

    public int getEntertain() {
        return Entertain;
    }

    public void setEntertain(int entertain) {
        Entertain = entertain;
    }

    @Override
    public String toString() {
        return "Video{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", Sport=" + Sport +
                ", Enterain=" + Entertain +
                ", Event=" + Event +
                ", Weight=" + Weight +
                '}';
    }



    public int getEvent() {
        return Event;
    }

    public void setEvent(int event) {
        Event = event;
    }
}
