HmaGen
======

*HMA Catalogue Metadata Generator*

It is a GUI tool to generate synthetic HMA Catalogue GetRecords responses (xml files) or to serve them trough an embedded HTTP server.

Features
--------
* `EOProduct`s extrinsic objects are always generated
* EOArchivingInformation, `EOAcquisitionPlatform` and `EOBrowseInformation` extrinsic objects are generated on demand
* You can choose in detail which attributes (_Slots_) are to be generated
* A classification can be generated too
* Up to two `EOBrowseInformation` objects can be generated: thumbnail and quicklook
* Option to link thumbnail and quicklook attributes (same index in the list of values)
* Footprint can be restricted to a geographical range (min/max lat/lon), quick choice via presets
* Generated GetRecordsResponse can be without leading spaces and optionally wrapped in SOAPV1.1 or SOAPV1.2 envelopes
* Import/Export of generation settings
* Generation in worker thread with progress notification
* Serving trough an embedded Jetty HTTP server
* In server mode the number of records can be randomized and the parent identifiers can be those of the request
* Statistics are collected in server mode and shown every minute
* Before generation settings are validated (e.g. intervals with end greater than beginning, allowed value lists not empty, etc.)

##Changelog

### V. 0.3

3-Jan-2015

* Fixed broken preset load/save ([#3](/../../issues/3))
* Delay log of statistics

### V. 0.2

22-Dec-2014

* Transitioned to maven build tool
* It's now possible to specify the server port
* Logging trough SLF4J api with Logback implementation
* Statistics trough Dropwizard Metrics library ([#1](/../../issues/1))
* Footprint generation area presets ([#2](/../../issues/2))

### V. 0.1

2014-2013

* Initial release as NetBeans project
