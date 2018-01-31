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

import java.util.Calendar;

/**
 * Application version information helper class.
 * 
 * @author Paulo Perbone <pauloperbone@yahoo.com>
 * @since 0.1.0
 */
final class Version
{
    private final String title;

    private final String version;

    private final int major;

    private final int minor;

    private final int patch;

    private final String vendor;

    private final String copyright;

    private final String jvm;

    private static Version instance = new Version();

    private Version()
    {
        Package pac = this.getClass().getPackage();
        title = pac.getImplementationTitle() == null ? "JEJDBC" : pac.getImplementationTitle();
        version = pac.getImplementationVersion() == null ? "{version not available on this runtime}"
                : pac.getImplementationVersion();
        major = parseVersionNumbers()[0];
        minor = parseVersionNumbers()[1];
        patch = parseVersionNumbers()[2];
        vendor = pac.getImplementationVendor() == null ? "Paulo Perbone," : pac.getImplementationVendor();
        copyright = String.format("(c) 2013-%d %s Todos os direitos reservados",
                Calendar.getInstance().get(Calendar.YEAR), vendor);
        jvm = System.getProperty("java.version");
    }

    public static String getTitle()
    {
        return instance.title;
    }

    public static String getVersion()
    {
        return instance.version;
    }

    public static int getMajorVersion()
    {
        return instance.major;
    }

    public static int getMinorVersion()
    {
        return instance.minor;
    }

    public static int getPatchVersion()
    {
        return instance.patch;
    }

    public static String getVendor()
    {
        return instance.vendor;
    }

    public static String getCopyright()
    {
        return instance.copyright;
    }

    public static String getJvm()
    {
        return instance.jvm;
    }

    private int[] parseVersionNumbers()
    {
        int[] result = { 0, 0, 0 };

        String[] nums = version.split("\\.");

        if (nums.length == 3)
        {
            result[0] = Integer.parseInt(nums[0]);
            result[1] = Integer.parseInt(nums[1]);
            if (nums[2].split("-").length == 0)
                result[2] = Integer.parseInt(nums[2]);
            else
                // Strip out -SNAPSHOT, -GA etc
                result[2] = Integer.parseInt(nums[2].split("-")[0]);
        }

        return result;
    }
}