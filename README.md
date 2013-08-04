HmaGen
======

*HMA Catalogue Metadata Generator*

It is a GUI tool to generate synthetic HMA Catalogue GetRecords responses (xml files).

Features
--------
* `EOProduct`s extrinsic objects are always generated
* EOArchivingInformation, `EOAcquisitionPlatform` and `EOBrowseInformation` extrinsic objects are generated on demand
* Up to two `EOBrowseInformation` objects can be generated: thumbnail and quicklook
* You can choose in detail which attributes (_Slots_) are to be generated
* A classification can be generated too
* Footprint can be restricted by a geographical bounding box (min/max lat/ton)
* Option to strip leading spaces from lines in generated files (more compact)
* Option to wrap generated GetRecordsResponse in SOAPV1.1 or SOAPV1.2 envelopes
* Import/Export of generation settings
* Generation in worker thread with progress notification
* Check correctness of values before generation (e.g. intervals with end greater than beginning, allowed vals not empty, etc.)
* Remember last folder where files have been generated and config files loaded/saved
* Option to link thumbnail and quicklook attributes (same index in the list of values)

Future enhancements
----
* Reduce `EOProduct` tab cluttering separating optical, radar and atmospheric attributes in different tabs
* Better error reporting
* Multithreaded generation
* Automatic persistence of generation settings between runs (Java Preferences API)