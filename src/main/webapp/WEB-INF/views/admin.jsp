<html>  
<head>  
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
    <title>Admin</title>  
    </head>  
<body>  
    Welcome Admin
    <form action="<%=request.getContextPath()%>/appLogout" method="POST">
       <input type="submit" value="Logout"/>
       <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>        
     </form> 
</body>  
</html>