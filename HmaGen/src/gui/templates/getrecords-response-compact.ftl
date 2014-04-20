<#-- Freemarker template of an HMA GetRecords response -->
<#if envelope=="soap11">
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
<soapenv:Header/>
<soapenv:Body>
</#if>
<#if envelope=="soap12">
<soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope">
<soap:Header/>
<soap:Body>
</#if>
<csw:GetRecordsResponse xmlns="http://www.opengis.net/cat/csw/2.0.2"
xmlns:csw="http://www.opengis.net/cat/csw/2.0.2"
xmlns:rim="urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0"
xmlns:wrs="http://www.opengis.net/cat/wrs/1.0"
xmlns:gml="http://www.opengis.net/gml">
<csw:SearchStatus/>
<csw:SearchResults numberOfRecordsMatched="${numRecs}" numberOfRecordsReturned="${numRecs}">
<#list records as rec>
<rim:RegistryPackage id="${rec.prodId}" objectType="urn:oasis:names:tc:ebxml-regrep:ObjectType:RegistryObject:RegistryPackage">
<rim:Name>
<rim:LocalizedString xml:lang="en-US" charset="UTF-8" value="EOProduct"/>
</rim:Name>
<rim:RegistryObjectList>
<rim:ExtrinsicObject id="${rec.prodId}" objectType="urn:ogc:def:objectType:OGC-CSW-ebRIM-EO::EOProduct">
<#if rec.parentId??>
<rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::parentIdentifier" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:String">
<rim:ValueList>
<rim:Value>${rec.parentId}</rim:Value>
</rim:ValueList>
</rim:Slot>
</#if>
<#if rec.prdType??>
<rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::productType" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:String">
<rim:ValueList>
<rim:Value>${rec.prdType}</rim:Value>
</rim:ValueList>
</rim:Slot>
</#if>
<#if rec.status??>
<rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::status" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:String">
<rim:ValueList>
<rim:Value>${rec.status}</rim:Value>
</rim:ValueList>
</rim:Slot>
</#if>
<#if rec.startSensing??>
<rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::beginPosition" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:DateTime">
<rim:ValueList>
<rim:Value>${rec.startSensing}</rim:Value>
</rim:ValueList>
</rim:Slot>
</#if>
<#if rec.stopSensing??>
<rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::endPosition" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:DateTime">
<rim:ValueList>
<rim:Value>${rec.stopSensing}</rim:Value>
</rim:ValueList>
</rim:Slot>
</#if>
<#if rec.orbitNumber??>
<rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::orbitNumber" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:Integer">
<rim:ValueList>
<rim:Value>${rec.orbitNumber}</rim:Value>
</rim:ValueList>
</rim:Slot>
</#if>
<#if rec.lastOrbit??>
<rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::lastOrbitNumber" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:Integer">
<rim:ValueList>
<rim:Value>${rec.lastOrbit}</rim:Value>
</rim:ValueList>
</rim:Slot>
</#if>
<#if rec.orbitDir??>
<rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::orbitDirection" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:String">
<rim:ValueList>
<rim:Value>${rec.orbitDir}</rim:Value>
</rim:ValueList>
</rim:Slot>
</#if>
<#if rec.qltyDeg??>
<rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::imageQualityDegradation" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:Double">
<rim:ValueList>
<rim:Value>${rec.qltyDeg}</rim:Value>
</rim:ValueList>
</rim:Slot>
</#if>
<#if rec.footprint??>
<rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::multiExtentOf" slotType="urn:ogc:def:dataType:ISO-19107:2003:GM_Object">
<wrs:ValueList>
<wrs:AnyValue>
<gml:Polygon srsName="urn:ogc:def:crs:EPSG:6.3:4326">
<gml:exterior>
<gml:LinearRing srsName="urn:ogc:def:crs:EPSG:6.3:4326">
<gml:posList>${rec.footprint}</gml:posList>
</gml:LinearRing>
</gml:exterior>
</gml:Polygon>
</wrs:AnyValue>
</wrs:ValueList>
</rim:Slot>
</#if>
<#if rec.center??>
<rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::centerOf" slotType="urn:ogc:def:dataType:ISO-19107:2003:GM_Object">
<wrs:ValueList>
<wrs:AnyValue>
<gml:Point srsName=" urn:ogc:def:crs:EPSG:6.3:4326">
<gml:pos>${rec.center}</gml:pos>
</gml:Point>
</wrs:AnyValue>
</wrs:ValueList>
</rim:Slot>
</#if>
<#if rec.Incid??>
<rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::incidenceAngle" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:Double">
<rim:ValueList>
<rim:Value>${rec.Incid}</rim:Value>
</rim:ValueList>
</rim:Slot>
</#if>
<#if rec.alongIncAngle??>
<rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::alongTrackIncidenceAngle" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:Double">
<rim:ValueList>
<rim:Value>${rec.alongIncAngle}</rim:Value>
</rim:ValueList>
</rim:Slot>
</#if>
<#if rec.acrossIncAngle??>
<rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::acrossTrackIncidenceAngle" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:Double">
<rim:ValueList>
<rim:Value>${rec.acrossIncAngle}</rim:Value>
</rim:ValueList>
</rim:Slot>
</#if>
<#if rec.ANX??>
<rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::ascendingNodeLongitude" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:Double">
<rim:ValueList>
<rim:Value>${rec.ANX}</rim:Value>
</rim:ValueList>
</rim:Slot>
</#if>
<#if rec.WRSLat??>
<rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::wrsLatitudeGrid" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:Double">
<rim:ValueList>
<rim:Value>${rec.WRSLat}</rim:Value>
</rim:ValueList>
</rim:Slot>
</#if>
<#if rec.WRSLon??>
<rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::wrsLongitudeGrid" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:Double">
<rim:ValueList>
<rim:Value>${rec.WRSLon}</rim:Value>
</rim:ValueList>
</rim:Slot>
</#if>
<#if rec.acqType??>
<rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::acquisitionType" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:String">
<rim:ValueList>
<rim:Value>${rec.acqType}</rim:Value>
</rim:ValueList>
</rim:Slot>
</#if>
<#if rec.acqSubType??>
<rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::acquisitionSubType" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:String">
<rim:ValueList>
<rim:Value>${rec.acqSubType}</rim:Value>
</rim:ValueList>
</rim:Slot>
</#if>
<#if rec.acqStation??>
<rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::acquisitionStation" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:String">
<rim:ValueList>
<rim:Value>${rec.acqStation}</rim:Value>
</rim:ValueList>
</rim:Slot>
</#if>
<#if rec.acqDate??>
<rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::acquisitionDate" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:DateTime">
<rim:ValueList>
<rim:Value>${rec.acqDate}</rim:Value>
</rim:ValueList>
</rim:Slot>
</#if>
<#if rec.cloudCover??>
<rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::cloudCoverPercentage" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:Double">
<rim:ValueList>
<rim:Value>${rec.cloudCover}</rim:Value>
</rim:ValueList>
</rim:Slot>
</#if>
<#if rec.snowCover??>
<rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::snowCoverPercentage" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:Double">
<rim:ValueList>
<rim:Value>${rec.snowCover}</rim:Value>
</rim:ValueList>
</rim:Slot>
</#if>
<#if rec.illumAzim??>
<rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::illuminationAzimuthAngle" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:Double">
<rim:ValueList>
<rim:Value>${rec.illumAzim}</rim:Value>
</rim:ValueList>
</rim:Slot>
</#if>
<#if rec.illumElev??>
<rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::illuminationElevationAngle" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:Double">
<rim:ValueList>
<rim:Value>${rec.illumElev}</rim:Value>
</rim:ValueList>
</rim:Slot>
</#if>
<#if rec.polarisation??>
<rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::polarisationChannels" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:String">
<rim:ValueList>
<rim:Value>${rec.polarisation}</rim:Value>
</rim:ValueList>
</rim:Slot>
</#if>
<#if rec.polarisationModes??>
<rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::polarisationMode" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:String">
<rim:ValueList>
<rim:Value>${rec.polarisationModes}</rim:Value>
</rim:ValueList>
</rim:Slot>
</#if>
<#if rec.antLookDir??>
<rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::antennaLookDirection" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:String">
<rim:ValueList>
<rim:Value>${rec.antLookDir}</rim:Value>
</rim:ValueList>
</rim:Slot>
</#if>
<#if rec.minIncid??>
<rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::minimumIncidenceAngle" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:Double">
<rim:ValueList>
<rim:Value>${rec.minIncid}</rim:Value>
</rim:ValueList>
</rim:Slot>
</#if>
<#if rec.maxIncid??>
<rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::maximumIncidenceAngle" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:Double">
<rim:ValueList>
<rim:Value>${rec.maxIncid}</rim:Value>
</rim:ValueList>
</rim:Slot>
</#if>
<#if rec.specAttrs??>
<rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::vendorSpecificAttributes" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:String">
<rim:ValueList>
<#list rec.specAttrs as attr>
<rim:Value>${attr[0]}</rim:Value>
</#list>
</rim:ValueList>
</rim:Slot>
<rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::vendorSpecificValues" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:String">
<rim:ValueList>
<#list rec.specAttrs as attr>
<rim:Value>${attr[1]}</rim:Value>
</#list>
</rim:ValueList>
</rim:Slot>
</#if>
</rim:ExtrinsicObject>
<#if rec.archCenter??>
<rim:ExtrinsicObject id="${rec.prodId}:ARCH" objectType="urn:ogc:def:objectType:OGC-CSW-ebRIM-EO::EOArchivingInformation">
<#if rec.archDate??>
<rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::archivingDate" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:DateTime">
<rim:ValueList>
<rim:Value>${rec.archDate}</rim:Value>
</rim:ValueList>
</rim:Slot>
</#if>
<#if rec.archId??>
<rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::archivingIdentifier" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:String">
<rim:ValueList>
<rim:Value>${rec.archId}</rim:Value>
</rim:ValueList>
</rim:Slot>
</#if>
<rim:Name>
<rim:LocalizedString xml:lang="en-US" charset="UTF-8" value="${rec.archCenter}"/>
</rim:Name>
</rim:ExtrinsicObject>
<rim:Association id="${rec.prodId}:ARCH_ASSOC"
associationType="urn:ogc:def:associationType:OGC-CSW-ebRIM-EO::ArchivedIn"
sourceObject="${rec.prodId}"
targetObject="${rec.prodId}:ARCH"/>
</#if>
<#if rec.thmbUrl??>
<rim:ExtrinsicObject id="${rec.prodId}:THMB" objectType="urn:ogc:def:objectType:OGC-CSW-ebRIM-EO::EOBrowseInformation">
<rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::fileName" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:String">
<rim:ValueList>
<rim:Value>${rec.thmbUrl}</rim:Value>
</rim:ValueList>
</rim:Slot>
<rim:Name>
<rim:LocalizedString xml:lang="en-US" charset="UTF-8" value="THUMBNAIL"/>
</rim:Name>
</rim:ExtrinsicObject>
<rim:Association id="${rec.prodId}:THMB_ASSOC"
associationType="urn:ogc:def:associationType:OGC-CSW-ebRIM-EO::HasBrowseInformation"
sourceObject="${rec.prodId}"
targetObject="${rec.prodId}:THMB"/>
</#if>
<#if rec.qlkUrl??>
<rim:ExtrinsicObject id="${rec.prodId}:QLK" objectType="urn:ogc:def:objectType:OGC-CSW-ebRIM-EO::EOBrowseInformation">
<rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::fileName" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:String">
<rim:ValueList>
<rim:Value>${rec.qlkUrl}</rim:Value>
</rim:ValueList>
</rim:Slot>
<rim:Name>
<rim:LocalizedString xml:lang="en-US" charset="UTF-8" value="QUICKLOOK"/>
</rim:Name>
</rim:ExtrinsicObject>
<rim:Association id="${rec.prodId}:QLK_ASSOC"
associationType="urn:ogc:def:associationType:OGC-CSW-ebRIM-EO::HasBrowseInformation"
sourceObject="${rec.prodId}"
targetObject="${rec.prodId}:QLK"/>
</#if>
<#if rec.platName??>
<rim:ExtrinsicObject id="${rec.prodId}:ACQ" objectType="urn:ogc:def:objectType:OGC-CSW-ebRIM-EO::EOAcquisitionPlatform">
<#if rec.resolution??>
<rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::sensorResolution" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:Double">
<rim:ValueList>
<rim:Value>${rec.resolution}</rim:Value>
</rim:ValueList>
</rim:Slot>
</#if>
<#if rec.swathId??>
<rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::swathIdentifier" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:String">
<rim:ValueList>
<rim:Value>${rec.swathId}</rim:Value>
</rim:ValueList>
</rim:Slot>
</#if>
<#if rec.sensMode??>
<rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::sensorOperationalMode" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:String">
<rim:ValueList>
<rim:Value>${rec.sensMode}</rim:Value>
</rim:ValueList>
</rim:Slot>
</#if>
<#if rec.sensType??>
<rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::sensorType" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:String">
<rim:ValueList>
<rim:Value>${rec.sensType}</rim:Value>
</rim:ValueList>
</rim:Slot>
</#if>
<#if rec.sensName??>
<rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::instrumentShortName" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:String">
<rim:ValueList>
<rim:Value>${rec.sensName}</rim:Value>
</rim:ValueList>
</rim:Slot>
</#if>
<#if rec.platSer??>
<rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::platformSerialIdentifier" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:String">
<rim:ValueList>
<rim:Value>${rec.platSer}</rim:Value>
</rim:ValueList>
</rim:Slot>
</#if>
<rim:Name>
<rim:LocalizedString xml:lang="en-US" charset="UTF-8" value="${rec.platName}"/>
</rim:Name>
</rim:ExtrinsicObject>
<rim:Association id="${rec.prodId}:ACQ_ASSOC"
associationType="urn:ogc:def:associationType:OGC-CSW-ebRIM-EO::AcquiredBy"
sourceObject="${rec.prodId}"
targetObject="${rec.prodId}:ACQ"/>
</#if>
<#if rec.classif??>
<rim:Classification id="${rec.prodId}:CLAS"
classifiedObject="${rec.prodId}"
classificationNode="urn:ogc:def:classificationScheme:OGC-CSW-ebRIM-EO::EOProductTypes:${rec.classif}"
classificationScheme="urn:ogc:def:classificationScheme:OGC-CSW-ebRIM-EO::EOProductTypes"/>
</#if>
</rim:RegistryObjectList>
</rim:RegistryPackage>
</#list>
</csw:SearchResults>
</csw:GetRecordsResponse>
<#if envelope=="soap11">
</soapenv:Body>
</soapenv:Envelope>
</#if>
<#if envelope=="soap12">
</soap:Body>
</soap:Envelope>
</#if>
