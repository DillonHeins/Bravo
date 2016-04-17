# Bravo Integration

How to deploy to Maven repo:

1.) Add the following to your ejb module's pom.xml file:
```xml
<distributionManagement>
    <repository>
        <id>snapshots</id>
        <name>Snapshots</name>
        <url>http://ec2-54-213-154-144.us-west-2.compute.amazonaws.com:8081/nexus/content/repositories/snapshots/</url>
    </repository>
</distributionManagement>
```
2.) Add the following to your settings.xml file (located at C:\Users\username\\.m2)
```xml
<servers>
	<server>
	  <id>snapshots</id>
	  <username>deploy</username>
	  <password>bravo</password>
	</server>
</servers>
```
3.) Ensure that you have set up your ejb module correctly in terms of group ID and artifact ID etc.
	For a working example of each subsection look in the 'Mocks' folder located under Integration.
	Feel free to use your corresponding ejb module under 'Mocks' as a template to place your business logic and entities in, we would prefer and
	do recommend that you use this approach as it will ensure that it integrates with the system correctly.

4.) Use `mvn install` to install your ejb module.

5.) Use `mvn deploy` to deploy your jar to the Maven repository.

6.) Notify your Integration team leader that you have deployed.