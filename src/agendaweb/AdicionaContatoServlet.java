package agendaweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/adicionaContato") 
public class AdicionaContatoServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String nome = request.getParameter("nome"); 
		String endereco = request.getParameter("endereco"); 
		String email = request.getParameter("email"); 
		String dataEmTexto = request
				.getParameter("dataNascimento");
		Calendar dataHascimento = null;
		Calendar dataNascimento;
		try { 
			Date date = 
					new SimpleDateFormat("dd/MM/yyyy") 
			.parse(dataEmTexto); 
			dataNascimento = Calendar.getInstance(); 
			dataNascimento.setTime(date); 
		} catch (ParseException e) {
			out.println("Erro de conversão da data"); 
			return; 
		}
		Contato contato = new Contato(); 
		contato.setNome(nome); 
		contato.setEndereco(endereco); 
		contato.setEmail(email); 
		contato.setDataNascimento(dataNascimento);

		ContatoDao dao = new ContatoDao(); 
		dao.adiciona(contato);
		out.println("<html>"); 
		out.println("<html>"); 
		out.println("Contato " + contato.getNome() + 
				" adicionado com sucesso"); 
		out.println("</body>"); 
		out.println("</html>");

		}
		
		
	
	

}
