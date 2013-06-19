jejdbc
======

A JDBC 4.1 compliant driver for Berkeley DB Java Edition

## Features

* Read-Write from local database
* Read-Write from local master database
* Read-Only from local slave database
* Write-Forwarding to remote master database
* Server mode for local database
* Server mode for replicated database
* Client mode for remote database (can be local or replicated)
* Proxy mode for remote database (can be local or replicated)

## Issues and Support

Have a bug? Please create an issue here on GitHub!

https://github.com/perbone/jejdbc/issues

## Versioning

For transparency and insight into our release cycle, releases are be numbered with the [semantic versioning](http://semver.org/) format: `<major>.<minor>.<patch>` and constructed with the following guidelines:

* Breaking backwards compatibility bumps the major
* New additions without breaking backwards compatibility bumps the minor
* Bug fixes and misc changes bump the patch

## Contributors

* Paulo Perbone ([@perbone](https://twitter.com/perbone))

## License

Copyright (C) 2013 Paulo Perbone. All rights reserved.

This file is part of JEJDBC 
(https://github.com/perbone/jejdbc/)

JEJDBC is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

JEJDBC is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with JEJDBC. If not, see (http://www.gnu.org/licenses/).
