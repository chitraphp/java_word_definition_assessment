import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/indexOne.vtl");
      model.put("words", Word.getAll());
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("word/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/word-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("words/:id/definitions", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Word word = Word.find(Integer.parseInt(request.params(":id")));
      System.out.println(word.getWord());
      ArrayList<Definition> definitions = word.getDefinitions();
      model.put("word", word);
      model.put("words",Word.getAll());
      model.put("definitions", definitions);
      model.put("template", "templates/indexOne.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("words/:id/definition/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Word word = Word.find(Integer.parseInt(request.params(":id")));
      System.out.println(word.getWord());
      ArrayList<Definition> definitions = word.getDefinitions();
      model.put("word", word);
      model.put("definitions", definitions);
      model.put("template", "templates/word-definition-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/word", (request,response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String word = request.queryParams("word");
      Word newWord = new Word(word);
      model.put("words", Word.getAll());
      model.put("template", "templates/word-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/definition", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      Word word = Word.find(Integer.parseInt(request.queryParams("wordId")));
      ArrayList<Definition> definitions = word.getDefinitions();

      if (definitions == null) {
        definitions = new ArrayList<Definition>();
      }

      String definition = request.queryParams("definition");
      Definition newDefinition = new Definition(definition);

      definitions.add(newDefinition);

      model.put("definitions", definitions);
      model.put("word", word);
      model.put("template", "templates/word-definition-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());




  }
}
