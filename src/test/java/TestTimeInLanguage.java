import com.flipkart.Utils.PostHelper;
import org.junit.Test;

import java.time.LocalDateTime;


public class TestTimeInLanguage {
    @Test
    public void testTimeInLanguage(){
        LocalDateTime timeStamp=LocalDateTime.now();
        System.out.println(PostHelper.getTimeInLanguage(timeStamp));
        System.out.println(PostHelper.getTimeInLanguage(timeStamp.minusMinutes(50)));
        System.out.println(PostHelper.getTimeInLanguage(timeStamp.minusHours(10)));
        System.out.println(PostHelper.getTimeInLanguage(timeStamp.minusDays(2)));
        System.out.println(PostHelper.getTimeInLanguage(timeStamp.minusMonths(5)));
        System.out.println(PostHelper.getTimeInLanguage(timeStamp.minusYears(2)));
    }
}
