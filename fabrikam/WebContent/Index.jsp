


<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.fabrikam.db.*,com.fabrikam.common.*,java.util.*"%>

<head>
<meta charset="utf-8" />

<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/content/images/favicon.ico" />

<title>Home Page</title>
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
						<h1>Dashboard</h1>
					</td>
					<td align="left">
						<p>
							<a href="CreateNewTicket.jsp"> <img
								src="${pageContext.request.contextPath}/content/images/button.png" /></a>
						</p>

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
					<td>
						<table class="dataTable">
							<tr>
								<th>Ref</th>
								<th>Status</th>
								<th>Escalation</th>
								<th>Title</th>
								<th>Assigned To</th>
								<th>Time Open</th>

							</tr>
							<%
								DataAccess access = new DataAccess();
								ArrayList list = access.getServiceTickets();
								pageContext.setAttribute("serviceTokens", list);
							%>
							<c:forEach var="serviceTicket" items="${serviceTokens}">
								<tr>
									<td>A01410${serviceTicket.ref}</td>
									<td>${serviceTicket.status}</td>
									<td>Level ${serviceTicket.escalation}</td>
									<td>${serviceTicket.title}</td>
									<td>${serviceTicket.name}</td>
									<td>${serviceTicket.openedDate}</td>

								</tr>
							</c:forEach>
							<%-- <c:forEach var="i" begin="1" end="5">
	 <tr>
	   <td>Item <c:out value="${i}"/></td>
	   </tr>
	  </c:forEach> --%>

						</table>

					</td>

				</tr>
			</table>
		</section>
	</div>
</html>