package com.davidvlijmincx.workshop_server;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/VisitedService")
public class MultiServiceController {

    @PostMapping("/1")
    ResponseEntity<Object> service1(@RequestBody String a) throws InterruptedException {

        Thread.sleep(200);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/2")
    ResponseEntity<Object> service2(@RequestBody String a) throws InterruptedException {

        Thread.sleep(300);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/3")
    ResponseEntity<Object> service3(@RequestBody String a) {
     //   System.out.println("Visited URL = " + a);

        return ResponseEntity.ok().build();
    }




}
