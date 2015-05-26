import intrayobjects.BoardInfo;
import intrayobjects.EisTask;
import intrayobjects.EisUser;
import intrayobjects.EisUserMetrics;
import rx.Observable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("unused")
public class Example {

  public static void main(String[] args) {

  }

  public static Observable<EisUser> retrieveUser() {
    return Observable.just(new EisUser(1, "Eis user"));
  }

  public static Observable<EisTask> retrieveTasks(EisUser user) {
    return Observable.range(1, 100)
        .map(i -> new EisTask(i, Math.random() > 0.5 ? 0 : 1))
        .delay(i -> Observable.empty().delay(
            Math.round(Math.random() * 5000), TimeUnit.MILLISECONDS));
  }

  public static Observable<EisUserMetrics> retrieveMetrics(EisUser user) {
    return Observable.just(new EisUserMetrics(Math.random() > 0.5))
        .delay(Math.round(Math.random() * 5000), TimeUnit.MILLISECONDS);
  }

  public static Observable<List<BoardInfo>> retrieveBoards(EisUser user) {
    return Observable.range(1, 100)
        .filter(i -> Math.random() > 0.5)
        .map(i -> new BoardInfo(i, "Board #" + i.toString(), "Person #" + i.toString()))
        .delay(i -> Observable.empty().delay(
            Math.round(Math.random() * 5000), TimeUnit.MILLISECONDS))
        .reduce(new ArrayList<>(), (accumlator, boardInfo) -> {
          accumlator.add(boardInfo);
          return accumlator;
        });
  }

}
