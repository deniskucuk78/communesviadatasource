<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>communes</title>
</head>
<body>
<h2>Recherche par code postal</h2>
<form action="CommuneServlet">
Code postal <input name="cp" id="cp" size="8"> <button>Rechercher</button>
</form>

<h2>Recherche par département</h2>
<form action="RechercheCommunesParDepartementServlet">
DEPARTEMENT <input name="departement" id="cp" size="8"> <button>Rechercher</button>
</form>



</body>
</html>