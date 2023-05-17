<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" indent="yes" />

<xsl:template match="/">
   <html>
	
	<p><b><xsl:value-of select="//name" /></b></p>
    <p><b>Contents: </b><xsl:value-of select="//content" /></p>
    <p><b>Owner:</b></p>
	<xsl:value-of select="Owner"/>
	<p> Name: <xsl:value-of select="@name" /> </p>
	<p> Email:   <xsl:value-of select="email" /> </p>
	<p> Phone: <xsl:value-of select="phone" /></p>
	
	<table border="1">
	  <th>Dog's name</th>
      <th>Breed</th>
      <th>Coat</th>
      <th>Date of Birth</th>
      
      <xsl:for-each select="Owner/Dogs/dog">
      <xsl:sort select="@name" />
	       <tr>
	            <td><xsl:value-of select="@name" /></td>
	            <td><xsl:value-of select="breed" /></td>
	            <td><xsl:value-of select="coat" /></td>
	            <td><xsl:value-of select="dob" /></td>            
	       </tr>        
      </xsl:for-each>  
		
	</table>		
	   
   </html>
   </xsl:template>
	
</xsl:stylesheet>