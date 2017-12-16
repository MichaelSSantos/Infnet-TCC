<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="page" %>

<page:template titulo="Novo professor">
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
			
				<div class="page-header">
					<h3>Novo professor</h3>
				</div>
			
				<form:form action="${s:mvcUrl('PC#gravar').build()}" method="POST">
					<div class="form-group">
						<label for="matricula">Matricula:</label>
						<input type="text" id="matricula" name="matricula" class="form-control" />
					</div>
					<div class="form-group">
						<label for="nome">Nome:</label>
						<input type="text" id="nome" name="nome" class="form-control" />
					</div>
					<button type="submit" class="btn btn-primary">Salvar</button>
				</form:form>
			</div>
		</div>
	</div>

</page:template>
