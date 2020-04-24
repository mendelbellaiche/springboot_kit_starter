package springboot.service;

import org.springframework.stereotype.Service;
import springboot.model.Advertisement;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class AdvertisementServiceImpl implements  AdvertisementService{

    private static Map<String, Advertisement> advertisementRepo = new HashMap<>();

    /*static {
        Advertisement ad1 = new Advertisement();
        ad1.setId(1);
        ad1.setContent("This is a test");
        ad1.setUrlImage("http://www.francesoir.fr/sites/francesoir/files/cyril-hanouna-francesoir_field_mise_en_avant_principale.jpg");
        ad1.setUrlVideo("https://www.youtube.com/embed/Hby1lTM0r6A");
        advertisementRepo.put(ad1.getId(), ad1);

        Advertisement ad2 = new Advertisement();
        ad2.setId(2);
        ad2.setContent("This is a second test");
        ad2.setUrlImage("http://www.francesoir.fr/sites/francesoir/files/cyril-hanouna-francesoir_field_mise_en_avant_principale.jpg");
        ad2.setUrlVideo("https://www.youtube.com/embed/Hby1lTM0r6A");
        advertisementRepo.put(ad2.getId(), ad2);
    }*/


    @Override
    public void createProduct(Advertisement product) {
        //advertisementRepo.put(product.getId(), product);
    }

    @Override
    public void updateProduct(String id, Advertisement adv) {
        advertisementRepo.remove(id);
        //adv.setId(id);
        advertisementRepo.put(id, adv);
    }

    @Override
    public void deleteProduct(String id) {
        advertisementRepo.remove(id);
    }

    @Override
    public Collection<Advertisement> getProducts() {
        return advertisementRepo.values();
    }
}
