<%@page import="com.model.CityList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $('#call').click(function ()
            {
                $.ajax({
                    type: "get",
                    url: "data", //this is my servlet
                    success: function(msg){      
                            $('#output').append(msg);
                    }
                });
            });

        });
    </script>
</head>
<body>
<p>Hello Test</p>
<button id="call"></button>
<div id="output"></div>
</body>
</html>