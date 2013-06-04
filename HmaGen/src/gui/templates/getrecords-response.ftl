<#-- Freemarker template of an HMA GetRecords response -->
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
<#if rec.qltyDeg??>
                    <rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::imageQualityDegradation" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:Double">
                        <rim:ValueList>
                            <rim:Value>${rec.qltyDeg}</rim:Value>
                        </rim:ValueList>
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
<#if rec.prdType??>
                    <rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::productType" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:String">
                        <rim:ValueList>
                            <rim:Value>${rec.prdType}</rim:Value>
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
<#if rec.alongIncAngle??>
                    <rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::alongTrackIncidenceAngle" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:Double">
                        <rim:ValueList>
                            <rim:Value>${rec.alongIncAngle}</rim:Value>
                        </rim:ValueList>
                    </rim:Slot>
</#if>
<#if rec.acqType??>
                    <rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::acquisitionType" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:String">
                        <rim:ValueList>
                            <rim:Value>${rec.acqType}NOMINAL</rim:Value>
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
<#if rec.acrossIncAngle??>
                    <rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::acrossTrackIncidenceAngle" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:Double">
                        <rim:ValueList>
                            <rim:Value>${rec.acrossIncAngle}</rim:Value>
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
<#if rec.status??>
                    <rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::status" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:String">
                        <rim:ValueList>
                            <rim:Value>${rec.status}</rim:Value>
                        </rim:ValueList>
                    </rim:Slot>
</#if>
                </rim:ExtrinsicObject>
<#--
                <rim:ExtrinsicObject id="${rec.prodId}:ARCH" objectType="urn:ogc:def:objectType:OGC-CSW-ebRIM-EO::EOArchivingInformation">
                    <rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::archivingDate" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:DateTime">
                        <rim:ValueList>
                            <rim:Value>2007-01-10T01:04:01Z</rim:Value>
                        </rim:ValueList>
                    </rim:Slot>
                    <rim:Name>
                        <rim:LocalizedString xml:lang="en-US" charset="UTF-8" value="AB"/>
                    </rim:Name>
                </rim:ExtrinsicObject>
                <rim:Association id="${rec.prodId}:ARCH_ASSOC"
                                 associationType="urn:ogc:def:associationType:OGC-CSW-ebRIM-EO::ArchivedIn"
                                 sourceObject="${rec.prodId}"
                                 targetObject="${rec.prodId}:ARCH"/>
                <rim:ExtrinsicObject id="${rec.prodId}:BRWS" objectType="urn:ogc:def:objectType:OGC-CSW-ebRIM-EO::EOBrowseInformation">
                    <rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::fileName" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:String">
                        <rim:ValueList>
                            <rim:Value>http://dev.ionicsoft.com:80/daliproxy/wrs/DALIPROXYLAZY?REQUEST=GetRepositoryItem&amp;Id=urn%3Ax-dali%3Asat%3AShift0%3Aa21%3A43733800701100016312I%3Adn%3A4377990%3A4</rim:Value>
                        </rim:ValueList>
                    </rim:Slot>
                </rim:ExtrinsicObject>
                <rim:Association id="${rec.prodId}:BRWS_ASSOC"
                                 associationType="urn:ogc:def:associationType:OGC-CSW-ebRIM-EO::HasBrowseInformation"
                                 sourceObject="${rec.prodId}"
                                 targetObject="${rec.prodId}:BRWS"/>
                <rim:ExtrinsicObject id="${rec.prodId}:ACQ" objectType="urn:ogc:def:objectType:OGC-CSW-ebRIM-EO::EOAcquisitionPlatform">
                    <rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::sensorType" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:String">
                        <rim:ValueList>
                            <rim:Value>OPTICAL</rim:Value>
                        </rim:ValueList>
                    </rim:Slot>
                    <rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::instrumentShortName" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:String">
                        <rim:ValueList>
                            <rim:Value>HRVIR-Nb2</rim:Value>
                        </rim:ValueList>
                    </rim:Slot>
                    <rim:Slot name="urn:ogc:def:slot:OGC-CSW-ebRIM-EO::platformSerialIdentifier" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:String">
                        <rim:ValueList>
                            <rim:Value>I</rim:Value>
                        </rim:ValueList>
                    </rim:Slot>
                    <rim:Name>
                        <rim:LocalizedString xml:lang="en-US" charset="UTF-8" value="Spot4"/>
                    </rim:Name>
                </rim:ExtrinsicObject>
                <rim:Association id="${rec.prodId}:ACQ_ASSOC"
                                 associationType="urn:ogc:def:associationType:OGC-CSW-ebRIM-EO::AcquiredBy"
                                 sourceObject="${rec.prodId}"
                                 targetObject="${rec.prodId}:ACQ"/>
-->
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