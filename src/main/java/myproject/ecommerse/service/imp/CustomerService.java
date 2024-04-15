package myproject.ecommerse.service.imp;

import lombok.RequiredArgsConstructor;
import myproject.ecommerse.dto.CustomerDTO;
import myproject.ecommerse.exception.CustomerNotFoundException;
import myproject.ecommerse.model.Address;
import myproject.ecommerse.model.Customer;
import myproject.ecommerse.model.Review;
import myproject.ecommerse.repository.AddressRepository;
import myproject.ecommerse.repository.CustomerRepo;
import myproject.ecommerse.service.ICustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CustomerService implements ICustomerService {

    private final CustomerRepo customerRepo;
    private final ModelMapper modelMapper;
    private final AddressRepository addressRepo;
    @Override
//    public CustomerDTO addCustomer(CustomerDTO customerDTO) {
////        customerDTO.getAddressList().stream().forEach(address -> {
////            address.
////        });
//        Customer customer = modelMapper.map(customerDTO, Customer.class);
//        if(customer != null) {
//
//            List<Address> address = customerDTO.getAddressList()
//                    .stream().map(address1 -> modelMapper.map(address1, Address.class))
//                    .toList();
//            if (address != null){
//                customer.setAddressList(address);
//                customerRepo.save(customer);
//            }
//            else {
//              address =null;
//            }
//
//        }
//
//        return modelMapper.map( customerRepo.save(customer), CustomerDTO.class);
//    }

//    public CustomerDTO addCustomer(CustomerDTO customerDTO) {
//        Customer customer = modelMapper.map(customerDTO, Customer.class);
//if (customerDTO.getAddressList() != null) {
//            List<Address> addressList = customerDTO.getAddressList()
//                    .stream()
//                    .map(addressDTO -> modelMapper.map(addressDTO, Address.class))
//                    .toList();
//customer.setAddressList(addressList);
//        }
//Customer customer1 =customerRepo.save(customer);
//return modelMapper.map(customer1, CustomerDTO.class);
//    }

    public CustomerDTO addCustomer(CustomerDTO customerDTO) {
        Customer customer = modelMapper.map(customerDTO, Customer.class);

        List<Address> addressList = Optional.ofNullable(customerDTO.getAddressList())
                .orElseGet(Collections::emptyList)
                .stream()
                .map(addressDTO -> addressDTO.getAddressId() != null ?
                        addressRepo.findById(addressDTO.getAddressId()).orElse(null) :
                        addressRepo.save(modelMapper.map(addressDTO, Address.class)))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

       customer.setAddressList(addressList);
       // customer.getAddressList().addAll(addressList);

        return modelMapper.map(customerRepo.save(customer), CustomerDTO.class);
    }
//
//
//    public CustomerDTO addCustomer(CustomerDTO customerDTO) {
//        Customer customer = modelMapper.map(customerDTO, Customer.class);
//
//        List<Address> addressList = customerDTO.getAddressList().stream()
//                .map(addressDTO -> {
//                    if (addressDTO.getAddressId() != null) {
//                        return addressRepo.findById(addressDTO.getAddressId()).orElse(null);
//                    } else {
//                        return addressRepo.save(modelMapper.map(addressDTO, Address.class));
//                    }})
//                .filter(Objects::nonNull)
//                .collect(Collectors.toList());
//
//        customer.setAddressList(addressList);
//
//        return modelMapper.map(customerRepo.save(customer), CustomerDTO.class);
//    }


    @Override
    public List<CustomerDTO> getAllCustomers() {

         List<Customer> customer = customerRepo.findAll();
        return customer.stream().
                map(customer1 -> modelMapper.map(customer1, CustomerDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(int id) {
        Customer customer= customerRepo.findById(id)
                .orElseThrow(()->new CustomerNotFoundException("Customer is not exist in the system"));
        return modelMapper.map(customer, CustomerDTO.class);


    }

    @Override
    public void deleteCustomer(int id) {
        Customer customer= customerRepo.findById(id).orElseThrow(()->
                new CustomerNotFoundException("The customer with ID " + id +" Is already deleted or not exist"));
        customerRepo.delete(customer);

    }

    @Override
    public void updateCustomer(int id, CustomerDTO customerDTO) {
        Customer existcustomer= customerRepo.findById(id).orElseThrow(()->
                new CustomerNotFoundException("The customer with ID " + id +" Is already deleted or not exist"));

        existcustomer.setFirstName(customerDTO.getFirstName());
        existcustomer.setLastName(customerDTO.getLastName());
        existcustomer.setEmail(customerDTO.getEmail());

          modelMapper.map(customerRepo.save(existcustomer), CustomerDTO.class);

    }
}
