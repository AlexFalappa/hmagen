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
<csw:GetRecordsResponse xmlns:csw="http://www.opengis.net/cat/csw/2.0.2">
<csw:SearchStatus/>
<csw:SearchResults numberOfRecordsMatched="${numRecs}" numberOfRecordsReturned="${numRecs}"/>
</csw:GetRecordsResponse>
<#if envelope=="soap11">
</soapenv:Body>
</soapenv:Envelope>
</#if>
<#if envelope=="soap12">
</soap:Body>
</soap:Envelope>
</#if>
