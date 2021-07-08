package ru.job4j.tracker;

import org.junit.*;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
            int id = tracker.add(new Item("testItem")).getId();
            Item item = new Item("newItem");
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
    public void deleteItemTest() {
        try (SqlTracker tracker = new SqlTracker(connection)) {
            int id = tracker.add(new Item("testItem")).getId();
            Assert.assertEquals(tracker.findById(id).getName(),"testItem");
            tracker.delete(id);
            Assert.assertEquals(tracker.findByName("testItem").size(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findAllTest() {
        try (SqlTracker tracker = new SqlTracker(connection)) {
            Assert.assertEquals(tracker.findAll().size(), 0);
            tracker.add(new Item("testItem1"));
            Assert.assertEquals(tracker.findAll().size(), 1);
            tracker.add(new Item("testItem2"));
            Assert.assertEquals(tracker.findAll().size(), 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findByIdTest() {
        try (SqlTracker tracker = new SqlTracker(connection)) {
            tracker.add(new Item("testItem1"));
            tracker.add(new Item("testItem2"));
            tracker.add(new Item("testItem3"));
            Assert.assertEquals(tracker.findById(0).getName(), "testItem1");
            Assert.assertEquals(tracker.findById(1).getName(), "testItem2");
            Assert.assertEquals(tracker.findById(2).getName(), "testItem3");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}