package com.agrigoriev.calculator_unit_tests;

import android.content.Context;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UriValidatorTest {

    UriValidator mUriValidator;
    Context mockContext;

    @Before
    public void setUp() throws Exception {
        mockContext = Mockito.mock(Context.class);
        Mockito.when(mockContext.getString(R.string.nothing)).thenReturn("Nothing");
        Mockito.when(mockContext.getString(R.string.url)).thenReturn("URL");
        Mockito.when(mockContext.getString(R.string.file)).thenReturn("FILE");
        mUriValidator = new UriValidator(mockContext);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void exampleMock() {
        System.out.println(mockContext.getString(R.string.nothing));
        System.out.println(mockContext.getString(R.string.file));
        System.out.println(mockContext.getString(R.string.url));
    }

    @Test
    public void validate() {
        assertThat(mUriValidator.validate("http://google.com"), is("URL"));
        assertThat(mUriValidator.validate("file://sdcard/DCIM/img.jpg"), is("FILE"));
        assertThat(mUriValidator.validate("blablabla"), is("Nothing"));
    }
}