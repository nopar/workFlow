<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:output omit-xml-declaration="yes"/>

<xsl:variable name="marker">
------------------------------------
</xsl:variable>

<xsl:template match="/">

 <xsl:text>Users</xsl:text>
 <xsl:text>&#13;</xsl:text>
 <xsl:value-of select="$marker"/>

 <xsl:for-each select="/*/user">

   <xsl:value-of select="name(name)"/>
   <xsl:text> : </xsl:text>
   <xsl:value-of select="name"/>
   <xsl:text>&#13;</xsl:text>

   <xsl:text>Gender : </xsl:text>
   <xsl:choose>
	<xsl:when test="@gender='M'">
        <xsl:text>Male</xsl:text>
	</xsl:when>
        <xsl:otherwise>
         <xsl:text>Female</xsl:text>
        </xsl:otherwise>
   </xsl:choose>
   <xsl:text>&#13;</xsl:text>

   <xsl:value-of select="name(age)"/>
   <xsl:text> : </xsl:text>
   <xsl:value-of select="age"/>
   <xsl:text>&#13;</xsl:text>

   <xsl:value-of select="name(role)"/>
   <xsl:text> : </xsl:text>
   <xsl:value-of select="role"/>
   <xsl:text>&#13;</xsl:text>

   <xsl:value-of select="$marker"/>

 </xsl:for-each>

</xsl:template>

</xsl:stylesheet>
