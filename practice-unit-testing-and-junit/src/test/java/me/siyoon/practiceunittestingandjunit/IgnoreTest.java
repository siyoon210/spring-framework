package me.siyoon.practiceunittestingandjunit;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class IgnoreTest {
    @Test
    public void normalTest() throws Exception {
        //given
        String name = "siyoon";

        //when


        //then
        assertThat(name, is("siyoon"));
    }

    @Ignore("이그노어 하면 어떻게 되나요")
    @Test
    public void ignoreTest() throws Exception {
        //given
        String name = "siyoon";

        //when


        //then
        assertThat(name, is("puru"));
    }
}
