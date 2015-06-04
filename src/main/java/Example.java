import dashboardobjects.*;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import rx.Observable;
import rx.Subscription;

import java.util.List;


@Slf4j
@SuppressWarnings("unused")
public class Example {

  @SneakyThrows
  public static void main(String[] args) {
    Observable<EisUser> userObservable = retrieveUser();

    Observable<EisUserMetrics> metricsObservable =
      userObservable
        .flatMap(user -> retrieveMetrics(user));

    Observable<List<BoardInfo>> boardObservable =
      userObservable
        .flatMap(user -> retrieveBoards(user))
        .take(5)
        .toList();

    Observable<EisTask> allTasks =
      userObservable
        .flatMap(user -> retrieveTasks(user));

    Observable<List<EisTask>> taskObservable =
      allTasks
        .filter(task -> task.getPriority() == 0)
        .concatWith(allTasks)
        .distinct()
        .take(10)
        .toList();

    Subscription subscription = Observable.zip(
      userObservable, metricsObservable,
      taskObservable, boardObservable,
      (user, metrics, tasks, boards) ->
        new Dashboard(user, metrics, tasks, boards)
    ).subscribe(dashboard -> log.info(dashboard.toString()));

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
