<%@page import="model.entidade.AlunoEntidade"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String id = "";
	String nome = "";
	String email = "";
	String telres = "";
	String telcel = "";
	String cpf = "";
	String rg = "";
	String datanasc = "";
	String end = "";
	String comp = "";
	String num = "";

	String displayI = "none";
	String displayA = "none";
	String displayE = "none";
	String displayC = "none";
	
	String resultIncluir = (String) request
			.getAttribute("resultIncluir");
	String resultAlterar = (String) request
			.getAttribute("resultAlterar");
	String resultExcluir = (String) request
			.getAttribute("resultExcluir");
	
	AlunoEntidade resultConsultar = (AlunoEntidade) request
			.getAttribute("resultConsultar");

	if (resultIncluir != null) {
		if (resultIncluir.equals("exist")) {
			resultIncluir = "CPF ja cadastrado anteriormente no sistema";
			displayI = "block";
		} else if (resultIncluir.equals("ok")) {
			resultIncluir = "Cadastro de aluno realizado com sucesso";
			displayI = "block";
		} else {
			displayI = "block";
		}
	} else if (resultAlterar != null) {
		if (resultAlterar.equals("exist")) {
			resultAlterar = "CPF inserido nao foi detectado no sistema";
			displayA = "block";
		} else {
			resultAlterar = "Aluno alterado com sucesso";
			displayA = "block";
		}
	} else if (resultExcluir != null) {
		resultExcluir = "Cadastro excluido com sucesso";
		displayE = "block";
	
	} else if (resultConsultar != null){
		id = String.valueOf(resultConsultar.getCod());
		nome = resultConsultar.getNome();
		email = resultConsultar.getEmail();
		telres = resultConsultar.getTelRes();
		telcel = resultConsultar.getTelCel();
		cpf = resultConsultar.getCpf();
		rg = resultConsultar.getRg();
		datanasc = resultConsultar.getDataNasc();
		end = resultConsultar.getEnd();
		comp = resultConsultar.getComp();
		num = resultConsultar.getNum();
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/Estilo.css">
<title>Cadastro de Alunos</title>
</head>
<body id="body">

	<div id="interface">
		<fieldset>
			<legend>&nbsp; Cadastro de Alunos &nbsp;</legend>

			<form action="ManterAluno.do" method="post">
				<table>
					<tr>
						<td><label for="iCod">Codigo:&nbsp;</label></td>
						<td><input id="iCod" type="text" name="text_cod" readonly value="<%=id%>"></td>
					</tr>
					
					<tr>
						<td><label for="idNome">Nome:&nbsp;</label></td>
						<td><input id="idNome" type="text" name="text_nome" value="<%=nome%>" ></td>
						
						<td><label for="idEmail">Email:&nbsp;</label></td>
						<td><input id="idEmail" type="text" name="text_email" value="<%=email%>"></td>
					</tr>

					<tr>
						<td><label for="lTelRes" for="idP">Telefone Res.:&nbsp;</label></td>
						<td><input id="lTelRes" type="text" name="text_telRes" value="<%=telres%>"></td>
						
						<td><label for="lTelCel" for="idP">Telefone Cel.:&nbsp;</label></td>
						<td><input id="lTelCel" type="text" name="text_telCel" value="<%=telcel%>"></td>
					</tr>

					<tr>
						<td><label for="idCpf">CPF:&nbsp;</label></td>
						<td><input id="idCpf" type="text" name="text_cpf" required="required" value="<%=cpf%>"></td>
						
						<td><label for="idRg">RG:&nbsp;</label></td>
						<td><input id="idRg" type="text" name="text_rg" value="<%=rg%>"></td>
					</tr>

					<tr>
						<td><label for="idDataNasc">Data Nascimento:&nbsp;</label></td>
						<td><input id="idDataNasc" type="text" name="text_dataNasc" value="<%=datanasc%>">
						</td>
					</tr>

					<tr>
						<td><label for="idEnd">Endereco:&nbsp;</label></td>
						<td colspan="3"><input id="idEnd" type="text" name="text_end" value="<%=end%>"></td>
					</tr>
					
					<tr>	
						<td><label for="idComplemento">Complemento:&nbsp;</label></td>
						<td><input id="idComplemento" type="text" name="text_compl" value="<%=comp%>"></td>
						
						<td><label for="idNumero">Numero:&nbsp;</label></td>
						<td><input id="idNumero" type="text" name="text_num" value="<%=num%>"> </td>
					</tr>
				</table>
				
				<input type="submit" name="acao" value="Inserir"> 
				<input type="submit" name="acao" value="Alterar"> 
				<input type="submit" name="acao" value="Consultar"> 
				<input type="submit" name="acao" value="Excluir">
			</form>
			
			<span style="display:<%=displayI%>;"><%=resultIncluir%></span> 
			<span style="display:<%=displayA%>;"><%=resultAlterar%></span>
			<span style="display:<%=displayE%>;"><%=resultExcluir%></span>
			
		</fieldset>
	</div>
</body>
</html>