package MainProgram.DBConnector.Bean;

public class AppUser {
    String Tel;
    String Psd;
    int id;

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getPsd() {
        return Psd;
    }

    public void setPsd(String psd) {
        Psd = psd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "Tel='" + Tel + '\'' +
                ", Psd='" + Psd + '\'' +
                ", id=" + id +
                '}';
    }
}
