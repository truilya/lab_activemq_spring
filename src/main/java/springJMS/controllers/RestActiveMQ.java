package springJMS.controllers;

import springJMS.jms.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RestActiveMQ {

    @Autowired
    private Producer jmsProducer;

    @RequestMapping("send")
    public String send(@RequestParam(name="text") String text) {
        try {
            jmsProducer.send("testQueue", text);
            return "OK";
        } catch (Exception e) {
            return "oops";
        }
    }

}
