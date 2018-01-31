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

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;

import io.perbone.jejdbc.i18n.Messages;

/**
 * This is the {@link java.sql.Statement} interface implementation.
 * 
 * @see java.sql.Statement
 * 
 * @author Paulo Perbone <pauloperbone@yahoo.com>
 * @since 0.1.0
 */
class StatementImpl implements Statement
{
    protected final Messages messages;

    public StatementImpl(final Messages messages)
    {
        this.messages = messages;
    }

    @Override
    public <T> T unwrap(final Class<T> iface) throws SQLException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isWrapperFor(final Class<?> iface) throws SQLException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public ResultSet executeQuery(final String sql) throws SQLException
    {
        return new ResultSetImpl(messages);
    }

    @Override
    public int executeUpdate(final String sql) throws SQLException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void close() throws SQLException
    {
        throw new UnsupportedOperationException();

    }

    @Override
    public int getMaxFieldSize() throws SQLException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setMaxFieldSize(final int max) throws SQLException
    {
        throw new UnsupportedOperationException();

    }

    @Override
    public int getMaxRows() throws SQLException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setMaxRows(final int max) throws SQLException
    {
        throw new UnsupportedOperationException();

    }

    @Override
    public void setEscapeProcessing(final boolean enable) throws SQLException
    {
        throw new UnsupportedOperationException();

    }

    @Override
    public int getQueryTimeout() throws SQLException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setQueryTimeout(final int seconds) throws SQLException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void cancel() throws SQLException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public SQLWarning getWarnings() throws SQLException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clearWarnings() throws SQLException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setCursorName(final String name) throws SQLException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean execute(final String sql) throws SQLException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public ResultSet getResultSet() throws SQLException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getUpdateCount() throws SQLException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean getMoreResults() throws SQLException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setFetchDirection(final int direction) throws SQLException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getFetchDirection() throws SQLException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setFetchSize(final int rows) throws SQLException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getFetchSize() throws SQLException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getResultSetConcurrency() throws SQLException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getResultSetType() throws SQLException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addBatch(String sql) throws SQLException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clearBatch() throws SQLException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public int[] executeBatch() throws SQLException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Connection getConnection() throws SQLException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean getMoreResults(final int current) throws SQLException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public ResultSet getGeneratedKeys() throws SQLException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public int executeUpdate(final String sql, final int autoGeneratedKeys) throws SQLException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public int executeUpdate(final String sql, final int[] columnIndexes) throws SQLException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public int executeUpdate(final String sql, final String[] columnNames) throws SQLException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean execute(final String sql, final int autoGeneratedKeys) throws SQLException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean execute(final String sql, final int[] columnIndexes) throws SQLException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean execute(final String sql, final String[] columnNames) throws SQLException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getResultSetHoldability() throws SQLException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isClosed() throws SQLException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setPoolable(final boolean poolable) throws SQLException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isPoolable() throws SQLException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void closeOnCompletion() throws SQLException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isCloseOnCompletion() throws SQLException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public long getLargeUpdateCount() throws SQLException
    {
        return Statement.super.getLargeUpdateCount();
    }

    @Override
    public void setLargeMaxRows(final long max) throws SQLException
    {
        Statement.super.setLargeMaxRows(max);
    }

    @Override
    public long getLargeMaxRows() throws SQLException
    {
        return Statement.super.getLargeMaxRows();
    }

    @Override
    public long[] executeLargeBatch() throws SQLException
    {
        return Statement.super.executeLargeBatch();
    }

    @Override
    public long executeLargeUpdate(final String sql) throws SQLException
    {
        return Statement.super.executeLargeUpdate(sql);
    }

    @Override
    public long executeLargeUpdate(final String sql, final int autoGeneratedKeys) throws SQLException
    {
        return Statement.super.executeLargeUpdate(sql, autoGeneratedKeys);
    }

    @Override
    public long executeLargeUpdate(final String sql, final int[] columnIndexes) throws SQLException
    {
        return Statement.super.executeLargeUpdate(sql, columnIndexes);
    }

    @Override
    public long executeLargeUpdate(final String sql, final String[] columnNames) throws SQLException
    {
        return Statement.super.executeLargeUpdate(sql, columnNames);
    }
}