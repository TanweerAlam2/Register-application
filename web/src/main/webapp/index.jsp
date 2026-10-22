<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.register.domain.RegistrationResult" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register Account</title>
    <style>
        body { font-family: Arial, sans-serif; background:#f4f6f8; margin:0; }
        main { max-width:460px; margin:60px auto; background:#fff; padding:32px;
                border-radius:12px; box-shadow:0 8px 24px rgba(0,0,0,.08); }
        label { display:block; margin-top:16px; font-weight:600; }
        input { width:100%; box-sizing:border-box; padding:12px; margin-top:6px;
                border:1px solid #ccd3da; border-radius:6px; }
        button { width:100%; margin-top:24px; padding:12px; border:0;
                 border-radius:6px; background:#1565c0; color:white; font-size:16px; }
        .message { margin:16px 0; padding:12px; border-radius:6px; background:#eef5ff; }
    </style>
</head>
<body>
<main>
    <h1>Create account</h1>
    <% RegistrationResult result = (RegistrationResult) request.getAttribute("result"); %>
    <% if (result != null) { %>
        <div class="message"><%= result.message() %></div>
    <% } %>
    <form method="post" action="${pageContext.request.contextPath}/register">
        <label for="fullName">Full name</label>
        <input id="fullName" name="fullName" required maxlength="150">
        <label for="email">Email</label>
        <input id="email" name="email" type="email" required maxlength="255">
        <label for="password">Password</label>
        <input id="password" name="password" type="password" required minlength="8">
        <button type="submit">Register</button>
    </form>
</main>
</body>
</html>