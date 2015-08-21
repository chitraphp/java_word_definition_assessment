import java.util.ArrayList;
public class Word {
  private static ArrayList<Word> wordList = new ArrayList<Word>();
  private String mWord;
  private int mId;
  private ArrayList<Definition> mDefinitions;

  public Word(String word) {
    mWord = word;
    wordList.add(this);
    mId = wordList.size();
    mDefinitions = new ArrayList<Definition>();
  }

  public String getWord() {
    return mWord;
  }

  public int getId() {
  return mId;
  }

  public ArrayList<Definition> getDefinitions() {
    return mDefinitions;
  }

  public void addDefinition(Definition definition) {
    mDefinitions.add(definition);
  }

  public static ArrayList<Word> all() {
    return wordList;
  }

  public static void clear() {
    wordList.clear();
  }

  public static Word find(int id) {
    try {
      return wordList.get(id - 1);
    } catch (IndexOutOfBoundsException exception) {
      return null;
    }
  }


}
