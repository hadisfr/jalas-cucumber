package ir.ac.ut.ece.jalas;

import java.util.ArrayList;
import java.util.List;

public class AlwaysSuccessfulMailSenderMock extends MailSender {
    List<String> receivers;

    public AlwaysSuccessfulMailSenderMock() {
        this.receivers = new ArrayList<String>();
    }

    @Override
    public boolean sendMailTo(String voter) {
        receivers.add(voter);
        return true;
    }

    public boolean hasSendMailTo(String receiver) {
        return receivers.contains(receiver);
    }
}
