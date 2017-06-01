package br.usjt.arqsis.sisco.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.usjt.arqsis.sisco.model.Usuario;;

@WebFilter("/controller.do")
public class LoginFilter implements Filter
{
	public void init(FilterConfig fConfig) throws ServletException
	{
	}
	
	public void destroy()
	{
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException
	{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		Usuario logado = (Usuario) session.getAttribute("logado");
		System.out.println("LoginFiler - logado é nulo: " + (logado == null ? "sim" : "não"));
		
		String path = req.getContextPath();
		String uri = req.getRequestURI();
		String comando = req.getParameter("command");
		
		if (comando == null)
		{
			comando = "";
		}

		if (logado == null &&							// Se o usuário não estiver logado, e
				!uri.equals(path + "/Login.jsp") &&		// Se a página for diferente da de login, e
				!comando.equals("FazerLogin"))			// Se o comando for diferente de FazerLogin, então volta pra login
		{
			System.out.println("redirecionou pra Login!");
			((HttpServletResponse) response).sendRedirect(path + "/Login.jsp");
		}
		else
		{
			System.out.println("Passou pra frente!");
			chain.doFilter(request, response);
		}
	}
}
