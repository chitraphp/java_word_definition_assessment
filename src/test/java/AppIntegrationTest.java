import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.assertj.core.api.Assertions.assertThat;


public class AppIntegrationTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
  goTo("http://localhost:4567/");
  assertThat(pageSource()).contains("Word Definitions!");
  }

  @Test
  public void titleTest() {
  goTo("http://localhost:4567/");
  assertThat(title()).contains("Word-Definition");
  }

  @Test
  public void successsPage() {
  goTo("http://localhost:4567/");
  find("a", withText("Add a New Word")).click();
  fill("#word").with("moon");
  submit(".btn");
  assertThat(pageSource()).contains("Add a Word");
  }

  @Test
  public void rememberPreviousEntries() {
    goTo("http://localhost:4567/");
    find("a", withText("Add a New Word")).click();
    fill("#word").with("moon");
    submit(".btn");
    find("a", withText("Word List")).click();
    assertThat(pageSource()).contains("moon");
  }

  @Test
  public void rememberPreviousEntries2() {
    goTo("http://localhost:4567/");
    find("a", withText("Add a New Word")).click();
    fill("#word").with("moon");
    submit(".btn");
    fill("#word").with("blue");
    submit(".btn");
    find("a", withText("Word List")).click();
    assertThat(pageSource()).contains("moon");
    assertThat(pageSource()).contains("blue");
  }
}
