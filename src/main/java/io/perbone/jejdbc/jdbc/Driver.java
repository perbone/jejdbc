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

import java.sql.Connection;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This is the {@link java.sql.Driver} interface implementation.
 * 
 * @see java.sql.Driver
 * 
 * @author Paulo Perbone <pauloperbone@yahoo.com>
 * @since 0.1.0
 */
public class Driver implements java.sql.Driver
{
    /*
     * Self registration with the JDBC DriverManager.
     */
    static
    {
        try
        {
            java.sql.DriverManager.registerDriver(new Driver());
        }
        catch (SQLException e)
        {
            throw new RuntimeException("Can't register driver", e);
        }
    }

    private static final Pattern URL_PATTERN = Pattern.compile("jdbc:jejdbc:(?://)?([^/]+)(?:/.+)?");

    @SuppressWarnings("unused")
    private static final ExecutionMode DEFAULT_EXECUTION_MODE = ExecutionMode.LOCAL;

    /**
     * Creates a new
     */
    public Driver()
    {
    }

    @Override
    public Connection connect(String url, Properties info) throws SQLException
    {
        /*
         * According to JDBC specification: The driver should return "null" if it realizes it is the
         * wrong kind of driver to connect to the given URL. This will be common, as when the JDBC
         * driver manager is asked to connect to a given URL it passes the URL to each loaded driver
         * in turn.
         */

        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean acceptsURL(String url) throws SQLException
    {
        Matcher matcher = URL_PATTERN.matcher(url);

        boolean accepts = matcher.matches();

        return accepts;
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getMajorVersion()
    {
        return Version.getMajorVersion();
    }

    @Override
    public int getMinorVersion()
    {
        return Version.getMinorVersion();
    }

    @Override
    public boolean jdbcCompliant()
    {
        return false;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException
    {
        throw new SQLFeatureNotSupportedException("No parent logger available; we use Log4j 2");
    }
}