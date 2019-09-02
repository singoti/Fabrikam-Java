


<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.fabrikam.db.*,com.fabrikam.common.*,java.util.*"%>

<head>
<meta charset="utf-8" />
<%This is a sample Change%>
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/content/images/favicon.ico" />

<title>Customers</title>
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
	<form method="post" action="CreateCustomers">
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
						<td>
							<%
								String id = request.getParameter("id");
								int idNo = 0;
								try {
									if (id != null)
										idNo = Integer.parseInt(id);
								} catch (NumberFormatException e) {
								}
								DataAccess access = DataAccess.getInstance();
								Customer customer1 = access.getCustomer(idNo);
								System.out.println(customer1);
								pageContext.setAttribute("customer", customer1);
							%> <c:if test="${customer==null}">
Create
</c:if> <c:if test="${customer!=null}">
								<input type="hidden" name="action" value="edit">
								<input type="hidden" name="id" value="${customer.id}">
Edit
</c:if> <br /> <br /> <br /> Customer <br /> <br /> <br /> First Name <br>
							<c:if test="${customer==null}">
								<input name="firstName" type="text" size="50" /> 
							</c:if> <c:if test="${customer!=null}">
								<input name="firstName" type="text" size="50"
									value="${customer.firstName}" /> 
							</c:if> <br /> <br /> 
							Last Name <br> 
							<c:if test="${customer==null}">
								<input name="lastName" type="text" size="50" />
							</c:if> <c:if test="${customer!=null}">
								<input name="lastName" type="text" size="50"
									value="${customer.lastName}" />
							</c:if> <br /> <br /> 
							Street <br> <c:if test="${customer==null}">
								<input name="street" type="text" size="50" />
							</c:if> <c:if test="${customer!=null}">
								<input name="street" type="text" size="50"
									value="${customer.street}" />
							</c:if> <br /> <br /> 
							City <br> <c:if test="${customer==null}">
								<input name="city" type="text" size="50" />
							</c:if> <c:if test="${customer!=null}">
								<input name="city" type="text" size="50"
									value="${customer.city}" />
							</c:if> <br /> <br /> 
							State <br> <c:if test="${customer==null}">
								<input name="state" type="text" size="50" />
							</c:if> <c:if test="${customer!=null}">
								<input name="state" type="text" size="50"
									value="${customer.state}" />
							</c:if> <br /> <br /> 
							Zip <br> <c:if test="${customer==null}">
								<input name="zip" type="text" size="50" />
							</c:if> <c:if test="${customer!=null}">
								<input name="zip" type="text" size="50" value="${customer.zip}" />
							</c:if> <br /> <br /> <br /> <c:if test="${customer==null}">
								<input type="submit" name="create" value="Create" />
							</c:if> <c:if test="${customer!=null}">
								<input type="submit" name="save" value="Save" />
							</c:if>
						</td>
					</tr>
				</table>
			</section>
		</div>
	</form>
</body>
</html>
