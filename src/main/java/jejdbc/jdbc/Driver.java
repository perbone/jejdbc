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

package jejdbc.jdbc;

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
    public enum ExecutionMode
    {
        /**
         * <ul>
         * <li>Read-Write from/to local database (standalone environment)</li>
         * </ul>
         */
        LOCAL,

        /**
         * <ul>
         * <li>Read-Write from/to local master database (HA environment)</li>
         * <li>Read-Only from local replica database (HA environment)</li>
         * <li>Write-Forwarding to remote master database (HA environment)</li>
         * </ul>
         */
        LOCAL_HA,

        /**
         * <ul>
         * <li>Server mode for local database (standalone environment)</li>
         * </ul>
         */
        SERVER,

        /**
         * <ul>
         * <li>Server mode for local master/replica database (HA environment)</li>
         * </ul>
         */
        SERVER_HA,

        /**
         * <ul>
         * <li>Client mode for remote database (standalone/HA environment)</li>
         * </ul>
         */
        CLIENT,

        /**
         * <ul>
         * <li>Proxy mode for remote database (standalone/HA environment)</li>
         * </ul>
         */
        PROXY
    }

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

    /**
     * Creates a new
     */
    public Driver()
    {
    }

    @Override
    public Connection connect(String url, Properties info) throws SQLException
    {
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
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getMinorVersion()
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean jdbcCompliant()
    {
        return false;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException
    {
        // TODO Auto-generated method stub
        return null;
    }
}