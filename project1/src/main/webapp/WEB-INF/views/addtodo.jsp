<%@ include file="control/header.jspf"%>
<%@ include file="control/constraint.jspf"%>
<div class="container">
<form:form method="post"  commandName="todo">
<spring:message code="add.message"/>
<fieldset class="form-group">
<form:hidden path="id"/>
<form:hidden path="user"/>

<form:label path="desc">Enter Your Description<br> </form:label><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:input type="text" path="desc" required="required" class="form-control"></form:input><br>
<form:errors path="desc" cssclass="text-warning"></form:errors>

</fieldset>
<fieldset class="form-group">
<form:label path="targetDate">Enter Date</form:label><br>

<form:input type="text" path="targetDate" required="required" class="form-control"></form:input><br>

</fieldset>
<input class="btn btn-success" type="submit" value="submit" >

</form:form>
</div>
