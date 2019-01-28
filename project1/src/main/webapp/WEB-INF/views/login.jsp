<%@ include file="control/header.jspf"%>
<%@ include file="control/constraint.jspf"%>
<div class="container">

<fieldset class="form-group">
    <p><font color="red">${errorMessage}</font></p>
    <form action="login" method="POST">
    <label>    Name</label> : <input name="name" type="text" class="form-control" />
    <label> Password</label> : <input name="password" type="password" class="form-control" /> 
    <input class="btn btn-success" type="submit" />
    </form>
    </div>
 