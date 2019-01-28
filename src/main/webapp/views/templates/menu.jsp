<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="sidebar-left" class="col-xs-2 col-sm-2">
			<ul class="nav main-menu">
				<li>
					<a href="<c:url value="/" />" class="active ajax-link">
						<i class="fa fa-dashboard"></i>
						<span class="hidden-xs">Início</span>
					</a>
				</li>
				
				
				<li class="dropdown">
					<a href="#" class="dropdown-toggle">
						<i class="fa fa-bar-chart-o"></i>
						<span class="hidden-xs">Cadastros</span>
					</a>
					<ul class="dropdown-menu">
						<li><a class="ajax-link" href="<c:url value="/cliente/listar"/>">Clientes</a></li>
						<li><a class="ajax-link" href="<c:url value="/servico/listar"/>">Serviços</a></li>
						<li><a class="ajax-link" href="<c:url value="/ordem/listar"/>">Ordem de serviço</a></li>
					</ul>
				</li>
			</ul>
</div>	