package serverTesting;

import client.Message;
import client.services.MessageService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class MessageTest {

    @Mock
    RestTemplate restTemplate;

    @InjectMocks
    MessageService messageService = new MessageService();

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetMessage()
    {
        Message message = new Message(0, "Hello, nume");

        Mockito
                .when(restTemplate.getForObject("http://localhost:8080/greeting", Message.class))
                .thenReturn(message);

        Message msg = messageService.getMessage(restTemplate, "http://localhost:8080/greeting");

        Assert.assertEquals(message, msg);
    }

    @Test
    public void testGetMessageSpecificName()
    {
        Message message = new Message(0, "Hello, ServerName");

        Mockito
                .when(restTemplate.getForObject("http://localhost:8080/greeting?name=ServerName", Message.class))
                .thenReturn(message);

        Message msg = messageService.getMessage(restTemplate, "http://localhost:8080/greeting?name=ServerName");

        Assert.assertEquals(message, msg);
    }

}
