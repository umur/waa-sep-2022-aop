package WAA.spring.data.services.imple;

import WAA.spring.data.entity.Address;
import WAA.spring.data.repository.AddressRepo;
import WAA.spring.data.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceIplme implements AddressService {
    @Autowired
    private AddressRepo addressRepo;

    @Override
    public void save(Address address) {
        addressRepo.save(address);

    }

    @Override
    public Address getById(int id) {
        return addressRepo.findById(id).orElse(null);
    }

    @Override
    public void update(int id, Address addressreq) {
    Address address =addressRepo.findById(id).orElse(null);

    address.setCity(addressreq.getCity());
    address.setStreet(addressreq.getStreet());
    address.setZip(addressreq.getZip());


    }

    @Override
    public void delete(int id) {
        Address address =addressRepo.findById(id).orElse(null);
        addressRepo.delete(address);
    }

    @Override
    public List<Address> findAll() {
        return (List<Address>) addressRepo.findAll();
    }
}
