HmaGen
======

*HMA Catalogue Metadata Generator*

It is a GUI tool to generate synthetic HMA Catalogue GetRecords responses (xml files).

Features
--------
* `EOProduct`s extrinsic objects are always generated
* EOArchivingInformation, `EOAcquisitionPlatform` and `EOBrowseInformation` extrinsic objects are generated on demand
* You can choose in detail which attributes (_Slots_) are to be generated
* A classification can be generated too
* Up to two `EOBrowseInformation` objects can be generated: thumbnail and quicklook
* Option to link thumbnail and quicklook attributes (same index in the list of values)
* Footprint can be restricted by a geographical bounding box (min/max lat/ton)
* Generated GetRecordsResponse can be generated without leading spaces and optionally wrapped in SOAPV1.1 or SOAPV1.2 envelopes
* Import/Export of generation settings
* Generation in worker thread with progress notification
* Before generation settings are validated (e.g. intervals with end greater than beginning, allowed value lists not empty, etc.)
