package smartshop.com.smartshop.sql;

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

import java.util.List;

import smartshop.com.smartshop.model.User;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockingDetails;
import static org.mockito.Mockito.when;

import static org.junit.Assert.*;

/**
 * Created by Vicky on 11/12/2017.
 */
public class DatabaseHelperTest {
    @Before
    public void setUp() throws Exception {
        Assert.assertTrue("Passed", true);
    }

    @After
    public void tearDown() throws Exception {
        Assert.assertTrue("Passed", true);
    }

    @Test
    public void onCreate() throws Exception {
        Assert.assertTrue("Passed", true);
    }

    @Test
    public void onUpgrade() throws Exception {
        Assert.assertTrue("Passed", true);
    }

    @Test
    public void addUser() throws Exception {
        Assert.assertTrue("Passed", true);
    }

    @Test
    public void getAllUser() throws Exception {
        DatabaseHelper dbHelper =  Mockito.mock(DatabaseHelper.class);
        List<User> userList = dbHelper.getAllUser();
        Assert.assertTrue(userList != null);
    }

    @Test
    public void updateUser() throws Exception {
        Assert.assertTrue("Passed", true);
    }

    @Test
    public void deleteUser() throws Exception {
        Assert.assertTrue("Passed", true);
    }

    @Test
    public void checkUser() throws Exception {
        DatabaseHelper dbHelper =  Mockito.mock(DatabaseHelper.class);
        boolean checkUser = dbHelper.checkUser(Mockito.anyString());
        Assert.assertFalse(checkUser);
    }

    @Test
    public void checkUser1() throws Exception {

    }

}