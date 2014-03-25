<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:wf="http://wfms.fei.stuba.sk/team/R">

<xsl:output method="text" version="1.0" indent="no" omit-xml-declaration="yes" encoding="windows-1250" />

<xsl:variable name="marker">#####<xsl:text>&#13;</xsl:text></xsl:variable>

<xsl:template match="/">

 <xsl:text>Users&#13;</xsl:text>
 <xsl:value-of select="$marker"/>

 <xsl:for-each select="wf:users/wf:user">

   <xsl:value-of select="local-name(wf:name)"/>
   <xsl:text> : </xsl:text>
   <xsl:value-of select="wf:name"/>
   <xsl:text>&#13;</xsl:text>

   <xsl:value-of select="local-name(@gender)"/>
   <xsl:text> : </xsl:text>
   <xsl:choose>
	<xsl:when test="@gender='M'">
        <xsl:text>Male</xsl:text>
	</xsl:when>
        <xsl:otherwise>
         <xsl:text>Female</xsl:text>
        </xsl:otherwise>
   </xsl:choose>
   <xsl:text>&#13;</xsl:text>

   <xsl:value-of select="local-name(wf:age)"/>
   <xsl:text> : </xsl:text>
   <xsl:value-of select="wf:age"/>
   <xsl:text>&#13;</xsl:text>

   <xsl:value-of select="local-name(wf:role)"/>
   <xsl:text> : </xsl:text>
   <xsl:value-of select="wf:role"/>
   <xsl:text>&#13;</xsl:text>

   <xsl:value-of select="$marker"/>

 </xsl:for-each>

</xsl:template>

</xsl:stylesheet>
