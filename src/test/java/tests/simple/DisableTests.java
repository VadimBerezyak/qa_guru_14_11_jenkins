package tests.simple;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DisableTests {

    @Test
    @Disabled("Testing paused by QA")
    void test1(){
        assertTrue(false);
    }

    @Test
    @Disabled("Testing paused by QA")
    void test2(){
        assertTrue(false);
    }


}
