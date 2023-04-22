package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
// @Component   // 이 클래스도 스프링빈으로 등록해 줘야 함. @Component를 사용할 수 있지만 보통 직접 지정해서 등록하는 방법을 많이 사용
public class TimeTraceAop {

    @Around("execution(* hello.hellospring..*(..)) " +      // hello.hellospring 하위에 있는 것들 모두에 적용
            "&& !target(hello.hellospring.SpringConfig)")   // 순환참조 발생 방지를 위해 이 조건을 넣어야 함
            // SpringConfig도 hellospring 패키지 하위에 있는데, TimeTraceAop 클래스를 빈으로 등록하는 코드가 있기 때문에 순환참조 발생
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }
}
