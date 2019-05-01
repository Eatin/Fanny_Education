package MainProgram.DBConnector.Bean;

public class Apper {
    int id;
    int Event;
    int Sport;
    int Entertain;
    String Tel;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEvent() {
        return Event;
    }

    public void setEvent(int event) {
        Event = event;
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
