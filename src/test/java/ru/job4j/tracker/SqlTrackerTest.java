package ru.job4j.tracker;

import org.junit.*;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;


public class SqlTrackerTest {

    static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader().getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void addItemTest() {
        try (SqlTracker tracker = new SqlTracker(connection)) {
            tracker.add(new Item("itemName"));
            Assert.assertEquals(tracker.findByName("itemName").size(), 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void replaceItemTest() {
        try (SqlTracker tracker = new SqlTracker(connection)) {
            tracker.add(new Item("testItem"));
            Item item = new Item("newItem");
            int id = tracker.findByName("testItem").get(0).getId();
            tracker.replace(id, item);
            Assert.assertEquals(tracker.findByName("newItem").size(), 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findByNameTest() {
        try (SqlTracker tracker = new SqlTracker(connection)) {
            tracker.add(new Item("testItem1"));
            tracker.add(new Item("testItem2"));
            tracker.add(new Item("testItem2"));
            tracker.add(new Item("testItem3"));
            tracker.add(new Item("testItem3"));
            tracker.add(new Item("testItem3"));
            Assert.assertEquals(tracker.findByName("testItem1").size(), 1);
            Assert.assertEquals(tracker.findByName("testItem2").size(), 2);
            Assert.assertEquals(tracker.findByName("testItem3").size(), 3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteItemTest() throws SQLException {
        try (SqlTracker tracker = new SqlTracker(connection)) {
            tracker.add(new Item("testItem"));
            int id = tracker.findByName("testItem").get(0).getId();
            Assert.assertEquals(tracker.findById(id).getName(),"testItem");
            tracker.delete(id);
            Assert.assertEquals(tracker.findByName("testItem").size(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}