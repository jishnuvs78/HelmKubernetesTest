package com.camel.HelmKubernetesTest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payload {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hermes_id;
    private String payload;
    private Integer stg_id;

    public Payload() {
    }

    public Payload(String hermes_id, String payload, Integer stg_id) {
        this.hermes_id = hermes_id;
        this.payload = payload;
        this.stg_id = stg_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHermes_id() {
        return hermes_id;
    }

    public void setHermes_id(String hermes_id) {
        this.hermes_id = hermes_id;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public Integer getStg_id() {
        return stg_id;
    }

    public void setStg_id(Integer stg_id) {
        this.stg_id = stg_id;
    }

    @Override
    public String toString() {
        return "Payload{" +
                "id=" + id +
                ", hermes_id='" + hermes_id + '\'' +
                ", payload='" + payload + '\'' +
                ", stg_id=" + stg_id +
                '}';
    }


}
