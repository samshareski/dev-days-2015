package demoobjects;

import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class DemoObservables {

  public static Observable<Integer> getIntegersForever() {
    return Observable.interval(200, TimeUnit.MILLISECONDS)
      .map(Long::intValue);
  }

  public static Observable<Integer> getIntegersOrdered() {
    return Observable.range(1, 10)
      .delay(500, TimeUnit.MILLISECONDS, Schedulers.immediate());
  }

  public static Observable<Integer> getIntegers() {
    return Observable.range(1, 10)
      .delay(i -> Observable.empty()
        .delay((Math.round(Math.random() * 10000000.0)) % 5000, TimeUnit.MILLISECONDS))
      .cache();
  }

  public static Observable<Integer> getIntegersError() {
    return Observable.range(1, 5)
      .concatWith(Observable.error(new RuntimeException()))
      .delay(500, TimeUnit.MILLISECONDS, Schedulers.immediate());
  }

}
