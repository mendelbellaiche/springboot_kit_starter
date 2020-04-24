package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springboot.model.Advertisement;
import springboot.model.AdvertisementRepository;
import springboot.service.AdvertisementService;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class AdvertisementServiceController {

    @Autowired
    private AdvertisementRepository advRepository;

    @RequestMapping(value = "/advertisements")
    public Iterable<Advertisement> getProduct() {
        return advRepository.findAll();
    }

    @RequestMapping(value = "/advertisements", method = RequestMethod.POST)
    public ResponseEntity<Object> createAdvertisements(@RequestBody Advertisement advertisement) {
        advRepository.save(advertisement);
        return new ResponseEntity<>("Advertisement is created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/advertisements/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getAdvertisements(@PathVariable("id") String id) {
        Optional<Advertisement> advById = advRepository.findById(Integer.parseInt(id));
        if (advById.isPresent()) {
            return new ResponseEntity<>(advRepository.findById(Integer.parseInt(id)), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ArrayList<Advertisement>(), HttpStatus.OK);
    }

    @RequestMapping(value = "/advertisements/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateAdvertisements(@PathVariable("id") String id, @RequestBody Advertisement advertisement) {
        advRepository.deleteById(Integer.parseInt(id));
        advertisement.setId(Integer.parseInt(id));
        advRepository.save(advertisement);
        return new ResponseEntity<>(advertisement, HttpStatus.OK);
    }

    @RequestMapping(value = "/advertisements/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        advRepository.deleteById(Integer.parseInt(id));
        return new ResponseEntity<>("Advertisement is deleted successsfully", HttpStatus.OK);
    }
}
