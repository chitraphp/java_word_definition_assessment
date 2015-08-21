import org.junit.*;
import static org.junit.Assert.*;
public class WordUnitTest {
  @Rule
  public ClearRule  clearRule= new ClearRule();

  @Test
  public void word_instantiatesCorrectly_true() {
    Word myWord = new Word("Mow the lawn");
    assertEquals(true, myWord instanceof Word);
  }
}
