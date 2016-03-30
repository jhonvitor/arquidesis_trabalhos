package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entidade.AlunoEntidade;
import model.service.AlunoService;

/**
 * Servlet implementation class ManterClienteController
 */
@WebServlet("/ManterAluno.do")
public class ManterClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pAcao = request.getParameter("acao");
		String pCodigo = request.getParameter("text_cod");
		String pNome = request.getParameter("text_nome");
		String pEmail = request.getParameter("text_email");
		String pTelRes = request.getParameter("text_telRes");
		String pTelCel = request.getParameter("text_telCel");
		String pCpf = request.getParameter("text_cpf");
		String pRg = request.getParameter("text_rg");
		String pDataNasc = request.getParameter("text_dataNasc");
		String pEndereco = request.getParameter("text_end");
		String pComplemento = request.getParameter("text_compl");
		String pNumero = request.getParameter("text_num");
		int cod = -1;
		try {
			cod = Integer.parseInt(pCodigo);
		} catch (NumberFormatException e) {

		}

		if (pAcao.equals("Inserir")) {
			try {
				String result = new AlunoService().setCadastroDeAluno(cod,
						pNome, pEndereco, pNumero, pComplemento, pDataNasc,
						pEmail, pTelRes, pTelCel, pRg, pCpf);
				
				request.setAttribute("resultIncluir", result);
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);

				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
		} else if (pAcao.equals("Alterar")) {
			try {
				String result = new AlunoService().setAlterarAluno(cod, pNome,
						pEndereco, pNumero, pComplemento, pDataNasc, pEmail,
						pTelRes, pTelCel, pRg, pCpf);
				
				request.setAttribute("resultAlterar", result);
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (pAcao.equals("Excluir")) {
			try {
				boolean result = new AlunoService().setDeletarAlunoPorCpf(pCpf);
				
				if(result){
					request.setAttribute("resultExcluir", "excluido");
					RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
					dispatcher.forward(request, response);
				}
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else if (pAcao.equals("Consultar")) {
			AlunoEntidade result = null;
			try {
				result = new AlunoService().setBuscarAlunosPorCpfSimples(pCpf);
				
				request.setAttribute("resultConsultar", result);
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
