HmaGen
======

*HMA Catalogue Metadata Generator*

It is a GUI tool to generate synthetic HMA Catalogue GetRecords responses (xml files).

Features
--------
* `EOProduct`s extrinsic objects are always generated
* EOArchivingInformation, `EOAcquisitionPlatform` and `EOBrowseInformation` extrinsic objects are optional
* Up to two `EOBrowseInformation` objects can be generated: thumbnail and quicklook
* You can choose in detail which attributes (_Slots_) are to be generated
* A classification can be generated too
* Import/Export of generation settings
* Dialog for successful generation
* Generation in worker thread with progress notification
* Check correctness of values before generation (e.g. intervals with end greater than beginning, allowed vals not empty, etc.)

Future enhancements
----
* Option to strip leading spaces from output lines
* Remember last folder where files have been generated and config files loaded/saved
* Automatically add `.hmagen` extension to config files and `.xml` extension to generated files
* More `EOProduct` metadata attributes
* Reduce `EOProduct` tab cluttering separating optical, radar and atmospheric attributes in different tabs
* Better error reporting
* Multithreaded generation
* Automatic persistence of generation settings between runs (Java Preferences API)