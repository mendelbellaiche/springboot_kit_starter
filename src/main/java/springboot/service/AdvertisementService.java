package springboot.service;

import springboot.model.Advertisement;
import java.util.Collection;

public interface AdvertisementService {

    public abstract void createProduct(Advertisement product);
    public abstract void updateProduct(String id, Advertisement product);
    public abstract void deleteProduct(String id);
    public abstract Collection<Advertisement> getProducts();

}
