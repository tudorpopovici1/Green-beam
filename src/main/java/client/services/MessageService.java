package client.services;

import client.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MessageService {

    public Message getMessage(RestTemplate restTemplate, String url)
    {
        Message result = restTemplate.getForObject(url, Message.class);

        System.out.println(result.toString());

        return result;
    }

}
