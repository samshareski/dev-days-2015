import dashboardobjects.*;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import rx.Observable;
import rx.Subscription;


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

  private static Observable<EisUser> retrieveUser() {
    return ExampleObservables.retrieveUser();
  }

  private static Observable<EisTask> retrieveTasks(EisUser user) {
    return ExampleObservables.retrieveTasks(user);
  }

  private static Observable<EisUserMetrics> retrieveMetrics(EisUser user) {
    return ExampleObservables.retrieveMetrics(user);
  }

  private static Observable<BoardInfo> retrieveBoards(EisUser user) {
    return ExampleObservables.retrieveBoards(user);
  }


}
