<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hospital Management System</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
body {
    background: linear-gradient(to right, #4facfe, #00f2fe);
    height: 100vh;
}

.card {
    margin-top: 100px;
    border-radius: 20px;
}

.btn-custom {
    background-color: #198754;
    color: white;
    border-radius: 10px;
}

.btn-custom:hover {
    background-color: #145c32;
}
</style>
</head>

<body>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow-lg p-5">
                <h2 class="text-center mb-4">🏥 Hospital Management System</h2>

                <form action="DiseasePredictionServlet" method="post">

                    <div class="mb-3">
                        <label class="form-label">Enter Symptoms</label>
                        <input type="text" name="symptoms" 
                               class="form-control"
                               placeholder="Example: fever, cough, headache"
                               required>
                    </div>

                    <div class="d-grid">
                        <button type="submit" class="btn btn-custom">
                            Predict Disease
                        </button>
                    </div>

                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>