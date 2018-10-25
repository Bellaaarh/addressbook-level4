package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalTransactions.getUniqueFinancialDatabase;

import org.junit.Test;

import seedu.address.logic.CommandHistory;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.transaction.Deadline;


public class AnalyticsCommandTest {
    private CommandHistory history = new CommandHistory();
    private Model model = new ModelManager();
    private Model expectedModel = new ModelManager();
    private Model modelWithData = new ModelManager(getUniqueFinancialDatabase(), new UserPrefs());
    private Model expectedModelWithData = new ModelManager(getUniqueFinancialDatabase(), new UserPrefs());


    @Test
    public void execute_emptyFinancialListWithNoDate() {
        String expectedMessage = "Financial status : SGD 0.00";
        AnalyticsCommand analyticsCommand = new AnalyticsCommand();
        assertCommandSuccess(analyticsCommand, model, history, expectedMessage, expectedModel);
    }
    
    @Test
    public void execute_emptyFinancialListWithDate_When_DatePassed_Then_TestWillFail() {
        String date = "12/12/2020";
        Deadline checkDate = new Deadline(date);
        String expectedMessage = "Financial status : SGD 0.00";
        AnalyticsCommand analyticsCommand = new AnalyticsCommand(checkDate);
        assertCommandSuccess(analyticsCommand, model, history, expectedMessage, expectedModel);
    }

    @Test
    public void execute_non_emptyFinancialListWithNoDate() {
        String expectedMessage = "Financial status : SGD 188.10";
        AnalyticsCommand analyticsCommand = new AnalyticsCommand();
        assertCommandSuccess(analyticsCommand, modelWithData, history, expectedMessage, expectedModelWithData);
    }
    
    @Test
    public void execute_non_emptyFinancialListWithDate_When_DatePassed_Then_TestWillFail() {
        String date = "11/11/2018";
        Deadline checkDate = new Deadline(date);
        String expectedMessage = "Financial status : SGD 0.00";
        AnalyticsCommand analyticsCommand = new AnalyticsCommand(checkDate);
        assertCommandSuccess(analyticsCommand, modelWithData, history, expectedMessage, expectedModelWithData);
    }

    @Test
    public void execute_non_emptyFinancialListWithDateTest2_When_DatePassed_Then_TestWillFail() {
        String date = "12/11/2018";
        Deadline checkDate = new Deadline(date);
        String expectedMessage = "Financial status : SGD 85.00";
        AnalyticsCommand analyticsCommand = new AnalyticsCommand(checkDate);
        assertCommandSuccess(analyticsCommand, modelWithData, history, expectedMessage, expectedModelWithData);
    }

    @Test
    public void execute_non_emptyFinancialListWithDateTest3_When_DatePassed_Then_TestWillFail() {
        String date = "18/11/2018";
        Deadline checkDate = new Deadline(date);
        String expectedMessage = "Financial status : SGD 230.60";
        AnalyticsCommand analyticsCommand = new AnalyticsCommand(checkDate);
        assertCommandSuccess(analyticsCommand, modelWithData, history, expectedMessage, expectedModelWithData);
    }
    
    @Test
    public void execute_non_emptyFinancialListWithDateTest4_When_DatePassed_Then_TestWillFail() {
        String date = "12/12/2018";
        Deadline checkDate = new Deadline(date);
        String expectedMessage = "Financial status : SGD 188.10";
        AnalyticsCommand analyticsCommand = new AnalyticsCommand(checkDate);
        assertCommandSuccess(analyticsCommand, modelWithData, history, expectedMessage, expectedModelWithData);
    }
}
