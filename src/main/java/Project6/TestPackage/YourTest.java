package Project6.TestPackage;

import Project6.Settings.UserNameAndPassword;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class YourTest {

    UserNameAndPassword userNameAndPassword = new UserNameAndPassword();

    @Before
    public void beforeClass() {

        userNameAndPassword.addUserToList();
    }

    @Test
    public void Testpassword1() {
        String actual = "Password";
        String expected = userNameAndPassword.setPassword(actual);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void Testpassword2() {
        String actual = "Password length more then 5 character";
        String expected = userNameAndPassword.setPassword("Pass");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestsetUsername1() {
        String actual = "Username length should be more then 6";
        String expected = userNameAndPassword.setUsername("st@n");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestsetUsername2() {
        String actual = "Username should NOT contain space";
        String expected = userNameAndPassword.setUsername("Jane@n com");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestsetUsername3() {
        String actual = "Username should contain @ symbol";
        String expected = userNameAndPassword.setUsername("JohnSmiths");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestsetUsername4() {
        String actual = "Username should be unique";
        String expected = userNameAndPassword.setUsername("David@gmail.com");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestsetUsername5() {
        String actual = "Natasha@mail.ru";
        String expected = userNameAndPassword.setUsername(actual);
        Assert.assertEquals(expected, actual);
    }
}
