package personal.leo.serviceManager.controller;

import org.apache.sshd.client.SshClient;
import org.apache.sshd.client.session.ClientSession;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.time.Duration;

@CrossOrigin
@RestController
@RequestMapping("test")
public class TestController {

    SshClient client;
    ClientSession session;

    @PostConstruct
    private void postConstruct() throws IOException {
        client = SshClient.setUpDefaultClient();
        client.start();
        session = client.connect("root", "localhost", 22)
                .verify(Duration.ofSeconds(10))
                .getSession();
        session.auth().verify(Duration.ofSeconds(10));
    }


    @PostMapping("test")
    public String test(String cmd) throws IOException {
        final String output = session.executeRemoteCommand(cmd);
        System.out.println(output);
        return output;
    }


}
