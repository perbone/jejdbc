jejdbc - JDBC Driver for Berkeley DB Java Edition [![License](https://img.shields.io/:license-apache-blue.svg)](https://opensource.org/licenses/Apache-2.0) 
======

> WIP (heavily updated so you can expect constants changes - no commitment with feature freezing at this moment)

A JDBC 4.2 compliant driver for Berkeley DB Java Edition

## Features

* Read-Write from/to local database (standalone environment)
* Read-Write from/to local master database (HA environment)
* Read-Only from local replica database (HA environment)
* Write-Forwarding to remote master database (HA environment)
* Server mode for local database (standalone environment)
* Server mode for local master/replica database (HA environment)
* Client mode for remote database (standalone/HA environment)
* Proxy mode for remote database (standalone/HA environment)
* Monitor mode for remote database (standalone/HA environment)
* Partitioning (optionally with multi-master)
* Saga pattern (really advanced)

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

Copyright 2013-2017 Paulo Perbone

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License
