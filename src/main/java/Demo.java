import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import rx.Observable;
import rx.Subscription;

import static demoobjects.DemoObservables.*;

@Slf4j
@SuppressWarnings("unused")
public class Demo {

  @SneakyThrows
  public static void main(String[] args) {
    Observable<Integer> observable = null;

    Subscription sub = null;

    while (!sub.isUnsubscribed()) {
      Thread.sleep(100);
    }
  }

}
