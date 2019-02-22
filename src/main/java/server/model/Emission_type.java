package server.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(
        name = "emission_type",
        schema = "public"
)
public class Emission_type {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "emission_id")
    private Long emission_id;

    @Column(columnDefinition = "emission_name")
    private String emission_name;

    @OneToMany(mappedBy = "emission")
    private Set<Emissions> emissions;

    public Long getEmission_id() {
        return emission_id;
    }

    public void setEmission_id(Long emission_id) {
        this.emission_id = emission_id;
    }

    public String getEmission_name() {
        return emission_name;
    }

    public void setEmission_name(String emission_name) {
        this.emission_name = emission_name;
    }

    public Set<Emissions> getEmission() {
        return emissions;
    }

    public void setEmission(Set<Emissions> emission) {
        this.emissions = emission;
    }
}