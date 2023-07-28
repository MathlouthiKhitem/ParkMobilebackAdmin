package com.example.demo.Module;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;

/**
 * A Zone.
 */
@Document(collection = "zone")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Zone implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field("name_zone")
    private String nameZone;

    @Field("hour_price")
    private String hourPrice;
    @Field("ville")
    private String ville;
    @Field("description")
    private String description;
    @Field("numeroParking")
    private String numeroParking;

    public String getNmeroParking() {
        return numeroParking;
    }

    public void setNmeroParking(String numeroParking) {
        this.numeroParking = numeroParking;
    }

    @DBRef
    @Field("parkings")
    @JsonIgnoreProperties(value = { "zones", "map", "sessions" }, allowSetters = true)
    private List<Parkings> parkings;

//    public Zone() {
//    }


    public String getId() {
        return this.id;
    }

    public Zone id(String id) {
        this.setId(id);
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getNameZone() {
        return this.nameZone;
    }

    public Zone nameZone(String nameZone) {
        this.setNameZone(nameZone);
        return this;
    }

    public void setNameZone(String nameZone) {
        this.nameZone = nameZone;
    }

    public String getHourPrice() {
        return this.hourPrice;
    }

    public Zone hourPrice(String hourPrice) {
        this.setHourPrice(hourPrice);
        return this;
    }

    public void setHourPrice(String hourPrice) {
        this.hourPrice = hourPrice;
    }

    public List<Parkings> getParkings() {
        return this.parkings;
    }

    public void setParkings(List<Parkings> parkings) {
        this.parkings = parkings;
    }

    public Zone parkings(List<Parkings> parkings) {
        this.setParkings(parkings);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Zone)) {
            return false;
        }
        return id != null && id.equals(((Zone) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Zone{" +
            "id=" + getId() +
            ", nameZone='" + getNameZone() + "'" +
            ", hourPrice='" + getHourPrice() + "'" +
            "}";
    }
}
