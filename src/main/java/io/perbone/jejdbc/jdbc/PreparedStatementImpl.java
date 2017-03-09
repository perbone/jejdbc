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

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;

import io.perbone.jejdbc.i18n.Messages;

/**
 * This is the {@link java.sql.PreparedStatement} interface implementation.
 * 
 * @see java.sql.PreparedStatement
 * 
 * @author Paulo Perbone <pauloperbone@yahoo.com>
 * @since 0.1.0
 */
class PreparedStatementImpl extends StatementImpl implements PreparedStatement
{
    public PreparedStatementImpl(final Messages messages)
    {
        super(messages);
    }

    @Override
    public ResultSet executeQuery() throws SQLException
    {
        // TODO Auto-generated method stub
        return new ResultSetImpl(messages);
    }

    @Override
    public int executeUpdate() throws SQLException
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setNull(final int parameterIndex, final int sqlType) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setBoolean(final int parameterIndex, final boolean x) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setByte(final int parameterIndex, final byte x) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setShort(final int parameterIndex, final short x) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setInt(final int parameterIndex, final int x) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setLong(final int parameterIndex, final long x) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setFloat(final int parameterIndex, final float x) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setDouble(final int parameterIndex, final double x) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setBigDecimal(final int parameterIndex, final BigDecimal x) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setString(final int parameterIndex, final String x) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setBytes(final int parameterIndex, final byte[] x) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setDate(final int parameterIndex, final Date x) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setTime(final int parameterIndex, final Time x) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setTimestamp(final int parameterIndex, final Timestamp x) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setAsciiStream(final int parameterIndex, final InputStream x, final int length) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    @Deprecated
    public void setUnicodeStream(final int parameterIndex, final InputStream x, final int length) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setBinaryStream(final int parameterIndex, final InputStream x, final int length) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void clearParameters() throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setObject(final int parameterIndex, final Object x, final int targetSqlType) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setObject(final int parameterIndex, final Object x) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean execute() throws SQLException
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void addBatch() throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setCharacterStream(final int parameterIndex, final Reader reader, final int length) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setRef(final int parameterIndex, final Ref x) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setBlob(final int parameterIndex, final Blob x) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setClob(final int parameterIndex, final Clob x) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setArray(final int parameterIndex, final Array x) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public ResultSetMetaData getMetaData() throws SQLException
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setDate(final int parameterIndex, final Date x, final Calendar cal) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setTime(final int parameterIndex, final Time x, final Calendar cal) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setTimestamp(final int parameterIndex, final Timestamp x, final Calendar cal) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setNull(final int parameterIndex, final int sqlType, final String typeName) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setURL(final int parameterIndex, final URL x) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public ParameterMetaData getParameterMetaData() throws SQLException
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setRowId(final int parameterIndex, final RowId x) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setNString(final int parameterIndex, final String value) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setNCharacterStream(final int parameterIndex, final Reader value, final long length) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setNClob(final int parameterIndex, final NClob value) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setClob(final int parameterIndex, final Reader reader, final long length) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setBlob(final int parameterIndex, final InputStream inputStream, final long length) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setNClob(final int parameterIndex, final Reader reader, final long length) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setSQLXML(final int parameterIndex, final SQLXML xmlObject) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setObject(final int parameterIndex, final Object x, final int targetSqlType, final int scaleOrLength)
            throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setAsciiStream(final int parameterIndex, final InputStream x, final long length) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setBinaryStream(final int parameterIndex, final InputStream x, final long length) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setCharacterStream(final int parameterIndex, final Reader reader, final long length) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setAsciiStream(final int parameterIndex, final InputStream x) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setBinaryStream(final int parameterIndex, final InputStream x) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setCharacterStream(final int parameterIndex, final Reader reader) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setNCharacterStream(final int parameterIndex, final Reader value) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setClob(final int parameterIndex, final Reader reader) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setBlob(final int parameterIndex, final InputStream inputStream) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setNClob(final int parameterIndex, final Reader reader) throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setObject(final int parameterIndex, final Object x, final SQLType targetSqlType,
            final int scaleOrLength) throws SQLException
    {
        // TODO Auto-generated method stub
        PreparedStatement.super.setObject(parameterIndex, x, targetSqlType, scaleOrLength);
    }

    @Override
    public void setObject(final int parameterIndex, final Object x, final SQLType targetSqlType) throws SQLException
    {
        // TODO Auto-generated method stub
        PreparedStatement.super.setObject(parameterIndex, x, targetSqlType);
    }

    @Override
    public long executeLargeUpdate() throws SQLException
    {
        // TODO Auto-generated method stub
        return PreparedStatement.super.executeLargeUpdate();
    }
}