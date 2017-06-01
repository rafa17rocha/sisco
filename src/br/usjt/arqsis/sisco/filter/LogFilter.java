package br.usjt.arqsis.sisco.filter;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.usjt.arqsis.sisco.model.Usuario;
import br.usjt.arqsis.sisco.util.Log;

@WebFilter("/*")
public class LogFilter implements Filter
{
	FilterConfig filterConfig = null;
	
	public void init(FilterConfig fConfig) throws ServletException
	{
		this.filterConfig = fConfig;
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
		String comando = req.getParameter("command");
		
		if(comando == null)
			comando = req.getRequestURI();
		
		Calendar timestamp = Calendar.getInstance();
		
		String textLog= "";
		
		ServletContext servletContext = filterConfig.getServletContext();
		
		String contextPath = servletContext.getRealPath(File.separator);
		
		if(logado == null)
			textLog = String.format("[%1$tA, %1$tB %1$td, %1$tY %1$tZ %1$tI:%1$tM:%1$tS:%1$tL %tp] %s\n", timestamp, comando);
		else
			textLog = String.format("[%1$tA, %1$tB %1$td, %1$tY %1$tZ %1$tI:%1$tM:%1$tS:%1$tL %tp] %s -> %s\n", timestamp, logado.getUsuario(), comando);
		
		synchronized (textLog)
		{
			Log log = new Log();
			
			String path = contextPath + File.separator + "log" + File.separator + Log.NOME;
			
			log.abrir(path);
			log.escrever(textLog);
			log.fechar();
		}
		
		chain.doFilter(request, response);
	}
}
