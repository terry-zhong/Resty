package cn.dreampie.example;

import cn.dreampie.util.json.Jsoner;
import cn.dreampie.util.json.ModelDeserializer;
import cn.dreampie.util.json.ModelSerializer;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ice on 14-12-31.
 */
public class JsonTest {
  @Before
  public void setUp() throws Exception {
    ActiveRecord.init();
  }

  @Test
  public void testJson() {
    User user = new User();
    user.put("test", "test");
    Jsoner.addSerializer(User.class, ModelSerializer.instance());
    String json = Jsoner.toJSONString(user);
    System.out.println(json);
    Jsoner.addDeserializer(User.class, ModelDeserializer.instance());
    User t = (User) Jsoner.parseObject("{\"key\":\"value\"}", User.class);
    System.out.println(t.get("key"));
  }
}
