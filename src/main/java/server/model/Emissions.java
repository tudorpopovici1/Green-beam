package server.model;


import javax.persistence.*;

@Entity
@Table(
        name = "emissions",
        schema = "public"
)
class Emissions {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "emission_type")
    private Long emission_type;

    @Column(name = "carbon_footprint")
    private Long carbonFootprint;

    @Column(name = "date_of_emission")
    private String date;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(final Long user_id) {
        this.user_id = user_id;
    }

    public Long getEmission_type() {
        return emission_type;
    }

    public void setEmission_type(final Long emission_type) {
        this.emission_type = emission_type;
    }

    public Long getCarbonFootprint() {
        return carbonFootprint;
    }

    public void setCarbonFootprint(final Long carbonFootprint) {
        this.carbonFootprint = carbonFootprint;
    }

    public String getDate() {
        return date;
    }

    public void setDate(final String date) {
        this.date = date;
    }
}