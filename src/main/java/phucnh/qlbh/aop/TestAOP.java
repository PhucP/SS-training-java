package phucnh.qlbh.aop;

import org.springframework.stereotype.Component;

@Component
public class TestAOP {
    public void showPersonInfo() {
        System.out.println("this is log show person info");
    }

    public void write() {
        System.out.println("writing");
    }

    public void read() {
        System.out.println("reading");
    }
}
