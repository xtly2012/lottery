package com.chen.test.support;

import org.junit.Assert;
import org.unitils.UnitilsJUnit4;
import org.unitils.spring.annotation.SpringApplicationContext;

@SpringApplicationContext({ "classpath:testapplication/appContext.xml"})
public abstract class UnitilsJUnit4Support extends UnitilsJUnit4
{

    public void assertNotNull(Object object)
    {
        Assert.assertNotNull(object);
    }

    public void assertEquals(boolean expected, boolean actual)
    {
        Assert.assertEquals(expected, actual);
    }

    public void assertEquals(int expected, int actual)
    {
        Assert.assertEquals(expected, actual);
    }

    public void assertEquals(String expected, String actual)
    {
        Assert.assertEquals(expected, actual);
    }

    public void assertEquals(long expected, long actual)
    {
        Assert.assertEquals(expected, actual);
    }

    public void assertEquals(Object expected, Object actual)
    {
        Assert.assertEquals(expected, actual);
    }

    public void assertNull(Object object)
    {
        Assert.assertNull(object);
    }

    public void assertTrue(boolean condition)
    {
        Assert.assertTrue(condition);
    }

    public void assertNotSame(Object unexpected, Object actual)
    {
        Assert.assertNotSame(unexpected, actual);
    }

    public void assertSame(Object expected, Object actual)
    {
        Assert.assertSame(expected, actual);
    }
    

    public abstract void setUp();
}
