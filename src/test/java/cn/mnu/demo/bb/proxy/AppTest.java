package cn.mnu.demo.bb.proxy;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@RunWith(JUnitPlatform.class)
@DisplayName("A stack")
public class AppTest {

	Stack<Object> stack;

    @Test
    @DisplayName("is instantiated with new Stack()")
    void isInstantiatedWithNew() {
        new Stack<>();
    }

    @Nested
    @DisplayName("when new")
    class WhenNew {

        @BeforeEach
        void createNewStack() {
            stack = new Stack<>();
        }

        @Test
        @DisplayName("is empty")
        void isEmpty() {
            assertTrue(stack.isEmpty());
        }

        @Test
        @DisplayName("throws EmptyStackException when popped")
        void throwsExceptionWhenPopped() {
            assertThrows(EmptyStackException.class, () -> stack.pop());
        }

        @Test
        @DisplayName("throws EmptyStackException when peeked")
        void throwsExceptionWhenPeeked() {
            assertThrows(EmptyStackException.class, () -> stack.peek());
        }

        @Nested
        @DisplayName("after pushing an element")
        class AfterPushing {

            String anElement = "an element";

            @BeforeEach
            void pushAnElement() {
                stack.push(anElement);
            }

            @Test
            @DisplayName("it is no longer empty")
            void isNotEmpty() {
                assertFalse(stack.isEmpty());
            }

            @Test
            @DisplayName("returns the element when popped and is empty")
            void returnElementWhenPopped() {
                assertEquals(anElement, stack.pop());
                assertTrue(stack.isEmpty());
            }

            @Test
            @DisplayName("returns the element when peeked but remains not empty")
            void returnElementWhenPeeked() {
                assertEquals(anElement, stack.peek());
                assertFalse(stack.isEmpty());
            }
        }
    }
    
    @Nested
    @DisplayName("ParamterTest")
    class ParamterTest{
    	
    	@ParameterizedTest
    	@DisplayName("returns the element when peeked but remains not empty ,@ParameterizedTest")
    	
    	@ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
    	void palindromes(String candidate) {
    		assertTrue(!"".equals(candidate));
    	}
    	
    	  @ParameterizedTest
    	    @MethodSource("stringProvider")
    	    void testWithSimpleMethodSource(String argument) {
    	        assertNotNull(argument);
    	    }

    	    Stream<String> stringProvider() {
    	        return Stream.of("foo", "bar");
    	    }
    	    
    	    @ParameterizedTest
    	    @MethodSource("stringIntAndListProvider")
    	    void testWithMultiArgMethodSource(String str, int num, List<String> list) {
    	        assertEquals(3, str.length());
    	        assertTrue(num >=1 && num <=2);
    	        assertEquals(2, list.size());
    	    }

    	    Stream<Arguments> stringIntAndListProvider() {
    	        return Stream.of(
    	            Arguments.of("foo", 1, Arrays.asList("a", "b")),
    	            Arguments.of("bar", 2, Arrays.asList("x", "y"))
    	        );
    	    }
    }
    
    
  
}
