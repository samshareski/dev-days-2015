import dashboardobjects.EisUser;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import rx.Observable;
import rx.Subscription;

import static dashboardobjects.ExampleObservables.*;

@Slf4j
@SuppressWarnings("unused")
public class Example {

  @SneakyThrows
  public static void main(String[] args) {
    Observable<EisUser> userObservable = retrieveUser();

    Subscription subscription = null;

    while (!subscription.isUnsubscribed()) {
      Thread.sleep(100);
    }
  }

}
