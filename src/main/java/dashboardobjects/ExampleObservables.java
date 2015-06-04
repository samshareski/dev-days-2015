package dashboardobjects;

import rx.Observable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ExampleObservables {

  public static Observable<EisUser> retrieveUser() {
    return Observable.just(new EisUser(1, "Eis user"));
  }

  public static Observable<EisTask> retrieveTasks(EisUser user) {
    List<EisTask> taskList = Arrays.asList(new EisTask(1, 0),
      new EisTask(2, 0),
      new EisTask(3, 1),
      new EisTask(4, 1),
      new EisTask(5, 1),
      new EisTask(6, 0),
      new EisTask(7, 0),
      new EisTask(8, 1),
      new EisTask(9, 1),
      new EisTask(10, 1),
      new EisTask(11, 0),
      new EisTask(12, 1),
      new EisTask(13, 1),
      new EisTask(14, 1),
      new EisTask(15, 1),
      new EisTask(16, 1),
      new EisTask(17, 1),
      new EisTask(18, 1),
      new EisTask(19, 1),
      new EisTask(20, 1),
      new EisTask(21, 1),
      new EisTask(22, 1),
      new EisTask(23, 1),
      new EisTask(24, 1),
      new EisTask(25, 1));
    return Observable.from(taskList)
      .delay(i -> Observable.empty().delay(
        Math.round(Math.random() * 5000), TimeUnit.MILLISECONDS));
  }

  public static Observable<EisUserMetrics> retrieveMetrics(EisUser user) {
    return Observable.just(new EisUserMetrics(Math.random() > 0.5))
      .delay(Math.round(Math.random() * 5000), TimeUnit.MILLISECONDS);
  }

  public static Observable<List<BoardInfo>> retrieveBoards(EisUser user) {
    return Observable.range(1, 10)
      .filter(i -> Math.random() > 0.5)
      .map(i -> new BoardInfo(i, "Board #" + i.toString(), "Person #" + i.toString()))
      .delay(i -> Observable.empty().delay(
        Math.round(Math.random() * 5000), TimeUnit.MILLISECONDS))
      .reduce(new ArrayList<BoardInfo>(), (accumlator, boardInfo) -> {
        accumlator.add(boardInfo);
        return accumlator;
      });
  }

}
