<!DOCTYPE html>
<html lang="en" class="bg-secondary-subtle">

<head>
    <title>Bootstrap Example</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <style>
        .stretch-image {
            width: 100%;
            height: 100%;
            object-fit: fill;
        }
    </style>
</head>

<body>
<div class="container-fluid bg-secondary-subtle">
    <div class="row">
        <div class="col-md-6">
            <h1 class="text-primary text-center">Logger Application</h1>
            <hr>
            <div class="center">
                <form ACTION='Logger' method='POST' class="d-grid gap-2">
                    <input type='text' class="form-control" name='log' placeholder="New Log Message">
                    <input type='submit' class="btn btn-primary" value='Submit'>
                </form>
            </div>
            <table class="table table-secondary">
                <thead>
                <tr>
                    <th scope="col">Timestamp</th>
                    <th scope="col">Message</th>
                </tr>
                </thead>
                <tbody>
                <#list times as currentTime>
                    <tr>
                        <td>${currentTime}</td>
                        <td>${logs[currentTime_index]}</td>
                    </tr>
                </#list>
                </tbody>
            </table>
            <footer> <#include "footer.ftl"> </footer>
        </div>
        <div class="col-md-6">
            <img src="${imagePath!}" class="img-fluid stretch-image" alt="Dynamic Description">
        </div>
    </div>
</div>
</body>

</html>