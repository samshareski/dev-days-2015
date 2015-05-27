import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import rx.Observable;
import rx.Subscription;
import rx.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

@Slf4j
@SuppressWarnings("unused")
public class Demo {

  @SneakyThrows
  public static void main(String[] args) {
    Subscription sub = null;

    while (!sub.isUnsubscribed()) {
      Thread.sleep(100);
    }
  }

  private static Observable<Integer> getIntegersOrdered() {
    return Observable.range(11, 10)
        .delay(500, TimeUnit.MILLISECONDS, Schedulers.immediate());
  }

  private static Observable<Integer> getIntegers() {
    return Observable.range(1, 10)
        .delay(i -> Observable.empty()
            .delay((Math.round(Math.random() * 10000000.0)) % 5000, TimeUnit.MILLISECONDS));
  }

  private static Observable<Integer> getIntegersError() {
    return Observable.range(1, 5)
        .concatWith(Observable.error(new RuntimeException()))
        .delay(500, TimeUnit.MILLISECONDS, Schedulers.immediate());
  }

}
