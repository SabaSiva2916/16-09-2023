package org.day;

import org.junit.Ignore;
import org.junit.Test;

public class Sample {

    @Test
    public void tc01() {
	System.out.println("Method 1");

    }

    @Test
    public void tc02() {
	System.out.println("Method 2");

    }

    @Test
    public void tc03() {
	System.out.println("Method 3");
    }

    @Ignore
    @Test
    public void tc04() {
	System.out.println("Method 4");
    }

    @Test
    public void tc05() {
	System.out.println("Method 5");
    }

}
