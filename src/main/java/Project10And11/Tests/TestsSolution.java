//package Project10And11.Tests;

import Project10And11.Solution.Data;
import Project10And11.Solution.LibraryApp;
import Project10And11.Solution.Users.User;
//import main.java.Project10And11.Tests.TextFromStandardInputStream;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
//import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

/*import java.time.LocalDate;


public class TestsSolution {

    @Rule
    public final TextFromStandardInputStream systemInMock = TextFromStandardInputStream.emptyStandardInputStream();

    @Test
    public void test1() {
        systemInMock.provideLines("abcd", "C");
        LibraryApp.main(null);
    }

    @Test
    public void test2() {
        systemInMock.provideLines("\n", "C");
        LibraryApp.main(null);
        // This test is expected to fail!
    }

    @Test
    public void test3() {
        String userID = "1000";
        systemInMock.provideLines(userID, "0");
        LibraryApp.main(null);

        User expected = Data.getUserMap().get(Integer.valueOf(userID));
        User actual = LibraryApp.getActiveUser();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        String userID = "1000";
        systemInMock.provideLines(userID, "0");
        LibraryApp.main(null);

        String expected = Data.getUserMap().get(Integer.valueOf(userID)).getName();
        String actual = LibraryApp.getActiveUser().getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        String userID = "1000";
        systemInMock.provideLines(userID, "0");
        LibraryApp.main(null);

        String expected = Data.getUserMap().get(Integer.valueOf(userID)).getLastName();
        String actual = LibraryApp.getActiveUser().getLastName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test6() {
        String userID = "2002";
        String bookID = "10002";
        systemInMock.provideLines(userID, "1", bookID, "0");
        LibraryApp.main(null);

        User expected = Data.getUserMap().get(Integer.valueOf(userID));
        User actual = Data.getBookMap().get(Integer.valueOf(bookID)).getBorrower();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test7() {
        String userID = "3000";
        String bookID = "20000";
        systemInMock.provideLines(userID, "1", bookID, "0");
        LibraryApp.main(null);

        LocalDate expected = LocalDate.now().plusDays(14);
        LocalDate actual = Data.getBookMap().get(Integer.valueOf(bookID)).getDueDate();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test8() {
        String userID = "2001";
        String bookID = "10000";
        systemInMock.provideLines(userID, "1", bookID, "0");
        LibraryApp.main(null);

        LocalDate expected = LocalDate.now().plusDays(21);
        LocalDate actual = Data.getBookMap().get(Integer.valueOf(bookID)).getDueDate();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test9() {
        String userID = "1001";
        String bookID = "10002";
        systemInMock.provideLines(userID, "1", bookID, "0");
        LibraryApp.main(null);

        LocalDate expected = LocalDate.now().plusDays(30);
        LocalDate actual = Data.getBookMap().get(Integer.valueOf(bookID)).getDueDate();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test10() {
        String userID = "1001";
        String bookID = "90001";
        systemInMock.provideLines(userID, "1", bookID, "0");
        LibraryApp.main(null);

        User expected = null;
        User actual = Data.getBookMap().get(Integer.valueOf(bookID)).getBorrower();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test11() {
        String userID = "2000";
        String bookID = "abcde";
        systemInMock.provideLines(userID, "1", bookID, "0");
        LibraryApp.main(null);
        // This test is expected to fail!
    }

    @Test
    public void test12() {
        String userID = "2000";
        String bookID = "10000";
        systemInMock.provideLines(userID, "1", bookID, "2", bookID, "0");
        LibraryApp.main(null);

        Assert.assertFalse(Data.getBookMap().get(Integer.valueOf(bookID)).isCheckedOut());
    }

    @Test
    public void test13() {
        String userID = "1001";
        String bookID = "10000";
        String borrowerID = "2002";
        systemInMock.provideLines(userID, "5", bookID, borrowerID, "2", bookID, "0");
        LibraryApp.main(null);

        Assert.assertFalse(Data.getBookMap().get(Integer.valueOf(bookID)).isCheckedOut());
    }

    @Test
    public void test14() {
        String userID = "1000";
        String bookID = "20000";
        String borrowerID = "2001";
        systemInMock.provideLines(userID, "5", bookID, borrowerID, "0");
        LibraryApp.main(null);

        User expected = Data.getUserMap().get(Integer.valueOf(borrowerID));
        User actual = Data.getBookMap().get(Integer.valueOf(bookID)).getBorrower();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test15() {
        String userID = "1000";
        String bookID = "90000";
        String borrowerID = "3002";
        systemInMock.provideLines(userID, "5", bookID, borrowerID, "0");
        LibraryApp.main(null);

        User expected = null;
        User actual = Data.getBookMap().get(Integer.valueOf(bookID)).getBorrower();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test16() {
        String userID = "1000";
        String newTeacherName = "John";
        String newTeacherLastName = "Smith";
        String newTeacherID = "2065";
        systemInMock.provideLines(userID, "3", "2", newTeacherName, newTeacherLastName, newTeacherID, "0");
        LibraryApp.main(null);

        Assert.assertTrue(Data.getUserMap().containsKey(Integer.valueOf(newTeacherID)));
    }

    @Test
    public void test17() {
        String userID = "1000";
        String newStudentName = "John";
        String newStudentLastName = "Smith";
        String newStudentID = "3065";
        systemInMock.provideLines(userID, "3", "3", newStudentName, newStudentLastName, newStudentID, "0");
        LibraryApp.main(null);

        Assert.assertTrue(Data.getUserMap().containsKey(Integer.valueOf(newStudentID)));
    }

    @Test
    public void test18() {
        String userID = "1000";
        String newLibrarianName = "John";
        String newLibrarianLastName = "Smith";
        String newLibrarianID = "1065";
        systemInMock.provideLines(userID, "3", "1", newLibrarianName, newLibrarianLastName, newLibrarianID, "0");
        LibraryApp.main(null);

        Assert.assertTrue(Data.getUserMap().containsKey(Integer.valueOf(newLibrarianID)));
    }

    @Test
    public void test19() {
        String userID = "1000";
        String newStudentName = "John";
        String newStudentLastName = "Smith";
        String wrongStudentID = "5000";
        String correctStudentID = "3165";
        systemInMock.provideLines(userID, "3", "3", newStudentName, newStudentLastName, wrongStudentID, correctStudentID, "0");
        LibraryApp.main(null);

        Assert.assertFalse(Data.getUserMap().containsKey(Integer.valueOf(wrongStudentID)));
    }

    @Test
    public void test20() {
        String userID = "1000";
        String newTeacherName = "John";
        String newTeacherLastName = "Smith";
        String newTeacherID = "2165";
        systemInMock.provideLines(userID, "3", "2", newTeacherName, newTeacherLastName, newTeacherID, "0");
        LibraryApp.main(null);

        int expected = 21;
        int actual = Data.getUserMap().get(Integer.valueOf(newTeacherID)).getMAX_DAYS();
        Assert.assertEquals(expected, actual);
    }

}*/
