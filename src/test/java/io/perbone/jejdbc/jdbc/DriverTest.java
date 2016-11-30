/*
 * This file is part of JEJDBC 
 * https://github.com/perbone/jejdbc/
 * 
 * Copyright 2013-2016 Paulo Perbone
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

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.BasicConfigurator;
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
    private static final String URL_SAMPLE = "jdbc:jejdbc://localhost:5101";
    private static final String URL_SAMPLE_WRONG = "jdbc:blah://localhost:5101";
    private static final String DRIVER_CLASS_PATH = "io.perbone.jejdbc.jdbc.Driver";

    @BeforeClass
    public static void initialSetup()
    {
        BasicConfigurator.configure();
    }

    @Test
    public void loadDriver()
    {
        try
        {
            Class.forName(DRIVER_CLASS_PATH);
        }
        catch (ClassNotFoundException e)
        {
            fail(e.getMessage());
        }
    }

    @Test
    public void getDriver()
    {
        try
        {
            Driver driver = DriverManager.getDriver(URL_SAMPLE);

            assertNotNull(driver);
            assertTrue(driver.getClass().equals(io.perbone.jejdbc.jdbc.Driver.class));
        }
        catch (SQLException e)
        {
            fail(e.getMessage());
        }

        Driver driver = null;

        try
        {
            driver = DriverManager.getDriver(URL_SAMPLE_WRONG);
        }
        catch (SQLException e)
        {
            assertNull(driver);
        }
    }

    @Test
    public void testAcceptsURL()
    {
        try
        {
            Driver driver = new io.perbone.jejdbc.jdbc.Driver();

            assertTrue(driver.acceptsURL(URL_SAMPLE));
            assertFalse(driver.acceptsURL(URL_SAMPLE_WRONG));
        }
        catch (SQLException e)
        {
            fail(e.getMessage());
        }
    }
}