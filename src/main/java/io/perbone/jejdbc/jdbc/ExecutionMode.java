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

/**
 * Execution Mode enumeration. Controls how the driver will be configured.
 * <p>
 * Defaults to {@link ExecutionMode#LOCAL} mode.
 * 
 * @author Paulo Perbone <pauloperbone@yahoo.com>
 * @since 0.1.0
 */
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
    PROXY,

    /**
     * <ul>
     * <li>Monitor mode for remote database (standalone/HA environment)</li>
     * </ul>
     */
    MONITOR
}