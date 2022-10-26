<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<link rel="icon"
		  href="${pageContext.request.contextPath}/resources/media/analysis.png">
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="https://cdn.tailwindcss.com"></script>

<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>

<script>
    let kafka_info = {
           "msgID" : "${requestScope.kafka_info.getMsgID()}"
    };
    
    console.log(kafka_info);
</script>
<meta charset="UTF-8">
<title>tweezer</title>
</head>
<body>


<nav class="bg-white px-2 sm:px-4 py-2.5 dark:bg-gray-900 fixed w-full z-20 top-0 left-0 border-b border-gray-200 dark:border-gray-600">
  <div class="container flex flex-wrap justify-between items-center mx-auto">
  <a href="${pageContext.request.contextPath}/" class="flex items-center">
      <img src="${pageContext.request.contextPath}/resources/media/analysis.png"class="mr-3 h-6 sm:h-9" alt="Flowbite Logo">
      <span class="self-center text-xl font-semibold whitespace-nowrap dark:text-white">Tweezer</span>
  </a>
  <div class="flex items-center md:order-2">

	 <form:form action="${pageContext.request.contextPath}/logout" 
				   				method="POST">
		<button type="submit" class="inline-block px-4 pt-2.5 pb-2 bg-blue-600 text-white font-medium text-xs leading-normal uppercase rounded shadow-md hover:bg-blue-700 hover:shadow-lg focus:bg-blue-700 focus:shadow-lg focus:outline-none focus:ring-0 active:bg-blue-800 active:shadow-lg transition duration-150 ease-in-out flex align-center">
      		<img alt="" class="w-3 mr-2" src="${pageContext.request.contextPath}/resources/media/logout.png" >
      			Logout
      	</button>
	  </form:form>
      <!-- Dropdown menu -->
      <div class="hidden  z-50 my-4 text-base list-none bg-white rounded divide-y divide-gray-100 shadow dark:bg-gray-700 dark:divide-gray-600" id="user-dropdown">
        <div class="py-3 px-4">
          <span class="block text-sm text-gray-900 dark:text-white">Bonnie Green</span>
          <span class="block text-sm font-medium text-gray-500 truncate dark:text-gray-400">name@flowbite.com</span>
        </div>
        <ul class="py-1" aria-labelledby="user-menu-button">
          <li>
            <a href="#" class="block py-2 px-4 text-sm text-gray-700 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white">Dashboard</a>
          </li>
          <li>
            <a href="#" class="block py-2 px-4 text-sm text-gray-700 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white">Settings</a>
          </li>
          <li>
            <a href="#" class="block py-2 px-4 text-sm text-gray-700 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white">Sign out</a>
          </li>
        </ul>
      </div>
      <button data-collapse-toggle="mobile-menu-2" type="button" class="inline-flex items-center p-2 ml-1 text-sm text-gray-500 rounded-lg md:hidden hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-gray-200 dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:ring-gray-600" aria-controls="mobile-menu-2" aria-expanded="false">
        <span class="sr-only">Open main menu</span>
        <svg class="w-6 h-6" aria-hidden="true" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M3 5a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 10a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 15a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1z" clip-rule="evenodd"></path></svg>
    </button>
  </div>

  </div>
</nav>





<div class="flex items-center justify-center min-h-screen bg-gray-100">
	<div>
		<h1 class="text-3xl font-bold underline">
	    	Hello world!
	  	</h1>
	  	
		
		<form:form class="flex items-center" method="POST"
						   action="${pageContext.request.contextPath}/home" 
                		   modelAttribute="home">   
			<label for="simple-search" class="sr-only">Enter keyword </label>
	    	<div class="relative w-full">
	        	<div class="flex absolute inset-y-0 left-0 items-center pl-3 pointer-events-none">
	            	<svg aria-hidden="true" class="w-5 h-5 text-gray-500 dark:text-gray-400" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M8 4a4 4 0 100 8 4 4 0 000-8zM2 8a6 6 0 1110.89 3.476l4.817 4.817a1 1 0 01-1.414 1.414l-4.816-4.816A6 6 0 012 8z" clip-rule="evenodd"></path></svg>
	        	</div>
	        	<form:input type="text" path="keyword"
	        				id="simple-search" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full pl-10 p-2.5  dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="Enter Keyword" required=""/>
	    	</div>
	    	<button  type="submit" class="p-2.5 ml-2 text-sm font-medium text-white bg-blue-700 rounded-lg border border-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800" >
	        	<img class="w-5 h-5" src="${pageContext.request.contextPath}/resources/media/analysis.png"></img>
	        	<span class="sr-only">Search</span>
	    	</button>
		</form:form>
		
		<c:if test="${home.keyword != null}">
			   <div class="text-3xl font-bold underline"> <c:out value="${home.keyword}"/> </div>
		</c:if>
		<div><canvas id="myChart" width="400" height="400"></canvas></div>
	</div>
</div>

</body>
<script src="${pageContext.request.contextPath}/resources/scripts/chartSetup.js"></script>
</html>