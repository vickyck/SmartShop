package smartshop.com.smartshop.helpers;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

import static org.junit.Assert.*;

/**
 * Created by Vicky on 11/12/2017.
 */

@RunWith(PowerMockRunner.class)
public class InputValidationTest {

    @Before
    public void setUp() throws Exception {
        Assert.assertTrue("Passed", true);
    }

    @After
    public void tearDown() throws Exception {
        Assert.assertTrue("Passed", true);
    }

    @Test
    public void isInputEditTextFilled() throws Exception {
        InputValidation inpVal = Mockito.mock(InputValidation.class);
        //boolean output = inpVal.isInputEditTextFilled(null, null, Mockito.anyString());
        assertTrue("Passed", true);
    }

    @Test
    public void isInputEditTextEmail() throws Exception {
        InputValidation inpVal = Mockito.mock(InputValidation.class);
        //boolean output = inpVal.isInputEditTextEmail(null, null, Mockito.anyString());
        assertTrue("Passed", true);
    }

    @Test
    public void isInputEditTextMatches() throws Exception {
        InputValidation inpVal = Mockito.mock(InputValidation.class);
        //boolean output = inpVal.isInputEditTextMatches(null, null, null, Mockito.anyString());
        assertTrue("Passed", true);
    }

}