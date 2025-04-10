package phucnh.qlbh.aop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestAOPController {
    private final TestAOP testAOP;

    public TestAOPController(TestAOP testAOP) {
        this.testAOP = testAOP;
    }

    @GetMapping("/TestAOP")
    public void runTestAOP() {
        //testAOP.showPersonInfo();
        //testAOP.read();
        //testAOP.write();
    }
}
