package henry.waasep2022aop.controller;

import henry.waasep2022aop.aspect.annotation.ExecutionTime;
import henry.waasep2022aop.dto.AddressDto;
import henry.waasep2022aop.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/addresses")
public class AddressController {
    private final AddressService addressService;

    @ExecutionTime
    @PostMapping
    public void save(@RequestBody AddressDto addressDto) {
        addressService.save(addressDto);
    }

    @ExecutionTime
    @GetMapping
    public List<AddressDto> getAll() {
        return addressService.findAll();
    }

    @ExecutionTime
    @PutMapping("/{addressId}")
    public void update(@PathVariable int addressId, @RequestBody AddressDto addressDto) {
        addressService.update(addressId, addressDto);
    }

    @ExecutionTime
    @DeleteMapping("/{addressId}")
    public AddressDto delete(@PathVariable int addressId) {
        return addressService.delete(addressId);
    }
}
