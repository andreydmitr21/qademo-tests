package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

public class FirstJUnitTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll");

    }
    @AfterAll
    static void afterAll() {
        System.out.println("afterAll");

    }

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
        System.out.println("textTest");
    }

    @Test
    void videoTest() {
        // video search
        System.out.println("videoTest");
    }
}
