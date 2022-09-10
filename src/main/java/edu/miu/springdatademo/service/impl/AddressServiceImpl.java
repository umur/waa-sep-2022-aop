package edu.miu.springdatademo.service.impl;

import edu.miu.springdatademo.dto.AddressDTO;
import edu.miu.springdatademo.entity.Address;
import edu.miu.springdatademo.repo.AddressRepo;
import edu.miu.springdatademo.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Pointcut;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<AddressDTO> getAllAddress() {
        List<Address> addresses= addressRepo.findAll();

        List<AddressDTO> collect = addresses.stream().map(address -> modelMapper.map(address, AddressDTO.class))
                .collect(Collectors.toList());
        return collect;
    }

    @Override
    public AddressDTO getAddressById(Integer id) {
        return  modelMapper.map(addressRepo.findById(id).orElseThrow(() -> new RuntimeException("Invalid ID!")), AddressDTO.class);
    }

    @Override
    public AddressDTO SaveAddress(AddressDTO addressDTO) {
        Address address=modelMapper.map(addressDTO,Address.class);
        address=addressRepo.save(address);
        return modelMapper.map(address,AddressDTO.class);

    }

//    @Pointcut("@annotation(edu.miu.springdatademo.ExecutionTime)")
//    private void executionTimePointcut() {}
//
//    @Advice()
//    public void advice() {
//        long startTimeMili = System.currentTimeMillis();
//        // some service call e.g email send, some operations
//        // .proceed()
//        long duration = System.currentTimeMillis() - startTimeMili;
//
//        // ActivityLog save ActivityTimeLog (id,date,operation,duration)
//    }

    //public void advice() {
//        long startTimeMili = System.currentTimeMillis();
//        // some service call e.g email send, some operations
//        // .proceed()
//        long duration = System.currentTimeMillis() - startTimeMili;
//
//        ActivityLog activityLog = new ActivityLog();
//        activityLog.setDate(new LocalDateTime.now())
//        avitiyLogService.save(activityLog);
//        // ActivityLog save ActivityTimeLog (id,date,operation,duration)
//    }

    @Override
    public AddressDTO updateAddress(AddressDTO addressDTO, Integer id) {
        if (id!=addressDTO.getId()) throw new RuntimeException("Invalid Id ");
        Address address=modelMapper.map(addressDTO,Address.class);
        Address address1=addressRepo.save(address);
        return modelMapper.map(address1, AddressDTO.class);

    }

    @Override
    public AddressDTO deleteAddress(Integer id) {
        Address address=addressRepo.findById(id).orElseThrow(()->new RuntimeException("element not available"));
        addressRepo.delete(address);
        return modelMapper.map(address,AddressDTO.class);

    }
}
