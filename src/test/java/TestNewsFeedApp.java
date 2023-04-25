import com.flipkart.CommandLineService.CommandExecutorFactory;
import com.flipkart.CommandLineService.NewsFeedCommands;
import com.flipkart.Exceptions.BadCommandException;
import com.flipkart.Exceptions.InvalidPostException;
import com.flipkart.Exceptions.InvalidUserException;
import com.flipkart.Exceptions.UserAlreadyExistsException;
import org.junit.Test;

public class TestNewsFeedApp {
    CommandExecutorFactory commandExecutorFactory=CommandExecutorFactory.getInstance();
    @Test
    public void testcase1(){
        String[] commands={"signup David",
                "login David",
                "post Welcome!",
                "SignUp John",
                "login John",
                "follow David",
                "SHOWNEWSFEED",
                "reply 1 thanks",
                "post Welcome Harry",
                "Signup Harry",
                "login Harry",
                "follow David",
                "Follow John",
                "shownewsFEED",
                "reply 3 thanks",
                "upvote 3",
                "login David",
                "follow Harry",
                "follow John",
                "upvote 2",
                "reply 2 takecare",
                "login Harry",
                "shownewsfeed"
        };

        for(String command:commands){
            String[] commandLine=command.split(" ");
            try {
                commandExecutorFactory.getCommandExecutor(NewsFeedCommands.valueOf(commandLine[0].toUpperCase())).execute(commandLine);
            }  catch (BadCommandException | UserAlreadyExistsException | InvalidPostException | InvalidUserException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
