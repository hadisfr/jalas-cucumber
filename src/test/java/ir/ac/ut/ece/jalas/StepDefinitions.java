package ir.ac.ut.ece.jalas;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Map;

public class StepDefinitions {

    Jalas jalas;
    Poll poll;
    AlwaysSuccessfulMailSenderMock mailSenderMock;

    @Given("a poll exists with options like:")
    public void aPollExistsWithOptionsLike(io.cucumber.datatable.DataTable dataTable) {
        jalas = new Jalas();
        poll = new Poll("Question", dataTable.asList());
        jalas.addNewPoll(poll);
        mailSenderMock = new AlwaysSuccessfulMailSenderMock();
    }

    @Given("previous votes are like:")
    public void previousVotesAreLike(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : table)
            poll.setVotes(row.get("Option"), Integer.parseInt(row.get("Votes")));
    }

    @When("{} votes to {}")
    public void aNewVoterVotesTo(String voter, String option) {
        jalas.vote(poll, voter, option);
    }

    @Then("votes should be like:")
    public void votesShouldBeLike(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : table)
            Assert.assertEquals(poll.getVotes(row.get("Option")), Integer.parseInt(row.get("Votes")));
    }

    @Given("mail server is up")
    public void mailServerIsUp() {
        jalas.setMailSender(mailSenderMock);
    }

    @When("a mail notification should be sent to {}")
    public void aMailNotificationShouldBeSentTo(String receiver) {
        Assertions.assertTrue(mailSenderMock.hasSentMailTo(receiver));
    }
}
