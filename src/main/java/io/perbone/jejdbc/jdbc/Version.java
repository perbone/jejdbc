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

import java.util.Calendar;

/**
 * Application version information helper class implementation.
 * 
 * @author Paulo Perbone <pauloperbone@yahoo.com>
 * @since 0.1.0
 */
public final class Version
{
    private final String title;

    private final String version;

    private final String vendor;

    private final String copyright;

    private final String jvm;

    private static Version instance = new Version();

    private Version()
    {
        Package pac = this.getClass().getPackage();
        title = pac.getSpecificationTitle() == null ? "JEJDBC" : pac.getSpecificationTitle();
        version = pac.getSpecificationVersion() == null ? "{version not available on this runtime}"
                : pac.getSpecificationVersion();
        vendor = pac.getSpecificationVendor() == null ? "Paulo Perbone," : pac.getSpecificationVendor();
        copyright = String.format("(c) 2013-%d %s Todos os direitos reservados",
                Calendar.getInstance().get(Calendar.YEAR), vendor);
        jvm = System.getProperty("java.version");
    }

    public static String title()
    {
        return instance.title;
    }

    public static String version()
    {
        return instance.version;
    }

    public static String vendor()
    {
        return instance.vendor;
    }

    public static String copyright()
    {
        return instance.copyright;
    }

    public static String jvm()
    {
        return instance.jvm;
    }
}