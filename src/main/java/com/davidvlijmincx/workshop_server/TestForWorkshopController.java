package com.davidvlijmincx.workshop_server;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping(value = "/v1/crawl/")
public class TestForWorkshopController {

    @GetMapping("{a}/{b}")
    String randomPage(@PathVariable String a, @PathVariable String b){
        return generateHtmlPageWithUrls(10);
    }

    @GetMapping("/delay/{a}/{b}")
    String randomPageWithDelay(@PathVariable String a, @PathVariable String b){
        // show what impact the timer has on the threads
        Random r = new Random();
        try {
            Thread.sleep(r.nextInt(10, 200));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return generateHtmlPageWithUrls(10);
    }


    private String generateHtmlPageWithUrls(int numberOfUrls){
        StringBuilder s = new StringBuilder();

        Random r = new Random();

        s.append("<html>");
        s.append("<body>");

        for (int i = 0; i < numberOfUrls; i++) {
            int n = r.nextInt(0,numberOfUrls + 1000);
            int n1 = r.nextInt(0,numberOfUrls + 1000);

            s.append("<a href=\"http://localhost:8080/v1/crawl/").append(n1).append("/").append(n).append("\">i am a random url ").append(i).append(" ").append(n1).append("</a><br/>");
        }

        s.append("</body>");
        s.append("</html>");

        return s.toString();
    }
}
