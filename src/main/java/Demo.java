import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import rx.Observable;
import rx.Subscription;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static demoobjects.DemoObservables.*;

@Slf4j
@SuppressWarnings("unused")
public class Demo {

  @SneakyThrows
  public static void main(String[] args) {
    Observable<Integer> observable = getIntegersError();


    Subscription sub =
      observable
        .filter(i -> i < 6)
        .map(i -> i * 2)
        .onErrorResumeNext(getIntegers())
        .subscribe(
          i -> log.info(i.toString()),
          e -> log.error("error", e));

    while (!sub.isUnsubscribed()) {
      Thread.sleep(100);
    }
  }

}
