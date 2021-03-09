package com.stratio.qa.store.service;

import com.stratio.qa.store.model.Customer;
import com.stratio.qa.store.service.external.AddressService;
import com.stratio.qa.store.service.external.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private AddressService addressService;

    @Autowired
    private HostService hostService;


    public String getPLZAddressCombination(Customer customer) {

        String result = Integer.toString(addressService.getPLZForCustomer(customer))
                + "_"
                + addressService.getAddressForCustomer(customer);

        return result;
    }

    public String getPLZAddressCombinationIncludingHostValue(Customer customer, boolean updateExternalSystems) {

        hostService.expand(customer);

        String result = Integer.toString(addressService.getPLZForCustomer(customer))
            + "_"
            + addressService.getAddressForCustomer(customer)
            + "_"
            + customer.getHostValue();

        if (updateExternalSystems) {
            addressService.updateExternalSystems(customer);
        }

        return result;
    }
}
