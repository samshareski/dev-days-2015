import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

@Slf4j
@SuppressWarnings("unused")
public class Demo {

  @SneakyThrows
  public static void main(String[] args) {
  }

  private static Observable<Integer> getIntegersSync() {
    return Observable.range(11, 20)
        .delay(500, TimeUnit.MILLISECONDS, Schedulers.immediate());
  }

  private static Observable<Integer> getIntegers() {
    return Observable.range(1, 10)
        .delay(i -> Observable.empty()
            .delay((Math.round(Math.random() * 10000000.0)) % 5000, TimeUnit.MILLISECONDS));
  }

}
