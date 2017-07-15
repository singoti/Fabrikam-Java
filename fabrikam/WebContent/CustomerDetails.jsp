


<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.fabrikam.db.*,com.fabrikam.common.*,java.util.*"%>

<head>
<meta charset="utf-8" />

<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/content/images/favicon.ico" />

<title>Delete Customer</title>
<link href="${pageContext.request.contextPath}/content/style.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/content/themes/base/jquery.ui.all.css"
	rel="stylesheet" type="text/css" />
<script
	src="${pageContext.request.contextPath}/Scripts/jquery-1.5.1.min.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/Scripts/jQuery.tmpl.min.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/Scripts/knockout-1.2.0.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/Scripts/knockout.mapping-latest.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/Scripts/jquery-ui-1.8.11.js"
	type="text/javascript"></script>

</head>

<body>
		<table>
			<tr>
				<td>
					<h1>
						<img
							src="${pageContext.request.contextPath}/content/images/logo_new.png"
							alt="Fabrikam Fiber" />
					</h1>
				</td>
				<td align="left" valign="bottom"><a
					href="${pageContext.request.contextPath}/CustomerIndex.jsp"> <img
						src="${pageContext.request.contextPath}/content/images/menu.png" />
				</a></td>
			</tr>
		</table>
		<!--  Part 1 End -->
		<div id="container">
			<section id="content">
				<table>
					<!--  Part 2 Start -->
					<tr>
						<td>
							<aside id="profile">
								<h1>Profile</h1>
							</aside>
						</td>

						<td>
							<h1></h1>
						</td>
						<td align="left">
							<p>&nbsp;</p>
						</td>
					</tr>
					<tr>
						<td>
							<div class="profileImage"
								style="background-image: url('${pageContext.request.contextPath}/content/images/userphoto_kensanchez.jpg')">
							</div>
							<h2>Drew Robbins</h2>

							<ul class="alerts">
								<li><a href=""><span>Alerts:</span> 5</a></li>
								<li><a href=""><span>Tickets:</span> 3</a></li>
							</ul>

							<ul class="admin">
								<li class="tickets"><a href="">My tickets</a></li>
								<li class="profile"><a href="">My profile</a></li>
								<li class="schedule"><a href="">Schedule</a></li>
							</ul>
						</td>
						<td class="content">
							<%
								String id = request.getParameter("id");
								System.out.println("id in delete customer" + id);
								int idNo = Integer.parseInt(id);
								DataAccess access = DataAccess.getInstance();
								Customer customer = access.getCustomer(idNo);
								pageContext.setAttribute("customer", customer);
							%> Details <input type="hidden" name="id" value=<%=id%>> <br />
							<br /> <br /> Customer <br /> <br /> <br /> First Name <br>
							${customer.firstName} <br /> <br /> Last Name <br>
							${customer.lastName} <br /> <br /> Street <br>
							${customer.street} <br /> <br /> City <br> ${customer.city}
							<br /> <br /> State <br> ${customer.state} <br /> <br /> Zip
							<br> ${customer.zip} <br /> <br /> <br />
						</td>
					</tr>
				</table>
			</section>
		</div>
</body>
</html>