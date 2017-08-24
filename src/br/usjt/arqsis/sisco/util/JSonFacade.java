package br.usjt.arqsis.sisco.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.usjt.arqsis.sisco.model.Usuario;

public class JSonFacade
{
	public static StringBuilder montaJSon(HttpServletRequest request) throws IOException
	{
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = request.getReader();
		
		try
		{
			String line;
			while ((line = reader.readLine()) != null)
			{
				sb.append(line).append("\n");
			}
		}
		finally
		{
			reader.close();
		}
		return sb;
	}
	
	public static String listToJSon(ArrayList<Usuario> lista)
	{
		JSONArray vetor = new JSONArray();
		
		for(Usuario u : lista)
		{
			JSONObject ob = new JSONObject();
			
			try
			{
				ob.put("id",			u.getId());
				ob.put("tipo",			u.getTipo());
				ob.put("nome",			u.getNome());
				ob.put("cpf",			u.getCpf());
				ob.put("idEmpresa",		u.getIdEmpresa());
				ob.put("expediente",	u.getExpediente());
				ob.put("livreAcesso",	u.getLivreAcesso());
				ob.put("alteraAr",		u.getAlteraAr());
				ob.put("usuario",		u.getUsuario());
				ob.put("senha",			u.getSenha());
				
				vetor.put(ob);
			}
			catch(JSONException e)
			{
				e.printStackTrace();
			}
		}
		return vetor.toString();
	}
	
	public static Usuario jSonToUsuario(String json) throws IOException
	{
		try
		{
			JSONObject reg = new JSONObject(json);
			
			int id =					reg.getInt("id");
			int tipo =					reg.getInt("tipo");
			String nome =				reg.getString("nome");
			long cpf =					reg.getLong("cpf");
			int idEmpresa =				reg.getInt("idEmpresa");
			String expediente =			reg.getString("expediente");
			boolean livreAcesso =		reg.getBoolean("livreAcesso");
			boolean alteraArEmpresa =	reg.getBoolean("alteraAr");
			String usuario =			reg.getString("usuario");
			String senha =				reg.getString("senha");
			
			Usuario u = new Usuario(id, tipo, nome, cpf, idEmpresa, expediente, livreAcesso, alteraArEmpresa, usuario, senha);
			return u;
		}
		catch(JSONException e)
		{
			e.printStackTrace();
			throw new IOException(e);
		}
	}
	
	public static String usuarioToJSon(Usuario u) throws IOException
	{
		JSONObject ob = new JSONObject();
		
		try
		{
			ob.put("id",			u.getId());
			ob.put("tipo",			u.getTipo());
			ob.put("nome",			u.getNome());
			ob.put("cpf",			u.getCpf());
			ob.put("idEmpresa",		u.getIdEmpresa());
			ob.put("expediente",	u.getExpediente());
			ob.put("livreAcesso",	u.getLivreAcesso());
			ob.put("alteraAr",		u.getAlteraAr());
			ob.put("usuario",		u.getUsuario());
			ob.put("senha",			u.getSenha());
		}
		catch(JSONException e)
		{
			e.printStackTrace();
		}
		
		return ob.toString();
	}
	
	public static String errorToJSon(Exception e)
	{
		JSONObject ob = new JSONObject();
		
		try
		{
			ob.put("error", e.toString());
		}
		catch(JSONException f)
		{
			e.printStackTrace();
		}
		
		return ob.toString();
	}
}
