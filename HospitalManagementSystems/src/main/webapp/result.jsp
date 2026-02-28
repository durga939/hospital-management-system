<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Prediction Result</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
body {
    background: linear-gradient(to right, #00f2fe, #4facfe);
    height: 100vh;
}

.card {
    margin-top: 120px;
    border-radius: 20px;
}
</style>
</head>

<body>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow-lg p-5 text-center">
                <h2>🩺 Prediction Result</h2>

                <h3 class="mt-4 text-primary">
                    ${result}
                </h3>

                <a href="index.jsp" class="btn btn-success mt-4">
                    Check Again
                </a>
            </div>
        </div>
    </div>
</div>

</body>
</html>