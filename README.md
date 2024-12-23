# ICT_CRUD
**#persistence**
<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence
             http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd"
	version="2.1">

	<persistence-unit name="raj"
		transaction-type="RESOURCE_LOCAL">

		<properties>
			<property name="javax.persistence.jdbc.driver"
				value="org.postgresql.Driver" /> <!-- DB Driver -->
			<property name="javax.persistence.jdbc.url"
				value="jdbc:postgresql://localhost:5432/crudspringbootjpa" /> <!-- DB Name -->
			<property name="javax.persistence.jdbc.user" value="postgres" /> <!-- DB User -->
			<property name="javax.persistence.jdbc.password" value="root" /> <!-- DB Password -->

			<property name="hibernate.dialect"
				value="org.hibernate.dialect.PostgreSQLDialect" /> <!-- DB Dialect -->
			<property name="hibernate.hbm2ddl.auto" value="update" /> <!-- create / create-drop / update -->

			<property name="hibernate.show_sql" value="true" /> <!-- Show SQL in console -->
			<property name="hibernate.format_sql" value="true" /> <!-- Show SQL formatted -->
		</properties>

	</persistence-unit>

</persistence>
