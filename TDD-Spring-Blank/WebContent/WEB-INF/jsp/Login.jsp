<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%
String ROOT = request.getContextPath();
if (ROOT.equalsIgnoreCase("/")) {
	ROOT = "";
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Login | payb.at</title>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
	<link rel="icon" href="<%=ROOT%>/images/favicon.png" />
	<meta name="keywords" content="social bank network, digital banking platform" />
	<meta name="description" content="payb.at struggle to make 'Everyone can build digital bank' coming true." />
	<link type="text/css" rel="stylesheet" href="<%=ROOT%>/styles/common.css" />		
	<link type="text/css" rel="stylesheet" href="<%=ROOT%>/styles/bootstrap.min.css" />		
	<link type="text/css" rel="stylesheet" href="<%=ROOT%>/styles/bootstrap-theme.min.css" />		
	<script type="text/javascript" src="<%=ROOT%>/scripts/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="<%=ROOT%>/scripts/responsive.js"></script>
	<script type="text/javascript" src="<%=ROOT%>/scripts/bootstrap.min.js"></script>
	<script type="text/javascript">
function yo_screen_changed() {
}
function yo_screen_changed_1280() {
}
function yo_screen_changed_960() {
}
function yo_screen_changed_854() {
}
function yo_screen_changed_800() {
}
function yo_screen_changed_720() {
}
function yo_screen_changed_640() {
}
function yo_screen_changed_600() {
}
function yo_screen_changed_540() {
}
function yo_screen_changed_480() {
}
function yo_screen_changed_360() {
}
function yo_screen_changed_320() {
}
function yo_screen_changed_240() {
}
	</script>		
	<style>
	
	</style>
</head>
<body id="yo-screen">
	<div class="yo-page">

<div class='yo-logo'>
	<a href='<%=ROOT%>/index.yo' title='payb.at - Social Bank Network'>
		<img src='<%=ROOT%>/images/icon.png' width='100px' height='100px' />
	</a>
</div>

<div class="yo-menu">
	<a href="<%=ROOT%>/login.yo">Login</a>
</div>

<div class="yo-post" style="max-width: 340px;">
	<div class="yo-title"><a href="<%=ROOT%>/login.yo">Login</a></div>
	<div class="yo-body">
		<form:form action="${ROOT}/login.yo" commandName="user">
		<p><form:input id="emailE" path="email" class="form-control" placeholder="Enter email" /></p>
		<p><form:input id="passwordE" path="password" type="password" class="form-control" placeholder="Enter password" /></p>
		<p class="text-center"><input id="loginE" type="submit" class="btn btn-success" value="Login" /></p>
		<p class="text-warning" id="messageE">${message}</p>
		</form:form>
	</div>
</div>
	
<div class='yo-copyright'><center>Copyright &copy; 2016 &nbsp; <a href='<%=ROOT%>/index.yo'>payb.at</a></center></div>
	
	</div>
</body>
</html>