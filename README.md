#DEPENDENCY
```
MYSQLConnector
Hibernate-core-relocation-5.6.15.Final
spring-webmvc-6.2.0
jakarta.servlet.jsp.jstl-api-3.0.0
org.glassfish.web-jakarta.servlet.jsp.jstl-3.0.1
javax.servlet-jstl-1.2
jakarta.servlet-jakarta.servlet-api-6.1.0-provided
```


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


**#WEBINITIALIZER**
```java
public class EmployeeWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
        @Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}
        @Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {EmployeeConfiguration.class,};
	}
        @Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}
```

```
**#CONFIGURATION**
@Configuration
@ComponentScan(basePackages = "com.ty")
public class EmployeeConfiguration {
        @Bean
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("raj").createEntityManager();
	}
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
	}
```

**#CONTROLLER**
```
@Controller
public class EmployeeController {
        @Autowired
	private EmployeeDao employeeDao;
        @ModelAttribute("genderlist")
	public List<String> getGender() {
		List<String> list = new ArrayList<String>();
		list.add("male");
		list.add("female");
		list.add("Others");
		return list;
	}
        @ModelAttribute("interestList")
	public List<String> getInterset() {
		List<String> list = new ArrayList<String>();
		list.add("Travelling");
		list.add("Tracking");
		list.add("Sports");
		return list;
	}
        @ModelAttribute("familyincomelist")
	public List<String> getFamilyIncome() {
		List<String> list = new ArrayList<String>();
		list.add("Up to 1lac");
		list.add("1 lac to 5 lac");
		list.add("5 lac to 10 lac");
		list.add("10 lac and above");
		return list;
	}
        @GetMapping("register")
	public String register(Model model) {
		model.addAttribute("user", new userEntity());
		return "register";
	}
       @PostMapping("save")
	public String save(@ModelAttribute("user") userEntity user) {
		this.employeeDao.save(user);
		return "redirect:read";
	}
        @GetMapping("read")
	public ModelAndView read(ModelAndView modelAndView) {
		modelAndView.addObject("use", this.employeeDao.getAllUsers());
		modelAndView.setViewName("read");
		return modelAndView;
	}
        @GetMapping("edit")
	public ModelAndView edit(@RequestParam("id") int id, ModelAndView modelAndView) {
		modelAndView.addObject("user", this.employeeDao.getUserById(id));
		modelAndView.setViewName("update");
		return modelAndView;
	}
        @PostMapping("update")
	public String update(@ModelAttribute("user") userEntity user) {
		this.employeeDao.update(user);
		return "redirect:read";
	}
       @GetMapping("delete")
	public String delete(@RequestParam("id") int id) {
		this.employeeDao.delete(id);
		return "redirect:read";
	}
```


**#DAO**
```
@Repository
public class EmployeeDao {
	@Autowired
	private EntityManager entityManager;
        public void save(userEntity user) {
		// TODO Auto-generated method stub
		EntityTransaction entityTransaction = this.entityManager.getTransaction();
		entityTransaction.begin();
		this.entityManager.persist(user);
		entityTransaction.commit();
	}
	public List<String> getAllUsers() {
		Query query = this.entityManager.createQuery("select u from userEntity u");
		return query.getResultList();
	}
	public userEntity getUserById(int id) {
	      return (userEntity)this.entityManager.find(userEntity.class, id);
	   }
          public void update(userEntity user) {
	      EntityTransaction entityTransaction = this.entityManager.getTransaction();
	      entityTransaction.begin();
	      this.entityManager.merge(user);
	      entityTransaction.commit();
	   }
           public void delete(int id) {
	      EntityTransaction entityTransaction = this.entityManager.getTransaction();
	      entityTransaction.begin();
	      this.entityManager.remove(this.getUserById(id));
	      entityTransaction.commit();
	   }
```


