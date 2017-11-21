<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="page" %>

<page:template titulo="Editar usu�rio">
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h4>Edi��o de usu�rio</h4>
				<form:form action="${s:mvcUrl('UC#atualizar').build()}" method="POST">
					<input type="hidden" name="id" value="${usuario.id}" />
					<div class="form-group">
						<label for="email">E-mail:</label>
						<input type="text" id="matricula" name="email" value="${usuario.email}" class="form-control" />
					</div>
					<div class="form-group">
						<label for="nome">Nome:</label>
						<input type="text" id="nome" name="nome" value="${usuario.nome}" class="form-control" />
					</div>
					<div class="form-group">
						<label for="senha">Nova senha:</label>
						<input type="password" id="senha" name="senha" value="${usuario.senha}" class="form-control" />
					</div>
					<div class="form-group">
						<label>Permiss�es:</label>
						<select name="permissao" class="form-control">
							<c:forEach items="${permissoesDiponiveis}" var="permissao">
								<option value="${permissao}">${permissao.descricao}</option>
							</c:forEach>
						</select>
					</div>
					<button type="submit" class="btn btn-primary">Salvar</button>
				</form:form>
			</div>
		</div>
	</div>
	
</page:template>