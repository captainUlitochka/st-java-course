package ru.stqa.pft.rest;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.jayway.restassured.RestAssured;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class TestBase {

 // @BeforeClass
  public void init() {
    RestAssured.authentication = RestAssured.basic("288f44776e7bec4bf44fdfeb1e646490", "");
  }

  public String status(int issue_id) {
    String json = RestAssured
            .get(String.format("https://bugify.stqa.ru/api/issues/" + issue_id + ".json"))
            .asString();
    JsonElement parsed = new JsonParser().parse(json);
    String status = parsed.getAsJsonObject()
            .get("issues").getAsJsonArray().get(0).getAsJsonObject()
            .get("state_name").getAsString();
    return status;
  }

  public boolean isIssueOpen(int issueId) {
    if (!status(issueId).equals("Resolved")) {
      return true;
    } else
      return false;
  }

  public void skipIfNotFixed(int issueId) throws IOException {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }
}