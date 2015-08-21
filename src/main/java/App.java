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
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("word/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/word-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/word", (request,response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String word = request.queryParams("cword");
      Word wordrd = new Word(word);
      model.put("newWord", newCategory);
      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/words", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("words", word.getAll());
      model.put("template", "templates/word.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("words/:id/definition/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Word word = Word.find(Integer.parseInt(request.params("id")));
      ArrayList<Definition> definitions = word.getDefinitions();
      model.put("word", word);
      model.put("definitions", definitions);
      model.put("template", "templates/word-definition-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/definition", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      Word word = Word.find(Integer.parseInt(requewordParams("wordId")));
      ArrayList<Definition> definitions = word.getDefinitions();

      if (definitions == null) {
        definitions = new ArrayList<Definitions>();
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
