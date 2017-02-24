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

package io.perbone.jejdbc.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Messages bundle helper class.
 * <p>
 * All messages are localized for the current (default) locale.
 * 
 * @author Paulo Perbone <pauloperbone@yahoo.com>
 * @since 0.1.0
 */
public final class Messages
{
    public static final String KEY_EXCEPTION_CANT_REGISTER_DRIVER = "driver.exception.cantRegisterDriver";
    public static final String KEY_EXCEPTION_NO_PARENT_LOGGER = "driver.exception.noParentLogger";
    public static final String KEY_PARAM_URL_NULL = "driver.param.url.null";

    private ResourceBundle bundle;

    public Messages()
    {
        bundle = ResourceBundle.getBundle("messages", Locale.getDefault());
    }

    public Messages setLocale(final String language)
    {
        bundle = ResourceBundle.getBundle("messages", new Locale(language));

        return this;
    }

    public Messages setLocale(final String language, final String country)
    {
        bundle = ResourceBundle.getBundle("messages", new Locale(language, country));

        return this;
    }

    public String get(final String key)
    {
        return bundle.getString(key);
    }
}