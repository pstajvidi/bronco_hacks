package com.restaurants.types.restaurants;

import jakarta.persistence.*;

@Entity
@Table(name = "restaurants")
public class Restaurants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "market")
    private String market;

    @Column(name = "rname")
    private String rname;

    @Column(name = "rdesc")
    private String rdesc;

    @Column(name = "raddy")
    private String raddy;

    public Restaurants() {
    }

    public Restaurants(Long id, String market, String rname, String rdesc, String raddy) {
        this.id = id;
        this.market = market;
        this.rname = rname;
        this.rdesc = rdesc;
        this.raddy = raddy;
    }

    public Long getId() {
        return id;
    }

    public String getMarket() {
        return market;
    }

    public String getRname() {
        return rname;
    }

    public String getRdesc() {
        return rdesc;
    }

    public String getRaddy() {
        return raddy;
    }
}
