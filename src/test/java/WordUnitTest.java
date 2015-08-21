import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
public class WordUnitTest {
  @Rule
  public ClearRule  clearRule= new ClearRule();

  @Test
  public void word_instantiatesCorrectly_true() {
    Word myWord = new Word("birthday");
    assertEquals(true, myWord instanceof Word);
  }

   @Test
   public void word_getWord() {
   Word myWord = new Word("birthday");
   assertEquals("birthday", myWord.getWord());
  }

   @Test
   public void word_getId() {
   Word myWord = new Word("birthday");
   assertEquals(1, myWord.getId());
   }

   @Test
   public void word_getAll() {
   Word myFirstWord = new Word("birthday");
   Word mySecondWord = new Word("happy");
   assertTrue(Word.getAll().contains(myFirstWord));
   }

   @Test
   public void word_getAll_equals() {
   Word myFirstWord = new Word("birthday");
   Word mySecondWord = new Word("happy");
   assertEquals(Word.getAll().size(),mySecondWord.getId());
   }

   @Test
   public void word_addDefinitions() {
   Word myFirstWord = new Word("birthday");
   Definition myDefinition = new Definition("happy");
   myFirstWord.addDefinition(myDefinition);
   assertTrue(myFirstWord.getDefinitions().contains(myDefinition));
   }

   @Test
   public void find_returnsNullWhenNoWordFound_null() {
   assertTrue(Word.find(999) == null);
   }

   @Test
   public void clear_emptiesAllWordsFromArrayList() {
   Word myTask = new Word("Mow the lawn");
   Word.clear();
   assertEquals(Word.getAll().size(), 0);
   }

   /*---------Definition Tests------------*/

   @Test
   public void definition_instantiatesCorrectly_true() {
     Definition myDefinition = new Definition("birthday");
     assertEquals(true, myDefinition instanceof Definition);
   }

    @Test
    public void definition_getDefinition() {
    Definition myDefinition = new Definition("birthday");
    assertEquals("birthday", myDefinition.getDefinition());
   }

    @Test
    public void definition_getId() {
    Definition myDefinition = new Definition("birthday");
    assertEquals(1, myDefinition.getId());
    }

    @Test
    public void definition_getAll() {
    Definition myFirstDefinition = new Definition("birthday");
    Definition mySecondDefinition = new Definition("happy");
    assertTrue(Definition.getAll().contains(myFirstDefinition));
    }

    @Test
    public void definition_getAll_equals() {
    Definition myFirstDefinition = new Definition("birthday");
    Definition mySecondDefinition = new Definition("happy");
    assertEquals(Definition.getAll().size(),mySecondDefinition.getId());
    }

    @Test
    public void find_returnsNullWhenNoDefinitionFound_null() {
    assertTrue(Definition.find(999) == null);
    }

    @Test
    public void clear_emptiesAllDefinitionsFromArrayList() {
    Definition myDefinition = new Definition("Mow the lawn");
    Definition.clear();
    assertEquals(Definition.getAll().size(), 0);
    }




}
