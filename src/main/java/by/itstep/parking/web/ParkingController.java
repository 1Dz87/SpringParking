package by.itstep.parking.web;

import by.itstep.parking.model.Parking;
import by.itstep.parking.model.ParkingType;
import by.itstep.parking.service.EchoService;
import by.itstep.parking.service.ParkingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    private final EchoService echoService;

    private final ParkingService parkingService;

    public ParkingController(EchoService echoService, ParkingService parkingService) {
        this.echoService = echoService;
        this.parkingService = parkingService;
    }

    @GetMapping("/echo")
    public ResponseEntity<String> echo(@RequestParam(name = "mes") String message,
                                       @RequestParam(required = false, defaultValue = "1") int times) {
        return ResponseEntity.ok(echoService.echo(message, times));
    }

    @GetMapping("/getParkingById")
    public ResponseEntity<Parking> getParkingById(@RequestParam Integer id) {
        return ResponseEntity.ok(parkingService.getParkingById(id).orElse(null));
    }

    @GetMapping("/getByName")
    public ResponseEntity<List<Parking>> getByName(@RequestParam String name, @RequestParam ParkingType type) {
        return ResponseEntity.ok(parkingService.getByName(name, type));
    }

    @GetMapping("/getByOrderId")
    public ResponseEntity<Parking> getByOrderId(@RequestParam Long orderId) {
        return ResponseEntity.ok(parkingService.getByOrderNumber(orderId).orElse(null));
    }

    @PostMapping("/create")
    public ResponseEntity<Integer> createNewParking(@RequestBody Parking parking) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(parkingService.saveParking(parking));
    }
}
