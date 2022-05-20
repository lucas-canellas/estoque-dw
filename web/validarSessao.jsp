<%  if (session == null || session.getAttribute("username") == null) {  %>
        <jsp:forward page="index.jsp" />
<%  }  %>