package by.itstep.parking.repository;

import by.itstep.parking.model.Parking;
import by.itstep.parking.model.ParkingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Integer> {

    @Query(value = "select * from parking p where p.id in " +
            "(select pp.parking_id from parking_place pp " +
            "join orders o on pp.number = o.pp_number and pp.floor = o.pp_floor " +
            "where o.id = :orderId)", nativeQuery = true)
    Optional<Parking> getByOrderNumber(Long orderId);

    List<Parking> findByNameAndType(String name, ParkingType type);
}
