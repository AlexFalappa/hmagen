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

Todo
----
* More `EOProduct` metadata attributes
* Reduce `EOProduct` tab cluttering separating optical, radar and atmospheric attributes in different tabs
* Better error reporting
* Check correctness of values before generation (e.g. intervals with end greater than beginning, allowed vals not empty, etc.)
* Generation in worker thread with progress notification
* Multithreaded generation
* Dialog for successful generation
* Reset/Clear all values function
* Import/Export of generation settings
* Persistence of current generation settings between runs