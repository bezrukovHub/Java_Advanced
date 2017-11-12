package ua.com.library.dto;

/**
 * Created by admin on 11.12.2016.
 */
public class CityDTO {
    private String name;
    private String idCountry;

    public CityDTO(String name, String idCountry) {
        this.name = name;
        this.idCountry = idCountry;
    }

    public CityDTO() {
    }
    public CityDTO(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(String idCountry) {
        this.idCountry = idCountry;
    }

    @Override
    public String toString() {
        return "CityDTO{" +
                "name='" + name + '\'' +
                ", idCountry=" + idCountry +
                '}';
    }
}
