import java.util.ArrayList;
public class Definition {
  private static ArrayList<Definition> definitionList = new ArrayList<Definition>();

  private String mDefinition;
  private int mId;

  public Definition(String definition) {
    mDefinition = definition;
    definitionList.add(this);
    mId = definitionList.size();
  }

  public String getDefinition() {
    return mDefinition;
  }

  public int getId() {
    return mId;
  }

  public static ArrayList<Definition> getAll() {
    return definitionList;
  }

  public static Definition find(int id) {
    try {
      return definitionList.get(id - 1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

  public static void clear() {
    definitionList.clear();
  }

}
