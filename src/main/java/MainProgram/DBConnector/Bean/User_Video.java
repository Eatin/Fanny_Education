package MainProgram.DBConnector.Bean;

public class User_Video {
    String Video;
    double distance;

    public String getVideo() {
        return Video;
    }

    public void setVideo(String video) {
        Video = video;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }


    @Override
    public String toString() {
        return "{" +
                "Video='" + Video + '\'' +
                ", distance=" + distance +
                '}';
    }
}
