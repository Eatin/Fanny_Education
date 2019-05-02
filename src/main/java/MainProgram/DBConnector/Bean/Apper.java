package MainProgram.DBConnector.Bean;

public class Apper {
    int id;
    double Event;
    double Sport;
    double Entertain;
    String Tel;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getEvent() {
        return Event;
    }

    public void setEvent(double event) {
        Event = event;
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

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    @Override
    public String toString() {
        return "Apper{" +
                "id=" + id +
                ", Event=" + Event +
                ", Sport=" + Sport +
                ", Entertain=" + Entertain +
                ", Tel='" + Tel + '\'' +
                '}';
    }
}
