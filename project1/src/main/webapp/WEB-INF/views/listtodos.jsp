<%@ include file="control/header.jspf"%>
<%@ include file="control/constraint.jspf"%>
<div class="container"></div>
Welcome 
<table class="table  table-striped">
<caption><spring:message code="todo.caption" /></caption>

</h1>

</caption>
<thead>
<tr>
<th>id</th>
<th>desc</th>
<th>date</th>
<th>completed</th>

</tr>
</thead>


<tbody>
<c:forEach items="${to}" var="too">
<tr>
<td> ${too.id}</td>
<td>${too.desc}<br></td>


<td><fmt:formatDate value="${too.targetDate}" pattern="yyyy/MM/dd" /></td>

<td> ${too.isDone()}</td>
<td><a href="/deletetodo?id=${too.id }" class="btn btn-danger"> Delete  </a></td>
<td><a href="/updatetodo?id=${too.id }" class="btn btn-success"> Update </a></td>
</tr>
</c:forEach>
</tbody>
</table>
</div>

<div class="">
<a class="btn btn-success" href="/addtodo">Add</a>
</div>
<div align ="right" >

<a href="/ifanyerror" class="btn btn-danger">ErrorZone</a>

</div>
