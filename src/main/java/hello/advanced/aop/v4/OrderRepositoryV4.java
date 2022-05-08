package hello.advanced.aop.v4;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV4 {

  private final LogTrace trace;

  public void save(String itemId) {

    AbstractTemplate<Void> template = new AbstractTemplate<Void>(trace) {
      @Override
      protected Void call() {
        //저장로직
        if (itemId.equals("ex")) {
          throw new IllegalStateException("예외발생");
        }
        sleep(1000);
        return null;
      }
    };

    template.execute("OrderRepository.save()");

//    TraceStatus status = null;
//    try {
//      status = trace.begin("OrderRepository.save()");
//
//      //저장로직
//      if (itemId.equals("ex")) {
//        throw new IllegalStateException("예외발생");
//      }
//      sleep(1000);
//
//      trace.end(status);
//    } catch (Exception e) {
//      trace.exception(status, e);
//      throw e; //예외를 꼭 다시 던져주어야 한다.
//    }
  }

  private void sleep(int mills) {
    try {
      Thread.sleep((mills));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
