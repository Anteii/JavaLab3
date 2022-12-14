package com.example.lab3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Client {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "client_id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "client_name", nullable = false, length = 50)
    private String name;
    @Basic
    @Column(name = "city_name", nullable = false, length = 50)
    private String city;
    @Basic
    @Column(name = "client_email", nullable = false, length = 50)
    private String email;

    public Client(String name, String city, String email) {
        this.name = name;
        this.city = city;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (!Objects.equals(id, client.id)) return false;
        if (!Objects.equals(name, client.name)) return false;
        if (!Objects.equals(city, client.city)) return false;
        return Objects.equals(email, client.email);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
