package com.project.cat;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Cat implements Serializable {
    private String id;
    private String name;
    private String cfa_url;
    private String vetstreet_url;
    private String vcahospitals_url;
    private String temperament;
    private String origin;
    private String description;
    private String life_span;
    private String indoor;
    private String lap;
    private String alt_names;
    private String adaptability;
    private String child_friendly;
    private String energy_level;
    private String grooming;
    private String health_issues;
    private String intelligence;
    private String shedding_level;
    private String social_needs;
    private String stranger_friendly;
    private String vocalisation;
    private String experimental;
    private String hairless;
    private String natural;
    private String rare;
    private String rex;
    private String suppressed_tail;
    private String short_legs;
    private String wikipedia_url;
    private String dog_friendly;
    private Weight weight;

    public Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }

      class Weight implements Serializable{
       String metric;
       String imperial;

       public String getMetric() {
           return metric;
       }

       public void setMetric(String metric) {
           this.metric = metric;
       }

       public String getImperial() {
           return imperial;
       }

       public void setImperial(String imperial) {
           this.imperial = imperial;
       }
   }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCfa_url() {
        return cfa_url;
    }

    public void setCfa_url(String cfa_url) {
        this.cfa_url = cfa_url;
    }

    public String getVetstreet_url() {
        return vetstreet_url;
    }

    public void setVetstreet_url(String vetstreet_url) {
        this.vetstreet_url = vetstreet_url;
    }

    public String getVcahospitals_url() {
        return vcahospitals_url;
    }

    public void setVcahospitals_url(String vcahospitals_url) {
        this.vcahospitals_url = vcahospitals_url;
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLife_span() {
        return life_span;
    }

    public void setLife_span(String life_span) {
        this.life_span = life_span;
    }

    public String getIndoor() {
        return indoor;
    }

    public void setIndoor(String indoor) {
        this.indoor = indoor;
    }

    public String getLap() {
        return lap;
    }

    public void setLap(String lap) {
        this.lap = lap;
    }

    public String getAlt_names() {
        return alt_names;
    }

    public void setAlt_names(String alt_names) {
        this.alt_names = alt_names;
    }

    public String getAdaptability() {
        return adaptability;
    }

    public void setAdaptability(String adaptability) {
        this.adaptability = adaptability;
    }

    public String getChild_friendly() {
        return child_friendly;
    }

    public void setChild_friendly(String child_friendly) {
        this.child_friendly = child_friendly;
    }

    public String getEnergy_level() {
        return energy_level;
    }

    public void setEnergy_level(String energy_level) {
        this.energy_level = energy_level;
    }

    public String getGrooming() {
        return grooming;
    }

    public void setGrooming(String grooming) {
        this.grooming = grooming;
    }

    public String getHealth_issues() {
        return health_issues;
    }

    public void setHealth_issues(String health_issues) {
        this.health_issues = health_issues;
    }

    public String getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(String intelligence) {
        this.intelligence = intelligence;
    }

    public String getShedding_level() {
        return shedding_level;
    }

    public void setShedding_level(String shedding_level) {
        this.shedding_level = shedding_level;
    }

    public String getSocial_needs() {
        return social_needs;
    }

    public void setSocial_needs(String social_needs) {
        this.social_needs = social_needs;
    }

    public String getStranger_friendly() {
        return stranger_friendly;
    }

    public void setStranger_friendly(String stranger_friendly) {
        this.stranger_friendly = stranger_friendly;
    }

    public String getVocalisation() {
        return vocalisation;
    }

    public void setVocalisation(String vocalisation) {
        this.vocalisation = vocalisation;
    }

    public String getExperimental() {
        return experimental;
    }

    public void setExperimental(String experimental) {
        this.experimental = experimental;
    }

    public String getHairless() {
        return hairless;
    }

    public void setHairless(String hairless) {
        this.hairless = hairless;
    }

    public String getNatural() {
        return natural;
    }

    public void setNatural(String natural) {
        this.natural = natural;
    }

    public String getRare() {
        return rare;
    }

    public void setRare(String rare) {
        this.rare = rare;
    }

    public String getRex() {
        return rex;
    }

    public void setRex(String rex) {
        this.rex = rex;
    }

    public String getSuppressed_tail() {
        return suppressed_tail;
    }

    public void setSuppressed_tail(String suppressed_tail) {
        this.suppressed_tail = suppressed_tail;
    }

    public String getShort_legs() {
        return short_legs;
    }

    public void setShort_legs(String short_legs) {
        this.short_legs = short_legs;
    }

    public String getWikipedia_url() {
        return wikipedia_url;
    }

    public void setWikipedia_url(String wikipedia_url) {
        this.wikipedia_url = wikipedia_url;
    }

    public String getDog_friendly() {
        return dog_friendly;
    }

    public void setDog_friendly(String dog_friendly) {
        this.dog_friendly = dog_friendly;
    }
}
