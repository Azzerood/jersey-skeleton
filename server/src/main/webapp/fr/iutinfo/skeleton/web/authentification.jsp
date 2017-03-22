
<!DOCTYPE html>
<html lang="fr">
	<head>
	<%@ page import="truc.*" %>
	<%@ page import="java.sql.*"  %>
	<%@ page import="java.io.*"  %>
	<%@ page import="java.util.*" %>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>Articles</title>

	<!-- Bootstrap core CSS -->
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	
	</head>
	<body>
	<%	
	Panier p = (Panier)session.getAttribute("p");

	if (p==null){
		p = new Panier();
	}
	if(request.getParameter("id")!=null){
		p.ajouter(request.getParameter("id"));
	}else{
		p.clear();
	}
	session.setAttribute("p",p);
	%>
	
	<%
		Connection con =null;
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://psqlserv/n3p1","lamboisa","moi");
			Statement stmt= con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from produits");
	%><center><table border=1 width=200px><%
	
		while(rs.next()){
			%><tr><td><%out.print(rs.getString("id"));%></td><td><a href=affiche.jsp?id=<%out.print(rs.getString("libelle"));%>><%out.print(rs.getString("libelle"));%></a></td><td><%out.print(rs.getString("prix"));%></td></tr><%
		}
		
	}catch(Exception e){
		
	}finally{
		con.close();
	} 
	%></table></center>
	
	<center><%out.print(p.toHtml());%></center>
	<center><%out.print(p.prixGlobal());%></center>
	
	<center><a href=affiche.jsp>Clear</a></center>
	<center><a href=./servlet/Commander>Valider</a></center>
	
	<%if(request.getParameter("valide")!=null){
		%><center><% out.print("Commande prise en compte");%></center><%
	} %>
	</body>
</html>
