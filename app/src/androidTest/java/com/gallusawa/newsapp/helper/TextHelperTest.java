package com.gallusawa.newsapp.helper;

import com.gallusawa.newsapp.news.helper.TextHelper;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by gallusawa on 12/8/17.
 */

public class TextHelperTest {
    private TextHelper helper = null;

    @Before
    public void setUp() throws Exception{
        helper = TextHelper.getInstance();
    }

    @After
    public void tearDown() throws Exception{
        helper = null;
    }

    @Test
    public void testGetText()
    {
        Assert.assertEquals(helper.getText(49), "low");
    }
}
