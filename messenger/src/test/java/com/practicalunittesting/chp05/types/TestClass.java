package com.practicalunittesting.chp05.types;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class TestClass {

    private static final String MESSAGE = "Some message";
    private static final String PREPARED_MESSAGE = "Prepared message";
    private static final String EMAIL = "example@mail.com";
    private  final Client client = mock(Client.class);

    private final MailServer server = mock(MailServer.class);
    private final TemplateEngine templateEngine = mock(TemplateEngine.class);
    @Test
    void testMailServerCall(){
        when(client.getEmail())
                .thenReturn(EMAIL);
        when(templateEngine.prepareMessage(MESSAGE, client))
                .thenReturn(PREPARED_MESSAGE);

        Messenger testedMessenger = new Messenger(server, templateEngine);
        testedMessenger.sendMessage(client, MESSAGE);
        verify(server).send(EMAIL, PREPARED_MESSAGE);
    }
    @Test
    void testTemplateEngineCalling(){

    }

}
