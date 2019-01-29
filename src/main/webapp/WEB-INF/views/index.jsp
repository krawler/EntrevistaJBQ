<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isELIgnored="false"%>

<div class="col-sm-10">
	<a href="<c:url value="/ordem/cadastro"/>" class="btn btn-default marginTop sem-margin-esquerda">Nova Ordem de serviço</a>
</div>

<div class="col-sm-5">
	<h4>Ultimas ordens de serviço adicionadas</h4>
	<div class="box-content no-padding table-responsive">
		<table
			class="table m-table table-bordered table-hover table-heading"
			id="datatable-2">
			<thead>
				<tr>
					<th>Cliente</th>
					<th>Serviço</th>
					<th>Data Final</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ordens}" var="ordem">
					<tr>
						<td>${ordem.cliente.nome}</td>
						<td>${ordem.servico.descricao}</td>
						<td><fmt:formatDate pattern="dd/MM/yyyy" value="${ordem.dataFim}" /></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
				  <td></td>	
				</tr>
			</tfoot>
		</table>
	</div>
</div>
<!-- id="ticker-table" -->