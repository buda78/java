<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Perfect Number Checker</title>
</head>
<body>
    <h2>Perfect Number Checker</h2>
    
    <%!
        boolean isPerfect(int num) {
            int sum = 1;
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    sum += i;
                    if (i * i != num) {
                        sum += num / i;
                    }
                }
            }
            return sum == num && num != 1;
        }
    %>
    
    <%
        String numberStr = request.getParameter("number");
        String resultMessage = "";
        if (numberStr != null && !numberStr.isEmpty()) {
            int number = Integer.parseInt(numberStr);
            if (isPerfect(number)) {
                resultMessage = number + " is a Perfect Number.";
            } else {
                resultMessage = number + " is not a Perfect Number.";
            }
        }
    %>

    <p>${resultMessage}</p>

    <form method="post">
        Enter a number: <input type="text" name="number">
        <input type="submit" value="Check">
    </form>
</body>
</html>

