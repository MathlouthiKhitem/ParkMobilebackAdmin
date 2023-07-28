package com.example.demo.Module;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * A Agent.
 */
@Document(collection = "agent")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Agent implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private Users users;
    // jhipster-needle-entity-add-field - JHipster will add fields here
    @JsonIgnore
    @DBRef
    @Field("zone")
    private Zone zone;

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

//    @JsonIgnore
//    @DBRef
//    @Field("zone")
//    private Set<Zone> zones;
//
//    public Set<Zone> getZones() {
//        return zones;
//    }
//
//    public void setZones(Set<Zone> zones) {
//        this.zones = zones;
//    }

    public String getId() {
        return this.id;
    }

    public Agent id(String id) {
        this.setId(id);
        return this;
    }

    public void setId(String id) {
        this.id = id;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here
    public void setUser(Users users) {
        this.users = users;
    }
    public Users getUser() {
        return users;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Agent)) {
            return false;
        }
        return id != null && id.equals(((Agent) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Agent{" +
            "id=" + getId() +
            "}";
    }
}
