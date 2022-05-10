package junit;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FirstJUnitTest {
    @BeforeEach

    void before() {
        System.out.println("This method will execute before each test");

    }

    @AfterEach

    void after() {
        System.out.println("This method will execute after each test");

    }

    @Test
    void textTest() {
        // text search
        Assertions.assertTrue(2<4);
    }

    @Test
    void videoTest() {
        // video search
        Assertions.assertTrue(2<4);
    }
}
