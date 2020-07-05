package com.juit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

public class test {

    @BeforeEach
    @DisplayName("每条用例开始时执行")
    void start() {

    }

    @AfterEach
    @DisplayName("每条用例结束时执行")
    void end() {

    }

    @Test
    void myFirstTest() {
        assertEquals(2, 1 + 1);
    }

    @Test
    @DisplayName("描述测试用例╯°□°）╯")
    void testWithDisplayName() {

    }

    @Test
    @Disabled("这条用例暂时跑不过，忽略!")
    void myFailTest() {
        assertEquals(1, 2);
    }

    @Test
    @DisplayName("运行一组断言")
    public void assertAllCase() {
        assertAll("groupAssert", () -> assertEquals(2, 1 + 1), () -> assertTrue(1 > 0));
    }

    @Test
    @DisplayName("依赖注入1")
    public void testInfo(final TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
    }

    @Test
    @DisplayName("依赖注入2")
    public void testReporter(final TestReporter testReporter) {
        testReporter.publishEntry("name", "Alex");
    }
}
