package br.mil.eb.dashboard_sgl_sg7.entities.sg7;

public class Coordenadas {
    private final String longitude;
    private final String latitude;

    public Coordenadas(String longitude, String latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }
}