package cn.mnu.demo.bb.proxy;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

class DisabledTestsDemo {


	@Disabled
    @Test
    void testWillBeSkipped() {
    }

    @Test
    void testWillBeExecuted() {
    	System.out.println("test pass");
    }
    
    @Test
    @EnabledOnOs(OS.MAC)
    void onlyOnMacOs() {
        // ...
    }
    
    @Test
    @EnabledOnOs(OS.WINDOWS)
    void onlyOnWindowsOs() {
        assertTrue(1==1);
    }
    
    @TestOnWindows
    void onlyOnWindwosOs() {
    	System.out.println("only test on Windows");
    }
    
    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
    void onlyOn64BitArchitectures() {
        System.out.println("test on os arch 64");
    }
    
   /* @Test
//    @TestInstance.Lifecycle
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
    void onlyOn64BitArchitectures() {
        // ...
    }*/
}