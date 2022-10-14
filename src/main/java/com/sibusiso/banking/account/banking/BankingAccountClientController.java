package com.sibusiso.banking.account.banking;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/banking")
public class BankingAccountClientController {
    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "/savings/create/{account}/{amount}")
    public String createSavingsAccount(@PathVariable("account") String account, @PathVariable("amount") Double amount) {
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("SAVINGS-ACCOUNT-CLIENT", false);
        String savingServiceInstanceUrl = "http://" + instanceInfo.getAppName() + ":" + instanceInfo.getPort();

        ResponseEntity<String> response = restTemplate.exchange(savingServiceInstanceUrl + "/savings/create/" + account + "/" + amount,
                HttpMethod.GET, null, String.class);
        return response.getBody();
    }

    @GetMapping(value = "/savings/deposit/{account}/{amount}")
    public String depositSavingsAccount(@PathVariable("account") String account, @PathVariable("amount") Double amount) {
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("SAVINGS-ACCOUNT-CLIENT", false);
        String savingServiceInstanceUrl = "http://" + instanceInfo.getAppName() + ":" + instanceInfo.getPort();

        ResponseEntity<String> response = restTemplate.exchange(savingServiceInstanceUrl + "/savings/deposit/" + account + "/" + amount,
                HttpMethod.GET, null, String.class);
        return response.getBody();
    }

    @GetMapping(value = "/savings/draw/{account}/{amount}")
    public String drawSavingsAccount(@PathVariable("account") String account, @PathVariable("amount") Double amount) {
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("SAVINGS-ACCOUNT-CLIENT", false);
        String savingServiceInstanceUrl = "http://" + instanceInfo.getAppName() + ":" + instanceInfo.getPort();

        ResponseEntity<String> response = restTemplate.exchange(savingServiceInstanceUrl + "/savings/draw/" + account + "/" + amount,
                HttpMethod.GET, null, String.class);
        return response.getBody();
    }

    @GetMapping(value = "/savings/transfer/{fromAccountNumber}/{amount}/{toAccountNumber}")
    public String transferSavingsAccount(@PathVariable("fromAccountNumber") String fromAccountNumber,
                                         @PathVariable("amount") Double amount,
                                         @PathVariable("toAccountNumber") String toAccountNumber) {
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("SAVINGS-ACCOUNT-CLIENT", false);
        String savingServiceInstanceUrl = "http://" + instanceInfo.getAppName() + ":" + instanceInfo.getPort();

        ResponseEntity<String> response = restTemplate.exchange(savingServiceInstanceUrl + "/savings/transfer/{fromAccountNumber}" +
                        "/{amount}/{toAccountNumber}"+ fromAccountNumber + "/" + amount + "/" + toAccountNumber,
                HttpMethod.GET, null, String.class);
        return response.getBody();
    }

    @GetMapping(value = "/cheque/create/{account}/{amount}")
    public String createChequeAccount(@PathVariable("account") String account, @PathVariable("amount") Double amount) {
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("CHEQUE-ACCOUNT-CLIENT", false);
        String savingServiceInstanceUrl = "http://" + instanceInfo.getAppName() + ":" + instanceInfo.getPort();

        ResponseEntity<String> response = restTemplate.exchange(savingServiceInstanceUrl + "/cheque/create/" + account + "/" + amount,
                HttpMethod.GET, null, String.class);
        return response.getBody();
    }

    @GetMapping(value = "/cheque/deposit/{account}/{amount}")
    public String depositChequeAccount(@PathVariable("account") String account, @PathVariable("amount") Double amount) {
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("CHEQUE-ACCOUNT-CLIENT", false);
        String savingServiceInstanceUrl = "http://" + instanceInfo.getAppName() + ":" + instanceInfo.getPort();

        ResponseEntity<String> response = restTemplate.exchange(savingServiceInstanceUrl + "/cheque/deposit/" + account + "/" + amount,
                HttpMethod.GET, null, String.class);
        return response.getBody();
    }

    @GetMapping(value = "/cheque/draw/{account}/{amount}")
    public String drawChequeAccount(@PathVariable("account") String account, @PathVariable("amount") Double amount) {
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("CHEQUE-ACCOUNT-CLIENT", false);
        String savingServiceInstanceUrl = "http://" + instanceInfo.getAppName() + ":" + instanceInfo.getPort();

        ResponseEntity<String> response = restTemplate.exchange(savingServiceInstanceUrl + "/cheque/draw/" + account + "/" + amount,
                HttpMethod.GET, null, String.class);
        return response.getBody();
    }

    @GetMapping(value = "/cheque/transfer/{fromAccountNumber}/{amount}/{toAccountNumber}")
    public String transferChequeAccount(@PathVariable("fromAccountNumber") String fromAccountNumber,
                                         @PathVariable("amount") Double amount,
                                         @PathVariable("toAccountNumber") String toAccountNumber) {
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("CHEQUE-ACCOUNT-CLIENT", false);
        String savingServiceInstanceUrl = "http://" + instanceInfo.getAppName() + ":" + instanceInfo.getPort();

        ResponseEntity<String> response = restTemplate.exchange(savingServiceInstanceUrl + "/cheque/transfer/{fromAccountNumber}" +
                        "/{amount}/{toAccountNumber}"+ fromAccountNumber + "/" + amount + "/" + toAccountNumber,
                HttpMethod.GET, null, String.class);
        return response.getBody();
    }
}
