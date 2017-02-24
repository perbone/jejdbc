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
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Logger;
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

    private ExecutionMode executionMode = ExecutionMode.CLIENT;

    private ResourceBundle messages = ResourceBundle.getBundle("messages", Locale.getDefault());

    /**
     * Creates a new driver instance
     */
    public Driver()
    {
    }

    @Override
    public Connection connect(final String url, final Properties info) throws SQLException
    {
        /*
         * According to JDBC specification: The driver should return "null" if it realizes it is the
         * wrong kind of driver to connect to the given URL. This will be common, as when the JDBC
         * driver manager is asked to connect to a given URL it passes the URL to each loaded driver
         * in turn.
         */
        if (!acceptsURL(url))
            return null;

        // TODO open a connection based on the configured execution mode

        return null;
    }

    @Override
    public boolean acceptsURL(final String url) throws SQLException
    {
        if (url == null)
            throw new SQLException("Parameter 'url' cannot be null");

        return URL_PATTERN.matcher(url).matches();
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(final String url, final Properties info) throws SQLException
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
        // FIXME make it jdbc compliant
        return false;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException
    {
        throw new SQLFeatureNotSupportedException("No parent logger available; we use Log4j 2");
    }
}