**#REGISTERPAGE**
```
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
</head>
<body>
<form:form action="save" method="post" modelAttribute="user">
 	<form:label path="fullName"> Full Name:</form:label>
		<form:input path="fullName" />
		<br>
		<form:label path="date">Date of Birth</form:label>
		<form:input path="date" />
		<br>
		<form:label path="gender">Gender</form:label>
		<form:radiobuttons path="gender" items="${genderlist}" delimiter=" | " />
		<br>
		<form:label path="address">Address</form:label>
		<form:textarea path="address" />
		<br>
		<form:label path="state">State</form:label>
		<form:input path="state" />
		<br>
		<form:label path="district">District</form:label>
		<form:input path="district" />
		<br>
		<form:label path="taluka">Taluka</form:label>
		<form:input path="taluka" />
		<br>
		<form:label path="pincode">Pincode</form:label>
		<form:input path="pincode" />
		<br>
		<form:label path="familyIncome"> Family Income</form:label>
		<br>
		<form:radiobuttons path="familyIncome" items="${familyincomelist}"
			delimiter=" <br> " />
		<form:label path="interest">Interest :</form:label>
		<form:checkboxes items="${interestList}" path="interest"
			delimiter="<br>" />
		<table border="1px">
			<tr>
				<th>Skills</th>
				<th>RAting</th>
				<th>Out Of</th>
			</tr>
			<tr>
				<td>J2EE</td>
				<td><form:input path="j2ee" /></td>
				<td>10</td>
			</tr>
			<tr>
				<td>Hibernate</td>
				<td><form:input path="hibernate" /></td>
				<td>10</td>
			</tr>
			<tr>
				<td>Spring</td>
				<td><form:input path="spring" /></td>
				<td>10</td>
			</tr>
		</table>
		<form:button>Submit</form:button>
 	
</form:form>
</body>
</html>
```


**#READPAGE**
```
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1px">
		<tr>
			<th>ID</th>
			<th>Full Name</th>
			<th>Date of Birth</th>
			<th>Gender</th>
			<th>Address</th>
			<th>State</th>
			<th>District</th>
			<th>Taluka</th>
			<th>Pincode</th>
			<th>Family Income</th>
			<th>Intersest</th>
			<th>j2ee</th>
			<th>Hibernate</th>
			<th>Spring</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${use}" var="u">
			<tr>
				<th>${u.id}</th>
				<th>${u.fullName}</th>
				<th>${u.date}</th>
				<th>${u.gender}</th>
				<th>${u.address}</th>
				<th>${u.state}</th>
				<th>${u.district}</th>
				<th>${u.taluka}</th>
				<th>${u.pincode}</th>
				<th>${u.familyIncome}</th>
				<th>${u.interest}</th>
				<th>${u.j2ee}</th>
				<th>${u.hibernate}</th>
				<th>${u.spring}</th>
				<th><a href="edit?id=${u.id}"><button>Edit</button> </a></th>
				<th><a href="delete?id=${u.id}"><button>Delete</button></a></th>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
```


**#update**
```
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form method="post" modelAttribute="user" action="update">
	    <form:label path="id">ID :</form:label>
	    <form:input path="id" readonly="true"/>
		<form:label path="fullName"> Full Name:</form:label>
		<form:input path="fullName" />
		<br>
		<form:label path="date">Date of Birth</form:label>
		<form:input path="date" />
		<br>
		<form:label path="gender">Gender</form:label>
		<form:radiobuttons path="gender" items="${genderlist}" delimiter=" | " />
		<br>
		<form:label path="address">Address</form:label>
		<form:textarea path="address" />
		<br>
		<form:label path="state">State</form:label>
		<form:input path="state" />
		<br>
		<form:label path="district">District</form:label>
		<form:input path="district" />
		<br>
		<form:label path="taluka">Taluka</form:label>
		<form:input path="taluka" />
		<br>
		<form:label path="pincode">Pincode</form:label>
		<form:input path="pincode" />
		<br>
		<form:label path="familyIncome"> Family Income</form:label>
		<br>
		<form:radiobuttons path="familyIncome" items="${familyincomelist}"
			delimiter=" <br> " />
		<form:label path="interest">Interest :</form:label>
		<form:checkboxes items="${interestList}" path="interest" delimiter="<br>"/>		
		<table border="1px">
			<tr>
				<th>Skills</th>
				<th>Rating</th>
				<th>Out Of</th>
			</tr>
			<tr>
				<td>J2EE</td>
				<td><form:input path="j2ee" /></td>
				<td>10</td>
			</tr>
			<tr>
				<td>Hibernate</td>
				<td><form:input path="hibernate" /></td>
				<td>10</td>
			</tr>
			<tr>
				<td>Spring</td>
				<td><form:input path="spring" /></td>
				<td>10</td>
			</tr>
		</table>
		<form:button>Submit</form:button>
	</form:form>
</body>
</html>
```
