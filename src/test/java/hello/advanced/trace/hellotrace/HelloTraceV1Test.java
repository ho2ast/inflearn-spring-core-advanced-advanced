package hello.advanced.trace.hellotrace;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloTraceV1Test {
  @Test
  void test() throws Exception {
    TraceId id = new TraceId();
    System.out.println("id = " + id.getId());
    System.out.println("level = " + id.getLevel());
    System.out.println("isItFirst? = " + id.isFirstLevel());
    TraceId nextLevel = id.createNextId();
    System.out.println("id = " + nextLevel.getId());
    System.out.println("level = " + nextLevel.getLevel());
    System.out.println("isItFirst? = " + nextLevel.isFirstLevel());
  }

//  @Test
//  void begin_end() throws Exception {
//    HelloTraceV1 trace = new HelloTraceV1();
//    TraceStatus status = trace.begin("hello");
//    trace.end(status);
//  }
//
//  @Test
//  void begin_exception() throws Exception {
//    HelloTraceV1 trace = new HelloTraceV1();
//    TraceStatus status = trace.begin("hello");
//    trace.exception(status, new IllegalStateException());
//  }

}