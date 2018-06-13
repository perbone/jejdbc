/*
 * This file is part of JEJDBC 
 * https://github.com/perbone/jejdbc/
 * 
 * Copyright 2013-2018 Paulo Perbone
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

import static io.perbone.jejdbc.i18n.Messages.KEY_EXCEPTION_CANT_REGISTER_DRIVER;
import static io.perbone.jejdbc.i18n.Messages.KEY_EXCEPTION_NO_PARENT_LOGGER;
import static io.perbone.jejdbc.i18n.Messages.KEY_PARAM_URL_NULL;

import java.sql.Connection;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import io.perbone.jejdbc.i18n.Messages;

/**
 * This is the {@link java.sql.Driver} interface implementation.
 * 
 * @see java.sql.Driver
 * 
 * @author Paulo Perbone <pauloperbone@yahoo.com>
 * @since 0.1.0
 */
public final class Driver implements java.sql.Driver
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
            throw new RuntimeException(new Messages().get(KEY_EXCEPTION_CANT_REGISTER_DRIVER), e);
        }
    }

    private static final Pattern URL_PATTERN = Pattern.compile("jdbc:jejdbc:(?://)?([^/]+)(?:/.+)?");

    @SuppressWarnings("unused")
    private ExecutionMode executionMode = ExecutionMode.LOCAL;

    private final Messages messages = new Messages();

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

        return new ConnectionImpl(messages);
    }

    @Override
    public boolean acceptsURL(final String url) throws SQLException
    {
        if (url == null)
            throw new SQLException(messages.get(KEY_PARAM_URL_NULL));

        URL_PATTERN.matcher(url).matches();
        // FIXME should use patter - this is temporary
        return url.startsWith("jdbc:jejdbc:");
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(final String url, final Properties info) throws SQLException
    {
        throw new UnsupportedOperationException();
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
        // FIXME make it ANSI SQL92 compliant
        return false;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException
    {
        throw new SQLFeatureNotSupportedException(messages.get(KEY_EXCEPTION_NO_PARENT_LOGGER));
    }
}