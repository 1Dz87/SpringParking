package by.itstep.parking.service;

import by.itstep.parking.model.Parking;
import by.itstep.parking.model.ParkingType;
import by.itstep.parking.repository.ParkingRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ParkingService {

    private final Random random;

    private final ParkingRepository repository;

    public ParkingService(Random random, ParkingRepository repository) {
        this.random = random;
        this.repository = repository;
    }

    public Optional<Parking> getByOrderNumber(Long orderId) {
        return repository.getByOrderNumber(orderId);
    }

    public Optional<Parking> getParkingById(Integer id) {
        return repository.findById(id);
    }

    public List<Parking> getByName(String name, ParkingType type) {
        return repository.findByNameAndType(name, type);
    }

    public Integer saveParking(Parking parking) {
        int id = random.nextInt(999);
        return id;
    }
}
