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

import java.sql.SQLException;

/**
 * This is the {@link java.sql.ResultSetMetaData} interface implementation.
 * 
 * @see java.sql.ResultSetMetaData
 * 
 * @author Paulo Perbone <pauloperbone@yahoo.com>
 * @since 0.1.0
 */
class ResultSetMetaData implements java.sql.ResultSetMetaData
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
    public int getColumnCount() throws SQLException
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isAutoIncrement(int column) throws SQLException
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isCaseSensitive(int column) throws SQLException
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isSearchable(int column) throws SQLException
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isCurrency(int column) throws SQLException
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int isNullable(int column) throws SQLException
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isSigned(int column) throws SQLException
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int getColumnDisplaySize(int column) throws SQLException
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String getColumnLabel(int column) throws SQLException
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getColumnName(int column) throws SQLException
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getSchemaName(int column) throws SQLException
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getPrecision(int column) throws SQLException
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getScale(int column) throws SQLException
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String getTableName(int column) throws SQLException
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getCatalogName(int column) throws SQLException
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getColumnType(int column) throws SQLException
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String getColumnTypeName(int column) throws SQLException
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isReadOnly(int column) throws SQLException
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isWritable(int column) throws SQLException
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isDefinitelyWritable(int column) throws SQLException
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String getColumnClassName(int column) throws SQLException
    {
        // TODO Auto-generated method stub
        return null;
    }
}