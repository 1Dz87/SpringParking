package by.itstep.parking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "parking")
public class Parking {

    @Id
    @Column(name = "id")
    private Integer id;

    @Enumerated(value = EnumType.STRING)
    private ParkingType type;

    private String name;

    private String address;
}
