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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;

/**
 * This is the {@link java.sql.Statement} interface abstract implementation.
 * 
 * @see java.sql.Statement
 * 
 * @author Paulo Perbone <pauloperbone@yahoo.com>
 * @since 0.1.0
 */
abstract class AbstractStatement implements java.sql.Statement
{
    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public ResultSet executeQuery(String sql) throws SQLException
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int executeUpdate(String sql) throws SQLException
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void close() throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public int getMaxFieldSize() throws SQLException
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setMaxFieldSize(int max) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public int getMaxRows() throws SQLException
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setMaxRows(int max) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setEscapeProcessing(boolean enable) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public int getQueryTimeout() throws SQLException
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setQueryTimeout(int seconds) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void cancel() throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public SQLWarning getWarnings() throws SQLException
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void clearWarnings() throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setCursorName(String name) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean execute(String sql) throws SQLException
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public ResultSet getResultSet() throws SQLException
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getUpdateCount() throws SQLException
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean getMoreResults() throws SQLException
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setFetchDirection(int direction) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public int getFetchDirection() throws SQLException
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setFetchSize(int rows) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public int getFetchSize() throws SQLException
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getResultSetConcurrency() throws SQLException
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getResultSetType() throws SQLException
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void addBatch(String sql) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void clearBatch() throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public int[] executeBatch() throws SQLException
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Connection getConnection() throws SQLException
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean getMoreResults(int current) throws SQLException
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public ResultSet getGeneratedKeys() throws SQLException
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int executeUpdate(String sql, int[] columnIndexes) throws SQLException
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int executeUpdate(String sql, String[] columnNames) throws SQLException
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean execute(String sql, int autoGeneratedKeys) throws SQLException
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean execute(String sql, int[] columnIndexes) throws SQLException
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean execute(String sql, String[] columnNames) throws SQLException
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int getResultSetHoldability() throws SQLException
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isClosed() throws SQLException
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setPoolable(boolean poolable) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isPoolable() throws SQLException
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void closeOnCompletion() throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isCloseOnCompletion() throws SQLException
    {
        // TODO Auto-generated method stub
        return false;
    }
}