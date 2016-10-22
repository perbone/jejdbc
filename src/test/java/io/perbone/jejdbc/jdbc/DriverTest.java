/*
 * Copyright (C) 2013 Paulo Perbone. All rights reserved.
 * 
 * This file is part of JEJDBC 
 * https://github.com/perbone/jejdbc/
 *
 * JEJDBC is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * JEJDBC is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with JEJDBC. If not, see <http://www.gnu.org/licenses/>.
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
 * Driver Test Suite.
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