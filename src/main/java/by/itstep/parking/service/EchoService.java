package by.itstep.parking.service;

import org.springframework.stereotype.Service;

@Service
public class EchoService {

    public String echo(String message, int times) {
        String result = "";
        for (int i = 0; i < times; i++) {
            result += message + " ";
        }
        return result;
    }
}
