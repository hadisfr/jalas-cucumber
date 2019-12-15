package ir.ac.ut.ece.jalas;

import java.util.ArrayList;
import java.util.List;

public class Jalas {
    MailSender mailSender;
    List<Poll> polls;

    public Jalas() {
        this.mailSender = new MailSender();
        polls = new ArrayList<Poll>();
    }

    public void addNewPoll(Poll poll) {
        polls.add(poll);
    }

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void vote(Poll poll, String voter, String option) {
        poll.vote(option);
        mailSender.sendMailTo(voter);
    }
}
