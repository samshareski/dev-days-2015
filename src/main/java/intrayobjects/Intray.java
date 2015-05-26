package intrayobjects;

import lombok.Data;

import java.util.List;

@Data
public class Intray {

  private final EisUser eisUser;
  private final EisUserMetrics eisUserMetrics;
  private final List<EisTask> eisTasks;
  private final List<BoardInfo> boardInfo;

}
