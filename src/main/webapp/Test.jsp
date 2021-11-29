<%@page import="com.model.WeatherGet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
String lat = "0";
String lng = "0";

if(request.getParameter("lat")!=null && request.getParameter("lng")!=null){
	lat=request.getParameter("lat");
	lng=request.getParameter("lng");
}
WeatherGet weather = new WeatherGet(lat,lng);
%>
<%=weather.getWeatherHTML()%>