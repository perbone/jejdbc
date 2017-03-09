/*
 * This file is part of JEJDBC 
 * https://github.com/perbone/jejdbc/
 * 
 * Copyright 2013-2017 Paulo Perbone
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package io.perbone.jejdbc.jdbc;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Driver class test suit.
 * 
 * @author Paulo Perbone <pauloperbone@yahoo.com>
 * @since 0.1.0
 */
public class DriverTest
{
    private static final String DRIVER_CLASS_PATH = "io.perbone.jejdbc.jdbc.Driver";

    private static final String URL_SAMPLE_CLIENT = "jdbc:jejdbc://localhost:5101/sampledb";
    private static final String URL_SAMPLE_LOCAL = "jdbc:jejdbc:/tmp/sampledb";
    private static final String URL_SAMPLE_BAD = "jdbc:foo://localhost:5101";

    @BeforeClass
    public static void initialSetup()
    {
    }

    @Test
    public void loadDriver()
    {
        try
        {
            Class.forName(DRIVER_CLASS_PATH);
        }
        catch (final ClassNotFoundException e)
        {
            fail(e.getMessage());
        }
    }

    @Test
    public void getDriver()
    {
        Driver driver = null;

        try
        {
            driver = DriverManager.getDriver(URL_SAMPLE_CLIENT);

            assertNotNull(driver);
            assertTrue(driver.getClass().equals(io.perbone.jejdbc.jdbc.Driver.class));
        }
        catch (final SQLException e)
        {
            fail(e.getMessage());
        }

        try
        {
            driver = DriverManager.getDriver(URL_SAMPLE_LOCAL);

            assertNotNull(driver);
            assertTrue(driver.getClass().equals(io.perbone.jejdbc.jdbc.Driver.class));
        }
        catch (final SQLException e)
        {
            fail(e.getMessage());
        }

        driver = null;

        try
        {
            driver = DriverManager.getDriver(URL_SAMPLE_BAD);
        }
        catch (final SQLException e)
        {
        }

        assertNull(driver);
    }

    @Test
    public void testAcceptsURL()
    {
        try
        {
            Driver driver = new io.perbone.jejdbc.jdbc.Driver();

            assertTrue(driver.acceptsURL(URL_SAMPLE_CLIENT));
            assertFalse(driver.acceptsURL(URL_SAMPLE_BAD));
        }
        catch (final SQLException e)
        {
            fail(e.getMessage());
        }
    }

    @Test
    public void testConnection()
    {
        try
        {
            Driver driver = DriverManager.getDriver(URL_SAMPLE_LOCAL);

            Connection conn = driver.connect(URL_SAMPLE_CLIENT, null);
            assertNotNull(conn);
            conn.close();

            conn = driver.connect(URL_SAMPLE_LOCAL, null);
            assertNotNull(conn);
            conn.close();

            conn = driver.connect(URL_SAMPLE_BAD, null);
            assertNull(conn);
        }
        catch (final SQLException e)
        {
            fail(e.getMessage());
        }
    }

    @Test(expected = SQLException.class)
    public void testExceptionMessagesAcceptsURL() throws SQLException
    {
        Driver driver = new io.perbone.jejdbc.jdbc.Driver();

        driver.acceptsURL(null);
    }

    @Test(expected = SQLException.class)
    public void testExceptionMessagesGetParentLogger() throws SQLException
    {
        Driver driver = new io.perbone.jejdbc.jdbc.Driver();

        driver.getParentLogger();
    }
}