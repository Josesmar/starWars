package dev.swapi.starwars.entity;
import javax.persistence.*;
import java.math.BigDecimal;

public class Starwars {

    private long id;
    private String name;
    private String model;
    private String manufacturer;
    private String cost_in_credits;
    private Integer passengers;
    private Integer cargo_capacity;
    private String MGLT;
    private String length;
    private String max_atmosphering_speed;
    private String crew;
    private String consumables;
    private String hyperdrive_rating;
    private String tarship_class;

    public void setCost_in_credits(String cost_in_credits) {
        this.cost_in_credits = cost_in_credits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getMax_atmosphering_speed() {
        return max_atmosphering_speed;
    }

    public void setMax_atmosphering_speed(String max_atmosphering_speed) {
        this.max_atmosphering_speed = max_atmosphering_speed;
    }

    public String getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }

    public String getConsumables() {
        return consumables;
    }

    public void setConsumables(String consumables) {
        this.consumables = consumables;
    }

    public String getHyperdrive_rating() {
        return hyperdrive_rating;
    }

    public void setHyperdrive_rating(String hyperdrive_rating) {
        this.hyperdrive_rating = hyperdrive_rating;
    }

    public String getTarship_class() {
        return tarship_class;
    }

    public void setTarship_class(String tarship_class) {
        this.tarship_class = tarship_class;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return name;
    }
    public void setNome(String name) {
        this.name = name;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public String getCost_in_credits() {
        return cost_in_credits;
    }
    public Integer getPassengers() {
        return passengers;
    }
    public void setPassengers(Integer passengers) {
        this.passengers = passengers;
    }
    public Integer getCargo_capacity() {
        return cargo_capacity;
    }
    public void setCargo_capacity(Integer cargo_capacity) {
        this.cargo_capacity = cargo_capacity;
    }
    public String getMGLT() {
        return MGLT;
    }
    public void setMGLT(String MGLT) {
        this.MGLT = MGLT;
    }
}
